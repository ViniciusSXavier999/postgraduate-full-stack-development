# 4 → CONSULTA DE REGISTROS (SELEÇÃO)

## DIFERENÇA ENTRE CONSULTAS DE PROJEÇÃO E SELEÇÃO

A diferença entre **projeção** e **seleção** em consultas SQL está no **tipo de filtragem** aplicado aos dados:

### **1. Projeção (Projection)**

- Refere-se à escolha de **quais colunas** serão exibidas na consulta.
- Não altera o número de linhas retornadas, apenas define **quais atributos** da tabela serão mostrados.

### **Exemplo de Projeção:**

```sql
SELECT nome, idade FROM clientes;

```

- Retorna apenas as colunas `nome` e `idade`, ignorando outras colunas da tabela.

### **2. Seleção (Selection)**

- Refere-se à **filtragem de linhas** com base em critérios definidos na cláusula `WHERE`.
- Mantém todas as colunas especificadas, mas retorna apenas as linhas que atendem à condição.

### **Exemplo de Seleção:**

```sql
SELECT * FROM clientes WHERE idade > 30;

```

- Retorna **todas as colunas**, mas apenas as linhas em que a `idade` seja maior que 30.

### **Projeção + Seleção (Combinando as Duas)**

É comum usar projeção e seleção juntas para obter um subconjunto de colunas e linhas.

```sql
SELECT nome, idade FROM clientes WHERE idade > 30;

```

- **Projeção**: Exibe apenas `nome` e `idade`.
- **Seleção**: Filtra apenas clientes com `idade` maior que 30.

**Resumo:**

| Característica | Projeção | Seleção |
| --- | --- | --- |
| Atua sobre | Colunas | Linhas |
| Usa | `SELECT` | `WHERE` |
| Objetivo | Escolher quais colunas retornar | Escolher quais linhas retornar |

---

---

---

🏆 Consultas de seleção é aonde a gente vai selecionar REGISTROS (DADOS) dentro da tabela


## LIMITANDO LINHAS USANDO UMA SELEÇÃO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o1.png" />

🏆 Eu não quero mais ver todos os registros de tal coluna, eu quero agora penas os dados específicos e necessários para a minha utilização


> No exemplo da imagem, estamos dizendo: Eu só quero ver os funcionários que trabalham no departamento 10
> 

🏆 QUANDO A GENTE FAZ UMA SELEÇÃO DE REGISTROS(DADOS) A GENTE VAI IMPOR UMA OU MAIS CONDIÇÕES


---

## LIMITANDO LINHAS SELECIONADAS

- RESTRINGE AS LINHAS RETORNADAS USANDO A CLÁUSULA WHERE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o2.png" />

- A cláusula WHERE segue a cláusula FROM

---

## USANDO A CLÁUSULA WHERE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o3.png" />

🏆 VAI SER RETORNADA APENAS OS DADOS QUE CUMPREM COM A CONDIÇÃO ESTABELECIDA NA CLÁUSULA WHERE 


> Toda vez que for STRING tem que estar entre aspas simples
> 

> O valor tem que estar da forma que foi cadastrado na tabela
> 

---

## OPERADORES DE COMPARAÇÃO QUE PODEMOS UTILIZAR NA CLÁUSULA WHERE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o4.png" />

## USANDO OPERADORES DE COMPARAÇÃO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o5.png" />

> OBSERVE QUE O REGISTRO RETORNADO RESPEITA A CONDIÇÃO QUE FOI ESTABELECIDA
> 

---

## OUTROS OPERADORES DE COMPARAÇÃO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o6.png" />

- BETEEN → FAZ UMA COMPARAÇÃO ENTRE DOIS VALORES
- IN → FAZ UMA BUSCA EM UMA LISTA DE VALORES
- LIKE → QUANDO A GENTE VAI CONSULTAR APENAS ALGUNS CARACTERES DENTRO DO CAMPO
- IS NULL → PARA FAZER A COMPARAÇÃO COM NULOS

---

## EXEMPLOS

## USANDO O OPERADOR BETWEEN

### USE O OPERADOR BETEEN PARA EXIBIR LINHAS BASEADAS EM UMA FAIXA DE VALORES

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o7.png" />

🏆 A gente esta selecionando o NOME E O SALARIO da TABELA EMP onde o salário esteja entre 1000 e 1500


> Os limites são inclusivos, podemos observar que o oracle trás os dados do TURNER que ganha 1500 de salário
> 

---

## USANDO O OPERADOR IN

### USE O OPERADOR IN PARA TESTAR VALORES DE UMA LISTA

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o8.png" />

🏆 Estamos selecionando o EMPNO, ENAME, SAL, MGR DA TABELA EMP ONDE (WHERE) O CÓDIGO DO MGR SEJA (7902 OU 7566 OU 7788)


---

## USANDO O OPERADOR LIKE

- USE O OPERADOR LIKE PARA EXECUTAR PESQUISAS CURINGA DE VALORES DE STRING DE PESQUISA VÁLIDOS.
- AS CONDIÇÕES DE PESQUISA PODEM CONTER CARACTERES LITERAIS OU NÚMEROS.
- % DENOTA ZERO OU MUITOS CARACTERES
- _ DENOTA UM CARACTERE

> A gente utiliza quando queremos especificar algum tipo de padrão
> 

> O OPERADOR LIKE TRABALHA JUNTO COM ESSES DOIS CARACTERES % E _
> 

🏆

% → QUALQUER COISA 

_ → QUALQUER LETRA


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o9.png" />

🏆 Na imagem estamos selecionando o ENAME(nome) da tabela emp ONDE esse nome tenha a primeira letra a letra S e depois do S qualquer coisa, ou seja, esse select vai trazer para gente todos os nomes de funcionários que começam com a letra S

---

## USANDO O OPERADOR IS NULL

### TESTE PARA VALORES NULOS COM O OPERADOR IS NULL

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o10.png" />

> Lembrando que nullo é ausência de valor.
> 

🏆 Nós queremos selecionar o ENAME, MGR da tabela emp onde o código do gerente seja nullo, ou seja, queremos saber o funcionário que não tem gerente


---

## ALEM DOS OPERADORES DE COMPARAÇÃO, TEMOS TAMBÉM OS OPERADORES LÓGICOS, VAMOS UTILIZA LOS PARA ESTIPULAR OUTRAS CONDIÇÕES

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o11.png" />

---

## USANDO O OPERADOR AND

### AND EXIGE QUE AMBAS AS CONDIÇÕES SEJAM TRUE

### FAZENDO O SELECT COM MAIS DE UMA CONDIÇÃO

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o12.png" />

---

## USANDO O OPERADOR OR

### OR EXIGE QUE CADA CONDIÇÃO SEJA TRUE

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o13.png" />

🏆 COM O OR O RESULTADO É DIFERENTE PORQUE SE UMA DAS CONDIÇÕES FOR TRUE O REGISTRO SERÁ SELECIONADO

🏆 OU o salário é maior ou igual a 100 OU job=’CLERK’


---

## USANDO O OPERADOR NOT

### O OPERADOR NOT PODE NEGAR TODOS OS OPERADORES QUE VIMOS

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o14.png" />
🏆

- NOT IN → NÃO ESTÁ NA LISTA
- NOT BETWEEN → NÃO ESTÁ NA FAIXA
- NOT IS NOT NULL → NÃO É NULLO

🏆 NA IMAGEM EU QUERO SABER QUAL FUNCIONÁRIO NÃO TEM O CARGO DE ‘CLERK, MANAGER, ANALYST’


---

## CLÁUSULA ORDER BY

### SERVE PARA FAZER A CLASSIFICAÇÃO DOS REGISTROS

- CLASSIFICAR AS LINHAS COM A CLÁUSULA ORDER BY
    - ASC: ORDEM CRESCENTE, DEFAULT
    - DESC: ORDEM DECRESCENTE
- A CLÁUSULA ORDER BY VEM DEPOIS NA INSTRUÇÃO SELECT

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o15.png" />

> QUANDO NÃO UTILIZAMOS A CLÁUSULA ORDER BY OS REGISTROS SÃO RETORNADOS NA ORDEM EM QUE FORAM INSERIDOS NA TABELA, QUANDO NÓS QUEREMOS ALTERAR ESSA CLASSIFICAÇÃO AI A GENTE UTILIZA A CLÁUSULA ORDER BY
> 

---

## PRATICANDO!!!!!!

### UTILIZANDO O OPERADOR DE COMPARAÇÃO MAIOR IGUAL

```sql
SELECT ENAME, SAL FROM SCOTT.EMP WHERE SAL  >= 2500
```

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o16.png" />

### FAZENDO A COMPARAÇÃO POR STRING

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP WHERE ENAME= 'JAMES';
```

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o17.png" />

### FAZENDO A COMPARAÇÃO COM OS OPERADORES ESPECIAIS

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP WHERE SAL BETWEEN 1000 AND 1500
```

> Realizando a comparação dos funcionários que ganham entre 1000 e 1500
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o18.png" />

### UTILIZANDO O OPERADOR IN

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP WHERE JOB IN ('MANAGER', 'PRESIDENT')
```

> O resultado será apenas com os cargos de MANAGER E PRESIDENT
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o19.png" />

### UTILIZANDO O OPERADOR IS NULL

```sql
SELECT ENAME, SAL, JOB, COMM FROM SCOTT.EMP WHERE COMM IS NULL;
```

> Queremos saber os funcionários que não ganham comissão
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o20.png" />

### UTILIZANDO O OPERADOR LIKE

```sql
SELECT ENAME FROM SCOTT.EMP WHERE ENAME LIKE 'A%';
```

> Queremos ver qual é o nome do funcionário que começa com a letra A e depois dessa letra pode vir qualquer coisa
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o21.png" />

### OU PODEMOS FAZER AO CONTRARIO DA PROPOSTA ACIMA, A PRIMEIRA LETRA PODE SER QUALQUER LETRA E A LETRA SEGUINTE TEM QUE SER A LETRA A, É AI QUE ENTRA O _

```sql
SELECT ENAME FROM SCOTT.EMP WHERE ENAME LIKE '_A%';
```

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o22.png" />

### ADICIONANDO CONDIÇÕES COM O END

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP WHERE SAL > 1000 AND JOB = 'CLERK'
```

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o23.png" />

> Lembrando que ambos tem que ser TRUE com o operador AND
> 

### EXECUTANDO O MESMO COMANDO COM O OPERADOR OR

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP WHERE SAL > 1000 OR JOB = 'CLERK'
```

> SE PELO MENOS UMA DAS CONDIÇÕES FOR VERDADEIRA O REGISTRO JÁ SERÁ SELECIONADO
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o24.png" />

### UTILIZANDO A CLÁUSULA ORDER BY

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP ORDER BY ENAME
```

> AS É A PALAVRA DEFAULT, POR ISSO NÃO PRECISA SER ADICIONADO
> 

> ESTAMOS BUSCANDO OS NOMES EM ORDEM ALFABETICA
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o25.png" />

### UTILIZANDO O ORDER BY NA ORDEM DECRESCENTE

```sql
SELECT ENAME, SAL, JOB FROM SCOTT.EMP ORDER BY ENAME DESC
```

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaSele%C3%A7%C3%A3o26.png" />