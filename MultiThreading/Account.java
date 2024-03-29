class AccountThread extends Thread{
    Account act;
    AccountThread(Account a){
        act = a;
    }
    public void run(){
        act.withdraw(20000);
    }
}

class Account{
    int balance;
    void deposit(int x){
        balance = balance + x;
    }
    void withdraw(int y){
        System.out.println(Thread.currentThread() + " wants to withdraw");
        System.out.println(Thread.currentThread()+ " can withdraw at most "+(balance-500));

        synchronized(this){
            try{
                if(balance-y >= 500){
                    balance = balance - y;
                    System.out.println("Amount withdrawn by "+Thread.currentThread());
                    System.out.println("balane after withdrawn by "+Thread.currentThread()+" is "+balance);
                }else{
                    Thread.sleep(1000);
                    System.out.println("Insufficient Fund for "+Thread.currentThread());
                }
            }catch(InterruptedException ie){}
        }    

    }
}

class TestAccount{
    public static void main(String args[]){
        Account ob = new Account();
        ob.deposit(50000);   


        AccountThread ob1 = new AccountThread(ob);
        ob1.setName("ATM");

        AccountThread ob2 = new AccountThread(ob);
        ob2.setName("NET");

        AccountThread ob3 = new AccountThread(ob);
        ob3.setName("CHEQUE");

        ob1.start();
        ob2.start();
        ob3.start();
    }
}