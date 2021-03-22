<!-- select.jsp -->
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="com.sri.dto.EmployerDTO"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<%
		String source = (String) request.getAttribute("source");
		ArrayList<EmployerDTO> al = (ArrayList<EmployerDTO>) request.getAttribute("dto");

		if (al.isEmpty()) {
			out.println(" <h1 style='color:red; text-align: center;'>PLEASE ENTER VALID 'ID' AND 'NAME'....</h1>");
			out.println("<br></br><a href='input.jsp'><img src='image/home.jpg' hight=40 width=40 /><a/>");
		} else {
			try {
		%>
		<h1 class="text text-center">Earning's</h1>
		<br>
		<table
			class="table table-bordered table-center text-denger bg-success">
			<tr style="width: 914px;">
				<th style="width: 150px;">ID</th>
				<th style="width: 150px;">Name</th>
				<th style="width: 150px;">Salary</th>
				<th style="width: 150px;">HRA</th>
				<th style="width: 150px;">TravellingAllowance</th>
				<th style="width: 150px;">MedicalAllowance</th>
				<th style="width: 150px;">OtherAllowance</th>
				<th style="width: 150px;">BasicSalary</th>
			</tr>
		</table>
		<%
		for (EmployerDTO dto : al) {
		%>
		<table class="table table-striped table-center text-primary bg-link">
			<tr style="width: 914px;">
				<td style="width: 150px;"><%=dto.getId()%></td>
				<td style="width: 150px;"><%=dto.getName()%></td>
				<td style="width: 150px;"><%=dto.getSalary()%></td>
				<td style="width: 150px;"><%=dto.getHRA()%></td>
				<td style="width: 150px;"><%=dto.getTA()%></td>
				<td style="width: 150px;"><%=dto.getMA()%></td>
				<td style="width: 150px;"><%=dto.getOA()%></td>
				<td style="width: 150px;"><%=dto.getNetSalary()%></td>
			</tr>
		</table>
		<%
		}
		%>
		<br></br>

		<h1 class="text text-center">Deductions</h1>
		<br>
		<table class="table bg-warning">
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
		<table class="table bg-info ">
			<tr style="width: 914px;">
				<td style="width: 150px;"><%=dto.getName()%></td>
				<td style="width: 150px;"><%=dto.getPF()%></td>
				<td style="width: 150px;"><%=dto.getHRA()%></td>
				<td style="width: 150px;"><%=dto.getTA()%></td>
				<td style="width: 150px;"><%=dto.getOA()%></td>
				<td style="width: 150px;"><%=dto.getDTD()%></td>
			</tr>
		</table>
		<%
		}
		out.println("NetSalary ::<br>");
		for (EmployerDTO dto : al) {
		out.println(dto.getName() + " : " + dto.getSalary() + "<br>");
		}
		} //try 
		catch (Exception e) {
		e.printStackTrace();
		}
		out.println("<a href='logout.jsp?source=" + source + "'>Next_logOut<a/><br><br>");
		}
		%>

	</div>
</body>
</html>