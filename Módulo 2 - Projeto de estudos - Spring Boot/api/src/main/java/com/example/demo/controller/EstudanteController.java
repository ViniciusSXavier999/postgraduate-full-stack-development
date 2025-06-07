package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudante;
import com.example.demo.repository.EstudanteRepository;
import com.example.demo.service.EstudanteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	


	// BUSCANDO ESTUDANTES POR ID
	@GetMapping(value = "/{id}", produces = "application/json")
	@Operation(summary = "Buscar estudantes por id", description = "Retorna um estudante de acordo com o seu ID fornecido")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudantePorId(id);
	
	}

	// BUSCANDO TODOS OS ESTUDANTES
	@GetMapping
	public Page<Estudante> buscarTodosEstudantes(@RequestParam(defaultValue = "0") Integer pagina, @RequestParam(defaultValue = "5")  Integer itensPorPagina) {
		
		return estudanteService.buscarTodosEstudantes(PageRequest.of(pagina, itensPorPagina));
	}

	// CADASTRAR ESTUDANTE
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
		return estudanteService.cadastrarEstudante(estudante);

	}

	// ATUALIZAR ESTUDANTE
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudante(id, estudante);

	}

	// DELETAR ESTUDANTE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirEstudante(@PathVariable Long id) {
		return estudanteService.excluirEstudante(id);
	}
	
	// ESTUDANTES QUE AINDA NÃO AVALIARAM NENHUM CURSO
	@GetMapping("/naoAvaliaram")
	public List<Estudante> buscarEstudantesQueNaoAvaliaram() {
		return estudanteService.buscarEstudanteQueNaoAvaliaram();
	}

}
