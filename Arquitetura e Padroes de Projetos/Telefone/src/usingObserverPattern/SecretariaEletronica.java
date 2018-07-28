package usingObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class SecretariaEletronica implements Observer {

	private String numeroSerie;
	private String modelo;

	public SecretariaEletronica(String numeroSerie, String modelo) {
		super();
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
	}

	public String getNumeroSerie() { return numeroSerie; }

	public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

	public String getModelo() { return modelo; }

	public void setModelo(String modelo) { this.modelo = modelo; }
	
	@Override
	public void update(Observable o, Object arg) {
		Telefone phone = (Telefone) o;
		String msg = "Secretaria [" + this.getNumeroSerie() + "]: Fiquei sabendo que o telefone " + phone.getNumero();
		switch (phone.getStatus()) {
		case TOCAR:
			System.out.println(msg   + " tocou!");
			break;
		case ATENDER:
			System.out.println(msg + " foi atendido!");
			break;
		case DESLIGAR:
			System.out.println(msg + " foi desligado!");
			break;
		}
	}


}
