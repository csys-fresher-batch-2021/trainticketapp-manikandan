package in.mani.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtilTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}

}
