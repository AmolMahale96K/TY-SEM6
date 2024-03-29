<%@page language="java" session="false" contentType="text/html"%>

<%				
	

		int no = 1;
		Cookie c[] = request.getCookies();
		if(c==null){
			Cookie c1 = new Cookie("no",""+no);
			response.addCookie(c1);
			out.print("<br>Number of Visitor : "+no);
		}else{
			no = Integer.parseInt(c[0].getValue());
			no++;			
			c[0].setValue(""+no);
			response.addCookie(c[0]);
			out.print("<br>Number of Visitor : "+no);			
		}
%>