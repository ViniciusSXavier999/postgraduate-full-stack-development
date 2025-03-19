# 1 → FUNÇÕES DE GRUPO

## O QUE SÃO FUNÇÕES DE GRUPO?

🏆 As funções de grupo operam em conjuntos de linhas para fornecer um resultado por grupo


> A função de grupo atua em um conjunto de valores(na maioria das vezes valores numéricos) e retorna 1 valor para aquele conjunto de valores de acordo com a função que está sendo solicitada.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo1.png" />

🏆 Na imagem temos o conjunto de valores do campo SAL, e estamos aplicando a função MAX, ou seja, queremos saber qual é o maior salário(5 mil) entre os funcionários.


---

## OS PRINCIPAIS TIPOS DE FUNÇÕES DE GRUPO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo2.png" />

- AVG → CALCULA A MÉDIA
- COUNT → FAZ A CONTAGEM DE VALORES
- MAX → PEGA O MAIOR VALOR
- MIN → PEGA O MENOR VALOR
- STDDEV →

A função `STDDEV` no SQL é usada para calcular o **desvio padrão** de um conjunto de valores numéricos. O desvio padrão é uma medida de dispersão que indica o quanto os valores de um conjunto de dados variam em relação à média.

### Como funciona:

- **Desvio Padrão**: Medida que expressa o quanto os valores de uma amostra estão distantes da média. Um desvio padrão mais alto significa que os dados estão mais dispersos em torno da média. Um desvio padrão baixo significa que os valores estão mais próximos da média.

### Sintaxe:

```sql
STDDEV(coluna)

```

- **coluna**: é o nome da coluna que contém os valores numéricos dos quais você deseja calcular o desvio padrão.

### Exemplo:

Se você tem uma tabela de vendas e quer calcular o desvio padrão do valor das vendas, pode usar a função `STDDEV` como no exemplo abaixo:

```sql
SELECT STDDEV(valor_venda) AS desvio_padrao
FROM vendas;

```

Isso calculará o desvio padrão da coluna `valor_venda` na tabela `vendas`.

### Nota:

- O `STDDEV` pode ser usado para calcular o desvio padrão em uma **população inteira** (em alguns sistemas de banco de dados) ou para uma **amostra** (nos sistemas mais comuns como Oracle e PostgreSQL).
- Se você precisar do desvio padrão da **população inteira**, use `STDDEV_POP` em vez de `STDDEV`.
- Se você precisar do desvio padrão de uma **amostra**, use `STDDEV_SAMP` (em alguns bancos de dados, como o PostgreSQL).

Em resumo, a função `STDDEV` ajuda a entender a variabilidade de um conjunto de dados numéricos.

### EXEMPLO NA PRÁTICA

### Suponha que temos a seguinte tabela `vendas`:

| id_venda | valor_venda |
| --- | --- |
| 1 | 100 |
| 2 | 150 |
| 3 | 200 |
| 4 | 250 |
| 5 | 300 |

Agora, vamos calcular o **desvio padrão** dos valores das vendas usando a função `STDDEV`.

### Exemplo de SQL com a função `STDDEV`:

```sql
SELECT STDDEV(valor_venda) AS desvio_padrao
FROM vendas;

```

### Passo a Passo de como o SQL calcula o desvio padrão:

1. **Calcular a média dos valores** (média aritmética):
    
    Meˊdia=100+150+200+250+3005=10005=200\text{Média} = \frac{100 + 150 + 200 + 250 + 300}{5} = \frac{1000}{5} = 200
    
2. **Calcular a diferença de cada valor para a média** e elevar ao quadrado:
    - (100 - 200)² = (-100)² = 10000
    - (150 - 200)² = (-50)² = 2500
    - (200 - 200)² = 0² = 0
    - (250 - 200)² = (50)² = 2500
    - (300 - 200)² = (100)² = 10000
3. **Calcular a média das diferenças ao quadrado**:
    
    Meˊdia das diferenc¸as quadradas=10000+2500+0+2500+100005=250005=5000\text{Média das diferenças quadradas} = \frac{10000 + 2500 + 0 + 2500 + 10000}{5} = \frac{25000}{5} = 5000
    
4. **Calcular a raiz quadrada dessa média**:
    
    Desvio Padra˜o=5000≈70.71\text{Desvio Padrão} = \sqrt{5000} \approx 70.71
    

### Resultado:

A consulta SQL retorna o valor **70.71**, que é o desvio padrão dos valores de venda.

### Resultado esperado:

desvio_padrao

---

70.7106781

---

O desvio padrão nos dá uma ideia de quão dispersos os valores de vendas estão em relação à média. Neste caso, como o valor médio das vendas é 200, o desvio padrão de aproximadamente 70 indica que as vendas variam em torno desse valor de forma moderada.

### Observações:

- O valor retornado pode variar ligeiramente dependendo do banco de dados, já que algumas implementações podem tratar o cálculo de forma diferente, mas o conceito e o método de cálculo são sempre os mesmos.
- Caso você queira calcular o desvio padrão de uma amostra, alguns bancos de dados podem ter funções específicas, como `STDDEV_SAMP` ou `STDDEV_POP` (para a população inteira).
- SUM → FAZ A SOMA, CALCULA O TOTAL
- VARIANCE → CALCULA A VARIANCE DOS VALORES, TAMBÉM É UMA FUNÇÃO ESTATISTICA.

---

---

---

## USANDO FUNÇÕES DE GRUPO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo3.png" />

🏆 Via de regra a função de grupo ela sempre vai trabalhar com um conjunto de valores numéricos.


🏆 Vamos especificar na cláusula SELECT qual é a função de grupo e em qual coluna queremos aplicar essa função


---

## USANDO FUNÇÕES AVG E SUM

> Você pode usar AVG e SUM para dados numéricos.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo4.png" />

✅ ESTAMOS FAZENDO O SELECT UTILIZANDO AS FUNÇÕES DE GRUPO

FROM → INDICA QUAL SERÁ A TABELA

WHERE → ONDE, NA COLUNA JOB ONDE O CARGO COMEÇE COM A PALAVRA SALES%


⚠️

### EXPLICANDO PASSO A PASSO DO CÓDIGO DA IMAGEM

Vamos analisar o código SQL linha por linha para entender o que ele faz:

```sql
SELECT AVG(SAL), MAX(SAL), MIN(SAL), SUM(SAL)
FROM SCOTT.EMP
WHERE JOB LIKE 'SALES%';

```

### 1. **`SELECT AVG(SAL), MAX(SAL), MIN(SAL), SUM(SAL)`**

- **`AVG(SAL)`**: Calcula a **média** salarial (SAL) dos funcionários que atendem à condição na cláusula `WHERE`.
- **`MAX(SAL)`**: Retorna o **valor máximo** de salário (SAL) entre os funcionários filtrados.
- **`MIN(SAL)`**: Retorna o **valor mínimo** de salário (SAL) entre os funcionários filtrados.
- **`SUM(SAL)`**: Retorna a **soma total** de todos os salários (SAL) dos funcionários filtrados.

Essas funções agregadas são usadas para calcular estatísticas sobre a coluna `SAL` (salário) dos funcionários. Elas aplicam-se apenas aos registros que correspondem à condição definida na cláusula `WHERE`.

### 2. **`FROM SCOTT.EMP`**

- **`SCOTT.EMP`**: Especifica a tabela de onde os dados serão extraídos. Nesse caso, é a tabela `EMP` no schema `SCOTT`. O schema `SCOTT` é uma base de dados padrão usada para demonstrações em muitos sistemas Oracle.
- **`EMP`**: Essa é a tabela que contém informações sobre os funcionários, incluindo colunas como `SAL` (salário) e `JOB` (cargo).

### 3. **`WHERE JOB LIKE 'SALES%'`**

- **`WHERE`**: Define uma **condição** para filtrar as linhas da tabela. Apenas as linhas que atendem a essa condição serão consideradas nas funções agregadas.
- **`JOB`**: Esta é a coluna que armazena o cargo do funcionário.
- **`LIKE 'SALES%'`**: Aqui, o operador `LIKE` é usado para filtrar todos os registros em que a coluna `JOB` começa com a palavra "SALES". O símbolo `%` representa qualquer sequência de caracteres que venha após a palavra "SALES".
    - Por exemplo, isso incluiria valores como "SALES MANAGER", "SALES ASSOCIATE", "SALES EXECUTIVE", etc.

### Resumo do que o código faz:

Este código SQL calcula quatro estatísticas sobre os salários dos funcionários que têm cargos que começam com "SALES":

1. **Média salarial** (`AVG(SAL)`)
2. **Salário mais alto** (`MAX(SAL)`)
3. **Salário mais baixo** (`MIN(SAL)`)
4. **Soma total dos salários** (`SUM(SAL)`)

Tudo isso é calculado apenas para os funcionários cujo cargo (`JOB`) começa com "SALES".



<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo5.png" />

💡

### EXPLICANDO OPERADOR LIKE (JÁ QUE EU TINHA ESQUECIDO)

O operador `LIKE` no SQL é usado para buscar um padrão específico em uma coluna de texto. Ele permite realizar consultas que encontram correspondências parciais de strings, usando caracteres curinga como:

- `%`: Representa **qualquer número de caracteres** (incluindo zero).
- `_`: Representa **um único caractere**.

### Exemplos:

1. **Usando o `%` para buscar qualquer valor que comece com "Jo"**:
    
    ```sql
    SELECT * FROM clientes
    WHERE nome LIKE 'Jo%';
    
    ```
    
    Isso vai retornar todos os clientes cujo nome começa com "Jo", como "João", "Jorge", "Josiane", etc.
    
2. **Usando o `%` para buscar qualquer valor que termine com "son"**:
    
    ```sql
    SELECT * FROM clientes
    WHERE nome LIKE '%son';
    
    ```
    
    Isso vai retornar clientes cujos nomes terminam com "son", como "Robson", "Jason", etc.
    
3. **Usando o `_` para buscar nomes com exatamente 4 letras começando com "J"**:
    
    ```sql
    SELECT * FROM clientes
    WHERE nome LIKE 'J___';
    
    ```
    
    Aqui, `J___` significa que o nome começa com "J" e tem exatamente 3 caracteres após ele, como "João", "José", etc.
    

### Resumo:

- `LIKE` é útil para procurar padrões em colunas de texto.
- O `%` pode substituir qualquer número de caracteres.
- O `_` substitui um único caractere.

---

## USANDO FUNÇÕES MIN E MAX (podem ser usadas para qualquer tipo de dados)

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo6.png" />

⚠️ Essas funções conseguem trabalhar especificamente com datas e com caracteres


> Na imagem está sendo feito o MIN(hiredate → Data de admissão do funcionário) e MAX(qual é a maior data de admissão)
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo7.png" />

---

## USANDO A FUNÇÃO COUNT

🏆 Ela faz a contagem de valores, quantos valores tem naquele grupo determinado?


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo8.png" />

🏆 Nesse exemplo estamos contando quantos registros da tabela EMP tem o departamento igual a 30


✅ É NECESSÁRIO RESSALTAR QUE QUALQUER FUNÇÃO DE GRUPO SÓ TRABALHA COM VALORES, ISSO SIGNFICA QUE OS NULOS NÃO ENTRA NAS CONTAS DA FUNÇÃO DE GRUPO


### OUTRO EXEMPLO:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo9.png" />

⚠️ COUNT(expr) retorna o número de linhas não nulas


✅ Nesse exemplo onde filtramos quantos funcionários ganham comissão podemos observar que a conta é feito somente com os números e ignorando os nulos, somente 4 funcionários ganham comissão, ou seja, que tem valores no campo ‘comm’


---

## FUNÇÕES DE GRUPO E VALORES NULOS

🏆 As funções de grupo ignoram valores nulos na coluna


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo10.png" />

🏆 Essa query vai trazer a média das comissões, E SOMENTE das pessoas QUE GANHAM comissão, vai somar as 4 comissões e dividir por 4.

> Os nulos são ignorados.
> 

---

## USANDO A FUNÇÃO NVL COM FUNÇÕES DE GRUPO

> Caso a gente queira que os nulos entrem na operação da função
> 

🏆 A função NVL força as funções de grupo a incluírem valores nulos.


✅ ANINHAMENTO DE FUNÇÕES → UMA FUNÇÃO DENTRO DA OUTRA


✅ FUNÇÃO NVL → FAZ A CONVERSÃO DE UM NULO PARA NÚMERO


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo11.png" />

> No EXEMPLO o nvl está fazendo: onde a comissão for nula, converta para 0
> 

⚠️ O valor agora veio diferente pois foi somado todos os valores e dividido por 14 que é a quantidade de registro que tem na tabela


---

## CRIANDO GRUPO DE DADOS

🏆 Dentro da tabela a gente cria grupo de dados, exemplo: 

- Eu quero a média salarial do departamento 10
- Eu quero a média salarial do departamento 20

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo12.png" />


### É AI QUE SURGE UMA NOVA CLÁUSULA CHAMADA GROUP BY.

---

## CRIANDO GRUPOS DE DADOS: CLÁUSULA GROUP BY

🏆 Divida linhas de uma tabela em grupos menores usando a cláusula GROUP BY


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo13.png" />

> Determina qual grupo eu quero criar dentro da tabela:
> 
- Eu quero agrupar a tabela pelo departamento
- Eu quero agrupar a tabela pelo cargo
- Eu quero agrupar a tabela pelos gerente

> Qual grupo ou quais grupos nós queremos criar dentro da tabela, isso é especificado na cláusula GRUOUP BY
> 

---

## USANDO A CLÁUSULA GROUP BY

🏆 Todas as colunas na lista SELECT que não estejam em funções de grupo devem estar na cláusula GROUP BY 

Sim, **todas as colunas** na lista `SELECT` que **não estão em funções de agregação** (como `SUM()`, `AVG()`, `COUNT()`, `MAX()`, `MIN()`) devem ser **inclusas na cláusula `GROUP BY`**.

Isso ocorre porque, quando você usa `GROUP BY`, o SQL precisa saber como agrupar as linhas. Colunas que não são usadas em funções de agregação precisam ser agrupadas para garantir que os resultados façam sentido. Ou seja, qualquer coluna que não seja parte de uma função de agregação precisa ser explicitamente mencionada no `GROUP BY`, pois o SQL precisa saber como combinar os dados em grupos baseados nessas colunas.

### Exemplo:

Suponha que temos uma tabela `funcionarios` com as colunas `id`, `nome`, `salario`, `cargo`.

### Caso Correto:

```sql
SELECT cargo, AVG(salario)
FROM funcionarios
GROUP BY cargo;

```

Aqui, `cargo` está na cláusula `GROUP BY` porque não está envolvido em uma função de agregação. Já a coluna `salario` está dentro da função de agregação `AVG()`, então ela não precisa ser incluída no `GROUP BY`.

### Caso Incorreto (sem incluir as colunas na cláusula `GROUP BY`):

```sql
SELECT cargo, nome, AVG(salario)
FROM funcionarios
GROUP BY cargo;

```

Este código geraria um erro, porque a coluna `nome` não está envolvida em uma função de agregação, mas também não está na cláusula `GROUP BY`. O SQL não sabe como agrupar os dados de `nome`, já que ele não pode saber se `nome` se refere ao nome de um único funcionário ou a vários.

### Como corrigir:

```sql
SELECT cargo, nome, AVG(salario)
FROM funcionarios
GROUP BY cargo, nome;

```

Agora, o SQL sabe como agrupar as linhas de acordo com `cargo` **e** `nome`, e calcula a média dos salários de cada grupo.

### Resumo:

- **Colunas que não estão em funções de agregação** devem ser **explicitamente mencionadas** na cláusula `GROUP BY`.
- **Colunas em funções de agregação** (como `SUM()`, `AVG()`, etc.) **não precisam** estar no `GROUP BY`.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo14.png" />

💡 Nesse exemplo temos a média salarial que é nossa função de grupo AGRUPADA POR DEPARTAMENTO.


---

## AGRUPANDO POR MAIS DE UMA COLUNA

🏆 Caso a tabela tenha mais de um grupo, podemos formar mais de um grupo no mesmo comando


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo15.png" />

🏆 Estamos agrupando pelo departamento e DENTRO DO DEPARTAMENTO PELO CARGO.


---

## USANDO A CLÁUSULA GROUP BY EM VÁRIAS COLUNAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo16.png" />

🏆

- SELECT → CÓDIGO DO DEPARTAMENTO, CARGO, E SOMA SALÁRIAL
- FROM → DA TABELA EMP
- GROUP BY → AGRUPA PELO DEPARTAMENTO E DENTRO DO DEPARTAMENTO AGRUPA PELO CARGO

---

## PRATICANDO!!!

> Vamos selecionar o schema do usuário SCOTT.
> 

### UTILIZANDO O MAX, MIN, AVG, SUM

```sql
SELECT max(sal), min(sal), avg(sal), sum(sal)
FROM scott.emp
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo17.png" />

✅ CASO EU NÃO QUEIRA VER TODAS ESSAS CASAS DECIMAIS, BASTA DAR UM TRUNC


```sql
SELECT max(sal), min(sal), trunc(avg(sal)), sum(sal)
FROM scott.emp
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo18.png" />

### UTILIZANDO AS FUNÇÕS MIN E MAX EM CAMPOS DE DATA E EM CAMPOS DE CARACTERE

```sql
SELECT min(hiredate), max(hiredate), max(ename), min(ename)
FROM scott.emp;
```

> Buscando datas de admissão máxima e mínima e os nomes MAX(o SQL coloca os nomes em ordem alfabética, o ultimo nome listado é o maior nome) e MIN(O PRIMEIRO NOME SERÁ O MENOR NOME)
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo19.png" />

### UTILIZANDO A FUNÇÃO COUNT QUE FAZ A CONTAGEM DE REGISTROS

✅ Quando fazemos COUNT(*) ele conta a quantidade de registros solicitada


```sql
SELECT count(*), count(comm)
FROM scott.emp
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo20.png" />

⚠️ Na tabela emp nós temos 14 registros

E NO campo COMM temos 4 registros sem contar os nulos


🏆 Função de GRUPOS não leva os nulos em consideração.


🏆

### EXPLICAÇÃO DETALHADA DA QUERY COM A FUNÇÃO COUNT

A query que você forneceu:

```sql
SELECT count(*), count(comm)
FROM scott.emp;

```

é uma consulta SQL que utiliza a função de agregação **`COUNT()`** para contar o número de registros. Vamos explicar detalhadamente o que acontece aqui, com exemplos.

### Função `COUNT()`

A função `COUNT()` é usada para contar o número de linhas ou valores não nulos em uma coluna. Dependendo do que você passar como argumento para o `COUNT()`, o comportamento muda:

- **`COUNT(*)`**: Conta **todas as linhas** da tabela, **independente de haver valores nulos** ou não.
- **`COUNT(coluna)`**: Conta apenas as **linhas em que a coluna** especificada **não é nula**.

### Entendendo a Query:

A consulta:

```sql
SELECT count(*), count(comm)
FROM scott.emp;

```

faz duas contagens:

1. **`count(*)`**: Conta **todas as linhas** na tabela `emp` do schema `scott`, **independentemente do valor das colunas**. Ou seja, ele conta todos os registros na tabela, sem se importar se algum valor de alguma coluna é nulo ou não.
2. **`count(comm)`**: Conta **somente as linhas em que a coluna `comm` (provavelmente comissão) não é nula**. Ou seja, ele conta apenas os registros onde a coluna `comm` possui um valor válido (não nulo).

### Exemplo Prático:

Suponha que a tabela `emp` tenha os seguintes dados:

| empno | ename | comm |
| --- | --- | --- |
| 7369 | SMITH | 500 |
| 7499 | ALLEN | NULL |
| 7521 | WARD | 150 |
| 7566 | JONES | NULL |
| 7698 | BLAKE | NULL |
| 7782 | CLARK | 200 |
| 7788 | SCOTT | NULL |
| 7902 | FORD | 250 |
| 7934 | MILLER | 100 |
- **`count(*)`**: Ele vai contar todas as linhas da tabela. Mesmo que algumas colunas, como `comm`, tenham valores nulos, isso não interfere. Ele vai contar **todas as 9 linhas** da tabela.
- **`count(comm)`**: Ele vai contar somente as linhas onde a coluna `comm` **não é nula**. No caso dessa tabela, os valores de `comm` são nulos para as linhas de `ALLEN`, `JONES`, `BLAKE`, `SCOTT`, então ele vai contar as linhas em que `comm` tem um valor. Existem 5 valores não nulos para `comm` (500, 150, 200, 250, 100).

### Resultado Esperado:

Para a tabela de exemplo acima, o resultado da consulta seria:

| count(*) | count(comm) |
| --- | --- |
| 9 | 5 |

**Explicação**:

- **`count(*)`** retorna **9**, porque existem 9 linhas no total na tabela `emp`.
- **`count(comm)`** retorna **5**, porque a coluna `comm` tem 5 valores não nulos.

### Resumo:

- **`count(*)`** conta todas as linhas da tabela, independentemente de valores nulos.
- **`count(comm)`** conta apenas as linhas onde o valor da coluna `comm` não é nulo.

### CASO A GENTE QUEIRA QUE OS NULOS SEJAM LEVADOS EM CONSIDERAÇÃO(NVL)

```sql
SELECT avg(comm), avg(nvl(comm,0))
FROM scott.emp
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo21.png" />

- AVG DO CAMPO COMM → Deu 550 pegou as 4 comissões somou e dividiu por 4.
- AVG COM NVL → PEGOU AS 4 COMISSÕES, SOMOU E DIVIDIU POR 14 PORQUE AGORA TODAS AS COMISSÕES TEM VALOR, OS VALORES QUE ERAM NULO AGORA SÃO 0 POR CONTA DO NVL

### UTILIZANDO O GROUP BY

```sql
SELECT deptno, sum(sal)
FROM scott.emp
GROUP BY deptno
ORDER BY deptno
```

> Vamos realizar a soma salarial por departamento
> 

🔑 Agrupamos a tabela por departamento


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo22.png" />

🔑 A função de grupo é aplicada para cada grupo de departamento dentro da tabela


🏆

### EXPLICAÇÃO DETALHADA DESSA QUERY

```sql
SELECT deptno, sum(sal)
FROM scott.emp
GROUP BY deptno
ORDER BY deptno

```

### 1. **SELECT deptno, sum(sal)**

- **`deptno`**: Esta coluna se refere ao número do departamento. Ela será retornada na consulta e mostra a qual departamento cada registro pertence.
- **`sum(sal)`**: Aqui, a função **`sum()`** é uma função agregada que soma os valores de uma coluna. Neste caso, `sal` se refere ao salário dos empregados. Usando `sum(sal)`, estamos pedindo para somar todos os salários dos empregados **por departamento**.
    - A função `sum()` é usada para calcular a soma total dos salários dentro de cada grupo de departamentos que será criado pela cláusula `GROUP BY`.
    - Como `sal` é uma coluna numérica, a função `sum()` irá somar os valores dessa coluna para cada grupo de `deptno`.

### 2. **FROM scott.emp**

- **`scott.emp`**: A query está sendo executada na tabela `emp`, que está no schema `scott`. Esta tabela contém informações sobre os empregados de uma empresa, como o número do empregado (`empno`), nome (`ename`), salário (`sal`), número do departamento (`deptno`), etc.
    
    Em outras palavras, `emp` é a tabela onde os dados dos empregados estão armazenados, e `scott` é o nome do schema (ou usuário) que possui essa tabela.
    

### 3. **GROUP BY deptno**

- **`GROUP BY deptno`**: Esta cláusula agrupa os resultados da consulta pela coluna `deptno`, ou seja, ela agrupa todos os empregados de um determinado departamento em um único grupo. Assim, a função agregada `sum(sal)` será calculada para cada grupo de empregados que pertencem ao mesmo `deptno`.
    - **Importante**: Quando usamos `GROUP BY`, todas as colunas na cláusula `SELECT` que não são funções agregadas (como `sum(sal)`) devem estar presentes na cláusula `GROUP BY`. No caso, `deptno` é uma coluna que aparece na cláusula `SELECT`, então ela deve ser mencionada em `GROUP BY`, o que está correto aqui.

### 4. **ORDER BY deptno**

- **`ORDER BY deptno`**: A cláusula `ORDER BY` ordena o resultado da consulta com base na coluna `deptno`. Neste caso, os departamentos serão ordenados de forma crescente, ou seja, do menor para o maior número de departamento.
    - **Por padrão**, o `ORDER BY` ordena em ordem crescente (não é necessário especificar `ASC`), mas se você quiser uma ordem decrescente, poderia adicionar `ORDER BY deptno DESC`.

### Resumo do que a query faz:

- **Agrupa** os empregados por departamento (`deptno`).
- Para cada departamento, a função `sum(sal)` calcula o **total de salários** dos empregados desse departamento.
- Em seguida, a query retorna dois resultados para cada grupo de departamento:
    1. O número do departamento (`deptno`).
    2. O total de salários desse departamento (`sum(sal)`).
- Finalmente, os resultados são **ordenados pelo número do departamento** em ordem crescente.

### Exemplo de resultado esperado:

Suponha que a tabela `emp` contenha os seguintes dados de exemplo:

| empno | ename | sal | deptno |
| --- | --- | --- | --- |
| 7839 | KING | 5000 | 10 |
| 7566 | JONES | 2975 | 20 |
| 7698 | BLAKE | 2850 | 30 |
| 7782 | CLARK | 2450 | 10 |
| 7788 | SCOTT | 3000 | 20 |
| 7902 | FORD | 3000 | 30 |
| 7844 | TURNER | 1500 | 20 |

A consulta retornaria algo como:

| deptno | sum(sal) |
| --- | --- |
| 10 | 7450 |
| 20 | 9475 |
| 30 | 5850 |

### Explicação dos resultados:

- **Departamento 10**: A soma dos salários dos empregados neste departamento é 5000 (KING) + 2450 (CLARK) = 7450.
- **Departamento 20**: A soma dos salários é 2975 (JONES) + 3000 (SCOTT) + 1500 (TURNER) = 9475.
- **Departamento 30**: A soma dos salários é 2850 (BLAKE) + 3000 (FORD) = 5850.

Esses resultados seriam exibidos, e os departamentos estariam ordenados de forma crescente (do número de departamento menor para o maior).

### Resumo final:

A query **agrupa os empregados por departamento**, calcula a **soma dos salários por departamento**, e ordena os resultados pelo número do departamento (`deptno`).


### AGRUPAMENTO COM MAIS DE UM GRUPO

```sql
SELECT deptno, job, sum(sal)
FROM scott.emp
GROUP BY deptno, job
ORDER BY deptno, job

```

🔑

- Estamos fazendo a soma salarial do departamento
- dentro do departamento vamos agrupar pelo cargo.

> No departamento 10 podemos notar que temos 3 cargos diferentes, ou seja, 3 subgrupos E ASSIM POR DIANTE
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fun%C3%A7%C3%B5esDeGrupo23.png" />

🔑 Nós temos o grupo do departamento e dentro do departamento nós temos o sub grupo do cargo


🔑

### EXPLICANDO A QUERY DETALHADAMENTE

Vamos analisar detalhadamente essa query SQL:

```sql
SELECT deptno, job, sum(sal)
FROM scott.emp
GROUP BY deptno, job
ORDER BY deptno, job

```

### 1. **SELECT deptno, job, sum(sal)**

- **`deptno`**: Esta coluna representa o número do departamento. A consulta seleciona essa coluna para mostrar o número do departamento de cada grupo.
- **`job`**: A coluna `job` representa o cargo ou função do empregado, como "CLERK", "MANAGER", etc. Ela também é selecionada na consulta para mostrar o cargo de cada empregado dentro de cada grupo.
- **`sum(sal)`**: A função `sum()` é uma função agregada que calcula a soma dos valores de uma coluna. Nesse caso, `sal` refere-se ao salário do empregado. A função `sum(sal)` irá somar os salários de todos os empregados **que têm o mesmo cargo dentro do mesmo departamento**.

### 2. **FROM scott.emp**

- **`scott.emp`**: Esta é a tabela de onde os dados estão sendo extraídos. Ela contém informações sobre os empregados, como o número do departamento (`deptno`), o cargo (`job`), o salário (`sal`), entre outros. A tabela `emp` está no schema `scott`.

### 3. **GROUP BY deptno, job**

- **`GROUP BY deptno, job`**: A cláusula `GROUP BY` agrupa os registros da tabela com base nas colunas mencionadas. Aqui, estamos agrupando os dados pela combinação de **departamento (deptno)** e **cargo (job)**. Isso significa que a consulta irá agrupar todos os empregados que estão no mesmo departamento e têm o mesmo cargo em um único grupo.
    - **Exemplo de agrupamento**: Suponha que no departamento 10 existam 3 empregados com o cargo "CLERK" e 2 empregados com o cargo "MANAGER". A consulta vai separar esses dois grupos:
        - Um grupo para os "CLERK" do departamento 10.
        - Um grupo para os "MANAGER" do departamento 10.
    - A função `sum(sal)` será aplicada a cada um desses grupos separadamente, ou seja, a soma dos salários será calculada para cada cargo dentro de cada departamento.
    
    **Observação importante**: Quando usamos `GROUP BY` em várias colunas, como `deptno` e `job`, cada linha no resultado da consulta será uma combinação única desses dois campos. Ou seja, para cada par único de `deptno` e `job`, haverá uma linha no resultado, com a soma dos salários (`sum(sal)`).
    

### 4. **ORDER BY deptno, job**

- **`ORDER BY deptno, job`**: A cláusula `ORDER BY` ordena os resultados da consulta. Aqui, estamos pedindo para ordenar os resultados primeiro pelo número do departamento (`deptno`) e, em seguida, pelo cargo (`job`).
    - Isso significa que a consulta irá listar os resultados em ordem crescente de número de departamento e, dentro de cada departamento, irá ordenar os cargos em ordem alfabética.

### Resumo do que a consulta faz:

1. **Agrupa os empregados** por **departamento (`deptno`)** e **cargo (`job`)**.
2. Para cada grupo (departamento e cargo), a função `sum(sal)` calcula a soma dos salários dos empregados nesse grupo.
3. **Ordena os resultados** pelo número do departamento (`deptno`) e, dentro de cada departamento, pelos cargos (`job`).

### Exemplo de como seria o resultado:

Considerando que a tabela `emp` contém dados como o seguinte:

| empno | ename | job | sal | deptno |
| --- | --- | --- | --- | --- |
| 7839 | KING | PRESIDENT | 5000 | 10 |
| 7566 | JONES | MANAGER | 2975 | 20 |
| 7698 | BLAKE | MANAGER | 2850 | 30 |
| 7782 | CLARK | CLERK | 2450 | 10 |
| 7788 | SCOTT | ANALYST | 3000 | 20 |
| 7902 | FORD | ANALYST | 3000 | 30 |
| 7844 | TURNER | CLERK | 1500 | 20 |

A consulta retornaria um resultado semelhante a:

| deptno | job | sum(sal) |
| --- | --- | --- |
| 10 | CLERK | 2450 |
| 10 | PRESIDENT | 5000 |
| 20 | ANALYST | 6000 |
| 20 | CLERK | 1500 |
| 20 | MANAGER | 2975 |
| 30 | ANALYST | 3000 |
| 30 | MANAGER | 2850 |

### Explicação dos resultados:

- **Departamento 10**:
    - Para o cargo de **CLERK**, temos um único empregado com salário 2450.
    - Para o cargo de **PRESIDENT**, temos um único empregado (KING) com salário 5000.
- **Departamento 20**:
    - Para o cargo de **ANALYST**, temos um único empregado (SCOTT) com salário 3000, e outro (FORD) com salário 3000, totalizando 6000.
    - Para o cargo de **CLERK**, temos um único empregado (TURNER) com salário 1500.
    - Para o cargo de **MANAGER**, temos um único empregado (JONES) com salário 2975.
- **Departamento 30**:
    - Para o cargo de **ANALYST**, temos um único empregado (FORD) com salário 3000.
    - Para o cargo de **MANAGER**, temos um único empregado (BLAKE) com salário 2850.

### Explicação do processo de ordenação:

- A consulta é **ordenada** por `deptno` em ordem crescente primeiro (10, 20, 30).
- Dentro de cada departamento, a consulta é **ordenada** por `job` em ordem alfabética (exemplo: "ANALYST", "CLERK", "MANAGER", "PRESIDENT").

### Conclusão:

A consulta permite analisar os salários agregados por departamento e cargo. Ela divide os empregados em grupos, soma os salários dentro de cada grupo, e organiza os resultados de forma hierárquica, primeiro pelo número do departamento e depois pelo cargo.


🏆

### EXPLICANDO DETALHADAMENTE A CLÁUSULA GROUP BY

### Explicação Detalhada da Cláusula `GROUP BY`:

A cláusula **`GROUP BY`** no SQL é usada para **agrupar** as linhas de uma tabela com base em uma ou mais colunas. Ela é geralmente utilizada junto com **funções de agregação** (como `COUNT()`, `SUM()`, `AVG()`, `MAX()`, `MIN()`) para realizar cálculos sobre grupos de dados.

Quando você usa `GROUP BY`, o SQL agrupa os registros que têm valores iguais nas colunas especificadas e, em seguida, aplica as funções de agregação a esses grupos.

### Sintaxe:

```sql
SELECT coluna1, coluna2, AGREGACAO(coluna)
FROM tabela
WHERE condição
GROUP BY coluna1, coluna2;

```

- **`coluna1`, `coluna2`**: São as colunas que você deseja usar para agrupar os dados.
- **`AGREGACAO(coluna)`**: É a função de agregação que será aplicada a cada grupo (por exemplo, `SUM(salario)`, `COUNT(*)`, etc.).
- **`GROUP BY`**: Agrupa os dados de acordo com as colunas mencionadas.

### Exemplo Detalhado:

Suponha que temos uma tabela `funcionarios` com as seguintes colunas: `id`, `nome`, `salario`, `cargo`.

| id | nome | salario | cargo |
| --- | --- | --- | --- |
| 1 | João | 3000 | Vendedor |
| 2 | Maria | 3500 | Vendedora |
| 3 | José | 4000 | Gerente |
| 4 | Ana | 4500 | Vendedora |
| 5 | Paulo | 5000 | Gerente |

Agora, queremos **calcular a soma total dos salários** para cada cargo.

A consulta seria:

```sql
SELECT cargo, SUM(salario) AS total_salario
FROM funcionarios
GROUP BY cargo;

```

### Passo a Passo:

1. **Agrupamento**: O SQL agrupa as linhas com base no valor da coluna `cargo`. Nesse caso, ele vai criar dois grupos:
    - Grupo 1: `Vendedor` e `Vendedora`
    - Grupo 2: `Gerente`
2. **Função de agregação**: A função `SUM(salario)` é aplicada a cada grupo. Ou seja, ele calcula a soma dos salários para cada grupo de `cargo`.
3. **Resultado**:

| cargo | total_salario |
| --- | --- |
| Vendedor | 3000 |
| Vendedora | 8500 |
| Gerente | 9000 |

### Considerações Importantes:

1. **Agrupamento por várias colunas**: Você pode agrupar por mais de uma coluna, como por exemplo, por `cargo` e `departamento` ao mesmo tempo:
    
    ```sql
    SELECT cargo, departamento, AVG(salario)
    FROM funcionarios
    GROUP BY cargo, departamento;
    
    ```
    
    Neste caso, o SQL agruparia os dados com base em **duas colunas**: `cargo` e `departamento`.
    
2. **Funções de agregação**: Ao usar o `GROUP BY`, as colunas que não são usadas nas funções de agregação devem estar na cláusula `GROUP BY`. Ou seja, se você estiver calculando a média de salários e quer mostrar o cargo, o cargo deve estar no `GROUP BY`.
3. **Filtragem de grupos**: Se precisar filtrar os grupos após a agregação, você pode usar a cláusula **`HAVING`** (não `WHERE`):
    
    ```sql
    SELECT cargo, AVG(salario)
    FROM funcionarios
    GROUP BY cargo
    HAVING AVG(salario) > 3000;
    
    ```
    
    Isso retorna apenas os cargos com a média salarial superior a 3000.
    

---

### Explicação Resumida:

A cláusula `GROUP BY` é usada para agrupar os dados com base nos valores de uma ou mais colunas. Ela é geralmente combinada com **funções de agregação** (como `SUM()`, `AVG()`, `COUNT()`, `MAX()`, `MIN()`) para calcular valores para cada grupo de dados.

**Exemplo:**

```sql
SELECT cargo, SUM(salario)
FROM funcionarios
GROUP BY cargo;

```

Neste caso, a consulta agrupa os funcionários por `cargo` e calcula a soma dos salários dentro de cada grupo de cargo.

A cláusula **`HAVING`** pode ser usada para **filtrar grupos** após a agregação.


## DUVIDAS QUE SURGIRAM DURANTE A AULA

### DIFERENÇA LINHAS E COLUNAS

Não, **linhas** e **colunas** não são a mesma coisa em uma tabela de banco de dados. Vamos esclarecer:

- **Colunas**: São as características ou atributos de uma tabela. Cada coluna representa um tipo de dado que você armazena na tabela. Por exemplo, em uma tabela de funcionários, as colunas podem ser: `id`, `nome`, `salario`, `cargo`, etc. Cada coluna contém dados de um tipo específico (como texto, números, datas, etc.).
- **Linhas**: São os **registros** ou **entradas** da tabela. Cada linha contém valores para todas as colunas da tabela, representando um único item ou instância. Por exemplo, uma linha pode representar um único funcionário, com valores específicos para as colunas `id`, `nome`, `salario`, `cargo`, etc.

### Exemplo:

Suponha a tabela `FUNCIONARIOS`:

| id | nome | salario | cargo |
| --- | --- | --- | --- |
| 1 | João | 3000 | Vendedor |
| 2 | Maria | 3500 | Vendedora |
| 3 | José | 4000 | Gerente |
- **Colunas**: `id`, `nome`, `salario`, `cargo`.
- **Linhas**:
    - Linha 1: João, 3000, Vendedor.
    - Linha 2: Maria, 3500, Vendedora.
    - Linha 3: José, 4000, Gerente.

Cada **linha** representa um **registro** de um funcionário, e cada **coluna** contém um tipo específico de dado para aquele registro.

Então, para resumir: **colunas** são os **atributos** (características) da tabela, e **linhas** são os **registros** ou **entradas** com os dados reais.

---

### CLÁUSULA WHERE E HAVING

A cláusula `WHERE` é usada para filtrar linhas **antes** das funções de agregação serem aplicadas.

Em vez disso, as funções de agregação geralmente são usadas com a cláusula **`HAVING`**, que permite filtrar os resultados **após** a agregação ser feita.

### Diferença entre `WHERE` e `HAVING`:

- **`WHERE`**: Filtra as linhas antes de qualquer agregação. É usada para condições em colunas individuais.
- **`HAVING`**: Filtra os resultados após a agregação ser feita, ou seja, filtra com base no resultado das funções de agregação.

### Exemplos:

### 1. Usando `WHERE` para filtrar as linhas **antes** da agregação:

```sql
SELECT AVG(salario)
FROM funcionarios
WHERE cargo = 'Vendedor';

```

Neste caso, a consulta calcula a **média salarial** apenas para os funcionários cujo cargo é **"Vendedor"**. A cláusula `WHERE` filtra as linhas com base no cargo, **antes** de calcular a média.

### 2. Usando `HAVING` para filtrar os resultados **após** a agregação:

```sql
SELECT cargo, AVG(salario)
FROM funcionarios
GROUP BY cargo
HAVING AVG(salario) > 3000;

```

Aqui, a consulta calcula a **média salarial** para cada **cargo**, mas só retorna os cargos cujo salário médio é superior a **3000**. A cláusula `HAVING` filtra os grupos resultantes da agregação.

### Resumo:

- Use **`WHERE`** para filtrar linhas antes de aplicar funções de agregação.
- Use **`HAVING`** para filtrar os resultados **depois** que as funções de agregação são aplicadas.

---

### POSSO UTILIZAR AS FUNÇÕES DE GRUPO SEM AS CLÁUSULAS WHERE E HAVING?

Sim, é possível usar **funções de grupo** (ou agregação) **sem a cláusula `WHERE` ou `HAVING`**. Quando você não precisa filtrar dados antes ou depois de aplicar a agregação, pode simplesmente usar a função de agregação para calcular a métrica desejada em todas as linhas da tabela ou em grupos de dados, sem precisar de qualquer filtragem adicional.

### Exemplo sem `WHERE` nem `HAVING`:

Suponha que temos uma tabela de **funcionários** e queremos calcular a **média salarial** de todos os funcionários, sem aplicar nenhum filtro. O código seria:

```sql
SELECT AVG(salario) AS salario_medio
FROM funcionarios;

```

Aqui:

- A função `AVG(salario)` calcula a média dos salários de **todos os funcionários** na tabela `funcionarios`.
- Não há a cláusula `WHERE` (sem filtro antes da agregação) nem a cláusula `HAVING` (sem filtro após a agregação).

### Outros exemplos:

1. **Soma de todos os salários**:
    
    ```sql
    SELECT SUM(salario) AS total_salarios
    FROM funcionarios;
    
    ```
    
    Aqui, `SUM(salario)` soma todos os salários dos funcionários.
    
2. **Contar o número de funcionários**:
    
    ```sql
    SELECT COUNT(*) AS total_funcionarios
    FROM funcionarios;
    
    ```
    
    Aqui, `COUNT(*)` conta o número total de registros (funcionários) na tabela.
    

### Quando usar funções de agregação sem `WHERE` ou `HAVING`:

- Quando você deseja obter uma visão geral dos dados, como a soma total, a média, o número de registros, o valor máximo ou mínimo, sem precisar filtrar ou agrupar os resultados.
- Não é necessário usar `WHERE` ou `HAVING` se você quer trabalhar com todos os dados da tabela ou com a agregação sobre todos os grupos de dados, sem a necessidade de aplicar condições específicas.

### Resumo:

Sim, funções de agregação podem ser usadas sem a cláusula `WHERE` ou `HAVING` se você não precisar filtrar os dados antes ou depois de aplicar a agregação. Elas funcionam para calcular valores como média, soma, contagem, máximo e mínimo sobre os dados totais ou grupos de dados da tabela.