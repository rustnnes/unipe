package Automovel;

public class Passeio extends Veiculo {

	private boolean arCondicionado;
	private int qtdePortas;

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public int getQtdePortas() {
		return qtdePortas;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public void setQtdePortas(int qtdePortas) {
		this.qtdePortas = qtdePortas;
	}

	public Passeio(Pessoa proprietario, String placa, String marca, 
				   String modelo, String chassi, int ano,
				   double valorKmRodado, double kmInicial, double kmFinal, 
				   double valorLocacao, boolean arCondicionado, int qtdePortas) {
		super(proprietario, placa, marca, modelo, chassi, ano, valorKmRodado, kmInicial, kmFinal, valorLocacao);
		this.setArCondicionado(arCondicionado);
		this.setQtdePortas(qtdePortas);
	}

}
