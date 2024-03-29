// Collections : A class having many utility methods
import java.util.*;
class MyCollections{
    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(111);
        al.add(22);
        al.add(333);
        al.add(44);
        System.out.println(al);

        Collections.shuffle(al);
        System.out.println(al);

        Collections.reverse(al);
        System.out.println(al);

        Object o;
        o = Collections.max(al);
        System.out.println("Maximum : "+o);
 
        o = Collections.min(al);
        System.out.println("Minimum : "+o);

        Collections.sort(al);
        System.out.println(al);

        int a = Collections.binarySearch(al,111); // if not found then returns negative number
        System.out.println("111 found? "+a);
    }
}