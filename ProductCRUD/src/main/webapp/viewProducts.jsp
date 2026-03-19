<%@ page import="java.sql.*" %>
<%@ page import="com.product.DBConnection" %>

<html>
<body>
<h2>Product List</h2>

<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Price</th>
    <th>Quantity</th><th>Category</th><th>Action</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM products");

while(rs.next()){
%>
<tr>
<td><%=rs.getInt("product_id")%></td>
<td><%=rs.getString("product_name")%></td>
<td><%=rs.getDouble("price")%></td>
<td><%=rs.getInt("quantity")%></td>
<td><%=rs.getString("category")%></td>

<td>
<a href="deleteProduct?product_id=<%=rs.getInt("product_id")%>">Delete</a>
<a href="updateProduct.jsp?id=<%=rs.getInt("product_id")%>">Update</a>
</td>

</tr>
<%
}
%>

</table>

<a href="AddProduct.jsp">Add New Product</a>

</body>
</html>