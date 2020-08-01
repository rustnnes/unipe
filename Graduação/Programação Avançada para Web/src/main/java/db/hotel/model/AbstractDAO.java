package db.hotel.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO<T extends AbstractEntity> {

	@PersistenceContext
	protected EntityManager manager;
	
	protected abstract Class<T> entityClass();
	
	public AbstractDAO(EntityManager manager)  {
		this.manager = manager;
	}

	public void salvar(T entity) {
		manager.persist(entity);
	}

	public void atualizar(T entity) {
		manager.merge(entity);
	}

	public void excluir(T entity) {
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);
	}

	public T buscarPorId(Long id) {
		return manager.find(entityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		return manager.createQuery("select a from " + entityClass().getSimpleName() + " a").getResultList();
	}

}
