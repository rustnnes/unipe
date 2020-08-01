package main;

import central.Camera;
import central.Central;
import central.SMSSender;
import central.Sensor;
import central.Sirene;

public class Sistema {

	public static void main(String[] args) {

		Central central = new Central("Lysianne", "83996232330", "Av. Sapé");
		
		Sensor sQuintal = new Sensor("quintal");
		Sensor sJardim = new Sensor("jardim");
		Sensor sLateral = new Sensor("lateral");
		
		sQuintal.addObserver(central);
		sJardim.addObserver(central);
		sLateral.addObserver(central);

		Sirene sirene = new Sirene();
		
		Camera cQuarto = new Camera("quarto");
		Camera cSala = new Camera("sala");
		
		SMSSender sms = new SMSSender();
		
		central.addObserver(sirene);
		central.addObserver(cSala);
		central.addObserver(cQuarto);
		central.addObserver(sms);

		sQuintal.Ativar();
	}

}