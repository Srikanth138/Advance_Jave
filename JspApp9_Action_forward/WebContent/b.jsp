<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<br>
<b>form b.jsp</b><br>
<%=new java.util.Date() %><br>
book name is:<%=request.getParameter("bkName") %><br>
book price :<%=request.getParameter("billAmt") %>
<br>