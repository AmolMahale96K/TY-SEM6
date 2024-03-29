import java.util.*;
import java.io.*;
class SearchThread extends Thread{
    String fname;
    String str;
    SearchThread(String fn,String st){
        fname = fn;
        str = st;
    }
    public void run(){      //job/task
        try{
            BufferedReader br = new BufferedReader(new FileReader(fname));   
            int i=0;
            String line;

            while((line = br.readLine())!=null){
                Thread.sleep(1000);
                i++;
                if(line.contains(str))
                    System.out.println(fname+" : "+i + " : " + line);
            }
        }catch(Exception ioe){}
    }
}



class FileSearch{
    public static void main(String args[]){
        String fnames[];
        String str;
        int n;
        int i;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to be searched in current directory:");
        str = sc.next();

        File f = new File(".");         //open current directory
        fnames = f.list();
        n = fnames.length;
        SearchThread st[] = new SearchThread[n];
        for(i=0;i<n;i++){
            st[i] = new SearchThread(fnames[i],str);
        }

        for(i=0;i<n;i++){
            st[i].start();
        }        
    }
}