package br.com.switchxiv.academicoweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Desempenho extends AbstractEntity{
	
	@ManyToOne
	private Aluno aluno;
	@OneToMany(mappedBy="desempenho", fetch=FetchType.EAGER)
	private List<Nota> notas;
	@ManyToOne
	private Turma turma;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
