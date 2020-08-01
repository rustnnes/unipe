package db.hotel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import db.hotel.model.AbstractEntity;

@Entity
@SequenceGenerator(name = "quarto_id", sequenceName = "quarto_seq", allocationSize = 1)
public class Quarto extends  AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quarto_id")
	private Long id;
	private int numero;
	private int andar;

	@OneToMany(mappedBy = "quarto")
	private List<Reserva> reservas;

	@ManyToOne
	private Categoria categoria;

	public Quarto() {
		super();
	}

	public Quarto(Long id, int numero, int andar, List<Reserva> reservas, Categoria categoria) {
		super();
		this.id = id;
		this.numero = numero;
		this.andar = andar;
		this.reservas = reservas;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
