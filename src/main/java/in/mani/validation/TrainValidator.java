package in.mani.validation;

import java.util.List;

import in.mani.dao.TrainDAO;
import in.mani.dto.TrainDTO;
import in.mani.exception.ValidationException;
import in.mani.model.Train;
import in.mani.util.NameValidation;
import in.mani.util.NumberValidator;

public class TrainValidator {

	private TrainValidator() {
		// Default Constructor
	}

	/**
	 * This Method Validates the Train Details
	 * 
	 * @param trainDTO
	 */
	public static void isValidTrainDetails(TrainDTO trainDTO) {

		try {
			TrainNumberValidator.isValidtrainNumber(trainDTO.getTrainNumber());
			NameValidation.isValidName(trainDTO.getTrainName());
			NameValidation.isValidName(trainDTO.getSource());
			NameValidation.isValidName(trainDTO.getDestination());
			NumberValidator.isValidNumber(trainDTO.getClassTypeFare());
			NumberValidator.isValidNumber(trainDTO.getClassTypeAvailability());
			TrainValidator.isSameTrain(trainDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
	}

	public static void isSameTrain(TrainDTO trainDTO) {
		TrainDAO trainDAO = TrainDAO.getInstance();
		List<Train> allTrains = trainDAO.getAllTrains();
		for (Train trainObj : allTrains) {
			if (trainDTO.getTrainNumber().equals(trainObj.getTrainNumber())) {
				throw new ValidationException("Train Number Already Exists");
			}
			if (trainDTO.getTrainName().equals(trainObj.getTrainName())) {
				throw new ValidationException("Train Name Already Exists");
			}
		}
	}

	public static void isTrainExists(List<Train> trains) {
		if (trains.isEmpty()) {
			throw new ValidationException("NO Matching Train Found");
		}

	}

}
