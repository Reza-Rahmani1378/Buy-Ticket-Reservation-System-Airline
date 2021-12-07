<%@ page import="ir.maktab.home_work17.domain.User" %>
<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%User user = SecurityContext.getActiveUser();%>
<html>
<head>
	<title>Admin workbench</title>
</head>
<body>
<h1>Admin Main Menu</h1>
<div class="center">
	<h2>
	<%
		out.print(" Welcome to your Workbench Mr/Miss" + "| " + user.getFirst_name() +" " + user.getLast_name()
				+ " |");%>
	</h2>
</div>
<div id='divMenu'>
	<ul>
		<li><a href='profileCustomer.jsp'>Your Profile and Edition</a></li>
		
		<li><a href='buyTicket.jsp'>Buy Ticket</a></li>
		
		<li><a href='ticketOfCustomers.jsp'>Show Your Tickets</a></li>
		
		<li><a href='Logout'>Log out</a></li>
	
	</ul>

</div>

</body>
</html>
