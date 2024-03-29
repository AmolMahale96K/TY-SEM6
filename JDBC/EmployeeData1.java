import java.sql.*;
import java.util.*;
class EmployeeData1{
    public static void main(String args[]){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String dbURL = "jdbc:postgresql://localhost/";
        String dbName = "tyjdbc1";
        String dbUsr = "postgres";
        String dbPwd = "password";

        Scanner sc = new Scanner(System.in);
        int eid;
        String ename;
        float esalary;

        System.out.println("Enter id:");
        eid = sc.nextInt();
        System.out.println("Enter name:");
        ename = sc.next();
        System.out.println("Enter salary:");
        esalary = sc.nextFloat();        

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL+dbName,dbUsr,dbPwd);
            stmt = con.createStatement();
            stmt.executeUpdate("insert into employee values("+eid+",'"+ename+"',"+esalary+")");

            // stmt.executeUpdate("delete from employee where id=333");
            // stmt.executeUpdate("update employee set name='sssss' where id=111");            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}