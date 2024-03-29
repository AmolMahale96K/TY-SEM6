import java.sql.*; //set classpath (optional)
class EmployeeDataa{
    public static void main(String args[]){
        Connection cn; //interface
        Statement st; //interface
        ResultSet rs; //interface
        try{
            // step - 1 : Register/Load driver
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");

            // step - 2 : Establish the connection
            // DriverManager.getConnection("jdbc:dbProduct://hostName:portNo/dbName","dbUser","dbPassword");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");

            // step - 3 : Create a Statement using connection
            st = cn.createStatement();

            // step - 4 : Execute Query using statement
            // ResultSet executeQuery() : SELECT query
            // int executeUpdate() : insert, delete, update, create,alter : NON-select query
            // boolean execute() : SELECT or NON-SELECT
            rs = st.executeQuery("select * from employee");

            // Print Result if any
            while(rs.next()){
                System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+rs.getFloat("salary"));
            }

        }catch(ClassNotFoundException cnfe){
            System.out.println("driver not found "+cnfe);
        }catch(SQLException sqle){
            System.out.println("SQL error "+sqle);
        }catch(Exception e){
            System.out.println("other error"+e);
        }
    }
}
