package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PreDestroy;

@Service
public class NotificacaoSerivce {
	
	private final SocketIONamespace namespace;
	
	private final SocketIOServer server;
	
	public void publicar(String mensagem) {
		namespace.getBroadcastOperations().sendEvent("notificacao", mensagem);
	}
	
	// MÉTODO PADRÃO QUE VAI RECEBER COMO PARAMETRO A NOSSA OUTRA CLASSE DE SOCKET
	public NotificacaoSerivce(SocketIOServer server) {
		this.server = server;
		
		// VAMOS ESPECIFICAR O CAMINHO QUE VAMOS SUBIR NOSSO WEBSOCKET
		this.namespace = server.addNamespace("/ws-listener");
		
		// VAMOS STARTAR O SERVIDOR
		this.server.start();
	}
	
	
	// MÉTODO PARA FINALIZAR O SERVIDOR QUANDO A GENTE NÃO PRECISAR MAIS
	@PreDestroy
	private void stopSocketIO() {
		this.server.stop();
	}

}
