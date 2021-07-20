<!-- updatejsp.jsp -->
<%@ page import="com.sri.bo.EmployerBO" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
int i=0;
if(i==(int)request.getAttribute("i")) {
	out.println("<h1 style='color:red; text-align: center;'> Record Updation Faild </h1>");
}
else {
	out.println("<h1 style='color:green; text-align: center;;'> Details Are succesfully Updated</h1>");
}

out.println(" <a href='index.jsp'><img src='image/home.jpg' hight=40 width=40 /></a>");
%>