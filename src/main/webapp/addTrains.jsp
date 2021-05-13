<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Trains</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<jsp:include page="message.jsp"></jsp:include>
		<h1>Add Trains</h1>
		<form action="AddTrainServlet">
			<label for="Train Number">Train Number :</label> 
			<input type="number" name="trainNumber" placeholder="Enter Train Number" min="10000" max="99999" autocomplete="off" autofocus required><br /> 
			<label for="Train Name">Train Name :</label> 
			<input type="text" name="trainName" placeholder="Enter Train Name" autocomplete="off" required><br />
			<button type="submit" class="btn btn-secondary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
</body>
</html>