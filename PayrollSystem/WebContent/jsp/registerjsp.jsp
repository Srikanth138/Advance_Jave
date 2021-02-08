<!-- registerjsp.jsp -->
<%@ page import="com.sri.dao.RegisterDAO" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
RegisterDAO rdao=new  RegisterDAO();
int i=rdao.insert(request);
if(i==0) {
	out.println("<h1 style='color:red; text-align: center;'> Record Insertion Faild </h1>");
}
else {
	out.println("<h1 style='color:green; text-align: center;;'> Details Are succesfully Inserted </h1>");
}

out.println("</br></br><a href='input.html'>Home<a/>");
%>