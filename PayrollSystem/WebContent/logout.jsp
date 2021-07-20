<!-- logout.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String source=request.getParameter("source");
request.removeAttribute("i");
request.removeAttribute("dto");
request.removeAttribute("id");

if (source.equals("employer")) {
	request.getRequestDispatcher("/Employer.jsp").forward(request, response);
}
else if(source.equals("select")) {
	request.getRequestDispatcher("/Employee.jsp").forward(request, response);
}
else{
	request.getRequestDispatcher("/index.jsp").include(request, response);
}
%>