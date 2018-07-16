
<%@page import="org.model.Employee"%>
<div style="background-color: yellow;color: blue;float: right; width: 50%">
Id is ${emp.id}<br>
Name is ${emp.name}<br>
Salary is ${emp.salary}<br>
</div>

<br><br><br><br><br>
<hr>

<div style="background-color: yellow;color: blue;float: right; width: 50%">
<% 
Employee e1=(Employee)request.getAttribute("emp");
%>

Id is  <%=e1.getId() %><br>
Name is <%=e1.getName() %><br>
Salary is <%=e1.getSalary() %><br>
</div>



