// Collection(I) : It is a group of values. 
// Map(I) : It is a group of values with keys. (key-value pair)
// key is nothing but in the form of any object

// Unordered
// duplicate not allowed (key can't be duplicate, value can be duplicate)
// HashMap : 1 null key and many null values, Hashtable
// LinkedHashMap : LinkedList + Hashtable, Ordered
// TreeMap : 0 null key but many null values, red-black tree, Sorted(keywise)
// Hashtable : 0 null key/value, Legacy class, methods are synchronized (slow),
                // by default capacity is 11, Hashtable(single word)

// common methods for Map
// int size()
// boolean isEmpty()
// void clear()
// boolean containsKey(Object)
// boolean containsValue(Object)
// Object put(Object,Object)
// Object remove(Object)
// putAll()
// get(), set()

import java.util.*;
class MyHashMap{
    public static void main(String args[]){
        HashMap hm = new HashMap();
        System.out.println("Size:"+hm.size());
        System.out.println("isEmpty?"+hm.isEmpty());
        System.out.println(hm);

        hm.put(111,"java");
        hm.put(222,"php");
        hm.put(333,"tcs");
        System.out.println(hm);

        Object o;
        o = hm.put(333,"python"); //if duplicate key then value will get replaced
        System.out.println(hm);//replaced value will be returned
        System.out.println("replaced value : "+o);

        o = hm.put(444,"OS"); // if unique key then value will get added
        System.out.println(hm);// null will be returned
        System.out.println("Result : "+o);

        System.out.println("java?"+hm.containsValue("java"));
        System.out.println("333 key?"+hm.containsKey(333));

        o = hm.remove(444);  //keywise remove, it returns removed value
        System.out.println(hm); //if key is absent, then null will be returned
        System.out.println("Removed element : "+o);

        hm.clear();
        System.out.println(hm);

        hm.put(2.5f,true);
        hm.put(true,"hello");
        hm.put("abcd",45);
        hm.put(null,"aaaaa");
        hm.put(null,"abcd");
        hm.put(1,null);
        hm.put(2,null);
        hm.put(3,null);

        System.out.println(hm);


        HashMap hm1 = new HashMap();
        hm1.put(22,"abcd");
        hm1.put(33,"xyzw");
        hm1.put(44,"pqrs");
        hm1.put(55,"mnop");

        hm.putAll(hm1);
        System.out.println(hm);
    }
}