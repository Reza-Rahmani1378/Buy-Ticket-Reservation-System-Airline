package ir.maktab.btrs.btrsa.filter;

import ir.maktab.btrs.btrsa.domain.User;
import ir.maktab.btrs.btrsa.utility.ApplicationContext;
import ir.maktab.btrs.btrsa.utility.SecurityContext;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

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

        User user = ApplicationContext.getUserService().existByUsername(username);
        if (!Objects.isNull(user)) {
            if (user.getPassword().equals(password)) {
                SecurityContext.setActiveUser(user);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                out.println(
                        "<h2 align='center'>  Your username or password is wrong.. </h2>\n" +
                                "<p align='center'><a href='index.jsp'>Return to Login Page</a></p><br>");
            }
        } else {
            out.println(
                    "<p align='center'>You don't have an account You can Sign Up  <a href='RegisterServlet'>click here</a></p>");
        }

    }

    @Override
    public void destroy() {

    }
}
