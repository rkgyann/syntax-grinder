import java.util.*;
public class LembdaExample {
    
    MathOperation add= (a,b) -> a+b; //(a,b) -> a+b is called lamda function

    int result= add.operate(5,8);
    System.out.println("Result is: "+result);
}
