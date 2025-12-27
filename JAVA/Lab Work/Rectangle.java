
    /* Write a program to create a class Rectangle with the following information: length, breadth in integer. 
Add two constructors, (a) default constructor, and (b) constructor to pass on length and breadth of a Rectangle.
Add a method printData( ) to print the two information about the rectangle in console.
Add methods printArea( ) and printPerimeter( ) to compute and print the area and perimeter of rectangle in console.
*/
import java.util.Scanner;
public class Rectangle
{
    private int L;
    private int B;

    public Rectangle()
    {
        L = 0;
        B = 0;
    }

    public Rectangle(int l, int b)
    {
        L = l;
        B = b;
    }

    public void printData()
    {
        System.out.println("Length is: " + L + " Breadth is: " + B);
    }

    public void printArea()
    {
        int a = L * B;
        System.out.println("Area is: " + a);
    }

    public void printPerimeter()
    {
        int p = 2 * (L + B);
        System.out.println("Perimeter is: " + p);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Rectangle r1 = new Rectangle();
        r1.printData();
        r1.printArea();
        r1.printPerimeter();

        System.out.println("Enter the Length:");
        int l = sc.nextInt();
        System.out.println("Enter the Breadth:");
        int b = sc.nextInt();

        Rectangle r2 = new Rectangle(l, b);
        r2.printData();
        r2.printArea();
        r2.printPerimeter();

        sc.close();
    }
}
