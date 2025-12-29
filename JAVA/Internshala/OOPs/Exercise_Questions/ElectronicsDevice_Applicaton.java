//package JAVA.Internshala.Exercise_Questions;

public class ElectronicsDevice_Applicaton {

    public static void main(String[] args) {

        ElectronicsDevice s = new SmartPhone("IPhone", "Apple");
        s.displayDetails();
        s.powerOn();
        s.powerOff();

        ElectronicsDevice r = new Laptop("MacBook", "Apple");
        r.displayDetails();
        r.powerOn();
        r.powerOff();

    }
}
