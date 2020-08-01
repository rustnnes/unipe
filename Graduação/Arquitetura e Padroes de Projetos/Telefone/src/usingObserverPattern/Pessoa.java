package usingObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {

	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public String getCpf() { return cpf; }

	public void setCpf(String cpf) { this.cpf = cpf; }
	
	@Override
	public void update(Observable o, Object arg) {
		Telefone phone = (Telefone) o;
		String msg = "Pessoa [" + this.getNome() + "]: Fiquei sabendo que o telefone " + phone.getNumero();
		switch (phone.getStatus()) {
		case TOCAR:
			System.out.println(msg   + " tocou!");
			break;
		case ATENDER:
			System.out.println(msg + " foi atendido!");
			break;
		case DESLIGAR:
			System.out.println(msg + " foi desligado!");
			break;
		}
	}

}
