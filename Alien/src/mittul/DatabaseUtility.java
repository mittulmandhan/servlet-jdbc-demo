package mittul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public final class DatabaseUtility {
//	private static DatabaseConnection dbConnection;
	private static Connection connection;

	static {
		connection = createConnection();
	}

	private DatabaseUtility() {

	}

	private static Connection createConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName = "servlet_jdbc_demo";
		String dbUserName = "root";
		String dbPassword = "root";

		Connection con = null;

		try {
			con = DriverManager.getConnection(dbURL + dbName, dbUserName, dbPassword);
			System.out.println("connection created");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	public static Connection getConnection() {
		return connection;
	}
}
