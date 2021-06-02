package in.mani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mani.exception.DBException;
import in.mani.model.Admin;
import in.mani.util.ConnectionUtil;

public class AdminDAO {

	// Creating Object
		private static final AdminDAO instance = new AdminDAO();

		// This Method returns the object which can be used for access methods in DAO
		public static AdminDAO getInstance() {
			return instance;
		}
		
		public List<Admin> getAllAdmins() throws DBException {

			List<Admin> admins = new ArrayList<>();
			Connection connection = null;
			ResultSet result = null;
			PreparedStatement pst = null;

			try {

				connection = ConnectionUtil.getConnection();

				String sql = "select * from employees";

				pst = connection.prepareStatement(sql);

				result = pst.executeQuery();

				while (result.next()) {
					Admin admin = new Admin();
					int adminId = result.getInt("id");
					String adminName = result.getString("admin_name");
					String adminPassword = result.getString("admin_password");
					
					admin.setId(adminId);
					admin.setAdminId(adminName);
					admin.setPassword(adminPassword);

					admins.add(admin);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Unable to Get Admin Details");

			} finally {
				ConnectionUtil.close(pst, connection, result);
			}
			return admins;

		}

}
