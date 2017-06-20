package br.com.switchxiv.academicoweb.dao;

import java.util.Collection;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.switchxiv.academicoweb.model.Turma;

@Repository
@Transactional
public class TurmaBusiness extends GenericBusiness<Turma> implements TurmaRepository {
	
	@Override
	public Turma save(Turma entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}
	
	@Override
	public Collection<Turma> list() {
		Query query = manager.createQuery("from Turma");

		@SuppressWarnings("unchecked")
		Collection<Turma> list = query.getResultList();
		return list;
	}
	
	@Override
	public Turma find(Long id) {
		return manager.find(Turma.class, id);
	}
	
	
}
