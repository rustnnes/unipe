package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Reserva;
import db.hotel.model.AbstractDAO;


public class ReservaDAO extends AbstractDAO<Reserva> {

	public ReservaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Reserva> entityClass() {
		return Reserva.class;
	}
}
