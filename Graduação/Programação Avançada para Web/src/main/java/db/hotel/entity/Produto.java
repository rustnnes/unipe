package db.hotel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import db.hotel.model.AbstractEntity;

@Entity
@SequenceGenerator(name = "produto_id", sequenceName = "produto_seq", allocationSize = 1)
public class Produto extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id")
	private Long id;
	private String nome;
	private float preco;

	@OneToMany(mappedBy = "produto")
	private List<Consumo> consumos;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, float preco, List<Consumo> consumos) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.consumos = consumos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

}
