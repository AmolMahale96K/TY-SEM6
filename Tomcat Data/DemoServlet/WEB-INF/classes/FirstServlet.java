import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) 
	throws ServletException,IOException{
	
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("usr");		
		out.println("Congrats!!!! "+uname);
	}
}