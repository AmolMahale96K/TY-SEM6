// collection : a group of object
// Collection : (interface)supermost interface in collection hierarchy
// Collections : (class) a special class having many utility methods
// collection : a group of object


// Three main collections : Set, List and Queue
// Collection, Set, List and Queue are interfaces


// common methods for entire collection
// int size()
// boolean isEmpty()
// void clear()
// boolean contains(Object)
// boolean add(Object)
// boolean remove(Object)
// addAll()
// removeAll()
// retainAll()


// List : index, Ordered by insertion, duplicate allowed, many null allowed
// Object get(int)
// Object set(int,Object)
// void add(int,Object)
// Object remove(int)
// int indexOf(Object)
// int lastIndexOf(Object)


// ArrayList : background implementation is resizable array
// Vector : capacity(), background implementation is dynamic array
            // all methods are synchronized
            // legacy class
            // its capacity gets doubled once gets fulled

// LinkedList : addFirst(),addLast(),removeFirst(),removeLast(),getFirst(),getLast()
            //   : background implementation : Doubly linkedlist

// Wrapper class : Byte, Short, Integer, Long, Float, Double, Boolean
// String

// Autoboxing : primitives to non-primitives
// int --> Integer
// float --> Float

import java.util.*;
class MyArrayList{
    public static void main(String args[]){
        ArrayList al = new ArrayList();
        al.add(111);
        al.add(new Float(2.5f));
        al.add(true);
        al.add(34.7);
        al.add("hello");
        al.add(111);  // return type : boolean
        al.add(null);
        System.out.println(al);

        al.add(3,"java"); //return type : void
        System.out.println(al);

        al.remove("hello"); //return type : boolean
        System.out.println(al);

        al.remove(4); // return type : Object
        System.out.println(al);

        // al.remove(111); //by default int parameter is considered as index
        al.remove(new Integer(111)); 

        System.out.println(al);

    }
}