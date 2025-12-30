public class CustomException {
    
    public static void main(String[] args) {
        
        try{
            int age=12;
            //validate age
            validateAge(age);
            System.out.println("\nAge is valid. \nYou can access the website.\n");
        }
        catch(AgeTooYoungException e){
            System.out.println("\nException Caught: "+e.getMessage()+"\n");
        }

    }
    public static void validateAge(int age) throws AgeTooYoungException{

        //age<= 15 -> throw
        if(age<=15){
            throw new AgeTooYoungException("Age is too less. \nMust be greater than 15 to access the webiste");
        }
    }
}
