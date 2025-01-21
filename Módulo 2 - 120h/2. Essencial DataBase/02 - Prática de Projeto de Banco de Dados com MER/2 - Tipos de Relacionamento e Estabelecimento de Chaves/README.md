# 2 → TIPOS DE RELACIONAMENTO E ESTABELECIMENTO DE CHAVES

> Quando a gente faz o projeto de Banco de dados, começando pelo modelo conceitual, é comum a gente colocar:
> 
- Entidade
- Atributos
- Relacionamento

🏆 E a outra coisa que precisamos colocar já no modelo conceitual é a cardinalidade dos relacionamentos.


> Para estabelecer essa cardinalidade nos relacionamentos a gente precisa entender como essas entidades se relacionam no negócio e ai vai representar esse relacionamento no modelo conceitual.
> 

---

## O QUE É CARDINALIDADE?

💡 A cardinalidade significa: quantas vezes a entidade A se relaciona no mínimo e no máximo com a entidade B e vice e versa


🏆

**Cardinalidade** em bancos de dados refere-se à natureza das relações entre entidades em um modelo de dados. Ela descreve quantas ocorrências de uma entidade podem estar associadas a ocorrências de outra entidade em uma relação. Isso é fundamental para entender como as tabelas se relacionam em um banco de dados relacional.

### Tipos de Cardinalidade

1. **1:1 (Um para Um)**
    
    Cada registro em uma tabela está associado a no máximo um registro em outra tabela e vice-versa.
    
    - **Exemplo**:
    Uma tabela de usuários e uma tabela de documentos de identificação, onde cada usuário tem um único documento e cada documento pertence a apenas um usuário.
2. **1:N (Um para Muitos)**
    
    Um registro em uma tabela pode estar associado a vários registros em outra tabela, mas cada registro na segunda tabela está associado a apenas um registro na primeira.
    
    - **Exemplo**:
    Uma tabela de clientes e uma tabela de pedidos, onde um cliente pode ter muitos pedidos, mas cada pedido pertence a apenas um cliente.
3. **N:M (Muitos para Muitos)**
    
    Muitos registros em uma tabela podem estar associados a muitos registros em outra tabela. Geralmente, isso requer uma tabela intermediária (tabela de junção) para gerenciar as associações.
    
    - **Exemplo**:
    Uma tabela de alunos e uma tabela de cursos, onde um aluno pode se inscrever em vários cursos, e cada curso pode ter vários alunos.

### Exemplos Práticos

- **1:1**:
    
    ```sql
    CREATE TABLE Usuario (
        id INT PRIMARY KEY,
        nome VARCHAR(50)
    );
    
    CREATE TABLE Documento (
        id INT PRIMARY KEY,
        numero VARCHAR(20),
        usuario_id INT UNIQUE,
        FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
    );
    
    ```
    
- **1:N**:
    
    ```sql
    CREATE TABLE Cliente (
        id INT PRIMARY KEY,
        nome VARCHAR(50)
    );
    
    CREATE TABLE Pedido (
        id INT PRIMARY KEY,
        data DATE,
        cliente_id INT,
        FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
    );
    
    ```
    
- **N:M**:
    
    ```sql
    CREATE TABLE Aluno (
        id INT PRIMARY KEY,
        nome VARCHAR(50)
    );
    
    CREATE TABLE Curso (
        id INT PRIMARY KEY,
        nome VARCHAR(50)
    );
    
    CREATE TABLE AlunoCurso (
        aluno_id INT,
        curso_id INT,
        PRIMARY KEY (aluno_id, curso_id),
        FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
        FOREIGN KEY (curso_id) REFERENCES Curso(id)
    );
    
    ```
    

### Por que a Cardinalidade é Importante?

- Garante a integridade referencial no banco de dados.
- Facilita a criação de consultas eficientes.
- Ajuda no design lógico e físico do banco de dados para refletir os requisitos de negócios.

---

---

---

## TIPOS DE ATRIBUTOS CHAVES QUE A GENTE PODE TER EM UMA ENTIDADE

### CHAVE PRIMÁRIA


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP1.png" />

🏆 Serve para gente localizar registros dentro de uma tabela


🏆

**Chave primária (Primary Key)** é um atributo ou um conjunto de atributos em uma tabela de banco de dados que identifica de forma **única** cada registro (linha) dessa tabela.

### Características da Chave Primária:

1. **Unicidade**: Cada valor na chave primária deve ser único, garantindo que não existam dois registros com a mesma chave.
2. **Não nulo**: A chave primária não pode conter valores nulos, pois sempre deve identificar um registro.
3. **Imutável**: O valor da chave primária raramente deve ser alterado, pois é o identificador principal do registro.

### Exemplo Simples

Imagine uma tabela de usuários:

| **id** | **nome** | **email** |
| --- | --- | --- |
| 1 | João Silva | [joao@email.com](mailto:joao@email.com) |
| 2 | Ana Costa | [ana@email.com](mailto:ana@email.com) |
| 3 | Pedro Lima | [pedro@email.com](mailto:pedro@email.com) |
- **Chave Primária**: A coluna `id` é a chave primária, pois identifica de forma única cada usuário.

### Criação em SQL:

```sql
CREATE TABLE Usuario (
    id INT PRIMARY KEY, -- Define a chave primária
    nome VARCHAR(50),
    email VARCHAR(100)
);

```

### Por que é Importante?

- Garante que os registros sejam únicos e facilmente localizáveis.
- Facilita a criação de relações entre tabelas, como ao referenciar a chave primária em outra tabela como uma **chave estrangeira**.

### CHAVE PRIMÁRIA COMPOSTA OU SUPERCHAVE


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP2.png" />

🏆 Vamos entender a **chave primária composta** com um exemplo bem simples e detalhado.

### Cenário: Loja de Produtos

Imagine que temos uma tabela chamada **PedidoProduto**, que registra os produtos incluídos em cada pedido em uma loja. Os campos dessa tabela são:

- **pedido_id**: o identificador único do pedido.
- **produto_id**: o identificador único do produto.
- **quantidade**: a quantidade do produto naquele pedido.

Agora, veja um exemplo de dados:

| **pedido_id** | **produto_id** | **quantidade** |
| --- | --- | --- |
| 1 | 101 | 2 |
| 1 | 102 | 1 |
| 2 | 101 | 3 |
| 2 | 103 | 4 |

### Problema:

- **`pedido_id`** sozinho não é suficiente para identificar de forma única um registro, porque um mesmo pedido pode ter vários produtos.
- **`produto_id`** sozinho também não é suficiente, porque o mesmo produto pode aparecer em diferentes pedidos.

No entanto, **a combinação de `pedido_id` e `produto_id` identifica de forma única** cada linha da tabela.

### Solução: Chave Primária Composta

Usamos os campos **`pedido_id` e `produto_id` juntos como uma chave primária composta**, porque essa combinação garante a unicidade de cada registro.

### Criação em SQL:

```sql
CREATE TABLE PedidoProduto (
    pedido_id INT,
    produto_id INT,
    quantidade INT,
    PRIMARY KEY (pedido_id, produto_id) -- Chave primária composta
);

```

---

### Como Funciona na Prática:

- O registro `(1, 101)` significa "No pedido 1, o produto 101 foi pedido."
- O registro `(1, 102)` significa "No pedido 1, o produto 102 foi pedido."
- O registro `(2, 101)` significa "No pedido 2, o produto 101 foi pedido."

Assim, cada combinação de `pedido_id` e `produto_id` é única e identifica exatamente um registro.

---

Se precisar de mais explicações ou outro exemplo, posso ajudar! 😊


🏆 Em uma tabela existe apenas 1 chave primária, sendo que essa função de chave primária pode ser exercida por 1 ou mais campos, quando ela é exercida por mais de um campo, ela é chamada de chave composta


🏆 A chave primária pode ser simples ou composta, a forma mais comum é ela ser simples


### CHAVE ESTRANGEIRA


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP3.png" />

🏆

### **O que é uma Chave Estrangeira (Foreign Key)?**

Uma **chave estrangeira** é um campo (ou conjunto de campos) em uma tabela que serve para criar um vínculo com a **chave primária** de outra tabela. Ela estabelece uma **relação** entre as tabelas, garantindo a **integridade referencial** no banco de dados.

### **Por que usar Chaves Estrangeiras?**

- Para **conectar tabelas** de forma lógica.
- Para garantir que um registro em uma tabela só possa existir se houver um registro correspondente na outra tabela.
- Para evitar inconsistências nos dados.

---

### **Exemplo Simples**

Imagine um banco de dados com duas tabelas: **Cliente** e **Pedido**.

1. **Tabela Cliente**:
    - Armazena informações sobre os clientes.
    - **Chave Primária**: `id` (identificador único do cliente).
    
    | **id** | **nome** |
    | --- | --- |
    | 1 | João Silva |
    | 2 | Ana Costa |
2. **Tabela Pedido**:
    - Armazena informações sobre os pedidos realizados por clientes.
    - **Chave Estrangeira**: `cliente_id`, que faz referência ao campo `id` da tabela Cliente.
    
    | **id** | **cliente_id** | **data_pedido** |
    | --- | --- | --- |
    | 101 | 1 | 2025-01-15 |
    | 102 | 2 | 2025-01-16 |
    | 103 | 1 | 2025-01-17 |

---

### **Como Funciona?**

- O campo `cliente_id` na tabela **Pedido** é a **chave estrangeira** que se conecta ao campo `id` na tabela **Cliente**.
- Isso significa que cada pedido deve estar associado a um cliente válido. Por exemplo:
    - O pedido com `id = 101` pertence ao cliente com `id = 1` (João Silva).
    - O pedido com `id = 102` pertence ao cliente com `id = 2` (Ana Costa).

Se tentarmos inserir um registro na tabela **Pedido** com um `cliente_id` que não existe na tabela **Cliente**, o banco de dados não permitirá (caso a integridade referencial esteja habilitada).

---

### **Criação em SQL**

### Tabela Cliente:

```sql
CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    nome VARCHAR(50)
);

```

### Tabela Pedido:

```sql
CREATE TABLE Pedido (
    id INT PRIMARY KEY,
    cliente_id INT,
    data_pedido DATE,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) -- Chave estrangeira
);

```

---

### **Resumo**

1. A **chave primária** na tabela **Cliente** é `id`.
2. A **chave estrangeira** na tabela **Pedido** é `cliente_id`, que aponta para o campo `id` da tabela **Cliente**.
3. A relação entre as tabelas é **1:N (Um para Muitos)**:
    - Um cliente pode fazer muitos pedidos.
    - Cada pedido pertence a apenas um cliente.

Se precisar de mais exemplos ou explicações, é só avisar! 😊


🏆 Ela serve para estabelecer o relacionamento entre as tabelas, quando a gente estabelece esse relacionamento é que vem a importância de saber a cardinalidade entre esses relacionamentos, a chave estrangeira sempre fica do lado do N.


---

---

---

## PARA QUE SERVE A CHAVE PRIMÁRIA?

### Quanto ganha o josé?


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP4.png" />

> Nesse exemplo nós temos 2 funcionários que se chamam José, ou seja, dados repetidos, esse acaba sendo o problema e á ai que entra a chave primária, ela serve como uma forma de identificar o determinado josé, dessa forma não perdemos o dado.
> 

🏆 Solução do problema com a chave primária(primary key) denominada ‘cod_func’ 


### Quanta ganha o José, de código 1002?


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP5.png" />

> Quando temos a chave primária, não existe margem para dúvidas, dessa forma conseguimos identificar única e exclusivamente o registro dentro da tabela, é por isso que todas as tabelas tem que ter uma chave primária, que é um mecanismo para achar dados dentro da tabela de forma única e assertiva.
> 

---

## ESTABELECIMENTO DE CARDINALIDADE DO RELACIONAMENTO

🏆 Identificar a cardinalidade do relacionamento entre as tabelas é fundamental para determinar a localização da chave estrangeira, lembrando que a chave estrangeira sempre fica do lado do “n”.

Para essa tarefa vamos analisar o exemplo das tabelas Empregado e Departamento


🏆 Essa é uma regra que devemos ter em mente, a chave estrangeira sempre fica do lado do “n”


### TABELAS EMPREGADOS E DEPARTAMENTO


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP6.png" />

❓ Olhando para as tabelas da forma que ela está agora, não seria possível por exemplo responder qual o departamento onde o funcionário 1002 trabalha.

> As tabelas inicialmente estão relacionadas apenas por força do negócio pois, o departamento possui empregados, e o empregado trabalha no departamento, essas tabelas estão relacionadas por força do negócio, aliás o negócio funciona dessa forma.
> 

🏆 A gente não consegue dizer porque a chave estrangeira não foi estabelecida, essa é a principal função da chave estrangeira, estabelecer o relacionamento entre as tabelas.


🏆 A gente analisa o negócio, depois de ver como esse negócio funciona, a gente entende qual a relação que existe entre entidade A e entidade B para dizer qual é a cardinalidade do relacionamento entre as tabelas.



<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP7.png" />

---

---

---

🏆 Essa é uma técnica de IDA e VOLTA, vamos ver o significado a seguir: 


## SENTIDO DA LEITURA DO RELACIONAMENTO → IDA


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP8.png" />

> Significa ler o relacionamento no sentido da IDA → QUE É DA ENTIDADE A PARA ENTIDADE B
> 

> Ler o relacionamento no sentido da VOLTA → DA ENTIDADE B PARA ENTIDADE A
> 

## SENTIDO DA LEITURA DO RELACIONAMENTO → VOLTA


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP9.png" />

“N empregados” → Quer dizer “MUITOS empregados”

🏆 Quando utilizamos a palavra “MUITOS” a gente substitui pelo N 


> Dessa forma fazendo no sentido da IDA e da VOLTA a gente consegue estabelecer a cardinalidade do relacionamento.
> 

> Lembrando que a chave estrangeira fica do lado de ‘N’
> 

---

## ESTABELECENDO O RELACIONAMENTO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP10.png" />

### Explicação dessa cardinalidade com o exemplo acima

Esse relacionamento descreve uma **relação entre empregados e departamentos** em um banco de dados, que pode ser representado por uma **cardinalidade** de **1:N (um para muitos)**, com algumas restrições.

### **Analisando o relacionamento:**

1. **Empregado:**
    - **"No mínimo trabalha em 1 departamento e no máximo em 1 departamento"**:
        - Isso significa que todo empregado **deve obrigatoriamente estar associado a um departamento**. Não pode existir um empregado sem departamento.
        - Além disso, cada empregado só pode estar associado a **um único departamento por vez**.
2. **Departamento:**
    - **"No mínimo tem 0 empregados e no máximo N empregados"**:
        - Um departamento pode existir **sem ter empregados associados** (por exemplo, um departamento recém-criado ou que ainda não tem equipe alocada).
        - Um departamento pode ter **um número ilimitado de empregados**.

---

### **Relação e Motivo**

Este cenário modela uma estrutura organizacional comum em empresas:

- **Relação**: **1:N (Um para Muitos)**:
    - Um **departamento** pode ter muitos **empregados**.
    - Um **empregado** pertence a exatamente um **departamento**.
- **Motivo**: Essa estrutura é prática porque reflete uma hierarquia comum:
    - Cada empregado é atribuído a um departamento específico (claro e organizado).
    - Departamentos podem existir mesmo sem equipe, permitindo planejamento ou alocação futura.

---

### **Exemplo Prático em SQL**

### Tabela Departamento:

```sql
CREATE TABLE Departamento (
    id INT PRIMARY KEY,
    nome VARCHAR(50)
);

```

### Tabela Empregado:

```sql
CREATE TABLE Empregado (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    departamento_id INT NOT NULL, -- Sempre associado a um departamento
    FOREIGN KEY (departamento_id) REFERENCES Departamento(id)
);

```

---

### **Regras Implementadas:**

1. **Empregado**:
    - Cada empregado está associado a um `departamento_id` obrigatório (no mínimo 1 departamento).
    - A restrição de chave estrangeira garante que o departamento referenciado exista.
2. **Departamento**:
    - Um departamento pode existir sem empregados (não é obrigatório que um departamento tenha empregados associados).
    - Pode ter múltiplos empregados associados.

Essa modelagem mantém a integridade e reflete um sistema de gestão de funcionários e departamentos.

---

---

---

## EXEMPLO DE RELACIONAMENTO 1:1


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP11.png" />

> Geralmente quando o relacionamento é 1:1 a gente coloca a chave estrangeira do lado de “quem tem”, exemplo:
> 
- QUEM TEM o plano de ensino é a disciplina
- QUEM TEM a cnh é a pessoa

## EXEMPLO DE RELACIONAMENTO 1:N ou N:1


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP12.png" />

## EXEMPLO DE RELACIONAMENTO N:M


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/TP13.png" />

> Nesse relacionamento a gente cria a entidade associativa
> 

🏆 Nesse caso ficou N para os dois lados, por isso foi necessário criar a entidade associativa chamada AULA, e a leitura ficará da seguinte forma:

- A disciplina tem muitas AULAS
- O professor ministra MUITAS AULAS

> A entidade associativa é formada pelas chaves primárias das duas outras entidades, que vem para essa entidade como chaves estrangeiras e a junção forma a chave primária composta.
>