<html>
<body>
<h2>Add Product</h2>

<form action="AddProductServlet" method="post">
    Name: <input type="text" name="product_name"><br>
    Price: <input type="text" name="price"><br>
    Quantity: <input type="text" name="quantity"><br>
    Category: <input type="text" name="category"><br>
    <input type="submit" value="Add Product">
</form>

<a href="viewProducts.jsp">View Products</a>

</body>
</html>