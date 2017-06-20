package br.com.switchxiv.academicoweb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.switchxiv.academicoweb.model.Desempenho;

@Repository
@Transactional
public class DesempenhoBusiness extends GenericBusiness<Desempenho> implements DesempenhoRepository{
	
	@Override
	public Desempenho save(Desempenho entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}

}
