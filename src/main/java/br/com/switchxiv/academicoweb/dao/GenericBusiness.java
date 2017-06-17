package br.com.switchxiv.academicoweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import br.com.switchxiv.academicoweb.model.AbstractEntity;

public class GenericBusiness<T extends AbstractEntity> implements GenericRepository<T> {

	@PersistenceContext
	protected EntityManager manager;
	protected SessionFactory sessionfactory;
	protected Class<T> clasz;

	@SuppressWarnings("unused")
	public GenericBusiness() {
		@SuppressWarnings("unchecked")
		Class<T> clasz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public Collection<T> list() {
		Query query = manager.createQuery("from " + clasz.getName());

		@SuppressWarnings("unchecked")
		Collection<T> list = query.getResultList();
		return list;
	}

	public T find(Long id) {
		return manager.find(clasz, id);
	}

	public void remove(T entity) {
		manager.remove(manager.getReference(clasz, entity.getId()));
	}

	public void delete(Long id) {
		manager.remove(id);
	}

	public T save(T entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}
}
