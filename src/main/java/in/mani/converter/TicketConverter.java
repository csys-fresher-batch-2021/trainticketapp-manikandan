package in.mani.converter;

import java.util.ArrayList;
import java.util.List;

import in.mani.dto.TicketDTO;
import in.mani.dto.TrainDTO;
import in.mani.dto.UserDTO;
import in.mani.model.Ticket;
import in.mani.model.Train;
import in.mani.model.User;

public class TicketConverter {

	private TicketConverter() {
		// Default Constructor
	}

	/**
	 * This Method will Converts Ticket DTO objects to Model Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static Ticket toTicket(TicketDTO dto) {
		Ticket ticket = new Ticket();
		Train train = TrainConverter.toTrain(dto.getTrain());
		User user = UserConverter.toUser(dto.getUser());

		ticket.setId(dto.getId());
		ticket.setUser(user);
		ticket.setTrain(train);
		ticket.setPnrNumber(dto.getPnrNumber());
		ticket.setBookingDate(dto.getBookingDate());
		ticket.setJourneyDate(dto.getJourneyDate());
		ticket.setJourneyTime(dto.getJourneyTime());
		ticket.setNoOfTickets(dto.getNoOfTickets());
		ticket.setPassengers(dto.getPassengers());
		ticket.setTotalPrice(dto.getTotalPrice());
		ticket.setStatus(dto.getStatus());
		return ticket;
	}

	/**
	 * This Method will Converts Model object to Ticket DTO Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static TicketDTO toTicketDTO(Ticket ticket) {
		TicketDTO dto = new TicketDTO();
		TrainDTO trainDTO = TrainConverter.toTrainDTO(ticket.getTrain());
		UserDTO userDTO = UserConverter.toUserDTO(ticket.getUser());

		dto.setId(ticket.getId());
		dto.setUser(userDTO);
		dto.setTrain(trainDTO);
		dto.setPnrNumber(ticket.getPnrNumber());
		dto.setBookingDate(ticket.getBookingDate());
		dto.setJourneyDate(ticket.getJourneyDate());
		dto.setJourneyTime(ticket.getJourneyTime());
		dto.setNoOfTickets(ticket.getNoOfTickets());
		dto.setPassengers(ticket.getPassengers());
		dto.setTotalPrice(ticket.getTotalPrice());
		dto.setStatus(ticket.getStatus());
		return dto;
	}

	/**
	 * This Method will Converts List of Model objects to List of Ticket DTO Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static List<TicketDTO> toTicketDTO(List<Ticket> tickets) {
		List<TicketDTO> dtoList = new ArrayList<>();
		for (Ticket ticket : tickets) {
			TicketDTO ticketDTO = TicketConverter.toTicketDTO(ticket);
			dtoList.add(ticketDTO);
		}
		return dtoList;
	}

	/**
	 * This Method will Converts List of DTO objects to Model Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static List<Ticket> toTicket(List<TicketDTO> dto) {
		List<Ticket> ticketList = new ArrayList<>();
		for (TicketDTO ticketdto : dto) {
			Ticket ticket = TicketConverter.toTicket(ticketdto);
			ticketList.add(ticket);
		}

		return ticketList;
	}

}
