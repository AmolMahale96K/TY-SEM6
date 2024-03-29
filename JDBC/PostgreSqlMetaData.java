import java.sql.*;
class PostgreSqlMetaData{
    public static void main(String args[]){
        Connection con;
        DatabaseMetaData dmd;
        ResultSet rs;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","password");
            dmd = con.getMetaData();

            rs = dmd.getTables(null,null,null,new String[]{"TABLE"});
            while(rs.next()){
                // System.out.println(rs.getString("table_cat")+"\t"+rs.getString("table_schem")+"\t"+rs.getString("table_name")+"\t"+rs.getString("table_type")+"\t"+rs.getString("remarks"));
                // System.out.println(rs.getString(3));
                System.out.println(rs.getString("table_name"));
            }

            // getTables() returns a resultset of 5 columns
            // in which column 3 contains table name
            // table_cat
            // table_schem
            // table_name
            // table_type
            // remarks



            // System.out.println("User Name : "+dmd.getUserName());
            // System.out.println("URL : "+dmd.getURL());
            
            // System.out.println("Database Product Name : "+dmd.getDatabaseProductName());
            // System.out.println("Database Version Name : "+dmd.getDatabaseProductVersion());

            // System.out.println("Driver Name : "+dmd.getDriverName());
            // System.out.println("Driver Version : "+dmd.getDriverVersion());
            // System.out.println("Driver Major Version : "+dmd.getDriverMajorVersion());
            // System.out.println("Driver Minor Version : "+dmd.getDriverMinorVersion());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}