<%@ page import="ir.maktab.home_work17.domain.Customer" %>
<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %>
<%@ page import="ir.maktab.home_work17.domain.Ticket" %>
<%@ page import="java.util.Set" %>
<%

Customer customer = (Customer) SecurityContext.getActiveUser();
Set<Ticket> tickets = customer.getTickets();
%>
<%
	if (tickets.isEmpty()){
        out.println(
				"""
						<!DOCTYPE html>
						<html lang='en'>
						<head>
						<meta charset='UTF-8'>
						<link rel='stylesheet' href='style/style.css'>
						</head>
						<body>
						<h2> You don't have tickets...</h2>
						<p>
						<a href='customer_workbench.jsp' class='underline'>Return to Main Menu</a>
						</p>
						</body>
						</html>"""
		);
  
	}
	
	
%>

<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8'>
<link rel='stylesheet' href='../style/style.css'>
	<title></title>
</head>
<body>
    <h2> Your Tickets </h2>
<%
	for (Ticket ticket : tickets) {
		
		out.println(
				"<hr>\n" +
						"    <p>\n" +
						"        <table align='center'>\n" +
						"            <tr>\n" +
						"                <td align='right'>Airline : " + ticket.getAir_line().getName() + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"                <td align='right'>From : " + ticket.getStart_point() + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"                <td align='right'>To : " + ticket.getEnd_point()  + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"                <td align='right'>Price : " + ticket.getPrice_ticket() + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"                <td align='right'>Date : " + ticket.getDate() + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"                <td align='right'>Time : " + ticket.getTime() + "</td>\n" +
						"                <td></td>\n" +
						"            </tr>\n" +
						"        </table><br><br>\n" +
						"    </p>\n" +
						"    <p>\n" +
						"        <a href='customer_workbench.jsp' class='underline'>Return to Main Menu</a>\n" +
						"    </p>\n" +
						"    <hr>"
		);
		
		
	}
%>
</body>
</html>
