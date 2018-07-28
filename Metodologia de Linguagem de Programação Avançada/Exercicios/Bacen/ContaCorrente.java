package Bacen;

public class ContaCorrente extends Conta {

	@Override
	public void atualizar(double pct) {
		super.atualizar(pct * 2);
	}

	@Override
	public void creditar(double valor) {
		super.creditar(valor - 0.1);
	}

	public ContaCorrente(String numeroConta) {
		super(numeroConta);
	}

}
	