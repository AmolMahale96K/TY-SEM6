import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyThread extends Thread{
	int top;
	int left;
	CircleFrame parent;
	Color c;
	boolean flag;
	MyThread(int t,int l,Color cc,CircleFrame cf){
		top=t;
		left=l;
		c=cc;
		parent=cf;
		flag=false;
	}
	public void run(){
		try{
		while(true){
			Thread.sleep(10);
			if(top>=(parent.mp.getHeight()-40))
				flag=true;
			if(top<=0)
				flag=false;
			if(flag)
				top=top-1;
			else
				top=top+1;
			parent.mp.repaint();
		}
		}catch(Exception e){}
	}
}

public class CircleFrame extends JFrame implements ActionListener{
	MyPanel mp;
	Panel p;
	JButton jb1;
	Color c[]={Color.blue,Color.black,Color.pink,Color.red,Color.DARK_GRAY,Color.white,Color.yellow,Color.orange,Color.green,Color.magenta};
	int n,top,left;
	MyThread t[];
	
	CircleFrame(){
		n=0;top=0;left=0;
		t=new MyThread[10];


		setSize(300,300);
		setLocation(10,10);
		setLayout(new BorderLayout());
		mp=new MyPanel(this);
		mp.setBackground(Color.gray);
		add(mp,BorderLayout.CENTER);
		
		p=new Panel();
		p.setBackground(Color.cyan);
		jb1=new JButton("start");
		jb1.addActionListener(this);
		p.add(jb1);

		add(p,BorderLayout.SOUTH);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(n>=10){
			JOptionPane.showMessageDialog(null,"only 10 ball are allowed");	
			jb1.setEnabled(false);
		}
		t[n]=new MyThread(top,left,c[n],this);
		t[n].start();
		n++;
		top=top+25;
		left=left+65;
	}
	public static void main(String args[]){
		CircleFrame cf=new CircleFrame();
	}
}

class MyPanel extends JPanel{
	CircleFrame parent;
	MyPanel(CircleFrame c){
		parent=c;
	}
	public void paint(Graphics g){
		
		for(int i=0;i<parent.n;i++){	
			g.setColor(parent.c[i]);
			g.fillOval(parent.t[i].left,parent.t[i].top,50,50);
		}
	}
}
