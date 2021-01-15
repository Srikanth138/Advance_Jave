

<h1 style="color: red; text-align: center;">Enter Employee Details</h1>
<br>
<br>
<br>


<form method="post" action="registerService">

	<table align="center" bgcolor="cyan">
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
			<th>PanCardNO ::</th>
			<td><input type="text" name="pan"></td>
		</tr>

		<tr>
			<th>DateOfBirth::</th>
			<td><input type="date" name="dob" min="1990-01-01"
				max="2021-01-30" /></td>

		</tr>
		<tr>
			<th>DateOfJoin::</th>
			<td><input type="date" name="doj" min="2021-01-11"
				max="2021-02-25"></td>
		</tr>
		<tr>
			<td>Select qualification ::</td>
			<td><select name="qlf">
					<option value="MCA" selected="selected">MCA</option>
					<option value="BSC">BSC</option>
					<option value="MBA">MBA</option>
			</select></td>
		</tr>

		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="cancel"></td>
	</table>

</form>