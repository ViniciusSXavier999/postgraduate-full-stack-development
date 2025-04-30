# 2 → INTERFACE JPAREPOSITORY

### O QUE É O JPAREPOSITORY?

🏆 JPA REPOSITORY é particularmente uma extensão específica de JPA para repositórios.


🏆 Ele contém as APIS para operações básicas de CRUD, as APIS para paginação e as APIS para ordenação


> Todas as operações que a gente precisa para manipular os nossos dados e armazenar eles, o JPA REPOSITORY nos fornece
> 

🏆 Resumidamente, o repositório irá conter todos os métodos que irão nos permitir manipular os dados no nosso banco de dados.


---

### COMO UTILIZAR O JPAREPOSITORY?

🏆 Para utilizá-lo, devemos fazer a importação do repositório e usar o extends na classe para implementá-lo, como no exemplo abaixo.

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/interfaceJPARepository03.png" />

- No primeiro parâmetro a gente passa a entidade
- No segundo parâmetro a gente passa o tipo de ID da entidade

---

### O JPA REPOSITORY EXTENDS OUTRAS CLASSES NATURALMENTE

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/interfaceJPARepository01.png" />

🔒 Se você quiser criar só CRUD, você pode utilizar o repositório CRUD repository, caso queira criar tanto CRUD quanto page sort você utiliza o JPAREPOSITORY porque ele contém os dois.

---

### CONFIGURANDO O JPAREPOSITORY

ARQUIVO APPLICATION PROPERTIES

```java
spring.datasource.url=jdbc:mysql://localhost/db_apiposgraduacao?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false
spring.datasource.username=root
spring.datasource.password=soudev[
spring.datasource.initialization-mode=always 
spring.jpa.database=mysql

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```



### EXPLICAÇÃO DE CADA LINHA DO CÓDIGO 🔒

1. **`spring.datasource.url=...`**
    
    Define a URL de conexão com o banco de dados MySQL.
    
    - `localhost`: servidor local
    - `db_digitalmenu`: nome do banco
    - `createDatabaseIfNotExist=true`: cria o banco se não existir
    - `serverTimezone=America/Sao_Paulo`: define o fuso horário
    - `useSSL=false`: desativa o uso de SSL
2. **`spring.datasource.username=root`**
    
    Nome de usuário para conectar ao banco de dados (aqui, `root`).
    
3. **`spring.datasource.password=soudev`**
    
    Senha do usuário do banco de dados.
    
4. **`spring.jpa.hibernate.ddl-auto=update`**
    
    Diz ao Hibernate para atualizar automaticamente o esquema do banco com base nas entidades Java.
    
5. **`spring.jpa.database=mysql`**
    
    Informa que o banco de dados utilizado é MySQL.
    
6. **`spring.jpa.show-sql=true`**
    
    Faz com que as queries SQL geradas pelo JPA/Hibernate sejam exibidas no console.
    
7.  A propriedade **`spring.datasource.initialization-mode=always`** define quando o **Spring Boot** deve **executar scripts de inicialização SQL** (como `schema.sql` e `data.sql`) ao iniciar a aplicação.

### Valor `always`:

- **Sempre executa os scripts de inicialização**, **mesmo em produção**.
- Útil para **popular o banco com dados iniciais** ou **criar tabelas** automaticamente, independentemente do ambiente.

### Exemplo de uso:

Se você tem um `data.sql` com dados de exemplo, ele será executado toda vez que a aplicação subir, recriando esses dados (se as tabelas permitirem).


---

### VAMOS TESTAR AS FUNCIONALIDADES DA INTERFACE JPAREPOSITORY

### 1. PRIMEIRO VOU CRIAR UM PACKAGE CHAMADO ‘REPOSITORY’ E DENTRO DELE CRIAR UMA INTERFACE CHAMADA ‘ESTUDANTE REPOSITORY’

> Vai ser criado um repository aproveitando a entidade estudante que eu havia criado nas aulas anteriores
> 

### 2. ANOTAR A CLASSE COM A ANOTAÇÃO @REPOSITORY QUE INDICA PARA O SPRING GERENCIAR AQUELA CLASSE COMO UM REPOSITÓRIO

### 3. DAR UM EXTENDS NA INTERFACE JPAREPOSITORY E PREENCHER OS PARÂMETROS DE ACORDO COM A ENTIDADE UTILIZADA.



### O QUE SIGNFICA O EXTENDS? 🔒

Resumidamente, em Java, **`extends` em uma interface** serve para **herdar outra interface**.

### Exemplo simples:

```java
java
CopiarEditar
interface A {
    void metodoA();
}

interface B extends A {
    void metodoB();
}

```

### O que acontece:

- A interface `B` **herda os métodos da interface `A`**.
- Qualquer classe que implementar `B` também terá que implementar os métodos de `A`.

### Resumo:

> extends em uma interface permite herança múltipla de interfaces, para reutilizar contratos (métodos abstratos) sem precisar reescrevê-los.
> 

### 4. VAMOS CONFIGURAR A ENTIDADE ESTUDANTE COM AS ANOTAÇÕES NECESSÁRIAS

1. Primeiro vamos dizer ao spring que não é uma classe qualquer e que se trata de uma entidade, e para isso vamos anotar a classe com a anotação @Entity 

1. Precisamos dizer para o spring qual é a chave primária da nossa entidade, vamos utilizar a anotação @ID

1. Precisamos dizer também para ele como essa chave primária vai ser gerada e que o JPA fique responsável de fazer isso por mim: 	@GeneratedValue(strategy = GenerationType.IDENTITY)

🔒 Resumidamente, a anotação **`@GeneratedValue(strategy = GenerationType.IDENTITY)`** indica que o **banco de dados vai gerar automaticamente o valor da chave primária**, geralmente usando **auto-incremento**.

### Exemplo:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

```

### O que faz:

- Quando um novo registro é salvo, o **banco define o valor de `id` automaticamente**, sem precisar passar manualmente.

> Em resumo: define que o campo será auto-incrementado pelo banco de dados.
> 

### 5. PODEMOS OBSERVAR QUE DEU TUDO CERTO COM NOSSAS CONFIGURAÇÕES E O BANCO DE DADOS E A TABELA FOI CRIADA.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/interfaceJPARepository02.png" />

