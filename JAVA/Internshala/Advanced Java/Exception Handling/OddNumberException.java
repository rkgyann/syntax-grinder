import java.util.Scanner;
public class OddNumberException {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("Enter the number: ");
            int n=sc.nextInt();
            //validate
            validateNumber(n);
            System.out.println("\nNumber is valid.\nNumber is Even Number.\n");
        }
        catch(OddNumberCustomException e){
            System.out.println("\nExceptio Caught: "+e.getMessage());
        }
    }
    public static void validateNumber(int n) throws OddNumberCustomException{
        if(n%2!=0){
            throw new OddNumberCustomException("\nNumber is invalid.\nNumber must be Even Number.\n");
        }
    }
}
