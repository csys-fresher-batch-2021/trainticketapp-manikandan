<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 410px;">
				<h4 class="card-title mt-3 text-center">Create Account</h4>
				<p class="text-center">Get started with our Train Ticket App</p>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
				<form action="UserRegisterServlet" method="POST">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-user"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="firstName" class="form-control"
							placeholder="First Name" type="text" autocomplete="off" required>
						<input name="lastName" class="form-control"
							placeholder="Last Name" type="text" autocomplete="off" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-envelope"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="email" class="form-control"
							placeholder="Enter Email Address" type="email" autocomplete="off"
							required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-phone"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input class="form-control" value="+91" type="text" readonly>
						<input name="mobileNumber" class="form-control"
							placeholder="Mobile Number" type="number" autocomplete="off"
							required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-user"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="userName" class="form-control"
							placeholder="Enter User Name" type="text" autocomplete="off"
							required>
					</div>
					<div><p>(*Hints :Username must contains Atleast one Upper & Lower letters and one Number|Length of Username should be > 6 Characters )</p></div>
					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-lock"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="newPassword" class="form-control"
							placeholder="New Password" type="password" autocomplete="off"
							required>
					</div>
					<div><p>(*Hints :Password must contains Atleast one Upper & Lower letters, one Symbol and one Number|Length of Password should be > 8 Characters )</p></div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-lock"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="confirmPassword" class="form-control"
							placeholder="Confirm Password" type="password" autocomplete="off"
							required>
					</div>
					<div class="form-group input-group">
						<input type="checkbox" required>By Creating Account you
						accept our Terms Of Use
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Create Account</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="userLogin.jsp">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->
	</main>
</body>
</html>