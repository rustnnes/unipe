import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private String data;
	private List<ItemVenda> produtos = new ArrayList<>();
	
	public Venda() {}
	
	public void addItem(double qtde, Produto prod, double pVenda){
		ItemVenda iv = new ItemVenda(prod, qtde, pVenda);
		produtos.add(iv);
	}

	public void addItem(double qtde, Produto prod){
		ItemVenda iv = new ItemVenda(prod, qtde, prod.getPreco());
		produtos.add(iv);
	}

	public String getData() { return data; }
	public void setData(String data) { this.data = data; }

	public List<ItemVenda> getProdutos() { return produtos; }
	public void setProdutos(List<ItemVenda> produtos) {
		this.produtos = produtos;
	}

	public double total(){
		double tmp = 0;
		for(int i = 0; i < produtos.size(); i++)
			tmp += produtos.get(i).subtotal();
	
		return tmp;
	}
	
	
}
