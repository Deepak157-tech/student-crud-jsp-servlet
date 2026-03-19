<%@ page import="java.sql.*" %>
<%@ page import="com.studentcrud.DBConnection" %>
<%
    String sid = request.getParameter("id");
    if (sid == null || sid.isEmpty()) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
    int id = Integer.parseInt(sid);
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id=?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (!rs.next()) {
        out.println("No student found!");
        con.close();
        return;
    }
%>
<html>
<body>
<h2>Edit Student</h2>
<form action="<%=request.getContextPath()%>/editStudent" method="post">
    <input type="hidden" name="id" value="<%=rs.getInt("id")%>">
    Name:   <input type="text" name="name"   value="<%=rs.getString("name")%>"><br><br>
    Email:  <input type="text" name="email"  value="<%=rs.getString("email")%>"><br><br>
    Course: <input type="text" name="course" value="<%=rs.getString("course")%>"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
<%
    con.close();
%>