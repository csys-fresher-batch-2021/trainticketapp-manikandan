package in.mani.validation;

import java.util.List;

import in.mani.dto.UserDTO;
import in.mani.exception.ValidationException;
import in.mani.service.UserRegisterService;

public class UserLoginValidator {

	private UserLoginValidator() {
		// Default Constructor
	}

	public static void isValidLogin(String userName, String password) {
		List<UserDTO> users = UserRegisterService.getUsers();
		boolean valid = false;
		if ((userName != null) && (password != null)) {
			for (UserDTO userDTO : users) {
				if (userName.equals(userDTO.getUserName()) && (password.equals(userDTO.getNewpassword()))) {
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
