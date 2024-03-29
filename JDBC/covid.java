import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class covid extends JFrame implements ActionListener{
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jtitle;
    JTextField jtf1,jtf2,jtf3,jtf4;
    JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5,jrb6,jrb7,jrb8;
    ButtonGroup bg1,bg2,bg3;
    JButton jb1,jb2,jb3,jb4,jb5;
    JPanel jp1,jp2;
    Font f;
   
    covid(){
        setBounds(100,100,450,300);
        setLayout(new BorderLayout());

        jtitle = new JLabel("Co-WIN Registration",JLabel.CENTER);
        add(jtitle,BorderLayout.NORTH);
        f = new Font(Font.SERIF,Font.BOLD,20);
        jtitle.setFont(f);

        jp1 = new JPanel();
        jp1.setLayout(new FlowLayout());
        add(jp1,BorderLayout.CENTER);

        
        jl1 = new JLabel("AdharCardNo");
        jl2 = new JLabel("BirthYear");
        jl3 = new JLabel("MobileNo");
        jl4 = new JLabel("Age Group");
        jl5 = new JLabel("Select Hospital");
        jl6 = new JLabel("Vaccines");
        jl7 = new JLabel("Time Slot");
        
        jtf1 = new JTextField(20);
        jtf2 = new JTextField(20);
        jtf3 = new JTextField(20);
        jtf4 = new JTextField(20);
        
        bg1 = new ButtonGroup();
        jrb1 = new JRadioButton("18 & Above");
        jrb2 = new JRadioButton("45 & Above");
        bg1.add(jrb1);
        bg1.add(jrb2);

        bg2 = new ButtonGroup();
        jrb3 = new JRadioButton("Covishield",true);
        jrb4 = new JRadioButton("Covaxin");
        jrb5 = new JRadioButton("Sptunik V.");        
        bg2.add(jrb3);
        bg2.add(jrb4);
        bg2.add(jrb5);


        bg3 = new ButtonGroup();
        jrb6 = new JRadioButton("Morning",true);
        jrb7 = new JRadioButton("Afternoon");
        jrb8 = new JRadioButton("Evening");
        bg3.add(jrb6);
        bg3.add(jrb7);
        bg3.add(jrb8);

        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(jl3);
        jp1.add(jtf3);

        jp1.add(jl4);
        jp1.add(jrb1);
        jp1.add(jrb2);
        jp1.add(jl5);
        jp1.add(jtf4);

        jp1.add(jl6);
        jp1.add(jrb3);
        jp1.add(jrb4);
        jp1.add(jrb5);
        jp1.add(jl7);
        jp1.add(jrb6);
        jp1.add(jrb7);
        jp1.add(jrb8);
        




        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(1,5));
        jb1 = new JButton("ADD");
        jb2 = new JButton("UPDATE");
        jb3 = new JButton("DELETE");
        jb4 = new JButton("VIEW");
        jb5 = new JButton("SEARCH");
        jp2.add(jb1);
        jb1.addActionListener(this);
        jp2.add(jb2);
        jb2.addActionListener(this);
        jp2.add(jb3);
        jb3.addActionListener(this);
        jp2.add(jb4);
        jb4.addActionListener(this);
        jp2.add(jb5);
        jb5.addActionListener(this);
        add(jp2,BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==jb1){

            }
            if(ae.getSource()==jb2){
                
            }
            if(ae.getSource()==jb3){
                
            }
            if(ae.getSource()==jb4){
                
            }
            if(ae.getSource()==jb5){
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new covid();
    }
}