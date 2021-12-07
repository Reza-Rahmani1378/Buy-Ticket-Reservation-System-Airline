<%@ page import="java.time.LocalDate" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="ir.maktab.home_work17.domain.DiscountCode" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%
	String discountCode = request.getParameter("discountCode");
    Double percentage = Double.parseDouble(request.getParameter("percentageValue"));
	LocalDate expireDateCode = LocalDate.parse(request.getParameter("expireDateCode"));
	ApplicationContext.getDiscountCodeService().save(
            new DiscountCode(
                    discountCode,
					percentage,
					expireDateCode
			)
	);
%>
<html>
<head>
	<title>Save Discount Code</title>
	
	
</head>

	<div class="center">
		<h2>Discount Code added successfully.</h2>
		<p>
			<a href="admin_workbench.jsp">Back to workbench</a>
		</p>
	</div>
<body>

</body>
</html>
