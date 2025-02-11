# 4 → ALTERAÇÃO E EXCLUSÃO DE TABELAS

## A INSTRUÇÃO ALTER TABLE → VAMOS ALTERAR A ESTRUTURA DE UMA TABELA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o1.png" />

> Não confundir com alteração dos dados
> 

### USE A INSTRUÇÃO ALTER TABLE PARA:

- Adicionar uma nova coluna
- Modificar uma coluna existente
- Definir um valor default para a nova coluna

🏆 Quando falamos de alterar uma tabela estamos falando de alterar uma coluna, adicionar uma constraint, eliminar uma constraint, modificar o tido de dado de um campo, renomear um campo, esses são exemplos de modificações na estrutura de uma tabela


> O comando update altera os DADOS da tabela não a ESTRUTURA
> 

🏆 A clausula ADD adiciona uma coluna, uma constraint


🏆 A clausula MODIFY adiciona alguma modificação 


## ADICIONANDO UMA COLUNA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o2.png" />

> Aqui estamos adicionando a coluna JOB na tabela DEPT 30
> 

## MODIFICANDO UMA COLUNA (MODIFY)

> Podemos utilizar o modify para modificar o tipo do dado ou o tamanho do campo.
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o3.png" />

## ADICIONANDO UMA RESTRIÇÃO (ADD)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o4.png" />

### Adicionando uma restrição FOREIGN KEY

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o5.png" />

## ELIMINANDO UMA RESTRIÇÃO (CLAUSULA DROP)

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o6.png" />

> No segundo exemplo, vai apagar a chave primária e todas as constraints que estejam ligadas a essa chave primaria
> 

## ELIMINANDO UMA COLUNA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o7.png" />

## ELIMINANDO UMA TABELA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o8.png" />

> Tudo que estiver relacionado com essa tabela, será eliminado
> 

## ALTERANDO O NOME DE UM OBJETO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o9.png" />

> NÃO CONFUNDIR COM RENOMEAR UMA COLUNA DA TABELA, NO QUAL O COMANDO É:
> 

```sql
ALTER TABLE RENAME COLUMN 
```

---

---

---

## PRATICANDO

### ADICIONANDO UM NOVO CAMPO NA TABELA ALUNO

```sql
alter table aluno
add data_nasc date;
```

### MODIFICANDO A QUANTIDADE DE CARACTER NO CAMPO NOME DA TABELA ALUNO

```sql
alter table aluno 
modify nome varchar2(200)
```

### MODIFICANDO O NOME PARA UMA CONSTRAINT PARA QUE ELE SEJA NOT NULL

```sql
alter table aluno 
modify nome not null;
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o10.png" />

### RENOMEANDO UM CAMPO DA TABELA ALUNO

```sql
alter table aluno 
rename column data_nasc to data_nascimento;
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o11.png" />

### ELIMINANDO UMA COLUNA DA TABELA

```sql
alter table aluno
drop column nome;
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o12.png" />

### ADICIONANDO UMA CONSTRAINT PRIMARY KEY NA TABELA ALUNO

```sql
alter table aluno
add constraint pk_alu primary key(ra);
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o13.png" />

> Podemos observar que ‘ra’ se tornou uma primary key, pois agora ela não aceita nullos. A primary key não aceita nullos nem valores repetidos.
> 

### RENOMENADO O OBJETO (TABELA ALUNO)

```sql
rename aluno to alu;
```
<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/altera%C3%A7%C3%A3oEexclus%C3%A3o14.png" />

### DELETANDO A TABELA PROFESSOR DA AULA PASSADA

```sql
drop table professor 
```

> Todos os dados da tabela foram apagados.
>