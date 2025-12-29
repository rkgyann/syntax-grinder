public class Calculator {
    
    public static int result;

    public static void addd(int a,int b){
       result=a+b;
    }

    public int add(int a, int b){
        return (a+b);
    }
    public float add(float a, float b){
        return (a+b);
    }
    public String add(String a, String b){
        return a+b;
    }

    public static void subtract(int a,int b){
        result=a-b;
    }

    public static int getResult(){
        return result;
    }
}
