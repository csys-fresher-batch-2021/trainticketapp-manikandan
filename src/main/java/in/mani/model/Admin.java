package in.mani.model;

public class Admin {

	private String adminId;

	public String getAdminId() {
		return adminId;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public Admin() {
		super();
		this.adminId = "admin";
		this.password = "admin123";
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + "]";
	}

}
