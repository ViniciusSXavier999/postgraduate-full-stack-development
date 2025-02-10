# 2 → PRÁTICA PARA CRIAÇÃO DE TABELAS

🚨 A linguagem SQL é composta por categorias de comandos

- DDL
- DML
- DCL
- DQL
- TCL

🏆 Nessa Aula vamos trabalhar com os comandos DDL → Data Definition Language (**Linguagem de definição de dados**), ELES PERMITEM:

- Criação das estruturas
- Alteração das estruturas
- Exclusão das estruturas

> Nessa aula vamos falar sobre a criação de tabelas
> 

---

## CATEGORIAS DE COMANDOS DA LINGUAGEM SQL

🏆 Para criar as tabelas a gente precisa respeitar as características, as regras de nomenclatura que todo SGBD tem.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o1.png" />


---

## CRIANDO INSTRUÇÕES SQL

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o2.png" />

> Tanto faz maiúscula e minúsculas.
> 

> Os comandos não podem ser abreviados exemplo do create: CRIA.
>

## CRIAÇÃO DE TABELAS - REGRAS DE NOMENCLATURA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o3.png" />

> Palavra reservadas são as palavras especificas da linguagem SQL, exemplo: SELECT, CREATE
> 

---

## A INSTRUÇÃO CREATE TABLE

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o4.png" />

> Todos os comandos da linguagem SQL devem terminar com ;
>

## TIPOS DE DADOS 


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o5.png" />



> O 2 que esta no ‘VARCHAR2’ significa que ele dobra a quantidade de armazenamento, se o VARCHAR armazena 2 mil, o VARCHAR2 armazena 4 mil
> 

> O tipo NUMBER é para armazenar números, o ‘p’ entre parênteses significa PRECISÃO e o ‘s’ a ESCALA, exemplo:
> 

🏆 O tipo de dado **`NUMBER(p, s)`** no Oracle SQL é utilizado para armazenar números, onde:

- **`p` (precisão)**: define o número total de dígitos que o número pode ter, tanto à esquerda quanto à direita da vírgula decimal. A precisão pode variar de 1 até 38.
- **`s` (escala)**: define o número de dígitos à direita da vírgula decimal. A escala pode ser um número entre 0 e `p`. Ou seja, a escala não pode ser maior que a precisão.

### Exemplos de `NUMBER(p, s)`:

- **`NUMBER(5, 2)`**: Isso significa que o número pode ter até 5 dígitos no total, e até 2 desses dígitos podem estar à direita da vírgula decimal. Exemplo de valores possíveis: `123.45`, `99.99`, `10000` (sem vírgula decimal).
- **`NUMBER(8, 3)`**: Nesse caso, o número pode ter até 8 dígitos no total, com até 3 dígitos após a vírgula decimal. Exemplos de valores válidos: `1234.567`, `98765.432`.

### Considerações:

- Se o valor inserido tiver mais dígitos à direita da vírgula decimal do que a escala definida, o Oracle arredondará o valor.
- Se a escala for 0, significa que o número será tratado como um número inteiro.
- Se o valor de `s` for omitido, a escala será considerada 0 por padrão.

Por exemplo:

- **`NUMBER(10)`** significa que o número pode ter até 10 dígitos no total e nenhum dígito decimal (escala = 0).
- **`NUMBER(10, 2)`** pode armazenar um número com até 10 dígitos, dos quais 2 podem ser após a vírgula decimal.

Se tiver mais alguma dúvida sobre como usar esse tipo ou se precisar de exemplos práticos, é só perguntar!


> O campo CLOB, o C é de caractere e o LOB é de objeto grande de caractere, um objeto grande tem o tamanho de até 4 gigas, caso isso aconteça utilizar o CLOB
> 

> BLOB → SERVE para armazenar um vídeo, um áudio que vai ter tamanho até 4 gigas
> 

---

---

---

## PRATICANDO NO ORACLE LIVE

### Criando tabela

```sql
create table aluno (
ra number(5),
nome varchar(100),
data_matricula date
);
```

### Comando para mostrar a tabela

```sql
describre
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/pratica_cria%C3%A7%C3%A3o6.png" />