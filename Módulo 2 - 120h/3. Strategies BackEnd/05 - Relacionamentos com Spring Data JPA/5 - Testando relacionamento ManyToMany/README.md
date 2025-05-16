# 5 → TESTANDO RELACIONAMENTO MANY TO MANY

🏆 Agora chegou o grande momento de testarmos, porém, em relação a Avaliação precisamos criar:

- Repository
- Service
- Controller

---

### 1. PRIMEIRO VAMOS CRIAR O REPOSITORY

```java
public interface AvaliacaoCursoRepository extends JpaRepository<AvaliacaoCurso, AvaliacaoCursoKey>{
}
```

### 2. VAMOS PRECISAR FAZER UM CRUD DE CURSO (NÃO SERÁ FEITO EM VIDEO AULA, O PROFESSOR DEIXOU COMO DESAFIO)

🏆 Pra adiantar, será adicionado valores diretamente no banco de dados 


### 3. REPOSITORY DE CURSOREPOSITORY

```java
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

// Estamos realizando uma consulta personalizada 
  Optional<Curso> findByNome(@Param("nomeCurso") String nomeCurso)
}
```

### 4. VAMOS CRIAR O SERVICE DE AVALIACAO CURSO



### PRIMEIRO VAMOS REALIZAR A INJEÇÃO DE DEPENDÊNCIA DOS REPOSITORYS NO SERVICE 🏆

- AvaliacaoCursoRepository
- EstudanteRepository
- CursoRepository



### AGORA VAMOS CRIAR O MÉTODO AVALIAR 🏆

```java
public ResponseEntity<String> avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao) {
		Optional<Estudante> estudanteOpt = estudanteRepository.findById(idEstudante);
		if (!estudanteOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
		}
		
		Optional<Curso> cursoOpt = cursoRepository.findByNome(nomeCurso);
		if (!cursoOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
		}
		
		AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();
		avaliacaoCurso.setEstudante(estudanteOpt.get());
		avaliacaoCurso.setCurso(cursoOpt.get());
		avaliacaoCurso.setNotaDaAvaliacao(notaAvaliacao);
		
		avaliacaoCursoRepository.save(avaliacaoCurso);
		return ResponseEntity.ok("Avaliação salva com sucesso");
		
		
	}

```



### EXPLICAÇÃO LINHA POR LINHA DO MÉTODO ✅

---

### 🔹 Método completo:

```java
public ResponseEntity<String> avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao)

```

---

### 🧠 O que ele faz?

Este método busca um estudante e um curso no banco de dados, cria uma nova avaliação para o curso com base na nota informada e a salva. Ele retorna uma resposta HTTP apropriada dependendo do sucesso ou falha da operação.

---

### 🧩 Linha por linha:

---

```java
public ResponseEntity<String> avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao)

```

- Declaração do método.
- Retorna um `ResponseEntity<String>` (uma resposta HTTP com uma mensagem de texto).
- Recebe 3 parâmetros:
    - `idEstudante`: ID do estudante que fez a avaliação.
    - `nomeCurso`: nome do curso avaliado.
    - `notaAvaliacao`: nota dada pelo estudante (por exemplo, de 0 a 10).

---

```java
Optional<Estudante> estudanteOpt = estudanteRepository.findById(idEstudante);

```

- Tenta encontrar um estudante no banco de dados com o `idEstudante`.
- O resultado é um `Optional<Estudante>` — pode conter o estudante ou estar vazio (`Optional.empty()`), caso não encontrado.

---

```java
if (!estudanteOpt.isPresent()) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
}

```

- Verifica se o estudante não foi encontrado.
- Se for o caso, retorna uma resposta HTTP 404 (`NOT_FOUND`) com a mensagem **"Estudante não encontrado!"**.

---

```java
Optional<Curso> cursoOpt = cursoRepository.findByNome(nomeCurso);

```

- Busca um curso com o nome informado.
- `cursoRepository.findByNome(...)` provavelmente é um método customizado no repositório (como `findByNome(String nome)`).
- Retorna um `Optional<Curso>`.

---

```java
if (!cursoOpt.isPresent()) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
}

```

- Verifica se o curso também não foi encontrado.
- Se não existir, retorna HTTP 404 com a mensagem **"Curso não encontrado"**.

---

```java
AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();

```

- Cria uma nova instância da entidade `AvaliacaoCurso`, que provavelmente representa a tabela de avaliações no banco.

---

```java
avaliacaoCurso.setEstudante(estudanteOpt.get());

```

- Define o estudante na avaliação.
- Usa `estudanteOpt.get()` pois já foi validado que o estudante existe (`isPresent()` foi verdadeiro).

---

```java
avaliacaoCurso.setCurso(cursoOpt.get());

```

- Define o curso na avaliação.

---

```java
avaliacaoCurso.setNotaDaAvaliacao(notaAvaliacao);

```

- Define a nota informada na avaliação.

---

```java
avaliacaoCursoRepository.save(avaliacaoCurso);

```

- Salva o objeto `AvaliacaoCurso` no banco de dados.
- Esse repositório deve ser uma interface que estende `JpaRepository`.

---

```java
return ResponseEntity.ok("Avaliação salva com sucesso");

```

- Retorna uma resposta HTTP 200 (`OK`) com a mensagem de sucesso.

---

### ✅ Em resumo:

Este método:

1. Verifica se o estudante e o curso existem.
2. Se sim, cria uma nova avaliação com os dados.
3. Salva no banco.
4. Retorna uma resposta apropriada (404 ou 200).



### 5. VAMOS CRIAR O CONTROLLER DE AVALIACAOCURSO

```java
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoCursoController {

	
	@Autowired
	private AvaliacaoCursoService avaliacaoCursoService;
	
	public ResponseEntity<String> avaliar(@RequestParam Long idEstudante, @RequestParam String nomeCurso, @RequestParam Integer notaAvaliacao) {
		return avaliacaoCursoService.avaliar(idEstudante, nomeCurso, notaAvaliacao);
	}
}
```

✅ OS PARAMETROS VÃO VIR NA URL DA REQUISIÇÃO


---

## INICIANDO TESTES NO POSTMAN

- Primeiro vamos colocar o id do estudante
- Segundo vamos passar o nome do curso
    - Vale lembrar que não temos dados dos cursos ainda, será necessário inserir no banco de dados ou criar um crud de curso
- Terceiro vamos passar a nota

✅ O resultado esperado é “200 OK → avaliação salva com sucesso”

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/testandoManyToMany1.png" />


### APÓS ISSO, VAMOS VERIFICAR NO BANCO SE A AVALIÇÃO FOI SALVA COM SUCESSO ✅

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/testandoManyToMany2.png" />

