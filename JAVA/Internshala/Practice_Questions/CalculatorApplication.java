public class CalculatorApplication {
    
    public static void main(String[] args) {
        
        System.out.println();
        Calculator a=new Calculator();
        a.addd(5, 3);
        System.out.println("Result of Addition is: "+a.getResult());

        Calculator s=new Calculator();
        s.subtract(10, 4);
        System.out.println("Result of Subtraction is: "+s.getResult());
    
        Calculator cal1=new Calculator();
        int resultInt= cal1.add(56,78);
        System.out.println(resultInt);

        float resutFloat=cal1.add(67.89f, 56.43f);
        System.out.println(resutFloat);

        String resultString=cal1.add("Hello", " World!");
        System.out.println(resultString);
    }
}
