// capacity gets doubled once fulled.
// all methods are synchronized i.e. slow
// vector is a legacy class

import java.util.*;
class MyVector{
    public static void main(String artasfvd[]){
        Vector v = new Vector(); //by default capacity is 10
        System.out.println(v);
        System.out.println("Size:"+v.size());
        System.out.println("Capacity:"+v.capacity());

        v.add(111);
        System.out.println(v);
        System.out.println("Size:"+v.size());
        System.out.println("Capacity:"+v.capacity());

        v.add(222);
        v.add(333);
        v.add(222);
        v.add(222);

        System.out.println(v);
        System.out.println("Size:"+v.size());
        System.out.println("Capacity:"+v.capacity());

        v.add("hello");
        System.out.println("Size:"+v.size());
        System.out.println("Capacity:"+v.capacity());

        v.add("bye");
        v.add("bye");
        v.add("bye");
        v.add("bye");
        v.add(null);
        System.out.println(v);
        System.out.println("Size:"+v.size());
        System.out.println("Capacity:"+v.capacity());
    }
}