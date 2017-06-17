package br.com.switchxiv.academicoweb.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Turma extends AbstractEntity {
	
	private int semestre;
	private LocalDate ano;
	@OneToMany(mappedBy="turma", fetch=FetchType.EAGER)
	private List<Desempenho> desempenhos;
	@ManyToMany(mappedBy="turmas", fetch=FetchType.EAGER)
	private List<Disciplina> disciplinas;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Professor> professores;

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public LocalDate getAno() {
		return ano;
	}

	public void setAno(LocalDate ano) {
		this.ano = ano;
	}

	public List<Desempenho> getDesempenhos() {
		return desempenhos;
	}

	public void setDesempenhos(List<Desempenho> desempenhos) {
		this.desempenhos = desempenhos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
