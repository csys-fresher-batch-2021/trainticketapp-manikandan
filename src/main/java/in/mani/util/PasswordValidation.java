package in.mani.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mani.exception.ValidationException;

public class PasswordValidation {

	private PasswordValidation() {
		// Default Constructor
	}

	public static void isValidPassword(String password) {

		if (password == null || password.trim().equals("")) {
			throw new ValidationException("Password Cannot be Null");
		}
		String condition = "[a-zA-Z0-9@#$%^&+=\\s*]{8,}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(password);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Password");
		}
		if (password.length() < 7 || password.length() > 15) {
			throw new ValidationException("Invalid Password");
		}
	}
}
