<%@page import="in.mani.dto.TrainDTO"%>
<%@page import="in.mani.dto.TicketDTO"%>
<%@page import="in.mani.model.Train"%>
<%@page import="in.mani.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="text-center">
	<main class="container-fluid">
		<br><h2 class="text-center" style="color:green;">TICKET BOOKED SUCCESSFULLY</h2><br/>
	    <br><h3 class="text-center">BOOKING DETAILS</h3><br/>
		<%
			TicketDTO ticket = (TicketDTO)request.getAttribute("BOOKING_DETAILS");
			TrainDTO train = ticket.getTrain();						
		%>
		<table class="table table-bordered">
		<caption>Showing Booking Details</caption>
		<tbody>
		<tr><td>TRAIN NUMBER</td> <td><%=train.getTrainNumber()%></td> </tr>
		<tr><td>TRAIN NAME</td> <td><%=train.getTrainName()%></td> </tr>
		<tr><td>JOURNEY DATE (YYYY-MM-DD)</td> <td> <%=ticket.getJourneyDate()%></td> </tr>
		<tr><td>JOURNEY TIME</td> <td> <%=ticket.getJourneyTime()%></td> </tr>
		<tr><td>PASSENGERS NAME</td> <td> <%= ticket.getPassengers()%></td></tr>
		<tr><td>TOTAL TICKETS</td> <td> <%=ticket.getNoOfTickets()%></td> </tr>
		<tr><td>TOTAL FARE(inclusive of all taxes)</td> <td>Rs: <%=ticket.getTotalPrice()%>/-</td> </tr>
		</tbody>
		</table>
		<br><a href="index.jsp" class="btn btn-primary">Home Page</a>
	</main>
	</div>
</body>
</html>