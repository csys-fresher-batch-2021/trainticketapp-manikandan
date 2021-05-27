package in.mani.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mani.exception.ValidationException;

public class NameValidation {

	private NameValidation() {
		// Default Constructor
	}

	public static void isValidName(String name) {
		if (name == null || name.trim().equals("")) {
			throw new ValidationException("Name Field should not be Empty");
		}
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(name);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Name");
		}
	}
}
