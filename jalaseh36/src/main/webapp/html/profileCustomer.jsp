<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %>
<%@ page import="ir.maktab.home_work17.domain.Customer" %>

<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Customer customer = (Customer) SecurityContext.getActiveUser();
%>

<!DOCTYPE html>
<html>
	<head>
		<title>Edit information</title>
		<link rel="stylesheet" href="../style/style.css">
	</head>

	<body>
	<div class="custom">
		<h2> Profile </h2>
		<p>
		     <%
				 out.println("Your username is :" + customer.getUsername());
			 %>
			<br>
		    </p>
	    <h4>edit username or edit password</h4>
	    <form action='changeUsername.jsp'>
		       <table>
			            <tr>
				                <div class="td-right">
									<td><label for='username'>New Username : </label></td>
								</div>
				                <div class="td-left">
									<td><input type='text' required='required' pattern='.+' name='username' id='username'></td>
								</div>
				            </tr>
			            <tr>
				                <td></td>
				                <div class="center">
									<td><input type='submit' value='New Username Submit'></td>
								</div>
				            </tr>
			        </table>
		    </form><br>
	   <form action='changePassword.jsp'>
		        <table>
			            <tr>
				                <div class="td-right">
									<td><label for='password'>New Password : </label></td>
								</div>
				                <div class="td-left">
									<td><input type='password' required='required'  name='password' id='password'></td>
								</div>
				            </tr>
			            <tr>
				                <td></td>
				                <div class="center">
									<td><input type='submit' value='New Password Submit'></td>
								</div>
				            </tr>
			        </table>
		    </form><br>
	    <form action='increaseWallet.jsp'>
		        <table>
			            <tr>
				                <div class="td-right">
									<td><label for='balance'>Balance Increase Amount : </label></td>
								</div>
				                <div class="td-left">
									<td><input type='number' required='required' min='1' name='balance' id='balance'></td>
								</div>
				            </tr>
			            <tr>
				                <td></td>
				                <div class="center">
									<td><input type='submit' value='Balance Increase Submit'></td>
								</div>
				            </tr>
			        </table>
		    </form><br>
	    <p>
		        <a href='customer_workbench.jsp' class='underline'>Back to Main Menu</a>
		    </p>
	</div>
	</body>

</html>
