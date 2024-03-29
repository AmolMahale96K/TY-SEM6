import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MyPhoneBook1 extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,ok;
	JPanel jp1,jp2,jp3;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	MyPhoneBook1(){
		setBounds(100,100,700,300);
		setLayout(new BorderLayout());
		setTitle("PhoneBook");
		
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
		jb1.setEnabled(false);
		jp2.add(jb2);
		jb2.setEnabled(false);
		jp2.add(jb3);
		jb3.setEnabled(false);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);		
		
		add(jp2,BorderLayout.SOUTH);
	
	
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(1,5));
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		jtf8 = new JTextField();
		ok = new JButton("OK");
		jp3.add(jtf5);
		jp3.add(jtf6);
		jp3.add(jtf7);
		jp3.add(jtf8);
		jp3.add(ok);
		ok.addActionListener(this);
		add(jp3,BorderLayout.NORTH);
		jp3.setVisible(false);
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
			jb2.setEnabled(true);
			jb3.setEnabled(true);
			jb4.setEnabled(true);
			jb5.setEnabled(true);
			
			rs.previous();
			if(rs.isBeforeFirst()){
				jb1.setEnabled(false);
				jb2.setEnabled(false);
				jb3.setEnabled(false);
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");				
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
			String name = jtf1.getText();
			String address = jtf2.getText();
			String phone = jtf3.getText();
			String email = jtf4.getText();
			
		
			rs.updateString(1,name);
			rs.updateString(2,address);
			rs.updateString(3,phone);
			rs.updateString(4,email);
			
			rs.updateRow();
		}
		if(ae.getSource()==jb4){
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(true);
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf8.setText("");			
		}
		if(ae.getSource()==ok){
			
			rs.moveToInsertRow();  //create extra row to insert
			
			String name = jtf5.getText();
			String address = jtf6.getText();
			String phone = jtf7.getText();
			String email = jtf8.getText();
			
			rs.updateString(1,name);
			rs.updateString(2,address);
			rs.updateString(3,phone);
			rs.updateString(4,email);
			
			rs.insertRow();
			
			jp1.setVisible(true);
			jp2.setVisible(true);
			jp3.setVisible(false);
			
			rs.last();
			
			jtf1.setText(rs.getString(1));
			jtf2.setText(rs.getString(2));
			jtf3.setText(rs.getString(3));
			jtf4.setText(rs.getString(4));			
		}
		
		if(ae.getSource()==jb5){
			jb1.setEnabled(true);
			jb2.setEnabled(true);
			jb3.setEnabled(true);
			jb4.setEnabled(true);
			jb5.setEnabled(true);
			
			rs.next();			
			if(rs.isAfterLast()){
				jb5.setEnabled(false);
				jb2.setEnabled(false);
				jb3.setEnabled(false);
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
			}else{			 	
				jtf1.setText(rs.getString(1));
				jtf2.setText(rs.getString(2));
				jtf3.setText(rs.getString(3));
				jtf4.setText(rs.getString(4));
			}	
		}
		
		if(ae.getSource()==jb6){
			System.exit(0);
		}		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[]){
		new MyPhoneBook1();
	}
}