package Automovel;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private int idade;
	private char sexo;
	private EstadoCivil estadoCivil;
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public int getIdade() {
		return idade;
	}
	public char getSexo() {
		return sexo;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Pessoa(String nome, String sobrenome, String cpf, String rg, int idade, char sexo, EstadoCivil estadoCivil) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}
	
	
	
	
}
