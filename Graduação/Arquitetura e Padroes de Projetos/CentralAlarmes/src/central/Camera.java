package central;

import java.util.Observable;
import java.util.Observer;

public class Camera implements Observer {
	private String comodo;
	
	public Camera(String c) {
		super();
		this.comodo = c;
	}

	public void gravarImagem() {
		System.out.println("Camera em "+ comodo +" gravou imagem!");
	}

	public void update(Observable o, Object arg) {
		gravarImagem();
	}

}
