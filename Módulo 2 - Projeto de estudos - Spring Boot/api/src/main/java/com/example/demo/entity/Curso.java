package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private Set<AvaliacaoCurso> avaliacaoCursos;
	
	
	
	public Curso(Long id, String nome, Set<AvaliacaoCurso> avaliacaoCursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacaoCursos = avaliacaoCursos;
	}


	public Curso() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<AvaliacaoCurso> getAvaliacaoCursos() {
		return avaliacaoCursos;
	}


	public void setAvaliacaoCursos(Set<AvaliacaoCurso> avaliacaoCursos) {
		this.avaliacaoCursos = avaliacaoCursos;
	}
	
	

}
