<%@ page import="java.sql.*" %>
<%@ page import="com.library.DBConnection" %>

<html>
<body>
<h2>Book List</h2>

<form action="SearchBookServlet" method="get">
Search by Title: <input type="text" name="title">
<input type="submit" value="Search">
</form>

<table border="1">
<tr>
<th>ID</th><th>Title</th><th>Author</th>
<th>Category</th><th>Quantity</th><th>Action</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM books");

while(rs.next()){
%>

<tr>
<td><%=rs.getInt("book_id")%></td>
<td><%=rs.getString("title")%></td>
<td><%=rs.getString("author")%></td>
<td><%=rs.getString("category")%></td>
<td><%=rs.getInt("quantity")%></td>

<td>
<a href="DeleteBookServlet?id=<%=rs.getInt("book_id")%>">Delete</a>
<a href="updateBook.jsp?id=<%=rs.getInt("book_id")%>">Update</a>
</td>

</tr>

<%
}
%>

</table>

<a href="addBook.jsp">Add Book</a>

</body>
</html>