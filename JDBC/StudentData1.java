import java.sql.*;
class StudentData1{
    public static void main(String args[]){
        Connection con;
        Statement stmt;
        ResultSet rs;
        boolean ans;
        try{
            Class.forName("com.mysql.jdbc.Driver"); //set classpath
            con = DriverManager.getConnection("jdbc:mysql://localhost/tyjdbc1","root","");
            stmt = con.createStatement();
            // ans = stmt.execute("select * from student");
            // ans = stmt.execute("insert into student values(999,'aaa',56)");
            // ans = stmt.execute("update student set mks=60 where roll>200");
            ans = stmt.execute("delete from student where mks<70");
            if(ans){
                System.out.println("You have executed SELECT query");
                rs = stmt.getResultSet();
                while(rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
                }
            }else{
                System.out.println("You have executed non-SELECT query");
                int n;
                n = stmt.getUpdateCount();
                System.out.println("No of records affected : "+n);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}