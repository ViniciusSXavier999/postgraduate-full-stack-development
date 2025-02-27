# 1 → CONSULTA COM OPERAÇÕES ENTRE CAMPOS

✅ É possível fazer operações aritméticas entre os campos 


---

## EXPRESSÕES ARITMÉTICAS

### Criar expressões com dados NUMBER e DATE usando operadores aritméticos.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC1.png" />

---

## USANDO OPERADORES ARITMÉTICOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC2.png" />

### RESULTADO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC3.png" />

> Estamos selecionando o nome e vamos simular o salário acrescido de 300, isso é uma operação aritmética
> 

🚨 Vale lembrar que estamos utilizando o comando select, portanto estamos fazendo uma consulta e não uma alteração no salário, caso a gente queira alterar algum registro devemos utilizar o UPDATE


---

## PRECEDÊNCIA DO OPERADOR

 1 -> * <br>
 2 -> / <br>
 3 -> + <br>
 4 -> - <br>

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC4.png" />

## PRECEDÊNCIA DO OPERADOR NA PRÁTICA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC5.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC6.png" />

> Primeiro será feito 12 * sal e depois acrescenta o 100
> 

### CASO A GENTE QUEIRA QUE A OPERAÇÃO DE SOMA SEJA FEITA PRIMEIRO QUE A MULTIPLICAÇÃO

## USANDO PARÊNTESES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC7.png" />

### RESULTADO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC8.png" />

> Podemos observar que os resultados serão diferentes
> 

---

## DEFININDO UM VALOR NULO

> O campo COMM (comissão dos funcionários) é um exemplo perfeito para esse cenário de nulos e um bom exemplo para a necessidade de ter um nulo.
> 

🚨 Nem todos os cargos ganham comissão, somente os cargos ligados ao departamento comercial, o vendedor, gerente de vendas.

Já um analista de sistemas, um assistente, essas pessoas, o cargo delas não é comissionado, por tanto quando olhamos para a comissão delas a gente se depara com um valor nulo (ausência de valor)


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC9.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC10.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC11.png" />

---

## VALORES NULOS NAS EXPRESSÕES ARITMÉTICAS

🚨 Quando realizamos operações aritméticas com um nulo, o resultado será nulo


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC12.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC13.png" />

🚨 Quando o ‘comm’ é nullo, o resultado da operação será nullo

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC14.png" />


---

## DEFININDO UM APELIDO DE COLUNA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC15.png" />

💡 É nossa função fornecer um relatório que seja legível para os usuários, e desta forma pensando nessa melhoria da leitura, nem sempre os nomes dos campos são legíveis, então acaba sendo difícil para o usuário entender, como por exemplo no campo ‘comm’ se trata da comissão dos funcionários, e nem é obrigação do usuário saber disso, a obrigação é nossa fornecer os melhores relatórios para o usuário entender, por isso é importante o uso dos apelidos das colunas. 


> Os apelidos são vigentes na hora da execução da consulta, a hora que acabou a consulta aquele apelido não existe mais.
> 

> Dar um apelido ao campo não significa que estamos alterando o nome do campo
> 

## USANDO APELIDOS DE COLUNA

💡 Podemos dar esses apelidos através da palavra reservada ‘AS’


✅ Quando o apelido é simples basta colocar o espaço em branco e o apelido que a gente quer

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC16.png" />


✅ Agora quando se trata de um apelido composto, devemos obrigatoriamente colocar entre “” aspas duplas

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC17.png" />


> Podemos dar apelido a campos e a operações
> 

---

## OPERADOR DE CONCATENAÇÃO


✅ É quando a gente quer juntar o conteúdo de um campo com o conteúdo de outro campo 


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC18.png" />

✅ Nós podemos concatenar campos com 

- STRING
- LITERAL (Valor que não pode ser alterado)
- COM OUTRO CAMPO

✅ Podemos concatenar campos de diferentes tipos, ou seja, concatenar STRING COM NÚMERO, CHAR COM DATA


### EXEMPLO: USANDO UM OPERADOR DE CONCATENAÇÃO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC19.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC20.png" />

> Na imagem estamos selecionando os campos ‘ename’ e ‘job’ e apelidando o campo chamando ele de “Employees”
> 

---

## STRING LITERAIS DE CARACTERES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC21.png" />

> Podemos notar que a formatação do resultado não fica tão legal porque os resultados acabam saindo grudado um nos outros, por isso existe a possibilidade de utilizar a concatenação com strins literais
> 

### USANDO STRING LITERAIS DE CARACTERES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC22.png" />

> Após usar as String literais a gente pode perceber uma leitura muito mais legível
> 

---

## LINHAS DUPLICADAS

### A exibição default das consultas é de todas as linhas, incluindo linhas duplicadas

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC23.png" />

✅ Com a cláusula DISTINC nós podemos eliminar os valores repetidos, muitos campos tem valores repetidos e nem sempre a gente quer listar todos os valores do campo, muitas vezes a gente só quer listar os valores singulares, ou seja, os valores sem as repetições  


### ELIMINANDO LINHAS DUPLICADAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC24.png" />

✅ Elimine linhas duplicadas usando a palavra-chave DISTINC na cláusula SELECT


---

---

---

## PRATICANDO!!!

### REALIZANDO OPERAÇÕES ARITMÉTICAS ENTRE OS CAMPOS

```sql
SELECT ENAME, SAL, SAL+500
FROM SCOTT.EMP;
```

> Selecionando o nome dos funcionários, o salário e o salário + 500
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC25.png" />

### REALIZANDO COM A ORDEM DE PRECEDÊNCIA DE CADA UMA DELAS

```sql
SELECT ENAME, SAL, SAL*12+100 FROM SCOTT.EMP;
```

> SE trata da mesma ordem de precedência da matemática, primeiro é feito a multiplicação e depois a soma
> 

✅ Caso a gente queira interferir nessa ordem

```sql
SELECT ENAME, SAL, 12 * (SAL+100) FROM SCOTT.EMP;
```

> Quando a gente quer que uma operação seja executada primeiro, essa operação deve estar dentro dos parênteses
> 

### APRENDENDO MAIS SOBRE APELIDOS EM CAMPOS (APELIDO SIMPLES, COMPOSTO E NAS OPERAÇÕES)

```sql
SELECT ENAME FUNCIONARIO, SAL "SALÁRIO DO COLABORADOR", 12 * (SAL+100) AS "SALARIO ANUAL COM BONUS" FROM SCOTT.EMP;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC26.png" />

### REALIZANDO A CONCATENAÇÃO ENTRE OS CAMPOS

```sql
SELECT ENAME, JOB, SAL, ENAME || JOB || SAL FROM SCOTT.EMP
```

> Vamos selecionar o nome, o cargo e o salário dos funcionários
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC27.png" />

> Podemos notar que a formatação não ficou muito legível e ficou toda junta
> 

✅ POR ISSO PODEMOS CONCATENAR COM STRING PARA FICAR MAIS LEGÍVEL

```sql
SELECT ENAME, JOB, SAL, ENAME || ' TEM O CARGO DE ' || JOB || ' E GANHA ' || SAL "FUNCIONARIOS - CARGOS E SALARIOS" FROM SCOTT.EMP;
```

> ENAME está concatenado com ‘TEM O CARGO DE’ que está concatenado com o JOB que está concatenado com a STRING ‘E GANHA’ concatenado com o campo salário
> 

> “FUCIONARIOS - CARGOS E SALARIOS” → ESTAMOS NOMEANDO ESSA OPERAÇÃO
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC28.png" />

### REALIZANDO OPERAÇÕES SEM REPETIÇÕES

> Com esse comando podemos observar que existe funcionários com o mesmo cargo
> 

```sql
SELECT JOB FROM SCOTT.EMP
```

<img width="100" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC29.png" />

### CASO A GENTE QUEIRA EVITAR REPETIÇÕES VAMOS UTILIZAR A PALAVRA (CLÁUSULA) RESERVADA DISTINCT

> Vamos realizar uma seleção distinta do cargo, ou seja, sem mostrar as repetições
>


```sql
SELECT DISTINCT JOB FROM SCOTT.EMP
```

<img width="100" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultaOPC30.png" />
