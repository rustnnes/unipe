package usingObserverPattern;


import java.util.Observable;
import java.util.Observer;

public class Telefone extends Observable{
	private String numero;
	private Status status;
	
	public Telefone() { super(); }
	public Telefone(String numero) {
		this();
		this.numero = numero;
	}

	public String getNumero() { return numero; }
	public void setNumero(String numero) { this.numero = numero; }
	public Status getStatus() { return status; }
	public void setStatus(Status s) { status = s; }
	
	public void go(Status s){
		if ( !(this.status == s) ){
			this.status = s;
			setChanged();
		}
		notifyObservers();
	}

	@Override
	public synchronized void addObserver(Observer o) { super.addObserver(o); }
	@Override
	public synchronized void deleteObserver(Observer o) { super.deleteObserver(o); }
	@Override
	public synchronized void deleteObservers() { super.deleteObservers(); }
	@Override
	public void notifyObservers() { super.notifyObservers(); }
	@Override
	public void notifyObservers(Object arg) { super.notifyObservers(arg); }
	@Override
	protected synchronized void setChanged() { super.setChanged(); }
	@Override
	protected synchronized void clearChanged() { super.clearChanged(); }
	@Override
	public synchronized boolean hasChanged() { return super.hasChanged(); }
	@Override
	public synchronized int countObservers() { return super.countObservers(); }

}
