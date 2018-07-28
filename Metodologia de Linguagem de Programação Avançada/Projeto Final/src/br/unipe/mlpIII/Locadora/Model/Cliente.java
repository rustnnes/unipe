package br.unipe.mlpIII.Locadora.Model;

import java.util.Comparator;
import java.util.Date;

public class Cliente implements Comparable <Cliente> {
	protected String	id;
	protected String	nome;
	protected String	cpf;
	protected Date		dataNasc;
	protected String	sexo;
	protected double	salario;

	public	String	getId() 					{ return id; }
	public	void 	setId(String id) 			{ this.id = id; }

	public	String	getNome() 					{ return nome; }
	public	void 	setNome(String nome) 		{ this.nome = nome; }

	public	String	getCpf() 					{ return cpf; }
	public	void	setCpf(String cpf) 			{ this.cpf = cpf; }

	public	Date	getDataNasc() 				{ return dataNasc; }
	public	void	setDataNasc(Date dataNasc) 	{ this.dataNasc = dataNasc; }

	public	String	getSexo() 					{ return sexo; }
	public	void	setSexo(String sexo)		{ this.sexo = sexo; }

	public	double	getSalario() 				{ return salario; }
	public	void	setSalario(double salario) 	{ this.salario = salario; }

	public Cliente(String id, String nome, String cpf, Date dataNasc, String sexo, double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", sexo=" + sexo
				+ ", salario=" + salario + "]";
	}

	@Override
	public int compareTo(Cliente cliente) {
		return id.compareTo(cliente.id);
	}

	public static final Comparator <Cliente> NOME = new Comparator <Cliente>() {
		@Override
		public int compare(Cliente cli1, Cliente cli2) {
			return cli1.nome.compareToIgnoreCase(cli2.nome);
		}
	};

}
