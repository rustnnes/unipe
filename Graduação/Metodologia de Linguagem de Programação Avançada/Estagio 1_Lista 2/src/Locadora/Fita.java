package Locadora;

public abstract class Fita {

	protected String titulo;
	protected Categoria categoria;
	protected double precoLocacao;
	protected Autor autor;

	public String getTitulo() {
		return titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public double getPrecoLocacao() {
		return precoLocacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPrecoLocacao(double precoLocacao) {
		this.precoLocacao = precoLocacao;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Fita(String titulo, Categoria categoria, double precoLocacao, Autor autor) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.precoLocacao = precoLocacao;
		this.autor = autor;
	}

	public Fita(String titulo, Categoria categoria, double precoLocacao) {
 		this.titulo = titulo;
		this.categoria = categoria;
		this.precoLocacao = precoLocacao;
	}

}
