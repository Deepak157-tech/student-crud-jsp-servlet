<%@ page import="java.sql.*" %>
<%@ page import="com.studentcrud.DBConnection" %>

<h2>Add Student</h2>

<form action="addStudent" method="post">

Name:
<input type="text" name="name"><br><br>

Email:
<input type="text" name="email"><br><br>

Course:
<input type="text" name="course"><br><br>

<input type="submit" value="Add Student">

</form>