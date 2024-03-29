import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class WelcomeServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter pw = response.getWriter();
		
		pw.println("Hello "+request.getParameter("usr")+" Welcome to NSG...");
	}
}