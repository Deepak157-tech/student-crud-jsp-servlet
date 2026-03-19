<%@ page import="java.util.*,com.emp.Employee"%>

<h2>Employee List</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Dept</th><th>Salary</th><th>Action</th>
</tr>

<%
List<Employee> list = (List<Employee>) request.getAttribute("list");

for(Employee e : list){
%>

<tr>
<td><%=e.getEmpId()%></td>
<td><%=e.getEmpName()%></td>
<td><%=e.getDepartment()%></td>
<td><%=e.getSalary()%></td>
<td>
<a href="deleteEmployee?id=<%=e.getEmpId()%>">Delete</a>
</td>
</tr>

<%
}
%>

</table>