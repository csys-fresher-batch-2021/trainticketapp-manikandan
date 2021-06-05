<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
			<h4 class="card-title mt-3 text-center">SIGN IN</h4>
			<p class="text-center">Welcome to Train Ticket App</p>
			<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
			<form action="UserLoginServlet" method="POST">
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <em class="fa fa-user" style="font-size:24px"></em>
						</span>
					</div>
					<input name="userName" class="form-control"
						placeholder="Enter User Name" type="text" autocomplete="off"
						required>
				</div>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <em class="fa fa-lock" style="font-size:24px"></em>
						</span>
					</div>
					<input name="password" class="form-control"
						placeholder="Enter Password" type="password" autocomplete="off"
						required>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Login</button>
				</div>
				<!-- form-group// -->
				<p class="text-center">
					Don't have an account? <a href="registerUser.jsp">Sign Up</a>
				</p>
				<p class="text-center">
					<a href="#">Forgot your Password?</a>
				</p>
			</form>
		</article>
		</div>
	</main>
</body>
</html>