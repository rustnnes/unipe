package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.QuartoDAO;
import db.hotel.entity.Quarto;
import db.hotel.model.AbstractService;


public class QuartoService extends AbstractService<Quarto, QuartoDAO> {

	@Override
	protected QuartoDAO newDAO(EntityManager manager) {
		return new QuartoDAO(manager);
	}
}
