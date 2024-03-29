<%@page language="java"%>

<%
		String uname = request.getParameter("usr");
		String pass = request.getParameter("pwd");
		
		if(uname.equals(pass))
			out.println("Congrats "+uname);
		else
			out.println("Sorry "+uname);
%>