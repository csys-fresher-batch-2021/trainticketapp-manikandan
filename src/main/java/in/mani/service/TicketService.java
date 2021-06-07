package in.mani.service;

import java.util.List;

import in.mani.converter.TicketConverter;
import in.mani.dao.TicketDAO;
import in.mani.dto.TicketDTO;
import in.mani.exception.ServiceException;
import in.mani.model.Ticket;
import in.mani.util.NameValidation;
import in.mani.util.NumberValidator;

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
			NameValidation.isValidName(ticketDTO.getPassengers());
			NumberValidator.isValidNumber(ticketDTO.getNoOfTickets());
			Ticket ticket = TicketConverter.toTicket(ticketDTO);
			ticketDAO.addTicketDetails(ticket);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is to get Booking Details
	 * @param userId
	 * @return
	 */
	public static List<TicketDTO> getUserBookingDetails(Integer userId) {
		List<Ticket> tickets = null;

		try {
			tickets = ticketDAO.getUserBookings(userId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return TicketConverter.toTicketDTO(tickets);

	}

	/**
	 * This Method is to cancel Booking Details
	 * @param bookingId
	 */
	public static void cancelBooking(Integer bookingId) {
		try {
			ticketDAO.cancelBooking(bookingId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * This Method will return the Booking Details of all Users
	 * @return
	 */
	public static List<TicketDTO> getAllBookingDetails() {

		List<Ticket> tickets = null;

		try {
			tickets = ticketDAO.getAllBookings();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return TicketConverter.toTicketDTO(tickets);

	}
}
