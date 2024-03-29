// MultiTasking
    // Application based Multitasking
    // Thread based Multitasking (MultiThreading)

class A extends Thread{
    String name;
    public A(String s){
        name = s;
    }
    public void run(){  //job
        System.out.println(name);

        try{
            Thread.sleep(2000);//ms
        }catch(InterruptedException e){
            
        }
        System.out.println(Thread.currentThread());
    }    
}

class B{
    public static void main(String args[]){
        // System.out.println(Thread.currentThread());
        Thread t = Thread.currentThread();
        t.setName("Parent");
        System.out.println(t.getName());

        A ob1 = new A("bhav");
        A ob2 = new A("krish");
        A ob3 = new A("dave");

        ob1.setName("Child1");
        ob2.setName("Child2");
        ob3.setName("Child3");

        // System.out.println(ob1.getName());

        ob1.setPriority(7);
        ob2.setPriority(2);
        ob3.setPriority(9);

        System.out.println(ob1.isAlive());
        System.out.println(ob2.isAlive());
        System.out.println(ob3.isAlive());

        ob1.start();
        ob2.start();
        ob3.start();

        try{
            // ob1.join();
            // ob2.join();
            ob3.join();
        }catch(InterruptedException ie){
        }

        System.out.println("EXIT OF MAIN METHOD");
    }
}