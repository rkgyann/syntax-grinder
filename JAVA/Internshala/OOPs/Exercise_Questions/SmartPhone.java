//package JAVA.Internshala.Exercise_Questions;

public class SmartPhone extends ElectronicsDevice {

    public SmartPhone(String name, String brand) {
        super(name, brand);
    }

    @Override
    public void powerOn() {
        System.out.println("SmartPhone is Powering On.");
    }

    @Override
    public void powerOff() {
        System.out.println("SmartPhone is Powering Off.");
    }
}
