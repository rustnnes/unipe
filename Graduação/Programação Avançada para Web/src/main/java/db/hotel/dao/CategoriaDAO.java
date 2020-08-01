package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Categoria;
import db.hotel.model.AbstractDAO;

public class CategoriaDAO extends AbstractDAO<Categoria> {

	public CategoriaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Categoria> entityClass() {
		return Categoria.class;
	}
}
