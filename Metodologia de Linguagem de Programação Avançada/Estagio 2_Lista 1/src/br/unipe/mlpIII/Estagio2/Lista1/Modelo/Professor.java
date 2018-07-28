package br.unipe.mlpIII.Estagio2.Lista1.Modelo;

import java.util.Comparator;

public class Professor implements Comparable<Professor> {

	private String nome;
	private long matricula;
	private String especialidade;

	public String getNome() {
		return nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Professor(a): " + nome + " (" + matricula + ")";
	}

	@Override
	public int compareTo(Professor professor) {
		return nome.compareToIgnoreCase(professor.nome);
	}

	public static final Comparator<Professor> NOME = new Comparator<Professor>() {
		public int compare(Professor p1, Professor p2) {
			return p2.nome.compareToIgnoreCase(p1.nome);
		}
	};
	
	
}
