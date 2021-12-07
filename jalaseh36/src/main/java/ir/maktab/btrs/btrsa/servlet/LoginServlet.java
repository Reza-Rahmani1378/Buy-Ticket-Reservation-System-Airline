package ir.maktab.btrs.btrsa.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {

    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("html/text;charset=UTF-8");

        PrintWriter out = response.getWriter();

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

        out.println
                (
                        """
                                        <h2 align='center'>Login</h2>
                                        <form action='signInConfirm'>
                                        <table align='center'>\s
                                        <tr>
                                        <td align='right'><label for='u_name'>Username : </label></td>
                                        <td align='left'><input type='text' name='username' id='u_name' required='required'></td>
                                        </tr>
                                        <tr>
                                        <td align='right'><label for='password'>Password : </label></td>
                                        <td align='left'><input type='password' name='password' id='password' required='required'></td>
                                        </tr>
                                        <tr>
                                        <td></td>
                                        <td><input type='submit' value='Sign In Submit'></td>
                                        </tr>
                                        </table>
                                        </form>
                                """
                );

        out.println(
                "</body>" +
                        "<br>" +
                        "</html>"
        );
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
