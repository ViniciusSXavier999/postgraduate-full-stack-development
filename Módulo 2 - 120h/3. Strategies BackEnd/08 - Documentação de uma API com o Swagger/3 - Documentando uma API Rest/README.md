# 3 → DOCUMENTANDO UMA API REST

🏆 Vamos realizar alguns ajustes na documentação e realizar alguns testes de endpoints.


---

🏆 Com a ajuda do Swagger, vamos fazer a documentação da nossa API.

> Com poucos clique já conseguimos documentar e deixar essa documentação interativa, o que é ainda melhor.
> 

---

## REALIZANDO AJUSTES NECESSÁRIOS E REALIZANDO TESTES

### 1. AGORA COMO NOSSA API TEM A PARTE DE SEGURANÇA, SERÁ NECESSÁRIO REALIZAR ALGUNS PROCEDIMENTOS

- VAMOS GERAR O TOKEN LÁ NO POSTMAN
- EM SEGUIDA, ESCREVER “BEARER” NO CAMPO VALUE E COLAR O TOKEN

🏆 Desse forma, todos enpoints que antes estavam bloqueados, agora estarão livres para serem utilizados.


### 2. AGORA VAMOS REALIZAR A CUSTOMIZAÇÃO(COLOCAR UMA DESCRIÇÃO, NOME) DO MÉTODO NA DOCUMENTAÇÃO DO SWAGGER.

🏆 Para isso vamos utilizar a anotação @Operations do swagger que é usada para descrever endpoints


```java
	@GetMapping("/{id}")
	@Operation(summary = "Buscar estudantes por id", description = "Retorna um estudante de acordo com o seu ID fornecido")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudantePorId(id);
	
	}
```

### 3. PODEMOS NOTAR TAMBÉM QUE NÃO FICA EXPLICITO EM NOSSA DOCUMENTAÇÃO QUE VAMOS RECEBER UM TOKEN COMO RESPONSE, FICA APENAS “?**/” SIMBOLOS ESTRANHOS

🏆 É muito importante ficar claro para quem esta consumindo nossa API, o que cada endpoint dela vai estar retornando e em qual formato vai ser a resposta desse endpoint, nesse caso será JSON.


```java
	@GetMapping(value = "/{id}", produces = "application/json")
	@Operation(summary = "Buscar estudantes por id", description = "Retorna um estudante de acordo com o seu ID fornecido")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudantePorId(id);
	
	}
```

### 4. PARA FAZER UMA LISTA DE RESPONSES QUE A GENTE ESPERA RECEBER EM NOSSA API

```java
@ApiResponses({
    @ApiResponse(responseCode = "401", description = "Acesso não autorizado"),
    @ApiResponse(responseCode = "403", description = "Proibido"),
    @ApiResponse(responseCode = "404", description = "Não encontrado")
})

```

🏆 Tudo isso é para facilitar a vida do usuário.

