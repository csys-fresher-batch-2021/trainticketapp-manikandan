package in.mani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mani.exception.DBException;
import in.mani.model.User;
import in.mani.util.ConnectionUtil;

public class UserRegisterDAO {

	// Creating Object
	private static final UserRegisterDAO instance = new UserRegisterDAO();

	// This Method returns the object which can be used for access methods in DAO
	public static UserRegisterDAO getInstance() {
		return instance;
	}

	public void addUser(User user) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into users (firstname,lastname,email,mobilenumber,username,newpassword) values (?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setLong(4, user.getMobileNumber());
			pst.setString(5, user.getUserName());
			pst.setString(6, user.getNewpassword());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add User");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<User> getAllUsers() throws DBException {

		List<User> users = new ArrayList<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from users";

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				User user = new User();
				int userId = result.getInt("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				Long mobilenumber = result.getLong("mobilenumber");
				String username = result.getString("username");
				String password = result.getString("newpassword");

				user.setId(userId);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setEmail(email);
				user.setMobileNumber(mobilenumber);
				user.setUserName(username);
				user.setNewpassword(password);

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get User Details");

		} finally {
			ConnectionUtil.close(pst, connection, result);
		}
		return users;

	}
	
	/**
	 * This Method will fetch the user Details by entering username
	 * 
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName) {

		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		User user = new User();

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from users where username= ?";

			pst = connection.prepareStatement(sql);

			pst.setString(1, userName);

			result = pst.executeQuery();

			while (result.next()) {
				int userId = result.getInt("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				Long mobilenumber = result.getLong("mobilenumber");
				String username = result.getString("username");
				String password = result.getString("newpassword");

				user.setId(userId);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setEmail(email);
				user.setMobileNumber(mobilenumber);
				user.setUserName(username);
				user.setNewpassword(password);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get User Details");

		} finally {
			ConnectionUtil.close(pst, connection, result);
		}

		return user;

	}
}
