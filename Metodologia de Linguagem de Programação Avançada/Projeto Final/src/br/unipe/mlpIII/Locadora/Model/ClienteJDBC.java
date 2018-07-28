package br.unipe.mlpIII.Locadora.Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import br.unipe.mlpIII.Locadora.Utils.JDBC;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;

public class ClienteJDBC extends JDBC<Cliente> {
	//private ClienteJDBC instance;
	
	@Override
	public void insert(List<Cliente> clientes) {
		for (Cliente c : clientes) {
			try {
				PreparedStatement prepStatement = conn.prepareStatement(
						"INSERT INTO Clientes (id, nome, cpf, dataNasc, sexo, salario) VALUES (NEWID() , ?, ?, ?, ?, ?)");
				prepStatement.setString(1, c.getNome());
				prepStatement.setString(2, c.getCpf());
				prepStatement.setDate(3, (Date) c.getDataNasc());
				prepStatement.setString(4, c.getSexo());
				prepStatement.setDouble(5, c.getSalario());
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(List<Cliente> clientes) {
		for (Cliente c : clientes) {
			try {
				PreparedStatement prepStatement = conn.prepareStatement(
						"UPDATE Clientes (nome, cpf, dataNasc, sexo, salario) VALUES (?, ?, ?, ?, ?) where id = '"
								+ c.getId() + "'");
				prepStatement.setString(1, c.getNome());
				prepStatement.setString(2, c.getCpf());
				prepStatement.setDate(3, (Date) c.getDataNasc());
				prepStatement.setString(4, c.getSexo());
				prepStatement.setDouble(5, c.getSalario());
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(List<Cliente> clientes) {
		for (Cliente c : clientes) {
			try {
				PreparedStatement prepStatement = conn
						.prepareStatement("DELETE FROM Clientes where id = '" + c.getId() + "'");
				prepStatement.executeUpdate();
				prepStatement.close();
			} catch (SQLException e) {
				MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Cliente> select(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new LinkedList<Cliente>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next())
				clientes.add(new Cliente(rs.getString("id"), rs.getString("nome"), rs.getString("cpf"),
						rs.getDate("dataNasc"), rs.getString("sexo"), rs.getDouble("salario")));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
		return clientes;
	}

	public ClienteJDBC(Properties props) {
		super(props);
		// TODO possibilitar Singleton aqui
		this.getConnection();
	}

//	public ClienteJDBC getInstance(Properties props) {
//		if (instance == null) instance = new ClienteJDBC(props);
//		return instance;
//	}
}
