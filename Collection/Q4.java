import java.util.*;
class Q4{
    public static void main(String args[]){
        LinkedList colors = new LinkedList();
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("orange");

        // System.out.println(colors);
        System.out.println("All colors in forward direction");
        Iterator cursor = colors.iterator();
        while(cursor.hasNext())
            System.out.println(cursor.next());

        System.out.println("All colors in reverse direction");
        ListIterator rcursor = colors.listIterator(colors.size());
        while(rcursor.hasPrevious())
            System.out.println(rcursor.previous());

        LinkedList colors1 = new LinkedList();
        colors1.add("pink");
        colors1.add("green");

        int loc = colors.indexOf("yellow");
        colors.addAll(loc,colors1);

        System.out.println("Updated Linkedlist");
        System.out.println(colors);


        colors.addFirst("black");
        colors.removeLast();
        System.out.println("Updated Linkedlist");
        System.out.println(colors);
        System.out.println("Number of colors : "+colors.size());
    }
}