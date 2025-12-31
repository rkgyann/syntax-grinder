//package JAVA.Internshala.Advanced Java.List.Practice Questions;
/*Write code to create an ArrayList of 10 integers (1-10), insert 0 at index 5, replace index 3 with 99, 
then print elements from index 4 to end using a for loop.*/

import java.util.*;
public class NaturalNumber {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> n=new ArrayList<>();

        for(Integer i: n){
            System.out.println(i+", ");
        }
        System.out.println("\nInitial size: "+n.size());
        System.out.println("Enter no. of Elements: ");
        int m=sc.nextInt();

        for(int j=0;;j++){

            System.out.println("Enter the number: ");
            int a=sc.nextInt();
            n.add(a);
            if(n.size()==m)
                break;
        }
        
        for(Integer i: n){
            System.out.print(i+" ");
        }
        System.out.println("\nCurrent Size is: "+n.size());

        n.set(5,0);
        n.set(3,99);

        int index=0;
        for(Integer i: n){
            //if(index++ >=4)
            System.out.print(i+" ");
        }
    }
}
