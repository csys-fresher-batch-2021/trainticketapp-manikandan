package in.mani.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

	private static final String BASE_QUERY = "select b.id,u.username as user_name, t.trainnumber as train_number, t.trainname as train_name, b.pnr_no as pnr_number ,b.booking_date, b.journey_date ,b.journey_time , b.tickets,b.passengers,b.total_price, b.status from users u, trains t , booking_details b where b.user_id = u.id and b.train_id = t.id" + "";
	
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
			throw new DBException("Unable to Book Train");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This Method Retrieves the Booking Details of the User
	 * @param userId
	 * @return
	 */
	public List<Ticket> getUserBookings(Integer userId) {
		final List<Ticket> tickets = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try { 
			// Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = BASE_QUERY + " and u.id= ?" + "order by b.status asc";
			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			pst.setInt(1, userId);

			result = pst.executeQuery();

			while (result.next()) {

				Ticket ticket = toRow(result);

				tickets.add(ticket);
			}

		} catch (SQLException e) {
			throw new DBException("Unable to Fetch Train Details");
		} finally {
			// Closing the Connection
			ConnectionUtil.close(pst, connection,result);
		}

		return tickets;
	}
	
	/**
	 * This Method is Used to Cancel the Booking Done by the User
	 * @param id
	 */
	public void cancelBooking(Integer id) {

		Connection connection = null;

		PreparedStatement pst = null;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "update booking_details set status = 'CANCELLED' where id = ?";

			// Execution Step
			pst = connection.prepareStatement(sql);

			pst.setInt(1, id);

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("Unable to Update Train Details");
		} finally {

			// Closing the Session
			ConnectionUtil.close(pst, connection);

		}

	}
	
	
	/**
	 * This Method is Used to fetch All booking Details Done by the User
	 * @return
	 */
	public List<Ticket> getAllBookings() {

		final List<Ticket> tickets = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try { // Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			// Executing Query Statement
			String sql = BASE_QUERY ;
			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {

				Ticket ticket = toRow(result);
				tickets.add(ticket);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Trains");
		} finally {
			// Closing the Connection
			ConnectionUtil.close( pst, connection,result);
		}

		return tickets;
	}

	
	/**
	 * This Method get the input from the Database and store in the ticket object
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private Ticket toRow(ResultSet result) throws SQLException {
		Ticket ticket = new Ticket();
		Train train = new Train();
		User user = new User();
		Integer id = result.getInt("id");
		String name = result.getString("user_name");
		Integer trainNumber = result.getInt("train_number");
		String trainName = result.getString("train_name");
		Integer pnrNumber = result.getInt("pnr_number");
		Timestamp bookingDate = result.getTimestamp("booking_date");
		LocalDateTime bDate = bookingDate.toLocalDateTime();
		Date date = result.getDate("journey_date");
		LocalDate journeyDate = date.toLocalDate();
		Time time = result.getTime("journey_time");
		LocalTime journeyTime = time.toLocalTime();
		Integer noOftickets = result.getInt("tickets");
		String passengers = result.getString("passengers");
		int price = result.getInt("total_price");
		String status = result.getString("status");
		
		
		user.setUserName(name);
		train.setTrainNumber(trainNumber);
		train.setTrainName(trainName);
		
		ticket.setId(id);
		ticket.setTrain(train);
		ticket.setUser(user);
		ticket.setPnrNumber(pnrNumber);
		ticket.setBookingDate(bDate);
		ticket.setJourneyDate(journeyDate);
		ticket.setJourneyTime(journeyTime);
		ticket.setNoOfTickets(noOftickets);
		ticket.setPassengers(passengers);
		ticket.setTotalPrice(price);
		ticket.setStatus(status);
		
		
		return ticket;
	}

	}
