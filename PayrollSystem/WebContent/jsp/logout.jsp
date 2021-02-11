<!-- registerjsp.jsp -->
<%@ page import="com.sri.dao.RegisterDAO,com.sri.bo.EmployerBO" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
application.removeAttribute("i");
application.removeAttribute("name");

request.getRequestDispatcher("/PayrollSystem/WebContent/input.html").forward(request, response);
%>