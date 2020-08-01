package br.unipe.mlpIII.Estagio2.Lista1.UI;

import java.util.Scanner;
import br.unipe.mlpIII.Estagio2.Lista1.Fachada.Inventario;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Inventario.menu(scan);
		scan.close();
	}

}
