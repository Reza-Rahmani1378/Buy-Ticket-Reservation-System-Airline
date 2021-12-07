<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.home_work17.domain.AirLine" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%
	List<AirLine> airLines = ApplicationContext.getAirLineService().findAll();
	
	out.println(
			"""
					<!DOCTYPE html>
					<html lang='en'>
					<head>
					    <meta charset='UTF-8'>
					    <link rel='stylesheet' href='style/style.css'>
					</head>
					<body>
					"""
	);
	
	out.println(
			"""
					<h2 align='center'>Add New Operator</h2>
					    <form action='saveAirlineOperator.jsp'>
					        <table align='center'>\s
								<tr>
					                <td align='right'>
										<label for='firstName'>FirstName : </label>
									</td>
					                <td align='left'><input type='text' name='firstName' id='firstName'  required='required' ></td></td>
					            </tr>
								<tr>
					                <td align='right'>
										<label for='lastName'>LastName : </label>
									</td>
					                <td align='left'><input type='text' name='lastName' id='lastName'  required='required' ></td></td>
					            </tr>
					            <tr>
					                <td align='right'>
										<label for='code'>National Code : </label>
									</td>
					                <td align='left'><input type='text' name='nationalCode' id='code' placeholder='Ten Digits' required='required' pattern='[0-9]{10}'></td></td>
					            </tr>
					            <tr>
					                <td align='right'><label for='u_name'>Username : </label></td>
					                <td align='left'><input type='text' name='username' id='u_name' required='required' pattern='.+'></td>
					            </tr>
					            <tr>
					                <td align='right'><label for='password'>Password : </label></td>
					                <td align='left'><input type='password' name='password' id='password' required='required' pattern='.+'></td>
					            </tr>
					            <tr>
					                <td align='right'><label for='airline'>Airline : </label></td>
					                <td align='left'>
					                    <select name='airlineName' id='airline'>
					"""
	);
	
	for (AirLine airline : airLines) {
		out.println(
				"<option value='" + airline.getName() + "'>" + airline.getName() + "</option>"
		);
	}
	out.println(
			"""
					                </select>
					            </td>
					        </tr>
					        <tr>
					            <td></td>
					            <td><input type='submit' value='Add Operator'></td>
					        </tr>
					    </table>
					</form>""".indent(5)
	);
	
	out.println(
			"</body>\n" +
					"</html>"
	);
%>