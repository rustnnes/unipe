package main;

import java.util.Scanner;

import animais.Abelha;
import animais.Animal;
import animais.Vespa;
import flores.Flor;
import flores.Magnolia;
import flores.Margarida;
import util.Status;


public class Main {

	public static void main(String[] args) {

		// Observers
		Animal bee = new Abelha();
		Animal wasp = new Vespa();
		
		// Observables
		Flor mag = new Magnolia();
		Flor daisy = new Margarida();
		
		mag.addObserver(bee);
		daisy.addObserver(wasp);
		
		Scanner scanner = new Scanner(System.in);
		String cmd = "";
		
		while (!cmd.equalsIgnoreCase("exit")) {
			System.out.print("-> ");
			cmd = scanner.nextLine();
			
			String[] cmdSplited = cmd.split(" ");
			
			if (cmdSplited.length == 2) {				
				Flor f = mag;
				if (cmdSplited[1].equals("d"))
					f = daisy;
				
				switch(cmdSplited[0].toLowerCase()){
				case "a":
					f.Status(Status.ABERTA);
					break;
				case "f":
					f.Status(Status.FECHAR);
					break;
				case "c": 
					f.Status(Status.FECHADA);
					break;
				default:
					System.out.println("usage: [a|f|c] [m|d]");
					break;
				}
			}
		}
		System.out.println("bye");
		scanner.close();
	}
}
