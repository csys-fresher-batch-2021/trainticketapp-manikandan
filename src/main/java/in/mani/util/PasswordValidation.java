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
		String condition = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(password);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Password");
		}
		if (password.length() < 7 || password.length() > 20) {
			throw new ValidationException("Password must contains greater than 8 Characters");
		}
	}
}
