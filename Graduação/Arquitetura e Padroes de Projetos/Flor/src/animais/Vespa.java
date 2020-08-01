package animais;

import util.Status;

public class Vespa extends Animal {

	@Override
	public void acao(String flor, Status status) {
		String msg = "";
		switch (status) {
		case ABERTA:
			msg = "ZZZzzzzzz Eu pousei na " + flor + ", pois ela abriu >) ";
			break;
		case FECHAR:
			msg = "Eita p****! " + flor + " esta pra fechar! Bater retirada! ZZZzzzzzz >) ";
			break;
		case FECHADA:
			msg = "Tah fechada, deixa pra lah...";
			break;
		}
		System.out.println(this.getClass().getSimpleName() + ": " + msg);
	}

}
