package br.com.switchxiv.academicoweb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.switchxiv.academicoweb.model.Disciplina;

@Repository
@Transactional
public class DisciplinaBusiness extends GenericBusiness<Disciplina> implements DisciplinaRepository{
	
	@Override
	public Disciplina save(Disciplina entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}

	@Override
	public List<Disciplina> getList(){
		try{
			return manager.createNamedQuery("Disciplina.getList", Disciplina.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Disciplina> getListCurso(){
		try{
			return manager.createNamedQuery("Disciplina.getListCurso", Disciplina.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
