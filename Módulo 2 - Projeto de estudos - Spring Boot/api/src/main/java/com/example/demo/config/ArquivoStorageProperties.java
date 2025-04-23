package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ArquivoStorageProperties {
	
	public ArquivoStorageProperties() {
	}
	
	public ArquivoStorageProperties(String uploadDir) {
		super();
		this.uploadDir = uploadDir;
	}


	@Value("${arquivo.uploadDir}")
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	
	

}
