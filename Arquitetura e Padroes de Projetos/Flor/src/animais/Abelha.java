package animais;

import util.Status;

public class Abelha extends Animal {

	@Override
	public void acao(String flor, Status status) {
		String msg = "";
		switch (status) {
		case ABERTA:
			msg = "ZZZzzzzzz Eu pousei na " + flor + ", pois ela abriu ;) ";
			break;
		case FECHAR:
			msg = "Percebi que a " + flor + " esta pra fechar! Fui! ZZZzzzzzz :'( ";
			break;
		case FECHADA:
			msg = "Que peninha! Tah fechada... Fica pra proxima =)";
			break;
		}
		System.out.println(this.getClass().getSimpleName() + ": " + msg);
	}
}
