package in.mani.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mani.exception.ValidationException;

public class UserNameValidation {
	private UserNameValidation() {
		// default Constructor
	}

	public static void isValidUserName(String userName) {
		if (userName == null || userName.trim().equals("")) {
			throw new ValidationException("User Name should not be empty");
		}
		String condition = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(userName);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid User Name");
		}
	}

}
