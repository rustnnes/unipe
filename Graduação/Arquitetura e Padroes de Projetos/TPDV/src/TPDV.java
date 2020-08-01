import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TPDV {
	private static List<Venda> vendas = new ArrayList<>();
	private static CatalogoProdutos catalogo = new CatalogoProdutos();
	
	public TPDV() {}
	
	public static void main(){
		if(catalogo.isEmpty())
			catalogo.cadastrarProdutos();
		
	}
	
	public void criarVenda(){ 
		// instanciar venda new Venda()
		// pegar data
		// listar produtos do catalogo
		// selecione produto - p = getProduto(codigo)
		// conferir se produto selecionado existe na lista
		// se existe
			// pergunta quantidade
			// se qtde <= 0 
				// informa erro
			// senao
				// venda.addItem (qtde , p)
				// imprime item p 
				// selecionar outro produto?
				// se sim
				// se nao break;
		// imprime total venda - venda.total
	}

}
