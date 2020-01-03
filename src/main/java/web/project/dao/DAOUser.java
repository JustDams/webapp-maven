package web.project.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.project.dao.model.User;

public class DAOUser {
	Connection connection;

	public DAOUser(Connection co) {
		this.connection = co;
	}

	public boolean addUser(User user) throws NoSuchAlgorithmException {
		try {
			String query = "SELECT * FROM user WHERE username=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, user.getUsername());

			ResultSet rs = ps.executeQuery();

			if (rs.next() == false) {
				String query2 = "INSERT INTO user(id,username,password) VALUES(null,?,?)";
				ps = connection.prepareStatement(query2);

				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());

				ps.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUser(User user) throws NoSuchAlgorithmException {
		try {
			String query = "SELECT password FROM user where username = ?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, user.getUsername());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (user.getPassword().equals(rs.getString("password"))) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
