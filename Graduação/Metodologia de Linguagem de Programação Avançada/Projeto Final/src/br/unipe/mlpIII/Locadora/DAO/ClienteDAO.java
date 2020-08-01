package br.unipe.mlpIII.Locadora.DAO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.unipe.mlpIII.Locadora.Model.Cliente;
import br.unipe.mlpIII.Locadora.Model.ClienteJDBC;
import br.unipe.mlpIII.Locadora.View.Main;

public final class ClienteDAO {
	private static final String stdQry = "select * from clientes";
	private static ClienteJDBC connClientes = new ClienteJDBC(Main.getProperties());

	public static List<Cliente> getClientes() {
		List<Cliente> clientes = new LinkedList<Cliente>();
		if(connClientes.getConnection()) clientes.addAll(connClientes.select(stdQry));
			
		return clientes;
	}
	
	public static Cliente getCliente(String id) {
		Cliente cliente = null;
		if(connClientes.getConnection()){
			List<Cliente> clientes = new LinkedList<Cliente>();
			clientes.addAll(connClientes.select(stdQry + " where id = '" + id + "'"));
			if(clientes.size() == 1) 
				cliente = clientes.get(0);
		}
		
		return cliente;
	}
	
	public List<String> metaData(String where){
		List<String> cliMetaData = new ArrayList<String>();
		if(connClientes.getConnection()) cliMetaData.addAll(connClientes.metaData(stdQry));
			
		return cliMetaData;
	}
}
