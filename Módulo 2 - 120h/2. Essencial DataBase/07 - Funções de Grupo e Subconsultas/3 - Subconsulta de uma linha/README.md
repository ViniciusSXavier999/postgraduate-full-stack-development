# 3 → SUBCONSULTA DE UMA LINHA

## USANDO UMA SUBCONSULTA PARA RESOLVER UM PROBLEMA

### Quem tem um salário maior que o de Jones?

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha1.png" />

⚠️

### “QUEM TEM O MAIOR SALÁRIO QUE O DE JONES?”

> A questão aqui é: Qual é o salário de Jones?, nós não sabemos! então essa se torna a tarefa da consulta interna(SUBCONSULTA) → Descobrir qual é o salário de Jones e aquele resultado retorna para a consulta externa, a partir disso o valor será analisado!
> 

✅ A sub consulta retorna para a consulta principal o valor que será analisado!

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha2.png" />


🏆 SUBCONSULTA TEM VÁRIOS NOMES, PODE SER CHAMADAS DÊ:

- SUBCONSULTA
- SUBSELECT
- CONSULTA DENTRO DA OUTRA

> Mas é tudo o mesmo conceito
> 

🏆 A Sub consulta é quando a gente tem a necessidade de fazer uma consulta menor, e essa consulta de dentro vai retornar um valor para a consulta externa


---

## SINTAXE DA SUB CONSULTA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha3.png" />

✅

- A sub consulta sempre deve estar entre parênteses (assim como vemos o exemplo na imagem), isso serve para indicar que é uma sub consulta
- A sub consulta na maioria das vezes retorna o valor para a consulta externa (consulta principal)
- Não é obrigatório que a sub consulta esteja identada a direita, mas isso facilita bastante na execução do comando, melhora bastante a leitura.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha4.png" />


🏆 A sub consulta (consulta interna) é executada uma vez antes da consulta principal 


🏆 O resultado da sub consulta é usado pela consulta principal(consulta externa)


---

## USANDO UMA SUBCONSULTA

> Nesse exemplo, nós queremos saber qual o nome dos funcionários que ganham mais que o funcionário 7566
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha5.png" />

🏆 Antes de qualquer coisa precisamos da SUB CONSULTA para saber quanto ganha o funcionário 7566.


🏆 Essa sub consulta vai retornar o valor para a consulta principal

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha6.png" />

🏆 A partir do resultado da sub consulta (2975) nós vamos descobrir o resultado da consulta principal (nome dos funcionários que tem o salario maior que 2975)


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha7.png" />

---

## DIRETRIZES PARA O USO DE SUB CONSULTAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha8.png" />

OPERADORES:

- **Operadores de comparação**: `=`, `<>`, `>`, `<`, `>=`, `<=`
- **Operadores de conjunto**: `IN`, `NOT IN`, `ANY`, `ALL`
- **Operadores existenciais**: `EXISTS`, `NOT EXISTS`

---

## TIPOS DE SUBCONSULTAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha9.png" />

### Subconsulta de uma única linha

🏆 É aquela onde a sub consulta retorna apenas 1 único valor.


### Subconsulta de várias linhas

🏆 É a sub consulta que retorna vários valores.


### Subconsulta de várias colunas

🏆 É a que retorna além de várias linhas, vários campos.


### QUAL A IMPORTÂNCIA DE SABER OS TIPOS DE SUBCONSULTA?

🏆 Para cada tipo vamos utilizar um operador especifico 


---

## SUBCONSULTA DE UMA ÚNICA LINHA

✅ Retorne somente uma linha(um valor)

Use operadores de comparação de uma única linha

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha10.png" />


### Executando subconsulta de uma única linha:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha11.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinhaaaaaa.png" />
✅ Explicando exemplo na imagem:

- SELECT → Nós queremos saber quais são os nomes e cargos de funcionários
- FROM → Na tabela scott.emp
- WHERE job = → Que tenha o mesmo cargo do funcionário 7369
- AND SAL > → E que o salário seja maior que o salário do funcionário 7876

> Podemos observar que podemos colocar subconsulta em varias cláusulas do SELECT, no exemplo estamos utilizando subconsultas na cláusula WHERE e no operador AND
> 

⚠️ É muito importante observar que:

- JOB a gente compara com JOB
- SAL a gente compara com SAL

> É necessário essa igualdade nos campos que estão sendo retornados para a consulta principal.
> 

🏆 Nesse exemplo as duas sub consultas retornam apenas 1 valor, por tanto os operadores que devemos utilizar são operadores de uma única linha.


---

## USANDO FUNÇÕES DE GRUPO EM UMA SUB CONSULTA

🏆 A gente pode utilizar qualquer função de grupo dentro de uma sub consulta, observe que os conceitos estão começando a se juntar.


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha12.png" />

> Observe que nessa sub consulta nós temos o MENOR salário da tabela EMP
> 

🏆 Significado da query:

 

- SELECT → Queremos saber o nome, cargo e salário
- FROM → Da tabela emp
- WHERE → Onde o salário seja igual ao menor salário

> Queremos saber qual funcionário tem o menor salário da tabela EMP
> 
> 
> <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha13.png" />
> 

💡 A sub consulta retorna 800 e a consulta principal vai retornar quais funcionários ganham 800 



---

## PRATICANDO!!!

> É sempre interessante começar pela sub consulta ao fazer a query
> 

> Vamos selecionar o salário da tabela emp onde o código do funcionário seja 7566
> 

> A gente quer saber o nome, o salario e o cargo da tabela emp onde o salário seja > que o valor que vai ser retornado pela sub consulta.
> 

```sql
SELECT ename, sal, job
FROM scott.emp
WHERE sal > (SELECT sal 
	                   FROM scott.emp
	                   WHERE empno = 7566)
```

🏆

### **Subconsulta: `(SELECT sal FROM scott.emp WHERE empno = 7566)`**

Agora vamos analisar a subconsulta detalhadamente:

- **`SELECT sal`**: A subconsulta está selecionando o valor da coluna `sal` (provavelmente, o salário) de uma tabela chamada `emp`.
- **`FROM scott.emp`**: O valor de `sal` está sendo selecionado da tabela `emp` no esquema (ou banco de dados) `scott`. Este é um esquema de exemplo comumente usado em bancos de dados de aprendizado, como o Oracle.
- **`WHERE empno = 7566`**: A condição `WHERE empno = 7566` especifica que a subconsulta deve retornar o salário (`sal`) **somente** do empregado cujo número de identificação (ou código) é `7566`.

🏆 Esses são os funcionários que ganham mais que o salário do funcionário 7566


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha14.png" />

🏆 O salário do funcionário 7566 é:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha15.png" />


💡 Com isso sabemos que a sub consulta retorna 2975 para a consulta principal 


### COLOCANDO SUB CONSULTA NO OPERADOR AND

> Podemos colocar sub consultas até mesmo na cláusula FROM
> 

```sql
SELECT ename, sal, job
FROM scott.emp
WHERE sal > (SELECT sal 
	                   FROM scott.emp
	                   WHERE empno = 7566)
	                   
AND job = (SELECT job
           FROM scott.emp
           WHERE ename = 'FORD') 
```

> Estamos dizendo que queremos o funcionário onde o JOB seja igual ao do funcionário ‘FORD’
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha16.png" />

🏆 Observe que os dois tem o salário maior que o do funcionário 7566 e que ambos os cargos são analist


### COLOCANDO NA SUB CONSULTA UMA FUNÇÃO DE GRUPO

> Queremos saber o nome dos funcionários onde o salario seja igual ao menor salário da tabela emp
> 

```sql
SELECT ename
FROM scott.emp 
WHERE sal = (SELECT  min(sal)
             FROM scott.emp)
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/subConsultaUmaLinha17.png" />