package br.unipe.mlpIII.Conta;

public class Conta {
	
	private int	id;
	private String numero;
	private double	saldo;
	private boolean	status;
	private String	titular;
	
	public int getId() {
		return id;
	}
	public String getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public boolean isStatus() {
		return status;
	}
	public String getTitular() {
		return titular;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public Conta(int id, String numero, double saldo, boolean status, String titular) {
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.status = status;
		this.titular = titular;
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", status=" + status + ", titular="
				+ titular + "]";
	}
	
	
}
