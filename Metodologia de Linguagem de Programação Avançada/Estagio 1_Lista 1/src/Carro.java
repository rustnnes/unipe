import java.util.Scanner;

public class Carro {

	protected String cor;
	protected String modelo;
	protected double velocidadeAtual;
	protected double velocidadeMaxima;
	protected boolean ligado;

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	private void setVelocidadeAtual(double velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}

	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public boolean ligar() {
		this.ligado = true;
		return this.ligado;
	}

	public void acelerar(double qty) {
		if ((this.getVelocidadeAtual() + qty) > this.getVelocidadeMaxima()) {
			this.setVelocidadeAtual(this.getVelocidadeMaxima());
			System.err.println("\t*\n\t* Velocidade máxima atingida!\n\t*");
		} else {
			this.setVelocidadeAtual(this.getVelocidadeAtual() + qty);
		}
	}

	@Override
	public String toString() {
		return " > Carro: \t" + "Cor: " + (cor != null ? cor : "###") + "\n\t\t" + "Modelo: "
				+ (modelo != null ? modelo : "###") + "\n\t\t" + "Velocidade Atual=" + velocidadeAtual + "\n\t\t"
				+ "Velocidade Maxima=" + velocidadeMaxima + "\n\t\t" + "Ligado=" + ligado; 
	}

	public Carro(String cor, String modelo, double velocidadeAtual, double velocidadeMaxima, boolean ligado) {
		this.cor = cor;
		this.modelo = modelo;
		this.velocidadeAtual = velocidadeAtual;
		this.velocidadeMaxima = velocidadeMaxima;
		this.ligado = ligado;
	} 

	public static void teste(Scanner scan) {
		String cor;
		String modelo;
		double velocidadeAtual = 0;
		double velocidadeMaxima = 0;

		System.out.println(" *\n * Carro\n *");

		System.out.printf(" > Informe cor [vermelho]: ");
		cor = scan.nextLine();
		if (cor.equals(""))
			cor = "vermelho";

		System.out.printf("\n > Informe modelo [Ferrari]: ");
		modelo = scan.nextLine();
		if (modelo.equals(""))
			modelo = "Ferrari";

		System.out.printf(" > Informe velocidade maxima (km/h) [400]: ");
		velocidadeMaxima = scan.nextDouble();
		if (velocidadeMaxima == 0)
			velocidadeMaxima = 400;

		Carro carro = new Carro(cor, modelo, velocidadeAtual, velocidadeMaxima, false);
		System.out.println(carro.toString());
	}

}
