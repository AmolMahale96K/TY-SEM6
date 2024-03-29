// boolean remove() datawise
// Object remove() indexwise by default

import java.util.*;
class MyArrayList1{
    public static void main(String args[]){
        ArrayList al = new ArrayList();
        al.add(111);
        al.add(222);
        al.add(333);
        al.add(444);
        al.add(1);
        al.add(2);
        al.add(222);
        al.add("aaaa");
        al.add(222);
        al.add("bbb");

        System.out.println(al);
        al.add(3,"hello");
        System.out.println(al);

        al.remove(new Integer(333));//by default indexwise remove
        System.out.println(al);

        Object o = al.remove(1); //here 1 is index //deleted element will be returned
        System.out.println(o);
        System.out.println("After removing element at 1st index:"+al);


        System.out.println("data at 4th index:"+al.get(4));
        al.set(3,"bye");
        System.out.println(al);


        System.out.println("First occurence of 222:"+al.indexOf(222));
        System.out.println("Last occurence of 222:"+al.lastIndexOf(222));
        
    }
}