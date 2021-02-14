<!-- logout.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
application.removeAttribute("i");
application.removeAttribute("dto");
application.removeAttribute("id");
request.getRequestDispatcher("input.jsp").forward(request, response);
%>