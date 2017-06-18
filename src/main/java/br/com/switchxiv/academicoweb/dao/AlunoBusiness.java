package br.com.switchxiv.academicoweb.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.switchxiv.academicoweb.model.Aluno;

@Repository
@Transactional
public class AlunoBusiness extends GenericBusiness<Aluno> implements AlunoRepository {

	@Override
	public Aluno save(Aluno entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}

}
