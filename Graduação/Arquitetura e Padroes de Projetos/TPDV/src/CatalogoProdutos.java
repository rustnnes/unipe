import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoProdutos {
	
	private List<Produto> produtos = new ArrayList<>();
	
	public CatalogoProdutos() {}

	public Produto getProduto(String desc){
		Produto prod = null;
		for(Produto p : produtos)
			if(p.getDescricao().equals(desc))
				prod = p;
		return prod;
	}
	
	public Produto getProduto(long codigo){
		Produto prod = null;
		for(Produto p : produtos)
			if(p.getCodigo() == codigo)
				prod = p;
		return prod;
	}

	public void addItem (String desc, double preco){
		Produto p = getProduto(desc); 
		if(p == null){
			p = new Produto();
			p.setDescricao(desc);
			p.setPreco(preco);
			produtos.add(p);
		}
		else
			System.err.println("Produto existente");
	}
	
	public void listaProdutos(String nome){
		for(Produto p : produtos)
			if(p.getDescricao().contains(nome.subSequence(0, nome.length())))
				System.out.println(p.getCodigo() + " - " + p.getDescricao());
	}
	
	public void listaProdutos(double pMin, double pMax){
		for(Produto p : produtos)
			if(p.getPreco() >= pMin && p.getPreco() <= pMax)
				System.out.println(p.getCodigo() + " - " + p.getDescricao());
	}
	
	public boolean isEmpty(){ return produtos.isEmpty(); }

	public void cadastrarProdutos(){
		Scanner scan = new Scanner(System.in);
		while(true){
			String desc = "", pergunta = "";
			double preco = 0;
			System.out.println("Informe descricao");
			desc = scan.nextLine();
			System.out.println("Informe preco");
			preco = scan.nextDouble();
			// tratamento das variaveis
			addItem(desc, preco);
			System.out.println("Deseja cadastrar novo item? [SIM] ou [NAO]");
			pergunta = scan.nextLine();
			if (!pergunta.equals("SIM")) break;
		}
		scan.close();
	}
}
