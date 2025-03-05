# 2 → JUNÇÃO NÃO-IDÊNTICA

🏆 Como vimos na junção idêntica para que a gente possa relacionar uma tabela com a outra nós usamos a igualdade dos valores dos campos geralmente através das chaves primárias e estrangeiras. 


🏆 Como o próprio nome já diz na junção não-idêntica não existe igualdade entre esses valores, não há campos nem com os mesmos nomes nem com os mesmos valores, mas existe uma forma de relacionar essas tabelas


---

## JUNÇÕES NÃO-IDÊNTICAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica1.png" />

> Na tabela SALGRADE existe uma grade salarial do menor salário até o maior salário, através disso podemos fazer o relacionamento entre as tabelas para saber em qual faixa salarial se enquadra cada funcionário da tabela EMP, a partir disso podemos observar que mesmo não havendo nenhum campo com o mesmo nome nem valores com os mesmos dados, é possível fazer o relacionamento.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica2.png" />

---

## RECUPERANDO REGISTROS COM JUNÇÕES NÃO-IDÊNTICAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica3.png" />

🏆 A condição será quando o e.sal(salário) da tabela EMP estiver entre (BETWEEN) s.losal (salário mínimo) E s.hisal(maior salário)

> Ou seja, quando o salário estiver entre os limites estabelecidos pela faixa salarial da tabela SALGRADE
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica4.png" />
---

## PRATICANDO!!!

### PRIMEIRO VAMOS CRIAR A TABELA SALGRADE

```sql
CREATE table salgrade(
    grade number(1) primary key,
    losal number(4),
    hisal number(4)
);
```

### DEPOIS INSERIR VALORES

```sql
insert into salgrade values (1, 700, 1200);
insert into salgrade values (2, 1201, 1400);
insert into salgrade values (3, 1401, 2000);
insert into salgrade values (4, 2001, 3000);
insert into salgrade values (5, 3001, 9999);
```

### CONFERIR SE OS DADOS FORAM INSERIDOS CORRETAMENTE

```sql
SELECT * FROM SALGRADE
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica5.png" />

### FAZENDO A JUNÇÃO NÃO-IDÊNTICA

```sql
SELECT e.ename, e.sal, s.grade, s.losal, s.hisal
from scott.emp e JOIN salgrade s // fazendo a join
ON (e.sal BETWEEN s.losal and s.hisal) //condição quando o campo sal da tabela emp estiver entre losal e hisal da tabela salgrade

```

> É recomendado sempre começar pela cláusula FROM
> 

<img width="400" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/jun%C3%A7%C3%A3oN%C3%A3oId%C3%AAntica6.png" />

### EXEMPLO

🏆

- O FUNCIONARIO SMITH GANHA 800
- A FAIXA SALARIAL DELE É 1 PORQUE 800 ESTÁ ENTRE LOSAL(700) E HISAL(1200)

## FIZEMOS UMA JUNÇÃO NÃO-IDÊNTICA(NO EQUI-JOIN)