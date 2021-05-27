package in.mani.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mani.exception.ValidationException;

public class EmailValidation {

	private EmailValidation() {
		// Default Constructor
	}

	public static void isValidEmail(String email) {

		if (email == null || email.trim().equals("")) {
			throw new ValidationException("Email Field should not be empty");
		}
		String condition = "[A-Za-z0-9+._-]+@[a-z]+[.][a-z]{2,3}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(email);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Email");
		}
	}
}
