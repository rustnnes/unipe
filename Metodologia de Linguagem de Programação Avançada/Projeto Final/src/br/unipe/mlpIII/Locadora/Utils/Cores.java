package br.unipe.mlpIII.Locadora.Utils;

public enum Cores {
	BRANCO(0), 
	PRETO(1),
	AZUL(2),
	AMARELO(3),
	VERMELHO(4),
	VERDE(5),
	ROXO(6),
	CINZA(7),
	PRATA(8),
	GRAFITE(9);
	
	private final int v;
	
	public int toInt(){
		return v;
	}

	private Cores(int v) {
		this.v = v;
	}
}
