package br.unipe.mlpIII.Estagio2.Lista1.Fachada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.unipe.mlpIII.Estagio2.Lista1.Modelo.CursoCapacitacao;
import br.unipe.mlpIII.Estagio2.Lista1.Utils.Utils;

public class Cursos {

	private static Cursos Instancia;
	protected List<CursoCapacitacao> cursos;

	private Cursos() {
		cursos = new ArrayList<CursoCapacitacao>();
	}

	public static synchronized Cursos getInstance() {
		if (Instancia == null)
			Instancia = new Cursos();
		return Instancia;
	}

	@Override
	public String toString() {
		return "";
	}

	private void listaCursos() {

	}

	private void admCurso(Scanner scan) {
		// TODO Auto-generated method stub

	}

	private void addCurso(Scanner scan) {

	}

	private void searchCurso(Scanner scan) {

	}

	private void editCurso(Scanner scan) {

	}

	private void delCurso(Scanner scan) {

	}

	public static void menu(Scanner scan) {
		Cursos cursos = Cursos.getInstance();
		boolean ok = true;
		while (ok) {
			System.out.println("\n\n\nCursos\n");
			System.out.println("[0]\tLista de cursos");
			System.out.println("[1]\tLista de cursos");
			System.out.println("[2]\tAdicionar curso");
			System.out.println("[3]\tBuscar curso");
			System.out.println("[4]\tEditar curso");
			System.out.println("[5]\tExcluir curso");
			System.out.println("[9]\tSair");

			switch (Utils.option("012349")) {
			case '0':
				cursos.listaCursos();
				break;
			case '1':
				cursos.admCurso(scan);
				break;
			case '2':
				cursos.addCurso(scan);
				break;
			case '3':
				cursos.searchCurso(scan);
				break;
			case '4':
				cursos.editCurso(scan);
				break;
			case '5':
				cursos.delCurso(scan);
				break;
			case '9':
				ok = false;
				break;
			}
		}
	}
}
