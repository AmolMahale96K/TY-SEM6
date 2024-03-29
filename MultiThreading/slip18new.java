import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class CharacterFrame extends JFrame implements ActionListener,Runnable{
	JPanel p1;
	JPanel p2;
	
	JButton jb1,jb2;
	
	int n,pos;
	Thread t;
	
	Color c[]={Color.red,Color.blue,Color.green,Color.black,Color.white,Color.DARK_GRAY,Color.yellow,Color.magenta,Color.cyan,Color.orange};
	char ch[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	Font f=new Font("Times New Roman",Font.BOLD,28);
	
	Random r=new Random();
	
    CharacterFrame(){
		
		setSize(700,400);
		setLocation(100,100);
		setLayout(new BorderLayout());
		
		p1=new JPanel();
		p1.setBackground(Color.gray);
		add(p1,BorderLayout.CENTER);
		
		p2=new JPanel();
		p2.setBackground(Color.cyan);
		jb1=new JButton("start");
		jb1.addActionListener(this);
		p2.add(jb1);
		jb2=new JButton("restart");
		jb2.setEnabled(false);
		jb2.addActionListener(this);
		p2.add(jb2);
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run(){
		int left=0;
		left=left+pos;
		pos=pos+25;
		
		int top=0,no;
		boolean flag=false;
		
		no=r.nextInt(26);
		
		JLabel jl = new JLabel(""+ch[no]);
		p1.add(jl);		
		
		jl.setLocation(left,top);
		jl.setFont(f);
		no=r.nextInt(10);
		jl.setForeground(c[no]);
		
		try{
			while(true){
				Thread.sleep(10);	
				
				if(top>=p1.getHeight()-25)
					flag=true;
				
				if(top<-5)
					flag=false;
					
				if(flag)
					top=top-1;	
				else
					top=top+1;	
				jl.setLocation(left,top);
			}
		}catch(Exception e){}		
	}


	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jb1 && n<10){
			t=new Thread(this);
			t.start();
			n++;		
		}
		
		if(ae.getSource()==jb2){
			n=0;
			pos=0;
			p1.removeAll();
			p1.repaint();
			jb1.setEnabled(true);
			jb2.setEnabled(false);
		}
	
		if(n>=10)
		  {
		   jb1.setEnabled(false);
		   jb2.setEnabled(true);
		   JOptionPane.showMessageDialog(null,"We have only 10 characters");
		  } 
		
	}
	public static void main(String args[]){
		new CharacterFrame();
	}
}

