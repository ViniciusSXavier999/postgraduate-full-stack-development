# 3 → CRIAÇÃO DE SEQUENCES

🏆 Em outros SGBD´s existe o campo ‘auto-increment’, geralmente é o campo utilizado para fazer a chave primária, ele é um campo que vai incrementando automaticamente.


## A INSTRUÇÃO CREATE SEQUENCE

🏆 Defina uma sequência para gerar números sequenciais automaticamente.


🏆 No oracle, não temos o auto-incremento, e sim a sequence, ela é uma sequência numérica, onde a gente determina:

- Qual o valor de inicio
- Qual o valor do fim
- Qual vai ser o incremento

> É um objeto que está muito mais no nosso controle do que o auto-incremento, pois podemos determinar algumas opções para ele.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences01.png" />

- INCREMENT BY → A gente diz qual vai ser o incremento, se ficar em branco será incrementado de 1 em 1 automaticamente.
- START WITH → É para dizer com qual valor queremos incrementar
- MAXVALUE → Número máximo que aquela sequencia vai chegar
- MINVALUE → Número minímo
- CYCLE → Vamos supor que o valor máximo é 100, quando chegamos no valor 100, caso a sequence não seja cycle, ela vai parar de gerar números. Caso ela seja uma sequence cycle, ela vai voltar para o número e repetir todo o processo.
- CACHE → Podemos dizer: Cache = 20, isso significa que os próximos 20 números gerados já estarão na memória cache, isso faz com que a sequence tenha mais performance na hora de fazer o INSERT.

---

## CRIANDO UMA SEQUÊNCIA

🏆 Crie uma sequência chamada DEPT_DEPTNO para ser usada na chave primária da tabela DEPT


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences02.png" />

---

## CONFIRMANDO SEQUÊNCIAS


🏆 Verifique seus valores de sequência na tabela do dicionário de dados USER_SEQUENCES 


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences03.png" />

> O select serve para que a gente tenha as informações de quais foram as sequencias criadas pelo usuário, o nome, o menor valor, as configurações da sequência em geral
> 

🏆 A coluna LAST_NUMBER exibe o próximo número de sequência disponível.


🏆 No contexto de bancos de dados, especialmente em sistemas como o **Oracle Database**, `USER_SEQUENCES` é uma **view** que contém informações sobre as sequências pertencentes ao usuário atual.

Uma sequência em um banco de dados é um objeto que gera números únicos, geralmente usados para criar valores de chave primária ou para contagens. Elas são incrementadas automaticamente de acordo com uma sequência definida pelo usuário.

A `USER_SEQUENCES` fornece as seguintes informações sobre as sequências do usuário:

1. **SEQUENCE_NAME**: O nome da sequência.
2. **MIN_VALUE**: O valor mínimo que a sequência pode gerar.
3. **MAX_VALUE**: O valor máximo que a sequência pode gerar.
4. **INCREMENT_BY**: O valor pelo qual a sequência é incrementada.
5. **CYCLE_FLAG**: Indica se a sequência "cicla" (volta ao valor mínimo após atingir o valor máximo).
6. **ORDER_FLAG**: Indica se a sequência gera números de forma ordenada.
7. **CACHE_SIZE**: O número de valores de sequência que o banco mantém em cache para melhorar o desempenho.
8. **LAST_NUMBER**: O último número gerado pela sequência.

Em resumo, a `USER_SEQUENCES` permite que um usuário consulte detalhes sobre as sequências que ele criou no banco de dados. Para acessar essas informações, você pode executar uma consulta simples como:

```sql
SELECT * FROM USER_SEQUENCES;
```


---

## USANDO UMA SEQUÊNCIA

> Depois de criar a sequência, como a gente faz para utilizar o número gerado por essa sequência?
> 

🏆 Insira um novo departamento chamado “MARKETING” em San Diego.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences04.png" />

> NEXTVAL é uma pseudocoluna para pegar o valor da próxima sequence
> 

💡

### EXEMPLO UTILIZANDO O NEXT.VAL

Para entender como a tabela ficará após inserir os dados com a função `NEXTVAL`, vamos considerar o exemplo em que estamos inserindo um registro na tabela `usuarios` usando o valor da sequência `minha_sequencia.NEXTVAL` para o campo `id`.

### Suponha que a tabela `usuarios` tenha a seguinte estrutura:

```sql
CREATE TABLE usuarios (
    id NUMBER PRIMARY KEY,  -- Chave primária (gerada pela sequência)
    nome VARCHAR2(100)      -- Nome do usuário
);

```

E a sequência `minha_sequencia` foi criada da seguinte forma:

```sql
CREATE SEQUENCE minha_sequencia
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

```

Neste caso, a sequência começará com o valor 1 e será incrementada de 1 em 1, sem cache e sem ciclo (não volta ao valor inicial após atingir o valor máximo).

Agora, vamos realizar o **INSERT** com o nome "João":

```sql
INSERT INTO usuarios (id, nome)
VALUES (minha_sequencia.NEXTVAL, 'João');

```

### Como ficará a tabela `usuarios` após a execução desse **INSERT**?

A tabela `usuarios` terá uma nova linha inserida, com o campo `id` recebendo o próximo valor da sequência (`minha_sequencia.NEXTVAL`), e o campo `nome` sendo preenchido com "João". Vamos analisar o que acontece passo a passo:

1. O valor de `minha_sequencia.NEXTVAL` gera o primeiro valor da sequência, que é **1**.
2. O valor **1** é inserido na coluna `id`.
3. O valor "João" é inserido na coluna `nome`.

Após o `INSERT`, a tabela `usuarios` ficará assim:

| id | nome |
| --- | --- |
| 1 | João |

### Explicação:

- O campo `id` foi preenchido automaticamente com o próximo valor da sequência, que era **1** no primeiro uso de `NEXTVAL`.
- O campo `nome` foi preenchido com o valor "João", conforme especificado no `INSERT`.

### Caso haja mais inserções:

Se você realizar mais inserções com o `NEXTVAL`, os valores da sequência continuarão a ser incrementados, e o campo `id` terá um número exclusivo para cada linha inserida. Por exemplo:

```sql
INSERT INTO usuarios (id, nome)
VALUES (minha_sequencia.NEXTVAL, 'Maria');

INSERT INTO usuarios (id, nome)
VALUES (minha_sequencia.NEXTVAL, 'Carlos');

```

Agora, a tabela `usuarios` ficaria assim:

| id | nome |
| --- | --- |
| 1 | João |
| 2 | Maria |
| 3 | Carlos |

Cada vez que você chama `minha_sequencia.NEXTVAL`, o valor de `id` é automaticamente incrementado, garantindo que cada registro tenha um identificador único.


🏆 Visualize o valor atual para a sequência DEPT_DEPTNO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences05.png" />

💡

### EXEMPLO UTILIZANDO O CURRVAL

A função **`CURRVAL`** é usada em bancos de dados, como o **Oracle**, para obter o **valor atual** de uma sequência após a execução da função `NEXTVAL`. Enquanto o `NEXTVAL` gera e retorna o próximo valor da sequência, o `CURRVAL` retorna o valor que foi **recentemente gerado** pela sequência na sessão atual.

A principal diferença entre `NEXTVAL` e `CURRVAL` é que **`NEXTVAL`** gera e retorna o próximo valor da sequência, **incrementando** a sequência, enquanto **`CURRVAL`** **não altera a sequência** e simplesmente retorna o valor que foi gerado mais recentemente para a sequência na sessão.

### Sintaxe:

```sql
sequencia_name.CURRVAL

```

### Como funciona:

- O **`CURRVAL`** só pode ser chamado **após** uma invocação de `NEXTVAL na mesma sessão`. Ou seja, a sequência precisa ter gerado pelo menos um valor usando `NEXTVAL` para que `CURRVAL` possa retornar um valor válido.
- **`CURRVAL`** **não** pode ser chamado antes de `NEXTVAL`, pois não há um valor atual da sequência até que o primeiro valor tenha sido gerado.

### Exemplo de uso:

Vamos continuar com o exemplo da sequência `minha_sequencia` que foi criada assim:

```sql
CREATE SEQUENCE minha_sequencia
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

```

E imagine que você tem a tabela `usuarios`:

```sql
CREATE TABLE usuarios (
    id NUMBER PRIMARY KEY,
    nome VARCHAR2(100)
);

```

### Passo 1: Inserindo o primeiro valor com `NEXTVAL`

Primeiro, inserimos um valor na tabela `usuarios`, usando a sequência `minha_sequencia.NEXTVAL`:

```sql
INSERT INTO usuarios (id, nome)
VALUES (minha_sequencia.NEXTVAL, 'João');

```

Aqui, o valor de `id` será **1** (porque `NEXTVAL` gerou o primeiro valor da sequência).

### Passo 2: Usando `CURRVAL`

Agora que o valor foi gerado, podemos usar `CURRVAL` para obter o valor atual da sequência na mesma sessão:

```sql
SELECT minha_sequencia.CURRVAL FROM dual;

```

Isso retornará **1**, que foi o último valor gerado pela sequência.

### Resultado esperado após o uso do `CURRVAL`:

CURRVAL

---

1

---

### Passo 3: Inserindo outro valor

Agora, se você inserir mais um valor na tabela usando `NEXTVAL`, como por exemplo:

```sql
INSERT INTO usuarios (id, nome)
VALUES (minha_sequencia.NEXTVAL, 'Maria');

```

O valor do `id` será **2** (o próximo valor gerado pela sequência).

Agora, se você executar `CURRVAL` novamente:

```sql
SELECT minha_sequencia.CURRVAL FROM dual;

```

O valor retornado será **2**, que é o último valor gerado pela sequência.

### Resumo das diferenças:

- **`NEXTVAL`**: Gera o próximo valor na sequência e o retorna.
- **`CURRVAL`**: Retorna o valor mais recente gerado pela sequência na sessão atual.

**Nota importante**: `CURRVAL` só funciona após a invocação de `NEXTVAL` na mesma sessão. Se você tentar usar `CURRVAL` sem ter usado `NEXTVAL` anteriormente, o banco de dados lançará um erro.


---

## MODIFICANDO UMA SEQUÊNCIA

🏆 Altere o valor de incremento, o valor máximo, o valor mínimo, a opcão de ciclo ou a opção de cache

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences06.png" />


---

## REMOVENDO UMA SEQUÊNCIA

🏆 Remova uma sequência do dicionário de dados usando a instrução DROP SEQUENCE. Após remover a sequência, você não poderá mais fazer referência à ela.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences07.png" />

> O fato de eliminar a sequência não afeta sobre nenhum aspecto os números que já foram inseridos ou manipulados por aquela sequencia em outras tabelas, quando a gente elimina a sequência, a gente elimina aquele objeto que ia gerar os próximos números, os números que foram manipulados em outros objetos não sofre nenhuma influência desse comando DROP SEQUENCE.
> 

---

## PRATICANDO!!!

### CRIANDO UMA CÓPIA DA TABELA DEPT

```sql
create table copia_dept as (select * from scott.dept)
```

🏆

### EXPLICANDO A QUERY

O comando SQL que você forneceu é utilizado para **criar uma nova tabela** baseada nos dados de uma **tabela existente**. Vamos analisar o comando detalhadamente:

```sql
CREATE TABLE copia_dept AS (SELECT * FROM scott.dept);

```

### Explicação passo a passo:

1. **`CREATE TABLE`**:
    - Esta parte do comando é usada para **criar uma nova tabela** no banco de dados. A nova tabela será criada com a mesma estrutura (colunas) e dados definidos pela consulta SQL subsequente.
2. **`copia_dept`**:
    - **`copia_dept`** é o **nome da nova tabela** que será criada.
    - A tabela criada terá a mesma estrutura da tabela `dept` no schema `scott`, pois os dados estão sendo copiados da tabela `dept`.
3. **`AS`**:
    - A palavra-chave **`AS`** indica que a tabela será criada **com base no resultado** de uma consulta SQL (neste caso, um `SELECT`).
    - Em vez de definir explicitamente as colunas e tipos de dados da tabela, a criação da tabela será feita usando os resultados da consulta `SELECT`.
4. **`(SELECT * FROM scott.dept)`**:
    - Esta parte é uma **consulta SQL** que recupera todos os dados da tabela `dept` no schema `scott`.
    - **`SELECT *`** significa **selecionar todas as colunas** da tabela.
    - **`FROM scott.dept`** especifica que os dados serão extraídos da tabela `dept` localizada no schema `scott`.
    
    O que acontece aqui é que a consulta `SELECT * FROM scott.dept` retorna **todos os registros e todas as colunas** da tabela `dept`, e o **`CREATE TABLE`** usa esses dados para criar a nova tabela `copia_dept`.
    

### O que ocorre ao executar o comando:

1. **Criação da nova tabela `copia_dept`**:
    - O banco de dados cria uma nova tabela chamada **`copia_dept`** com a **mesma estrutura** (tipos de dados, colunas) da tabela `dept` de `scott`.
    - Se a tabela `dept` possui as colunas `deptno`, `dname` e `loc`, então a tabela `copia_dept` terá essas mesmas colunas com os mesmos tipos de dados.
2. **Inserção de dados**:
    - Depois que a estrutura da tabela `copia_dept` é criada, o **banco de dados insere os dados** retornados pela consulta `SELECT * FROM scott.dept` na nova tabela.
    - Ou seja, todos os registros da tabela `dept` são copiados para a tabela `copia_dept`.

### Resultado:

Após a execução do comando, a tabela `copia_dept` terá:

- A mesma estrutura (colunas e tipos de dados) que a tabela `dept`.
- Todos os registros que estavam na tabela `dept`.

### Importante:

- **Não** é necessário criar manualmente a estrutura da tabela `copia_dept` (com colunas e tipos de dados específicos). O comando `CREATE TABLE AS` cria a tabela automaticamente com a mesma estrutura da tabela de origem, baseada na consulta `SELECT`.
- **Restrições e índices**: O comando `CREATE TABLE AS` **não** copia restrições (como chaves primárias, chaves estrangeiras, ou índices) da tabela original. Apenas os dados e a estrutura (colunas) são copiados. Se você precisar que a nova tabela tenha as mesmas restrições ou índices, será necessário criá-los manualmente após a criação da tabela.

### Exemplo do que acontece:

Se a tabela original `dept` for algo como:

| deptno | dname | loc |
| --- | --- | --- |
| 10 | ACCOUNT | NEW YORK |
| 20 | RESEARCH | DALLAS |
| 30 | SALES | CHICAGO |

Após a execução do comando `CREATE TABLE copia_dept AS (SELECT * FROM scott.dept);`, a tabela `copia_dept` terá os mesmos dados:

| deptno | dname | loc |
| --- | --- | --- |
| 10 | ACCOUNT | NEW YORK |
| 20 | RESEARCH | DALLAS |
| 30 | SALES | CHICAGO |

Ou seja, a tabela `copia_dept` será uma cópia exata da tabela `dept` no momento em que o comando for executado.

### Resumo:

- O comando cria uma nova tabela com a mesma estrutura e dados da tabela existente (`scott.dept`).
- Ele copia tanto os dados quanto a estrutura (colunas) da tabela original, mas **não copia** as restrições e índices.

### VERIFICANDO SE OS DADOS ESTÃO CORRETOS

```sql
SELECT * FROM copia_dept
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences08.png" />

### CRIANDO UMA SEQUENCE

```sql
CREATE SEQUENCE dept_deptno
start with 42
increment by 2 
maxvalue 90;
```

### AGORA VAMOS USAR ESSA SEQUENCE PARA INSERIR REGISTROS NA TABELA COPIA_DEPT

```sql
INSERT INTO copia_dept VALUES (dept_deptno.nextval, 'Comercial' , 'SP');
```

### OBSERVE QUE APÓS REALIZAR O COMANDO SELECT NOVAMENTE, OS DADOS DA TABELA FORAM REGISTRADOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/sequences09.png" />

> E assim será a cada próxima INSERT utilizando o NEXTVAL, os incrementos serão de acordo com as nossas configurações de sequence
> 

---

🏆

### DIFERENÇA DO USO DA CLÁUSULA “AS”

 O **`AS`** pode ser usado em SQL para **dar apelidos** (ou **alias**) tanto para **tabelas** quanto para **colunas**. No entanto, no comando que você forneceu, o **`AS`** tem uma função um pouco diferente, e vou explicar os dois casos abaixo.

### 1. **`AS` para apelidar colunas ou tabelas:**

Quando usamos o **`AS`** para **apelidar colunas ou tabelas**, ele serve para **dar um nome alternativo** (um "alias") para um campo ou para uma tabela, para tornar a consulta mais legível ou mais concisa.

### Exemplo de alias para colunas:

```sql
SELECT nome AS nome_usuario, idade AS idade_usuario
FROM usuarios;

```

Aqui, **`AS nome_usuario`** e **`AS idade_usuario`** são apelidos para as colunas `nome` e `idade`, respectivamente. Isso é útil, por exemplo, quando você quer dar um nome mais legível ou intuitivo para as colunas, ou quando a coluna tem um nome longo ou técnico.

### Exemplo de alias para tabelas:

```sql
SELECT a.nome, a.idade
FROM usuarios AS a;

```

Aqui, **`AS a`** está criando um apelido para a tabela `usuarios`, e você pode usar esse apelido **`a`** para se referir à tabela nas consultas.

### 2. **`AS` em `CREATE TABLE AS` (como no seu comando)**:

Agora, no comando `CREATE TABLE AS`, o **`AS`** tem uma função diferente. Nesse caso, o **`AS`** **não está criando um apelido para as colunas ou tabelas**. Em vez disso, ele está sendo usado para indicar que a **nova tabela** será criada a partir do **resultado de uma consulta SELECT**.

Vamos detalhar isso:

```sql
CREATE TABLE copia_dept AS (SELECT * FROM scott.dept);

```

- **`CREATE TABLE copia_dept`**: Cria uma nova tabela chamada `copia_dept`.
- **`AS`**: Indica que a tabela será criada com base no resultado de uma consulta `SELECT`.
- **`SELECT * FROM scott.dept`**: Esta consulta seleciona todos os dados da tabela `dept` no schema `scott`.

O **`AS`** aqui está indicando que a tabela `copia_dept` será criada usando o conjunto de dados da consulta `SELECT * FROM scott.dept`. Ou seja, ele está **definindo a estrutura** da nova tabela com base nos dados selecionados pela consulta, e não atribuindo um nome alternativo.

### Conclusão:

- **No comando `CREATE TABLE AS`**: O **`AS`** **não cria alias** para colunas ou tabelas, mas indica que a nova tabela será criada com base em uma consulta `SELECT`. Ele é usado para **criar a nova tabela** a partir do resultado de uma consulta.
- **Em consultas SELECT**: O **`AS`** é usado para **criar aliases** (apelidos) para colunas ou tabelas, facilitando a leitura e compreensão dos dados.

Então, sim, o **`AS`** serve para **apelidar campos**, mas o contexto de uso é diferente no comando `CREATE TABLE AS`, onde ele tem o papel de **definir que a tabela será criada a partir de uma consulta**.

