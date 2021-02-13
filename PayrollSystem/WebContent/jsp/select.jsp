<!-- select.jsp -->
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="com.sri.dao.EmployerDAO,com.sri.bo.EmployerBO"%>

<%
ArrayList<EmployerBO> al = null;
al = (ArrayList<EmployerBO>) application.getAttribute("name");

if (al.isEmpty()) {
	out.println(" <h1 style='color:red; text-align: center;'>PLEASE ENTER VALID 'ID' AND 'NAME'....</h1>");
	out.println("<br></br><a href='input.jsp'>home<a/>");
} 
else {
	try {
%>
<h1>hello</h1>
<center>Earning's</center>
<br>
<table bgcolor="cyan" align="center" border="2">
	<tr style="width: 914px;">
		<th style="width: 90px;">Name</th>
		<th style="width: 150px;">BasicSalary</th>
		<th style="width: 50px;">HRA</th>
		<th style="width: 150px;">TravellingAllowance</th>
		<th style="width: 150px;">MedicalAllowance</th>
		<th style="width: 150px;">OtherAllowance</th>
		<th style="width: 90px;">Salary</th>
	</tr>
</table>
<%
for (EmployerBO er : al) {
%>
<table bgcolor="cyan" align="center" border="2">
	<tr style="width: 914px;">
		<td style="width: 90px;"><%=er.getName()%></td>
		<td style="width: 150px;"><%=er.getSalary()%></td>
		<%
		er.setCTC(er.getSalary() * 0.10);
		%>
		<td style="width: 50px;"><%=er.getCTC()%></td>
		<td style="width: 150px;"><%=er.getSalary() * 0.15%></td>
		<td style="width: 150px;"><%=er.getSalary() * 0.10%></td>
		<td style="width: 150px;"><%=er.getSalary() * 0.10%></td>
		<td style="width: 90px;">
			<%
			out.println(er.getSalary() + er.getCTC() + (er.getSalary() * 0.15) + (er.getSalary() * 0.10) + (er.getSalary() * 0.10));
			// 			al.forEach(System.out::print);
			%>
		</td>

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
		<th style="width: 90px;">Name</th>
		<th style="width: 150px;">ProvidentFund (PF)</th>
		<th style="width: 150px;">LossofPay(LOP)</th>
		<th style="width: 150px;">Insurance Premium</th>
		<th style="width: 100px;">TDS</th>
		<th style="width: 90px;">Deductions</th>
	</tr>
</table>
<%
for (EmployerBO er : al) {
%>
<table bgcolor="green" align="center" border="2">
	<tr style="width: 914px;">
		<td style="width: 90px;"><%=er.getName()%></td>
		<%
		er.setCTC(er.getSalary() * 0.10);
		%>
		<td style="width: 150px;"><%=er.getCTC()%></td>
		<td style="width: 150px;"><%=er.getSalary() * 0.13%></td>
		<td style="width: 150px;"><%=er.getSalary() * 0.15%></td>
		<td style="width: 100px;"><%=er.getSalary() * 0.10%></td>

		<td style="width: 90px;">
			<%
			out.println(er.getCTC() + (er.getSalary() * 0.13) + (er.getSalary() * 0.15) + (er.getSalary() * 0.10));
			%>
		</td>
	</tr>
</table>
<%
}
out.println("NetSalary ::<br>");
ArrayList<EmployerBO> ll = new ArrayList<EmployerBO>();

for (EmployerBO aa : al) {
out.println(aa.getName() + " : "
		+ ((aa.getSalary() + (aa.getSalary() * 0.10) + (aa.getSalary() * 0.15) + (aa.getSalary() * 0.10)
		+ (aa.getSalary() * 0.10))
		- (aa.getCTC() + (aa.getSalary() * 0.13) + (aa.getSalary() * 0.15) + (aa.getSalary() * 0.10)))
		+ "<br>");

ll.add(aa);
}
} //try 
catch (Exception e) {
e.printStackTrace();
}

out.println("</br></br><a href='logout.jsp'>LogOut<a/>");
}
%>




