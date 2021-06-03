package in.mani.service;

import java.util.List;

import in.mani.converter.TicketConverter;
import in.mani.dao.TicketDAO;
import in.mani.dto.TicketDTO;
import in.mani.exception.ServiceException;
import in.mani.model.Ticket;

public class TicketService {

	private TicketService() {
		// Default Constructor
	}

	private static TicketDAO ticketDAO = TicketDAO.getInstance();

	/**
	 * This Method will store the Booking Details
	 * 
	 * @param ticketDTO
	 */
	public static void addTicketDetails(TicketDTO ticketDTO) {
		try {
			Ticket ticket = TicketConverter.toTicket(ticketDTO);
			ticketDAO.addTicketDetails(ticket);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public static List<TicketDTO> getUserBookingDetails(Integer userId) {
		List<Ticket> tickets = null;

		try {
			tickets = ticketDAO.getUserBookings(userId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return TicketConverter.toTicketDTO(tickets);

	}

	public static void cancelBooking(Integer bookingId) {
		try {
			ticketDAO.cancelBooking(bookingId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}
}
