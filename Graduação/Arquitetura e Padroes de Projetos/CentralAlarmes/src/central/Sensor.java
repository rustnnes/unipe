package central;

import java.util.Observable;
import java.util.Observer;

public class Sensor extends Observable {

	private boolean ativo;
	private String comodo;
	
	public Sensor(String c) {
		this.ativo = false;
		this.comodo = c;
	}

	public String Comodo() { return comodo; }
	
	public boolean Ativo() { return ativo; }
	public void Ativar() {
		if(!this.ativo){
			this.ativo = true;
			setChanged();
		}
		notifyObservers();
		try {
			Thread.sleep(1000);
			this.ativo = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public synchronized void addObserver(Observer o) { super.addObserver(o); }
	@Override
	public synchronized void deleteObserver(Observer o) { super.deleteObserver(o); }
	@Override
	public void notifyObservers() { super.notifyObservers(); }
	@Override
	protected synchronized void setChanged() { super.setChanged(); }

}
