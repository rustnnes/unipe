package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Consumo;
import db.hotel.model.AbstractDAO;


public class ConsumoDAO extends AbstractDAO<Consumo> {

	public ConsumoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Consumo> entityClass() {
		return Consumo.class;
	}
}
