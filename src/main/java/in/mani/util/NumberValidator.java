package in.mani.util;

import in.mani.exception.ValidationException;

public class NumberValidator {

	private NumberValidator() {
		// Default Constructor
	}

	/**
	 * This Method Checks the Number Whether it is Valid or Not
	 * 
	 * @param mobileNumber
	 */
	public static void isValidNumber(int number) {

		if (number == 0 || number < 0 || number > 2147483647) {
			throw new ValidationException("Number should not be Negative");
		}
	}
}
