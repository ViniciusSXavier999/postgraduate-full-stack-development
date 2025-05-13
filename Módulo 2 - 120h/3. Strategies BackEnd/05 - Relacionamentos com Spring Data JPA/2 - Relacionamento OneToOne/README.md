# 2 → RELACIONAMENTO ONE TO ONE

🏆 Qualquer aplicação, em algum momento, vai precisar de um relacionamento entre entidades.


🏆 Entender os relacionamentos e as operações realizadas é essencial para modelar o esquema de dados


### RELACIONAMENTOS E SUAS ANOTAÇÕES

🏆 Nos relacionamentos, também utilizamos anotações para referenciar cada tipo


🏆 Essas anotações representam abstrações de relacionamentos criados no nosso banco de dados:

- @OneToOne
- @OneToMany
- @ManyToOne
- @ManyToMany

---

### RELACIONAMENTO ONE TO ONE

🏆 @OneToOne: É um relacionamento um para um que define que só há uma entidade relacionada com a outra


### EXEMPLO:

🏆 Um exemplo desse tipo de relacionamento pode ser facilmente entendido entre uma entidade estudante e endereço. Um estudante só pode ter um endereço!

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/relacionamentoOneToOne1.png" />

🔒 Tudo depende da regra de negócio também, pode ter outros casos que um estudante pode ter vários endereços, sendo assim não seria mais @OneToOne 

🔒 Esse tipo de relacionamento é muito utilizado quando você não quer manter uma enorme quantidade de dados em uma única tabela, você quer dividir esses dados em mais de uma tabela



---

### AGORA VAMOS PRATICAR, CONSTRUIREMOS UM EXEMPLO @ONETOONE COM SPRING DATA JPA

### 1. VAMOS ATUALIZAR A CLASSE CURSO COM O ATRIBUTO NOME.

### INICIANDO COM O USO DO RELACIONAMENTO @ONETOONE

### 2. EU QUERO QUE UM ESTUDANTE TENHA UM ENDEREÇO E VICE VERSA.

🏆

### NA CLASSE ENDEREÇO VOU CRIAR A SEGUINTE VARIÁVEL

> Vamos usar a anotação @OneToOne
> 

```java
@OneToOne
@OneToOne(mappedBy = "endereco")
private Estudante estudante;
```

### O QUE É @OneToOne(mappedBy = "endereco")?

A linha `@OneToOne(mappedBy = "endereco")` é usada em um relacionamento bidirecional no JPA para indicar que **esta entidade não é a dona do relacionamento**.

### Explicação resumida:

- `@OneToOne`: indica um relacionamento **um-para-um**.
- `mappedBy = "endereco"`: diz que o **controle do relacionamento está na outra entidade**, na propriedade chamada `"endereco"`.

### Exemplo:

Se você tem duas entidades, `Pessoa` e `Endereco`, e na classe `Pessoa` você colocou:

```java
@OneToOne
@JoinColumn(name = "endereco_id")
private Endereco endereco;

```

Então na classe `Endereco` você coloca:

```java
@OneToOne(mappedBy = "endereco")
private Pessoa pessoa;

```

Isso evita que o JPA crie duas colunas de chave estrangeira e entende que só `Pessoa` deve gerenciar a relação no banco.

Se quiser, posso mostrar um exemplo completo das duas classes.

🏆

### NA CLASSE ESTUDANTE VOU CRIAR A SEGUINTE VARIÁVEL

> Vamos usar a anotação @OneToOne
> 

```java

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "endereco_id", referencedColumnName = "id")
private Endereco endereco;
```

### O QUE É ESSE cascade = CascadeType.ALL?

A linha `@OneToOne(cascade = CascadeType.ALL)` é uma anotação do **JPA (Java Persistence API)** usada em classes de entidade para mapear um relacionamento **um-para-um** entre duas entidades no banco de dados.

### Explicação resumida:

- `cascade = CascadeType.ALL`: significa que **todas as operações** (como persistir, atualizar, remover) feitas na entidade principal também serão **cascateadas** para a entidade relacionada.

### Exemplo prático:

Se você tiver uma entidade `Pessoa` com um relacionamento `@OneToOne` com `Endereco`, e usar `CascadeType.ALL`, ao salvar ou deletar uma `Pessoa`, o `Endereco` associado será automaticamente salvo ou deletado junto.


🏆 @JoinColumn(name = "endereco_id", referencedColumnName = "id") 

A linha `@JoinColumn(name = "endereco_id", referencedColumnName = "id")` é usada com anotações de relacionamento no JPA para **configurar a chave estrangeira** no banco de dados.

### Explicação resumida:

- `@JoinColumn`: define a **coluna que faz a junção** entre duas tabelas (chave estrangeira).
- `name = "endereco_id"`: é o **nome da coluna** na tabela atual que armazenará a chave estrangeira.
- `referencedColumnName = "id"`: indica que essa chave estrangeira **faz referência à coluna `id`** da tabela relacionada (geralmente a chave primária da outra entidade).

### Exemplo:

Se uma entidade `Pessoa` tem um `@OneToOne` com `Endereco`, essa anotação vai criar a coluna `endereco_id` na tabela `pessoa`, apontando para o `id` da tabela `endereco`.


---

### AGORA VAMOS REALIZAR OS TESTES NO POSTMAN

### 1. PRIMEIRO VAMOS CADASTRAR OS NOSSOS DOIS OBJETOS

```xml
{
    "nome": "Castiel",
    "email": "dean@gmail.com",
    "dataNascimento": "2006-01-09",
    "endereco": {
        "logradouro": "Nome rua",
         "bairro": "Cachoeirinha",
          "cidade": "SP",
           "cep": "123-123"
    }
}
```

🏆 Deu tudo certo ✅

