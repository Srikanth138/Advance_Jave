<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<h2><b>first jsp psge</b></h2><br>
<u>THIS IS GLOBLE DECLARATION</u><%! int a=10; %><br>
SCRIPTLER TAG:<% java.util.Date d=new java.util.Date();
out.println(d); 
int b=20;%><br>
Exprestion tag<%=b+a %><br>
end of jsp page