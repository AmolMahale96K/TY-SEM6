import java.sql.*;
import java.util.*;
class EmployeeMenu1{
    public static void main(String args[]){
        Connection con;
        PreparedStatement psinsert,psdelete,psupdatename,psupdatesalary,pssearch,psselect;
        ResultSet rs;

        int choice;
        
        int eid,ans;
        String ename;
        float esalary;

        Scanner sc = new Scanner(System.in);

        try{
            Class.forName("org.postgresql.Driver"); // set classpath
            con = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");
            
            psinsert = con.prepareStatement("insert into employee values(?,?,?)");
            psdelete = con.prepareStatement("delete from employee where id=?");
            psupdatename = con.prepareStatement("update employee set name=? where id=?");
            psupdatesalary = con.prepareStatement("update employee set salary=? where id=?");
            pssearch = con.prepareStatement("select * from employee where id=?");
            psselect = con.prepareStatement("select * from employee");

            do{
                System.out.println("1:Insert");
                System.out.println("2:Delete");
                System.out.println("3:Update");
                System.out.println("4:Search");
                System.out.println("5:ViewAll");
                System.out.println("6:Exit");
                System.out.print("Enter your choice:");
                choice = sc.nextInt();

                switch(choice){
                    case 1: System.out.print("Enter id:");
                            eid = sc.nextInt();
                            
                            sc.nextLine();

                            System.out.print("Enter name:");
                            ename = sc.nextLine();
                            System.out.print("Enter salary:");
                            esalary = sc.nextFloat();

                            psinsert.setInt(1,eid);
                            psinsert.setString(2,ename);
                            psinsert.setFloat(3,esalary);

                            try{
                                psinsert.executeUpdate(); //step-4
                                System.out.println("Inserted successfully");
                            }catch(SQLException se){
                                System.out.println("record already exist");
                            }
                            break;
                    case 2: System.out.print("Enter id to be deleted:");
                            eid = sc.nextInt();
                            
                            psdelete.setInt(1,eid);

                            ans = psdelete.executeUpdate(); //step-4
                            if(ans==0)
                                System.out.println(eid+" not present");
                            else
                                System.out.println("record deleted successfully");
                            break;
                    case 3: System.out.print("Enter id to be updated:");
                            eid = sc.nextInt();

                            System.out.println("1:Update name");
                            System.out.println("2:Update salary");
                            int choice1;
                            System.out.print("Enter your choice:");
                            choice1 = sc.nextInt();
                            
                            sc.nextLine();
                            
                            if(choice1==1){
                                System.out.print("Enter new name:");
                                ename = sc.nextLine();
                                psupdatename.setString(1,ename);
                                psupdatename.setInt(2,eid);

                                ans = psupdatename.executeUpdate(); //step-4
                                if(ans==0)
                                    System.out.println(eid+" not present");
                                else
                                    System.out.println("record updated successfully");

                            }else if(choice1==2){
                                System.out.print("Enter new salary:");
                                esalary = sc.nextFloat();
                                psupdatesalary.setFloat(1,esalary);
                                psupdatesalary.setInt(2,eid);

                                ans = psupdatesalary.executeUpdate(); //step-4
                                if(ans==0)
                                    System.out.println(eid+" not present");
                                else
                                    System.out.println("record updated successfully");
                            }else
                                System.out.println("Invalid choice");                            

                            break;
                    case 4: System.out.print("Enter id to be searched:");
                            eid = sc.nextInt();
                            pssearch.setInt(1,eid);

                            rs = pssearch.executeQuery();
                            if(rs.isBeforeFirst()){
                                rs.next();
                                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                            }else
                                System.out.println(eid+" not present");
                            break;
                    case 5: rs = psselect.executeQuery(); //step-4
                            if(rs.isBeforeFirst()){
                                System.out.println("ID\t\tNAME\t\tSALARY");
                                while(rs.next()){
                                    System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                                }
                            }else
                                System.out.println("No records");
                            break;
                }
            }while(choice!=6);

        }catch(ClassNotFoundException cnfe){
            System.out.println("driver is not loaded : "+cnfe);
        }catch(SQLException sqle){
            System.out.println("sql exception : "+sqle);
        }catch(Exception e){
            System.out.println("General Exception : "+e);
        }
    }
}