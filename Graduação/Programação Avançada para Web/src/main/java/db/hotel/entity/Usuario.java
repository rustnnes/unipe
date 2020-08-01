package db.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import db.hotel.model.AbstractEntity;

@Entity
@SequenceGenerator(name = "usuario_id", sequenceName = "usuario_seq", allocationSize = 1)
public class Usuario extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id")
	private Long id;
	@Column(unique=true)
	private String login;
	private String senha;
	@OneToOne
	private Pessoa pessoa;

	public Usuario() { super(); }

	public Usuario(Long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Long getId() { return id; }
	public String getLogin() { return login; }
	public String getSenha() { return senha; }
	public Pessoa getPessoa() { return pessoa; }

	public void setId(Long id) { this.id = id; }
	public void setLogin(String login) { this.login = login; }
	public void setSenha(String senha) { this.senha = senha; }
	public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

}
