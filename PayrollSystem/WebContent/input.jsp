<!-- input.jsp -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<script type="text/javascript" src="js/validate.js"></script>
</head>

<body bgcolor="yellow">
	<h1 style="color: red; text-align: center;">Employee Login page</h1>
	<center>
		<img alt="blank" src="image/backimg.jpg" width="400" height="200">
	</center>

	<form action="employer" method="post" name="frm"
		onsubmit="return validate()">
		<!-- onclick="return validate()"  return will true is go for servlet class (OR) false sty in html page.-->
		<table bgcolor="cyan" align="center">
			<tr>
				<th>Enter Your name</th>
				<td><input type="text" name="name"><br />
				<span style="color: red" id="pname"></span></td>
			</tr>

			<tr>
				<th>Enter Your ID</th>
				<td><input type="text" name="id"><br />
				<span style="color: red" id="pid"></span></td>
			</tr>

			<tr>
				<th>Select Your Gender</th>
				<td><input type="radio" name="gender" value="Male"
					checked="checked">Male <input type="radio" name="gender"
					value="FeMale">FeMale</td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="submit"></td>
				<td><input type="reset" name="reset" value="Reset"></td>
			</tr>
		</table>
		<input type="hidden" name="vflag" value="no">

	</form>

</body>
</html>