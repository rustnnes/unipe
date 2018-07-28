package db.hotel.dao;

import javax.persistence.EntityManager;

import db.hotel.entity.Hospede;
import db.hotel.model.AbstractDAO;


public class HospedeDAO extends AbstractDAO<Hospede> {

	public HospedeDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Hospede> entityClass() {
		return Hospede.class;
	}
}
