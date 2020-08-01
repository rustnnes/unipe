package flores;

import java.util.Observable;
import java.util.Observer;

import util.Status;

public abstract class Flor extends Observable {

	protected Status status = Status.FECHADA;
	
	public Flor() { }
	
	public String Nome() { return this.getClass().getSimpleName(); }

	public Status Status() { return status; }

	public void Status(Status status) { 
		if(this.status != status){
			this.status = status;
			setChanged();
		}
		notifyObservers();
	}

	@Override
	public synchronized void addObserver(Observer o) {super.addObserver(o);}

	@Override
	public synchronized void deleteObserver(Observer o) {super.deleteObserver(o);}

	@Override
	public synchronized void deleteObservers() {super.deleteObservers();}
	
	@Override
	public void notifyObservers() {super.notifyObservers();}

	@Override
	protected synchronized void setChanged() {super.setChanged();}

}
