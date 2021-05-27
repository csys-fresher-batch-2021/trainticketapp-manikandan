package in.mani.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.mani.exception.DBException;

import java.sql.Connection;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default Constructor
	}

	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String DATABASE_NAME = System.getenv("spring.datasource.url");
	private static final String DB_USERNAME = System.getenv("spring.datasource.username");
	private static final String DB_PASSWORD = System.getenv("spring.datasource.password");
	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME; // jdbc:postgres://localhost:5432/shoppingapp_db

	public static Connection getConnection() {

		Connection connection = null;
		try {
			// Step 1: Load the database driver into memory ( ClassNotFoundException )
			Class.forName(DRIVER_CLASS_NAME);

			// Step 2: Get the Database Connection (SQLException)
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to get the database connection");
		}

		return connection;
	}

	public static void close(PreparedStatement pst, Connection con) {
		// Null Check - to avoid Null Pointer Exception
		try {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to close the connection");
		}
	}

	public static void close(PreparedStatement pst, Connection con, ResultSet rs) {
		// Null Check - to avoid Null Pointer Exception
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to close the connection");
		}
	}
}
