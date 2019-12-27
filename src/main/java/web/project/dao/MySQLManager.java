package web.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	private static MySQLManager instance;
	@SuppressWarnings("unused")
	private Statement statement = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/maven_bdd?serverTimezone=Europe/Paris";
	private String user = "root";
	private String mdp = "";

	private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, mdp);
			this.statement = this.connection.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
