<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
declaration tag:
<%! int add(int x,int y){
int z=x+y;
return z;
}
%><br>
Scriptlet tag<% out.println(add(10,20));%><br>  <!-- scriptlet calling end that one use the";" & out.println();-->
Exprestion tag<%= add(10,30) %>  <!-- Exprestion tag calling the method are variable directly-->
</body>
</html>