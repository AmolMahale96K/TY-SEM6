import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HobbyServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		
		String hobby = request.getParameter("hobby");
		Cookie c[] = request.getCookies();
		int flag = 0,i;
		
		if(c==null){
			Cookie c1 = new Cookie("hobby0",hobby);
			response.addCookie(c1);
			out.print(hobby+" selected and added");
		}else{
			for(i=0;i<c.length;i++){
				if((c[i].getValue()).equals(hobby)){
					flag = 1;
					break;
				}
			}
			
			if(flag==1)
				out.println(hobby+" is duplicate. It is already added");
			else{
				//add new hobby
				Cookie c2 = new Cookie("hobby"+i,hobby);
				response.addCookie(c2);
				out.println(hobby+" selected and added");
			}
			
			out.println(" Your all hobbies....");
			for(i=0;i<c.length;i++)
				out.println(c[i].getValue());
		}				
	}
}