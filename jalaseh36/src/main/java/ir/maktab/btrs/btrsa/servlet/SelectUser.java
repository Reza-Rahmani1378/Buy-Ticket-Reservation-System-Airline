package ir.maktab.btrs.btrsa.servlet;

import ir.maktab.btrs.btrsa.domain.User;
import ir.maktab.btrs.btrsa.utility.SecurityContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SelectUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>Hello</h1>");

        User user = SecurityContext.getActiveUser();
        switch (user.getUserType()) {
            case ADMIN -> response.sendRedirect("/html/admin_workbench.jsp");
//                    {
//                        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/html/admin_workbench.jsp");
//                        requestDispatcher.forward(request , response);
//                    }


            case CUSTOMER -> response.sendRedirect("customer_workbench.jsp");
            case AIRLINE_OPERATOR -> response.sendRedirect("airline_operator_workbench.jsp");
        }

    }
}
