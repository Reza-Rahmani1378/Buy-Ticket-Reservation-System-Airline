<%@ page import="ir.maktab.home_work17.domain.AirLine" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="ir.maktab.home_work17.domain.AirLineOperator" %>
<%@ page import="ir.maktab.home_work17.domain.enumeration.UserType" %>

<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String nationalCode = request.getParameter("nationalCode");
	String airlineName = request.getParameter("airlineName");
	AirLine airLine = ApplicationContext.getAirLineService().findByName(airlineName);
	AirLineOperator airLineOperator = new AirLineOperator(
            firstName,
			lastName,
			username,
			nationalCode,
			password,
			UserType.AIRLINE_OPERATOR,
			true
	);
    airLine.setAirLineOperator(airLineOperator);
    airLineOperator.setAirLine(airLine);
    ApplicationContext.getAirLineService().save(airLine);
%>
<html>
<head>
	<title>Save AirlineOperator</title>
	<link rel="stylesheet" href="../style/style.css">
</head>
<body>
	<div class="center">
		<h2>Airline Operator Added Successfully...</h2>
	</div>
</body>
</html>
