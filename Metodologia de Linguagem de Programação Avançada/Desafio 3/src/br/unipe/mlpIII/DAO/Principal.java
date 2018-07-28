package br.unipe.mlpIII.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.mlpIII.Conta.Conta;

public class Principal {

	public static void main(String[] args) {
		String connStr = "jdbc:postgresql://localhost:1521/bancario";
		String user = "postgres";
		String pass = "123456";
		List<Conta> listaContas = new ArrayList<Conta>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(connStr, user, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from conta");
			while (rs.next()) 
				listaContas.add(new Conta(rs.getInt("id"), rs.getString("numero"), rs.getDouble("saldo"),
						rs.getBoolean("status"), rs.getString("titular")));
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Erro! Classe nao encontrada!\n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erro SQL!\n");
			e.printStackTrace();
		}
		
		listaContas.forEach(c -> System.out.println(c));
	}

}
