package in.mani.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket {

	private Integer id;

	private User user;

	private Train train;

	private int pnrNumber;

	private LocalDate journeyDate;

	private LocalTime journeyTime;

	private LocalDateTime bookingDate;

	private Integer noOfTickets;

	private String passengers;

	private int totalPrice;

	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Train getTrain() {
		return train;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public LocalTime getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(LocalTime journeyTime) {
		this.journeyTime = journeyTime;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Ticket() {
		// Default Constructor
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", user=" + user + ", train=" + train + ", pnrNumber=" + pnrNumber
				+ ", journeyDate=" + journeyDate + ", journeyTime=" + journeyTime + ", bookingDate=" + bookingDate
				+ ", noOfTickets=" + noOfTickets + ", passengers=" + passengers + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}

	public Ticket(Integer id, User user, Train train, int pnrNumber, LocalDate journeyDate, LocalTime journeyTime,
			LocalDateTime bookingDate, Integer noOfTickets, String passengers, int totalPrice, String status) {
		super();
		this.id = id;
		this.user = user;
		this.train = train;
		this.pnrNumber = pnrNumber;
		this.journeyDate = journeyDate;
		this.journeyTime = journeyTime;
		this.bookingDate = bookingDate;
		this.noOfTickets = noOfTickets;
		this.passengers = passengers;
		this.totalPrice = totalPrice;
		this.status = status;
	}
}