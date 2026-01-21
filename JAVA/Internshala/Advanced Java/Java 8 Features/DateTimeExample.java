//package JAVA.Internshala.Advanced Java.Java 8 Features;

import java.time.LocalDate;
import java.time.LocalTime;
public class DateTimeExample {
    public static void main(String[] args) {
        
        //Current date and current time
        LocalDate currentDate= LocalDate.now();
        System.out.println("Current Date is: "+currentDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time is; "+currentTime);
    }
}
