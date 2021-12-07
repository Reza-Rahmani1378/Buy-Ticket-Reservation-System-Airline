<%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<html>
<head>
	<title>Choose Start and End Point</title>
	<link rel="stylesheet" href="../style/style.css">
</head>
<body>
	<h2>Start and End Point</h2>
	<br>
	<form action="chooseTicket.jsp">
		<table align="center">
			<tr>
				<td>
					<label for="start" >From :</label>
					<br>
					<select name="start" id="start" >
						<option value="Tehran">Tehran</option>
						<option value="Mashhad">Mashhad</option>
						<option value="Ahvaz">Ahvaz</option>
						<option value="Shiraz">Shiraz</option>
						<option value="Kish">Kish</option>
						<option value="Esfahan">Esfahan</option>
						<option value="Tabriz">Tabriz</option>
					</select>
					<br>
					<label for="end" >To :</label>
					<br>
					<select name="end" id="end" >
						<option value="Tehran">Tehran</option>
						<option value="Mashhad">Mashhad</option>
						<option value="Ahvaz">Ahvaz</option>
						<option value="Shiraz">Shiraz</option>
						<option value="Kish">Kish</option>
						<option value="Esfahan">Esfahan</option>
						<option value="Tabriz">Tabriz</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Search">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>
