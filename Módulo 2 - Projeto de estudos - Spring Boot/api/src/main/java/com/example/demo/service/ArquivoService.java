package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.config.ArquivoStorageProperties;

@Service
public class ArquivoService {
	
	public ArquivoService(ArquivoStorageProperties arquivoStorageProperties) {
		// Vamos pegar aquela string do meu arquivo application properties
		arquivoStorageProperties.getUploadDir();
	}

}
