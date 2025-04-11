package com.example.demo.entity;

public class Arquivo {
	
	private String nomeArquivo;
	private String linkDownload;
	private String extensãoArquivo; // extensão do arquivo
	private Long tamanho;
	
	public Arquivo() {
		
	}
	
	
	public Arquivo(String nomeArquivo, String linkDownload, String extensãoArquivo, Long tamanho) {
		super();
		this.nomeArquivo = nomeArquivo;
		this.linkDownload = linkDownload;
		this.extensãoArquivo = extensãoArquivo;
		this.tamanho = tamanho;
	}


	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getLinkDownload() {
		return linkDownload;
	}
	public void setLinkDownload(String linkDownload) {
		this.linkDownload = linkDownload;
	}
	public String getExtensãoArquivo() {
		return extensãoArquivo;
	}
	public void setExtensãoArquivo(String extensãoArquivo) {
		this.extensãoArquivo = extensãoArquivo;
	}
	public Long getTamanho() {
		return tamanho;
	}
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
	
	

}
