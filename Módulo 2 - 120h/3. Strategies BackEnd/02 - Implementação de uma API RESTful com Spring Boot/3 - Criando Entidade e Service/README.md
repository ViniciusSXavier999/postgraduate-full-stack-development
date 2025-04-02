# 3 → CRIANDO ENTIDADE E SERVICE

🏆 Vamos começar a implementar a arquitetura MVC: MODEL, VIEW, CONTROLLER


---

## O QUE É UMA ENTIDADE?

🏆 Uma entidade é basicamente uma classe que irá representar a nossa tabela no banco de dados. é onde as informações de nossa API serão salvas!


## O QUE É O SERVICE?

🏆 O service é responsável por lidar com as regras de negócio da nossa aplicação. É uma parte fundamental da arquitetura em camadas.


---

## 1. VAMOS CRIAR DOIS PACKAGE

- ENTITY
- SERVICE

## 2. VAMOS CRIAR A CLASSE ESTUDANTE

### ATRIBUTOS

- ID
- NOME
- EMAIL
- DATA NASCIMENTO

### CRIAR MÉTODOS CONSTRUTOR E GET E SETTERS

### CLASSE ENTIDADE PRONTA

```sql
package com.example.demo.entity;

import java.time.LocalDate;

public class Estudante {
	
	public Estudante(Long id, String nome, String email, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public Estudante(){
	}
	
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	

}
```

## 3. VAMOS INICIAR O DESENVOLVIMENTO DO SERVICE

🏆 Inicialmente vamos alocar esses dados dentro de uma variável 

```java
private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
```

🏆 É muito importante que a gente dê um retorno de sucesso ou falha(por exemplo quando a gente não acha um estudante, a gente fala para o usuário que aquele estudante não foi encontrado) para quem está usando a nossa API, para isso utilizamos o RESPONSE ENTITY


🏆 RESPONSE ENTITY → PERMITE QUE A GENTE MODELE E RETORNE PARA O USUÁRIO UMA RESPOSTA COM STATUS CODE DA MELHOR FORMA POSSÍVEL DEPENDENDO DO CENÁRIO


### SERVICE CRIADO COM SUCESSO!

> Código pode sofrer alterações em breve.
> 

### BUSCAR ESTUDANTE POR ID

```java
private ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		Estudante estudante  = listaEstudantes.get(id);
		
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estudante); 
	}
```

### BUSCANDO TODOS ESTUDANTES

```java
	private List<Estudante> buscarTodosEstudantes() {
		return new ArrayList<>(listaEstudantes.values());
```

### CADASTRAR ESTUDANTE

```java
private ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		Estudante estudanteEncontrado  = listaEstudantes.get(estudante.getId());
		
		if (estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado); 
	}
```

### ATUALIZAR ESTUDANTE

```java
private ResponseEntity<Estudante> atualizarEstudante(Estudante estudante) {
		Estudante estudanteEncontrado  = listaEstudantes.get(estudante.getId());
		
		if (estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		// A unica coisa diferente é que vamos substituir o estudante na lista
		listaEstudantes.put(estudante.getId(), estudante);
		
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado); 
	}
```

### EXCLUIR ESTUDANTE

```java
private ResponseEntity<Estudante> atualizarEstudante(Estudante estudante) {
		Estudante estudanteEncontrado  = listaEstudantes.get(estudante.getId());
		
		if (estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		// A unica coisa diferente é que vamos substituir o estudante na lista
		listaEstudantes.put(estudante.getId(), estudante);
		
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado); 
	}
```