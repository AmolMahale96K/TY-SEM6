import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch2 extends JFrame implements ActionListener,Runnable{
    JTextField jtf;
    JButton jb1,jb2;
    Thread t;
    StopWatch2(){
        setBounds(100,100,300,300);
        setLayout(new FlowLayout());

        jtf = new JTextField(20);
        add(jtf);

        jb1 = new JButton("START");
        jb1.addActionListener(this);
        add(jb1);

        jb2 = new JButton("STOP");
        jb2.setEnabled(false);
        jb2.addActionListener(this);
        add(jb2);

        t = new Thread(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
            if(!t.isAlive()){
                t.start();
                jb1.setEnabled(false);
                jb2.setEnabled(true);
            }else{
                t.resume();
                jb1.setEnabled(false);
                jb2.setEnabled(true);
            }
        }
        if(ae.getSource()==jb2){
            t.suspend();
            jb1.setEnabled(true);
            jb2.setEnabled(false);
        }
    }

    public void run(){
        while(true){            
            Date d = new Date();
            int hh = d.getHours();
            int mm = d.getMinutes();
            int ss = d.getSeconds();
            jtf.setText(""+hh+":"+mm+":"+ss);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
            }
        }
    }

    public static void main(String args[]){
        new StopWatch2();
    }
}