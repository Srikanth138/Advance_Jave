<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<% //read form data
String name=request.getParameter("name");
//perform sendRirection with Google

response.sendRedirect("https://www.google.com/search?q="+name); %>