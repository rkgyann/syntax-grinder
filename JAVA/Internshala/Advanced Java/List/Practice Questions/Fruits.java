//package JAVA.Internshala.Advanced Java.List;
/* Initialize LinkedList of strings (“Apple”, “Banana”),
 add “Cherry” first and “Date” last, remove second element, 
 print first and last using getFirst()/getLast(). */
import java.util.*;
public class Fruits {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        LinkedList<String> sl=new LinkedList<>();
        sl.add("Apple");
        sl.add("Banana");
        System.out.print("\nInitial LinkedList is: ");
        for(String i: sl){
            System.out.print(i+" ");
        }

        sl.addFirst("Cherry");
        sl.addLast("Date");

        System.out.print("\nAfter Adding: ");
        for(String i: sl){
            System.out.print(i+" ");
        }
        sl.remove(1);
        System.out.print("\nAfter Removing: ");
        for(String i: sl){
            System.out.print(i+" ");
        }
        System.out.println("\n");
        System.out.println("Fruit at First Place: "+sl.getFirst()+" \nFruit at Last Place: "+sl.getLast()+"\n");
    }
}
