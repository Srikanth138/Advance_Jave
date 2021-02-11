<!-- registerjsp.jsp -->
<%@ page import="com.sri.dao.RegisterDAO,com.sri.bo.EmployerBO" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
System.out.println(request.getAttribute("i"));
System.out.println(request.getAttribute("name"));

request.removeAttribute("i");
request.removeAttribute("name");

System.out.println(request.getAttribute("i"));
System.out.println(request.getAttribute("name"));

request.getRequestDispatcher("/PayrollSystem/WebContent/input.html").forward(request, response);
%>