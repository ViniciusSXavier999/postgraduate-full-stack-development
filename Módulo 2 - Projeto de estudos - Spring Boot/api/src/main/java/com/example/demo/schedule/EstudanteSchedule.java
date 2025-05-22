package com.example.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EstudanteSchedule {
	
	private static final Logger log = LoggerFactory.getLogger(EstudanteSchedule.class);
	
	/*
	@Scheduled(fixedDelay = 1000)
	public void executarTarefa() {
		log.info("Tarefa executada com sucesso!");
	}
	*/
	
	/*
	 * DA ESQUERDA PARA DIREITA 
	 * 
	 * 1 -> SIGNFICA SEGUNDOS
	 * 2 -> MINUTOS
	 * 3 -> HORAS
	 * 4 -> DIAS
	 * 5 -> MES
	 * 6 -> DIAS DA SEMANA
	 * 
	 * */
	
	// O que a gente não quiser setar, a gente coloca *

	// Vamos supor que a gente queira que essa tarefa seja executada todo dia 12.
	@Scheduled(cron = "0 0 12 * * *")
	public void executarTarefa() {
		log.info("Tarefa executada com sucesso!");
	}
}
