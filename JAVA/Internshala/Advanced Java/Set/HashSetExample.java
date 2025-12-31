//package JAVA.Internshala.Advanced Java.Set;
import java.util.*;
public class HashSetExample {
    
    public static void main(String[] args) {
        
        HashSet<String> cars= new HashSet<String>();
        
        //add
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Ford");
        cars.add("BMW");

        System.out.println();
        //display
        for(String i: cars){
            System.out.print(i+" ");
        }
        System.out.println("\n");

        //BMW ->2, but once only, unique
        //unordered collection -> no order of elements

        //particular element -> contains
        System.out.println(cars.contains("FordNew")+"\n");

        //remove
        cars.remove("Ford");
        System.out.println(cars);
    }
}
