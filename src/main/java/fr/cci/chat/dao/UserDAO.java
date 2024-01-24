package fr.cci.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.cci.chat.model.User;

public class UserDAO {

	public User findByUsername(String username) {
		String sqlQuery = "SELECT * FROM users WHERE username=?";
		Connection connection = MySQLManager.getInstance().getConnection();
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(sqlQuery);
			pStatement.setString(1, username);
			ResultSet result = pStatement.executeQuery();
			if (result.next() != false) {
				User user = new User();
				user.setId(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
