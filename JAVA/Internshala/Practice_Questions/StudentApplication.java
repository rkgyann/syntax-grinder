public class StudentApplication {
    
    public static void main(String[] args) {
        //TODO Auto-generated methd stub

        Student s1=new Student("John", 20);
        Student s2=new Student("Alice", 21);

        s1.dispalyStudentDetail();

        System.out.println();
        s2.dispalyStudentDetail();   
        
        System.out.println();
        Student.showStudents();
    }
}
