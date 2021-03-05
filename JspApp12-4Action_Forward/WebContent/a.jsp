<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<b>start of a.jsp</b>
<br />
<%
float bAmt = 300.0f + (300.0f * 0.03f);
%>
<jsp:forward page="b.jsp">
	<jsp:param value="CRJ" name="bkName" />
	<jsp:param value="<%=bAmt%>" name="billAmt" />
</jsp:forward>
<br />
<b>start of a.jsp</b>