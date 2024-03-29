class MessageRunnable implements Runnable{
    String msg;
    int n;
    MessageRunnable(String m,int no){
        msg = m;
        n = no;
    }
    public void run(){
        for(int i=0;i<n;i++){
            System.out.println(msg);
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){

            }
        }
    }
}

class TestMessageRunnable{
    public static void main(String args[]){
        MessageRunnable mr1 = new MessageRunnable("Good Morning",10);  //create
        Thread t1 = new Thread(mr1); //convert
        t1.start(); //start

        MessageRunnable mr2 = new MessageRunnable("Good Evening",20);
        Thread t2 = new Thread(mr2);
        t2.start();
    }
}