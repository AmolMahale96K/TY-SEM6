class MessageThread extends Thread{
    String msg;
    int n;
    int x;
    MessageThread(String m,int no,int x1){
        msg = m;
        n = no;
        x = x1;
    }
    public void run(){  //task/job
        for(int i=0;i<n;i++){
            System.out.println(msg);
            try{
                Thread.sleep(x);
            }catch(InterruptedException ie){

            }
        }
    }
}
class TestMessageThread{
    public static void main(String args[]){
        MessageThread mt1 = new MessageThread("Good Morning",10,1000);
        mt1.start();

        MessageThread mt2 = new MessageThread("Good Evening",20,500);
        mt2.start();
    }
}