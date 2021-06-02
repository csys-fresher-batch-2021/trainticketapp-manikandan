package in.mani.dto;

public class AdminDTO {

	private Integer id;
	private String adminId;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminId=" + adminId + ", password=" + password + "]";
	}

	public AdminDTO(Integer id, String adminId, String password) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.password = password;
	}
}
