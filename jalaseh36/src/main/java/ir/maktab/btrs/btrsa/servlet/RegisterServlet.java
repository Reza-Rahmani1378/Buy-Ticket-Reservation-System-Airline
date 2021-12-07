/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.maktab.btrs.btrsa.servlet;

import ir.maktab.btrs.btrsa.domain.User;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import ir.maktab.btrs.btrsa.repository.UserRepository;
import ir.maktab.btrs.btrsa.service.UserService;
import ir.maktab.btrs.btrsa.utility.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegisterServlet extends HttpServlet {

    protected final UserService userService = ApplicationContext.getUserService();
    protected final UserRepository userRepository = ApplicationContext.getUserRepository();

    public RegisterServlet() {

    }


    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");


            User user = new User();
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String username = request.getParameter("username");
            String nationalCode = request.getParameter("national_code");
            String password = request.getParameter("password");
            user.setUserType(UserType.CUSTOMER);
            Date birthDay = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDay"));

            if (userRepository.existByUsername(username) != null) {

                String errorMessage = "User Available";
                HttpSession regSession = request.getSession();
                regSession.setAttribute("RegError", errorMessage);
                response.sendRedirect("../webapp/WEB-INF/web/registration.jsp");
            } else {

                user.setUserType(UserType.CUSTOMER);
                user.setBirth_day(birthDay);
                user.setFirst_name(firstName);
                user.setLast_name(lastName);
                user.setUsername(username);
                user.setPassword(password);
                user.setNational_code(nationalCode);
                userService.save(user);
                response.sendRedirect("index.jsp");


            }

            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
