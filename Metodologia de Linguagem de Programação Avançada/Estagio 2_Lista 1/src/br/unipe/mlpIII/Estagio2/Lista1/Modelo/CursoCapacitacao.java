package br.unipe.mlpIII.Estagio2.Lista1.Modelo;

import java.util.List;

public class CursoCapacitacao {

	protected String nome;
	protected long id;
	protected Professor professor;
	protected List<Aluno> alunos;

	public CursoCapacitacao(String nome, long id, Professor professor) {
		this.nome = nome;
		this.id = id;
		this.professor = professor;
	}

	public void insertAluno(Aluno a){ alunos.add(a); }
	public void deleteAluno(Aluno a){ alunos.remove(a); }
	
	@Override
	public String toString() {
		return "Curso de Capacitacao (Professor: " + professor.getNome() + "\n" + 
				"\t\tAluno(s)" + alunos.size() + " )";
	}

}
