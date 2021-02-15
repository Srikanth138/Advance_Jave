<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="text text-center text-danger">
	
		<h1 style="color: green; text-align: center;">Welcome to Employees</h1>
		
		
		
		<br></br>CheckTheSalaryDetails <a href=<% request.getRequestDispatcher("/jsp/retrivejsp.jsp").include( request, response); %> >Click </a> <br></br>
<%-- 		<br></br>CheckTheSalaryDetails <a href=<% request.getRequestDispatcher("/jsp/retrivejsp.jsp").forward( request, response); %> >Click </a> <br></br> --%>
				
		UpdateThe Employees Details <a href="update.jsp">Update</a> <br></br>
	</div>
</body>
</html>