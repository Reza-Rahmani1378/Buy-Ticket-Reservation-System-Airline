package ir.maktab.home_work17.filter;

import ir.maktab.home_work17.domain.Customer;
import ir.maktab.home_work17.domain.enumeration.UserType;
import ir.maktab.home_work17.utility.ApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String nationalCode = httpServletRequest.getParameter("nationalCode");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        out.println(
                """
                        <!DOCTYPE html>
                        <html lang='en'>
                        <head>
                            <meta charset='UTF-8'>
                            <link rel='stylesheet' href=styles/style.css'>
                        </head>
                        <body>
                        """
        );


        Customer customer = new Customer(username, password, nationalCode, UserType.CUSTOMER);
        ApplicationContext.getCustomerService().save(customer);
        filterChain.doFilter(servletRequest, servletResponse);


        out.println(
                "</body>\n" +
                        "</html>"
        );
    }

    @Override
    public void destroy() {

    }
}
