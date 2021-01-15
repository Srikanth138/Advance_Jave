<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="com.nt.dao.SelectDAO , com.nt.beans.EmpBeans"%>

<%
	SelectDAO dao = new SelectDAO();
ArrayList<EmpBeans> al = dao.retrive(request);

for (EmpBeans eb : al) {
%>
<center>
	<table>
		<tr>
			<td><%=eb.getName()%></td>
			<td><%=eb.getEmpId()%></td>
			<td><%=eb.getGender()%></td>
			<td><%=eb.getPan()%></td>
			<td><%=eb.getDOB()%></td>
			<td><%=eb.getDOJ()%></td>
			<td><%=eb.getQlf()%></td>
		</tr>
	</table>
</center>
<%
	}
%>


<a href='input.html'>Home</a>
