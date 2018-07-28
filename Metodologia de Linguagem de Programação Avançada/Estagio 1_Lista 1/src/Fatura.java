
import java.util.Scanner;

public class Fatura {

	private int numero;
	private String descricao;
	private int quantidadeComprada;
	private double precoPorItem;

	public int getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public double getPrecoPorItem() {
		return precoPorItem;
	}

	public double getValorFatura() {
		double result = getQuantidadeComprada() * getPrecoPorItem();
		return result < 0 ? 0.0 : result;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada; 
	}

	public void setPrecoPorItem(double precoPorItem) {
		this.precoPorItem = precoPorItem;
	}

	public Fatura(int numero, String descricao, int quantidadeComprada, double precoPorItem) {
		this.numero = numero;
		this.descricao = descricao;
		this.quantidadeComprada = quantidadeComprada; 
		this.precoPorItem = precoPorItem;
	}

	public static void teste(Scanner scan) {
		int numero;
		String descricao;
		int quantidadeComprada;
		double precoPorItem;
		System.out.println(" *\n * Fatura\n *");
		System.out.printf("\n > Informe o codigo: "); 
		numero = scan.nextInt();
		System.out.printf(" > Informe a descricao: ");
		descricao = scan.next();
		System.out.printf(" > Informe quantidade a comprar: ");
		quantidadeComprada = scan.nextInt();
		System.out.printf(" > Informe preco por item: ");
		precoPorItem = scan.nextDouble();

		Fatura fatura = new Fatura(numero, descricao, quantidadeComprada, precoPorItem);
		System.out.printf("\n > Valor Fatura: %.2f\n\n", fatura.getValorFatura());
	}

}
