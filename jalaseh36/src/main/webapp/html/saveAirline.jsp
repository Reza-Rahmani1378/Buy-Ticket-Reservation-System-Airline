<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="ir.maktab.home_work17.domain.AirLine" %>

<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%
	String airline_name = request.getParameter("airline");
    String airline_tel = request.getParameter("airline_tel");
	ApplicationContext.getAirLineService().save(
            new AirLine(
                    airline_name,airline_tel,null
			)
	);
%>
<html>
<head>
	<title>Saved Airline</title>
	<link rel="stylesheet" href="../style/style.css">
</head>
<body>
	<h2>Airline added successfully...</h2>
	<p>
		<a href="admin_workbench.jsp" > Back to workbench...</a>
	</p>

</body>
</html>
