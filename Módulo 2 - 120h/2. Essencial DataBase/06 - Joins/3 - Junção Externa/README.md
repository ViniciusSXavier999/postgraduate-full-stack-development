# 3 → JUNÇÃO EXTERNA

🏆 JUNÇÃO EXTERNA → outer join


---

🏆 A junção externa ela é necessária quando a gente tem pelo menos em uma das tabelas algum registro que não se relaciona com a outra tabela


### EXEMPLO:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna1.png" />

💡 Em ambas as tabelas a gente tem a coluna de departamento(DEPTNO) na tabela DEPT a gente tem os departamentos 10, 30, 10, 20 e 40, porém na tabela EMP nenhum funcionário trabalha no departamento 40.

> Quando a gente faz a junção idêntica o departamento 40 não aparece no resultado da query
> 

💡 A questão agora é, o fato do departamento 40 não aparecer na join, significa que 40 não é um departamento? claro que não!, ele continua sendo um departamento, porém no momento não tem funcionários trabalhando nesse departamento em especifico.


💡 A questão é: eu quero que apareça todos os departamentos, os que tem funcionários e OS QUE NÃO TEM também, é ai que entra a junção externa: Quando a gente tem esse tipo de situação, quando tem pelo menos 1 registro de 1 tabela que não se relaciona com a outra, a gente vai precisar construir uma outer join.



---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna2.png" />

---

🏆 A função externa pode ser a esquerda ou a direita, a esquerda e a direita refere-se exatamente a posição da tabela no comando


## LEFT OUTER JOIN

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna3.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna4.png" />

> A imagem acima significa que a gente vai privilegiar os registros da tabela que está a esquerda do comando da palavra JOIN, que no caso é a tabela EMPLOYEES, ou seja, vai ser mostrado todos os funcionários da tabela EMPLOYEES, os que tem departamento e os que não tem também.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna5.png" />

🏆

### EXPLICANDO MELHOR O LETF OUTER JOIN

O **LEFT OUTER JOIN** (ou simplesmente **LEFT JOIN**) é um tipo de operação de junção (join) em bancos de dados relacionais, usada para combinar registros de duas tabelas com base em uma condição de correspondência. A diferença entre o **LEFT OUTER JOIN** e o **INNER JOIN** está no comportamento quando não há correspondência entre os registros das tabelas.

### Como funciona o LEFT OUTER JOIN?

O **LEFT OUTER JOIN** retorna todos os registros da **tabela à esquerda** (a primeira tabela mencionada na consulta), mesmo que não haja correspondência na **tabela à direita** (a segunda tabela mencionada). Se não houver correspondência, os campos da tabela à direita terão o valor **NULL**.

### Sintaxe:

```sql
SELECT coluna1, coluna2, ...
FROM tabela1
LEFT OUTER JOIN tabela2
ON tabela1.coluna = tabela2.coluna;

```

### Exemplo:

Imagina que temos duas tabelas:

**clientes**:

| id_cliente | nome |
| --- | --- |
| 1 | João |
| 2 | Maria |
| 3 | Carlos |

**pedidos**:

| id_pedido | id_cliente | produto |
| --- | --- | --- |
| 101 | 1 | Televisão |
| 102 | 2 | Smartphone |

Se fizermos um **LEFT OUTER JOIN** entre **clientes** e **pedidos**, o SQL seria:

```sql
SELECT clientes.id_cliente, clientes.nome, pedidos.produto
FROM clientes
LEFT OUTER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

```

### Resultado:

| id_cliente | nome | produto |
| --- | --- | --- |
| 1 | João | Televisão |
| 2 | Maria | Smartphone |
| 3 | Carlos | NULL |
- **João** e **Maria** têm pedidos, então as colunas "produto" são preenchidas com o nome do produto.
- **Carlos** não tem pedido registrado, então a coluna "produto" é preenchida com **NULL**.

Em resumo, o **LEFT OUTER JOIN** garante que todos os registros da tabela à esquerda sejam retornados, independentemente de haver ou não correspondência na tabela à direita.

</aside>

---

---

---

## RIGHT OUTER JOIN

🏆 Ela é uma junção externa a direita, ou seja, vamos privilegiar todos os registros da tabela que está a direita do comando da palavra JOIN

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna6.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna7.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna8.png" />

🏆

### EXPLICANDO MELHOR O RIGHT OUTER JOIN

O **RIGHT OUTER JOIN** (ou simplesmente **RIGHT JOIN**) é um tipo de junção (join) em SQL, similar ao **LEFT OUTER JOIN**, mas com uma diferença importante: ele retorna todos os registros da **tabela à direita** (a segunda tabela mencionada na consulta), mesmo que não haja correspondência na **tabela à esquerda** (a primeira tabela mencionada).

### Como funciona o RIGHT OUTER JOIN?

O **RIGHT OUTER JOIN** garante que todos os registros da tabela à direita serão retornados na consulta, independentemente de haver ou não correspondência na tabela à esquerda. Quando não há correspondência, as colunas da tabela à esquerda terão valores **NULL**.

### Sintaxe:

A sintaxe do **RIGHT OUTER JOIN** é similar à do **LEFT OUTER JOIN**:

```sql
SELECT coluna1, coluna2, ...
FROM tabela1
RIGHT OUTER JOIN tabela2
ON tabela1.coluna = tabela2.coluna;

```

### Exemplo de **RIGHT OUTER JOIN**:

Imaginando que temos duas tabelas novamente:

**clientes**:

| id_cliente | nome |
| --- | --- |
| 1 | João |
| 2 | Maria |
| 3 | Carlos |

**pedidos**:

| id_pedido | id_cliente | produto |
| --- | --- | --- |
| 101 | 1 | Televisão |
| 102 | 2 | Smartphone |
| 103 | 4 | Notebook |

Nesse caso, a tabela **pedidos** tem um **id_cliente** 4, que não existe na tabela **clientes**.

Se fizermos um **RIGHT OUTER JOIN** entre **clientes** e **pedidos**, o SQL seria:

```sql
SELECT clientes.id_cliente, clientes.nome, pedidos.produto
FROM clientes
RIGHT OUTER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

```

### Resultado:

| id_cliente | nome | produto |
| --- | --- | --- |
| 1 | João | Televisão |
| 2 | Maria | Smartphone |
| NULL | NULL | Notebook |
- **João** e **Maria** têm pedidos, então as colunas "id_cliente" e "nome" são preenchidas normalmente.
- **Carlos** não tem pedido registrado, mas isso não importa aqui, porque estamos fazendo um **RIGHT OUTER JOIN**, então ele é excluído do resultado.
- **id_cliente = NULL** e **nome = NULL** indicam que o pedido 103 (Notebook) foi feito por um cliente que não existe na tabela **clientes** (id_cliente 4), então as colunas da tabela **clientes** ficam **NULL**.

### Resumo:

O **RIGHT OUTER JOIN** retorna todos os registros da **tabela à direita** (neste caso, **pedidos**), incluindo aqueles que não têm correspondência na **tabela à esquerda** (neste caso, **clientes**). Para os registros sem correspondência, as colunas da tabela à esquerda são preenchidas com **NULL**. É útil quando você deseja garantir que todos os dados da tabela à direita sejam incluídos, independentemente de existirem ou não correspondências na tabela à esquerda.

### Diferença entre LEFT JOIN e RIGHT JOIN:

- **LEFT OUTER JOIN**: Todos os registros da **tabela à esquerda** são retornados, com valores **NULL** nas colunas da tabela à direita quando não há correspondência.
- **RIGHT OUTER JOIN**: Todos os registros da **tabela à direita** são retornados, com valores **NULL** nas colunas da tabela à esquerda quando não há correspondência.

Em termos práticos, muitas vezes você pode usar **LEFT JOIN** ou **RIGHT JOIN** de forma intercambiável, dependendo de qual tabela você deseja garantir que todos os seus registros apareçam, mas a lógica de junção continua a mesma.


---

---

---

## FULL OUTER JOIN

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna9.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna10.png" />

🏆 Nesse caso da FULL OUTER JOIN nós queremos que apareçam todos os registros, TANTO DA TABELA QUE ESTÁ A ESQUERDA QUANTO A TABELA QUE ESTÁ A DIREITA, nós queremos que apareçam todos os empregados e todos os departamentos, os que se relacionam e os que não se relacionam, quando a gente quer privilegiar os dois lados da JOIN, utilizamos o FULL OUTER JOIN 


⚠️ A PALAVRA “OUTER” É OPCIONAL, A GENTE SÓ COLOCA SE A GENTE QUISER. É IGUAL A PALAVRA “INNER” NA JUNÇÃO IDÊNTICA, ELA É OPCIONAL, PARA provocar uma melhor leitura do comando a gente as vezes coloca essas palavras

🏆

### EXPLICANDO DETALHADAMENTE A FULL OUTER JOIN

O **FULL OUTER JOIN** (ou **FULL JOIN**) é um tipo de junção (join) em SQL que combina os comportamentos do **LEFT OUTER JOIN** e do **RIGHT OUTER JOIN**. Ele retorna **todos os registros** de **ambas as tabelas**, **independentemente de haver correspondência entre elas**.

### Como funciona o FULL OUTER JOIN?

- Ele retorna **todos os registros da tabela à esquerda** (tabela 1) e **todos os registros da tabela à direita** (tabela 2).
- Quando não há correspondência entre as tabelas para um registro, o **SQL preenche as colunas da tabela sem correspondência com valores NULL**.

Ou seja, ele garante que:

- Para cada registro da tabela à esquerda, que não tenha correspondência na tabela à direita, as colunas da tabela à direita aparecerão com **NULL**.
- Para cada registro da tabela à direita, que não tenha correspondência na tabela à esquerda, as colunas da tabela à esquerda aparecerão com **NULL**.

### Sintaxe:

A sintaxe para um **FULL OUTER JOIN** é a seguinte:

```sql
SELECT coluna1, coluna2, ...
FROM tabela1
FULL OUTER JOIN tabela2
ON tabela1.coluna = tabela2.coluna;

```

### Exemplo de **FULL OUTER JOIN**:

Vamos usar o mesmo exemplo das tabelas **clientes** e **pedidos**, mas agora, vamos adicionar um cenário onde existem clientes sem pedidos e pedidos feitos por um cliente que não está na tabela de clientes.

**clientes**:

| id_cliente | nome |
| --- | --- |
| 1 | João |
| 2 | Maria |
| 3 | Carlos |

**pedidos**:

| id_pedido | id_cliente | produto |
| --- | --- | --- |
| 101 | 1 | Televisão |
| 102 | 2 | Smartphone |
| 103 | 4 | Notebook |

Note que temos um cliente **Carlos (id_cliente = 3)** sem pedido, e um pedido **id_cliente = 4** (Notebook) que não tem um cliente correspondente na tabela **clientes**.

Agora, vamos realizar um **FULL OUTER JOIN** entre as tabelas **clientes** e **pedidos**:

```sql
SELECT clientes.id_cliente, clientes.nome, pedidos.produto
FROM clientes
FULL OUTER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

```

### Resultado:

| id_cliente | nome | produto |
| --- | --- | --- |
| 1 | João | Televisão |
| 2 | Maria | Smartphone |
| 3 | Carlos | NULL |
| NULL | NULL | Notebook |

### Explicação do resultado:

- **João** e **Maria** têm pedidos correspondentes, então as colunas "id_cliente" e "nome" são preenchidas normalmente com os dados das duas tabelas.
- **Carlos** não tem um pedido, então o campo **produto** é **NULL**.
- O pedido **id_pedido = 103** (Notebook) foi feito por um **id_cliente = 4** que não existe na tabela **clientes**, então os campos **id_cliente** e **nome** são **NULL**.

### Resumo:

O **FULL OUTER JOIN** retorna:

- Todos os registros da tabela à **esquerda** (clientes).
- Todos os registros da tabela à **direita** (pedidos).
- Quando não há correspondência, as colunas da tabela que não tem correspondência ficam **NULL**.

### Diferenças entre os tipos de JOIN:

1. **INNER JOIN**: Retorna apenas os registros que têm correspondência nas duas tabelas.
2. **LEFT OUTER JOIN**: Retorna todos os registros da tabela à esquerda, com **NULL** nas colunas da tabela à direita quando não há correspondência.
3. **RIGHT OUTER JOIN**: Retorna todos os registros da tabela à direita, com **NULL** nas colunas da tabela à esquerda quando não há correspondência.
4. **FULL OUTER JOIN**: Retorna todos os registros das duas tabelas, com **NULL** nas colunas quando não há correspondência de um dos lados.

O **FULL OUTER JOIN** é útil quando você deseja combinar dados de duas tabelas e garantir que não perca nenhum registro de qualquer uma das tabelas, mesmo que não haja correspondência entre elas.


---

## PRATICANDO!!!

⚠️ Vamos realizar uma listagem

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna11.png" />

> Podemos observar que temos a tabela EMPLOYEES e eu estou listando o funcionário GRANT, e esse funcionário não trabalha em departamento nenhum e o código do departamento desse funcionário é nulo
> 

### VAMOS COMEÇAR FAZENDO UMA JOIN PARA ESSE GRANT APARECER

## LEFT OUTER JOIN

> Sempre é recomendado começar pela cláusula “FROM” que é por onde toda JOIN se inicia.
> 

> Vamos trabalhar no schema do usuário HR que é quem tem as tabelas employees e departments
> 

```sql
SELECT e.last_name, d.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM hr.employees e LEFT OUTER JOIN hr.departments d
ON (e.department_id = d.department_id)
```

> A condição de junção acima é pela chave primária e estrangeira, ou seja, quando o código do departamento da tabela employees for igual ao código do departamento da tabela departments
> 

> Vale lembrar que a JOIN que vamos fazer, não é uma JOIN qualquer, É UMA OUTER JOIN(junção externa) e nesse primeiro exemplo é uma junção externa a esquerda, vamos estar privilegiando os dados da tabela employees(tabela que está a esquerda)
> 

!<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna12.png" />

⚠️ Para o resultado ser em ordem alfabética foi utilizado a cláusula ORDER BY na query.


!<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna13.png" />

> Podemos reparar que mesmo com os dados nulos o funcionário GRANT aparece na tabela, isso acontece porque estamos privilegiando a tabela employees, ou seja, todos dados dela serão mostrados
> 

## FAZENDO UMA RIGHT OUTER JOIN

> Observe na imagem abaixo, estamos vendo quais funcionários tem departamento (em verde), perceba que temos funcionários até o departamento 110, após isso não encontramos mais funcionários, mas nós temos outros departamentos (como podemos observar em azul), eles só não tem funcionário, mas EXISTEM.
> 

!<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna14.png" />

💡 Nós queremos criar uma JOIN que dê privilégios para os departamentos


```sql
SELECT e.last_name, d.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM hr.employees e RIGHT OUTER JOIN hr.departments d
ON (e.department_id = d.department_id)
```

> Podemos notar que os comandos são os mesmos, o que muda é somente de LEFT para RIGHT JOIN.
> 

💡 Fazendo uma junção externa a direita.

!<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna15.png" />

> Observe que mesmo com departamentos sem funcionário, os registros são mostrados, esse é o resultado de uma RIGHT OUTER JOIN(JUNÇÃO A ESQUERDA).
> 

## FAZENDO UMA FULL OUTER JOIN

```sql
SELECT e.last_name, d.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM hr.employees e RIGHT OUTER JOIN hr.departments d
ON (e.department_id = d.department_id)
```

> Observe que o comando é o mesmo, muda somente para a cláusula FULL
>

!<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oExterna16.png" />