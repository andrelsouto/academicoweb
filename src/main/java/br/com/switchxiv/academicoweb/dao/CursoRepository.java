package br.com.switchxiv.academicoweb.dao;

import java.util.List;


import br.com.switchxiv.academicoweb.model.Curso;

public interface CursoRepository extends GenericRepository<Curso>{

	List<Curso> getList();
	public Curso findWithProfessores(Long id);

}
