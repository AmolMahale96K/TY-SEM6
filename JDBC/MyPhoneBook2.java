import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class MyPhoneBook2 extends JFrame implements ActionListener{
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JLabel jl1,jl2,jl3,jl4;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb;
    JPanel jp1,jp2,jp3;

    Connection con;
    Statement stmt;
    ResultSet rs;

    MyPhoneBook2(){    
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from phonebook");
        }catch(Exception e){
            System.out.println(e);
        }


        setTitle("NSG Academy");
        setBounds(100,100,600,400);

        jp1 = new JPanel(new GridLayout(4,2));
            jl1 = new JLabel("NAME");
            jp1.add(jl1);
            jtf1 = new JTextField(20);
            jp1.add(jtf1);

            jl2 = new JLabel("ADDRESS");
            jp1.add(jl2);
            jtf2 = new JTextField(20);
            jp1.add(jtf2);
            
            jl3 = new JLabel("PHONE");
            jp1.add(jl3);
            jtf3 = new JTextField(20);
            jp1.add(jtf3);
            
            jl4 = new JLabel("EMAIL");
            jp1.add(jl4);
            jtf4 = new JTextField(20);
            jp1.add(jtf4);
            
        add(jp1,BorderLayout.CENTER);


        jp2 = new JPanel(new GridLayout(1,6));
            jb1 = new JButton("<<");
            jb1.setEnabled(false);
            jb1.addActionListener(this);
            jp2.add(jb1);

            jb2 = new JButton("DELETE");
            jb2.setEnabled(false);
            jb2.addActionListener(this);
            jp2.add(jb2);
            
            jb3 = new JButton("UPDATE");
            jb3.setEnabled(false);
            jb3.addActionListener(this);
            jp2.add(jb3);
            
            jb4 = new JButton("INSERT");
            jb4.addActionListener(this);
            jp2.add(jb4);
            
            jb5 = new JButton(">>");
            jb5.addActionListener(this);
            jp2.add(jb5);
            
            jb6 = new JButton("EXIT");
            jb6.addActionListener(this);
            jp2.add(jb6);
            
        add(jp2,BorderLayout.SOUTH);


        jp3 = new JPanel();
        jp3.setLayout(new GridLayout(1,5));
            jtf5 = new JTextField(20);
            jp3.add(jtf5);
            jtf6 = new JTextField(20);
            jp3.add(jtf6);
            jtf7 = new JTextField(20);
            jp3.add(jtf7);
            jtf8 = new JTextField(20);
            jp3.add(jtf8);
            jb = new JButton("OK");
            jp3.add(jb);
            jb.addActionListener(this);
        jp3.setVisible(false);
        add(jp3,BorderLayout.NORTH);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        try{

        if(ae.getSource()==jb1){
            rs.previous();
            jb2.setEnabled(true);
            jb3.setEnabled(true); 
            jb5.setEnabled(true);
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
            rs.updateString(1,jtf1.getText());
            rs.updateString(2,jtf2.getText());
            rs.updateString(3,jtf3.getText());
            rs.updateString(4,jtf4.getText());
            rs.updateRow();
        }
        if(ae.getSource()==jb4){
            jp3.setVisible(true);
            jp1.setVisible(false);
            jp2.setVisible(false);
        }
        if(ae.getSource()==jb5){
            rs.next();
            jb1.setEnabled(true);
            jb2.setEnabled(true);
            jb3.setEnabled(true);            
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

        if(ae.getSource()==jb){
            rs.moveToInsertRow();
            rs.updateString(1,jtf5.getText());
            rs.updateString(2,jtf6.getText());
            rs.updateString(3,jtf7.getText());
            rs.updateString(4,jtf8.getText());

            rs.insertRow();

            jp3.setVisible(false);
            jp1.setVisible(true);
            jp2.setVisible(true);
            rs.last();
            
            jtf1.setText(rs.getString(1));
            jtf2.setText(rs.getString(2));
            jtf3.setText(rs.getString(3));
            jtf4.setText(rs.getString(4));
        }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        new MyPhoneBook2();
    }
}