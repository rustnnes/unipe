package Walmart;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String pDescricao,chk;
		double pValor;
		int pEstoque;
		
		Scanner scan = new Scanner(System.in);

		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		while(true){
			System.out.println("Informe descrição produto: [PRODUTO X]");
			pDescricao = scan.nextLine();
			
			System.out.println("Informe valor produto:  ");
			pValor = scan.nextDouble();

			System.out.println("Informe quantidade em estoque do produto:  ");
			pEstoque = scan.nextInt();

			produtos.add( new Produto(pDescricao, pValor, pEstoque) );
			
			System.out.println("Informar novo produto? ([S]im [N]ão): ");
			chk = scan.next();
			if (chk.equals("n") || chk.equals("N")) break; // sai do while
		}
		
		for(Produto produto : produtos)
			System.out.println(produto.toString());
		scan.close();
	}

}
