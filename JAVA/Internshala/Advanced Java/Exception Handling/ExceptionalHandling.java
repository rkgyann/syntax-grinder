//package JAVA.Internshala.Advanced Java;
import java.util.Scanner;
public class ExceptionalHandling {
    
    public static void main(String[] args) {
        
        //division by zero
        //Scanner 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Numerator");
        int n=sc.nextInt();

        System.out.println("Enter the Denominator");
        int d=sc.nextInt();

        

        try{
            int result=n/d; //run-time error for n/0
            System.err.println("Result is: "+result);
        }
        catch(Exception e)
        {
            System.out.println("Error is: "+e.getMessage());
        }
        finally{
            sc.close();
            System.out.println("Fianlly Block Executed");
        }
    }
}
