// collection is a group of objects
// List, Set and Queue
// List have ArrayList, Vector and LinkedList
// util package

// common methods for entire collection 
// boolean add()
// boolean remove()
// int size()
// boolean isEmpty()
// boolean contains(object)
// void clear()

// special methods of List
// List have index
// void add() overloaded method
// Object remove()  overloaded method
// get()
// set()
// indexOf()
// lastIndexOf()


// duplicate allowed in List
// null allowed in List
// ordered by insertion

import java.util.*;
class MyArrayList{
    public static void main(String args[]){        
        ArrayList al = new ArrayList();
        System.out.println(al);
        System.out.println("Size:"+al.size());
        System.out.println("Empty?"+al.isEmpty());

        al.add(111); //new Integer(111); autobxing
        al.add(222);
        al.add(2.5f);
        al.add("hello");
        al.add(111);
        al.add(null);

        System.out.println(al);
        System.out.println("Size:"+al.size());
        System.out.println("Empty?"+al.isEmpty());

        boolean ans;
        ans = al.add(222);
        System.out.println("Successful insertion?"+ans);
        System.out.println(al); //toString()

        ans = al.contains("hello");
        System.out.println("arraylist contains hello?"+ans);


        System.out.println(al);
        System.out.println("Size:"+al.size());       

        ans = al.remove("bye");
     
        System.out.println("After deletion: "+al);
        System.out.println("Successful deletion?"+ans);
        System.out.println("Size:"+al.size());



        // System.out.println(al);
        // al.clear();
        // System.out.println(al);

    }
}