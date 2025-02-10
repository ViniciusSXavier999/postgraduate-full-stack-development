# 3 → IMPLEMENTAÇÃO DE RESTRIÇÕES DE INTEGRIDADE

🏆 Essas são as famosas ‘constraints’ 


---

## IMPOÉM REGRAS QUE PODEM SER NO NÍVEL DA COLUNA OU NO NÍVEL DA TABELA

- NOT NULL → Não permite que os dados sejam nullos
- UNIQUE → São os valores únicos
- PRIMARY KEY → significa que o campo não pode ser nullo e não pode ter valores repetidos
- FOREIGN KEY → Chave estrangeira, só podem existir valores naquele campo que existem na tabela mãe
- CHECK → Restrição de domínio que significa para restringir os valores que podem constar naquele campo ou pode impor alguma regra de negócio

---

## A RESTRIÇÃO NOT NULL

🏆 Assegura que os valores nulos não sejam permitidos para a coluna

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/restri%C3%A7%C3%B5es1.png" />

> NÃO SÃO ACEITOS NULOS, OU SEJA, O CAMPO É DE PREENCHIMENTO OBRIGATÓRIO
> 

## A RESTRIÇÃO UNIQUE KEY

🏆

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/restri%C3%A7%C3%B5es2.png" />

> UNIQUE KEY SIGNIFICA VALORES ÚNICOS, ou seja, naquele campo não pode haver valores repetidos
> 

> A constraint de UNIQUE aceita nulos, pois nullo não é valor, nullo é ausência de valor.
> 

A **constraint UNIQUE** é usada em bancos de dados para garantir que os valores de uma coluna (ou combinação de colunas) sejam únicos em todas as linhas de uma tabela.

Aqui estão alguns exemplos de como usar a **constraint UNIQUE** em diferentes contextos:

### 1. Criando uma Tabela com UNIQUE

```sql
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    username VARCHAR(50) UNIQUE
);

```

👉 Aqui, os campos `email` e `username` não podem ter valores duplicados.

---

### 2. Adicionando UNIQUE a uma Tabela Existente

```sql
ALTER TABLE usuarios ADD CONSTRAINT unique_email UNIQUE (email);

```

👉 Isso adiciona uma restrição de unicidade à coluna `email` na tabela `usuarios`.

---

### 3. UNIQUE em Múltiplas Colunas

```sql
CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    produto_id INT,
    quantidade INT,
    UNIQUE (cliente_id, produto_id)
);

```

👉 Isso garante que um mesmo `cliente_id` não possa ter mais de um registro com o mesmo `produto_id`.

---

### 4. Usando UNIQUE em uma Constraint Nomeada

```sql
CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(11),
    email VARCHAR(100),
    CONSTRAINT unique_cpf UNIQUE (cpf),
    CONSTRAINT unique_email UNIQUE (email

```


## A RESTRIÇÃO PRIMARY KEY

🏆

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/restri%C3%A7%C3%B5es3.png" />

> Quando a gente quer falar que um campo vai fazer a função de chave primária da tabela
> 

> Quando a gente diz que um campo é a chave primária, esse campo não pode ter valores nullos e nem repetidos
> 

## A RESTRIÇÃO CHECK

🏆

- Define uma condição que cada linha deve satisfazer
- Consultas que se referem a outros valores em outras linhas

> Existe campos que possuem um pré valor já determinado, exemplo: Estado civil, nós não podemos colocar qualquer valor no estado civil, ou é solteiro, casado, viúvo, divorciado, existe um número pré determinado de valores que a gente pode colocar nesse campo.
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/restri%C3%A7%C3%B5es4.png" />

🏆 Exemplo da imagem → O campo deptno só pode ter valores entre 10 e 99


> Essa é uma regra de negócio desta empresa.
> 

## A RESTRIÇÃO FOREIGN KEY

🏆

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/restri%C3%A7%C3%B5es5.png" />

> Serve para estabelecer a chave estrangeira, ela garante o relacionamento entre as tabelas.
> 

> Fazer a chave estrangeira significa identificar com qual tabela a chave estrangeira vai se relacionar, com qual campo de qual tabela ocorrerá essa relação.
> 

🏆 Na imagem estamos fazendo o relacionamento da chave estrangeira da tabela emp com a tabela dept no campo deptno


Uma **chave estrangeira (FOREIGN KEY)** é uma constraint que garante a integridade referencial entre duas tabelas, garantindo que um valor em uma coluna seja válido com base em outra tabela. Aqui estão alguns exemplos de como utilizá-la:

---

### 📌 **1. Criando uma tabela com chave estrangeira**

```sql
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    data_pedido DATE NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

```

✅ Aqui, `cliente_id` na tabela `pedidos` é uma **chave estrangeira** que referencia `id` na tabela `clientes`. Isso significa que `cliente_id` em `pedidos` só pode conter valores que existam na tabela `clientes`.

---

### 📌 **2. Adicionando uma chave estrangeira em uma tabela existente**

Se a tabela já existe e queremos adicionar a chave estrangeira depois:

```sql
ALTER TABLE pedidos
ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id);

```

✅ Isso adiciona a restrição de chave estrangeira após a criação da tabela.

---

### 📌 **3. Chave estrangeira com ação ON DELETE e ON UPDATE**

Podemos definir ações para o que acontece quando um registro referenciado for excluído ou atualizado:

```sql
CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE dependentes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    funcionario_id INT,
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id)
        REFERENCES funcionarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

```

✅ Aqui, se um `funcionario` for deletado, todos os `dependentes` relacionados também serão removidos (**ON DELETE CASCADE**).

✅ Se o `id` do funcionário for alterado, a mudança será propagada para `dependentes` (**ON UPDATE CASCADE**).

---

### 📌 **4. Chave estrangeira envolvendo múltiplas colunas**

Podemos criar uma chave estrangeira composta (que envolve mais de uma coluna):

```sql
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE fornecedores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE fornecimento (
    produto_id INT,
    fornecedor_id INT,
    preco DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (produto_id, fornecedor_id),
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produtos(id),
    CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

```

✅ Aqui, a tabela `fornecimento` estabelece um relacionamento **muitos para muitos** entre `produtos` e `fornecedores`, garantindo que um produto só possa ser registrado se existir na tabela `produtos` e um fornecedor só possa ser registrado se existir em `fornecedores`.

---

### 📌 **5. Removendo uma chave estrangeira**

Caso seja necessário remover a restrição de chave estrangeira:

```sql
ALTER TABLE pedidos DROP CONSTRAINT fk_cliente;

```

✅ Isso remove a restrição `fk_cliente` da tabela `pedidos`.

---



---

---

---

## PRATICANDO NO ORACLE LIVE

### CRIANDO TABELA DISCIPLINA

```sql
create table disciplina (
cod_disc number(3) primary key,
nome_disc varchar2(50) not null,
carga_horaria number(3)
);
```

### CRIANDO TABELA PROFESSOR

```sql
create table professor (
    cod_prof number(5) primary key,
    nome_prof varchar2(100) not null,
    dt_nasc date,
    sexo char(1) check(sexo = 'M' or sexo = 'F' or sexo='O'),
    cpf varchar2(11) unique,
    cod_disc number(3) references disciplina (cod_disc)
)
```

A linha:

```sql
cod_disc NUMBER(3) REFERENCES disciplina (cod_disc)

```

significa que a coluna **`cod_disc`** da tabela onde está sendo declarada é uma **chave estrangeira** que referencia a coluna **`cod_disc`** da tabela **`disciplina`**.

### 🔍 **Explicação por partes:**

1. **`cod_disc NUMBER(3)`** → Declara a coluna `cod_disc` como um número com até 3 dígitos (exemplo: 101, 202, etc.).
2. **`REFERENCES disciplina (cod_disc)`** → Define `cod_disc` como uma **chave estrangeira**, garantindo que qualquer valor inserido nessa coluna deve existir previamente na coluna `cod_disc` da tabela `disciplina`.

### 📝 **Exemplo completo de uso**

Suponha que temos a tabela `disciplina`:

```sql
CREATE TABLE disciplina (
    cod_disc NUMBER(3) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

```

Agora, queremos criar uma tabela `turma` que tenha uma relação com `disciplina`, garantindo que cada turma pertença a uma disciplina válida:

```sql
CREATE TABLE turma (
    cod_turma NUMBER(5) PRIMARY KEY,
    cod_disc NUMBER(3) REFERENCES disciplina (cod_disc),
    semestre VARCHAR(10) NOT NULL
);

```

🔹 Aqui, `cod_disc` na tabela `turma` só poderá ter valores que já existam na tabela `disciplina`.

🔹 Se tentarmos inserir um `cod_disc` em `turma` que não existe na tabela `disciplina`, o banco de dados **não permitirá**.

### 🔥 **Testando a restrição**

### ✅ **Inserindo dados válidos**

```sql
INSERT INTO disciplina (cod_disc, nome) VALUES (101, 'Matemática');
INSERT INTO turma (cod_turma, cod_disc, semestre) VALUES (50001, 101, '2024-1'); -- OK!

```

### ❌ **Tentando inserir um valor inexistente**

```sql
INSERT INTO turma (cod_turma, cod_disc, semestre) VALUES (50002, 999, '2024-1');

```

🛑 **Erro:** `cod_disc` 999 não existe na tabela `disciplina`, então a inserção falha.

---

### 🎯 **Conclusão**

A linha **`cod_disc NUMBER(3) REFERENCES disciplina (cod_disc)`** cria uma **chave estrangeira** que assegura a integridade referencial entre tabelas, impedindo a inserção de valores inválidos. 🚀