package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.UsuarioDAO;
import db.hotel.entity.Usuario;
import db.hotel.model.AbstractService;

public class UsuarioService extends AbstractService<Usuario, UsuarioDAO> {

	@Override
	protected UsuarioDAO newDAO(EntityManager manager) {
		return new UsuarioDAO(manager);
	}

	public Usuario efetuarLogin(String login, String senha) {
		manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		return usuarioDAO.efetuarLogin(login, senha);
	}
}
