<%@ page import="com.emp.Employee" %>

<%
Employee e = (Employee) request.getAttribute("emp");
%>

<h2>Edit Employee</h2>

<form action="updateEmployee" method="post">

    <input type="hidden" name="id" value="<%=e.getEmpId()%>">

    Name: <input type="text" name="name" value="<%=e.getEmpName()%>"><br><br>

    Department: <input type="text" name="department" value="<%=e.getDepartment()%>"><br><br>

    Salary: <input type="text" name="salary" value="<%=e.getSalary()%>"><br><br>

    <input type="submit" value="Update">

</form>