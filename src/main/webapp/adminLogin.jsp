<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">ADMIN LOGIN</h4>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
				<form action="AdminLoginServlet" method="POST">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="adminId" class="form-control"
							placeholder="Enter User Name" autocomplete="off" type="text"
							required>
					</div>
					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="password" class="form-control"
							placeholder="Enter Password" autocomplete="off" type="password"
							required>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Log In</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>



