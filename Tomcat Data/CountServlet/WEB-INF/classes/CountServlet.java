import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CountServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		
		String currentuser = request.getParameter("usr");
		String prevuser;
		
		int no = 1;
		Cookie c[] = request.getCookies();
		if(c==null){
			Cookie c1 = new Cookie("no",""+no);
			response.addCookie(c1);
			out.print("<br>Number of Visitor : "+no);
			
			Cookie c2 = new Cookie("user",currentuser);
			response.addCookie(c2);
			out.print("<br>Current Visitor : "+currentuser);
		}else{
			no = Integer.parseInt(c[0].getValue());
			no++;			
			c[0].setValue(""+no);
			response.addCookie(c[0]);
			out.print("<br>Number of Visitor : "+no);
			
			prevuser = c[1].getValue();
			out.print("<br>Previous visitor was "+prevuser);
			c[1].setValue(currentuser);
			response.addCookie(c[1]);
			out.print("<br>Current User : "+currentuser);
		}		
	}
}