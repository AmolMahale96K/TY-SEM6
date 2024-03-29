// keywise sorted
import java.util.*;
class MyTreeMap{
    public static void main(String args[]){
        // TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        // tm.put(111,"java");
        // tm.put(45,"python");
        // tm.put(222,"tcs");
        // tm.put(333,"OS");
        // tm.put(444,null);
        // tm.put(555,null);
        // // tm.put(null,"CN"); // NullPointerException
        // System.out.println(tm);

        Hashtable ht = new Hashtable();
        ht.put(111,"java");
        ht.put(2.5,true);
        ht.put(false,3.5f);
        // ht.put(null,3.5f); // NullPointerException
        // ht.put(34,null); // NullPointerException
        System.out.println(ht);

        // Set k = ht.keySet();  //returns a set of keys
        // System.out.println(k);

        // Collection c = ht.values(); //returns a colleciton of values
        // System.out.println(c);

        // Set s = ht.entrySet();  //returns a set of entries
        // System.out.println(s);

        // System.out.println(ht.get(111));

        Set keys = ht.keySet();
        Iterator itr = keys.iterator();        
        while(itr.hasNext()){
            Object o = (Object)itr.next();
            System.out.println(o+" : "+ht.get(o));            
        }
    }
}