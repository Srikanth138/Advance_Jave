<%@ page language="java" buffer="2kb"  autoFlush="true"
	pageEncoding="ISO-8859-1"%>
<!-- buffer default-8kb max-10kb, buffer="none" -->
<!-- autoFlush default value is true  ,autoFlush="false"-->

<% //autoFlush="false" raise the exception
for (int i = 0; i <= 100000; i++) {
	
	//out is extends the java.io.Write(AC)->javax.servlet.jsp.JspWriter(AC)
	out.println("hello" + i + "<br>");
}
%>