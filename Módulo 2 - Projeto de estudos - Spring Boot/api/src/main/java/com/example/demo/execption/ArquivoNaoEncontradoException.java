package com.example.demo.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArquivoNaoEncontradoException extends RuntimeException {
	
	public ArquivoNaoEncontradoException(String mensagem) {

		// vai sobrescrever essa mensagem
		super(mensagem);
	}

	public ArquivoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
