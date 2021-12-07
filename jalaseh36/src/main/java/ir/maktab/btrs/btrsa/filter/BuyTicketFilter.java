package ir.maktab.btrs.btrsa.filter;

import ir.maktab.btrs.btrsa.domain.Customer;
import ir.maktab.btrs.btrsa.domain.DiscountCode;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.utility.*;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class BuyTicketFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Customer customer = (Customer) SecurityContext.getActiveUser();
        long id = Long.parseLong(request.getParameter("ticket_id"));
        Ticket ticket = ApplicationContext.getTicketService().findById(id);
        PrintWriter out = response.getWriter();

        String discountCodeCode = request.getParameter("disCountCode");

        if (discountCodeCode.isEmpty()) {
            if (ticket.getPrice_ticket() > customer.getWallet().getTotalAmount()) {
                out.println(
                        """
                                <!DOCTYPE html>
                                <html lang='en'>
                                <head>
                                    <meta charset='UTF-8'>
                                    <link rel='stylesheet' href='style/style.css'>
                                </head>
                                <body>
                                    <h2> Your Total Amount wallet is not enough</h2>
                                    <p>
                                        <a href='customer_workbench.jsp' class='underline'>Back to workbench</a>
                                    </p>
                                </body>
                                </html>"""
                );
            } else if (ticket.getValency() < 1) {
                out.println(
                        """
                                <!DOCTYPE html>
                                <html lang='en'>
                                <head>
                                    <meta charset='UTF-8'>
                                    <link rel='stylesheet' href='style/style.css'>
                                </head>
                                <body>
                                    <h2>No Valency  for this Flight  </h2>
                                    <p>
                                        <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose ticket</a>
                                    </p>
                                </body>
                                </html>"""
                );
            } else if (ticket.getDepart_time().equals(LocalDate.now()) && ticket.getTake_of_time().compareTo(LocalTime.now()) < 0) {
                out.println(
                        """
                                <!DOCTYPE html>
                                <html lang='en'>
                                <head>
                                    <meta charset='UTF-8'>
                                    <link rel='stylesheet' href='resource/styles/style.css'>
                                </head>
                                <body>
                                    <h2> ==> Flight Time is Passed <== </h2>
                                    <p>
                                        <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose Ticket</a>
                                    </p>
                                </body>
                                </html>"""
                );
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            try {
                DiscountCode discountCode = ApplicationContext.getDiscountCodeService().findDiscountCodeByCode(discountCodeCode);
                Set<Customer> discountCodeCustomers = discountCode.getCustomers();
                if (discountCode.getExpireDate().compareTo(LocalDate.now()) < 0) {
                    out.println(
                            """
                                    <!DOCTYPE html>
                                    <html lang='en'>
                                    <head>
                                        <meta charset='UTF-8'>
                                        <link rel='stylesheet' href='style/style.css'>
                                    </head>
                                    <body>
                                        <h2> Discount Code is Expired...</h2>
                                        <p>
                                            <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose Ticket</a>
                                        </p>
                                    </body>
                                    </html>"""
                    );
                } else if (discountCodeCustomers.contains(customer)) {
                    out.println(
                            """
                                    <!DOCTYPE html>
                                    <html lang='en'>
                                    <head>
                                        <meta charset='UTF-8'>
                                        <link rel='stylesheet' href='resource/styles/style.css'>
                                    </head>
                                    <body>
                                        <h2> This Discount Code is used before... </h2>
                                        <p>
                                            <a href='chooseStartAndPoint.jsp' class='underline'> Back to choose Ticket</a>
                                        </p>
                                    </body>
                                    </html>"""
                    );
                } else if (((100 - discountCode.getDiscountPercent()) / 100 * ticket.getValency() > customer.getBalance())) {
                    out.println(
                            """
                                    <!DOCTYPE html>
                                    <html lang='en'>
                                    <head>
                                        <meta charset='UTF-8'>
                                        <link rel='stylesheet' href='style/style.css'>
                                    </head>
                                    <body>
                                        <h2> Your Total Amount wallet is not enough..  </h2>
                                        <p>
                                            <a href='customer_workbench.jsp' class='underline'>Back to workbench</a>
                                        </p>
                                    </body>
                                    </html>"""
                    );

                } else if (ticket.getValency() < 1) {
                    out.println(
                            """
                                    <!DOCTYPE html>
                                    <html lang='en'>
                                    <head>
                                        <meta charset='UTF-8'>
                                        <link rel='stylesheet' href='style/style.css'>
                                    </head>
                                    <body>
                                        <h2> There is no valency for this flight </h2>
                                        <p>
                                            <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose ticket</a>
                                        </p>
                                    </body>
                                    </html>"""
                    );
                } else if (ticket.getDepart_time().equals(LocalDate.now()) && ticket.getTake_of_time().compareTo(LocalTime.now()) < 0) {
                    out.println(
                            """
                                    <!DOCTYPE html>
                                    <html lang='en'>
                                    <head>
                                        <meta charset='UTF-8'>
                                        <link rel='stylesheet' href='style/style.css'>
                                    </head>
                                    <body>
                                        <h2> Sorry flight time is passed... </h2>
                                        <p>
                                            <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose ticket</a>
                                        </p>
                                    </body>
                                    </html>"""
                    );
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } catch (Exception e) {
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
                                    <h2> Discount Code is wrong... </h2>
                                    <p>
                                        <a href='chooseStartAndEndPoint.jsp' class='underline'>Back to choose Ticket</a>
                                    </p>
                                </body>
                                </html>"""
                );
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroyed...");
    }
}
