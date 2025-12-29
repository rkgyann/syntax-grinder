/*
Assignment 2:
Create a Java program that simulates a simple dice game without using objects and classes and without user input. 
The program should allow two players to take turns rolling a standard six-sided die (with numbers 1 to 6). 
Each player rolls the die once per turn, and the program keeps track of the total score for each player. 
The game should continue until one of the players accumulates a predefined winning score.

Your program should perform the following tasks:
1.	Define a predefined winning score (e.g.50 points).
2.	Simulate a two-player dice game where each player takes turns rolling a six-sided die.
3.	Update and display the total score for each player after each turn.
4.	Continue the game until one of the players reaches or exceeds the winning score.
5.	Display the winner and their final scores.

*/
//package JAVA.Assignments From Internshala.Assignment 1;
import java.util.*;
public class Dice_Game 
{
    public static void main(String[] args) 
    {
        int ws=50;//winning score
        int i,p1=0,p2=0;
        for(i=1;;i++)
        {
            if(i%2!=0)
                p1=p1+(int)(Math.random()*(6-1+1)+1);
            else
                p2=p2+(int)(Math.random()*(6-1+1)+1);
            if(p1>50 || p2>50)
                break;
        }
        if(p1>50)
            System.out.printf("Player 1 wins with %d scores \n",p1);
        else
            System.out.printf("Player 2 wins with %d scores \n",p2);
    }   
}
