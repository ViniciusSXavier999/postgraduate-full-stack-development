# 3 → RELACIONAMENTOS MANY TO ONE E ONE TO MANY

🏆 Os relacionamentos @ManyToOne e @OneToMany seguem a mesma lógica. São relacionamentos onde uma entidade é referenciada com outra entidade que contém valores únicos.


⚠️ No vídeo anterior, um estudante só podia ter um endereço. Agora um estudante pode ter vários livros e isso muda o tipo de relacionamento.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/OneToManyAndManyToOne1.png" />

> 1 estudante pode ter vários livros
> 

> 1 livro deve estar associado apenas à 1 estudante
> 

### OUTROS EXEMPLOS

### VENDA E PRODUTOS

🏆 Quando você realiza uma compra, você organiza um carrinho com 1 ou vários itens, e esses itens são únicos, eles tem um código de barra único.

> Uma venda está associada a vários produtos, e um produto está associado a uma venda.
> 

### AUTOR E LIVROS

🏆 Um autor ele tem vários livros, mas um livro esta associado a um autor


### CIDADES E BAIRROS


🏆 Uma cidade tem vários bairros, mas um bairro só pode estar associado a uma cidade.


---

### HORA DE PRATICAR!

### 1. PRIMEIRO DE TUDO VAMOS CONFIGURAR LIVROS NA CLASSE ESTUDANTE

```java
  @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Livro> livros;
```

🏆

- ONE -> se refere a estudante.
- MANY -> se refere a livros



### EXPLICAÇÃO DO CÓDIGO 🏆

```java
@OneToMany(
    mappedBy = "estudante",
    cascade = CascadeType.ALL,
    orphanRemoval = true
)

```

### Resumo:

- **@OneToMany**: Indica que um objeto da classe atual (por exemplo, `Aluno`) está relacionado a **muitos** objetos de outra classe (como `Disciplina`, por exemplo).
- **mappedBy = "estudante"**: O atributo `estudante` está na outra classe (a classe "muitos") e é o lado **dono** do relacionamento. Isso evita a criação de uma tabela intermediária.
- **cascade = CascadeType.ALL**: Todas as operações (persistir, atualizar, deletar, etc.) feitas no objeto pai serão **propagadas** para os filhos.
- **orphanRemoval = true**: Se um filho for **removido da coleção** no objeto pai, ele também será **removido do banco de dados**.

### Exemplo simples:

Se um `Aluno` tem uma lista de `Disciplinas`, ao deletar o aluno, todas as disciplinas associadas também serão deletadas automaticamente (por causa do cascade e orphanRemoval).




### EXEMPLO PARA ENTENDER MELHOR 🏆

No exemplo de **aluno e livros**, a relação é de **um para muitos**: **um aluno pode ter muitos livros**.

### Então:

- **"ONE"**: é o **Aluno** (um único aluno)
- **"MANY"**: são os **Livros** (vários livros pertencem a um aluno)

---

### Representação:

```java
// Classe Aluno (ONE)
@Entity
public class Aluno {

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livro> livros;

    // getters, setters, etc.
}

```

```java
// Classe Livro (MANY)
@Entity
public class Livro {

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    // getters, setters, etc.
}

```

### Resumo visual:

```
Aluno (ONE) --------< Livro (MANY)

```


### 2. AGORA VAMOS CONFIGURAR A CLASSE LIVRO

```java
  @ManyToOne
	@JoinColumn(name = "estudante_id", nullable = false)
	private Estudante estudante;
```

🏆 Como lá utilizamos @OneToMany, agora vamos utilizar @ManyToOne 


### EXPLICAÇÃO DO CÓDIGO 🏆

### Explicação resumida:

```java
@ManyToOne
@JoinColumn(name = "estudante_id", nullable = false)
private Estudante estudante;

```

- **@ManyToOne**: Indica que **muitos objetos** dessa entidade (ex: muitos livros, notas, matrículas, etc.) estão relacionados a **um único estudante**.
- **@JoinColumn(name = "estudante_id")**: Define o nome da **coluna estrangeira** no banco de dados que faz o link com a tabela `Estudante`.
- **nullable = false**: Essa coluna **não pode ser nula**, ou seja, cada objeto dessa entidade **deve obrigatoriamente estar associado a um estudante**.

---

### Exemplo de onde isso pode aparecer:

Na classe `Livro`, indicando que cada livro pertence a um estudante:

```java
@Entity
public class Livro {

    @ManyToOne
    @JoinColumn(name = "estudante_id", nullable = false)
    private Estudante estudante;

    // outros atributos...
}

```

### Resumo visual:

```
Vários Livros → 1 Estudante
```

Cada instância da classe `Livro` deve estar vinculada a **um único estudante** por meio da chave estrangeira `estudante_id`.




### DÚVIDA SOBRE QUAL O LUGAR CORRETO PARA UTILIZAR O JOINCOLUM 🚨

Boa pergunta! **Não, você não deve colocar `@JoinColumn` na classe `Estudante` nesse tipo de relacionamento.**

### Por quê?

A anotação `@JoinColumn` deve ser usada **apenas no lado que contém a chave estrangeira**, ou seja, o **lado "MANY"** da relação `@ManyToOne`.

---

### Explicando melhor com o exemplo:

### 1. Lado "MANY" (classe `Livro`):

Aqui sim vai a `@JoinColumn`, porque cada livro pertence a um estudante, e é nessa tabela (`livro`) que a coluna `estudante_id` será criada.

```java
@ManyToOne
@JoinColumn(name = "estudante_id", nullable = false)
private Estudante estudante;

```

### 2. Lado "ONE" (classe `Estudante`):

Aqui usamos apenas o `@OneToMany`, e indicamos o `mappedBy` para apontar para o atributo na classe `Livro`. **Não usamos `@JoinColumn` aqui.**

```java
@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Livro> livros;

```

---

### Resumo:

| Local | Anotação usada | Motivo |
| --- | --- | --- |
| Classe `Livro` (MANY) | `@ManyToOne + @JoinColumn` | É onde a coluna estrangeira `estudante_id` será criada |
| Classe `Estudante` (ONE) | `@OneToMany(mappedBy = "...")` | Relaciona-se com vários livros, mas não tem a FK direto |

Se colocar `@JoinColumn` do lado errado (no `@OneToMany`), o JPA pode tentar criar uma tabela extra ou lançar erro de mapeamento.


---

### REALIZANDO TESTES

### 1. VAMOS TENTAR CADASTRAR UM ESTUDANTE

🚨 Vai dar erro, será necessário alterar o código de EstudanteService, eu estou tentando cadastrar um estudante, e esse estudante tem um id próprio, e eu estou tentando salvar os livros com o id do estudante null


### ERRO DE LOOP INFINITO NO JSON DE LIVRO

🚨 Ao tentar cadastrar um livro junto a um estudante, eu estava enfrentando esse loop infinito retornado pelo postman, a solução foi utilizar duas anotações que resolveram esse problema: 

- @JsonManagedReference
- @JsonBackReference

### EXPLICANDO ESSAS ANOTAÇÕES DETALHADAMENTE

Explicação **resumida e direta** das anotações `@JsonManagedReference` e `@JsonBackReference`:

---

### 🔁 Problema que elas resolvem:

Quando você tem um relacionamento **bidirecional** entre duas entidades (ex: `Estudante` → `Livro` → `Estudante`), o Jackson (biblioteca que gera o JSON) pode entrar em **loop infinito** tentando serializar tudo de volta e pra frente.

---

## ✅ `@JsonManagedReference`

- **Usada no lado "pai"** do relacionamento (ex: `Estudante`).
- Indica que **esse lado será serializado normalmente** no JSON.

```java
@JsonManagedReference
private Set<Livro> livros;

```

---

## ✅ `@JsonBackReference`

- **Usada no lado "filho"** (ex: `Livro`).
- Indica que **esse lado será ignorado** na hora de gerar o JSON, evitando a recursão.

```java
@JsonBackReference
private Estudante estudante;

```

---

## 📌 Resumo visual:

```java
// Classe Estudante
@OneToMany(mappedBy = "estudante")
@JsonManagedReference
private Set<Livro> livros;

// Classe Livro
@ManyToOne
@JsonBackReference
private Estudante estudante;

```

### 🔒 Resultado:

- O JSON de `Estudante` **mostra os livros**.
- O JSON de cada `Livro` **não mostra o estudante** → evita loop.

---

