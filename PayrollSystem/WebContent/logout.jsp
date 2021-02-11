<!-- registerjsp.jsp -->
<%@ page import="com.sri.dao.RegisterDAO,com.sri.bo.EmployerBO" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
request.removeAttribute("i");
request.removeAttribute("name");

request.getRequestDispatcher("input.html").forward(request, response);
%>