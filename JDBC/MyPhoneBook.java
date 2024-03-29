import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MyPhoneBook extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JPanel jp1,jp2;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	MyPhoneBook(){
		setBounds(100,100,500,300);
		setLayout(new BorderLayout());
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4,2));
		jl1 = new JLabel("NAME");
		jl2 = new JLabel("ADDRESS");
		jl3 = new JLabel("PHONE");
		jl4 = new JLabel("EMAIL");		
		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		jtf4 = new JTextField(20);
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);		
		add(jp1,BorderLayout.CENTER);
		
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1,6));		
		jb1 = new JButton("<<");
		jb2 = new JButton("DELETE");
		jb3 = new JButton("UPDATE");
		jb4 = new JButton("INSERT");
		jb5 = new JButton(">>");
		jb6 = new JButton("EXIT");
		jp2.add(jb1);
		jp2.add(jb2);
		jb2.setEnabled(false);
		jp2.add(jb3);
		jb3.setEnabled(false);
		jp2.add(jb4);
		jb4.setEnabled(false);
		jp2.add(jb5);
		jp2.add(jb6);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);		
		
		add(jp2,BorderLayout.SOUTH);
	
	
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/tylive2020","postgres","password");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	
			rs = stmt.executeQuery("select * from phonebook");		
		}catch(Exception e){
			System.out.println(e);
		}	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		try{
		if(ae.getSource()==jb1){
			jb5.setEnabled(true);
			jb2.setEnabled(true);
			rs.previous();
			if(rs.isBeforeFirst()){
				jb1.setEnabled(false);
			}else{			 	
				jtf1.setText(rs.getString(1));
				jtf2.setText(rs.getString(2));
				jtf3.setText(rs.getString(3));
				jtf4.setText(rs.getString(4));
			}	
		}		
		if(ae.getSource()==jb2){
			rs.deleteRow();
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");			
		}
		if(ae.getSource()==jb3){
		
		}
		if(ae.getSource()==jb4){
		
		}
		if(ae.getSource()==jb5){
			jb1.setEnabled(true);
			jb2.setEnabled(true);
			rs.next();			
			if(rs.isAfterLast()){
				jb5.setEnabled(false);
			}else{			 	
				jtf1.setText(rs.getString(1));
				jtf2.setText(rs.getString(2));
				jtf3.setText(rs.getString(3));
				jtf4.setText(rs.getString(4));
			}	
		}
		
		if(ae.getSource()==jb6){
			System.exit(1);
		}		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[]){
		new MyPhoneBook();
	}
}