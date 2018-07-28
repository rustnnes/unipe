package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.HospedeDAO;
import db.hotel.entity.Hospede;
import db.hotel.model.AbstractService;


public class HospedeService extends AbstractService<Hospede, HospedeDAO> {

	@Override
	protected HospedeDAO newDAO(EntityManager manager) {
		return new HospedeDAO(manager);
	}
}
