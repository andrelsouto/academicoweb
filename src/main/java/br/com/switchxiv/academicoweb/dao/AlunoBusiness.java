package br.com.switchxiv.academicoweb.dao;

import java.util.Collection;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.switchxiv.academicoweb.model.Aluno;
import br.com.switchxiv.academicoweb.model.Usuario;

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

	@Override
	public void remove(Aluno entity) {
		manager.remove(manager.getReference(Aluno.class, entity.getId()));
	}
	
	@Override
	public Aluno find(Long id) {
		return manager.find(Aluno.class, id);
	}

	@Override
	public Collection<Aluno> list() {
		Query query = manager.createQuery("from Aluno ORDER BY id", Aluno.class);

		@SuppressWarnings("unchecked")
		Collection<Aluno> list = query.getResultList();
		return list;
	}

	@Override
	public Usuario findByMatricula(String matricula) {
		return manager.createQuery("from Usuario WHERE matricula = :matricula", Usuario.class)
				.setParameter("matricula", matricula).getSingleResult();
	}

}
