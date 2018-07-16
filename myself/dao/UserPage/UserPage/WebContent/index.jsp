<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UserInfo">
User Id<input name="uid"><br>
User Name<input name="name"><br>
User Salary<input name="salary"><br>
Select Operation
<select name="op">
<option value="add">Add</option>
<option value="remove">Remove</option>
<option value="find">Search</option>
<option value="update">Update</option>
<option value="showall">ShowAll</option>
</select>
<input type="submit">
</form>

</body>
</html>