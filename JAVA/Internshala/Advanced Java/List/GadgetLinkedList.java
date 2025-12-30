//package JAVA.Internshala.Advanced

import java.util.LinkedList;

public class GadgetLinkedList {
    
    public static void main(String[] args) {
        
        LinkedList<Gadget> lL=new LinkedList<>();
        //add gadegts
        lL.add(new Gadget("SamrtPhone", 35000.00));
        lL.add(new Gadget("Laptop", 65000.00));
        lL.add(new Gadget("HeadPhone", 15000.00));

        //display
        System.out.println("\nList Of Gadgets are: ");
        for(Gadget i:lL){
            System.out.println(i);
        }
        System.out.println();

        //access elements
        Gadget gt= lL.get(0);
        System.out.println("Details of Gadget at Index '0': "+gt);

        //remove elements -> removeFirst
        lL.removeFirst();

        System.out.print("\nAfter removing -> ");
        System.out.println("List Of Gadgets are: ");
        for(Gadget i:lL){
            System.out.println(i);
        }
        System.out.println();

        //remove elements -> removeLast
        lL.removeLast();

        System.out.print("\nAfter removing -> ");
        System.out.println("List Of Gadgets are: ");
        for(Gadget i:lL){
            System.out.println(i);
        }
        System.out.println();
    }
}
