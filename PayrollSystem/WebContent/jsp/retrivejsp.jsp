<!-- select.jsp -->
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="com.sri.dto.EmployerDTO"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<%
	ArrayList<EmployerDTO> al = (ArrayList<EmployerDTO>) request.getAttribute("dto");

	if (al.isEmpty()) {
		out.println(" <h1 style='color:red; text-align: center;'>PLEASE ENTER VALID 'ID' AND 'NAME'....</h1>");
		out.println("<br></br><a href='input.jsp'>home<a/>");
	} else {
		try {
	%>
	<h1 class="text text-center">Earning's</h1>
	<br>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr style="width: 914px;">
				<th style="width: 150px;">Name</th>
				<th style="width: 150px;">Salary</th>
				<th style="width: 150px;">HRA</th>
				<th style="width: 150px;">TravellingAllowance</th>
				<th style="width: 150px;">MedicalAllowance</th>
				<th style="width: 150px;">OtherAllowance</th>
				<th style="width: 150px;">BasicSalary</th>
			</tr>
		</thead>
	</table>
	<%
	for (EmployerDTO er : al) {
	%>
	<table class="table table-striped">
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

	<h1 class="text text-center">Deductions</h1>
	<br>
	<table class="table table-striped">
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
	for (EmployerDTO dto : al) {
	%>
	<table class="table table-striped">
		<tr style="width: 914px;">
			<td style="width: 150px;"><%=dto.getName()%></td>
			<td style="width: 150px;"><%=dto.getCTC()%></td>
			<td style="width: 150px;"><%=dto.getHRA()%></td>
			<td style="width: 150px;"><%=dto.getTA()%></td>
			<td style="width: 150px;"><%=dto.getOA()%></td>
			<td style="width: 150px;"><%=dto.getDTD()%></td>
		</tr>
	</table>
	<%
	}
	out.println("NetSalary ::<br>");

	for (EmployerDTO aa : al) {

	out.println(aa.getNetSalary() + "<br>");
	}
	} //try 

	catch (Exception e) {
	e.printStackTrace();
	}

	out.println("</br></br><a href='logout.jsp'>LogOut<a/>");
	}
	%>
</body>
</html>