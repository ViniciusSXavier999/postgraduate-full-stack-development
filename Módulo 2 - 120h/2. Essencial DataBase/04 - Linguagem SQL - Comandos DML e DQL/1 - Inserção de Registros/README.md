# 1 → INSERÇÃO DE REGISTROS

🏆 COMANDOS DML E DQL


🏆 ADIÇÃO DE REGISTROS NAS TABELAS


---

## O QUE É DML?

🏆 DML → DATA MANIPULATION LANGUAGE → **LINGUAGEM DE MANIPULAÇÃO DE DADOS**

> São os comandos que permitem e fazem parte da categoria de comandos DML
> 
- Inserir registros (INSERT)
- Atualizar registros (UPDATE)
- Excluir registros (DELETE)
    
    <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados1.png" />
    

---

## ADICIONANDO UMA NOVA LINHA EM UMA TABELA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados2.png" />

> Foi adicionado através do comando insert os valores ‘50’ e ‘DEVELOPMENT’
> 

## A INSTRUÇÃO INSERT → INSERINDO REGISTROS (DADOS) NA TABELA

 
<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados3.png" />

> Lembrando que o que está entre [] é opcional, então podemos ou não colocar o nome das colunas dependendo do insert que queremos fazer
> 

---

---

---

## PRATICANDO

### CRIANDO A TABELA DEPT

```sql
create table dept (
    deptno number(2, 0) primary key,
    dname varchar2(100),
    loc varchar2(100)
);
```

🏆 SE DERMOS O COMANDO:

```sql
SELECT * FROM
```

RECEBEREMOS O ERRO ‘NO DATA FOUND’ POIS NÃO EXISTE NENHUM REGISTRO (DADO) NA TABELA


### INSERINDO DADOS NA TABELA (FORMA MAIS COMPLETA PODE SE DIZER)

```sql
insert into dept (deptno, dname, loc)

values (10, 'comercial', 'São paulo');
```

🏆 Primeiro vamos colocar os campos que queremos inserir os valores e em seguida atribuir os valores na mesma ordem que colocamos os campos


🏆 AGORA CASO A GENTE EXECUTE O COMANDO

```sql
SELECT * FROM
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados4.png" />


### OUTRA FORMA DE FAZER O INSERT

```sql
INSERT INTO DEPT VALUES (20, 'FINANCEIRO', 'RIO DE JANEIRO')
```

> Dessa forma a gente insere registros sem listar os campos
> 

🏆 Para fazer dessa forma a gente precisa colocar os valores na ordem em que as colunas estão dispostas na tabela

- DEPTNO
- DNAME
- LOC

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados5.png" />

### OUTRA FORMA DE TRABALHAR COM O INSERT É QUANDO QUEREMOS INSERIR NULLOS NA TABELA

```sql
INSERT INTO DEPT VALUES (30, 'DIRETORIA',)
```

> QUANDO EU NÃO LISTO O CAMPO OS VALORES VEM COMO NULL
> 

> TAMBÉM É POSSÍVEL COLOCAR A PALAVRA ‘NULL’
>

```sql
INSERT INTO DEPT VALUES (30, 'DIRETORIA', NULL)
```
<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/inser%C3%A7%C3%A3oDados6.png" />