package in.mani.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mani.dto.TicketDTO;
import in.mani.dto.UserDTO;
import in.mani.exception.ServiceException;
import in.mani.service.TicketService;
import in.mani.service.UserRegisterService;

/**
 * Servlet implementation class UserBookingDetailsServlet
 */
@WebServlet("/UserBookingDetailsServlet")
public class UserBookingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserBookingDetailsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
			UserDTO user = UserRegisterService.findByUserName(loggedInUsername);
			Integer userId = user.getId();
			List<TicketDTO> tickets = TicketService.getUserBookingDetails(userId);
			request.setAttribute("TICKET_DETAILS", tickets);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userBookingDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException | ServiceException e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("userBookingDetails.jsp?errorMessage=" + errorMessage);
		}
	}
}
