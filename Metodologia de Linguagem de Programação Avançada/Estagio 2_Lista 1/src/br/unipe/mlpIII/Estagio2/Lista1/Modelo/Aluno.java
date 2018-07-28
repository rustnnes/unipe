package br.unipe.mlpIII.Estagio2.Lista1.Modelo;

import java.text.DecimalFormat;
import java.util.Comparator;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private long matricula;
	private double media;
	private int faltas;

	public Aluno(String nome, long matricula, double media, int faltas) {
		this.nome = nome;
		this.matricula = matricula;
		this.media = media;
		this.faltas = faltas;
	}

	public String getNome() {
		return nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public double getMedia() {
		return media;
	}

	public int getFalta(){
		return faltas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public void setFaltas(int faltas){
		this.faltas = faltas;
	}
	
	@Override
	public String toString() {
		return "Aluno(a): " + nome + " (mat: " + matricula + "\t\tfaltas: " +
				new DecimalFormat("000").format( faltas ) + ")";
	}

	@Override
	public int compareTo(Aluno aluno) {
		return nome.compareToIgnoreCase(aluno.nome);
	}

	public static final Comparator<Aluno> NOME = new Comparator<Aluno>() {
		public int compare(Aluno a1, Aluno a2) {
			return a2.nome.compareToIgnoreCase(a1.nome);
		}
	};
	
	public static final Comparator<Aluno> MEDIA = new Comparator<Aluno>() {
		public int compare(Aluno a1, Aluno a2) {
			return a2.compareTo(a1);			
		}
	};	
	
}
