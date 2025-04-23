package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.ArquivoStorageProperties;
import com.example.demo.execption.ArquivoNaoEncontradoException;
import com.example.demo.execption.UploadArquivoException;

import jakarta.annotation.Resources;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ArquivoService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ArquivoService.class);
	private final Path fileStorageLocation;
	
	public ArquivoService(ArquivoStorageProperties arquivoStorageProperties) {
		// Vamos pegar aquela string do meu arquivo application properties
		this.fileStorageLocation = Paths.get(arquivoStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(fileStorageLocation);
		} catch (IOException e) {
			
			throw new UploadArquivoException("Algo deu errado ao tentar criar a pasta", e);
			
		}
	}
	
	// MÉTODO PARA SALVAR ARQUIVO (UPLOAD DO ARQUIVO)
	public String salvarArquivo(MultipartFile file) {
		String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if (nomeArquivo.contains("..")) {
				throw new UploadArquivoException("Arquivo invalido");
			}
			
			// Junta o caminho base (fileStorageLocation) com o nomeArquivo.
			Path targetLocation = this.fileStorageLocation.resolve(nomeArquivo);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return nomeArquivo;
			
		} catch (Exception e) {
			throw new UploadArquivoException("Erro ao tentar salvar o arquivo", e);
		}
	}
	
	
	// CARREGAR ARQUIVO (DOWNLOAD)
	public Resource carregarArquivo(String arquivoNome) {
		try {
			Path filePath = this.fileStorageLocation.resolve(arquivoNome).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			
			if (resource.exists()) {
				return resource;
			} else {
				throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
			}
		} catch (Exception e) {
				throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
		}
	}
	
	
	
	
	// MÉTODO DE PEGAR EXTENSÃO DO ARQUIVO
	public String getContentType(HttpServletRequest request, Resource resource) {
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			
		} catch (Exception e) {
			log.error("Não foi possível determninar o tipo de arquivo");
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return contentType;
		
	}
	

}
