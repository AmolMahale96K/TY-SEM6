import java.io.*;
import java.util.*;
class FileThread extends Thread{    //implements Runnable
    String fname;
    // Thread t;
    FileThread(String fn){
        fname = fn;
        // t = new Thread(this);
    }
    public void run(){      //job/task
        try{
            while(true){
                File f = new File(fname);            
                if(f.exists()){
                    System.out.println(fname + "is found");
                    System.out.println("Length of "+f.getName()+" : "+f.length());
                    Thread tt = Thread.currentThread();
                    tt.stop();
                }else{
                    Thread.sleep(1000);
                    System.out.println("Searching......"+fname);
                }
            }
        }catch(Exception e){}
    }
}


class FileWatcher{
    public static void main(String args[]){
        String fname;
        Scanner sc = new Scanner(System.in);
        int i,n;
        System.out.print("Enter how many files to be searched:");
        n = sc.nextInt();

        FileThread ft[] = new FileThread[n];    //array of threads
        for(i=0;i<n;i++){
            System.out.print("Enter file name:");
            fname = sc.next();
            ft[i] = new FileThread(fname);//create thread
        }

        for(i=0;i<n;i++)
            ft[i].start();          //start thread      //ft[i].t.start();
        
    }
}