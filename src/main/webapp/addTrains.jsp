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
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">ADD TRAIN</h4>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
		<form action="AddTrainServlet">
			<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">TRAIN NUMBER</span>
			</div>
			<input type="number" name="trainNumber" placeholder="Train Number" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">TRAIN NAME</span>
			</div>
			<input type="text" name="trainName" placeholder="Train Name" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">SOURCE</span>
			</div>
			<input type="text" name="source" placeholder="Source" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">DESTINATION</span>
			</div>
			<input type="text" name="destination" placeholder="Destination" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">DEPARTURE TIME</span>
			</div>
			<input type="time" name="sourcetime" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">ARRIVAL TIME</span>
			</div>
			<input type="time" name="destinationtime" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">CLASS TYPE</span>
			</div>
			<select name="classType">
    		<option value="FirstClass">First Class</option>
    		<option value="Sleeper">Sleeper</option>
   			<option value="SecondSitting">Second Sitting</option>
  			</select>
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">FARE</span>
			</div>
			<input type="number" name="classTypeFare" placeholder="Fare" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">AVAILABILITY</span>
			</div>
			<input type="number" name="classTypeAvailability" placeholder="Availability" autocomplete="off" required><br />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block">Submit</button>
		</div>
		</form>
		</article>
		</div>
	</main>
</body>
</html>