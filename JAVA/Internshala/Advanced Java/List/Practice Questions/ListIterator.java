//package JAVA.Internshala.Advanced Java.List.Practice Questions;

/*Use ListIterator on ArrayList (1,4,7,2,5) to traverse forward,
 replace 4 with 40, skip 7, remove 2, print modified list backward */

import java.util.*;
public class ListIterator {
    public static void main(String[] args) {
        
        ArrayList<Integer> al=new ArrayList<>(Arrays.asList(1,4,7,2,5));

        System.out.print("Initial: ");
        for(Integer i: al){
            System.out.print(i+" ");
        }
        System.out.println();
        al.set(al.indexOf(4),40);
        al.remove(al.indexOf(2));

        System.out.print("After Modification: ");
        for(Integer i: al){
            if(al.get(al.indexOf(i))!=7)
                System.out.print(i+" ");
        }

        System.out.print("\nBackward: ");
        for(int j=al.size()-1;j>=0;j--){
            if(al.get(j)!=7)
            System.out.print(al.get(j)+" ");
        }

        //can use Collection.reverse(al) -> modifies the list permannently
        //al.reversed() -> modifies the list temprary
    }
}
