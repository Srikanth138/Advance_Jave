<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body class="container bg-warning">
	<div class="text text-center text-danger">
		<h1 style="color: green; text-align: center;">Welcome to Employer</h1>	
		<br></br>CheckTheSalaryDetails <a href=<% request.getRequestDispatcher("/jsp/EmployerRetrivejsp.jsp").include( request, response); %> >Click </a> <br></br>
<%-- 		<br></br>CheckTheSalaryDetails <a href=<% request.getRequestDispatcher("/jsp/EmployerRetrivejsp.jsp").forward( request, response); %> >Click </a> <br></br> --%>
			
		UpdateThe Employees Details <a href="update.jsp">Update</a> <br></br>
		DeleteThe Employee Record <a href="delete.jsp">Delete</a>
	</div>
</body>
</html>