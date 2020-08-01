package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.ProdutoDAO;
import db.hotel.entity.Produto;
import db.hotel.model.AbstractService;


public class ProdutoService extends AbstractService<Produto, ProdutoDAO> {

	@Override
	protected ProdutoDAO newDAO(EntityManager manager) {
		return new ProdutoDAO(manager);
	}
}
