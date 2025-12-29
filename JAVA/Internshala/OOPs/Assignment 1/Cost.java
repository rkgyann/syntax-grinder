
/*
 Assignment 1:
Create a Java program that calculates and displays the cost of purchasing a specified number of items, each priced at a
certain amount, with a given tax rate and discount. The program should perform calculations using various operators in
Java, without using objects and classes and without user input. The program should display the total cost, including tax
and discount.
Your program should perform the following tasks:


1. Define the following variables with predefined values:
itemPrice: the price of each item (e.g., $10.00).
numberOfItems: the number of items to be purchased (e.g., 5).
taxRate: the tax rate as a percentage (e.g., 8%).
discountPercentage: the discount rate as a percentage (e.g., 10%).

2. Calculate the following:
subtotal: the total cost before tax and discount.
taxAmount: the amount of tax based on the tax rate.
discountAmount: the amount of discount based on the discount rate.
totalCost: the final total cost, including tax and discount.
Display the calculated subtotal, taxAmount, discountAmount, and totalCost in the output.
*/
import java.util.Scanner;

public class Cost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double itemPrice = 10.00;
        int numberOfItems = 5;
        double taxRate = 8.0;
        double discountPercentage = 10.0;

        double subtotal = itemPrice * numberOfItems;
        double discountAmount = subtotal * discountPercentage / 100.0;
        double taxAmount = (subtotal - discountAmount) * taxRate / 100.0;
        double totalCost = subtotal + taxAmount - discountAmount;

        System.out.println("Total: $" + subtotal + "\nDiscount: $" + discountAmount + "\nTax Amount: $" + taxAmount
                + "\nGrand Total: $" + totalCost);
    }
}