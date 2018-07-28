package db.hotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	private String matricula;
	private String ctps;
	@OneToMany(mappedBy = "funcionario")
	private List<Reserva> reservas;

	public Funcionario(String nome, String cpf, Endereco endereco, int prioridade, String email, Long telefone,
			Date dataNascimento, String matricula, String ctps) {
		super(nome, cpf, endereco, prioridade, email, telefone, dataNascimento);
		this.matricula = matricula;
		this.ctps = ctps;
	}

	public Funcionario() {
		super();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
