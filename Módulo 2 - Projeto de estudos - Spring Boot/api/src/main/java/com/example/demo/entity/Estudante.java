package com.example.demo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	
	// RELACIONAMENTO ONETOONE
	@OneToOne(cascade = CascadeType.ALL) // Tudo que acontecer na classe estudante vai acontecer na entidade endereço também.
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true) // ONE -> se refere a estudante.  // MANY -> se refere a livros
	@JsonManagedReference 
	private Set<Livro> livros = new HashSet<>();
	
	@OneToMany(mappedBy = "estudante")
	@JsonIgnore
	private Set<AvaliacaoCurso> avaliacaoCursos;
	
	
    


	public Estudante(Long id, String nome, String email, LocalDate dataNascimento, Endereco endereco, Set<Livro> livros,
			Set<AvaliacaoCurso> avaliacaoCursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.livros = livros;
		this.avaliacaoCursos = avaliacaoCursos;
	}


	public Estudante(){
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}


	public Set<AvaliacaoCurso> getAvaliacaoCursos() {
		return avaliacaoCursos;
	}


	public void setAvaliacaoCursos(Set<AvaliacaoCurso> avaliacaoCursos) {
		this.avaliacaoCursos = avaliacaoCursos;
	}
	
	

}
