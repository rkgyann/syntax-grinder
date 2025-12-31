//package JAVA.Internshala.Advanced Java.List.Practice Questions;
/* Create ArrayList from array {5,3,8,1}, sort ascending with Collections.sort(), find index of 8, check if 10 exists. */

import java.util.*;
public class BasicSort {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> al=new ArrayList<>();

        int [] arr= {5,3,8,1};
        int n=arr.length;

        int j;
        for(j=0;j<n;j++){
            al.add(arr[j]);
        }

        System.out.print("\nInitial: ");
        for(Integer i: al){
            System.out.print(i+" ");
        }

        System.out.print("\nAfte Sorting: ");
        Collections.sort(al);
        for(Integer i: al){
            System.out.print(i+" ");
        }

        System.out.print("\nFound '8' at: "+al.indexOf(8));
        boolean d=al.contains(10);
        System.out.println("\nFound '10'? ->"+d);
            
    }
}