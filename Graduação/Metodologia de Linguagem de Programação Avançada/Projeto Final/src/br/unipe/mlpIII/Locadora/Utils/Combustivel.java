package br.unipe.mlpIII.Locadora.Utils;

public enum Combustivel {
	GASOLINA(0),
	ALCOOL(1),
	DIESEL(2),
	ELETRICO(3),
	TETRAFUEL(4);
	
	private final int v;
	
	public int toInt(){
		return v;
	}

	private Combustivel(int v) {
		this.v = v;
	}
	
	
}
