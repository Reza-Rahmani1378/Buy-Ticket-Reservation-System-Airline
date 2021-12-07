<%@page contentType="text/html" pageEncoding="UTF-8" %>



<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Join Us</title>
	<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
	<link href="style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="container">
	<div class="box">
		<img class="avatar" src="image/user-avatar.png" alt="">
		<h1>Login Account</h1>
		<form action="selectUser" <%--method="post"--%>>
			<p>Username</p>
			<label>
				<input type="text" placeholder="Username" name="username" required>
			</label>
			<p>Password</p>
			<label>
				<input type="password" placeholder="Password" name="password" required>
			</label>
			<input type="submit" value="Login">
			<a href="#">Forget Password?</a><br>
			<a href="html/registration.jsp">Create New Account</a>
		</form>
	</div>


</div>
</body>
</html>