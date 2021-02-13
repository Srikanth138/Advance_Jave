<!-- registerjsp.jsp -->
<%@ page import="com.sri.bo.EmployerBO" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
int i = 0;
int id = (int) request.getAttribute("id");
if (i == (int) request.getAttribute("i")) {
	out.println("<h1 style='color:red; text-align: center;'> Record Insertion Faild </h1>");
} else {
	out.println("<h1 style='color:green; text-align: center;'> Details Are succesfully Inserted </h1>");
	out.println("<h1 style='color:green; text-align: center;;'> YOUR ID IS :: " + id + " </h1>");
}

out.println("</br></br><a href='logout.jsp'>LogOut<a/>");
%>