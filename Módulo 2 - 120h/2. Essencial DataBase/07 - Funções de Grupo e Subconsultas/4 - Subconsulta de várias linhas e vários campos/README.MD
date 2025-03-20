# 4 → SUBCONSULTA DE VÁRIAS LINHAS E VÁRIOS CAMPOS

🏆

> Nós vimos que quando a sub consulta retorna uma linha, a gente pode utilizar os operadores de comparação, a questão é que esses operadores de comparação estão preparados para trabalhar com apenas 1 valor, eles não conseguem trabalhar com mais de um valor ao mesmo tempo
> 

🏆 Quando a sub consulta retorna mais de um valor, a gente é obrigado a utilizar operadores especiais 


### Retorne mais de uma linha, Use operadores de comparação de várias linhas

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos1.png" />

- IN → Quando o retorno é de vários campos
- ANY → Quando retorna vários valores
- ALL → Também é quando retorna vários valores

🏆 A diferença é:

- ANY → leitura é de ‘OR’
- ALL → A leitura é de ‘AND’

---

## USANDO O OPERADOR ANY EM SUBCONSULTAS DE VÁRIAS LINHAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos2.png" />

> Começando pela sub consulta → Está selecionando o salário da tabela EMP onde o cargo seja ‘CLERK’, essa sub consulta vai retornar todos os salários dos funcionários que tenham o cargo CLERK.
> 

> Consulta principal → Seleciona o código do funcionário, o nome e o cargo, da tabela emp, onde o salário seja menor que qualquer(ANY) (800 OU 1100 OU 950 08 1300) salário retornado pela sub consulta  E que o cargo seja diferente de “CLERK”
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos3.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos4.png" />

---

## USANDO O OPERADOR ALL EM SUBCONSULTAS DE VÁRIAS LINHAS

> Lembrando que quando utilizamos o ALL a leitura é de AND
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos5.png" />

🏆 ALL → QUE SEJA MAIOR QUE TODOS OS VALORES RETORNADOS PELA SUB CONSULTA


> Subconsulta → Está selecionando a média dos salários, da tabela emp, AGRUPADO pelo departamento(deptno)(vai retornar as médias salariais dos departamentos e nós sabemos que temos 3.)
> 

> Consulta principal → Selecionando o código, nome, e cargo do funcionário, da tabela emp, onde os salários seja maior que todas as médias salariais dos departamentos
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos6.png" />

> Podemos notar que a sub consulta está retornando 3 valores
> 

> Estamos selecionando o código, nome e cargo dos funcionários onde o salário seja maior que os dados retornados pela sub consulta
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos7.png" />

---

## PRATICANDO!!

### TENTANDO UTILIZAR OPERADOR DE COMPARAÇÃO DE UMA UNICA LINHA COM QUERY QUE RETORNA MULTIPLOS VALORES

> MOSTRARÁ UM ERRO!, POIS a consulta retorna mais de 1 valor.
> 

```sql
SELECT empno, ename, sal, job
FROM scott.emp 
WHERE sal >  (SELECT  sal
             FROM scott.emp
             where job='CLERK')
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos8.png" />

### CONCERTANDO A QUERY COM O OPERADOR CORRETO PARA OPERAÇÕES DE MULTIPLOS VALORES (UTILIZANDO O OPERADOR ANY(QUALQUER VALOR))

```sql
SELECT empno, ename, sal, job
FROM scott.emp 
WHERE sal > ANY (SELECT  sal
             FROM scott.emp
             where job='CLERK')
```

> sal > ANY → Qualquer valor retornado pela sub consulta
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos9.png" />

🏆 Esta retornando o código, nome, salário e cargo de todos os funcionários que tem salário maior QUALQUER SALÁRIO DO CARGO CLERK


### DESCOBRINDO OS SALÁRIOS DO CARGO CLERK

```sql
SELECT SAL 
FROM SCOTT.EMP
WHERE job = 'CLERK'
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos10.png" />

### UTILIZANDO O OPERADOR FULL

> Vamos fazer os salários dos funcionários maior que todas as médias salariais agrupadas pelo departamento
> 

```sql
SELECT empno, ename, sal, job
FROM scott.emp 
WHERE sal > ALL (SELECT  avg(sal)
             FROM scott.emp
             GROUP BY deptno)
```

🏆

- SELECIONANDO o código do funcionário, nome, salário e cargo
- DA TABELA emp
- ONDE O SALÁRIO É MAIOR QUE TODAS AS MÉDIAS SALARIAIS POR DEPARTAMENTO


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos11.png" />

### DESCOBRINDO AS MÉDIAS SALÁRIAIS

```sql
SELECT avg(sal)
FROM scott.emp
GROUP BY deptno;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos12.png" />

🏆 Já que queremos saber todos os funcionários que ganham mais que a média salarial de todos os departamentos, ou seja, o salario tem que ser maior que os resultados da imagem.


### UTILIZANDO A CLÁUSULA IN

> SUB CONSULTA → Estamos selecionando o cargo e o salario da tabela emp onde o salario é maior que 2500
> 

```sql
  SELECT  job, sal
     FROM scott.emp
     WHERE  sal > 2500
```

🏆 Primeiro estamos vendo o resultado da sub consulta

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos13.png" />


### CONSULTA PRINCIPAL

```sql
SELECT empno, ename, sal, job
FROM scott.emp 
WHERE (job, sal) IN (SELECT  job, sal
             FROM scott.emp
             WHERE  sal > 2500)
```

🏆

- SELECIONANDO O CÓDIGO DO FUNCIONARIO, O NOME, SALARIO E CARGO
- DA TABELA EMP
- ONDE TENHAM O MESMO CARGO E SALARIO DOS SALARIOS QUE SEJAM MAIOR QUE 2500

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaV%C3%A1riasLinhasEV%C3%A1riosCampos14.png" />

### MELHOR EXPLICAÇÃO DO IN

🏆

A cláusula **`IN`** em SQL é um operador de comparação usado para verificar se um valor está **dentro de um conjunto de valores** especificados. Ela é uma maneira prática de fazer múltiplas comparações sem precisar usar vários **operadores `OR`**. Ao utilizar `IN`, você pode verificar se um valor corresponde a qualquer valor dentro de uma lista de valores, o que facilita a escrita e leitura da consulta.

### Sintaxe da cláusula `IN`

A sintaxe básica do operador `IN` é a seguinte:

```sql
SELECT coluna1, coluna2, ...
FROM tabela
WHERE coluna IN (valor1, valor2, valor3, ...);

```

Aqui, a cláusula `IN` compara a **`coluna`** com os valores especificados no conjunto `(valor1, valor2, valor3, ...)`. Se o valor na coluna corresponder a **qualquer** valor da lista, a condição é verdadeira e a linha é retornada.

### Exemplo básico de uso do `IN`

```sql
SELECT nome, salario
FROM empregados
WHERE departamento_id IN (1, 2, 3);

```

### Explicação:

- A consulta retorna o **nome** e **salário** de todos os empregados cujos **`departamento_id`** é **1**, **2** ou **3**.
- Em vez de escrever algo como:

Usamos o operador `IN` para simplificar a consulta.
    
    ```sql
    WHERE departamento_id = 1 OR departamento_id = 2 OR departamento_id = 3
    
    ```
    

### `IN` com subconsulta

A cláusula `IN` também pode ser usada com **subconsultas** para comparar um valor com os resultados de uma outra consulta. Neste caso, a subconsulta retorna um conjunto de valores, e o operador `IN` verifica se o valor de uma coluna da consulta externa está presente nesse conjunto.

### Exemplo com subconsulta:

```sql
SELECT nome, salario
FROM empregados
WHERE departamento_id IN (SELECT departamento_id FROM departamentos WHERE localizacao = 'São Paulo');

```

### Explicação:

- A subconsulta `(SELECT departamento_id FROM departamentos WHERE localizacao = 'São Paulo')` retorna os `departamento_id` dos departamentos que estão localizados em 'São Paulo'.
- A consulta externa então retorna os **nomes** e **salários** dos **empregados** cujos **`departamento_id`** estão na lista de departamentos de 'São Paulo' retornada pela subconsulta.

### `NOT IN`

O operador `NOT IN` é o oposto de `IN`. Ele verifica se um valor **não está presente** em um conjunto de valores ou resultados de subconsulta.

### Exemplo com `NOT IN`:

```sql
SELECT nome, salario
FROM empregados
WHERE departamento_id NOT IN (1, 2, 3);

```

### Explicação:

- A consulta retorna o **nome** e **salário** de todos os empregados **cujo `departamento_id` não é** 1, 2 ou 3.
- Em vez de escrever:

Usamos o operador `NOT IN` para tornar a consulta mais legível.
    
    ```sql
    WHERE departamento_id <> 1 AND departamento_id <> 2 AND departamento_id <> 3
    
    ```
    

### Comparação com `=` e `OR`

### Comparação com `IN`:

Quando você tem um número de valores para comparar, o operador `IN` é mais conciso e legível:

```sql
SELECT nome
FROM empregados
WHERE departamento_id IN (1, 2, 3);

```

### Comparação com `=` e `OR`:

Você também poderia escrever a mesma consulta usando `=` e `OR`, mas a consulta ficaria mais longa e menos legível:

```sql
SELECT nome
FROM empregados
WHERE departamento_id = 1 OR departamento_id = 2 OR departamento_id = 3;

```

### Diferença entre `IN` e `=` com subconsulta

- **`IN`** com subconsulta é usado quando a subconsulta retorna **múltiplos valores**. Ele verifica se o valor na consulta externa está presente em **qualquer um dos resultados** da subconsulta.
- **`=`** com subconsulta é usado quando a subconsulta retorna **apenas um único valor**. Ele verifica se o valor na consulta externa é **igual ao valor único** retornado pela subconsulta.

### Exemplo com `IN` e subconsulta:

```sql
SELECT nome
FROM empregados
WHERE departamento_id IN (SELECT departamento_id FROM departamentos WHERE localizacao = 'São Paulo');

```

### Exemplo com `=` e subconsulta (supondo que a subconsulta retorne um único valor):

```sql
SELECT nome
FROM empregados
WHERE departamento_id = (SELECT departamento_id FROM departamentos WHERE localizacao = 'São Paulo' AND nome = 'TI');

```

### Considerações Importantes:

1. **Desempenho**: O uso de `IN` com listas de valores pode ser mais eficiente que múltiplos `OR`, especialmente quando o número de itens na lista é grande. No entanto, se a subconsulta retornar muitos resultados, pode afetar o desempenho dependendo do banco de dados e da complexidade da consulta.
2. **`NULL` no conjunto**: Se você usar `IN` com uma lista de valores que contenha `NULL`, os resultados podem ser inesperados. Em SQL, qualquer comparação com `NULL` retorna **falso**, então, se a subconsulta retornar um `NULL`, a comparação falhará, e você pode não obter os resultados esperados.

### Exemplo de problema com `NULL`:

```sql
SELECT nome
FROM empregados
WHERE departamento_id IN (1, 2, NULL);

```

Este exemplo pode **não retornar resultados** porque qualquer comparação com `NULL` é considerada **desconhecida** (não verdadeira), o que pode causar resultados inesperados.

### Conclusão:

A cláusula **`IN`** é uma ferramenta poderosa para verificar se um valor está dentro de um conjunto de valores, simplificando consultas e tornando-as mais legíveis. Você pode usá-la tanto com listas de valores como com subconsultas, e também pode usar **`NOT IN`** para encontrar valores que não estão no conjunto especificado.

