package Locadora;

public class Lancamento extends Fita{

	public Lancamento(String titulo, Categoria categoria, double precoLocacao, Autor autor) {
		super(titulo, categoria, precoLocacao * 1.2 , autor);
	}

	
}
