package in.mani.validation;

import in.mani.exception.ValidationException;
import in.mani.model.Admin;

public class AdminLoginValidator {

	private AdminLoginValidator() {
		// Default Constructor
	}

	/**
	 * This Method is used to validate Admin Login
	 * 
	 * @param adminId
	 * @param password
	 */
	public static void validateAdminLogin(String adminId, String password) {
		Admin admin = new Admin();
		if (!admin.getAdminId().equals(adminId) && !admin.getPassword().equals(password)) {
			throw new ValidationException("Invalid Credential");
		}
		if (!admin.getAdminId().equals(adminId) && admin.getPassword().equals(password)) {
			throw new ValidationException("Invalid Admin ID");
		}
		if (admin.getAdminId().equals(adminId) && !admin.getPassword().equals(password)) {
			throw new ValidationException("Invalid Password");
		}
	}
}
