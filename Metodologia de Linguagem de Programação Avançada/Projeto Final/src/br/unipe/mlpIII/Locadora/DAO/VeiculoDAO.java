package br.unipe.mlpIII.Locadora.DAO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.unipe.mlpIII.Locadora.Model.Cliente;
import br.unipe.mlpIII.Locadora.Model.Veiculo;
import br.unipe.mlpIII.Locadora.Model.VeiculoJDBC;
import br.unipe.mlpIII.Locadora.View.Main;

public class VeiculoDAO {
	private static final String stdQry = "select * from veiculos";
	private static VeiculoJDBC connVeiculos = new VeiculoJDBC(Main.getProperties());

	public static List<Veiculo> getVeiculos() {
		List<Veiculo> veiculos = new LinkedList<Veiculo>();
		if(connVeiculos.getConnection()) veiculos.addAll(connVeiculos.select(stdQry));
			
		return veiculos;
	}
	
	public static Cliente getProprietarioVeiculo(String id) {
		Cliente cliente = null;
		if(connVeiculos.getConnection()) {
			List<Veiculo> veiculos = new LinkedList<Veiculo>();
			veiculos.addAll(connVeiculos.select(stdQry + " where id = '" + id + "';"));
			if(veiculos.size() == 1)
				cliente = ClienteDAO.getCliente(veiculos.get(0).getIdCliente());
		}
		
		return cliente;
	}
	
	public List<String> metaData(String where){
		List<String> veiMetaData = new ArrayList<String>();
		if(connVeiculos.getConnection()) veiMetaData.addAll(connVeiculos.metaData(stdQry));
			
		return veiMetaData;
	}
}
