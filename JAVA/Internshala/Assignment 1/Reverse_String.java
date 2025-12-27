/*
Assignment 3:
You are given a sentence as a string in Java. 
Your task is to reverse the order of the words in the sentence while preserving the order of the characters within each word.
For example, if the input sentence is: "Hello World Java"
Your program should produce the output: "Java World Hello"
Write a Java program that takes an input sentence, performs the word reversal, and prints the modified sentence.
*/
import java.util.*;
public class Reverse_String 
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner (System.in);
        System.out.print("Enter the sentence: ");
        String s=sc.nextLine();
        String[] words=s.trim().split("\\s+");
        int n= words.length;
        String[] word= new String[n];
        int d=n;
        for(int i=0;i<n;i++)
        {
            word[--d]=words[i];
        }
        s=String.join(" ",word);
        System.out.println(s);
        System.out.println(n);
   }   
}
