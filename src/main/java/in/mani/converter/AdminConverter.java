package in.mani.converter;

import java.util.ArrayList;
import java.util.List;

import in.mani.dto.AdminDTO;
import in.mani.model.Admin;


public class AdminConverter {

	private AdminConverter() {
		// Default Constructor
	}

	/**
	 * This Method Converts DTO object to Model Object
	 * 
	 * @param dto
	 * @return
	 */
	public static Admin toAdmin(AdminDTO dto) {
		Admin admin = new Admin();
		admin.setAdminId(dto.getAdminId());
		admin.setPassword(dto.getPassword());
		return admin;
	}

	/**
	 * This Method Converts Model object to DTO object
	 * 
	 * @param user
	 * @return
	 */
	public static AdminDTO toAdminDTO(Admin admin) {
		AdminDTO dto = new AdminDTO();
		dto.setAdminId(admin.getAdminId());
		dto.setPassword(admin.getPassword());
		return dto;
	}
	
	/**
	 * This method converts List of Model objects to List of DTO objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<AdminDTO> toAdminDTO(List<Admin> admins) {
		List<AdminDTO> dtoList = new ArrayList<>();
		for (Admin admin : admins) {
			AdminDTO dto = toAdminDTO(admin);
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
	public static List<Admin> toAdmin(List<AdminDTO> admins) {
		List<Admin> adminList = new ArrayList<>();
		for (AdminDTO admin : admins) {
			Admin dto = toAdmin(admin);
			adminList.add(dto);
		}
		return adminList;
	}


}
