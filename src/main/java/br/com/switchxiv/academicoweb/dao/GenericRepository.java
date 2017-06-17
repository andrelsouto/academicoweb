package br.com.switchxiv.academicoweb.dao;

import java.util.Collection;

import br.com.switchxiv.academicoweb.model.AbstractEntity;

public interface GenericRepository<T extends AbstractEntity> {
	
	public abstract Collection<T> list();
	
	public abstract T find(Long id);
	
	public abstract void remove(T entity);
	
	public abstract void delete(Long id);
	
	public abstract T save(T entity);
	
	
}
