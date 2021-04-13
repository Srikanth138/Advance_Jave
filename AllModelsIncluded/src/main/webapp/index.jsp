<html>
<head>
<title>Welcome page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>

<body>
	<div class="container" align="center">
		<h1 style="color: gray;">Welcome to our first page</h1>

		<form method="post" action="welcome">
			<table class="container"
				style="color: red; text-align: left; background: aqua;">
				<tr>
					<td>Enter A Name ::</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Enter A Password::</td>
					<td><input type="password" name="pwd"></td>
				</tr>

				<tr>

					<td colspan="2" align="center"><input type="submit"
						name="submit" value="submit"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>