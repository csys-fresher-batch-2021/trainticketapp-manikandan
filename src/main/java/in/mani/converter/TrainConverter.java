package in.mani.converter;

import java.util.ArrayList;
import java.util.List;

import in.mani.dto.TrainDTO;
import in.mani.model.Train;

public class TrainConverter {

	private TrainConverter() {
		// Default Constructor
	}

	/**
	 * This Method Converts DTO object to Model Object
	 * 
	 * @param dto
	 * @return
	 */
	public static Train toTrain(TrainDTO dto) {
		Train train = new Train();
		train.setId(dto.getId());
		train.setTrainNumber(dto.getTrainNumber());
		train.setTrainName(dto.getTrainName());
		train.setSource(dto.getSource());
		train.setDestination(dto.getDestination());
		train.setSourceTime(dto.getSourceTime());
		train.setDestinationTime(dto.getDestinationTime());
		train.setClassType(dto.getClassType());
		train.setClassTypeFare(dto.getClassTypeFare());
		train.setClassTypeAvailability(dto.getClassTypeAvailability());
		return train;
	}

	/**
	 * This Method Converts Model object to DTO object
	 * 
	 * @param user
	 * @return
	 */
	public static TrainDTO toTrainDTO(Train train) {
		TrainDTO dto = new TrainDTO();
		dto.setId(train.getId());
		dto.setTrainNumber(train.getTrainNumber());
		dto.setTrainName(train.getTrainName());
		dto.setSource(train.getSource());
		dto.setDestination(train.getDestination());
		dto.setSourceTime(train.getSourceTime());
		dto.setDestinationTime(train.getDestinationTime());
		dto.setClassType(train.getClassType());
		dto.setClassTypeFare(train.getClassTypeFare());
		dto.setClassTypeAvailability(train.getClassTypeAvailability());
		return dto;
	}

	/**
	 * This method converts List of Model objects to List of DTO objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<TrainDTO> toTrainDTO(List<Train> trains) {
		List<TrainDTO> dtoList = new ArrayList<>();
		for (Train train : trains) {
			TrainDTO dto = toTrainDTO(train);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * This Method Converts List of DTO objects into Model Objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<Train> toTrain(List<TrainDTO> trains) {
		List<Train> userList = new ArrayList<>();
		for (TrainDTO train : trains) {
			Train dto = toTrain(train);
			userList.add(dto);
		}
		return userList;
	}
}
