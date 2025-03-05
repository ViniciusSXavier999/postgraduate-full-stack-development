# 1 → JUNÇÕES IDÊNTICAS E TRIDIMENSIONAIS

## QUANDO É NECESSÁRIO FAZER UMA JOIN ENTRE AS TABELAS?

🏆 A join se faz necessária quando a gente tem a necessidade de fazer uma consulta em mais de uma tabela ao mesmo tempo e no mesmo comando.


🏆 JOIN → QUANDO A GENTE QUER OBTER DADOS DE MAIS DE UMA TABELA.


---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas1.png" />

⚠️ Vamos supor que eu queira um relatório somente com os dados de “EMPNO”, “DEPTNO” E “LOC”


> Observe que estamos gerando uma consulta que está consultando dados da tabela EMP e DEPT
> 

💡 Essa é a situação clássica da necessidade da criação de uma junção: QUANDO PRECISAMOS CONSULTAR CAMPOS QUE ESTÃO EM TABELAS DIFERENTES


---

## O QUE É UMA JUNÇÃO?

🔑 Existe muitos tipos de JOIN, por isso é importante que a gente entenda a sintaxe da JOIN e qual é o tipo de JOIN que queremos construir.


### SINTAXE DA JOIN

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas2.png" />

🔑

- 1 → COMANDO SELECT
- 2 → DEPOS IDENTIFICAMOS O NOME DA TABELA
- 3 → NOME DO CAMPO(COLUNA) DA TABELA QUE A GENTE QUER CONSULTAR

### NA CLÁUSULA FROM

- 1 → A GENTE IDENTIFICA AS TABELAS QUE VÃO FAZER PARTE DESSA JOIN

### CLÁUSULA ON

- 1 → A GENTE COLOCA A CONDIÇÃO DA JUNÇÃO, OU SEJA, O QUE VAI FAZER O RELACIONAMENTO DA TABELA A COM A TABELA B.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas3.png" />

### EXPLICANDO SOBRE A CLÁUSULA ON

Imagine que temos duas tabelas:

### Tabela `funcionarios`

| id_funcionario | nome |
| --- | --- |
| 1 | João |
| 2 | Maria |
| 3 | Carlos |

### Tabela `departamentos`

| id_departamento | nome_departamento | id_funcionario |
| --- | --- | --- |
| 101 | TI | 1 |
| 102 | RH | 2 |
| 103 | Financeiro | 3 |

Agora, digamos que queremos saber o nome do funcionário e o nome do departamento onde ele trabalha. Para isso, vamos usar um `JOIN` entre as tabelas `funcionarios` e `departamentos`.

### Consulta com `ON`:

```sql
SELECT funcionarios.nome, departamentos.nome_departamento
FROM funcionarios
JOIN departamentos
ON funcionarios.id_funcionario = departamentos.id_funcionario;

```

### O que acontece aqui?

1. **`JOIN`**: Estamos unindo as duas tabelas, `funcionarios` e `departamentos`.
2. **`ON`**: Estamos dizendo ao SQL que a junção entre as tabelas deve ser feita com base na coluna `id_funcionario`. Ou seja, ele vai combinar as linhas onde o valor de `id_funcionario` nas duas tabelas for igual.

### Resultado da consulta:

| nome | nome_departamento |
| --- | --- |
| João | TI |
| Maria | RH |
| Carlos | Financeiro |

A cláusula `ON` permite que as tabelas se unam corretamente, vinculando os funcionários aos departamentos pelos IDs correspondentes. Neste caso, a junção foi feita onde `id_funcionario` de `funcionarios` é igual a `id_funcionario` de `departamentos`.

Espero que agora tenha ficado mais claro! Se precisar de mais alguma coisa, só avisar.

---

## O QUE É UMA JUNÇÃO IDÊNTICA?

> É o tipo mais comum da join, a equi join
> 

🏆 Temos a ligação da tabela A com a tabela B através do relacionamento estabelecido pela chave primaria e chave estrangeira 


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas4.png" />

🏆 Podemos observar que o campo DEPTNO da tabela EMP é a chave estrangeira

E o campo DEPTNO da tabela DEPT é a chave primária 


> Caso a gente queira saber por exemplo qual o nome do departamento que o funcionário KING trabalha: O KING TRABALHA NO DEPARTAMENTO 10, o DEPARTAMENTO 10 É O DEPARTAMENTO DE ACCOUNTING
> 

🏆 A gente relacionou as duas tabelas através da igualdade do valor da chave estrangeira com o valor da chave primária, por isso esse tipo de JOIN é chamado de junção idêntica, porque há uma igualdade nos valores que a gente vai comparar entre chave primária e chave estrangeira.


🔥 BANCOS DE DADOS EM termos matemáticos são dois conceitos:

- Teoria de conjuntos
- Probabilidade de estatísticas

> Fazer uma junção idêntica nada mais é do que buscar a intersecção(**Ponto em que se cruzam duas linhas**)  entre os conjuntos das tabelas, a tabela EMP tem os seus dados e a tabela DEPT tem os seus dados, o que é fazer a junção idêntica? é identificar o que tem de comum entre essas duas tabelas, como podemos observar é o campo DEPTNO.
> 

### FAZENDO UMA JUNÇÃO IDÊNTICA DO ZERO

Uma **junção idêntica** (ou **equijoin**, como discutimos antes) pode ser feita de maneira manual em SQL para unir duas tabelas com base na **igualdade** de valores em suas colunas. Vamos agora ver como você pode **criar uma junção idêntica do zero**, ou seja, construir um **equijoin** a partir de tabelas simples que não necessariamente têm um relacionamento pré-definido.

### Passo a passo para fazer uma **junção idêntica** (equijoin):

### 1. **Criar as tabelas**

Primeiro, vamos imaginar que você precisa criar duas tabelas simples, `clientes` e `pedidos`, e essas tabelas têm um campo em comum (digamos, `id_cliente`) que será usado para a junção.

Aqui estão os passos para criar as tabelas:

```sql
-- Criar a tabela de clientes
CREATE TABLE clientes (
    id_cliente INT,
    nome_cliente VARCHAR(100)
);

-- Criar a tabela de pedidos
CREATE TABLE pedidos (
    id_pedido INT,
    id_cliente INT,
    data_pedido DATE
);

```

### 2. **Inserir dados nas tabelas**

Agora, vamos inserir alguns dados nas tabelas para exemplificar a junção.

```sql
-- Inserir dados na tabela de clientes
INSERT INTO clientes (id_cliente, nome_cliente)
VALUES
(1, 'João'),
(2, 'Maria'),
(3, 'Carlos');

-- Inserir dados na tabela de pedidos
INSERT INTO pedidos (id_pedido, id_cliente, data_pedido)
VALUES
(101, 1, '2025-03-01'),
(102, 2, '2025-03-02'),
(103, 3, '2025-03-03');

```

### 3. **Fazer a junção idêntica (equijoin)**

Agora que temos os dados, vamos fazer a junção idêntica entre as duas tabelas. A ideia é unir essas tabelas pelo campo comum `id_cliente`, usando a **igualdade** (`=`), o que caracteriza o **equijoin**.

A consulta SQL para fazer a junção idêntica seria:

```sql
SELECT
    clientes.id_cliente,
    clientes.nome_cliente,
    pedidos.id_pedido,
    pedidos.data_pedido
FROM clientes
INNER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

```

### O que acontece aqui?

1. **`INNER JOIN`**: A junção entre as tabelas `clientes` e `pedidos` é feita usando o `INNER JOIN`. Isso significa que só vamos obter os registros onde há uma correspondência de `id_cliente` nas duas tabelas.
2. **`ON clientes.id_cliente = pedidos.id_cliente`**: A cláusula `ON` especifica que a junção deve ser feita quando o valor de `id_cliente` da tabela `clientes` for igual ao valor de `id_cliente` da tabela `pedidos`. Isso é o que caracteriza a junção **idêntica** ou **equijoin**.

### Resultado da consulta:

| id_cliente | nome_cliente | id_pedido | data_pedido |
| --- | --- | --- | --- |
| 1 | João | 101 | 2025-03-01 |
| 2 | Maria | 102 | 2025-03-02 |
| 3 | Carlos | 103 | 2025-03-03 |

Neste caso, as tabelas foram unidas pelas colunas `id_cliente`, e o valor de `id_cliente` foi o critério de igualdade para a junção. Como o `INNER JOIN` só retorna registros que têm correspondência nas duas tabelas, todos os resultados têm um cliente e um pedido correspondentes.

### Resumo:

- **Junção idêntica (equijoin)** é feita utilizando o operador de igualdade (`=`) nas colunas de duas tabelas.
- Utilizamos o **`INNER JOIN`** para combinar as tabelas com base em uma condição de igualdade entre as colunas.
- Esse tipo de junção pode ser feito do "zero", criando tabelas e inserindo dados manualmente, e depois realizando a junção entre elas usando a condição de igualdade.

---

### EXPLICANDO UM CÓDIGO SQL QUE TEM INNER JOIN

```sql
SELECT
    clientes.id_cliente,
    clientes.nome_cliente,
    pedidos.id_pedido,
    pedidos.data_pedido

```

- **`SELECT`**: O comando `SELECT` é usado para escolher quais colunas de dados você deseja retornar de uma ou mais tabelas.
- **`clientes.id_cliente`**: Aqui, você está pedindo para retornar a coluna `id_cliente` da tabela `clientes`.
- **`clientes.nome_cliente`**: Aqui, você está pedindo para retornar a coluna `nome_cliente` da tabela `clientes`.
- **`pedidos.id_pedido`**: Você está pedindo para retornar a coluna `id_pedido` da tabela `pedidos`.
- **`pedidos.data_pedido`**: Aqui, você está pedindo para retornar a coluna `data_pedido` da tabela `pedidos`.

Ou seja, essa primeira parte do código vai retornar quatro colunas: o ID e o nome dos clientes, além do ID e da data dos pedidos feitos por esses clientes.

```sql
FROM clientes

```

- **`FROM clientes`**: O comando `FROM` especifica a tabela de onde você está retirando os dados. Nesse caso, os dados estão sendo extraídos da tabela `clientes`.

```sql
INNER JOIN pedidos

```

- **`INNER JOIN pedidos`**: O `INNER JOIN` é uma operação de junção entre tabelas. Ele combina as linhas da tabela `clientes` com as linhas da tabela `pedidos` onde existe uma correspondência entre elas. Ou seja, ele vai pegar apenas os registros de `clientes` que têm pedidos na tabela `pedidos`. Se um cliente não tiver pedido registrado, ele não aparecerá no resultado.

```sql
ON clientes.id_cliente = pedidos.id_cliente;

```

- **`ON clientes.id_cliente = pedidos.id_cliente`**: Aqui, é especificada a condição de junção. O `INNER JOIN` vai associar a tabela `clientes` com a tabela `pedidos` com base no campo `id_cliente`. Isso significa que o SQL vai procurar registros na tabela `clientes` onde o valor de `id_cliente` é igual ao valor de `id_cliente` na tabela `pedidos`. Somente os clientes que têm um pedido correspondente terão seus dados exibidos.

### Resumo do funcionamento:

1. O código começa selecionando quatro colunas: duas da tabela `clientes` (ID e nome do cliente) e duas da tabela `pedidos` (ID do pedido e data do pedido).
2. Ele usa um `INNER JOIN` para combinar as tabelas `clientes` e `pedidos` com base no campo `id_cliente`.
3. A junção vai garantir que apenas clientes com pedidos registrados serão incluídos nos resultados.

Ou seja, o resultado dessa consulta vai ser uma lista de clientes e seus respectivos pedidos, com as colunas `id_cliente`, `nome_cliente`, `id_pedido` e `data_pedido`, mas somente para aqueles clientes que fizeram pedidos.

---

⚠️

## INNER JOIN E JOIN DÚVIDA:

**`JOIN`** e **`INNER JOIN`** não são exatamente a mesma coisa, mas, na prática, eles frequentemente têm o mesmo comportamento.

### Explicando a diferença:

1. **`INNER JOIN`**:
    - O `INNER JOIN` é um tipo específico de junção entre duas tabelas.
    - Ele retorna **somente as linhas** onde existe uma correspondência entre os registros das duas tabelas com base na condição de junção (geralmente utilizando `ON`).
    - Ou seja, ele exclui da consulta os registros que não têm correspondência nas duas tabelas.
2. **`JOIN` (sem especificação)**:
    - O `JOIN` sem nenhuma palavra-chave adicional é, por padrão, um **`INNER JOIN`**.
    - Ou seja, se você escrever apenas **`JOIN`** (sem especificar o tipo), o banco de dados vai tratá-lo como **`INNER JOIN`**.
    - Isso significa que, na prática, **`JOIN` e `INNER JOIN` são equivalentes**.

### Exemplo:

- **`INNER JOIN`**:
    
    ```sql
    SELECT *
    FROM clientes
    INNER JOIN pedidos
    ON clientes.id_cliente = pedidos.id_cliente;
    
    ```
    
- **`JOIN`** (equivalente a `INNER JOIN`):
    
    ```sql
    SELECT *
    FROM clientes
    JOIN pedidos
    ON clientes.id_cliente = pedidos.id_cliente;
    
    ```
    

Ambos os códigos acima fazem a mesma coisa: eles retornam os clientes que possuem pedidos, mostrando apenas as linhas em que existe uma correspondência entre as tabelas `clientes` e `pedidos`.

### Resumo:

- **`INNER JOIN`** é um tipo de junção que retorna apenas as linhas com correspondência nas duas tabelas.
- **`JOIN`**, por padrão, também é um **`INNER JOIN`**, e, portanto, tem o mesmo comportamento.

Por isso, você pode usar qualquer um dos dois, mas é mais explícito e claro usar **`INNER JOIN`** quando você quiser especificar que está realizando esse tipo de junção.


---

## RECUPERANDO REGISTROS COM JUNÇÕES IDÊNTICAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas5.png" />

### EXPLICANDO A SINTAXE DO COMANDO, ESTAMOS SELECIONANDO (SELECT):

- CAMPO empno da TABELA emp
- CAMPO ename da TABELA emp
- CAMPO deptno da TABELA emp
- CAMPO deptno da TABELA dept
- CAMPO loc da TABELA dept

### FROM E INNER JOIN

> ESSA JOIN ESTÁ SENDO FEITA ENTRE as tabelas FROM emp JOIN dept
> 

### ON

> A condição de junção é quando o campo deptno da tabela emp for igual (=) ao campo deptno da tabela dept
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas6.png" />

---

## USE APELIDOS NAS TABELAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas7.png" />

⚠️ O QUE É PREFIXOS DE TABELA?

Em SQL, o termo "prefixo das tabelas" refere-se a uma convenção ou prática de adicionar um conjunto de caracteres ou uma abreviação ao nome das tabelas para identificar ou categorizar melhor os objetos do banco de dados. Esse prefixo pode ser usado para distinguir diferentes tipos de tabelas ou para facilitar a organização e a leitura dos nomes das tabelas.

Por exemplo:

- Se uma tabela armazena informações sobre **clientes**, você pode ter uma tabela chamada `clientes` ou, para tornar mais claro o tipo de dado ou o contexto, poderia usar um prefixo como `tbl_` para indicar que é uma tabela, tornando o nome da tabela algo como `tbl_clientes`.
- Em alguns casos, se você tiver diferentes módulos ou áreas dentro de um sistema, você pode usar um prefixo para identificar isso. Por exemplo, se você tem tabelas relacionadas a **vendas**, elas poderiam ser nomeadas como `vendas_pedidos`, `vendas_itens`, e assim por diante.

O uso de prefixos pode variar de acordo com as convenções adotadas em cada projeto ou organização. É uma prática comum em sistemas legados ou em projetos que buscam manter uma boa organização visual do banco de dados, embora, em alguns casos, o uso de prefixos tenha sido desencorajado em favor de nomes mais descritivos e autoexplicativos.


> Para fazer a join a gente precisa colocar os nomes das tabelas, e isso dependendo do tamanho do nome pode gerar um tamanho muito grande, então para facilitar nossa vida no que se refere a digitação do comando, é sempre preferível colocar apelido nas tabelas para facilitar nossa vida na digitação dos comandos.
> 

> O apelido só é válido na execução da consulta, quando termina a consulta aquele apelido não é mais válido.
> 

### EXEMPLO USANDO APELIDOS DE TABELA

> Simplificando consultas usando apelidos de tabela
> 

### SEM APELIDOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas8.png" />

### UTILIZANDO APELIDOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas9.png" />

⚠️ Podemos fazer dessas duas formas, o que não pode é misturar os dois!


### OUTRO EXEMPLO UTILIZANDO APELIDOS DE TABELA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas10.png" />

---

## CRIANDO JUNÇÕES (JOINS) TRIDIMENSIONAIS

🏆 Quando a gente tem a necessidade de juntar mais de 2 tabelas na mesma consulta, chamamos isso de JOIN tridimensional


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas11.png" />

📢 Função matemática → se N é o número de tabelas, N menos 1 é o número de condições de junção

- Se a gente precisa fazer a JOIN entre 3 tabelas, significa que precisamos criar 2 condições de junção
- Se a gente precisa fazer a JOIN entre 10 tabelas, significa que precisamos criar 9 condições de junção

🏆 EXPLICAÇÃO DESSE CÓDIGO 

### Código:

```sql
SELECT employee_id, city, department_name
FROM employees e
JOIN departments d ON d.department_id = e.department_id
JOIN locations l ON d.location_id = l.location_id;

```

### 1. **`SELECT employee_id, city, department_name`**

- **O que faz:** Essa linha especifica as colunas que você quer selecionar no resultado da consulta.
    - **`employee_id`**: A coluna que provavelmente contém o identificador único de cada funcionário na tabela `employees`.
    - **`city`**: A coluna que contém o nome da cidade, que está associada à localização dos departamentos.
    - **`department_name`**: A coluna que contém o nome do departamento, que está na tabela `departments`.

### 2. **`FROM employees e`**

- **O que faz:** Indica que a consulta vai começar pela tabela `employees` (funcionários).
    - **`e`**: Isso é um **alias** (apelido) para a tabela `employees`. Ou seja, em vez de usar o nome completo da tabela em toda a consulta, você pode referenciá-la como `e`. Isso facilita a leitura e a escrita da consulta, especialmente quando há várias tabelas envolvidas.

### 3. **`JOIN departments d ON d.department_id = e.department_id`**

- **O que faz:** Realiza uma junção (join) entre a tabela `employees` (funcionários) e a tabela `departments` (departamentos).
    - **`JOIN`**: O tipo de junção que está sendo utilizado aqui é o `INNER JOIN`, que retorna apenas as linhas que têm correspondência nas duas tabelas. Ou seja, só serão retornados os funcionários que estão associados a um departamento.
    - **`d`**: Alias para a tabela `departments`, facilitando a referência a ela.
    - **`ON d.department_id = e.department_id`**: A condição de junção define que a coluna `department_id` da tabela `departments` deve ser igual à coluna `department_id` da tabela `employees`. Isso significa que a consulta vai combinar as linhas da tabela `employees` com as linhas da tabela `departments` baseadas no departamento ao qual o funcionário pertence.

### 4. **`JOIN locations l ON d.location_id = l.location_id`**

- **O que faz:** Realiza outra junção entre a tabela `departments` e a tabela `locations` (localizações).
    - **`l`**: Alias para a tabela `locations`.
    - **`ON d.location_id = l.location_id`**: A condição de junção define que a coluna `location_id` da tabela `departments` deve ser igual à coluna `location_id` da tabela `locations`. Ou seja, a consulta vai combinar os departamentos com suas respectivas localizações.

### Resultado Final:

A consulta vai retornar uma lista de funcionários (`employee_id`), juntamente com a cidade (`city`) e o nome do departamento (`department_name`) de cada um, combinando informações de três tabelas:

1. **`employees`** (dados sobre os funcionários),
2. **`departments`** (dados sobre os departamentos), e
3. **`locations`** (dados sobre as localizações dos departamentos).

A combinação é feita usando as condições de junção (`ON`) especificadas.

### Resumo:

Essa consulta é uma junção entre três tabelas (`employees`, `departments`, `locations`), buscando exibir o `employee_id`, a `city` da localização do departamento do funcionário e o nome do `department_name`. As junções entre as tabelas são feitas com base no `department_id` (funcionário e departamento) e no `location_id` (departamento e localização).


### EXECUÇÃO DA JUNÇÃO TRIDIMENSIONAL

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas12.png" />

📢 Parênteses podem ser usados para agrupar múltiplas condições de junção, ou para incluir subconsultas ou expressões dentro da cláusula **`ON`**.


---

## PRATICANDO!!!

### UTILIZANDO JOIN

> É sempre interessante começar fazendo a JOIN pela cláusula FROM
> 

```sql
SELECT e.ename, e.sal, d.dname, d.deptno, d.loc
FROM scott.emp e 
JOIN scott.dept d
ON (e.deptno = d.deptno)

```

> Não é obrigatório o uso do parênteses na cláusula ON, mas é recomendado para que fique mais legível o comando e para que você possa identificar onde esta exatamente a condição de junção
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas13.png" />

### CASO EU QUEIRA QUE APAREÇA O CAMPO DEPTNO DA TABELA EMP

```sql
SELECT e.ename, e.sal, e.deptno2, d.dname, d.deptno, d.loc
FROM scott.emp e 
JOIN scott.dept d
ON (e.deptno = d.deptno)

```

> Tem que colocar um apelido se não da erro de ambiguidade no console.
> 

### UTILIZANDO JOIN TRIDIMENSIONAL

> No oracle live mudamos o schema
> 

```sql
SELECT e.last_name, d.department_name, l.city
FROM hr.employees e join hr.departments d // Chamamos a tabela employees do usuario HR que recebe o apelido e, que vai fazer uma JOIN com a tabela departments do usuário hr
ON (e.department_id = d.department_id) // condição entre essas tabelas é pelo código do departamento, chave primaria com chave estrangeira 
JOIN hr.locations l
ON (d.location_id = l.location_id) // condição é quando o código do local da tabela department for igual a l.location_id
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%B5esId%C3%AAnticas14.png" />

> Buscamos 3 dados de 3 tabelas diferentes
> 

---

---

## DÚVIDAS QUE TIVE E FUI PESQUISAR SOLUÇÕES

### e caso a gente nao tenha campos iguais nas duas tabelas, o inner join vai dar erro?

Não, o `INNER JOIN` não vai dar erro se as duas tabelas não tiverem campos com o mesmo nome. Porém, ele **precisa** que você especifique uma condição de junção (usando a cláusula `ON`) para determinar como as tabelas devem ser associadas.

O erro pode acontecer se você não fornecer uma condição válida de junção ou se houver algum outro erro lógico na consulta. O `INNER JOIN` por si só **não exige** que as colunas nas duas tabelas tenham o mesmo nome, mas você precisa indicar explicitamente como as duas tabelas devem ser unidas.

### Exemplos:

1. **Juntando duas tabelas com campos diferentes**:
    
    Vamos supor que temos duas tabelas:
    
    - **Tabela `clientes`**:
        - `id_cliente`
        - `nome_cliente`
    - **Tabela `pedidos`**:
        - `id_pedido`
        - `id_cliente_pedido`
    
    Embora as colunas que identificam o cliente nas duas tabelas tenham nomes diferentes (`id_cliente` em `clientes` e `id_cliente_pedido` em `pedidos`), você ainda pode fazer o `INNER JOIN` se especificar a condição corretamente:
    
    ```sql
    SELECT clientes.id_cliente, clientes.nome_cliente, pedidos.id_pedido
    FROM clientes
    INNER JOIN pedidos
    ON clientes.id_cliente = pedidos.id_cliente_pedido;
    
    ```
    
    Nesse caso, estamos fazendo o join entre a coluna `id_cliente` da tabela `clientes` e a coluna `id_cliente_pedido` da tabela `pedidos`, mesmo que os nomes das colunas sejam diferentes.
    
2. **Caso sem condição de junção (erro)**:
    
    Se você esquecer de adicionar a condição de junção, o SQL vai gerar um erro, pois ele não saberá como combinar as tabelas corretamente. Por exemplo:
    
    ```sql
    SELECT clientes.id_cliente, clientes.nome_cliente, pedidos.id_pedido
    FROM clientes
    INNER JOIN pedidos;
    
    ```
    
    Esse código vai gerar um erro porque você não forneceu a condição de junção com a cláusula `ON` (ou `USING`), então o banco de dados não sabe como associar as tabelas.
    

### Resumo:

- O `INNER JOIN` **não exige que as colunas tenham o mesmo nome** nas duas tabelas, mas você **precisa** especificar claramente como as tabelas devem ser associadas através da cláusula `ON`.
- Se não houver uma condição de junção válida, o SQL gerará um erro.

---

### a junção só pode ser feita se as tabelas tiverem valores identicos?

Não, a junção **não precisa** ser feita apenas com valores **idênticos**. A junção pode ocorrer com base em condições de comparação diferentes, e não necessariamente valores exatos. As junções em SQL podem ser feitas com base em várias condições, além da **igualdade**. Vou explicar melhor as diferentes formas de junção que você pode usar.

### 1. **Junção com igualdade (mais comum) — `INNER JOIN`**

A **junção com igualdade** é, de fato, a forma mais comum de junção, onde você compara duas colunas para verificar se elas possuem **valores idênticos**. Por exemplo, quando você tem uma tabela `employees` com uma coluna `department_id` e uma tabela `departments` também com `department_id`, você pode usar uma condição de igualdade para juntar os dados:

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id;

```

Aqui, as duas tabelas são unidas onde o `department_id` em ambas as tabelas é **idêntico**.

### 2. **Junção com desigualdade (comparação de valores diferentes)**

Você pode também usar outros tipos de comparação, como **desigualdade**. Por exemplo, pode haver casos onde você queira comparar valores diferentes ou até mesmo fazer uma junção onde as colunas têm **valores não idênticos**:

- **Desigualdade (não igual):**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.salary != d.budget;
    
    ```
    
    Aqui, a junção ocorre onde o `salary` do funcionário **não é igual** ao `budget` do departamento.
    
- **Maior que ou menor que:**
    
    Você pode também usar operadores como `>`, `<`, `>=`, ou `<=` para fazer junções com base em comparações de valores:
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.salary > d.budget;
    
    ```
    
    Neste exemplo, a junção ocorre apenas quando o salário do funcionário é **maior que** o orçamento do departamento.
    

### 3. **Junção com intervalo (`BETWEEN`)**

Você também pode usar a palavra-chave `BETWEEN` para realizar junções com valores dentro de um **intervalo**. Ou seja, você pode juntar dados onde os valores estão dentro de um intervalo específico.

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.salary BETWEEN d.min_salary AND d.max_salary;

```

Neste caso, a junção ocorre quando o `salary` do funcionário está **dentro do intervalo** de salários (`min_salary` e `max_salary`) do departamento.

### 4. **Junção com `IS NULL` (verificação de valores nulos)**

Outra forma de realizar junção é verificando se uma coluna possui um **valor `NULL`**, o que pode ser útil em cenários onde você precisa combinar dados com registros ausentes.

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id IS NULL;

```

Neste exemplo, a junção ocorre quando o `department_id` de um funcionário é `NULL`, ou seja, o funcionário não está associado a nenhum departamento.

### 5. **Junção com comparação de padrões — `LIKE`**

A cláusula **`LIKE`** permite realizar junções baseadas em **padrões de texto**. Ao invés de comparar valores exatos, você pode buscar por correspondências parciais.

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.name LIKE d.department_name;

```

Nesse exemplo, a junção ocorre quando o nome do funcionário (provavelmente uma parte de seu nome) **corresponde** a um padrão no nome do departamento.

### 6. **Junção com `IN` (comparação com uma lista de valores)**

A condição **`IN`** pode ser usada para verificar se o valor de uma coluna corresponde a qualquer um de um conjunto de valores possíveis.

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id IN (1, 2, 3, 4);

```

Neste exemplo, a junção é feita onde o `department_id` do funcionário está **dentro** de uma lista específica de valores (1, 2, 3, 4).

### 7. **Junção com Expressões e Funções**

Você também pode usar funções ou expressões para fazer junções. Por exemplo, usando **funções de data** para comparar datas ou **expressões matemáticas**.

```sql
SELECT e.employee_id, e.name, d.department_name
FROM employees e
INNER JOIN departments d ON YEAR(e.hire_date) = YEAR(d.start_date);

```

Aqui, estamos fazendo uma junção com base no **ano** de contratação do funcionário e o **ano de início** do departamento.

---

### Resumo:

- A **junção idêntica** (com **`INNER JOIN`**) é a forma mais comum de junção e normalmente se baseia em uma comparação de **valores iguais** (como chaves primárias e estrangeiras), mas **não é limitada** a isso.
- Você pode realizar junções usando **outros tipos de comparação**, como desigualdade (`!=`), maior que (`>`), menor que (`<`), entre (`BETWEEN`), padrões (`LIKE`), listas (`IN`), e até mesmo verificações de `NULL`.
- A junção pode ser feita com base em **qualquer condição de comparação válida**, dependendo da lógica de negócios que você deseja aplicar, e não necessariamente valores **idênticos**.

Ou seja, as junções SQL são **muito flexíveis** e permitem comparações além da igualdade direta.

---

---

### a junção identica só é possivel fazer com chave primaria e chave estrangeira?

Não, a junção **`idêntica`** (ou **`INNER JOIN`**) não é limitada apenas à comparação entre **chave primária** e **chave estrangeira**. Embora seja **muito comum** utilizar chaves primárias e chaves estrangeiras em junções, você pode realizar uma junção baseada em **qualquer coluna** que tenha dados compatíveis entre as duas tabelas.

### O que caracteriza uma **junção idêntica**?

Uma junção **idêntica** (também conhecida como **`INNER JOIN`**) é aquela onde você **compara valores de colunas de duas tabelas** para combinar as linhas. Isso significa que, para cada linha de uma tabela, você busca uma linha correspondente na outra tabela onde as condições de junção sejam verdadeiras.

### Tipos de condições possíveis de junção (não limitadas a chaves primárias e estrangeiras):

Embora em muitos casos você utilize **chaves primárias** e **chaves estrangeiras** para definir a relação entre as tabelas, é possível usar **qualquer outra coluna** ou expressão para a condição de junção.

### Exemplos de junção não baseada em chave primária/estrangeira:

1. **Junção baseada em outra coluna qualquer**:
    - Suponha que você tenha duas tabelas, `products` e `sales`, e você quer juntar essas tabelas pela coluna `category` (não uma chave primária ou estrangeira):
    
    ```sql
    SELECT p.product_name, s.sale_date
    FROM products p
    INNER JOIN sales s ON p.category = s.category;
    
    ```
    
    Neste caso, a junção é feita com base na coluna `category`, não em uma chave primária ou estrangeira.
    
2. **Junção com expressão ou cálculo**:
    - Você também pode usar **expressões** ou **cálculos** na condição de junção. Por exemplo, se você quiser combinar as tabelas `employees` e `departments` com base na diferença entre salários e orçamentos:
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.salary > d.budget;
    
    ```
    
    Aqui, a junção não depende de nenhuma chave, mas de uma **expressão** que compara o `salary` de um funcionário com o `budget` de um departamento.
    
3. **Junção com intervalos de dados (usando BETWEEN)**:
    - Também é possível usar condições como `BETWEEN` para fazer junções:
    
    ```sql
    SELECT e.employee_id, e.name, p.product_name
    FROM employees e
    INNER JOIN products p ON e.salary BETWEEN p.price_min AND p.price_max;
    
    ```
    
    Neste exemplo, a junção é baseada no intervalo de preços dos produtos, não em uma chave primária ou estrangeira.
    
4. **Junção com `NULL` ou valores ausentes**:
    - Você pode até mesmo usar **condições `NULL`** em uma junção, como por exemplo:
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.department_id IS NULL;
    
    ```
    
    Nesse caso, você está unindo as tabelas com base na condição de que o `department_id` de um funcionário seja `NULL`.
    

### Resumo:

- **Junções idênticas (INNER JOIN)** não são restritas a comparações entre **chaves primárias e chaves estrangeiras**. Elas podem ser realizadas com **qualquer coluna** ou **expressão** que tenha valores correspondentes entre as tabelas.
- O uso de **chave primária** e **chave estrangeira** é muito comum porque essas colunas têm a garantia de conter dados únicos (chave primária) ou dados referenciando outros registros (chave estrangeira), facilitando a junção e garantindo a integridade dos dados.
- Mas você pode juntar tabelas de qualquer forma, desde que haja uma condição válida para a comparação entre os valores das colunas envolvidas.

Esses são apenas alguns exemplos para ilustrar a flexibilidade do SQL ao combinar tabelas, e a junção pode ser ajustada para atender a diversos cenários e necessidades de consulta.

---

### existe outros tipos de condições de junção sem ser a identica?

Sim, existem vários tipos de condições de junção além das junções "idênticas" (onde você compara diretamente valores de colunas de duas tabelas). Essas junções podem ser usadas para combinar dados de tabelas com base em diferentes tipos de condições. Aqui estão alguns dos tipos de junção mais comuns em SQL:

### 1. **`INNER JOIN` (Junção Interna)**

- **Descrição:** Retorna apenas as linhas que têm correspondência em ambas as tabelas.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.department_id = d.department_id;
    
    ```
    
- **Outros tipos de condição que você pode usar:**
    - `e.salary > d.budget` (comparando salários e orçamentos)
    - `e.hire_date BETWEEN d.start_date AND d.end_date` (comparando datas)

### 2. **`LEFT JOIN` (ou `LEFT OUTER JOIN`)**

- **Descrição:** Retorna todas as linhas da tabela à esquerda e as linhas correspondentes da tabela à direita. Se não houver correspondência, os resultados da tabela à direita serão `NULL`.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    LEFT JOIN departments d ON e.department_id = d.department_id;
    
    ```
    
- **Outros tipos de condição que você pode usar:**
    - `e.salary > d.budget`
    - `e.hire_date < d.start_date`
    
    Mesmo se não houver correspondência, a consulta ainda retorna todos os registros da tabela `employees` com valores `NULL` para as colunas de `departments`.
    

### 3. **`RIGHT JOIN` (ou `RIGHT OUTER JOIN`)**

- **Descrição:** Retorna todas as linhas da tabela à direita e as linhas correspondentes da tabela à esquerda. Se não houver correspondência, os resultados da tabela à esquerda serão `NULL`.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    RIGHT JOIN departments d ON e.department_id = d.department_id;
    
    ```
    
- **Outros tipos de condição que você pode usar:**
    - `e.hire_date = d.start_date`
    - `e.salary IS NULL`

### 4. **`FULL JOIN` (ou `FULL OUTER JOIN`)**

- **Descrição:** Retorna todas as linhas quando há uma correspondência em uma das tabelas. Se não houver correspondência, a linha será retornada com valores `NULL` para as colunas da tabela sem correspondência.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    FULL JOIN departments d ON e.department_id = d.department_id;
    
    ```
    
- **Outros tipos de condição que você pode usar:**
    - `e.salary <= d.budget`
    - `e.hire_date <> d.start_date`

### 5. **`CROSS JOIN`**

- **Descrição:** Retorna o produto cartesiano de duas tabelas, ou seja, combina todas as linhas da tabela à esquerda com todas as linhas da tabela à direita. Não há condição de junção para essa operação.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, d.department_name
    FROM employees e
    CROSS JOIN departments d;
    
    ```
    
- **Esse tipo de junção não usa condição explícita**, pois ele simplesmente combina todas as linhas de ambas as tabelas. Essa operação é útil quando você quer todas as combinações possíveis de linhas entre as duas tabelas.

### 6. **`SELF JOIN`**

- **Descrição:** Um **self join** é uma junção de uma tabela consigo mesma. Esse tipo de junção é útil quando você precisa comparar linhas dentro da mesma tabela.
- **Exemplo de Condição:**
    
    ```sql
    SELECT e1.employee_id, e1.name, e2.name AS manager_name
    FROM employees e1
    LEFT JOIN employees e2 ON e1.manager_id = e2.employee_id;
    
    ```
    
- **Nesse caso, a tabela `employees` é unida a si mesma**, com a condição de que o `manager_id` de um funcionário deve corresponder ao `employee_id` de outro funcionário, permitindo assim listar os funcionários junto aos seus gerentes.

### 7. **Junções com Condições de Intervalo (`BETWEEN`)**

Em algumas junções, você pode comparar valores em um intervalo. Isso pode ser útil, por exemplo, quando você compara uma data ou um valor numérico com um intervalo de dados.

- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d ON e.salary BETWEEN d.min_salary AND d.max_salary;
    
    ```
    

### 8. **Junções com Expressões Lógicas Complexas**

Você também pode usar **expressões lógicas complexas** dentro das condições de junção, como `AND`, `OR`, ou até mesmo funções como `IS NULL` ou `LIKE`.

- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    INNER JOIN departments d
      ON (e.department_id = d.department_id)
      AND (e.salary > 50000 OR e.hire_date > '2010-01-01');
    
    ```
    

### 9. **Junções com `IS NULL`**

Você pode usar condições para verificar se uma coluna tem um valor `NULL`, o que pode ser útil quando você quer encontrar registros que não possuem dados em uma coluna relacionada.

- **Exemplo de Condição:**
    
    ```sql
    SELECT e.employee_id, e.name, d.department_name
    FROM employees e
    LEFT JOIN departments d ON e.department_id = d.department_id
    WHERE d.department_name IS NULL;
    
    ```
    

Esse exemplo retornaria todos os funcionários que não estão atribuídos a nenhum departamento (onde o valor de `department_name` é `NULL`).

---

### Resumo:

- **Junções padrão**: Como **`INNER JOIN`**, **`LEFT JOIN`**, **`RIGHT JOIN`**, **`FULL JOIN`**, e **`CROSS JOIN`**, que têm suas próprias condições de junção.
- **Junções com condições mais complexas**: Usando **`BETWEEN`**, **`IS NULL`**, **`AND`**, **`OR`**, ou outras expressões lógicas.
- **Self Join**: Quando você une uma tabela a ela mesma.

Cada tipo de junção tem seu propósito, dependendo do tipo de dados e da lógica que você precisa aplicar para combinar as informações das tabelas.

---