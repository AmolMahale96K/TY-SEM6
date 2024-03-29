class MessageRunnable2 implements Runnable{
    String msg;
    int n;
    Thread t;
    MessageRunnable2(String m,int no){
        msg = m;
        n = no;
        t = new Thread(this); //convert
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

class TestMessageRunnable2{
    public static void main(String args[]){
        MessageRunnable2 mr1 = new MessageRunnable2("Good Morning",10);//create
        mr1.t.start(); //start

        MessageRunnable2 mr2 = new MessageRunnable2("Good Evening",20);
        mr2.t.start();
    }
}