package Bacen;

public class ContaPoupanca extends Conta{

	@Override
	public void atualizar(double pct) {
		super.atualizar(pct * 3);
	}

	public ContaPoupanca(String numeroConta) {
		super(numeroConta);
	}

}
