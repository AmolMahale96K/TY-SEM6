import java.util.*;
class Q1{
    public static void main(String args[]){
        ArrayList<String> city = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int n;        
        System.out.println("Enter how many cities:");
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter city name:");            
            city.add(sc.next());    
        }

        System.out.println(city);
        Collections.sort(city);
        System.out.println("All cities in sorted order:");
        System.out.println(city);
        city.clear();
        System.out.println("After removing all cities:");        
        System.out.println(city);
    }
}