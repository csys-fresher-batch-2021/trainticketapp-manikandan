package in.mani.service;

import java.util.HashMap;
import java.util.Map;

import in.mani.exception.TrainValidationException;
import in.mani.validation.TrainValidator;

public class TrainDetailSevices {
	
	private TrainDetailSevices() {
	//Default Constructor
	}

	private static Map<Integer, String> trainList = new HashMap<>();
	// Default adding the Train Name and Train Number
	static {
		trainList.put(12613, "TEJAS EXPRESS");
		trainList.put(12661, "POTHIGAI SUPERFAST EXPRESS");
		trainList.put(12331, "COIMBATORE EXPRESS");
	}
	private static Map<String, Integer> classListPrice = new HashMap<>();
	// Default adding the Class and Fare
	static {
		classListPrice.put("First Class", 760);
		classListPrice.put("Sleeper", 295);
		classListPrice.put("Second Sitting", 180);
	}
	
	/**
	 * This Method is used to add Trains
	 * @param trainNumber
	 * @param trainName
	 */
	public static void addTrains(int trainNumber, String trainName) {
		try {
			TrainValidator.validateTrainDetails(trainNumber, trainName);
			trainList.put(trainNumber, trainName);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new TrainValidationException(e.getMessage());
		}
	}

	/**
	 * This Method is used to get all Train List
	 */
	public static Map<Integer,String> getAllTrainList() {
		return trainList;
	}

	/**
	 * This Method is used to get all Train Class
	 */
	public static Map<String, Integer> getAllTrainClass() {
		return classListPrice;
	}
	
}
