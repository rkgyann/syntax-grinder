//package JAVA.Internshala.Advanced Java.Map;

import java.util.*;
public class Treemapxample {
    public static void main(String[] args) {
        
         //key,value -> Students-> name,marks
        Map<String,Integer> StudentsScore= new TreeMap<>();

        //add key value pairs
        StudentsScore.put("Student1", 90);
        StudentsScore.put("Student2", 84);
        StudentsScore.put("Student3", 89);
        StudentsScore.put("Student4", 95);

        System.out.println("\nStudents Score: ");
        for(Map.Entry<String,Integer> entry: StudentsScore.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        //particular element access
        System.out.println("Marks of Student3: "+StudentsScore.get("Student3")+"\n");
        
        //check if some key exists or not
        if(StudentsScore.containsKey("Student5"))
            System.out.println("Marks of Student5: "+StudentsScore.get("Student5")+"\n");
        else
            System.out.println("Student5 not found.\n");

        //remove
        StudentsScore.remove("Student1");
        System.out.println(StudentsScore+"\n");
    }
}
