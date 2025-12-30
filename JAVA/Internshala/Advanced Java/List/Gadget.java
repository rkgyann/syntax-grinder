//package JAVA.Internshala.Advanced Java.List.ArrayList;

public class Gadget {
    
    private String name;
    private double price;

    public Gadget(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    //toString ->it converts objects to string, and displays info in string formate
    @Override
    public String toString(){
        return name+" is of Rs."+price;
    }
}
