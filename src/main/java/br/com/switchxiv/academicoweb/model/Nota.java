package br.com.switchxiv.academicoweb.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Nota extends AbstractEntity {
	
	private int unidade;
	private double nota;
	private int peso;
	@ManyToOne
	private Desempenho desempenho;

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Desempenho getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}
}
