import RPi.GPIO as GPIO
import time
from adafruit_pca9685 import PCA9685
from board import SCL, SDA
import busio

# GPIO and hardware settings
TRIG = 5      # Ultrasonic TRIG
ECHO = 6      # Ultrasonic ECHO
IN1 = 17      # DC motor IN1
IN2 = 27      # DC motor IN2
BUZZER = 22   # Buzzer
LED = 23      # LED
SERVO_CHANNELS = [0, 1, 2, 3]
UPRIGHT = 90      # Upright angle
RETREAT = 30      # Retreat angle

i2c = busio.I2C(SCL, SDA)
pca = PCA9685(i2c)
pca.frequency = 50

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(TRIG, GPIO.OUT)
GPIO.setup(ECHO, GPIO.IN)
GPIO.setup(IN1, GPIO.OUT)
GPIO.setup(IN2, GPIO.OUT)
GPIO.setup(BUZZER, GPIO.OUT)
GPIO.setup(LED, GPIO.OUT)

def set_servo(channel, angle):
    # PCA9685 pulse mapping; adjust if needed for your servos
    pulse = int(150 + (angle / 180.0) * 450)
    pca.channels[channel].duty_cycle = pulse

def measure_distance():
    GPIO.output(TRIG, False)
    time.sleep(0.1)
    GPIO.output(TRIG, True)
    time.sleep(0.00001)
    GPIO.output(TRIG, False)
    timeout = time.time() + 0.1
    pulse_start, pulse_end = None, None
    while GPIO.input(ECHO) == 0 and time.time() < timeout:
        pulse_start = time.time()
    if pulse_start is None:
        return None
    while GPIO.input(ECHO) == 1 and time.time() < timeout:
        pulse_end = time.time()
    if pulse_end is None:
        return None
    pulse_duration = pulse_end - pulse_start
    distance = (pulse_duration * 34300) / 2
    return round(distance, 2)

def motor_forward():
    GPIO.output(IN1, GPIO.HIGH)
    GPIO.output(IN2, GPIO.LOW)

def motor_stop():
    GPIO.output(IN1, GPIO.LOW)
    GPIO.output(IN2, GPIO.LOW)

def buzz_led(on=True):
    GPIO.output(BUZZER, GPIO.HIGH if on else GPIO.LOW)
    GPIO.output(LED, GPIO.HIGH if on else GPIO.LOW)

try:
    # Lock all servos upright at start
    set_servo(0, UPRIGHT)
    set_servo(1, UPRIGHT)
    set_servo(2, UPRIGHT)
    set_servo(3, UPRIGHT)
    motor_stop()
    buzz_led(False)

    print("System armed. Patrol mode. Ctrl+C to stop.")
    prev_dist = measure_distance()
    prev_time = time.time()

    while True:
        # Always keep servo 1 & 2 locked upright (every loop, in case of servo drift)
        set_servo(1, UPRIGHT)
        set_servo(2, UPRIGHT)
        # Keep servo 0 & 3 upright during patrol
        set_servo(0, UPRIGHT)
        set_servo(3, UPRIGHT)

        curr_dist = measure_distance()
        curr_time = time.time()
        # Calculate speed; only when distance is valid and changes
        speed = 0
        if curr_dist is not None and prev_dist is not None:
            delta_d = prev_dist - curr_dist
            delta_t = curr_time - prev_time
            speed = delta_d / delta_t if delta_t > 0 else 0

            print(f"Distance: {curr_dist} cm | Speed: {abs(speed):.2f} cm/s")

            # ESCAPE SEQUENCE if object is within 2 cm
            if curr_dist <= 2:
                buzz_led(True)
                print("Object very close! Escape initiated.")

                start_dist = curr_dist

                # Move forward, keep measuring moved distance
                motor_forward()
                moved = 0
                while moved < 17:
                    new_dist = measure_distance()
                    time.sleep(0.05)
                    if new_dist is not None:
                        moved = start_dist - new_dist  # Forward means distance decreases
                        # Lock front servos in upright throughout
                        set_servo(1, UPRIGHT)
                        set_servo(2, UPRIGHT)
                motor_stop()
                buzz_led(False)
                print("Robot escaped 17 cm forward.")

                # Now, move back servos (0 & 3) to RETREAT for 2 seconds, then return upright
                set_servo(0, RETREAT)
                set_servo(3, RETREAT)
                set_servo(1, UPRIGHT)
                set_servo(2, UPRIGHT)
                time.sleep(2)
                set_servo(0, UPRIGHT)
                set_servo(3, UPRIGHT)

        else:
            print("Ultrasonic sensor: No echo detected.")
        prev_dist = curr_dist
        prev_time = curr_time
        time.sleep(0.2)

except KeyboardInterrupt:
    print("\nStopped by user.")

finally:
    motor_stop()
    buzz_led(False)
    # Lock all servos upright
    for ch in SERVO_CHANNELS:
        set_servo(ch, UPRIGHT)
    pca.deinit()
    GPIO.cleanup()
