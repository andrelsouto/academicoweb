package br.com.switchxiv.academicoweb.dao;

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
	
}
