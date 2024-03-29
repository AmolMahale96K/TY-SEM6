import java.sql.*;
import java.util.*;

class EmployeeData2{
    public static void main(String args[]){
        Connection con;
        PreparedStatement ps;
      
        int n;
        
        int eid;
        String ename;
        float esalary;

        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");
            
            ps = con.prepareStatement("insert into employee values(?,?,?)"); // ? placeholder

            // con.prepareStatement("delete from employee where id=?");
            // con.prepareStatement("update employee set salary=? where id=?");
            // con.prepareStatement("update employee set name=? where id=?");
            
            //dynamic sql OR precompiled sql

            System.out.print("Enter how many employees:");
            n = sc.nextInt();
            for(int i=0;i<n;i++){
                System.out.print("Enter id:");
                eid = sc.nextInt();
                System.out.print("Enter name:");
                ename = sc.next();
                System.out.print("Enter salary:");
                esalary = sc.nextFloat();

                ps.setInt(1,eid);  
                ps.setString(2,ename);
                ps.setFloat(3,esalary);

                ps.executeUpdate(); //step-4                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}