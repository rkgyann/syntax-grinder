//package JAVA.Internshala.Advanced Java.Set;

import java.util.*;
public class TreeSetExample {
    
    public static void main(String[] args) {
        
        TreeSet<String> cars= new TreeSet<String>();
        //sorted order-> alphabet, numbers-> ascending order

        //add elements
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Ford");
        cars.add("Alto");

        //display
        System.out.println("\n"+cars);

        //remove
        cars.remove("Ford");
        System.out.println(cars);
        //always displayed in sorted order even after certain operations done..
        

    }
}
