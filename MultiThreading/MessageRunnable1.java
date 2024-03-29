class MessageRunnable1 implements Runnable{
    String msg;
    int n;
    Thread t;
    MessageRunnable1(String m,int no){
        msg = m;
        n = no;
        t = new Thread(this); //convert
        t.start(); //start
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

class TestMessageRunnable1{
    public static void main(String args[]){
        MessageRunnable1 mr1 = new MessageRunnable1("Good Morning",10); //create


        MessageRunnable1 mr2 = new MessageRunnable1("Good Evening",20);
       
    }
}