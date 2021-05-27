package in.mani.converter;

import java.util.ArrayList;
import java.util.List;

import in.mani.dto.UserDTO;
import in.mani.model.User;

public class UserConverter {

	private UserConverter() {
		// Default Constructor
	}

	/**
	 * This Method Converts DTO object to Model Object
	 * 
	 * @param dto
	 * @return
	 */
	public static User toUser(UserDTO dto) {
		User user = new User();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setMobileNumber(dto.getMobileNumber());
		user.setUserName(dto.getUserName());
		user.setNewpassword(dto.getNewpassword());
		return user;
	}

	/**
	 * This Method Converts Model object to DTO object
	 * 
	 * @param user
	 * @return
	 */
	public static UserDTO toUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setUserName(user.getUserName());
		dto.setNewpassword(user.getNewpassword());

		return dto;
	}

	/**
	 * This method converts List of Model objects to List of DTO objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<UserDTO> toUserDTO(List<User> users) {
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = toUserDTO(user);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * This Method Converts List of DTO objects into Model Objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<User> toUser(List<UserDTO> users) {
		List<User> userList = new ArrayList<User>();
		for (UserDTO user : users) {
			User dto = toUser(user);
			userList.add(dto);
		}
		return userList;
	}

}
