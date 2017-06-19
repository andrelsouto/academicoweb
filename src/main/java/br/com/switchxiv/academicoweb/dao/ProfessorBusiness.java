package br.com.switchxiv.academicoweb.dao;

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

}
