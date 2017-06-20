package br.com.switchxiv.academicoweb.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Disciplina.getList",query="SELECT d FROM Disciplina d ORDER BY d.id DESC"),
	@NamedQuery(name="Disciplina.getListCurso",query="SELECT d FROM Disciplina d INNER JOIN d.curso c ORDER BY d.id DESC"),
})
public class Disciplina extends AbstractEntity {

	private String nome;
	private String area;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy="disciplinas")
	private Turma turma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


}
