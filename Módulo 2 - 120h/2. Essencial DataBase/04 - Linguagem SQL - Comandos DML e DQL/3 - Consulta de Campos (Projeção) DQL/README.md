# 3 → CONSULTA DE CAMPOS (PROJEÇÃO) INICIO DQL

## O QUE É DQL ?

🏆 

A Data Query Language ( **Linguagem de consulta de dados** ), ou DQL, ***é o grupo de comandos responsáveis por consultar os dados de um banco de dados***


---

## EXISTE ALGUNS TIPOS DE CONSULTAS

### RECURSOS DAS INSTRUÇÕES SELECT SQL

### SELEÇÃO

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL1.png" />

🏆 É quando a gente consulta alguns registros da tabela

### PROJEÇÃO

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL2.png" />

🏆

O recurso de **projeção** nas instruções `SELECT` do SQL refere-se à capacidade de selecionar **colunas específicas** de uma tabela em uma consulta, em vez de retornar todos os dados disponíveis. Isso permite que você refine os resultados da sua consulta para incluir apenas as informações necessárias.

### Exemplo de Projeção:

Se temos uma tabela `clientes` com as seguintes colunas:

| id | nome | idade | cidade |
| --- | --- | --- | --- |
| 1 | João | 30 | São Paulo |
| 2 | Maria | 25 | Rio de Janeiro |
| 3 | Carlos | 40 | Belo Horizonte |

### 1. Projeção de todas as colunas:

```sql
SELECT * FROM clientes;

```

- Retorna **todas as colunas** da tabela.

### 2. Projeção de colunas específicas:

```sql
SELECT nome, idade FROM clientes;

```

- Retorna apenas as colunas `nome` e `idade`.

| nome | idade |
| --- | --- |
| João | 30 |
| Maria | 25 |
| Carlos | 40 |

A projeção é útil para **otimizar consultas**, **reduzir o tráfego de dados** e **facilitar a análise**, garantindo que apenas as informações relevantes sejam recuperadas.

Quer mais detalhes sobre como melhorar consultas SQL?


### JUNÇÃO

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL3.png" />

🏆 Quando a gente consulta duas ou mais tabelas no mesmo comando, seja qual for o tipo, todos esses são exemplos de CONSULTAS, tudo se enquadra na categoria de comandos DQL


---

### INSTRUÇÃO SELECT BÁSICA

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL4.png" />

🏆 SELECT → A gente vai listar os campos que a gente quer selecionar da tabela e a partir da clausula FROM a gente identifica qual tabela queremos selecionar

* → É quando queremos selecionar todas as colunas de uma tabela

> Também podemos conceder apelidos as colunas
> 

💡
- SELECT IDENTIFICA QUE COLUNAS
- FROM IDENTIFICA QUAL TABELA

---

## PRATICANDO!!!

### VAMOS INICIAR FAZENDO UM SELECT COMPLETO, EU QUERO VER TODAS AS COLUNAS

```sql
SELECT * FROM SCOTT.EMP;
```

> EMP é uma tabela do usuário SCOTT
> 

💡 através do * a gente disse que queria acessar todos os campos da tabela com todos os registros


### SELECIONANDO CAMPOS ESPECIFICOS DA TABELA

```sql
SELECT ENAME, SAL FROM SCOTT.EMP
```

### CONCEDENDO APELIDO AOS CAMPOS

```sql
SELECT ENAME NOME, SAL "SALARIO DO FUNC", JOB AS "CARGO DO FUNC" FROM SCOTT.EMP
```

> Isso é bastante útil porque o usuário que vai receber esse relatório não é obrigado a saber o que significa o campo ENAME ou o que significa o campo SAL, a gente pode melhorar a leitura do relatório, deixando ele mais legível com o uso de apelidos
> 

💡 Quando temos apelidos com espaço em branco, chamamos de apelido COMPOSTO e ele deve obrigatoriamente estar entre “” (aspas duplas)


💡 PODEMOS também conceder apelidos através da palavra AS 


  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL5.png" />

### OUTRAS OPERAÇÕES QUE PODEMOS REALIZAR É AS OPERAÇÕES ARITMÉTICAS

```sql
SELECT ENAME, SAL, SAL * 12 "SALARIO ANUAL" FROM SCOTT.EMP
```

> Estamos realizando uma operação que mostra o salário anual e apelidando o campo de “SALARIO ANUAL”
> 

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL6.png" />

### TAMBÉM É POSSÍVEL FAZER EXPRESSÕES ARITMÉTICAS (É QUANDO REALIZAMOS MAIS DE UMA OPERAÇÃO NO MESMO SELECT)

> Nesse exemplo vamos simular o aumento de 10% para cada funcionário
> 

```sql
SELECT ENAME, SAL, SAL * 10/100 "AUMENTO DE 10%", SAL + (SAL*10/100) "SALARIO COM AUMENTO DE 10%" FROM SCOTT.EMP
```

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL7.png" />

### TAMBÉM PODEMOS REALIZAR A OPERAÇÃO DE CONCATENAÇÃO, ELA VAI JUNTAR O CONTEÚDO DE DOIS CAMPOS

```sql
SELECT ENAME, JOB, ENAME || JOB "NOME & CARGO" FROM SCOTT.EMP
```

```sql
SELECT ENAME, JOB, ENAME || ' TEM O CARGO DE ' || JOB "FUNCIONARIOS E CARGOS" FROM SCOTT.EMP
```

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inicioDQL8.png" />

💡 O SIMBOLO DA CONCATENAÇÃO SÃO DOIS PIPELINES → ||


💡 O MELHOR USO DA CONCATENAÇÃO SE APLICA QUANDO CONCATENAMOS CAMPO + LITERAL + CAMPO

> LITERAL É UM CONJUNTO DE CARACTERES
> 

🚨 A única coisa que tem aspas duplas são apelidos, se não for apelidos utilizar aspas simples


### CASO A GENTE QUEIRA GERAR UMA CONSULTA QUE MOSTRE O CARGO DOS FUNCIONARIOS, MAS QUE NÃO TENHA REPETIÇÕES

```sql
SELECT DISTINCT JOB FROM SCOTT.EMP
```


🚨 Isso só é possível por conta do DISTINCT (**DISTINTO**).
