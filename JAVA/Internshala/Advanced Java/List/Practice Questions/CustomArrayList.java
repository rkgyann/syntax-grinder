//package JAVA.Internshala.Advanced Java.List.Practice Questions;
/* Implement custom  removeAll(ArrayList, List)  method without using built-in method - traverse with index 
and shift elements manually. */

import java.util.*;
public class CustomArrayList {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(6,3,0,1,5,9,2,4,7));
        ArrayList<Integer> toRemove= new ArrayList<>(Arrays.asList(0,4));

        System.out.println("\nOrigional ArrayList: "+list);
        ArrayList<Integer> result= customArrayList(list,toRemove);
        System.out.println("After Modification: "+result);
        System.out.println("Reversed ArrayList: "+result.reversed());//temporary reverse
        System.out.println("Retrieved Arraylist: "+result+"\n");
    }

    public static ArrayList<Integer> customArrayList(ArrayList<Integer> list, ArrayList<Integer> remove){

        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int custom=list.get(i),n=0;

            for(int j=0;j<remove.size();j++){
                if(custom==remove.get(j)){
                    n=1;
                    break;
                }
            }
            if(n==0)
            result.add(custom);
        }
        return result;
    }
}
