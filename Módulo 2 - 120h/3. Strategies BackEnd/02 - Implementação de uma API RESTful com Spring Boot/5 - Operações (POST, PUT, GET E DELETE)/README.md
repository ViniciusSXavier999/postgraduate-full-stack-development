# 5 → OPERAÇÕES (POST, PUT, GET E DELETE)

🏆 Vamos realizar os devidos testes do nosso controler, serve e ver se a nossa API está funcionando como a gente gostaria.


---


🏆 VAMOS IMPLEMENTAR E TESTAR AS OPERAÇÕES: CRIAR(POST), ATUALIZAR(PUT), LISTAR(GET) E REMOVER(DELETE)


---

⚠️

### CORREÇÃO NO CÓDIGO 1

Vamos precisar realizar uma alteração no método “cadastrar estudante”, porque até então o cadastro não estava sendo feito de maneira correta.

```java
// CADASTRAR ESTUDANTE
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		listaEstudantes.put(estudante.getId(), estudante);
		
		return ResponseEntity.status(HttpStatus.OK).body(estudante); 
	}
```


⚠️

### CORREÇÃO NO CÓDIGO 2

Vamos precisar alterar o método “buscarEstudantePorId” com a anotação @PathVariable, estamos passando esse parâmetro na url da requisição, não como parâmetro 

```java
// BUSCANDO ESTUDANTES POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudantePorId(id);
	
	}
```

Já a anotação **@PathVariable** serve para pegar um `trecho` da url que geralmente é dinâmico. Exemplo:

```bash
http://localhost:8080/topicos/javaCopiar código
```

Agora como não tem o padrão **?nomeParametro=valorParametro** na url, o `/java` não é mais um parâmetro de query, mas sim parte da própria url, e para recuperá-lo devemos utilizar a anotação `@PathVariable`:

```less
@GetMapping("/topicos/{curso}")
public void exemplo(@PathVariable String curso) {
    //...
}Copiar código
```


⚠️ Todos os métodos vão ter a anotação @PathVariable, menos o método cadastrarEstudante


---

## INICIANDO OS TESTES NO POSTMAN.

### 1. PRIMEIRO VAMOS CADASTRAR UM ESTUDANTE (POST)

> Lembrando que foi declarado um método que recebe no corpo da requisição um objeto do tipo estudante.
> 

> Nós devemos passar um JSON exatamente no formato que nós declaramos nossa classe estudante
> 

```json
{
    "id": 1,
    "nome": "Vinicius xavier",
    "email": "vini@gmail.com",
    "dataNascimento": "2000-02-02"
}
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/opera%C3%A7%C3%B5es1.png" />

✅ NOSSO ESTUDANTE FOI CADASTRADO COM SUCESSO E RECEBEU COMO RESPOSTA O STATUS 200 OK


### 2. AGORA VAMOS BUSCAR ESTUDANTES POR ID (GET)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/opera%C3%A7%C3%B5es2.png" />

### 3. BUSCANDO TODOS ESTUDANTES (GET)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/opera%C3%A7%C3%B5es3.png" />

### 4. VAMOS ATUALIZAR UM ESTUDANTE (PUT)

> Vamos ter que passar um body no corpo da requisição.
> 

> Vamos supor que a gente queira atualizar o e-mail do estudante do id 1 que no caso se chama yslla
> 

```json
{
        "id": 2,
        "nome": "Yslla lima",
        "email": "heliane@gmail.com",
        "dataNascimento": "2000-02-02"
    }
```

⚠️ Durante aula estávamos tendo um real ao tentar atualizar estudante, nesse caso o erro era no método put no controller, onde era necessário passar o id como parâmetro do método e também atribuir a anotação @RequestBody, método atualizado:

```java
@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudante(estudante);
	}
```


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/opera%C3%A7%C3%B5es4.png" />

⚠️ Podemos notar que ao dar um get buscando por ID, é retornado o e-mail atualizado.


### 5. VAMOS DELETAR UM ESTUDANTE (DELETE)

> Basta passar o id do estudante que deseja deletar.
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/opera%C3%A7%C3%B5es5.png" />

⚠️ Nesse caso deletamos o estudante que pertence ao ID 2.

