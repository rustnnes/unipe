package Bacen;
import java.util.Scanner;

public class Principal {

	public static void menu(){
		
	}
	
	public static void main(String[] args) {
		String cc;
		double saldo;
		Scanner scan = new Scanner(System.in);

		System.out.println("Informe Número Conta Corrente: [123-X]");
		cc = scan.nextLine();
		if (cc.equals("")) cc = "123-X";
		
		System.out.println("Informe Saldo inicial: [R$ 100,00]: ");
		saldo = scan.nextDouble();
		if(saldo == 0) saldo = 100;

		Conta contaCorrente = new Conta(cc, saldo);
		System.out.println("Conta " + contaCorrente.getNumero() + ", com saldo de " + contaCorrente.getSaldo() + " " +
						   "foi criada com sucesso.\n\n");
		
		scan.close();
	}

}
