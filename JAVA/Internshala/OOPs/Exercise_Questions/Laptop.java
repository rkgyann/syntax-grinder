//package JAVA.Internshala.Exercise_Questions;

public class Laptop extends ElectronicsDevice {

    public Laptop(String name, String brand) {
        super(name, brand);
    }

    @Override
    public void powerOn() {
        System.out.println("Laptop is Powering On.");
    }

    @Override
    public void powerOff() {
        System.out.println("Laptop is Powering Off.");
    }
}