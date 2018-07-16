<html>
<body bgcolor=pink>
	<form action="MySession">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type=text name="id"></td>
			</tr>

			<tr>
				<td>name</td>
				<td><input type=text name="name"></td>
			</tr>

			<tr>
				<td>select</td>
				<td><select name=combo1>
						<option value="add">add
						<option value="find">find
						<option value="update">update
						<option value="delete">delete
						<option value="findall">findall
				</select></td>
			</tr>

			<tr>
				<td><input type=submit value="ok">
				<td><input type=reset value="clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>