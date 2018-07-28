package br.unipe.mlpIII.Locadora.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class JDBC<T> implements CRUDable<T> {
	protected Connection	conn	= null;
	protected Properties	props	= null;
	
	public boolean getConnection() {
		try {
			Class.forName(props.getProperty("driver"));
			if (conn == null) conn = DriverManager.getConnection(props.getProperty("connStr"),
					props.getProperty("user"), props.getProperty("password"));
			// conn.setSchema(props.getProperty("database"));
		} catch (ClassNotFoundException e) {
			MessageBoxes.Crit("Sistema", e.getMessage(), "Classe nao encontrada");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<String> metaData(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsM = null;
		List<String> metadata = new ArrayList<String>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rsM = rs.getMetaData();
			for (int i = 1; i <= rsM.getColumnCount(); i++)
				metadata.add(rsM.getColumnName(i));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			MessageBoxes.Crit("Sistema", e.getErrorCode() + " — " + e.getMessage(), "Erro SQL");
			e.printStackTrace();
		}
		return metadata;
	}
	
	public JDBC(Properties props) {
		this.props = props;
	}

}
