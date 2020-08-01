package usingObserverPattern;

import java.util.Scanner;


public class Sistema {

	public static void main(String[] args) {
		System.out.println("Observer-implemented version.");
		System.out.println("usage: [t|a|d] [1|2]; \"exit\" to quit.\n\n");

		// Observers
		Pessoa pJoao = new Pessoa("João", "12345678");
		Pessoa pMaria = new Pessoa("Maria", "98765432");
		SecretariaEletronica sABC = new SecretariaEletronica("ABC", "X25");
		Fax fax123 = new Fax("Motorola", 123456);
		
		// Observables
		Telefone telefone1 = new Telefone("9999-9999");
		Telefone telefone2 = new Telefone("8888-8888");
		
		telefone1.addObserver(pJoao);
		telefone1.addObserver(pMaria);
		telefone1.addObserver(sABC);
		
		telefone2.addObserver(pJoao);
		telefone2.addObserver(fax123);
		
		Scanner scanner = new Scanner(System.in);
		String cmd = "";
		
		while (!cmd.equalsIgnoreCase("exit")) {
			System.out.print("-> ");
			cmd = scanner.nextLine();
			
			String[] cmdSplited = cmd.split(" ");
			
			if (cmdSplited.length == 2) {				
				Telefone t = telefone1;
				if (cmdSplited[1].equals("2"))
					t = telefone2;
				
				switch(cmdSplited[0].toLowerCase()){
				case "t":
					t.go(Status.TOCAR);
					break;
				case "a":
					t.go(Status.ATENDER);
					break;
				case "d": 
					t.go(Status.DESLIGAR);
					break;
				default:
					System.out.println("usage: [t|a|d] [1|2]");
					break;
				}
			}
		}
		System.out.println("bye");
	}
}
