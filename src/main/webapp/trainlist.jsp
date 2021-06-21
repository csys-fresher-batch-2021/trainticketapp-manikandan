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
<title>Train List</title>
<style type="text/css">
table, td, th {
	text-align: center;
}
</style>
</head>
<body>
	<%
	String loggedInAdminId = (String) session.getAttribute("LOGGED_IN_ADMIN");
	String loggedInUser = (String) session.getAttribute("LOGGED_IN_USER");
	String role = (String) session.getAttribute("ROLE");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="text-center">List of Trains</h3>
		<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
		<%
		List<TrainDTO> trains = (List<TrainDTO>) request.getAttribute("TRAIN_LIST");
		if (trains != null) {
		%>
		<table class="table table-bordered">
			<caption>Train List</caption>
			<thead>
				<tr>
					<th id="trainID">SI.NO</th>
					<th id="trainNo">Train No</th>
					<th id="trainName">Train Name</th>
					<th id="source">Source</th>
					<th id="destination">Destination</th>
					<th id="classType">Class</th>
					<th id="fare">Fare(Rs./-)</th>
					<th id="availability">Availability</th>
					<%
					if (loggedInAdminId != null || loggedInUser != null) {
					%>
					<th id="action">
						<%
						if (loggedInAdminId != null && role != null && role.equalsIgnoreCase("ADMIN")) {
						%>Delete<%
						}
						%> <%
 if (loggedInUser != null) {
 %>Book
					</th>
					<%
					}
					}
					%>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 0;
					for (TrainDTO train : trains) {
						i++;
				%>
				<tr>
					<td rowspan="2"><%=i%></td>
					<td rowspan="2"><%=train.getTrainNumber()%></td>
					<td rowspan="2"><%=train.getTrainName()%></td>
					<td><%=train.getSource()%></td>
					<td><%=train.getDestination()%></td>
					<td rowspan="2"><%=train.getClassType()%></td>
					<td rowspan="2"><%=train.getClassTypeFare()%></td>
					<td rowspan="2"><%=train.getClassTypeAvailability()%></td>
					<%
					if (loggedInAdminId != null || loggedInUser != null) {
					%>
					<td rowspan="2">
						<%
						if (loggedInAdminId != null && role != null && role.equalsIgnoreCase("ADMIN")) {
						%> <a
						href="DeleteTrainServlet?trainName=<%=train.getTrainName()%>&trainNumber=<%=train.getTrainNumber()%>"
						class=" btn btn-danger">Delete</a> <%
 							}
 							%> <%
 						if (loggedInUser != null) {	
 						%> 
 						<a
						href="bookTicket.jsp?trainId=<%=train.getId()%>&trainName=<%=train.getTrainName()%>&trainNumber=<%=train.getTrainNumber()%>&source=<%=train.getSource()%>&sourceTime=<%=train.getSourceTime()%>&destination=<%=train.getDestination()%>&destinationTime=<%=train.getDestinationTime()%>&classType=<%=train.getClassType()%>"
						class=" btn btn-primary">Book</a>
					</td>
					<%
					}
					}
					%>
				</tr>
				<tr>
					<td>DEPARTURE TIME: <%=train.getSourceTime()%></td>
					<td>ARRIVAL TIME: <%=train.getDestinationTime()%></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
		<%} %>
	</main>
</body>
</html>