package in.mani.validation;

import java.util.Map;

import in.mani.exception.TrainValidationException;
import in.mani.service.TrainDetailSevices;

public class TrainValidator {

	private TrainValidator() {
		// Default Constructor
	}

	/**
	 * This Method Validates the Train Details
	 * 
	 * @param trainNumber
	 * @param trainName
	 */
	public static void validateTrainDetails(int trainNumber, String trainName) {
		Map<Integer, String> trainList = TrainDetailSevices.getAllTrainList();
		for (int trainNo : trainList.keySet()) {
			if (trainNumber == trainNo) {
				throw new TrainValidationException("Train Number already Exists");
			}
			String noSpaceTrainName = trainList.get(trainNo).replaceAll("\\s", "");
			if (trainName.trim().equalsIgnoreCase((noSpaceTrainName))) {
				throw new TrainValidationException("Train Name already Exists");
			}
			if (trainName == null || trainName.trim().equals("")) {
				throw new TrainValidationException("Invalid Train Name");
			}
		}
	}
}
