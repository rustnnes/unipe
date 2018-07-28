package central;

import java.util.Observable;
import java.util.Observer;

public class Central extends Observable implements Observer{

	private String proprietario;
	private String telefone;
	private String endereco;
	
	public String getProprietario() { return proprietario; }
	public void setProprietario(String proprietario) { this.proprietario = proprietario; }
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }
	
	public Central(String proprietario, String telefone, String endereco) {
		super();
		this.proprietario = proprietario;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	@Override
	public synchronized void addObserver(Observer o) { super.addObserver(o); }
	@Override
	public void notifyObservers() { super.notifyObservers(); }
	@Override
	protected synchronized void setChanged() { super.setChanged(); }

	public void update(Observable o, Object arg) {
		Sensor s = (Sensor) o;
		System.out.println("Sensor de presença instalado em: " + s.Comodo());
		System.out.println("indicou movimentação. Iniciando alarmes…");
		setChanged();
		notifyObservers();
	}
	
	
}
