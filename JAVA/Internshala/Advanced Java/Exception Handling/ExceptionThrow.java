public class ExceptionThrow {
    public static void main(String[] args) {
        
        //age as an input -> invalid ae, invalid input
        //throw keyword

        try{
            int age= -5;
            validateAge(age);
            System.out.println("Age is Valide.");
        }
        catch(IllegalArgumentException e){
            System.out.println("Error is: "+e.getMessage());
        }
    }

    //Function -> validates the age
    public static void validateAge(int age){
        if(age<0){
            //throw -> custom
            throw new IllegalArgumentException("Age cannot be negative.");
        }

        //rest code

    }
}
