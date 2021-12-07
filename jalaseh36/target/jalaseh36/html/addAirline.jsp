
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<html>
<head>
	<title>Add Airline</title>
	<link rel="stylesheet" href="../style/style.css">
</head>

<div class="center">
	<h2> Add Airline</h2>
</div>
<form action="saveAirline.jsp">
	<div class="center">
		<table>
			<tr>
			<div class="td-right">
				<td>
					<label for="airline">Airline Name</label>
				</td>
			</div>
			<div class="td-left">
				<td>
					<input type="text" required = required name="airline" id="airline">
				</td>
			</div>
			</tr>
			<tr>
				<div class="td-right">
					<td>
						<label for="airline_tel">Airline Phone</label>
					</td>
				</div>
				<div class="td-left">
					<td>
						<input type="text" required = required name="airline_tel" id="airline_tel">
					</td>
				</div>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Add Airline">
				</td>
			</tr>
		</table>
	</div>

</form>


<body>

</body>
</html>
