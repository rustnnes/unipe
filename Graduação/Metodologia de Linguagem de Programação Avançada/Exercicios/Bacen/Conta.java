package Bacen;

public class Conta {

	protected String numero;
	protected double saldo;

	public String getNumero() 				{	return numero;				}
	public double getSaldo() 				{	return saldo;				}
	
	public void setNumero(String numero) 	{	this.numero = numero;		}
	public void setSaldo(double saldo) 		{	this.saldo = saldo;			}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}	
	
	public void creditar(double valor) {
		if (valor <= 0) {
			System.err.println("Valor deve ser maior que zero");
		} else {
			saldo += valor;
		}
	}

	public void debitar(double valor) {
		if (valor <= 0) {
			System.err.println("Valor deve ser maior que zero");
		} else {
			saldo -= valor;
		}
	}

	public void atualizar(double pct) {
		this.saldo *= (1 + (pct / 100)); 
	}

	public Conta(String numeroConta, double saldoInicial) {
		this.numero = numeroConta;
		this.saldo = saldoInicial;
	}

	public Conta(String numeroConta) {
		this(numeroConta, 0);
	}

}
