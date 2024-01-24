package fr.cci.chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {
	
	private static MySQLManager instance = null;
	
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}
	
	public static MySQLManager getInstance() {
		if(instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}
	
	public MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbcci", 
					"root", 
					"root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
