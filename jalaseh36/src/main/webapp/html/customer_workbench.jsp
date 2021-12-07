<%@ page import="ir.maktab.home_work17.domain.User" %>
<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = SecurityContext.getActiveUser();%>

<html>
<head>
<link rel="stylesheet" href='../style/style.css'>
	<title>Customer Workbench</title>
</head>

<body>
<h1>Customer Main Menu</h1>
<h2 align='center'>
	<%
		out.print(" Welcome to your Workbench Mr/Miss" + "| " + user.getFirst_name() +" " + user.getLast_name()
		+ " |");%>
</h2>
<div id='divMenu'>
	<ul>
		<li><a href='profileCustomer.jsp'>Your Profile and Edition</a></li>
		
		<li><a href='buyTicket.jsp'>Buy Ticket</a></li>
		
		<li><a href='ticketOfCustomers.jsp'>Show Your Tickets</a></li>
		
		<li><a href='signOut'>SIGN OUT</a></li>
	
	</ul>

</div>

</body>

</html>

