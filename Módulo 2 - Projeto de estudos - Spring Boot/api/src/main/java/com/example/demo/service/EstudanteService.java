package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudante;
import com.example.demo.repository.EstudanteRepository;

@Service
public class EstudanteService {

	/* private static Map<Long, Estudante> listaEstudantes = new HashMap<>(); */

	@Autowired
	private EstudanteRepository repository;

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

	// CADASTRAR ESTUDANTE
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		Estudante estudanteCadastrado = repository.save(estudante);
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
