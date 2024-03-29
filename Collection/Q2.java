import java.util.*;
class Q2{
    public static void main(String afds[]){
        ArrayList al = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int i,n,t,cnt=0;
        System.out.print("Enter how many integers:");
        n = sc.nextInt();
        
        while(cnt<n){
            System.out.print("Enter unique integer:");            
            t = sc.nextInt();
            if(al.contains(t))  
                System.out.println(t+" is already added");
            else{
                al.add(t);
                cnt++;
            }
        }
        
        Collections.sort(al);
        System.out.println("Sorted integers");
        System.out.println(al);

        System.out.print("Enter number to be searched:");
        t = sc.nextInt();
        int ans = Collections.binarySearch(al,t);
        if(ans<0)
            System.out.println(t+" not found");
        else
            System.out.println(t+" found at "+ans+" location");

    }
}