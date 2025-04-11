# 1 → DEFININDO AS CLASSES

🏆 Nesse módulo vamos ver como vamos fazer upload e download de arquivos utilizando o SPRING


---

🏆 Nesta aula, vamos identificar as classes e dependências que serão utilizadas na implementação de upload e download de arquivos.


🏆 Nós precisaremos de uma classe com as informações do arquivo que foi feito o upload e uma Exception caso tenhamos algum problema ao tentar fazer o upload.


🏆 O download irá precisar de apenas uma Exception para caso o arquivo procurado não seja encontrado.


🏆 Nessas classes teremos algumas informações, como por exemplo:

- Nome do arquivo
- Link pro download
- Tamanho do arquivo

---

### 1. VAMOS IR ATÉ A NOSSA APLICAÇÃO E NO PACOTE ENTITY VAMOS CRIAR UMA CLASSE CHAMADA ‘ARQUIVO’

> Comando que duplica a linha → CTRL + ALT + SETA PARA BAIXO
> 

### 2. DENTRO DESSA CLASSE VAMOS LISTAR OS ATRIBUTOS NECESSÁRIOS PARA ESSE MEU ARQUIVO

```java
private String nomeArquivo;
private String linkDownload;
private String extensãoArquivo; // extensão do arquivo
private Long tamanho;

public class Arquivo {

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
```

### 3. VAMOS CRIAR UM NOVO PACKAGE CHAMADO ‘EXCEPTION’ PARA AS NOSSAS EXCEÇÕES.

### 4. DENTRO DESSE PACKAGE VAMOS CRIAR A NOSSA CLASSE PARA EXCEÇÕES DOS UPLOAD

🏆 Toda exceção precisaremos estender ela a outra exceção e sobrescrever alguns métodos que sejam necessários para nós.


🏆 SUPER() → CHAMA O CONSTRUTOR DA SUPER CLASSE 


```java
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

```

### 5. VAMOS CRIAR OUTRA EXCEPTION PARA CASO A GENTE BAIXE UM ARQUIVO QUE NÃO EXISTA

```java
package com.example.demo.execption;

public class ArquivoNaoEncontradoException extends RuntimeException {
	
	public ArquivoNaoEncontradoException(String mensagem) {

		// vai sobrescrever essa mensagem
		super(mensagem);
	}

	public ArquivoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
```

### 6. VAMOS ADICIONAR A ANOTAÇÃO @RESPONSESTATUS

🏆 Além de mandarmos a exception, a gente manda o status correto.

