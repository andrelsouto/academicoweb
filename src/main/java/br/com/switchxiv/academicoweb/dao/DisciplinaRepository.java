package br.com.switchxiv.academicoweb.dao;

import java.util.List;

import br.com.switchxiv.academicoweb.model.Disciplina;

public interface DisciplinaRepository extends GenericRepository<Disciplina>{

	List<Disciplina> getList();

	List<Disciplina> getListCurso();

}
