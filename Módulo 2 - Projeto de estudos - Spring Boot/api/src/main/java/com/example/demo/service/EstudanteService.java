package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudante;
import com.example.demo.entity.Livro;
import com.example.demo.repository.EstudanteRepository;
import com.example.demo.repository.LivroRepository;

@Service
public class EstudanteService {

	/* private static Map<Long, Estudante> listaEstudantes = new HashMap<>(); */

	@Autowired
	private EstudanteRepository repository;
	
	@Autowired
	private LivroRepository livroRepository;

	// BUSCANDO ESTUDANTES POR ID
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		if (repository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// BUSCANDO TODOS OS ESTUDANTES
	public Page<Estudante> buscarTodosEstudantes(PageRequest page) {
		return repository.findAll(page);
	}

	/*
	// CADASTRAR ESTUDANTE
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		
		
		// Estamos pegando os livros e salvando na váriavel "livros"
		Set<Livro> livros = estudante.getLivros();
		
		// Vou settar os livros de estudante para null
		estudante.setLivros(new HashSet<>());
		
		// Em seguida, vou salvar estudante
		Estudante estudanteCadastrado = repository.save(estudante);
		
		// Vou realizar a iteração de estudantes
		for (Livro livro: livros) {
			livro.setEstudante(estudante.builder().id(estudante.getId().build()));
			estudante.getLivros().add(livroRepository.save(livro));
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteCadastrado);
	}
	*/
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
	    
	    // Pegamos os livros enviados junto com o estudante
	    Set<Livro> livros = estudante.getLivros();

	    // Esvaziamos temporariamente os livros do estudante
	    estudante.setLivros(new HashSet<>());

	    // Salvamos o estudante no banco de dados (agora ele terá um ID)
	    Estudante estudanteCadastrado = repository.save(estudante);

	    // Para cada livro recebido, associamos ao estudante e salvamos
	    for (Livro livro : livros) {
	        livro.setEstudante(estudanteCadastrado); // associando corretamente o estudante salvo
	        Livro livroSalvo = livroRepository.save(livro); // salvando o livro
	        estudanteCadastrado.getLivros().add(livroSalvo); // adicionando o livro salvo ao estudante
	    }

	    // Retornamos o estudante com status 201 CREATED
	    return ResponseEntity.status(HttpStatus.CREATED).body(estudanteCadastrado);
	}

	// ATUALIZAR ESTUDANTE
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {
		
		if (repository.existsById(id)) {
			Estudante estudanteCadastrado = repository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteCadastrado);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
			
	}

	// DELETAR ESTUDANTE
	public ResponseEntity<String> excluirEstudante(Long id) {
		

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
			
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
	}
}
