package br.unipe.mlpIII.Locadora.Model;

import java.util.Comparator;

import br.unipe.mlpIII.Locadora.Utils.Combustivel;
import br.unipe.mlpIII.Locadora.Utils.Cores;

public class Veiculo implements Comparable<Veiculo> {

	private String id;
	private String idCliente;
	private String marca;
	private String modelo;
	private String chassis;
	private int ano;
	private Combustivel combustivel;
	private Cores cor;
	
	public String getId() {
		return this.id;
	}
	public String getIdCliente() {
		return this.idCliente;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	public String getChassis() {
		return this.chassis;
	}
	public int getAno() {
		return this.ano;
	}
	public Combustivel getCombustivel() {
		return this.combustivel;
	}
	public Cores getCor() {
		return this.cor;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public void setCor(Cores cor) {
		this.cor = cor;
	}

	public Veiculo(String id, String idCliente, String marca, String modelo, String chassis, int ano,
			Combustivel combustivel, Cores cor) {
		this.id = id;
		this.idCliente = idCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.chassis = chassis;
		this.ano = ano;
		this.combustivel = combustivel;
		this.cor = cor;
	}

	@Override
	public int compareTo(Veiculo v) {
		if(this.ano < v.ano) return -1;
		if(this.ano > v.ano) return 1;
		return 0;
	}
	
	public static final Comparator <Veiculo> CHASSIS = new Comparator <Veiculo>() {
		@Override
		public int compare(Veiculo v1, Veiculo v2) {
			return v1.chassis.compareToIgnoreCase(v2.chassis);
		}
	};
}
