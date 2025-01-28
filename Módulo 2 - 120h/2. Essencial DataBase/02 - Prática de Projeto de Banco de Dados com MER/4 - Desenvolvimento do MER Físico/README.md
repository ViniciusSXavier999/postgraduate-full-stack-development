# DESENVOLVIMENTO DO MER FISICO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico1.png" />

💡 O MODELO FISICO É O TERCEIRO NÍVEL (e último nível) DE MODELAGEM QUE A GENTE CONSTRÓI EM UM PROJETO DE BANCO DE DADOS


🏆 JÁ PASSAMOS PELOS MODELOS:

🏆 MODELO CONCEITUAL → Onde a gente representou o mundo real


🏆 MODELO LÓGICO → Onde a gente colocou todas especificações técnicas necessárias para a construção do Banco de Dados

---

📌 É o próprio script de comandos para a criação das estruturas que a gente modelou até o momento, o modelo físico é completamente dependente do SGBD


🔒 O QUE É SGBD?

**SGBD (Sistema Gerenciador de Banco de Dados) é um software que possui diversos mecanismos que garantem⁠:**

**A integridade dos dados**

**O relacionamento entre as estruturas**

**A segurança**

**O controle ao acesso**

**A velocidade no acesso⁠⁠**

**O SGBD é responsável por impor níveis de segurança no banco de dados através da criação de usuários e concessão de privilégios⁠. Ele também garante a consistência e integridade dos dados, por exemplo, garantindo que campos numéricos só aceitem números⁠.**

**Alguns dos principais SGBDs do mercado são⁠:**

**ORACLE**

**MYSQL**

**DB2**

**SQL SERVER**

---

> Em nenhum momento da criação do modelo conceitual e modelo lógico a gente preciso saber qual seria o SGBD (ORCLE, DB2, SQL SERVER), essa informação não é necessária para fazer os dois primeiros níveis de modelagem!!
> 

---

### POR QUE O MODELO FISICO DEPENDE DO SGBD?

🔒 Porque vamos a fazer adaptação dos tipos de dados para os tipos que o SGBD aceita, também é no modelo físico que vamos colocar os scripts dos comandos, que é o que vai permitir a criação dessas estruturas.


🔒 Para fazer o 3 nível de modelagem precisamos definir o SGBD que vamos utilizar


---

## DÚVIDA QUE SURGIU DURANTE A AULA

[o mysql query browser ou mysql workbench são SGBD?](https://pt.stackoverflow.com/questions/269086/o-mysql-query-browser-ou-mysql-workbench-s%C3%A3o-sgbd#:~:text=O%20MySQL%20Server%20%C3%A9%20um,vale%20para%20o%20Query%20Browser)

[Qual a diferença entre SQL Server, MySQL e outros SQL?](https://pt.stackoverflow.com/questions/480913/qual-a-diferen%C3%A7a-entre-sql-server-mysql-e-outros-sql)

---

---

---

🚨 NA DISCIPLINA VAI SER UTILIZADO O SGBD DA ORACLE:

- MYSQL

> É o SGBD mais robusto que a gente tem atualmente e é um dos melhores banco de dados do mundo em TERMOS de:
> 
- Performance
- Desempenho
- Ferramentas
- Possibilidades
- Implementações no projeto
- Suporta grandes bases de dados

---

---

---

🚨 Já que vamos utilizar esse SGBD, temos que nos atentar as regras de nomenclaturas dele:

- Quais nomes que vamos colocar nas tabelas
- Quais caracteres são permitidos e quais não são

## MER - NÍVEL FÍSICO - REGRAS DE NOMENCLATURA

As Regras de nomenclatura, mudam de um SGBD para o outro, mas as principais regras são:

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico2.png" />

> ‘não pode haver objetos com nomes duplicados’ → significa que não podemos ter tabelas com nomes iguais, exemplo: empregados
> 

---

🏆 Outra coisa que devemos determinar no modelo físico é a ordem de criação das tabelas

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico3.png" />


### O QUE É ENTIDADE FORTE E FRACA?

No MySQL,

**uma entidade forte é aquela que possui uma chave primária única e não depende de outra entidade para ser identificada.**

**Já uma entidade fraca é aquela que não tem uma chave primária única e depende de outra entidade para ser identificada**

.

Entidade forte É independente de outras entidades, Possui uma chave primária única, Possui um relacionamento um para muitos.

**Entidade fraca**

- Depende de outra entidade, chamada de entidade proprietária
- Não possui uma chave primária única
- Possui um relacionamento muitos para muitos

**Alguns exemplos de entidades fortes e fracas:**

- Em um sistema de vendas, a entidade produto é forte, enquanto a entidade venda é fraca
- Em um sistema acadêmico, a entidade curso é forte
- Em um sistema de gestão de recursos humanos, a entidade funcionário é forte, enquanto os dependentes do funcionário são fracos

🏆 

### **O que é uma Entidade Forte?**

Uma **entidade forte** (ou independente) é uma entidade que **possui sua própria chave primária**, que a identifica de forma única no banco de dados. Ela não depende de outra entidade para existir.

### **Exemplo Simples de Entidade Forte:**

Imagine uma tabela de **Cliente**:

| **id_cliente** | **nome** | **email** |
| --- | --- | --- |
| 1 | João Silva | [joao@email.com](mailto:joao@email.com) |
| 2 | Ana Costa | [ana@email.com](mailto:ana@email.com) |
- A entidade **Cliente** é forte porque o campo `id_cliente` é a chave primária, identificando cada registro de forma única.
- A tabela **não depende de outras tabelas para existir**.

### **Criação no MySQL:**

```sql
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(100)
);

```

---

### **O que é uma Entidade Fraca?**

Uma **entidade fraca** (ou dependente) é uma entidade que **não possui uma chave primária própria** e depende de outra entidade para existir. Para ser identificada de forma única, ela utiliza uma **chave estrangeira** combinada com outro atributo (ou atributos).

### **Exemplo Simples de Entidade Fraca:**

Imagine uma tabela de **Dependente** (filhos ou dependentes de um cliente):

| **id_dependente** | **id_cliente** | **nome_dependente** |
| --- | --- | --- |
| 1 | 1 | Pedro Silva |
| 2 | 1 | Maria Silva |
| 3 | 2 | Lucas Costa |
- A entidade **Dependente** é fraca porque `id_dependente` sozinho não seria suficiente para identificar o dependente. Ela precisa do `id_cliente` para ser única.
- **Dependente** só existe se houver um **Cliente** correspondente.

### **Criação no MySQL:**

```sql
CREATE TABLE Dependente (
    id_dependente INT,
    id_cliente INT,
    nome_dependente VARCHAR(50),
    PRIMARY KEY (id_dependente, id_cliente), -- Chave composta
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

```

---

### **Diferença Resumida entre Entidade Forte e Fraca:**

| Característica | Entidade Forte | Entidade Fraca |
| --- | --- | --- |
| **Chave Primária** | Possui própria chave | Depende de outra entidade |
| **Independência** | Existe sozinha | Depende de uma entidade forte |
| **Exemplo** | Cliente | Dependente (filho) |

---

---

---

---
💡 Quando o modelo é pequeno a gente até faz: 

- Primeiro as entidades fortes
- Depois as Fracas
- E por fim, as associativas


🏆 Mas quando é necessário a participação em grandes projetos, de grandes modelos, geralmente a gente faz assim:

- Crias as entidades PURAS (somente os atributos e a chave primária)
- E depois que criou todas as tabelas vai adicionando todas as chaves estrangeiras para não ter problema na criação.


---

---

---

## ESTUDO DE CASO FÁBRICA DE AUTO PEÇAS → MER LÓGICO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico4.png" />

💡 Com base no modelo lógico, a gente vai criar o modelo físico 


## GERANDO O MODELO FÍSICO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico5.png" />

💡 PODEMOS NOTAR QUE É O SCRIPT DO COMANDO


> Basta notarmos no modelo lógico a Tabela vendedor
> 

> O tipo ‘varchar2’ é um tipo especifico do Oracle que consegue armazenar até 4 mil caracteres
> 

## MAIS EXEMPLOS DA CRIAÇÃO DO MODELO FISICO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico6.png" />

🏆 GERAR o modelo físico de uma entidade significa criar essas tabelas

---

---

---

## OUTRO EXEMPLO → MODELO LÓGICO DA INDUSTRIA

### ESQUEMA LÓGICO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico7.png" />

> Muitas ferramentas tem a funcionalidade de converter para o modelo físico automaticamente
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico8.png" />

### RESULTADO DA CONVERSÃO COM O SCRIPT DOS COMANDOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_fisico9.png" />

> Alguns ajustes são necessários, nesse caso ele não conseguiu inserir as chaves estrangeiras
>