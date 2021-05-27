package in.mani.model;

import java.sql.Time;

public class Train {
	private Integer trainNumber;
	private String trainName;
	private String source;
	private String destination;
	private Time sourceTime;
	private Time destinationTime;
	private String classType;
	private Integer classTypeFare;
	private Integer classTypeAvailability;

	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Time getSourceTime() {
		return sourceTime;
	}

	public void setSourceTime(Time sourceTime) {
		this.sourceTime = sourceTime;
	}

	public Time getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(Time destinationTime) {
		this.destinationTime = destinationTime;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Integer getClassTypeFare() {
		return classTypeFare;
	}

	public void setClassTypeFare(Integer classTypeFare) {
		this.classTypeFare = classTypeFare;
	}

	public Integer getClassTypeAvailability() {
		return classTypeAvailability;
	}

	public void setClassTypeAvailability(Integer classTypeAvailability) {
		this.classTypeAvailability = classTypeAvailability;
	}

	public Train() {
		// Zero argument Constructor
	}

	public Train(Integer trainNumber, String trainName, String source, String destination, Time sourceTime,
			Time destinationTime, String classType, Integer classTypeFare, Integer classTypeAvailability) {
		super();
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.sourceTime = sourceTime;
		this.destinationTime = destinationTime;
		this.classType = classType;
		this.classTypeFare = classTypeFare;
		this.classTypeAvailability = classTypeAvailability;
	}

	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", trainName=" + trainName + ", source=" + source
				+ ", destination=" + destination + ", sourceTime=" + sourceTime + ", destinationTime=" + destinationTime
				+ ", classType=" + classType + ", classTypeFare=" + classTypeFare + ", classTypeAvailability="
				+ classTypeAvailability + "]";
	}

}
