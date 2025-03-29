# 4 → CRIAÇÃO DE ÍNDICES

## O QUE É UM ÍNDICE?

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices01.png" />

🏆 Vamos pensar no índice como um sumario de um livro.


🏆 Uma tabela que não tem índice a busca pelos registros é uma busca sequencial, ou seja, registro por registro, isso pode acabar sendo lento.

Já quando temos os índices, primeiro a gente busca no índice, e ele aponta diretamente para o registro que estamos buscando, otimizando bastante todo o processo.


🏆 A gente cria a tabela, mas não é obrigado a criar o índice, o índice apenas se baseia na tabela, apenas criamos o índice para deixar as consultas mais rápidas.


---

## CRIANDO UM ÍNDICE

🏆 Crie um índice em uma ou mais colunas.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices02.png" />


🏆 Aumente a velocidade do acesso de consulta na coluna ENAME da tabela EMP.

> EXEMPLO DE COMO CRIAR UM ÍNDICE.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices03.png" />


✅ Algumas constraints já criam os índices automaticamente, quando a gente diz que um campo vai ser a chave primária da tabela, automaticamente já é criado o índice.


✅ Também já é criado o índice quando dizemos que o campo é a chave estrangeira da tabela.


🏆 A GENTE CRIA ÍNDICES PARA TABELAS QUE SOFREM MUITAS CONSULTAS.


---

## QUANDO CRIAR UM ÍNDICE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices04.png" />

---

## CONFIRMANDO ÍNDICES

🏆 A view do dicionário de dados USER_INDEXES contém o nome do índice.


🏆 A view USER_IND_COLUMNS contém os nomes do índice, da tabela e da coluna.


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices05.png" />

🏆

### EXPLICANDO ESSA QUERY

O exemplo que você forneceu é uma consulta SQL que busca **índices** relacionados a uma tabela específica chamada **`EMP`** no schema atual de um usuário no banco de dados. Vamos explicar em detalhes o que cada parte dessa consulta faz:

### A Consulta:

```sql
SELECT index_name
FROM user_indexes
WHERE table_name = 'EMP';

```

### Explicação detalhada:

### 1. **`SELECT index_name`**:

- A parte **`SELECT`** é usada para especificar **quais colunas** você deseja retornar como resultado da consulta. Neste caso, **`index_name`** indica que queremos obter os **nomes dos índices** que estão relacionados a uma tabela específica.

### 2. **`FROM user_indexes`**:

- **`user_indexes`** é uma **view do dicionário de dados** do Oracle, que armazena informações sobre todos os índices no schema do usuário conectado.
    - Essa view contém informações sobre os **índices** que pertencem ao **usuário atual** (ou seja, ao schema onde a consulta está sendo executada).
    - O nome da tabela e o nome do índice, entre outras informações, são armazenados nessa view.

### 3. **`WHERE table_name = 'EMP'`**:

- **`WHERE`** é uma cláusula usada para **filtrar os resultados** de acordo com uma condição.
- **`table_name = 'EMP'`** filtra os índices para mostrar apenas aqueles que estão associados à tabela chamada **`EMP`**.
    - **`EMP`** é o nome da tabela na qual você está interessado.
    - Vale observar que em muitas implementações de bancos de dados, como o **Oracle**, os nomes das tabelas e dos índices são armazenados em **maiúsculas** no dicionário de dados, então `'EMP'` deve ser fornecido em maiúsculas.

### O que a consulta faz:

Esta consulta busca os **nomes dos índices** na tabela **`EMP`**, que está localizada no **schema do usuário atual**. O banco de dados retorna os nomes dos índices que foram definidos na tabela **`EMP`**.

### Exemplo de Saída:

Se a tabela `EMP` tiver os índices `emp_idx1` e `emp_idx2`, o resultado da consulta será algo assim:

INDEX_NAME

---

EMP_IDX1

---

EMP_IDX2

---

### Detalhes adicionais:

- **`user_indexes`**: Essa view só retorna índices do schema do usuário atual (ou seja, os índices das tabelas pertencentes ao usuário conectado). Se você quiser consultar índices em **outros schemas**, deve usar outras views, como **`all_indexes`** (que mostra índices de todos os esquemas que você tem permissão para ver) ou **`dba_indexes`** (que mostra índices de todos os esquemas, mas requer privilégios de administrador).
- **`table_name`**: O nome da tabela é armazenado na view em maiúsculas, então, ao fazer a consulta, sempre coloque o nome da tabela em maiúsculas. Caso contrário, o banco de dados não encontrará a tabela corretamente.

### Resumo:

A consulta **`SELECT index_name FROM user_indexes WHERE table_name = 'EMP';`** serve para listar todos os índices da tabela `EMP` no **schema do usuário atual**. O resultado será uma lista com o nome de cada índice associado à tabela `EMP`.


---

## REMOVENDO UM ÍNDICE

🏆 Remover o índice não afeta a tabela onde aquele índice estava atuando.


🏆

REMOVA UM ÍNDICE DO DICIONARIO DE DADOS.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices06.png" />


🏆 REMOVE O ÍNDICE EMP_ENAME_IDX DO DICIONÁRIO DE DADOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices07.png" />


🏆 PARA ELIMINAR UM ÍNDICE, VOCÊ PRECISA SER O PROPRIETÁRIO DO ÍNDICE OU POSSUIR O PRIVILÉGIO DROP ANY INDEX.


---

## PRATICANDO!!!

### PRIMEIRO VAMOS CRIAR UMA CÓPIA DA TABELA EMP PARA BRINCAR COM OS ÍNDICES

```sql
CREATE TABLE copy_emp as (select * from scott.emp)
```

### VAMOS DAR UM SELECT PARA VER SE ESSA TABELA EMP TEM ALGUM ÍNDICE

```sql
SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLE_NAME='COPY_EMP';
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices08.png" />

> Podemos observar que essa tabela não tem índices associados à ela.
> 

### AGORA VAMOS SUPOR QUE A GENTE FAÇA MUITAS CONSULTAS NO CAMPO ‘ENAME’ DA TABELA EMP, TENDO ISSO EM VISTA, É RECOMENDADO O USO DO ÍNDICE.

> Vamos criar o índice
> 

```sql
create index ename_idx on COPY_EMP(ename);
```

> Podemos observar que o índice foi criado após darmos o comando select.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/indices09.png" />

🏆 As consultas que envolver esse campo vão se tornar mais rápidas e ter mais performance.

```sql
SELECT empno, ename, sal
FROM copy_emp
WHERE ename= "JAMES"
```