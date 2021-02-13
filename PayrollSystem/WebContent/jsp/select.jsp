<!-- select.jsp -->
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="com.sri.dto.EmployerDTO"%>

<%
ArrayList<EmployerDTO> al = (ArrayList<EmployerDTO>) application.getAttribute("dto");

if (al.isEmpty()) {
	out.println(" <h1 style='color:red; text-align: center;'>PLEASE ENTER VALID 'ID' AND 'NAME'....</h1>");
	out.println("<br></br><a href='input.jsp'>home<a/>");
} else {
	try {
%>
<center>Earning's</center>
<br>
<table bgcolor="cyan" align="center" border="2">
	<tr style="width: 914px;">
		<th style="width: 150px;">Name</th>
		<th style="width: 150px;">Salary</th>
		<th style="width: 150px;">HRA</th>
		<th style="width: 150px;">TravellingAllowance</th>
		<th style="width: 150px;">MedicalAllowance</th>
		<th style="width: 150px;">OtherAllowance</th>
		<th style="width: 150px;">Salary</th>
	</tr>
</table>
<%
for (EmployerDTO er : al) {
%>
<table bgcolor="cyan" align="center" border="2">
	<tr style="width: 914px;">
		<td style="width: 150px;"><%=er.getName()%></td>
		<td style="width: 150px;"><%=er.getSalary()%></td>
		<td style="width: 150px;"><%=er.getHRA()%></td>
		<td style="width: 150px;"><%=er.getTA()%></td>
		<td style="width: 150px;"><%=er.getMA()%></td>
		<td style="width: 150px;"><%=er.getOA()%></td>
		<td style="width: 150px;"><%=er.getSalary()%></td>
	</tr>
</table>
<%
}
%>
<br></br>

<center>Deductions</center>
<br>
<table bgcolor="Green" align="center" border="2">
	<tr style="width: 914px;">
		<th style="width: 150px;">Name</th>
		<th style="width: 150px;">ProvidentFund (PF)</th>
		<th style="width: 150px;">LossofPay(LOP)</th>
		<th style="width: 150px;">Insurance Premium</th>
		<th style="width: 150px;">TDS</th>
		<th style="width: 150px;">Deductions</th>
	</tr>
</table>
<%
for (EmployerDTO er : al) {
%>
<table bgcolor="green" align="center" border="2">
	<tr style="width: 914px;">
		<td style="width: 150px;"><%=er.getName()%></td>
		<td style="width: 150px;"><%=er.getCTC()%></td>
		<td style="width: 150px;"><%=er.getHRA()%></td>
		<td style="width: 150px;"><%=er.getTA()%></td>
		<td style="width: 150px;"><%=er.getOA()%></td>
		<td style="width: 150px;"><%=er.getDTD() %></td>
	</tr>
</table>
<%
}
out.println("NetSalary ::<br>"); 

for (EmployerDTO aa : al) {
 out.println(aa.getName() + " : " + ((aa.getSalary() + aa.getCTC() + aa.getHRA() + aa.getMA() + aa.getOA())
 		- (aa.getCTC() + aa.getHRA() + aa.getMA() + aa.getOA())) + "<br>");
 }

} //try 

catch (Exception e) {
e.printStackTrace();
}

out.println("</br></br><a href='logout.jsp'>LogOut<a/>");
}
%>




