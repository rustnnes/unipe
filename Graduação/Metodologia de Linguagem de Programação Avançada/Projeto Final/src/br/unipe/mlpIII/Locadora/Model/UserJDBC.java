package br.unipe.mlpIII.Locadora.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import br.unipe.mlpIII.Locadora.Utils.JDBC;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;

public class UserJDBC extends JDBC<User> {

	@Override
	public void insert(List<User> users) {
		for (User u : users) {
			try {
				PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO Users (usr, pwd) VALUES (?, ?)");
				prepStatement.setString(1, u.getUsr());
				prepStatement.setString(2, u.getPwd());
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(List<User> users) {
		for (User u : users) {
			try {
				PreparedStatement prepStatement = conn.prepareStatement(
						"UPDATE Users (usr, pwd, dateCreated, dateModified) VALUES (?, ?, ?, ?) where id = '"
								+ u.getId() + "'");
				prepStatement.setString(1, u.getUsr());
				prepStatement.setString(2, u.getPwd());
				prepStatement.setDate(3, (java.sql.Date) u.getDateCreated());
				prepStatement.setDate(4, (java.sql.Date) u.getDateModified());
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(List<User> users) {
		for (User u : users) {
			try {
				PreparedStatement prepStatement = conn
						.prepareStatement("DELETE FROM users where id = '" + u.getId() + "'");
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> select(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new LinkedList<User>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next())
				users.add(new User(rs.getString("id"), rs.getString("usr"), rs.getString("pwd"),
						rs.getDate("dateCreated"), rs.getDate("dateModified")));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
		return users;
	}

	public UserJDBC(Properties props) {
		super(props);
	}
}
