<%@page import="in.mani.dto.UserDTO"%>
<%@page import="in.mani.dto.TicketDTO"%>
<%@page import="in.mani.service.TicketService"%>
<%@page import="in.mani.dto.TrainDTO"%>
<%@page import="in.mani.dao.TrainDAO"%>
<%@page import="in.mani.model.Train"%>
<%@page import="java.util.List"%>
<%@page import="in.mani.service.TrainDetailSevices"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>My Bookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div><h3 class="text-center">My Bookings</h3></div>
		<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
		<%List<TicketDTO> tickets = (List<TicketDTO>) request.getAttribute("TICKET_DETAILS");
		if (tickets != null) { %>
		<table class="table table-bordered">
			<caption>My Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">SI.NO</th>
					<th id="user">USERNAME</th>
					<th id="trainName">TRAIN</th>
					<th id="pnrNumber">PNR NUMBER</th>
					<th id="bookedDate">BOOKED DATE</th>
					<th id="journeyDate">JOURNEY DATE</th>
					<th id="journeyTime">JOURNEY TIME</th>
					<th id="tickets">TOTAL TICKETS</th>
					<th id="passengers">PASSENGERS</th>
					<th id="price">TOTAL FARE</th>
					<th id="status">STATUS</th>
					<th id="cancel">CANCEL</th>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 0;
					for (TicketDTO ticket : tickets) {
						i++;
						TrainDTO train = ticket.getTrain();
						UserDTO user = ticket.getUser();
						//To Convert the Date Format
						LocalDateTime dateTime = ticket.getBookingDate();
					   String bookedDate = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS"));
					    LocalDate date = ticket.getJourneyDate();
					   String journeyDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				%>
				<tr>
					<td><%=i%></td>
					<td><%=user.getUserName()%></td>
					<td><%=train.getTrainName()%>(<%=train.getTrainNumber()%>)</td>
					<td><%=ticket.getPnrNumber()%></td>
					<td><%=bookedDate%></td>
					<td><%=journeyDate%></td>
					<td><%=ticket.getJourneyTime()%></td>
					<td><%=ticket.getNoOfTickets()%></td>
					<td><%=ticket.getPassengers()%></td>
					<td><%=ticket.getTotalPrice()%></td>
					<%if(ticket.getJourneyDate().isBefore(LocalDate.now())) {%>
					<td><h5><span class="badge badge-info">COMPLETED</span></h5></td>
					<%}else if(ticket.getJourneyDate().isAfter(LocalDate.now()) && ticket.getStatus().equalsIgnoreCase("BOOKED") || ticket.getJourneyDate().isEqual(LocalDate.now())) {%>
					<td><h5><span class="badge badge-success">BOOKED</span></h5></td>
					<%}else{ %>
					<td><h5><span class="badge badge-danger">CANCELLED</span></h5></td>
					<%
					}
					if(ticket.getJourneyDate().isBefore(LocalDate.now())) {%>
					<td><h5><span class="badge badge-info">COMPLETED</span></h5></td>
					<%}else if (ticket.getJourneyDate().isAfter(LocalDate.now()) && ticket.getStatus().equalsIgnoreCase("BOOKED") || ticket.getJourneyDate().isEqual(LocalDate.now())) {
					%>
					<td><a
						href="CancelTrainServlet?orderId=<%=ticket.getId()%>&tickets=<%=ticket.getNoOfTickets()%>&showDate=<%=ticket.getJourneyDate()%>"
						class="btn btn-danger">Cancel</a> <%
				 	} else {
 						%>
					<td>
						<h5><span class="badge badge-danger">CANCELLED</span></h5>
					</td>
					<%
					}
					}
					%>

				</tr>
				
			</tbody>
		</table>
				<%}
			 else {
				%>
				<h4 class="text-center">No Records Found</h4>
				<%
				}
				%>
	</main>
</body>
</html>