import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd;
		
		String user = request.getParameter("usr");
		String pass = request.getParameter("pwd");
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		try{
			Class.forName("org.postgresql.Driver"); //copy jar file inside project/lib
			con = DriverManager.getConnection("jdbc:postgresql://localhost/tyjdbc1","postgres","password");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from login where uname='"+user+"' and pname='"+pass+"'");
			
			if(rs.isBeforeFirst()){
				rd = request.getRequestDispatcher("welcome");
				rd.forward(request,response);
			}
			else{
				rd = request.getRequestDispatcher("login.html");
				rd.include(request,response);
				pw.println("<div style=color:red;>Invalid "+user+"</div>");
			}		
			
		}catch(ClassNotFoundException cnfe){
			pw.println("driver not found : "+cnfe);
		}catch(SQLException sqle){
			pw.println("sql error : "+sqle);
		}catch(Exception e){
			pw.println("other error : "+e);
		}
	}
}