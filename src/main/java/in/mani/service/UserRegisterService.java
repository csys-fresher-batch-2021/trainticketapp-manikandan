package in.mani.service;

import java.util.List;

import in.mani.converter.UserConverter;
import in.mani.dao.UserRegisterDAO;
import in.mani.dto.UserDTO;
import in.mani.exception.ServiceException;
import in.mani.model.User;
import in.mani.validation.UserValidator;

public class UserRegisterService {

	private UserRegisterService() {
		// Default Constructor
	}

	/**
	 * This Method is used to Register the User
	 * 
	 * @param userDTO
	 */
	public static void registerUser(UserDTO userDTO,String confirmPassword) {

		try {
			UserValidator.isValidUser(userDTO,confirmPassword);
			UserRegisterDAO userDAO = UserRegisterDAO.getInstance();
			User user = UserConverter.toUser(userDTO);
			userDAO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is Used to fetch All Users
	 * 
	 * @return
	 */
	public static List<UserDTO> getUsers() {
		UserRegisterDAO userDAO = UserRegisterDAO.getInstance();
		List<User> allUsers = userDAO.getAllUsers();
		return UserConverter.toUserDTO(allUsers);
	}

}
