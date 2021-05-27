package in.mani.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mani.exception.ValidationException;

public class TrainNumberValidator {

	private TrainNumberValidator() {
		// Default Constructor
	}

	/**
	 * This Method Checks the Train Number Whether it is Valid or Not
	 * 
	 * @param trainNumber
	 */
	public static void isValidtrainNumber(int trainNumber) {
		String trainNumberStr = String.valueOf(trainNumber);
		String condition = "[1-9]{1}[0-9]{4}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(trainNumberStr);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Train Number");
		}

	}
}
