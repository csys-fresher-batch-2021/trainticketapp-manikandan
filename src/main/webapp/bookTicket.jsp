<%@page import="in.mani.dto.TrainDTO"%>
<%@page import="in.mani.dao.TrainDAO"%>
<%@page import="in.mani.model.Train"%>
<%@page import="java.util.List"%>
<%@page import="in.mani.service.TrainDetailSevices"%>
<%@page import="in.mani.service.TrainDetailSevices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BOOK TICKET</title>
</head>
<body id="setmin">
	<%
	String loggedInAdminId = (String) session.getAttribute("LOGGED_IN_ADMIN");
	String loggedInUser = (String) session.getAttribute("LOGGED_IN_USER");
	String role = (String) session.getAttribute("ROLE");
	String trainName = request.getParameter("trainName");
	String trainId = request.getParameter("trainId");
	String trainNumber = request.getParameter("trainNumber");
	 String source =request.getParameter("source"); 
	 String sourceTime =request.getParameter("sourceTime"); 
	 String destination =request.getParameter("destination"); 
	 String destinationTime =request.getParameter("destinationTime"); 
	 String classType = request.getParameter("classType");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 600px;">
				<h4 class="card-title mt-3 text-center">BOOK TICKET</h4>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
				<form action=BookTicketServlet>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">TRAIN NUMBER
							</span>
						</div>
						<input name="trainNumber" class="form-control" value=<%=trainNumber%> type="text" readonly>
						<input type="hidden" name="trainId" value=<%=trainId%>>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">TRAIN NAME
							</span>
						</div>
						<input name="trainName" class="form-control" value=<%=trainName%> type="text" readonly>
						</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">SOURCE
							</span>
						</div>
						<input name="source" class="form-control" value=<%=source%> type="text" readonly>
						<input name="sourceTime" class="form-control" value=<%=sourceTime%> type="text" readonly>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">DESTINATION
							</span>
						</div>
						<input name="destination" class="form-control" value=<%=destination%> type="text" readonly>
						<input name="destinationTime" class="form-control" value=<%=destinationTime%> type="text" readonly>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">CLASS
							</span>
						</div>
						<input name="trainClass" class="form-control" value=<%=classType%> type="text" readonly>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">JOURNEY DATE 
							</span>
						</div>
						<input name="journeyDate" id="journeyDate" class="form-control" type="date" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">NO OF PASSENGERS
							</span>
						</div>
						<input name="noOfTickets" class="form-control" type="number" autocomplete="off" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 170px;">PASSENGERS NAME
							</span>
						</div>
						<input name="passengersName" class="form-control" type="text" autocomplete="off" required>
						<p>(*Hints : Enter '/' between Passengers Name)</p>
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						CONFIRM TICKET</button>
				</div>
				</form>
			</article>
		</div>
	</main>
</body>
<script>
document.getElementById("setmin").addEventListener("load", setMinMax());
function setMinMax() {
    let todayStr = new Date().toJSON().substr(0, 10);
    document.querySelector("#journeyDate").setAttribute("min", todayStr);
    let endDate = new Date();
    endDate.setDate(endDate.getDate() + 28);
    let endDateStr = endDate.toJSON().substr(0, 10);
    document.querySelector("#journeyDate").setAttribute("max", endDateStr);
}
</script>
</html>