//package JAVA.Internshala.Advanced Java.Java 8 Features;

import java.util.*;
public class StreamExample {
    public static void main(String[] args) {
        

        //list number -. sum even
        List<Integer> Numbers= Arrays.asList(10,25,34,66,79,85,44,90);

        //even numbers
        int sum_even=Numbers.stream().filter(n -> n%2==0).mapToInt(Integer :: intValue).sum();
        System.out.println("Reslt of Even numbers sum is: "+sum_even);
    }
}
