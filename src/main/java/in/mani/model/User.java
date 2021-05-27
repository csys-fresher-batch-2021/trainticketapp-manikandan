package in.mani.model;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private Long mobileNumber;
	private String userName;
	private String newpassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, Long mobileNumber, String userName,
			String newpassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.newpassword = newpassword;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", userName=" + userName + ", newpassword=" + newpassword + "]";
	}

}
