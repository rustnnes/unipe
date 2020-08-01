package animais;

import java.util.Observable;
import java.util.Observer;

import flores.Flor;
import util.Status;

public abstract class Animal implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		Flor flor = (Flor) o;
		acao(flor.Nome(), flor.Status());
	}
	
	public abstract void acao(String flor, Status status);

}
