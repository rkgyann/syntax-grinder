//package JAVA.Internshala.Exercise_Questions;

public abstract class ElectronicsDevice {

    protected String name;
    protected String brand;

    public ElectronicsDevice(String name, String brand) {

        this.name = name;
        this.brand = brand;
    }

    public abstract void powerOn();
    public abstract void powerOff();

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println();
    }
}
