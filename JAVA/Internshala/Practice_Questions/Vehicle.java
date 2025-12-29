public class Vehicle {
    //base class

    void start(){
        System.out.println("Vehicle Starting.......");
    }
}

//subclass1
class Car extends Vehicle{

    void drive(){
        System.out.println("Car is being driven.......");
    }
}

//subclass2
class Bike extends Vehicle{

    void ride(){
        System.out.println("Bike is being ridden......");
    }
}