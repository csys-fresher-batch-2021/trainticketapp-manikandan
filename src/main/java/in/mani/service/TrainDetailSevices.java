package in.mani.service;

import java.util.HashMap;
import java.util.Map;

public class TrainDetailSevices {

	private static Map<Long, String> trainList = new HashMap<>();
	// Default adding the Train Name and Train Number
	static {
		trainList.put(12613L, "TEJAS EXPRESS");
		trainList.put(12661L, "POTHIGAI SUPERFAST EXPRESS");
		trainList.put(12331L, "COIMBATORE EXPRESS");
	}
	private static Map<String, Integer> classListPrice = new HashMap<>();
	// Default adding the Class and Fare
	static {
		classListPrice.put("First Class", 760);
		classListPrice.put("Sleeper", 295);
		classListPrice.put("Second Sitting", 180);
	}

	/**
	 * This Method is used to get all Train List
	 */
	public static Map<Long, String> getAllTrainList() {
		return trainList;
	}

	/**
	 * This Method is used to get all Train Class
	 */
	public static Map<String, Integer> getAllTrainClass() {
		return classListPrice;
	}
}
