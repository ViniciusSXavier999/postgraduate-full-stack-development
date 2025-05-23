package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TarefaAsyncService;

@RestController
@RequestMapping("/asyncs")
public class AsyncController {
	
	@Autowired
	private TarefaAsyncService asyncService;
	
	@GetMapping
	public ResponseEntity<String> executarTarefaAsync() throws InterruptedException {
		// CHAMAR TAREFA ASYNC
		
		asyncService.gerarTarefaAsync();
		return ResponseEntity.ok("Atividade iniciada com Sucesso");
	}

}
