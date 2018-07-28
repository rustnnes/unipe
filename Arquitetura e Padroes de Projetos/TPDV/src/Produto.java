
public class Produto {
	private static long newId = 0;
	private long codigo;
	private String descricao;
	private double preco;
	
	public Produto() {
		newId++;
		setCodigo(newId);
	}

	public long getCodigo() { return codigo; }
	private void setCodigo(long codigo) { this.codigo = codigo; }

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public double getPreco() { return preco; }
	public void setPreco(double preco) { this.preco = preco; }

	@Override
	public String toString() {
		return codigo + " - " + descricao + " - " + preco;
	}
	
	
}
