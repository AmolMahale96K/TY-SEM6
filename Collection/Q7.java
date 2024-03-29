import java.util.*;
import java.util.Map.*; //Map package for Entry class

class Q7{
    public static void main(String args[]){
        Hashtable ht = new Hashtable();
        Scanner sc = new Scanner(System.in);
        int n,i;
        int m;
        String name;
        System.out.print("Enter how many students:");
        n = sc.nextInt();

        while(true){
            System.out.print("Enter mobile number:");
            m = sc.nextInt();
            System.out.print("Enter name:");
            name = sc.next();
            if(ht.containsKey(m))
                System.out.println("Entry already exist");
            else{
                ht.put(m,name);
                n--;
            }
            if(n==0)
                break;
        }

        // System.out.println(ht);

        Set keys = ht.keySet();
        Iterator cursor = keys.iterator();
        System.out.println("Mobile\t\t|\t\tName");
        System.out.println("---------------------------------");        
        while(cursor.hasNext()){
            Object k = (Object)cursor.next();
            Object v = ht.get(k);
            System.out.println(k+"\t\t|\t\t"+v);
        }
        System.out.println("---------------------------------");       


        int t;
        System.out.println("Enter mobile number to be searched:");
        t = sc.nextInt();
        if(ht.containsKey(t))
            System.out.println("Name : "+ht.get(t));    //keywise retrieval
        else
            System.out.println("Mobile number is not in the table");


        System.out.println("Enter name to be searched:");
        name = sc.next();


        Set s = ht.entrySet();
        Iterator itr = s.iterator();
        while(itr.hasNext()){
            Entry e = (Entry)itr.next();
            // System.out.println("Key : "+e.getKey());
            // System.out.println("Value : "+e.getValue());
            if((e.getValue()).equals(name)){
                System.out.println("Mobile : "+e.getKey()); //valuewise key retrieval
                break;
            }
        }        
    }
}