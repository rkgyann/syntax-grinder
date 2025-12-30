//package JAVA.Internshala.Advanced Java;

public class MultipleException {
    public static void main(String[] args) {
        
        try{
            int[] num={10,20,30};
            int r=num[2]/0;
            System.out.println("Result is: "+r);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nError is: "+e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("\nError is: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("\nError is: "+e.getMessage());
        }
        finally{
            System.out.println("Fianlly Block Executed");
        }
    }
}
