package Locadora;

import java.util.Scanner;

public class Infantil extends Fita{
	public Infantil(String titulo, Categoria categoria, double precoLocacao) {
		super(titulo, categoria, precoLocacao * 0.6);
		Scanner scan = new Scanner(System.in);
		Autor autor = new Autor();
		System.out.printf("\nInforme o nome do autor: ");
		autor.setNome(scan.nextLine());
		this.setAutor(autor);
	}
}
