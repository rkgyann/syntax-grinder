public class Person {
    
    //attributes
    String name;
    int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void printDetails(){
        System.out.println("Student Name: "+name+"\nAge: "+age);
    }
}
