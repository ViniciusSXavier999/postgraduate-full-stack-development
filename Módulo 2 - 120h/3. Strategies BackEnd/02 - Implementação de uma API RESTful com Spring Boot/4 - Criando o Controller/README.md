# 4 → CRIANDO O CONTROLLER

🏆 O controller será responsável por receber as requisições, interpreta-las e direciona o request para a lógica de serviço correta.


---

🏆 Agora vamos criar um dos componente principais de nossa API que é o Controller, ele será responsável por receber e tratar as requisições HTTP.


---

⚠️ CORRIGIR OS MÉTODOS PRIVADOS PARA PUBLIC NA CLASSE SERVICE 


---

## 1. VAMOS CRIAR UM NOVO PACKAGE E UMA NOVA CLASSE

- PACKAGE → controller
- CLASSE → EstudanteController

## 2. DESENVOLVENDO CLASSE CONTROLLER

✅ Primeira coisa que precisamos fazer é dizer para o SPRING que se trata de uma classe de controller, para isso utilizaremos a anotação:

- @RestController

✅ Vamos utilizar também a anotação:

- @RequestMapping

Ela serve para que nós possamos especificar a rota do nosso recurso, que nesse caso é o de estudante.

> É interessante a gente criar uma rota para cada recurso.
> 

✅ O controllerEstudante vai ter respostas parecidas com as que a gente criou no service, então podemos copiar e colar os métodos e ir corrigindo eles conforme achamos melhor.


### CADA UM DOS NOSSOS MÉTODOS DA CLASSE CONTROLLER ELES DEVEM RESPONDER PARA UM MÉTODO HTTP ESPECIFICO, VAMOS ESPECIFICAR O MÉTODO HTTP PARA CADA UM DELES.

### MÉTODO BUSCAR ESTUDANTE POR ID

```java
@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@RequestParam Long id) {
	
	}
```

@GetMapping → Toda vez que a gente vê um GET na rota estudantes passando um ID eu quero buscar um estudante por ID.

@RequestParam → @RequestParam ***é utilizado para pegar um parâmetro de query da url***,

> O nome tem que ser o mesmo da rota e do parâmetro do método, nesse caso “id”.
> 

### MÉTODO BUSCAR TODOS OS ESTUDANTES

> Vamos utilizar o método GET também nesse método, quando não tivermos parâmetros, significa que eu quero buscar todos estudantes.
> 

```java
// BUSCANDO TODOS OS ESTUDANTES
@GetMapping
public List<Estudante> buscarTodosEstudantes() {
}
```

### MÉTODO PARA CADASTRAR UM NOVO ESTUDANTE

> Será utilizado o método POST para cadastra um novo estudante.
> 

```java

// CADASTRAR ESTUDANTE
@PostMapping
public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
}

```

@RequestBody → A anotação @RequestBody no Spring Boot **é usada para vincular o corpo de uma solicitação HTTP a um parâmetro de método em um método manipulador do controlador**

### MÉTODO PARA ATUALIZAR INFORMAÇÕES DO ESTUDANTE

> Será utilizado o método PUT
> 

> Também precisamos passar a anotação @RequestBody para enviar os dados atualizados do estudante
> 

```java
// ATUALIZAR ESTUDANTE
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@RequestBody Estudante estudante) {

	}
```

### MÉTODO PARA REMOVER ESTUDANTES

> Vai ser utilizado o verbo DELETE
> 

> Precisaremos passar o id do estudante que queremos excluir.
> 

```java
	// DELETAR ESTUDANTE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirEstudante(@RequestParam Long id) {
	}
```

🏆 AGORA O MEU CONTROLLER PRECISA ENCONTRAR A CLASSE SERVICE, E VAMOS PRECISAR QUE O SPRING FAÇA ISSO PARA NÓS, PARA QUE NÃO SEJA NECESSÁRIO FICAR INSTANCIADO TODA HORA UM ESTUDANTE SERVICE, O SPRING VAI FAZER ISSO AUTOMATICAMENTE. VAMOS FAZER ISSO ATRAVÉS DA INJEÇÃO DE DEPEDÊNCIA.

### PASSO A PASSO:

- Primeiro precisamos ir na classe EstudanteService e dizer para o Spring que ele vai ser o responsável por gerenciar aquela classe, fazemos isso através da anotação @Service
    - Com isso não será necessário ficar toda hora fazendo um “NEW EstudanteService”
- Em seguida vamos fazer a injeção de dependência no controller, existe duas maneiras:
    - Autowired
    - Por meio do construtor

### A PARTIR DE AGORA EU CONSIGO UTILIZAR ESSA VÁRIAVEL NA MINHA CLASSE CONTROLLER E RETORNAR OS MEUS MÉTODOS PRONTOS DA CLASSE SERVICE.

```java
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;

	// BUSCANDO ESTUDANTES POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@RequestParam Long id) {
		return estudanteService.buscarEstudantePorId(id);
	
	}

	// BUSCANDO TODOS OS ESTUDANTES
	@GetMapping
	public List<Estudante> buscarTodosEstudantes() {
		return estudanteService.buscarTodosEstudantes();
	}

	// CADASTRAR ESTUDANTE
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
		return estudanteService.cadastrarEstudante(estudante);

	}

	// ATUALIZAR ESTUDANTE
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudante(estudante);

	}

	// DELETAR ESTUDANTE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirEstudante(@RequestParam Long id) {
		return estudanteService.excluirEstudante(id);
	}

}
```

🏆 Podemos notar que não temos nenhuma lógica de negócio no controller, o trabalho dele é exatamente pegar uma requisição e tratar de acordo com o serviço respectivo dela,


🏆 A nossa lógica fica toda no service.

