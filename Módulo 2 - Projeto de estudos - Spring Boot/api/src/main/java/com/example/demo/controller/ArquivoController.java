package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Arquivo;
import com.example.demo.service.ArquivoService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService arquivoService;
	
	/* Como vamos passar o arquivo no body, vamos ter que usar um post mapping */
	@PostMapping("upload")
	public Arquivo uploadArquivo(@RequestParam("file") MultipartFile file) {
		String nomeArquivo = arquivoService.salvarArquivo(file);
		
		String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/arquivos/downloadArquivo/")
				.path(nomeArquivo).toUriString();
		
		return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(), file.getSize());
	}
	
	
	@GetMapping("/downloadArquivo/{nomeArquivo}")
	public ResponseEntity<Resource> downloadArquivo(@PathVariable String nomeArquivo, HttpServletRequest request) {
		
		
		Resource resource = arquivoService.carregarArquivo(nomeArquivo);
		
		// descobringo o tipo do arquivp
		String contentType = arquivoService.getContentType(request, resource);
		
		// agora vamos fazer o download do arquivo
		
		return ResponseEntity.ok()
				// Esse é um padrão para transferência e download de arquivo
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
