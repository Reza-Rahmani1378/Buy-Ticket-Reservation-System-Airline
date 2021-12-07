<%@ page import="ir.maktab.home_work17.domain.Customer" %>
<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="ir.maktab.home_work17.domain.dto.WalletChangeDTO" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	Customer customer = (Customer) SecurityContext.getActiveUser();
    Long cashAmount = Long.parseLong(request.getParameter("balance"));
	WalletChangeDTO walletChangeDTO = new WalletChangeDTO(customer.getId() , cashAmount , true);
    
    try {
        if (ApplicationContext.getCustomerService().isIncreaseWalletAmount(walletChangeDTO ,
				SecurityContext.getActiveUser().getUserType())) {
			out.println(
					"""
							<!DOCTYPE html>
							<html lang='en'>
							<head>
							    <meta charset='UTF-8'>
							    <link rel='stylesheet' href='style/style.css'>
							</head>
							<body>
							    <h2> Increase Amount Successfully...</h2>
							    <p>
							        <a href='customer_workbench.jsp' class='underline'>Back to workbench...</a>
							    </p>
							</body>
							</html>"""
			);
		}
  
	} catch (Exception e){
        e.printStackTrace();
		out.println(
				"""
						<!DOCTYPE html>
						<html lang='en'>
						<head>
						    <meta charset='UTF-8'>
						    <link rel='stylesheet' href='style/style.css'>
						</head>
						<body>
						    <h2>Accessed Denied..</h2>
						    <p>
						        <a href='customerMain' class='underline'>Back to workbench..</a>
						    </p>
						</body>
						</html>"""
		);
	}
%>

