
public class ItemVenda {
	private double qtde;
	private Produto produto;
	private double precoVenda;
	
	public double getQtde() { return qtde; }
	public void setQtde(double qtde) { this.qtde = qtde; }

	public Produto getProduto() { return produto; }
	public void setProduto(Produto produto) { this.produto = produto; }

	public double getPrecoVenda() { return precoVenda; }
	public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }

	public double subtotal(){ return precoVenda * qtde; }
	
	public ItemVenda(Produto prod, double qtde, double pVenda) {
		this.precoVenda = pVenda;
		this.produto = prod;
		this.qtde = qtde;
	}
}
