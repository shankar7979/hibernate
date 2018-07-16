<%@taglib uri="http://www.springframework.org/tags/form"  
  prefix="form"%>
<html>
<head>
<style type="text/css">
.style1{
color: red; font-size: large;background-color: aqua;
}
</style>
</head>
<body>
<form:form action="cst_control_1" modelAttribute="cst"
 method="post">

Enter id <form:input path="id"/>
<form:errors path="id" cssClass="style1">
</form:errors>

<br>
Enter name <form:input path="name"/>
<form:errors path="name" cssClass="style1"/>
<br>
Enter age <form:input path="age"/>
<form:errors path="age" cssClass="style1"/>

<br>

Enter city <form:input path="city"/>
<form:errors path="city" cssClass="style1"/>

<br> 

Select States
<form:select path="state">
<form:options items="${state_name}"/>
</form:select>
<form:errors path="state" cssClass="style1"/>

<br>
Select Hobbies
<form:checkboxes items="${hobby_name}" path="hobbies"/>
<form:errors path="hobbies" cssClass="style1"/>

<br>
Select gender
<form:radiobuttons items="${gender_name}" path="gender"/>
<input type="submit" value="Login">
<form:errors path="gender" cssClass="style1"/>

</form:form>
</body>
</html>