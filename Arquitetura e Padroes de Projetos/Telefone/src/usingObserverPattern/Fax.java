package usingObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class Fax implements Observer{
	
	private String fabricante;
	private int codigo;
	
	public Fax(String fabricante, int codigo) {
		super();
		this.fabricante = fabricante;
		this.codigo = codigo;
	}
	
	public String getFabricante() { return fabricante; }
	public void setFabricante(String fabricante) { this.fabricante = fabricante; }
	public int getCodigo() { return codigo; }
	public void setCodigo(int codigo) { this.codigo = codigo; }
	
	@Override
	public void update(Observable o, Object arg) {
		Telefone phone = (Telefone) o;
		String msg = "Pessoa [" + this.getCodigo() + "]: Fiquei sabendo que o telefone " + phone.getNumero();
		switch (phone.getStatus()) {
		case TOCAR:
			System.out.println(msg + " tocou!");
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
