package com.example.demo.execption;

public class UploadArquivoException extends RuntimeException {

	public UploadArquivoException(String mensagem) {

		// vai sobrescrever essa mensagem
		super(mensagem);
	}

	public UploadArquivoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
