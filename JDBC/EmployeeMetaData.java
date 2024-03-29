import java.sql.*;
class EmployeeMetaData{
    public static void main(String args[]){
        Connection con;
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData rmd;
        int n;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from employee");
            rmd = rs.getMetaData();  //step-5

            n = rmd.getColumnCount();
            System.out.println("Number of columns in employee table : "+n);

            for(int i=1;i<=n;i++){
                System.out.println("Column Name : "+rmd.getColumnName(i));
                System.out.println("Column Label : "+rmd.getColumnLabel(i));
                System.out.println("Column Type : "+rmd.getColumnTypeName(i));
                System.out.println("Column Display Size : "+rmd.getColumnDisplaySize(i));
                System.out.println("ReadOnly? : "+rmd.isReadOnly(i));
                System.out.println("Writable? : "+rmd.isWritable(i));
                System.out.println("NULL? : "+rmd.isNullable(i));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}