# 2 → CONSULTAS COM RESTRIÇÃO DE FUNÇÕES DE GRUPO

🏆 Vamos falar sobre as restrições que podemos impor nas funções de grupo


---

🏆 Quando fazemos a seleção dentro de uma tabela, a gente aprendeu que podemos utilizar a cláusula WHERE para impor condições, exemplo:

- Eu não quero ver todos os salários, somente salários que sejam maior que 3000.

💡 Quando queremos impor uma condição utilizamos a cláusula WHERE


🏆 Nós vimos também que com as funções de grupo nós podemos agrupar dentro da tabela, exemplo:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo1.png" />

Nós temos na imagem:

- O grupo do departamento 10
- O grupo do departamento 20
- O grupo do departamento 30

E estamos utilizando a função max para buscar o maior salário de cada grupo.


⚠️ Quando queremos impor uma condição para uma função de GROUP, a gente não utiliza a cláusula WHERE.


🔥 Para impor condições a uma função de GROUP a gente utiliza a cláusula HAVING



## EXCLUINDO RESULTADOS DO GRUPO: CLÁUSULA HAVING

🏆 Observação: Em uma select que tem função de grupo, nós podemos ter a cláusula WHERE. MAS a cláusula WHERE não pode ser utilizada para impor uma condição a uma função de grupo.

- Cláusula where é utilizada para impor uma condição para um campo.
- Cláusula HAVING impõe condições para função de GRUPO, exemplo: “Eu quero ver as médias salariais que sejam maiores que 3 mil”, estamos impondo uma condição para função de grupo, nesse caso utilizamos a cláusula HAVING.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo2.png" />

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo3.png" />

> ORDER BY É SEMPRE A ULTIMA CLÁUSULA DO COMANDO.
> 

---

## UTILIZANDO A CLÁUSULA HAVING

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo4.png" />

> Estamos agrupando a tabela pelo departamento(deptno), o sql vai pegar a tabela emp e juntar o bloco do departamento 10, o bloco do departamento 20, o bloco do departamento 30, e em cada grupo vai se aplicar a função de max(sal), ou seja, o maior salário de cada departamento
> 

🏆 MAS nós não queremos ver todos os maiores salários, queremos ver somente aqueles onde o maior salário seja maior que 2900 (utilizando a cláusula HAVING)

> Se utilizarmos a cláusula WHERE no lugar do HAVING, vamos obter um erro, pois o WHERE não consegue trabalhar com condições para funções de GRUPO.
> 

---

## PRATICANDO!!!

> Estamos buscando a média salarial de cada departamento e realizando o agrupamento da coluna deptno;
> 

```sql
SELECT deptno, trunc(avg(sal))
FROM scott.emp
GROUP deptno
ORDER BY deptno;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo5.png" />

### UTILIZANDO O HAVING, AGORA EU QUERO A CONDIÇÃO DE VER SOMENTE AS MÉDIAS SALARIAIS QUE SEJAM MAIORES QUE 2000

```sql
SELECT deptno, trunc(avg(sal))
FROM scott.emp
GROUP BY deptno
HAVING avg(sal) > 2000
ORDER BY deptno;
```

> Com isso estamos realizando as restrições de grupos
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/consultasComRestri%C3%A7%C3%B5esDeFun%C3%A7%C3%B5esDeGrupo6.png" />

🏆 Toda vez que a gente quiser impor uma condição a uma função de grupo, devemos utilizar a cláusula HAVING e respeitando a ordem dos exemplos.

