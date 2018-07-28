package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.FuncionarioDAO;
import db.hotel.entity.Funcionario;
import db.hotel.model.AbstractService;


public class FuncionarioService extends AbstractService<Funcionario, FuncionarioDAO> {

	@Override
	protected FuncionarioDAO newDAO(EntityManager manager) {
		return new FuncionarioDAO(manager);
	}
}
