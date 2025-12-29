/*
Assignment 4:
You are tasked with writing a Java program to analyze daily temperature data for a week. 

The program should take the following input:
The number of days in the week (e.g., 7 for a full week).
The daily high temperatures for each day.

Your program should calculate and display the following information:
The average daily temperature.
The highest daily temperature.
The lowest daily temperature.
The number of days with temperatures above 80 degrees Fahrenheit.
The number of days with temperatures below 60 degrees Fahrenheit.
Write a Java program that accomplishes this task.
 */
import java.util.*;
public class Temparature 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of days: ");
        int d=sc.nextInt();
        int[] h= new int[d];
        int[] l= new int[d];
        double[] a= new double[d];
        int i, ht=0, lt=0, n6=0, n8=0;
        System.out.print("Enter daily highest temparature: ");
        for(i=0;i<d;i++)
            h[i]=sc.nextInt();
        System.out.print("Enter daily lowest temparature: ");
        for(i=0;i<d;i++)
            l[i]=sc.nextInt();
        ht=h[0]; lt=l[0];
        for(i=0;i<d;i++)
        {
            a[i]=(h[i]+l[i]/2.0);
            if(h[i]>ht)
                ht=h[i];
            if(l[i]<lt)
                lt=l[i];
            if(h[i]>60)
                n6++;
            if(h[i]>80)
                n8++;
        }
        for(i=0;i<d;i++)
            System.out.printf("Highest is: %d and Lowest is: %d Temprature of Day %d \nAverage Temprature is: %f \n",h[i],l[i],i,a[i]);
        System.out.println("No. of Dyas with Temp. >80 Degrees Fahrenheit: "+n8);
        System.out.println("No. of Dyas with Temp. >60 Degrees Fahrenheit: "+n6);
    }
}