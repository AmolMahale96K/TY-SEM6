import java.util.*;
class ReadThread extends Thread{
    A ob;
    ReadThread(A o){
        ob = o;
    }
    public void run(){
        try{
        ob.accept();
        }catch(InterruptedException ie){}
    }
}

class WriteThread extends Thread{
    A ob;
    WriteThread(A o){
        ob = o;
    }
    public void run(){
        try{
        ob.display();            
        }catch(InterruptedException ie){}
    }
}

class AddThread extends Thread{
    A ob;
    AddThread(A o){
        ob = o;
    }
    public void run(){
        try{
        ob.calculate();
        }catch(InterruptedException ie){}
    }
}

class A{
    int a;
    int b;
    public synchronized void accept() throws InterruptedException{
        Random r = new Random();
        a = r.nextInt(100);
        b = r.nextInt(100);
        notifyAll();
        System.out.println(Thread.currentThread()+" generated numbers, now you can write/calculate");
    }
    public synchronized void display() throws InterruptedException{
        System.out.println(Thread.currentThread()+" is waiting for readThread");
        wait();
        System.out.println("First number:"+a);
        System.out.println("Second number:"+b);
    }
    public synchronized void calculate() throws InterruptedException{
        int c;
        System.out.println(Thread.currentThread()+" is waiting for readThread");
        wait();
        c = a+b;
        System.out.println("Total : "+c);
    }
}

class interthread{
    public static void main(String args[]){
        A ob = new A();
        
        ReadThread rt = new ReadThread(ob);
        WriteThread wt = new WriteThread(ob);
        AddThread at = new AddThread(ob);

        at.start();
        wt.start();
        try{
            Thread.sleep(10000);
        }catch(InterruptedException ie){}


        rt.start();
    }
}