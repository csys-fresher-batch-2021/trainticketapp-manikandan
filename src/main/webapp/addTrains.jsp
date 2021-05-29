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
			<span class="input-group-text" style="width:160px;">TRAIN NUMBER</span>
			</div>
			<input type="number" name="trainNumber" style="width:160px;" placeholder="Train Number" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">TRAIN NAME</span>
			</div>
			<input type="text" name="trainName" style="width:160px;" placeholder="Train Name" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">SOURCE</span>
			</div>
			<input type="text" name="source" style="width:160px;" placeholder="Source" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">DESTINATION</span>
			</div>
			<input type="text" name="destination" style="width:160px;" placeholder="Destination" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">DEPARTURE TIME</span>
			</div>
			<input type="time" name="sourcetime" style="width:160px;" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">ARRIVAL TIME</span>
			</div>
			<input type="time" name="destinationtime" style="width:160px;" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">CLASS TYPE</span>
			</div>
			<select name="classType" style="width:160px;">
    		<option value="FirstClass">First Class</option>
    		<option value="Sleeper">Sleeper</option>
   			<option value="SecondSitting">Second Sitting</option>
  			</select>
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">FARE</span>
			</div>
			<input type="number" name="classTypeFare" style="width:160px;" placeholder="Fare" autocomplete="off" required><br />
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
			<span class="input-group-text" style="width:160px;">AVAILABILITY</span>
			</div>
			<input type="number" name="classTypeAvailability" style="width:160px;" placeholder="Availability" autocomplete="off" required><br />
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