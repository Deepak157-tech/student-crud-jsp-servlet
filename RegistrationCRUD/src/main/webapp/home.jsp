<%
String user = (String) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
}
%>

<html>
<body>

<h2>Welcome <%= user %></h2>

<a href="LogoutServlet">Logout</a>

</body>
</html>