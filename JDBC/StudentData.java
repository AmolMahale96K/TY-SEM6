import java.sql.*;
class StudentData{
    public static void main(String args[]){
        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            // step - 1 Register Driver
            Class.forName("com.mysql.jdbc.Driver");
            // Class.forName("org.gjt.mm.mysql.Driver");

            // step - 2 Establish the connection
            // DriverManager.getConnection("jdbc:DBProductName://hostname:port/dbName",dbUsr,dbPwd);
            con = DriverManager.getConnection("jdbc:mysql://localhost/tyjdbc1","root","");

            // step - 3 Create a Statement
            stmt = con.createStatement();

            // step - 4 Execute Query
            rs = stmt.executeQuery("select * from student");

            System.out.println("ROLL\tNAME\tMARKS");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
            }     
        }catch(ClassNotFoundException cnfe){
            System.out.println("Driver not found : "+cnfe);
        }catch(SQLException sqle){
            System.out.println("SQL error : "+sqle);
        }catch(Exception e){
            System.out.println("Other errors : "+e);
        }
    }
}