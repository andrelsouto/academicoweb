package br.com.switchxiv.academicoweb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.switchxiv.academicoweb.model.Curso;

@Repository
@Transactional
public class CursoBusiness extends GenericBusiness<Curso> implements CursoRepository {

	@Override
	public Curso save(Curso entity) {
		if (entity.getId() == null) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}

	public Curso findWithProfessores(Long id) {

		try {
			return manager.createQuery("FROM Curso c JOIN FETCH c.professores WHERE c.id = :id", Curso.class)
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			Curso c = find(id);
			c.setProfessores(null);
			return c;
		}
	}

	@Override
	public List<Curso> getList() {
		try {
			return manager.createNamedQuery("Curso.getList", Curso.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Curso find(Long id) {
		try {
			return manager.find(Curso.class, id);
		} catch (Exception e) {
			return null;
		}
	}
}
