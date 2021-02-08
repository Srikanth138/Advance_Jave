<!-- register.jsp -->

<h1 style="color: red; text-align: center;">Enter Employee Details</h1>
<br>
<br>


<form method="post" action="registerService">

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
			<th>EnterGender ::</th>
			<td><input type="radio" name="gender" value="Male" checked>Male
				&nbsp;&nbsp; <input type="radio" name="gender" value="FeMale">FeMale
				&nbsp;&nbsp;<input type="radio" name="gender" value="FeMale">Other</td>
		</tr>

		<tr>
			<th>Salary::</th>
			<td><input type="text" name="salary" min="1000" max="100000"></td>
		</tr>

		<!-- <tr>
			<th>DateOfBirth::</th>
			<td><input type="date" name="dob" min="1990-01-01"
				max="2021-01-30" /></td>

		</tr>
		<tr>
			<th>DateOfJoin::</th>
			<td><input type="month" name="doj" min="2021-01-11"
				max="2021-02-25"></td>
		</tr> -->

		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="cancel"></td>
	</table>

</form>