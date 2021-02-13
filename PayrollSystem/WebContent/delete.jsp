<!-- register.jsp -->

<h1 style="color: red; text-align: center;">Enter Employee ID Delete
	Details</h1>
<br>
<br>
<form method="post" action="employerControll">

	<table align="center" bgcolor="cyan">
		<tr>
			<th>EnterID ::</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>EnterName ::</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><input type="submit" value="delete"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
	</table>
	<input type="hidden" name="source" value="delete" />
</form>