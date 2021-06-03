package in.mani.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mani.exception.ServiceException;
import in.mani.service.TicketService;

/**
 * Servlet implementation class CancelTrainServlet
 */
@WebServlet("/CancelTrainServlet")
public class CancelTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CancelTrainServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer bookingId=Integer.parseInt(request.getParameter("orderId"));
			TicketService.cancelBooking(bookingId);
			response.sendRedirect("UserBookingDetailsServlet");
		} catch (ServiceException e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("userBookingDetails.jsp?errorMessage=" + errorMessage);			
		}
	}
}
