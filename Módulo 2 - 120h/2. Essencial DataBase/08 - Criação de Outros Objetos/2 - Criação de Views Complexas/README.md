# 2 → CRIAÇÃO DE VIEWS COMPLEXAS

## CONSULTANDO UMA VIEW

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas1.png" />

> Quando utilizamos o comando ‘SELECT * FROM empvu10’ na verdade estamos executando a mesma coisa da imagem da direita.
> 

---

## MODIFICANDO UMA VIEW

✅ Modificar a view EMPVU10 usando a cláusula CREATE OR REPLACE VIEW. Adicionar um apelido para cada nome da coluna.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas2.png" />

> Estamos modificando a view EMPVU10 para ter os apelidos que estão entre os ()
> 

✅ Os apelidos de coluna na cláusula CREATE VIEW estão listados na mesma ordem que as colunas na subconsulta


🏆 É muito comum a gente já criar a view com esse comando CREATE OR REPLACE VIEW.


🏆
- CREATE VIEW → A GENTE CRIA A VIEW
- CREATE OR REPLACE VIEW → A GENTE ALTERA O TEXTO DA VIEW (É uma boa prática mesmo que esteja criando a view pela primeira vez já utiliza-lo)

---

## CRIANDO UMA VIEW COMPLEXA

🏆 VIEW complexa é aquela que possui funções de grupo ou que possui algum tipo de restrição.


🏆 Criar uma view complexa que contenha funções de grupo para exibir valores a partir de duas tabelas


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas3.png" />

> Podemos observar que a view é bastante complexa, ela acaba tendo restrições e funções de grupo.
> 

### EXPLICANDO QUERY DA IMAGEM:

- Estamos criando uma view que se chama dept_sum_vu
- Essa view vai ter os apelidos (name, minsal, maxsal, avgsal)
- Essa view faz uma JOIN da tabela emp com a tabela dept
- E busca qual é o nome do departamento, o menor, o maior e a media salarial
- Tudo isso agrupado por departamento.

🏆

### EXPLICANDO LINHA POR LINHA DA QUERY

Essa query SQL cria uma **view** chamada `dept_sum_vu`, que apresenta a soma de alguns dados (como o salário mínimo, máximo e médio) para cada departamento na tabela `dept` (departamentos), com base nas informações da tabela `emp` (empregados). Vamos analisar linha por linha:

### Linha 1:

```sql
CREATE VIEW dept_sum_vu (name, minsal, maxsal, avgsal)

```

- **CREATE VIEW**: Comando usado para criar uma **view** no banco de dados. Uma **view** é uma tabela virtual baseada no resultado de uma consulta SQL. Ela não armazena os dados fisicamente, mas sim define uma consulta que será executada sempre que a view for acessada.
- **dept_sum_vu**: Nome da view que está sendo criada.
- **(name, minsal, maxsal, avgsal)**: Definindo os **nomes das colunas** que a view irá ter. Ou seja, quando você acessar a view `dept_sum_vu`, ela terá essas 4 colunas:
    - `name`: Nome do departamento.
    - `minsal`: O salário mínimo dentro de cada departamento.
    - `maxsal`: O salário máximo dentro de cada departamento.
    - `avgsal`: A média salarial dentro de cada departamento.

### Linha 2:

```sql
AS SELECT d.name, MIN(e.sal), MAX(e.sal), AVG(e.sal)

```

- **AS**: Inicia a definição da consulta que irá ser executada pela view.
- **SELECT d.name, MIN(e.sal), MAX(e.sal), AVG(e.sal)**: Esta é a consulta que será usada dentro da view:
    - `d.name`: Nome do departamento (`d` é o alias para a tabela `dept`).
    - `MIN(e.sal)`: A função agregada `MIN()` calcula o **salário mínimo** (`e.sal` é o salário dos empregados na tabela `emp`).
    - `MAX(e.sal)`: A função agregada `MAX()` calcula o **salário máximo**.
    - `AVG(e.sal)`: A função agregada `AVG()` calcula o **salário médio**.

### Linha 3:

```sql
FROM scott.emp e join scott.dept d

```

- **FROM scott.emp e**: Indica que a tabela `emp` (empregados) está sendo referenciada, e o alias `e` é dado a ela para facilitar o uso nas colunas da consulta.
- **JOIN scott.dept d**: Realiza uma junção entre a tabela `emp` (empregados) e a tabela `dept` (departamentos), com o alias `d` dado à tabela `dept`.

### Linha 4:

```sql
ON (e.deptno = d.deptno)

```

- **ON (e.deptno = d.deptno)**: Especifica a condição para a junção entre as tabelas `emp` e `dept`. A condição de junção é que o campo `deptno` (número do departamento) da tabela `emp` seja igual ao campo `deptno` da tabela `dept`. Isso permite combinar as informações dos empregados com os respectivos departamentos.

### Linha 5:

```sql
GROUP BY d.name;

```

- **GROUP BY d.name**: O comando **GROUP BY** agrupa as linhas de acordo com o valor da coluna `d.name` (nome do departamento). Como estamos usando funções agregadas (`MIN()`, `MAX()`, `AVG()`), o agrupamento permite que essas funções operem em dados específicos de cada departamento, ou seja, calcula o salário mínimo, máximo e médio para cada departamento separadamente.

### Resumo do que a query faz:

Essa consulta cria uma view chamada `dept_sum_vu`, que, quando consultada, retorna:

- O nome de cada departamento (`name`).
- O salário mínimo (`minsal`), máximo (`maxsal`) e médio (`avgsal`) dos empregados de cada departamento.

Esses valores são calculados a partir da junção das tabelas `emp` (empregados) e `dept` (departamentos), agrupados pelo nome do departamento.

Exemplo de como os resultados poderiam ser:

| name | minsal | maxsal | avgsal |
| --- | --- | --- | --- |
| IT | 3000 | 9000 | 6000 |
| Marketing | 2500 | 8000 | 5000 |
| Finance | 4000 | 10000 | 7000 |

A view facilita a consulta aos salários de forma resumida por departamento, sem a necessidade de realizar a consulta completa com junções e agregações toda vez.


---

## REGRAS PARA EXECUTAR OPERAÇÕS DML EM UMA VIEW

🏆 Você poderá executar as operações DML em views simples.


🏆 Na maioria das vezes utilizamos a view simples para executar operações DML, porque quando a view contém função de grupo ou quando a view contém a palavra distinct não é possível executar as operações DML, POR TANTO PODEMOS FAZER INSERT, UPDATE, DELETE utilizando uma view simples.

🏆 Você não poderá remover uma linha se a view contiver:

- Funções de grupo
- Uma cláusula GROUP BY
- A palavra DISTINCT
- A palavra-chave pseudocoluna ROWNUM

---

## USANDO A CLÁUSULA WITH CHECK OPTION

🏆 você poderá garantir que a DML na view continue no domínio da view usando a cláusula WITH CHECK OPTION.


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas4.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas5.png" />

🏆 Se a gente tentar fazer qualquer operação DML que mude o nome do departamento para qualquer valor diferente de 20 vai acusar um erro.


🏆 A CLÁUSULA WITH CHECK OPTION garante que a constraint estipulada vai ser sempre verificada, nesse caso a condição estipulada é que o departamento seja igual a 20.


---

## NEGANDO OPERAÇÕES DML

🏆 Você poderá assegurar que nenhuma operação DML ocorra através da adição da opção with READ ONLY à definição da sua view.


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas6.png" />

- Estamos criando uma view que se chama empvu10
- Que vai ter os apelidos (employee_number, employee_name, job_title)
- Que corresponde aos campos empno, ename, job
- Da tabela emp
- ONDE o código do departamento é igual a 10.

🏆 WITH READ ONLY → SIGNIFICA QUE A VIEW SÓ PODERÁ SOFRER ALTERAÇÕES DE SELECT, LEITURA(READ)


---

## REMOVENDO UMA VIEW

🏆 A gente exclui a view, mas a tabela base não é excluída. 


🏆 Remover uma view sem perder dados porque uma view está baseada em tabelas subjacentes no banco de dados.


```sql
DROP VIEW view;
```

```sql
DROP VIEW empvu10
```

---

## PRATICANDO!!!

### NÓS VIMOS QUE É POSSÍVEL CRIAR VIEWS COMPLEXAS

```sql
CREATE OR REPLACE VIEW dept_vu_30
AS SELECT d.dname departamento, min(e.sal) menor, max(e.sal) maior, avg(e.sal) media
FROM scott.emp e JOIN scott.dept d
ON (e.deptno = d.deptno)
GROUP BY d.dname
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas7.png" />

### CRIANDO VIEW SIMPLES

```sql
CREATE OR REPLACE VIEW salvu30
AS SELECT empno, ename, deptno
FROM scott.emp
WHERE deptno=30
```

<img width="300" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas8.png" />

> Exclui os registros da view
> 

```sql
DELETE salvu30
```

🏆 Para termos privilegio de comandos DML devemos ir para MY SCHEMA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas9.png" />

> Foi necessário criar uma tabela que seja a cópia da scott.emp por conta dos privilégios.
> 
</aside>

### UTILIZANDO A CLÁUSULA RED-ONLY

> Estamos evitando que comandos DML faça alterações na view fazendo com que ela seja somente para leitura
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewComplexas10.png" />
