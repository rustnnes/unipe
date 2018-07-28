package db.hotel.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import db.hotel.model.AbstractEntity;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "pessoa_id", sequenceName = "pessoa_seq", allocationSize = 1, initialValue = 1)
public class Pessoa extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id")
	protected Long id;
	protected String nome;
	protected String cpf;
	@Embedded
	protected Endereco endereco;
	@Transient
	protected int prioridade;
	protected String email;
	protected Long telefone;
	@Temporal(TemporalType.DATE)
	protected Date dataNascimento;
	@OneToOne(mappedBy = "pessoa")
	protected Usuario usuario;

	public Pessoa() { super(); }

	protected Pessoa(String nome, String cpf, Endereco endereco, int prioridade, String email, Long telefone,
			Date dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.prioridade = prioridade;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public Long getId() { return id; }
	public String getNome() { return nome; }
	public String getCpf() { return cpf; }
	public Endereco getEndereco() { return endereco; }
	public int getPrioridade() { return prioridade; }
	public String getEmail() { return email; }
	public Long getTelefone() { return telefone; }
	public Date getDataNascimento() { return dataNascimento; }
	public Usuario getUsuario() { return usuario; }
	
	public void setId(Long id) { this.id = id; }
	public void setNome(String nome) { this.nome = nome; }
	public void setCpf(String cpf) { this.cpf = cpf; }
	public void setEndereco(Endereco endereco) { this.endereco = endereco; }
	public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
	public void setEmail(String email) { this.email = email; }
	public void setTelefone(Long telefone) { this.telefone = telefone; }
	public void setDataNascimento(Date d) { this.dataNascimento = d; }
	public void setUsuario(Usuario usuario) { this.usuario = usuario;	}
	

}
