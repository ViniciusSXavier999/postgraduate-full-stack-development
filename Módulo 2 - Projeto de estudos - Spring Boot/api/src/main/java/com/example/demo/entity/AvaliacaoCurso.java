package com.example.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class AvaliacaoCurso {
	
	@EmbeddedId
	private AvaliacaoCursoKey id = new AvaliacaoCursoKey();
	
	@ManyToOne
	@MapsId("estudanteId") // faz referencia ao id do estudante
	@JoinColumn(name = "estudante_id")
	private Estudante estudante;
	
	@ManyToOne
	@MapsId("cursoId") // faz referencia ao id do curso
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	private int notaDaAvaliacao;
	
	public AvaliacaoCurso() {
	}
	
	
	
	public AvaliacaoCurso(Estudante estudante, Curso curso, int notaDaAvaliacao) {
		super();
		this.estudante = estudante;
		this.curso = curso;
		this.notaDaAvaliacao = notaDaAvaliacao;
	}



	public Estudante getEstudante() {
		return estudante;
	}



	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}



	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	public int getNotaDaAvaliacao() {
		return notaDaAvaliacao;
	}



	public void setNotaDaAvaliacao(int notaDaAvaliacao) {
		this.notaDaAvaliacao = notaDaAvaliacao;
	}


}
