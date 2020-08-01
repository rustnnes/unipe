package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.ReservaDAO;
import db.hotel.entity.Reserva;
import db.hotel.model.AbstractService;


public class ReservaService extends AbstractService<Reserva, ReservaDAO> {

	@Override
	protected ReservaDAO newDAO(EntityManager manager) {
		return new ReservaDAO(manager);
	}
}
