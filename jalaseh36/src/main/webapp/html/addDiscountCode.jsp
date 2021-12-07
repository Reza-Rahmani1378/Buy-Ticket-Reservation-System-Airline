<%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<html>
<head>
	<title>Add Discount Code</title>
	<link rel="stylesheet" href="../style/style.css">
</head>
<body>
	<div class="center">
		<h2>Add Discount Code</h2>
			<form action="saveDiscountCode.jsp">
				<table>
					<tr>
						<div class="td-right">
							<td>
							<label for="discount_code">Discount Code:</label>
							</td>
						</div>
						<div class="td-left">
							<td>
								<input type="text" name="discountCode" id="discount_code" required = required>
							</td>
						</div>
					</tr>
					
					<tr>
						<div class="td-right">
							<td>
								<label for="percentage">Percentage :</label>
							</td>
						</div>
						<div class="td-left">
							<td>
								<input type="number" name="percentageValue" id="percentage" required = required min="1" max="100">
							</td>
						</div>
					</tr>
					
					<tr>
						<div class="td-right">
							<td>
								<label for="expire_date">Expire Date Code:</label>
							</td>
						</div>
						<div class="td-left">
							<td>
								<input type="date" name="expireDateCode" id="expire_date" required = required>
							</td>
						</div>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Add Discount Code">
						</td>
					</tr>
				</table>
			</form>
	</div>

</body>
</html>
