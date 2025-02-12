# 2 → ATUALIZAÇÃO E EXCLUSÃO DE REGISTROS

🏆 Também é possível realizar atualizações nos dados inseridos 


## ALTERANDO OS DADOS EM UMA TABELA

  <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros1.png" />

> Podemos notar que foi atualizado o valor 20 no lugar do 10 na coluna DEPTNO
> 

## A INSTRUÇÃO UPDATE

> Modifique linhas existentes com a instrução UPDATE
> 

  <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros2.png" />

🏆 Atualize mais de uma linha por vez, se necessário.


🏆 Quando a gente faz um comando UPDATE sem a clausula WHERE significa que todas as linhas da tabela serão afetadas  


## REMOVENDO UMA LINHA DE UMA TABELA

  <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros3.png" />

## A INSTRUÇÃO DELETE

> Você pode remover linhas existentes de uma tabela usando a instrução DELETE
> 

  <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros4.png" />

🏆 Tanto a clausula FROM como a clausula WHERE são opcionais 


---

---

---

## PRATICANDO!!!!!

### VAMOS ALTERAR ATRAVÉS DO UPDATE A LOC QUE ESTÁ NULL EM NOSSA TABELA

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros5.png" />

```sql
UPDATE DEPT 
SET LOC = 'BELO HORIZONTE'
WHERE DEPTNO = 30; // Queremos fazer o update no departamento 30 
```

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros6.png" />

### VAMOS REALIZAR UM UPDATE SEM A CLAUSULA WHERE (TODAS AS LINHAS VÃO SER ALTERADAS)

```sql
UPDATE DEPT
SET LOC = 'CURITIBA' // Todos os departamentos vão ficar localizados em curitiba
```

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros7.png" />

### EXCLUINDO REGISTROS DA TABELA COM O COMANDO DELETE

```sql
DELETE FROM DEPT
WHERE DEPTNO = 10
```

> Estamos excluindo da tabela o departamento 10
> 

  <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/updateEdeleteRegistros8.png" />

### FAZENDO O DELETE SEM A CLAUSULA WHERE E FROM (A EXCLUSÃO DO REGISTRO VAI ACONTECER PARA TODOS OS REGISTROS DA TABELA)

```sql
DELETE DEPT
```

> O resultado será ‘no data found’ → Essa tabela não tem mais nenhum registro
>