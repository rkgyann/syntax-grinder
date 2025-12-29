public class Student {

    //total-> Shared information->static members
    //static variables
    private static int totalStudents=0;
    
    //instance
    private String name;
    private int age;

    //constructor
    public Student(String name, int age)
    {
        this.name=name;
        this.age=age;
        totalStudents++;
    }

    //method
    public void dispalyStudentDetail(){
        System.out.println("Student Name: "+name+"\nAge: "+age);
    }

    //static method
    public static void showStudents(){
        System.out.println("Total No. of Students: "+totalStudents);
    }

    //static ->belong to class not object
}
