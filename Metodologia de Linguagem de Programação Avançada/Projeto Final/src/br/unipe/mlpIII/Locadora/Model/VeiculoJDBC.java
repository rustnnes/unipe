package br.unipe.mlpIII.Locadora.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import br.unipe.mlpIII.Locadora.Utils.Combustivel;
import br.unipe.mlpIII.Locadora.Utils.Cores;
import br.unipe.mlpIII.Locadora.Utils.JDBC;
import br.unipe.mlpIII.Locadora.Utils.MessageBoxes;

public class VeiculoJDBC extends JDBC<Veiculo> {

	@Override
	public void insert(List<Veiculo> veiculos) {
		try {
			for(Veiculo veiculo : veiculos){
				PreparedStatement prepStatement = conn.prepareStatement(
						"INSERT INTO Veiculos (id, idCliente, marca, modelo, chassis, ano, combustivel, cor) VALUES (NEWID() , ?, ?, ?, ?, ?, ?, ?)");
				prepStatement.setString(1, veiculo.getIdCliente());
				prepStatement.setString(2, veiculo.getMarca());
				prepStatement.setString(3, veiculo.getModelo());
				prepStatement.setString(4, veiculo.getChassis());
				prepStatement.setInt(5, veiculo.getAno());
				prepStatement.setInt(6, veiculo.getCombustivel().toInt());
				prepStatement.setInt(7, veiculo.getCor().toInt());
				prepStatement.executeUpdate();
				prepStatement.close();
			}
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<Veiculo> veiculos) {
		try {
			for(Veiculo veiculo : veiculos){
				PreparedStatement prepStatement = conn.prepareStatement(
						"UPDATE Veiculos SET id = '?', idCliente = '?', marca = '?', modelo = '?', chassis = '?', ano = '?', "
						+ "combustivel = '?', cor = '?' WHERE id = '"
								+ veiculo.getId() + "'");
				prepStatement.setString(1, veiculo.getIdCliente());
				prepStatement.setString(2, veiculo.getMarca());
				prepStatement.setString(3, veiculo.getModelo());
				prepStatement.setString(4, veiculo.getChassis());
				prepStatement.setInt(5, veiculo.getAno());
				prepStatement.setInt(6, veiculo.getCombustivel().toInt());
				prepStatement.setInt(7, veiculo.getCor().toInt());
				prepStatement.executeUpdate();
				prepStatement.close();
			}
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<Veiculo> veiculos) {
		try {
			for(Veiculo veiculo : veiculos){
				PreparedStatement prepStatement = conn.prepareStatement("DELETE FROM Veiculos where id = '" + veiculo.getId() + "'");
				prepStatement.executeUpdate();
				prepStatement.close();
			}
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
	}

	@Override
	public List <Veiculo> select(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		List <Veiculo> veiculos = new LinkedList <Veiculo>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next())
				veiculos.add(new Veiculo(rs.getString("id"), rs.getString("idCliente"), rs.getString("marca"), 
						rs.getString("modelo"), rs.getString("chassis"), rs.getInt("ano"), 
						Combustivel.values()[rs.getInt("combustivel")], Cores.values()[rs.getInt("cor")]));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
		return veiculos;
	}

	public VeiculoJDBC(Properties props) {
		super(props);
	}
}
