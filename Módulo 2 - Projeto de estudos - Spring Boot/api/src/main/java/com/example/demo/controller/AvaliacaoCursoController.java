package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AvaliacaoCursoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoCursoController {

	
	@Autowired
	private AvaliacaoCursoService avaliacaoCursoService;
	
	// ESSES PARAMETROS VÃO VIR NA URL DA REQUISIÇÃO
	@PostMapping
	public ResponseEntity<String> avaliar(@RequestParam Long idEstudante, @RequestParam String nomeCurso, @RequestParam Integer notaAvaliacao) {
		return avaliacaoCursoService.avaliar(idEstudante, nomeCurso, notaAvaliacao);
	}
}
