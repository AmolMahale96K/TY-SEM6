import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
class CircleThread extends Thread{
	CircleFrame parent;
	int top,left;
	boolean flag;
	CircleThread(CircleFrame cf,int t,int l){
		parent=cf;
		top=t;
		left=l;
	}
	public void run(){
		try{
			while(true){
				Thread.sleep(5);
				
				if(top<=0)
					flag=false;
				if(top>=parent.p1.getHeight()-40)
					flag=true;
					
				if(flag)
					top=top-1;
				else
					top=top+1;
				
				parent.p1.repaint();
			}
		}catch(Exception e){
		}
	}
}
class CircleFrame extends JFrame implements ActionListener{
	MyPanel p1;
	JPanel p2;
	JButton jb1,jb2;
	int n,top,left;
	CircleThread ct[]=new CircleThread[10];
	CircleFrame(){
		setLocation(10,10);
		setSize(650,400);
		setLayout(new BorderLayout());
		setResizable(false);
		p1=new MyPanel(this);
		p1.setBackground(Color.DARK_GRAY);
		add(p1,BorderLayout.CENTER);
		
		p2=new JPanel();
		p2.setBackground(Color.cyan);
		jb1=new JButton("start");
		p2.add(jb1);
		jb1.addActionListener(this);
		
		jb2=new JButton("restart");
		jb2.setEnabled(false);
		p2.add(jb2);
		jb2.addActionListener(this);
		
		add(p2,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jb2)
			{
				n=0;
				top=0;
				left=0;
				jb1.setEnabled(true);
				jb2.setEnabled(false);
			}
		
		ct[n]=new CircleThread(this,top,left);
		ct[n].start();
	
		top=top+25;
		left=left+65;
		n++;
		if(n>=10){
			jb1.setEnabled(false);
			jb2.setEnabled(true);
		}
		
	}
	public static void main(String args[]){
		CircleFrame cf=new CircleFrame();
	}
}

class MyPanel extends Panel{
	CircleFrame parent;
	Color c[]={Color.red,Color.green,Color.blue,Color.orange,Color.black,Color.white,Color.DARK_GRAY,Color.cyan,Color.magenta,Color.yellow};
	MyPanel(CircleFrame p){
		parent=p;
	}
	public void paint(Graphics g){
		for(int i=0;i<parent.n;i++){
			g.setColor(c[i]);
			g.fillOval(parent.ct[i].left,parent.ct[i].top,50,50);
		}
	}
}