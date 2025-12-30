import java.util.Scanner;
public class StringVowel {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("\nEnter the Sentence: ");
            String s=sc.nextLine();
            //validate
            validateString(s);
            System.out.println("\nThe String contains Vowel.\n");
        }
        catch(StringVowelException e){
            System.out.println("\nException Caught: "+e.getMessage());
        }
    }
    public static void validateString(String s) throws StringVowelException{
        int i,n=s.length(),a=0;
        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                a++;
        }
        if(a==0)
            throw new StringVowelException("\nThe Input String does not contain Vowels.\n");      
   }
}
