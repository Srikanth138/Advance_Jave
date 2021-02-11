<!-- update.jsp -->
<h1 style="color: red; text-align: center;">Enter Employee Update Details</h1>
<br>
<br>
<form method="post" action="updateService">

	<table align="center" bgcolor="cyan">
		<tr>
			<th>EnterID ::</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>EnterName ::</th>
			<td><input type="text" name="name"></td>
		</tr>
			<th>Salary::</th>
			<td><input type="text" name="salary" min="1000" max="100000"></td>
		</tr>

		<tr>
			<td><input type="submit" value="update"></td>
			<td><input type="reset" value="cancel"></td>
	</table>
	<input type="hidden" name="source" value="update" />
</form>