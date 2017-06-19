package br.com.switchxiv.academicoweb.dao;

import br.com.switchxiv.academicoweb.model.Aluno;
import br.com.switchxiv.academicoweb.model.Usuario;

public interface AlunoRepository extends GenericRepository<Aluno>{

	Usuario findByMatricula(String matricula);

}
