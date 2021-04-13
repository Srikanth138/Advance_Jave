<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<h1 style="color: red; text-align: center;">hello welcome to our
	ForWard page</h1>
<%
String name = (String) request.getAttribute("name");
out.println(name);

String pwd = (String) session.getAttribute("pwd");
out.println(pwd);

String submit = (String) application.getAttribute("submit");
out.println(submit);

Cookie ck[] = request.getCookies();
out.println(ck[0].getValue() + "," + ck[1].getValue() + "," + ck[2].getValue());

out.println("<h1 style='color:red;text-align:center'> All cookies are </h1>");
for (Cookie c : ck) {
	out.println("<b>" + c.getName() + "   " + c.getValue() + "</b><br>");
}
%>
<br>

<a href="index.jsp">home</a>