package db.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import db.hotel.model.AbstractEntity;

@Entity
@SequenceGenerator(name = "consumo_id", sequenceName = "consumo_seq", allocationSize = 1)
public class Consumo extends  AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumo_id")
	private Long id;
	private Long quantidade;

	@ManyToOne
	private Reserva reserva;

	@ManyToOne
	private Produto produto;

	public Consumo() {
		super();
	}

	public Consumo(Long id, Long quantidade, Reserva reserva, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.reserva = reserva;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
