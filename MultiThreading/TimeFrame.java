import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class TimeThread extends Thread{
    JTextField jtf;
    public TimeThread(JTextField jt){
        jtf = jt;
    }

    public void run(){
        while(true){
        try{
        Date d = new Date();
        int hh = d.getHours();
        int mm = d.getMinutes();
        int ss = d.getSeconds();
        jtf.setText(hh+":"+mm+":"+ss);
        Thread.sleep(300);
        }catch(InterruptedException ie){}
        }
    }
}


class TimeFrame extends JFrame implements ActionListener{
    JTextField jtf;
    JButton jb1,jb2;
    TimeThread tt;

    TimeFrame(){
        setBounds(100,100,300,300);
        setLayout(new FlowLayout());

        jtf = new JTextField(20);
        add(jtf);

        jb1 = new JButton("START");
        add(jb1);

        jb2 = new JButton("STOP");
        jb2.setEnabled(false);
        add(jb2);
        

        tt = new TimeThread(jtf);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
            if(!tt.isAlive()){
                tt.start();
                jb1.setEnabled(false);
                jb2.setEnabled(true);
            }else{
                tt.resume();
                jb1.setEnabled(false);
                jb2.setEnabled(true);
            }

        }
        if(ae.getSource()==jb2){
            tt.suspend();
            jb2.setEnabled(false);
            jb1.setEnabled(true);
        }
    }
}

class TestTimeFrame{
    public static void main(String args[]){
        new TimeFrame();
    }
}