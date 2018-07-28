package db.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.hotel.entity.Usuario;
import db.hotel.model.AbstractDAO;

public class UsuarioDAO extends AbstractDAO<Usuario> {

	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Usuario> entityClass() {
		return Usuario.class;
	}

	public Usuario efetuarLogin(String login, String senha) {
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();

		if (usuarios == null || usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}
}
