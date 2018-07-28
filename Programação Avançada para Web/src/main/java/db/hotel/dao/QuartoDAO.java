package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Quarto;
import db.hotel.model.AbstractDAO;


public class QuartoDAO extends AbstractDAO<Quarto> {

	public QuartoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Quarto> entityClass() {
		return Quarto.class;
	}
}
