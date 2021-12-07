<%-- 
    Document   : registration
    Created on : Jan 10, 2020, 2:43:53 PM
    Author     : almam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">

            <div class="regbox box">
                <img class="avatar" src="../img/collaboration.png" alt="">
                <h1>Register Account</h1>
                <form action="RegisterServlet" method="post">
                    <p>FirstName</p>
                    <label>
                        <input type="text" placeholder="FirstName" name="first_name" required>
                    </label>
                    <p>LastName</p>
                    <label>
                        <input type="text" placeholder="LastName" name="last_name" required>
                    </label>
                    <p>NationalCode</p>
                    <label>
                        <input type="text" placeholder="NationalCode" name="national_code" required>
                    </label>
                    <p>Username</p>
                    <label>
                        <input type="text" placeholder="Username" name="username" required>
                    </label>
                    <p>Password</p>
                    <label>
                        <input type="password" placeholder="Password" name="password" required>
                    </label>
                    <p>BirthDay</p>
                    <label>
                        <input type="date" placeholder="BirthDay" name="birthDay" required>
                    </label>
                    <input type="submit" value="Register">
                    <a href="../../index.jsp">Already have Account?</a>
                </form>
            </div>
        </div>

    </body>
</html>
