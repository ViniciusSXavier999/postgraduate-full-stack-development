# 4 → MANY TO MANY COM ATRIBUTOS (EMBEDDABLE)

🏆 Este relacionamento é uma associação de muitos para muitos

🏆 A pode estar associada a muitas entidades B e uma entidade B também poder estar associada a várias entidades A.


⚠️ Na maioria dos relacionamentos ManyToMany a gente vai precisar criar uma terceira tabela, que será a tabela de conexão(@Embeddable).


🏆 A JPA fornece a anotação @Embeddable para declarar que uma classe será incorporada por outras entidades.

A anotação `@Embeddable` é usada em Java, especificamente na **Java Persistence API (JPA)**, para indicar que uma classe pode ser **incorporada (embutida)** em outra entidade como parte do seu mapeamento para o banco de dados.

### Resumo:

- `@Embeddable` é usada para **marcar uma classe como componente**.
- Ela **não representa uma entidade independente** no banco de dados.
- É usada em conjunto com a anotação `@Embedded` dentro de uma entidade JPA.

### Exemplo simples:

```java
@Embeddable
public class Endereco {
    private String rua;
    private String cidade;
    private String cep;
}

@Entity
public class Cliente {
    @Id
    private Long id;

    @Embedded
    private Endereco endereco;
}

```

Nesse exemplo:

- A classe `Endereco` é marcada com `@Embeddable`.
- Ela é usada dentro da entidade `Cliente`, com a anotação `@Embedded`.
- Os campos de `Endereco` serão **mapeados como colunas da tabela `Cliente`**, e não em uma tabela separada.

🏆 Observe no exemplo que será feito o mapeamento dos campos para uma nova entidade.



### MAIS EXEMPLOS DO USO DE EMBEDDABLE

---

### 🧩 O que é `@Embeddable`?

`@Embeddable` é usada para criar **classes incorporáveis** (embedded) — ou seja, **classes cujos atributos podem ser incluídos em outras entidades JPA**, sem precisarem ser entidades separadas com seu próprio `@Id`.

---

## ✅ Exemplo simples de uso

### 1. Classe Embeddable

```java
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String cidade;
    private String cep;

    // Getters e Setters
}

```

Essa classe **não é uma entidade**. Ela será **incorporada** em outra entidade.

---

### 2. Classe Entity usando `@Embedded`

```java
import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Endereco endereco;

    // Getters e Setters
}

```

---

### 🧪 Exemplo de uso no código:

```java
Cliente cliente = new Cliente();
cliente.setNome("João");

Endereco endereco = new Endereco();
endereco.setRua("Rua A");
endereco.setCidade("São Paulo");
endereco.setCep("01000-000");

cliente.setEndereco(endereco);

entityManager.persist(cliente);

```

---

### 🧾 Resultado no banco de dados:

A tabela `Cliente` terá colunas:

```
id | nome  | rua   | cidade     | cep
-----------------------------------------
1  | João  | Rua A | São Paulo  | 01000-000

```

> Os atributos de Endereco são "embutidos" como colunas da tabela Cliente.
> 

---

Se quiser, posso mostrar também como personalizar os nomes das colunas com `@AttributeOverrides`. Deseja isso?

## EXEMPLO:

🏆 No exemplo abaixo, podemos dizer que um estudante pode avaliar vários cursos e que vários cursos podem ser avaliados por vários estudantes

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manyToMany1.png" />


---

### INICIANDO A PRÁTICA

💡 Antes vamos alterar algumas coisas no código da aula passada 

- Adicionar a anotação @Jsonignore no atributo estudante da entidade livro
- Adicionando um loop for no service de atualizar estudante para associar o livro para seu respectivo estudante

```java
	for(Livro livro: estudante.getLivros()) {
				livro.setEstudante(estudante);
			}
```

### EXPLICANDO O CÓDIGO DETALHADAMENTE

```java
for (Livro livro : estudante.getLivros()) {
    livro.setEstudante(estudante);
}

```

### ✅ **Resumo do que ele faz:**

Esse `for` percorre todos os **livros associados a um estudante**, e para **cada livro**, ele **define o próprio estudante como dono** (ou associado) desse livro.

### 📌 Contexto típico:

Esse padrão é comum em aplicações que usam **JPA/Hibernate**, quando temos um relacionamento **bidirecional** entre entidades, por exemplo:

- Um **Estudante** tem vários **Livros** (`@OneToMany`)
- Cada **Livro** pertence a um **Estudante** (`@ManyToOne`)

Para manter a **consistência do relacionamento dos dois lados**, precisamos garantir que cada `Livro` também "conheça" o `Estudante` ao qual pertence.

### 🧠 Por que isso é importante?

O JPA **não sincroniza automaticamente os dois lados do relacionamento**. Então, se você faz só:

```java
estudante.getLivros().add(livro);

```

O `livro` não sabe que pertence ao `estudante`, e isso pode causar inconsistências no banco ao salvar.

### ✅ Esse loop garante:

- `livro.getEstudante()` vai retornar o `estudante` correto.
- O relacionamento estará **totalmente sincronizado** e pronto para ser persistido com JPA.

Se quiser, posso mostrar o modelo completo com JPA para ilustrar melhor.


💡 - E também agora é possível cadastrar um estudante sem nenhum livro

```java
	private Set<Livro> livros = new HashSet<>();
```



### INICIANDO A PRÁTICA DA AULA ATUAL

### 1. VAMOS COMEÇAR CRIANDO UMA NOVA ENTIDADE CHAMADA “AVALIAÇÃOCURSO”

> Essa vai ser a entidade de conexão
> 

> Vamos colocar as anotações necessárias
> 

### 2. DENTRO DESSA TABELA DE CONEXÃO, VAMOS CRIAR UM ESTUDANTE E UM CURSO E UM ATRIBUTO ESPECIFICO DESSA CLASSE.

> Vamos anotar o atributo da classe Estudante com a anotação @ManyToOne
> 

### A Classe esta assim por enquanto

```java
	
	@ManyToOne
	@MapsId("estudanteId") // faz referencia ao id do estudante
	@JoinColumn(name = "estudante_id")
	private Estudante estudante;
	
	@ManyToOne
	@MapsId("cursoId") // faz referencia ao id do curso
	@JoinColumn(name = "curso_id")
	private Curso curso;
```

### 3. VAMOS CRIAR MAIS UMA CLASSE CHAMADA AVALIACAOCURSOKEY

> Nessa classe vamos fazer referência aos IDS de estudante e curso
> 

> O nome tem que ser o mesmo que eu passei na minha classe AvaliacaoCurso
> 

> Essa classe vai ser a chave primária da minha classe AvaliacaoCurso
> 

```java
@Embeddable
public class AvaliacaoCursoKey implements Serializable{
	
	private static final long serialVesionUID = 1L;
	
	@Column(name = "estudante_id")
	Long estudanteId;
	
	@Column(name = "curso_id")
	Long cursoId;

}

```

### 4. EM SEGUIDA, VAMOS ADICIONAR AVALIACAOCURSOS NA CLASSE ESTUDANTE (VAMOS FAZER O RELACIONAMENTO DE ESTUDANTE COM A TABELA DE CONEXÃO)

```java
	@OneToMany(mappedBy = "estudante")
	private Set<AvaliacaoCurso> avaliacaoCursos;
```

---

## DÚVIDAS

### O QUE É @MAPSID?

💡  A anotação `@MapsId` é usada para **mapear uma chave primária composta (composite key)**, especialmente quando **uma entidade compartilha sua chave primária com outra** (por exemplo, em relacionamentos `@OneToOne` ou `@ManyToOne` onde a FK também é a PK).

---

## 📌 O que é `@MapsId`?

`@MapsId` é uma anotação do JPA usada para **informar que o identificador da entidade atual é mapeado por um atributo de relacionamento** (normalmente uma entidade pai). Ela é útil para casos em que a chave primária é derivada de outra entidade.

---

### ✅ Exemplo prático:

Imagine duas entidades: `User` e `UserProfile`. Cada `UserProfile` pertence a exatamente um `User`, e o `id` do `UserProfile` **é o mesmo** que o `id` do `User`.

```java
@Entity
public class User {
    @Id
    private Long id;

    private String name;

    // getters e setters
}

```

```java
@Entity
public class UserProfile {

    @Id
    private Long id;

    @OneToOne
    @MapsId // Diz que o id do UserProfile é o mesmo do User
    @JoinColumn(name = "id")
    private User user;

    private String bio;

    // getters e setters
}

```

---

### 🔍 O que isso faz?

- `@MapsId` diz ao JPA que o campo `user` deve fornecer o valor para o campo `id` da entidade `UserProfile`.
- Ou seja, o `UserProfile` não tem seu próprio ID; ele **reutiliza o ID do `User`**.

---

### 🧠 Quando usar?

Use `@MapsId` quando:

- Você tem uma entidade dependente que **compartilha a chave primária com uma entidade "dona"**.
- Está modelando **relacionamentos fortes**, como composição ou entidades dependentes com o mesmo ID.

---


### O QUE É EMBEDDEDID?

💡 No **Java com JPA/Hibernate**, a anotação `@EmbeddedId` é usada para mapear **chaves primárias compostas** (ou seja, compostas por mais de um campo) em uma entidade.

---

## 📌 O que é `@EmbeddedId`?

`@EmbeddedId` é usada quando você deseja definir uma **chave primária composta como um objeto embutido (embeddable)**. Esse objeto deve ser anotado com `@Embeddable` e conter os campos que compõem a chave primária.

---

### ✅ Exemplo prático:

### 1. Criando a chave primária composta com `@Embeddable`:

```java
@Embeddable
public class OrderItemId implements Serializable {

    private Long orderId;
    private Long productId;

    // Construtores, getters, setters, equals() e hashCode()
}

```

### 2. Usando `@EmbeddedId` na entidade principal:

```java
@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;

    // Relacionamentos (opcional), getters e setters
}

```

---

### 🔍 O que acontece aqui?

- `OrderItem` possui uma chave composta por `orderId` e `productId`.
- Esses dois campos estão encapsulados dentro de uma classe `OrderItemId`, que é marcada com `@Embeddable`.
- `@EmbeddedId` diz ao JPA para usar esse objeto como chave primária da entidade.

---

## 🆚 Diferença entre `@EmbeddedId` e `@IdClass`

- `@EmbeddedId`:
    - Usa **um único campo objeto** como chave primária.
    - Mais orientado a objetos, mais limpo.
- `@IdClass`:
    - Define os campos da PK **diretamente na entidade**, e a classe separada serve apenas como "descrição".
    - É mais antigo e menos usado atualmente.

---


### DIFERENÇA DE MAPSID PARA EMBEDDEDID

💡  Tanto `@MapsId` quanto `@EmbeddedId` são usados para trabalhar com **chaves primárias compostas** no JPA, mas eles têm propósitos diferentes e funcionam de maneiras distintas.

Vamos comparar de forma clara:

---

## 🔹 `@EmbeddedId`

### ✅ Quando usar:

Quando você quer **modelar uma chave primária composta** como um **objeto embutido** (com `@Embeddable`), que representa **apenas a chave primária da entidade**.

### 🔧 Como funciona:

- A classe `@Embeddable` define os campos da chave composta.
- A entidade usa `@EmbeddedId` para incluir esse objeto como chave primária.
- Ideal para **entidades com chaves compostas que não são baseadas em relacionamentos fortes**.

### 🧩 Exemplo:

```java
@Embeddable
public class OrderItemId implements Serializable {
    private Long orderId;
    private Long productId;
}

@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;
}

```

---

## 🔹 `@MapsId`

### ✅ Quando usar:

Quando você tem uma entidade que **compartilha a chave primária com outra entidade relacionada** (geralmente em `@OneToOne` ou `@ManyToOne`), e você quer mapear esse relacionamento como a **própria chave primária**.

### 🔧 Como funciona:

- A chave primária vem de outra entidade relacionada.
- A entidade dependente **não tem seu próprio ID**; ela **reutiliza** o ID da entidade associada.
- Usa `@MapsId` junto com `@Id` ou `@EmbeddedId`.

### 🧩 Exemplo:

```java
@Entity
public class User {
    @Id
    private Long id;
}

@Entity
public class UserProfile {
    @Id
    private Long id;

    @OneToOne
    @MapsId // Usa o ID do User como chave primária
    @JoinColumn(name = "id")
    private User user;
}

```

---

## 📊 Resumo da diferença:

| Característica | `@EmbeddedId` | `@MapsId` |
| --- | --- | --- |
| Propósito | Chave composta com campos próprios | Compartilhar ID com outra entidade |
| Classe auxiliar | `@Embeddable` | Opcional (`@Embeddable` só se usar `@EmbeddedId`) |
| Baseada em relacionamento | ❌ Não necessariamente | ✅ Sim (precisa de um relacionamento) |
| Onde está o ID | Em um objeto embutido | Em uma entidade relacionada |
| Exemplo típico | Tabelas com chave composta simples | Entidades com dependência forte (composição) |

---

