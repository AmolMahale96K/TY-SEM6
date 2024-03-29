// addFirst()
// addLast()
// removeFirst()
// removeLast()
// getFirst()
// getLast()

import java.util.*;
class MyLinkedList{
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.add(111);
        ll.add(111);
        ll.add(111);
        ll.add(111);
        System.out.println(ll);
        ll.addFirst(12);
        ll.addLast(31);
        System.out.println(ll);
        
    }
}