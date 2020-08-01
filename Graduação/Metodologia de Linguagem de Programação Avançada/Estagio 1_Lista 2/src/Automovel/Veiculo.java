package Automovel;

public abstract class Veiculo {
	protected Pessoa proprietario;
	protected String placa;
	protected String marca;
	protected String modelo;
	protected String chassi;
	protected int ano;
	protected double valorKmRodado;
	protected double kmInicial;
	protected double kmFinal;
	protected double valorLocacao;
	
	public Pessoa getProprietario() {
		return proprietario;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getChassi() {
		return chassi;
	}
	public int getAno() {
		return ano;
	}
	public double getValorKmRodado() {
		return valorKmRodado;
	}
	public double getKmInicial() {
		return kmInicial;
	}
	public double getKmFinal() {
		return kmFinal;
	}
	public double getValorLocacao() {
		return valorLocacao;
	}
	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setValorKmRodado(double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}
	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}
	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}
	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	 
	public Veiculo(Pessoa proprietario, String placa, String marca, String modelo, String chassi, int ano,
			double valorKmRodado, double kmInicial, double kmFinal, double valorLocacao) {
		this.proprietario = proprietario;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.ano = ano;
		this.valorKmRodado = valorKmRodado;
		this.kmInicial = kmInicial;
		this.kmFinal = kmFinal;
		this.valorLocacao = (kmInicial - kmFinal) * valorKmRodado;
	}
	@Override
	public String toString() {
		return "Veiculo [\n" + 
				"   proprietario =" + (proprietario != null ? proprietario : "***") + ",\n" +  
				"          placa =" + (placa != null ?  placa : "***") + ",\n" +
				"          marca =" + (marca != null ? marca : "***") + ",\n" +
				"         modelo =" + (modelo != null ? modelo : "***") + ",\n" +
				"         chassi =" + (chassi != null ? chassi : "***") + ",\n" +
				"            ano =" + ano + ",\n" +
				"  valorKmRodado =" + valorKmRodado +",\n" + 
				"      kmInicial =" + kmInicial + ",\n" +
				"        kmFinal =" + kmFinal + ",\n" + 
				"   valorLocacao =" + valorLocacao + "\n]";
	}
	
	
	
}
