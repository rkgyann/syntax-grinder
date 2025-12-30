//package JAVA.Internshala.Advanced Java.List.ArrayList;
import java.util.ArrayList;
public class GadgetArrayList {
    
    public static void main(String[] args) {
        
        ArrayList<Gadget> ar = new ArrayList<>();

        //adding objects
        ar.add(new Gadget("SmartPhone", 25000.00));
        ar.add(new Gadget("Laptop", 55000.00));
        ar.add(new Gadget("HeadPhone", 5000.00));

        //display info
        System.out.println("\nList of Gadget: ");
        for(Gadget i: ar){
             //enhnced for-loop
             System.out.println(i);
        }
        System.out.println();
    
        //access elements by index
        //get
        Gadget gt= ar.get(0);
        System.out.println("Details of the Gadget at Index '0': "+gt);
    
        //remove
        ar.remove(0);

        System.out.print("\nAfter Removing-> ");
        System.out.println("List of Gadget: ");
        for(Gadget i: ar){
             //enhnced for-loop
             System.out.println(i);
        }
        System.out.println();

        Gadget gt1= ar.get(0);
        System.out.println("Details of the Gadget at Index '0': "+gt1);
        System.out.println();
    }
}
