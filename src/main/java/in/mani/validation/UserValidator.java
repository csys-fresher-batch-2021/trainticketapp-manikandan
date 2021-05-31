package in.mani.validation;

import java.util.List;

import in.mani.dao.UserRegisterDAO;
import in.mani.dto.UserDTO;
import in.mani.exception.ValidationException;
import in.mani.model.User;
import in.mani.util.EmailValidation;
import in.mani.util.MobileNumberValidation;
import in.mani.util.NameValidation;
import in.mani.util.PasswordValidation;
import in.mani.util.UserNameValidation;

public class UserValidator {
	private UserValidator() {
		// Default Constructor
	}

	public static void isValidUser(UserDTO userDTO,String confirmPassword) {

		try {
			if(!userDTO.getNewpassword().equals(confirmPassword)) {
				throw new ValidationException("Password Not Matches");
			}
			NameValidation.isValidName(userDTO.getFirstName());
			NameValidation.isValidName(userDTO.getLastName());
			EmailValidation.isValidEmail(userDTO.getEmail());
			MobileNumberValidation.isValidMobileNumber(userDTO.getMobileNumber());
			UserNameValidation.isValidUserName(userDTO.getUserName());
			PasswordValidation.isValidPassword(userDTO.getNewpassword());

			UserValidator.isSameUser(userDTO);
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public static void isSameUser(UserDTO userDTO) {
		UserRegisterDAO userDAO = UserRegisterDAO.getInstance();
		List<User> allUsers = userDAO.getAllUsers();
		for (User userObj : allUsers) {
			if (userDTO.getEmail().equals(userObj.getEmail())) {
				throw new ValidationException("Email ID Already Registered");
			}
			if (userDTO.getMobileNumber().equals(userObj.getMobileNumber())) {
				throw new ValidationException("Mobile Number Already Registered");
			}
			if (userDTO.getUserName().equals(userObj.getUserName())) {
				throw new ValidationException("User Name Already Registered");
			}
		}
	}
}
