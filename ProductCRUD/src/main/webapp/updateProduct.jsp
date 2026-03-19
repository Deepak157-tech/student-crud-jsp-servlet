<%@ page import="java.sql.*" %>
<%@ page import="com.product.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id=?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
rs.next();
%>

<html>
<body>
<h2>Update Product</h2>

<form action="UpdateProductServlet" method="post">
    <input type="hidden" name="id" value="<%=id%>">

    Name: <input type="text" name="product_name" value="<%=rs.getString("product_name")%>"><br>
    Price: <input type="text" name="price" value="<%=rs.getDouble("price")%>"><br>
    Quantity: <input type="text" name="quantity" value="<%=rs.getInt("quantity")%>"><br>
    Category: <input type="text" name="category" value="<%=rs.getString("category")%>"><br>

    <input type="submit" value="Update">
</form>

</body>
</html>