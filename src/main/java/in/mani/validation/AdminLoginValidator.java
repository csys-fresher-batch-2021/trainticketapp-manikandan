package in.mani.validation;

import java.util.List;

import in.mani.dto.AdminDTO;
import in.mani.exception.ValidationException;
import in.mani.service.AdminServices;

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
		List<AdminDTO> admins = AdminServices.getAdmins();
		boolean valid = false;
		if ((adminId != null) && (password != null)) {
			for (AdminDTO adminDTO : admins) {
				if (adminId.equals(adminDTO.getAdminId()) && (password.equals(adminDTO.getPassword()))) {
					valid = true;
					break;
				}
			}
			if (!valid) {
				throw new ValidationException("Invalid Login");
			}
		} else {
			throw new ValidationException("User Name or Password should not be empty");
		}
	}

}
