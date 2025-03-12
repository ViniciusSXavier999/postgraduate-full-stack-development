# 4 → AUTOJUNÇÃO

💡 AUTOJUNÇÃO → É quando a gente tem a necessidade de implementar o auto relacionamento, ou seja, a tabela se relacionando com ela mesmo, é como se nós tivéssemos duas tabelas, mas o que acontece é que os dados que a gente esta querendo consultar estão na mesma tabela.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o1.png" />

### TABELA EMP

- EMPNO → CÓDIGO DO FUNCIONÁRIO
- ENAME → NOME DO FUNCIONÁRIO
- MGR → CÓDIGO DO GERENTE

> A gente tem as informações de quem é o funcionário e de quem é o gerente na mesma tabela
> 

### EXEMPLO:

🏆 VAMOS SUPOR QUE EU QUEIRA SABER QUEM É O GERENTE DO FUNCIONÁRIO BLAKE:

- PRIMEIRO VAMOS NA TABELA EMP PARA BUSCAR O FUNCIONÁRIO BLAKE E O CÓDIGO DO GERENTE DELE
- O CÓDIGO DO GERENTE DO FUNCIONÁRIO BLAKE É 7839

> E depois? onde vamos para descobrir qual é o nome do funcionário 7839? NA MESMA TABELA EMP, no caso é o funcionário KING (GERENTE TAMBÉM UM FUNCIONÁRIO)
> 

🏆 Nós temos na mesma tabela todos os registros dos funcionários e nós temos o cadastro dos gerentes, sendo que o gerente também é um funcionário.

🏆 Para mostrar em uma mesma consulta o nome do funcionário e o gerente desse funcionário, a gente vai precisar fazer uma auto-junção(auto-JOIN) que se trata de uma junção com ela mesma.


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o2.png" />

🏆 Observe que na imagem a tabela está dividida em dois, 1 É A TABELA DO FUNCIONÁRIO E A 2 DO GERENTE, mas essas duas informações de quem é funciona´rio e quem é gerente estão na mesma tabela, que é a tabela EMP


💡 QUANDO O CAMPO ‘MGR’ FOR IGUAL AO CAMPO ‘EMPNO’ É A NOSSA CONDIÇÃO DE JUNÇÃO

💡

### EXPLICANDO MELHOR UMA AUTO-JOIN

Uma **auto-junção** (ou **auto-join**) é uma técnica no SQL onde uma tabela é unida com ela mesma. Isso é útil quando você precisa comparar linhas dentro de uma mesma tabela, como, por exemplo, quando você tem relações hierárquicas ou precisa comparar registros relacionados entre si.

Vamos entender passo a passo o conceito de auto-junção.

### Passo 1: Compreender a Tabela

Imagina que temos uma tabela chamada `empregados`, onde cada registro representa um empregado e tem, entre outros campos, o campo `id` (identificador único) e o campo `supervisor_id`, que indica o ID do supervisor direto de cada empregado.

Exemplo da tabela `empregados`:

| id | nome | supervisor_id |
| --- | --- | --- |
| 1 | João | NULL |
| 2 | Maria | 1 |
| 3 | Pedro | 1 |
| 4 | Ana | 2 |
| 5 | Carlos | 2 |

Neste exemplo, João é o supervisor de Maria e Pedro, e Maria é a supervisora de Ana e Carlos.

### Passo 2: Entender o Objetivo da Auto-Junção

Queremos, por exemplo, listar o nome de cada empregado e o nome do seu supervisor. Para isso, usamos uma auto-junção na tabela `empregados` para combinar as informações do empregado com as informações do seu supervisor (que também está na tabela `empregados`).

### Passo 3: Escrever a Consulta SQL

Para fazer a auto-junção, vamos **dar apelidos** à tabela para diferenciá-la em duas instâncias. Uma instância representará os empregados e a outra representará os supervisores.

A consulta ficaria assim:

```sql
SELECT e.nome AS empregado, s.nome AS supervisor
FROM empregados e
LEFT JOIN empregados s ON e.supervisor_id = s.id;

```

**Explicação do código:**

- **`FROM empregados e`**: Esta é a primeira instância da tabela `empregados`, que estamos chamando de `e` (de "empregado").
- **`LEFT JOIN empregados s`**: Estamos fazendo uma junção à esquerda (LEFT JOIN) da tabela `empregados` novamente, mas agora estamos dando a ela um alias de `s` (de "supervisor").
- **`ON e.supervisor_id = s.id`**: Esta é a condição de junção. Estamos dizendo que a coluna `supervisor_id` da instância `e` (empregado) deve corresponder à coluna `id` da instância `s` (supervisor).
- **`SELECT e.nome AS empregado, s.nome AS supervisor`**: Seleciona os nomes dos empregados e seus respectivos supervisores.

### Passo 4: Analisando o Resultado

A consulta retornará algo assim:

| empregado | supervisor |
| --- | --- |
| João | NULL |
| Maria | João |
| Pedro | João |
| Ana | Maria |
| Carlos | Maria |
- **João** não tem supervisor (por isso `NULL`).
- **Maria** e **Pedro** têm João como supervisor.
- **Ana** e **Carlos** têm Maria como supervisora.

### Passo 5: Tipos de Junção Usados

Na auto-junção, você pode usar diferentes tipos de junções, dependendo do que você quer mostrar:

1. **`INNER JOIN`**: Retorna apenas os empregados que têm supervisores (não inclui empregados sem supervisor).
    
    ```sql
    SELECT e.nome AS empregado, s.nome AS supervisor
    FROM empregados e
    INNER JOIN empregados s ON e.supervisor_id = s.id;
    
    ```
    
2. **`LEFT JOIN` (ou `LEFT OUTER JOIN`)**: Retorna todos os empregados, incluindo aqueles que não têm supervisor (o supervisor será `NULL` nesse caso).
    
    ```sql
    SELECT e.nome AS empregado, s.nome AS supervisor
    FROM empregados e
    LEFT JOIN empregados s ON e.supervisor_id = s.id;
    
    ```
    
3. **`RIGHT JOIN` (ou `RIGHT OUTER JOIN`)**: Retorna todos os supervisores, incluindo aqueles que não têm empregados. (Normalmente, em uma auto-junção de uma tabela onde a tabela está bem estruturada, o `LEFT JOIN` é mais comum, mas você pode usar o `RIGHT JOIN` se quiser garantir que todos os supervisores sejam retornados, mesmo sem empregados).
    
    ```sql
    SELECT e.nome AS empregado, s.nome AS supervisor
    FROM empregados e
    RIGHT JOIN empregados s ON e.supervisor_id = s.id;
    
    ```
    

### Conclusão

A auto-junção no SQL permite que você trate uma tabela como se ela fosse duas, o que é útil quando você precisa comparar ou relacionar dados dentro da mesma tabela. Ela é especialmente útil para estruturas hierárquicas, como a relação entre supervisores e subordinados, como vimos no exemplo acima.


---

## UNINDO UMA TABELA A ELA MESMA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o3.png" />

> Podemos reparar que o nome da tabela é o mesmo.
> 

### RESULTADO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o4.png" />

---

---

## PRATICANDO!!

> Vamos utilizar o SCHEMA do usuário SCOTT
> 

### REALIZANDO CONSULTA PARA VISUALIZAR OS DADOS DA TABELA

```sql
SELECT empno, ename, mgr
FROM scott.emp;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o5.png" />

### AGORA VAMOS REALIZAR A AUTO-JUNÇÃO

> Como boas práticas sempre começar a JOIN pela cláusula FROM
> 

💡 Sempre ressaltar que JOIN é a condição da query


```sql
SELECT funcionario.ename || ' trabalha para ' ||  gerente.ename " FUNCIONARIOS E GERENTES "
FROM scott.emp funcionario JOIN scott.emp gerente
ON (gerente.empno = funcionario.mgr)

```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autoJun%C3%A7%C3%A3o6.png" />

---

## IMPORTANTE!!!!

⚠️ Se os apelidos de tabelas foram definidos, é necessário usar esses apelidos em todas as outras cláusulas.


---