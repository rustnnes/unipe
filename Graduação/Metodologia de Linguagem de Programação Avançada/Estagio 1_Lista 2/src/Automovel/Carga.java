package Automovel;

public class Carga extends Veiculo {

	private double capacidadeCarga;
	
	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public Carga(Pessoa proprietario, String placa, String marca, 
				 String modelo, String chassi, int ano,
				 double valorKmRodado, double kmInicial, double kmFinal, 
				 double valorLocacao, double capacidadeCarga) {
		
		super(proprietario, placa, marca, modelo, chassi, ano, valorKmRodado, kmInicial, kmFinal, valorLocacao);
		this.setCapacidadeCarga(capacidadeCarga);
	}

}
