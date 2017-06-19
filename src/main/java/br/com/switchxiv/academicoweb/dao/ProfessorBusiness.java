package br.com.switchxiv.academicoweb.dao;

import java.util.Collection;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.switchxiv.academicoweb.model.Professor;

@Repository
@Transactional
public class ProfessorBusiness extends GenericBusiness<Professor> implements ProfessorRepository {

	@Override
	public Professor save(Professor entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}
	
	@Override
	public Collection<Professor> list() {
		Query query = manager.createQuery("from Professor", Professor.class);

		@SuppressWarnings("unchecked")
		Collection<Professor> list = query.getResultList();
		return list;
	}

}
