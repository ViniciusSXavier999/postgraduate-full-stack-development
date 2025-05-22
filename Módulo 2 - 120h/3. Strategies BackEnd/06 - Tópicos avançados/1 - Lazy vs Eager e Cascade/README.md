# 1 → LAZY VS EAGER E CASCADE

🏆 São recursos avançados porque sempre vamos ver ou precisar usar esses recursos em uma aplicação real.


---

### O QUE É LAZY?

🏆 LAZY é um padrão de projeto que é usado para adiar a inicialização de um objeto o máximo possível.

> Esse padrão existe para evitar que a gente tenha problemas de performance em determinadas consultas no banco
> 

> Caso a gente tenha várias entidades conectadas uma com as outras, muitas das vezes não faz sentido trazer todas entidades de uma vez em uma consulta ao banco de dados por exemplo. o lazy acaba sendo útil nesse sentido, podemos trazer somente o que seja realmente necessário.
> 

### O QUE É EAGER?

🏆 EAGER é um padrão de projeto no qual a inicialização dos dados ocorre no mesmo instante.


### O QUE É CASCADE?

> Em um relacionamento entre entidades, a existência de uma só faz sentido se a outra existir. Por exemplo, um Endereço só existe se um Aluno existir.
> 

🏆 Cascade permite que uma determinada ação seja realizada tanto na entidade pai, assim como em suas entidades filhas.

> Qualquer alteração que eu fizer na classe principal, vai acontecer também nas classes filhas, esse é o papel do cascade.
> 

---

## EXEMPLO DE LAZY VS EAGER E CASCADE

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/lazyEagerCascade1.png" />

## EXEMPLO DE CASCADE

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/lazyEagerCascade2.png" />

### AO TOTAL EXISTE 7 TIPOS DE CASCADE:

---

### ✅ 1. `CascadeType.PERSIST`

> Quando salvar (persist) o pai, também salva os filhos automaticamente.
> 

📌 Exemplo: `entityManager.persist(pai);` também persiste os filhos.

---

### ✅ 2. `CascadeType.MERGE`

> Quando atualizar (merge) o pai, também atualiza os filhos.
> 

📌 Útil para sincronizar objetos modificados com o banco.

---

### ✅ 3. `CascadeType.REMOVE`

> Quando deletar (remove) o pai, também deleta os filhos.
> 

📌 Cuidado! Pode apagar dados relacionados automaticamente.

---

### ✅ 4. `CascadeType.REFRESH`

> Quando atualizar o pai com dados do banco (refresh), também atualiza os filhos.
> 

📌 Útil para sincronizar o estado do objeto com o banco.

---

### ✅ 5. `CascadeType.DETACH`

> Quando desanexar (detach) o pai do contexto de persistência, também desanexa os filhos.
> 

📌 Ex: `entityManager.detach(pai);` remove o pai e os filhos da sessão.

---

### ✅ 6. `CascadeType.ALL`

> Ativa todos os tipos acima (PERSIST, MERGE, REMOVE, REFRESH, DETACH).
> 

📌 É um atalho para aplicar tudo de uma vez.

---

### ✅ 7. (Extra) `CascadeType.SAVE_UPDATE` *(específico do Hibernate)*

> Semelhante ao MERGE, mas mais interno ao Hibernate (não parte da especificação JPA).
> 

📌 Usado raramente em aplicações padrão com JPA puro.

---

### 🎯 Exemplo prático:

```java
@OneToMany(mappedBy = "pai", cascade = CascadeType.ALL)
private List<Filho> filhos;

```

Esse mapeamento faz com que qualquer operação no "pai" afete automaticamente os "filhos".

---

---

### COLOCANDO EM PRÁTICA ESSES RECURSOS NO PROJETO 

💡 A nossa aplicação já funciona sem o lazy EAGER, o relacionamento @OneToOne por padrão a inicialização é sempre EAGER e o @OneToMany é lazy.

- @OneToOne → EAGER
- @OneToMany → LAZY

### O QUE É “spring.jpa.open-in-view”? 💡



---

## 🔧 `spring.jpa.open-in-view`

É uma **configuração do Spring Boot** que define se a **sessão do EntityManager (Hibernate)** ficará **aberta durante toda a requisição HTTP**, inclusive na **fase da visualização (view)**.

### ✅ Por padrão: `true`

Isso permite acessar **relacionamentos `LAZY`** em templates (como **Thymeleaf**) mesmo **fora do service**, durante a renderização da view.

---

### 🧠 Por que existe?

No JPA, se você tenta acessar um relacionamento `LAZY` **depois que a transação terminou**, você recebe:

> LazyInitializationException
> 

Com `open-in-view: true`, o Hibernate **mantém a sessão aberta até a view ser renderizada**, evitando esse erro.

---

### ⚠️ Problemas (quando usar `false`)

- Manter a sessão aberta por muito tempo **vai contra boas práticas de arquitetura**.
- Pode causar **problemas de desempenho** e **vazamento de recursos**.
- **Ideal** em APIs REST: **desativar** e resolver `LAZY` dentro do service.

```yaml
spring.jpa.open-in-view: false

```

---

### ✅ Resumo rápido:

| Valor | Efeito |
| --- | --- |
| `true` (padrão) | Mantém a sessão aberta até o final da requisição (inclusive na view) |
| `false` | Fecha a sessão após a transação – evita uso de entidades fora do service |

---


### CASO A GENTE DEIXE COMO FALSE E TENTE BUSCAR UM ESTUDANTE POR ID, TEREMOS UM ERRO DE LAZY

🏆 Ainda que minha aplicação seja lazy, se eu usar esse atributo em algum momento, o JPA vai buscar esse dado no banco de dados para nós.


🏆 Vamos supor que essa informação de livros não é importante pra quem está buscando estudante por id, imagina que essa informação de livros só é usada dentro da nossa aplicação em si, então não faz sentido eu buscar essa informação toda vez que eu for buscar um estudante por ID.

> Só vai fazer sentido eu trazer essa informação somente quando eu for precisar dela, essa é a ideia da gente trazer ela aqui.
> 

### TEM DUAS FORMAS PARA RESOLVER ISSO

### 1. A PRIMEIRA E MAIS UTILIZADA

```java
@Transactional
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		if (repository.existsById(id)) {
			Optional<Estudante> estudanteOpt = repository.findById(id);
			
			// #1 - Usar a entidade livros de alguma forma
			estudanteOpt.ifPresent(e -> {
				Set<Livro> livros = e.getLivros();
				System.out.println(livros.size());
			});
			return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

```



### EXPLICAÇÃO DO CÓDIGO 1 💡

Esse método tem como objetivo **buscar um estudante por ID** e garantir que, ao acessar seus **livros relacionados (provavelmente `@OneToMany`)**, **não ocorra `LazyInitializationException`**.

---

## 🧩 Resumo do que o código faz:

```java
@Transactional
public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {

```

### 🔁 1. Verifica se o estudante existe no banco

```java
if (repository.existsById(id)) {

```

### 📦 2. Busca o estudante com `findById`

```java
Optional<Estudante> estudanteOpt = repository.findById(id);

```

### 📚 3. Acessa os **livros** do estudante (relacionamento)

```java
estudanteOpt.ifPresent(e -> {
    Set<Livro> livros = e.getLivros();
    System.out.println(livros.size());
});

```

- Aqui está o motivo do `@Transactional`:
    
    👉 Como `livros` provavelmente é `LAZY`, o acesso a `getLivros()` precisa ser **feito dentro de uma transação ativa**, senão o Hibernate lança erro (`LazyInitializationException`).
    

### ✅ 4. Retorna o estudante com HTTP 200

```java
return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());

```

- O `findById` é chamado duas vezes (desnecessariamente — dá para otimizar).

### ❌ 5. Se não existir, retorna HTTP 404

```java
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

```

---

## 🎯 Resumo final:

- `@Transactional` mantém a **sessão Hibernate aberta** durante todo o método.
- Isso permite **acessar os livros do estudante**, mesmo que eles estejam com **fetch = LAZY**.
- Sem `@Transactional`, acessar `e.getLivros()` **poderia causar erro**, porque o Hibernate já teria fechado a sessão.

---

## 🛠️ Otimização sugerida:

Evite chamar `findById` duas vezes:

```java
@Transactional
public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
    Optional<Estudante> estudanteOpt = repository.findById(id);

    if (estudanteOpt.isPresent()) {
        Estudante estudante = estudanteOpt.get();
        estudante.getLivros().size(); // força a inicialização
        return ResponseEntity.ok(estudante);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
}

```


### ACABEI FICANDO COM DÚVIDAS COM O USA DE LAMBDA NO MÉTODO


### EXPLICAÇÃO DO BLOCO DE CÓDIGO UTILIZANDO LAMBDA 💡

```java
estudanteOpt.ifPresent(e -> {
    Set<Livro> livros = e.getLivros();
    System.out.println(livros.size());
});

```

é o uso do método **`ifPresent`** da classe `Optional<T>` do Java.

---

## ✅ O que é `ifPresent`?

### 🔹 `ifPresent(Consumer<? super T> action)`

É um método que **executa um bloco de código apenas se o valor estiver presente** no `Optional`.

Ou seja:

- Se o `Optional` **tem um valor (não é vazio)** → ele executa o código do lambda.
- Se o `Optional` **está vazio** → não faz nada.

---

## 🧩 No seu exemplo:

```java
Optional<Estudante> estudanteOpt = repository.findById(id);

```

`repository.findById(id)` retorna um `Optional<Estudante>`, porque o estudante **pode existir ou não**.

Depois, com:

```java
estudanteOpt.ifPresent(e -> {
    Set<Livro> livros = e.getLivros();
    System.out.println(livros.size());
});

```

- Se `estudanteOpt` **tem um estudante**, ele:
    1. Pega os **livros** do estudante.
    2. Mostra quantos livros ele tem.
- Se o `Optional` estiver **vazio**, o bloco **não é executado** (evita `NullPointerException`).

---

## 🧠 Resumo simples:

| Código | Significado |
| --- | --- |
| `Optional<T>.ifPresent(...)` | "Se houver valor, execute isso..." |
| `e -> { ... }` | Lambda que executa ações com o valor `e` (estudante) |
| `e.getLivros().size()` | Acessa a lista de livros para forçar o carregamento |

---




### O MESMO CÓDIGO, MAS UTILIZANDO O IF TRADICIONAL 💡

---

## 🔁 Usando `if (optional.isPresent())` e `.get()`

### 🔹 Exemplo equivalente ao que você tinha:

```java
Optional<Estudante> estudanteOpt = repository.findById(id);

if (estudanteOpt.isPresent()) {
    Estudante estudante = estudanteOpt.get(); // extrai o valor
    Set<Livro> livros = estudante.getLivros();
    System.out.println(livros.size());
}

```

---

## ✅ Diferença entre os dois jeitos:

| Forma com lambda (mais moderna) | Forma tradicional |  |  |
| --- | --- | --- | --- |
| `optional.ifPresent(e -> { ... })` | `if (optional.isPresent()) { ... }` |  |  |
| Mais funcional (estilo Java 8+) | Mais legível para iniciantes |  |  |
| Evita uso explícito de `.get()` | Precisa usar `.get()` manualmente |  |  |

Ambas funcionam do mesmo jeito — escolha a que achar mais clara pro seu time ou projeto.

---


### 2. UTILIZANDO O HIBERNATE INITIALIZER

```java
@Transactional
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		if (repository.existsById(id)) {
			Optional<Estudante> estudanteOpt = repository.findById(id);
			 Hibernate.initialize(estudanteOpt.get().getLivros());
			return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
```



### O QUE É O HIBERNATE.INITIALIZER? 🏆

---

## ✅ O que é **`Hibernate.initialize()`**?

`Hibernate.initialize()` é um **método utilitário da API do Hibernate** que serve para **forçar a inicialização (carregamento)** de atributos marcados com `LAZY`, como coleções (`@OneToMany`) ou relacionamentos (`@ManyToOne`), **antes que a sessão seja fechada**.

---

## 🧠 Por que isso é útil?

No Hibernate (e JPA), relacionamentos `LAZY` **não são carregados automaticamente** — eles só são carregados **quando acessados**, e isso **precisa acontecer dentro de uma transação ativa**.

Se você tentar acessar um relacionamento `LAZY` **fora da transação**, você recebe um erro:

> ❌ LazyInitializationException
> 

---

## 🔧 Como `Hibernate.initialize()` resolve isso?

Você chama esse método **dentro de uma transação**, e ele **carrega os dados do relacionamento**, mesmo sem acessar diretamente os dados.

### 🧩 Exemplo:

```java
@Transactional
public Estudante buscar(Long id) {
    Estudante estudante = repository.findById(id).orElseThrow();

    // Força o carregamento da coleção LAZY
    Hibernate.initialize(estudante.getLivros());

    return estudante;
}

```

Esse método garante que, quando o método terminar, os **livros já estão carregados**, e não vai haver erro se forem acessados depois (fora da transação).

---

## 📦 De onde vem?

`Hibernate.initialize()` faz parte da classe:

```java
org.hibernate.Hibernate

```

Então, você precisa importar:

```java
import org.hibernate.Hibernate;

```

---

## ⚠️ Quando usar (e quando evitar)

| Use quando... | Evite quando... |
| --- | --- |
| Precisa garantir o carregamento manual | Pode fazer `JOIN FETCH` direto na query |
| Está lidando com lógica condicional | Pode usar DTOs que evitam carregar entidades inteiras |
| Precisa preparar os dados antes de retornar da service | Quer manter consultas mais performáticas e específicas |

---

## ✅ Resumo rápido

| Item | Descrição |
| --- | --- |
| O que é | Método do Hibernate para inicializar atributos LAZY |
| Usado para | Evitar `LazyInitializationException` |
| Onde usar | Dentro de métodos `@Transactional` |
| Alternativas melhores | `JOIN FETCH`, DTOs, projections |

---


💡 Quando a gente tiver trabalhando com transações nós temos que usar essa anotação @Transactional 

### EXPLICAÇÃO DO MÉTODO

A anotação `@Transactional` do Spring é usada para **definir e controlar transações** no banco de dados. Ela garante que um **bloco de código seja executado como uma única transação atômica** — ou seja, **ou tudo é salvo com sucesso, ou nada é salvo (rollback em caso de erro).**

---

## ✅ Para que serve `@Transactional`?

### 🧠 Objetivo principal:

> Garantir consistência dos dados ao executar operações de leitura/escrita no banco.
> 

---

## 🔧 O que ela faz?

Quando você anota um método com `@Transactional`, o Spring:

1. **Inicia uma transação** antes de executar o método.
2. Se tudo der certo, faz **commit** ao final.
3. Se lançar uma exceção (por padrão, do tipo `RuntimeException`), faz **rollback** (desfaz tudo).

---

### 📌 Exemplo simples:

```java
@Service
public class ContaService {

    @Transactional
    public void transferir(Conta origem, Conta destino, BigDecimal valor) {
        origem.debitar(valor);
        destino.creditar(valor);
        // Se der erro aqui, a transação é desfeita automaticamente
    }
}

```

Se der erro após debitar da conta de origem, o valor não será perdido — tudo será revertido.

---

## ⚠️ Cuidados importantes:

| Situação | Efeito |
| --- | --- |
| `@Transactional` em método **privado** | **Não funciona** (precisa ser público) |
| Chamadas **internas** de métodos anotados | **Não aplicam transação** (precisa ser chamado externamente para o proxy funcionar) |
| Por padrão, só faz rollback em **RuntimeException** | Checked exceptions **não fazem rollback automaticamente** |

---

## 🛠️ Exemplos de uso avançado:

```java
@Transactional(readOnly = true) // Para consultas
public List<Pedido> listarPedidos() { ... }

@Transactional(timeout = 5) // Tempo máximo de execução
public void processarLento() { ... }

@Transactional(rollbackFor = Exception.class) // Inclui checked exceptions
public void processarComFalhaPossível() throws Exception { ... }

```

---

## ✅ Resumo rápido:

| O que faz? | Controla transações no banco de forma automática |
| --- | --- |
| Onde usar? | Em métodos `public` de `@Service` ou `@Repository` |
| Rollback automático? | Sim, para `RuntimeException`; pode configurar outros casos |
| Vantagem principal? | **Consistência dos dados e controle de falhas** |

---


---

### UTILIZANDO O CASCADE.PERSIST

🏆 Podemos observar que somente o nome mudou e o endereço continua o mesmo, mesmo eu alterando o valor do endereço.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/lazyEagerCascade3.png" />


### CASO EU QUERIA SOMENTE REALIZAR AS OPERAÇÕES DE PERSIST, MERGE E ALL.

```java
@OneToOne(cascade = CascadeType.PERSIST, Cascade.MERGE, Cascade.REMOVE) 
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
```