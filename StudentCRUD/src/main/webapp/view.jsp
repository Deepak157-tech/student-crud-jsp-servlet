<%@ page import="java.sql.*" %>
<%@ page import="com.studentcrud.DBConnection" %>

<h2>Student List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%
Connection con = null;
Statement st = null;
ResultSet rs = null;

try {

    con = DBConnection.getConnection();

    st = con.createStatement();

    rs = st.executeQuery("SELECT * FROM students");

    while(rs.next()){
%>

<tr>

<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getString("email") %></td>
<td><%= rs.getString("course") %></td>

<td>
<a href="edit.jsp?id=<%= rs.getInt("id") %>">Edit</a>
</td>

<td>
<a href="deleteStudent?id=<%= rs.getInt("id") %>">Delete</a>
</td>

</tr>

<%
    }

} catch(Exception e){
    out.println("Database Error: " + e.getMessage());
}
%>

</table>