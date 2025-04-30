# 4 → PAGINAÇÃO

🏆 Vamos fazer um exemplo de paginação utilizando JPA

> É de certa forma bem simples
> 

---

### POR QUE UTILIZAR PAGINAÇÃO?

🏆 Imagina que temos uma tabela muito grande com milhões de linhas, é impossível trazer todas essas linhas em apenas uma consulta, para isso utilizamos a paginação para paginar essas consultas.


---

### 1. PRIMEIRO PASSO SERÁ CADASTRAR 10 ESTUDANTES NO POSTMAN PARA UTILIZAR O RECURDO DE PAGINAÇÃO.

> A partir da paginação eu posso escolher quantos itens vai ter em cada pagina
> 

### 2. VAMOS ALTERAR NOSSO CÓDIGO AGORA PARA ADQUIRIR O RECURSO DA PAGINAÇÃO

🏆 Precisamos dizer para o JPA qual é a pagina que a gente quer e a quantidade de itens em cada uma delas


1. Dentro do controller vamos alterar o método buscarTodosEstudantes()
2. Vamos começar criando duas variáveis do tipo INTEGER e passando elas como parâmetro do método
3. Vamos anotar essas váriaveis com a anotação @RequestParam
    1. Resumidamente, **@RequestParam** é uma anotação do Spring usada para **pegar valores passados na URL como parâmetros de consulta (query parameters)**.
    
    ### Exemplo:
    
    ```java
    @GetMapping("/saudacao")
    public String saudacao(@RequestParam String nome) {
        return "Olá, " + nome;
    }
    
    ```
    
    Se você acessar a URL:
    
    ```
    /saudacao?nome=Maria
    
    ```
    
    A resposta será:
    
    ```
    Olá, Maria
    
    ```
    
    Ou seja, `@RequestParam` extrai o valor de `nome` da URL.
    

🏆 A anotação **RequestParam** tem uma propriedade que é o valor default, caso o usuário não passe nenhum valor na URL.


1. No service precisamos fazer algumas alterações no método findAll também.

1 → Nosso método vai ter um PageRequest como parâmetro

🏆

O método **`PageRequest.of(pagina, itensPorPagina)`** é usado no Spring Data para **criar uma solicitação de páginação** ao buscar dados do banco de dados de forma paginada.

### Em resumo:

Ele define **qual página** você quer acessar e **quantos itens** devem vir por página.

---

### Parâmetros:

- `pagina`: o número da página que você quer (começa em **0**, não em 1).
- `itensPorPagina`: a quantidade de registros por página.

---

### Exemplo:

```java
PageRequest pageRequest = PageRequest.of(0, 10);

```

Isso significa:

- Buscar a **primeira página** (`0`)
- Com **10 registros** por página

---

### Uso comum:

```java
Page<Estudante> estudantes = estudanteRepository.findAll(PageRequest.of(0, 10));

```

Isso retorna um objeto `Page<Estudante>`, que contém:

- A lista de estudantes da página
- Total de páginas
- Total de elementos
- Número da página atual, etc.

2 → E também vai começar retornar um PAGE ao invés de um list

---

## REALIZANDO TESTES NO POSTAMAN

### PODEMOS NOTAR QUE A PAGINA VEIO ORDENADA EM 5 ITENS QUANDO NÃO PASSAMOS NADA NA URL

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pagina%C3%A7%C3%A3oJPA1.png" />

### AGORA PASSANDO PARÂMETROS

```xml
http://localhost:8080/estudantes?pagina=1&itensPorPagina=3
```

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pagina%C3%A7%C3%A3oJPA2.png" />



### DICA 🏆

Basta colocar o nome dos parâmetros do método no “queryParams” do postman

