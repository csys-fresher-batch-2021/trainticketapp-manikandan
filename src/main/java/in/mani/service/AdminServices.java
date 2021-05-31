package in.mani.service;

import java.util.List;

import in.mani.converter.AdminConverter;
import in.mani.dao.AdminDAO;
import in.mani.dto.AdminDTO;
import in.mani.model.Admin;

public class AdminServices {

	private AdminServices() {
		// Default Constructor
	}
	
	/**
	 * This Method is Used to fetch All Admins
	 * 
	 * @return
	 */
	public static List<AdminDTO> getAdmins() {
		AdminDAO adminDAO = AdminDAO.getInstance();
		List<Admin> allAdmins = adminDAO.getAllAdmins();
		return AdminConverter.toAdminDTO(allAdmins);
	}
}
