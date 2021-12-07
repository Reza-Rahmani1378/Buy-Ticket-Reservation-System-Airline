<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.home_work17.domain.Ticket" %>
<%@ page import="ir.maktab.home_work17.utility.ApplicationContext" %>
<%@ page import="ir.maktab.home_work17.domain.dto.TicketDto" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.Duration" %><%--
  Created by IntelliJ IDEA.
  User: anonymous
  Date: 10/13/21
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<%
  String start = request.getParameter("start");
  String end = request.getParameter("end");
  TicketDto ticketDto = new TicketDto(start , end);
  List<Ticket> tickets = ApplicationContext.getTicketService().searchByFromAndTo(ticketDto);
  
  
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
  
  if (tickets.isEmpty()){
    out.println("<h2> There is no tickets</h2>" +
            "</body>" +
            " </html>");
  }
  
  else {
    out.println(
            "<h2>Tickets</h2>"
    );
  
    for (Ticket ticket : tickets) {
      out.println(
              "        <table align='center'>\n" +
                      "            <tr>\n" +
                      "                <td>From : </td>\n" +
                      "                <td> " + ticket.getStart_point() + " </td>\n" +
                      "            </tr>\n" +
                      "            <tr>\n" +
                      "                <td>To : </td>\n" +
                      "                <td>" + ticket.getEnd_point() + "</td>\n" +
                      "            </tr>\n" +
                      "            <tr>\n" +
                      "                <td>Airline : </td>\n" +
                      "                <td>" + ticket.getAir_line().getName() + "</td>\n" +
                      "            </tr>\n" +
                      "            <tr>\n" +
                      "                 <td>Price : </td>\n");
    
      if (ticket.getDepart_time().equals(LocalDate.now())
              && ticket.getTake_of_time().compareTo(LocalTime.now()) > 0
              && Duration.between(LocalTime.now(), ticket.getTake_of_time()).toMinutes() < 60) {
        out.println(
                "<td><del>" + ticket.getPrice_ticket() + "</del> <ins>" + (double)ticket.getPrice_ticket() / 2 + "</ins></td>\n"
        );
      } else {
        out.println(
                "<td>" + ticket.getPrice_ticket() + "</td>\n"
        );
      }
      out.println(
              "            </tr>\n" +
                      "            <tr>\n" +
                      "                <td>Date : </td>\n" +
                      "                <td>" + ticket.getTake_of_time() + "</td>\n" +
                      "            </tr>\n" +
                      "            <tr>\n" +
                      "                <td>Time : </td>\n" +
                      "                <td>" + ticket.getDepart_time() + "</td>\n" +
                      "            </tr>\n" +
                      "           <form action='buyTicket'>\n" +
                      "            <tr>\n" +
                      "                <td><label for='couponCode'>Coupon Code : </label></td>\n" +
                      "                <td><input type='text' name='couponCode' id='couponCode'></td>\n" +
                      "            </tr>\n" +
                      "            <tr>\n" +
                      "                <td>\n" +
                      "                    <input type='hidden' name='ticket_id' value='" + ticket.getId() + "'>\n" +
                      "                    <input type='submit' value='Buy The Ticket'>\n" +
                      "                </td>\n" +
                      "            </tr>\n" +
                      "            </form>" +
                      "        </table>\n" +
                      "    <hr>"
      );
    
    }
  
  }
  
  out.println(
          """
                      <p>
                          <a href='customer_workbench' class='underline'>Back to workbench</a>
                      </p><br><br><br>
                  </body>
                  </html>"""
  );
  
%>

