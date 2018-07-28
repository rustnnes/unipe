package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Funcionario;
import db.hotel.model.AbstractDAO;


public class FuncionarioDAO extends AbstractDAO<Funcionario> {

	public FuncionarioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Funcionario> entityClass() {
		return Funcionario.class;
	}
}