package central;

import java.util.Observable;
import java.util.Observer;

public class Sirene implements Observer {
	
	public void tocar() {
		System.out.println("Sirene tocou!");
	}

	public void update(Observable o, Object arg) {
		tocar();
	}

}
