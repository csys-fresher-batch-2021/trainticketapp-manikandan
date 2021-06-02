package in.mani.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import in.mani.exception.DBException;
import in.mani.model.Ticket;
import in.mani.model.Train;
import in.mani.model.User;
import in.mani.util.ConnectionUtil;

public class TicketDAO {

	private static final TicketDAO instance = new TicketDAO();

	public static TicketDAO getInstance() {
		return instance;
	}
	
	/**
	 * This Methods stores Booking Details in DataBase
	 * 
	 * @param ticket
	 * @throws DBException
	 */
	public void addTicketDetails(Ticket ticket) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into booking_details(user_id,train_id,pnr_no,journey_date,journey_time,booking_date,tickets,passengers,total_price) values( ?,?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			User user = ticket.getUser();
			Train train = ticket.getTrain();
			pst.setInt(1, user.getId());
			pst.setInt(2, train.getId());
			pst.setInt(3, ticket.getPnrNumber());
			Date journeyDate = Date.valueOf(ticket.getJourneyDate());
			pst.setDate(4, journeyDate);
			Time journeyTime = Time.valueOf(ticket.getJourneyTime());
			pst.setTime(5, journeyTime);
			Timestamp bookingDate = Timestamp.valueOf(ticket.getBookingDate());
			pst.setTimestamp(6, bookingDate);
			pst.setInt(7, ticket.getNoOfTickets());
			pst.setString(8, ticket.getPassengers());
			pst.setInt(9, ticket.getTotalPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Book Train");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
}
