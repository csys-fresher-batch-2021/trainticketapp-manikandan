package in.mani.dto;

public class AdminDTO {

	private String adminId;
	private String password;
	
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public AdminDTO() {
		super();
	}

	public AdminDTO(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + "]";
	}
}
