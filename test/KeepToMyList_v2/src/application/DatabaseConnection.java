package application;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	Connection databaseLink;

	public Connection getConnection() {
		String databasName = "general-purpose";
		String databaseLogin = "root";
		String databasePassword = "loralor6";
		String URL = "jdbc:mysql://localhost:3306/"+databasName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(URL,databaseLogin,databasePassword);
		} catch(Exception e) {
			e.getStackTrace();
		}
		return databaseLink;
	}
}
