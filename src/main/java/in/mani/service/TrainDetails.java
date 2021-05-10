package in.mani.service;
import java.util.HashMap;
import java.util.Map;

public class TrainDetails {

	static Map<Long, String> trainList = new HashMap<Long, String>();
	// Default adding the Train Name and Train Number
	static {
		trainList.put(12613L, "TEJAS EXPRESS");
		trainList.put(12661L, "POTHIGAI SUPERFAST EXPRESS");
		trainList.put(12331L, "COIMBATORE EXPRESS");
	}
	static Map<String, Integer> classListPrice1 = new HashMap<String, Integer>();
	// Default adding the Class and Fare
	static {
		classListPrice1.put("First Class", 760);
		classListPrice1.put("Sleeper", 295);
		classListPrice1.put("Second Sitting", 180);
	}
	static Map<String, Integer> classListPrice2 = new HashMap<String, Integer>();
	// Default adding the Class and Fare
	static {
		classListPrice2.put("Chair Car", 625);
		classListPrice2.put("Second Sitting", 175);
	}
	static Map<String, Integer> classListPrice3 = new HashMap<String, Integer>();
	// Default adding the Class and Fare
	static {
		classListPrice3.put("Second Sitting", 230);
	}
	// Default adding the Train Number with its respective Class and Fare
	static Map<Long, HashMap<String, Integer>> trainDetails = new HashMap<Long, HashMap<String, Integer>>();
	static {
		trainDetails.put(12661L, (HashMap<String, Integer>) classListPrice1);
		trainDetails.put(12613L, (HashMap<String, Integer>) classListPrice2);
		trainDetails.put(12331L, (HashMap<String, Integer>) classListPrice3);
	}

	/**
	 * This Method is used to Display Train Details
	 * @return
	 * Train Details
	 */
	public static HashMap<Long, HashMap<String, Integer>> displayTrainDetails() {
		System.out.println("------------Train List-------------");
		for (long trainNumber : trainList.keySet()) {
			System.out.println("\n" + trainList.get(trainNumber) + "(" + trainNumber + ")");
			System.out.println("\n" + trainDetails.get(trainNumber));
			System.out.println("-----------------------------------");
		}
		return (HashMap<Long, HashMap<String, Integer>>) trainDetails;
	}
}

