<%@ page import="ir.maktab.home_work17.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/12/21
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% User user = (User) session.getAttribute("logUser");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>

    <body>
    <h1> Welcome, <%= user.getFirst_name() + user.getLast_name() %></h1>
    <h3>Your Account ID: <%= user.getId() %> </h3>
    <h3>Your Username: <%= user.getUsername() %> </h3>
    <h3>Your UserType: <%= user.getUserType().name() %> </h3>
    <h3>Your Password: <%= user.getPassword() %></h3>

    <button><a href="LogoutServlet">Log Out</a></button>
    </body>

    
    
    


</html>
