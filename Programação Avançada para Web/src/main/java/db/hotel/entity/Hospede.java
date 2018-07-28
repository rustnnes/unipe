package db.hotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Hospede extends Pessoa {

	@ManyToMany
	private List<Reserva> reservas;
	
	public Hospede() { super(); }
	
	public Hospede(String nome, String cpf, Endereco endereco, int prioridade, String email, Long telefone,
			Date dataNascimento) {
		super(nome, cpf, endereco, prioridade, email, telefone, dataNascimento);
	}

	public List<Reserva> getReservas() { return reservas; }

	public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }



}
