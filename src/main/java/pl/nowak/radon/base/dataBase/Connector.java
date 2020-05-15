package pl.nowak.radon.base.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	static String url = "jdbc:sqlserver://DESKTOP-GFR3HJ0:1433;instanceName=;databaseName=Radon";
	static String username = "DESKTOP-GFR3HJ0\\nowak";
	static String password = "";

	static public void ConnectTest() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connected");
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
