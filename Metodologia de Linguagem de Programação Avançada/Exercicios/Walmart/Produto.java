package Walmart;

public class Produto {

	private static int numero = 0;
	
	private String descricao;
	private double valor;
	private int estoque;

	// gerador de sequencia para nome de produtos instanciados como ""
    public static String gerarSeq()	{ return new String (Integer.toString(numero++)); }
	
	public String getDescricao() 	{ return descricao; }
	public double getValor() 		{ return valor; 	}
	public int getEstoque() 		{ return estoque; 	}

	public void setDescricao(String descricao) {
		if(descricao.equals("")){
			this.descricao = "PRODUTO " + gerarSeq();
		} else {
			this.descricao = descricao;
		}
	}

	public void setValor(double valor) {
		if(valor <= 0){
			System.err.println("Defina um valor maior que zero para o produto.");
		} else {
			this.valor = valor;
		}
	}

	public void setEstoque(int estoque) {
		if(estoque <= 0){
			System.err.println("Defina quantidades positivas para estoque do produto.");
		} else {
			this.estoque = estoque;
		}
	}

	@Override
	public String toString() {
		return "Produto [" + (descricao != null ? "descricao=" + descricao + ", " : "") + "valor=" + valor
				+ ", estoque=" + estoque + "]";
	}

	public Produto(String descricao, double valor, int estoque) {
		super();
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setEstoque(estoque);
	}


}


