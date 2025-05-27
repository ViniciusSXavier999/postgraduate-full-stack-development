package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TarefaAsyncService {
	
	@Autowired
	NotificacaoSerivce notificacaoSerivce;
	
	private static final Logger log = LoggerFactory.getLogger(TarefaAsyncService.class);
	
	@Async
	public void gerarTarefaAsync() throws InterruptedException {
		log.info("Tarefa iniciada com sucesso!");
		
		Thread.sleep(10000);
		
		notificacaoSerivce.publicar("Tarefa finalizada com sucesso.");
	}

}
