package in.mani.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mani.dto.TicketDTO;
import in.mani.dto.TrainDTO;
import in.mani.dto.UserDTO;
import in.mani.service.FareEstimationService;
import in.mani.service.GeneratePNRNumberService;
import in.mani.service.TicketService;
import in.mani.service.UserRegisterService;

/**
 * Servlet implementation class BookTicketServlet
 */
@WebServlet("/BookTicketServlet")
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookTicketServlet() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	TicketDTO ticket = new TicketDTO();
    	HttpSession session = request.getSession();
    	String userName = (String) session.getAttribute("LOGGED_IN_USER");
    	UserDTO user = UserRegisterService.findByUserName(userName);
    	Integer userId = user.getId();
    	UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		String trainIdStr = request.getParameter("trainId");
		String trainNumberStr = request.getParameter("trainNumber");
		String trainName = request.getParameter("trainName");
		String journeyDateStr = request.getParameter("journeyDate");
		String journeyTimeStr = request.getParameter("sourceTime");
		String noOfTicketsStr  = request.getParameter("noOfTickets");
		String passengersName  = request.getParameter("passengersName"); 
    	try {
    		int trainId = Integer.parseInt(trainIdStr);
    		int trainNumber = Integer.parseInt(trainNumberStr);
    		TrainDTO train = new TrainDTO();
    		train.setId(trainId);
    		train.setTrainNumber(trainNumber);
    		train.setTrainName(trainName);
    		LocalDate journeyDate = LocalDate.parse(journeyDateStr);
			LocalTime journeyTime = LocalTime.parse(journeyTimeStr);
			LocalDateTime bookingDate = LocalDateTime.now();
			int noOfTickets = Integer.parseInt(noOfTicketsStr);
			int totalPrice = FareEstimationService.getPrice(trainNumber,noOfTickets);
			int pnrNumber = GeneratePNRNumberService.getPNRNumber();
			ticket.setUser(userDTO);
			ticket.setTrain(train);
			ticket.setPnrNumber(pnrNumber);
			ticket.setJourneyDate(journeyDate);
			ticket.setJourneyTime(journeyTime);
			ticket.setBookingDate(bookingDate);
			ticket.setNoOfTickets(noOfTickets);
			ticket.setPassengers(passengersName);
			ticket.setTotalPrice(totalPrice);
			TicketService.addTicketDetails(ticket);
			request.setAttribute("BOOKING_DETAILS", ticket);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookingDetails.jsp");
   			requestDispatcher.forward(request, response);
    	}
    	catch (Exception e) {
			e.printStackTrace();
			String errorMessage=e.getMessage();
			response.sendRedirect("bookTicket.jsp?errorMessage=" + errorMessage);
		}
	}
}
