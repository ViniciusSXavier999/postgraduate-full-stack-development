# 1 → CRIAÇÃO DE VIEWS SIMPLES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples1.png" />

🏆 Até o momento o objeto que criamos foi a tabela EMP, e a partir disso criamos uma serie de coisas associadas a tabela:

- Os campos
- As constraints
- Tipos
- Tamanhos

mas sempre relacionado ao único objeto que é a tabela.

🏆 A tabela é o principal objeto de armazenamento de dados.



⚠️ Mas é muito importante que a gente saiba que existe outros objetos, como por exemplo a view.


🏆

### VIEW → VISÃO DE DADOS DA TABELA, ELA PODE SER SIMPLES OU COMPLEXA, ELA É UMA FORMA SIMPLIFICADA DE SELECIONAR OS DADOS DE UMA TABELA.


## FAZENDO UMA VIEW COM BASE NA TABELA EMP

> Vamos supor que eu queira construir uma view(visão) somente do departamento 10
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples2.png" />

---

## POR QUE USAR VIEWS?

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples3.png" />

> Ao invés de ficar digitando o comando de uma JOIN a gente cria uma VIEW que é se torna bem menos complexo
> 

> Podemos separar registros especificos para cada departamento, exemplo:
> 
- Departamento de RH é importante visualizar todos os dados da tabela EMP
- Já o departamento comercial, importa saber os dados dos funcionários do departamento de vendas

💡 A gente consegue criar varias visões dos dados a partir de uma única tabela.


---

## CARACTERÍSTICAS DE UMA VIEW SIMPLES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples4.png" />

---

## CRIANDO UMA VIEW

🏆 A view acaba se utilizando do conceito da SUB CONSULTA


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples5.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples6.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples7.png" />

[]→ São configurações opcionais 

⚠️ - Em uma view simples não utilizamos ORDER BY

## CRIANDO VIEW NA PRÁTICA (VIEW SIMPLES)

### Crie uma view, EMPVU10, que contenha detalhes sobre os funcionários no departamento 10.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples8.png" />

💡 Estamos criando uma view que vai mostrar os registros do departamento 10.


### Descreva a estrutura da view usando o comando DESCRIBE do SQL*Plus

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples9.png" />

## CRIANDO UMA VIEW QUE RECEBE APELIDOS DE COLUNA

### Crie uma view usando apelidos de coluna na subconsulta

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples10.png" />


### Selecione as colunas a partir desta view pelos nomes de apelidos dados.

---

## RECUPERANDO DADOS DE UMA VIEW

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples11.png" />


---

## PRATICANDO!!!

> Vamos utilizar o schema do SCOTT.
> 

### PRIMEIRO VAMOS DAR UM SELECT PARA CONSULTAR TODOS OS DADOS DA NOSSA TABELA BASE, A PARTIR DELA SERÁ CRIADA A VIEW.

```sql
SELECT * FROM scott.emp
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples12.png" />


### CRIANDO NOSSA PRIMEIRA VIEW

```sql
CREATE OR replace VIEW dept10_vu
AS SELECT ename, sal, deptno
FROM scott.emp
WHERE deptno = 10;
```

### PARA RECUPERAR OS DADOS DA VIEW

```sql
SELECT * FROM dept10_vu
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples13.png" />


### CRIANDO UMA VIEW COM OS FUNCIONÁRIOS DO DEPARTAMENTO 30

```sql
create or replace salvu_30
as select ename, nome, sal salario, deptno cod_deptno
from scott.emp
where deptno=30

select * from dept10_vu
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/viewSimples14.png" />


💡 Observe que temos uma VIEW com os funcionários do departamento 30.

