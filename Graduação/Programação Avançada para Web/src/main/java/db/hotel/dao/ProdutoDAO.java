package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Produto;
import db.hotel.model.AbstractDAO;

public class ProdutoDAO extends AbstractDAO<Produto> {

	public ProdutoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Produto> entityClass() {
		return Produto.class;
	}
}
