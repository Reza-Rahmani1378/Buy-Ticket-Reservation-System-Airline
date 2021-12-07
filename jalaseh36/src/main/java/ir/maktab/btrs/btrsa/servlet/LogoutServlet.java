package ir.maktab.btrs.btrsa.servlet;

import ir.maktab.btrs.btrsa.utility.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    public LogoutServlet() {

    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        SecurityContext.logOut();
        response.sendRedirect("/jalaseh36_war");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
