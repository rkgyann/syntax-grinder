//package JAVA.Internshala.Advanced Java.Java 8 Features;

import java.util.*;
public class LembdaExample {
    
    public static void main(String[] args) {

        MathOperation add= (a,b) -> a+b; //(a,b) -> a+b is called lamda function

        int result= add.operate(5,8);
        System.out.println("Result is: "+result);
    }
    
}
