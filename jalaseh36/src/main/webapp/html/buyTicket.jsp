<%@ page import="ir.maktab.home_work17.domain.Customer" %>
<%@ page import="ir.maktab.home_work17.utility.SecurityContext" %>
<%@ page import="ir.maktab.home_work17.domain.Ticket" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.Duration" %>
<%@ page import="ir.maktab.home_work17.domain.DiscountCode" %>
<%@ page import="ir.maktab.home_work17.domain.dto.WalletChangeDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>


<%
	// we can log to wallet to if we needed can implement this feature in this part to...
	Customer customer = (Customer) SecurityContext.getActiveUser();
	String discountCode = request.getParameter("discountCode");
	long id = Long.parseLong(request.getParameter("ticket_id"));
	Ticket ticket = ApplicationContext.getTicketService().findById(id);
	Long valency = ticket.getValency();
	double price;
	double finalPrice;
	String result = "";
	
	try {
		if (LocalDate.now().equals(ticket.getDate())
				&& ticket.getTake_of_time().compareTo(LocalTime.now()) > 0
				&& Duration.between(LocalTime.now(), ticket.getTake_of_time()).toMinutes() < 60){
			price = (double)ticket.getPrice_ticket()/2;
			result += "50 Percent For Time,. ";
		} else {
			price = ticket.getPrice_ticket();
		}
		
		if (discountCode.isEmpty()){
			finalPrice = price;
		} else {
			DiscountCode discount = ApplicationContext.getDiscountCodeService().findDiscountCodeByCode(discountCode);
			finalPrice = price * ((100-discount.getDiscountPercent())/100);
			discount.getCustomers().add(customer);
			ApplicationContext.getDiscountCodeService().save(discount);
			result += discount.getDiscountPercent() + " Percent For Discount... ";
		}
		
		if (!customer.getTickets().isEmpty() && customer.getTickets().size()%10 == 0){
			finalPrice = 0;
			result = "Free Ticket can use...";
		}
		
		ticket.setValency(valency-1);
		WalletChangeDTO wct = new WalletChangeDTO(customer.getId() , (long) finalPrice, true );
        ApplicationContext.getCustomerService().isDecreaseWalletAmountWithBuyTicket(wct , ticket);
		customer.getTickets().add(ticket);
		ApplicationContext.getCustomerService().save(customer);
        ApplicationContext.getTicketService().save(ticket);
		out.println(
				"""
						<!DOCTYPE html>
						<html lang='en'>
						<head>
						    <meta charset='UTF-8'>
						    <link rel='stylesheet' href='style/style.css'>
						</head>
						<body>
						    <h2>you can buy this ticket successfully...</h2>
						""");
		if (!result.equals("")){
			out.println("    <h3 align='center'> Your Discounts : " + result + "</h3>");
		}
		out.println(
				"""
						    <p>
						        <a href='customer_workbench.jsp' class='underline'>Back to workbench...</a>
						    </p>
						</body>
						</html>"""
		);
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
						    <h2> wrong in complete...</h2>
						    <p>
						        <a href='customer_workbench.jsp' class='underline'>Back to workbench...</a>
						    </p>
						</body>
						</html>"""
		);
	}

%>
