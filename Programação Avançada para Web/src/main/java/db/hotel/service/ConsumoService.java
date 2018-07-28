package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.ConsumoDAO;
import db.hotel.entity.Consumo;
import db.hotel.model.AbstractService;


public class ConsumoService extends AbstractService<Consumo, ConsumoDAO> {

	@Override
	protected ConsumoDAO newDAO(EntityManager manager) {
		return new ConsumoDAO(manager);
	}
}
