package db.hotel.service;

import javax.persistence.EntityManager;

import db.hotel.dao.CategoriaDAO;
import db.hotel.entity.Categoria;
import db.hotel.model.AbstractService;

public class CategoriaService extends AbstractService<Categoria, CategoriaDAO> {

	@Override
	protected CategoriaDAO newDAO(EntityManager manager) {
		return new CategoriaDAO(manager);
	}
}
