//package JAVA.Internshala.Advanced Java;

public class CheckedExample {
    public static void main(String[] args) {
        
        //compile time exception -> as compiler takes care of it.

        try{ 
            Class temp= Class.forName("class2");
        }
        catch(ClassNotFoundException e){
            System.out.println("Class doesn't exist. Check the name of the class.: "+e.getMessage());
        }
    }
}
