# 3 → MÉTODOS DO SPRING DATA JPA

🏆 Os métodos do JPARepository são as funcionalidades disponíveis que podemos utilizar na nossa aplicação, como o salvar, Deletar, alterar e alguns métodos de Pesquisa.


### OS PRINCIPAIS MÉTODOS DO JPA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA1.png" />

---

### VAMOS COMEÇAR ALTERANDO O NOSSO ESTUDANTE SERVICE

> ANTERIORMENTE A GENTE ESTAVA REALIZANDO TESTES COM UMA LISTA DE ESTUDANTES, A IDEIA AGORA É SALVAR O ESTUDANTE NO BANCO DE DADOS, QUE É O CERTO A SE FAZER DESDE O INICIO.
> 

### 1. PARA ISSO VAMOS INJETAR O NOSSO REPOSITORY NO SERVICE E EXCLUIR A VARIAVEL DE LISTA.

```java
	@Autowired
	private EstudanteRepository repository;
```

### 2. ALTERANDO O MÉTODO BUSCANDO ESTUDANTE POR ID

```java
	// BUSCANDO ESTUDANTES POR ID
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		if (repository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get()); 
			
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
```



### EXPLICANDO O CÓDIGO 🏆

```java
public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {

```

– Declaração do método `buscarEstudantePorId`, que recebe um `id` do tipo `Long` e retorna um `ResponseEntity<Estudante>`, ou seja, uma resposta HTTP com um objeto do tipo `Estudante`.

```java
	if (repository.existsById(id)) {

```

– Verifica se existe um estudante com o ID informado usando o método `existsById(id)` do repositório (geralmente ligado ao banco de dados).

```java
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());

```

– Se o estudante existir:

- Retorna um `ResponseEntity` com status HTTP 200 (OK),
- E com o corpo contendo o estudante buscado (`repository.findById(id).get()` recupera o objeto do banco).

```java
	}

```

– Fim do bloco `if`.

```java
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

```

– Se o estudante **não** existir:

- Retorna um `ResponseEntity` com status 404 (Not Found),
- E com o corpo vazio (`null`).

### 3. ALTERANDO O MÉTODO BUSCARTODOSESTUDANTES()

```java
	public List<Estudante> buscarTodosEstudantes() {
		return repository.findAll();
}
```



### EXPLICANDO O CÓDIGO 🏆

```
public List<Estudante> buscarTodosEstudantes() {
	return repository.findAll();
}
```

O MÉTODO `findAll()` é responsável por retornar uma lista de objetos.


### 4. ALTERANDO O MÉTODO CADASTRARESTUDANTE()

```java
// CADASTRAR ESTUDANTE
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		Estudante estudanteCadastrado = repository.save(estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteCadastrado);
	}
```

> É muito importante retornar as respostas adequadas para cada método para que nossa API atenda aos padrões do REST.
> 

### 5. ALTERANDO MÉTODO ATUALIZARESTUDANTE()

> Vamos precisar alterar o método do controller porque o id não estava sendo passado no método
> 

```java
// ATUALIZAR ESTUDANTE
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {
		
		if (repository.existsById(id)) {
			Estudante estudanteCadastrado = repository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteCadastrado);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
			
	}
```

🏆

### EXPLICANDO CÓDIGO

---

```java
public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {

```

– Declaração do método:

- Nome: `atualizarEstudante`
- Parâmetros: o `id` do estudante a ser atualizado e o objeto `Estudante` com os novos dados.
- Retorno: `ResponseEntity<Estudante>`, ou seja, uma resposta HTTP com o estudante atualizado ou uma mensagem de erro.

---

```java
	if (repository.existsById(id)) {

```

– Verifica se o estudante com o ID informado **existe** no banco de dados.

---

```java
		Estudante estudanteCadastrado = repository.save(estudante);

```

– Se existir:

- Atualiza o estudante usando o método `save(estudante)` do repositório.
- O `save()` atualiza se o ID já existe; se não existir, insere um novo registro.
- O retorno (`estudanteCadastrado`) é o objeto salvo no banco (pode vir com dados atualizados como ID ou timestamps).

---

```java
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteCadastrado);

```

– Retorna uma resposta HTTP:

- Status 200 OK
- Corpo: o estudante atualizado.

---

```java
	} else {

```

– Se o estudante com o ID informado **não existe**:

---

```java
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

```

– Retorna uma resposta com:

- Status 404 (Not Found),
- Corpo vazio (`null`), indicando que não foi possível encontrar o estudante para atualizar.

### 6. ALTERANDO O MÉTODO EXCLUIRESTUDANTE()

```java
// DELETAR ESTUDANTE
	public ResponseEntity<String> excluirEstudante(Long id) {
		

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
			
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
	}
```

---

## MOMENTOS DOS TESTES NO POSTMAN

### CADASTRANDO ESTUDANTE(POST)

ESTUDANTE 1

```xml
{
    "nome": "Yslla lima",
    "email": "yslla@gmail.com",
    "dataNascimento": "2000-02-02"
}
```

> Não é mais necessário passar o id, pois agora o spring é o responsável por isso.
> 

ESTUDANTE 2

```xml
{
    "nome": "Vini",
    "email": "vini@gmail.com",
    "dataNascimento": "2006-01-09"
}
```

### RESPOSTA DO MÉTODO POST

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA2.png" />

### BUSCANDO ESTUDANTES(GET)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA3.png" />

### BUSCANDO ESTUDANTE POR ID(GET)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA4.png" />

### ATUALIZANDO ESTUDANTE(PUT)

```xml
		{
        "id": 1,
        "nome": "Yslla heli atualizado",
        "email": "heliane@gmail.com",
        "dataNascimento": "2000-02-02"
    }
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA5.png" />

### DELETANDO ESTUDANTE(DELETE)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/metodosJPA6.png" />