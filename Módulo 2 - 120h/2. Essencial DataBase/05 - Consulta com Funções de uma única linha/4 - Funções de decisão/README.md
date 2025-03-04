# 4 → FUNÇÕES DE DECISÃO

🏆 Dependendo da consulta que a gente queira fazer, vai ser importante que a gente imponha algum tipo de condição.


## FUNÇÃO NVL → FUNÇÃO NULL VALUE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecis%C3%A3o1.png" />

🏆 NO EXEMPLO DA IMAGEM, ESTAMOS:

- Convertendo a comissão onde for nula, vai converter para o número 0
- hiredate onde for nulo, vai converter para ‘01-JAN-97’
- JOB onde for nulo, vai converter para ‘NO JOB YET’

🏆 Como podemos observar a função NVL, consegue trabalhar com:

- Números
- Datas
- Caracteres

> Quando a gente faz uma operação com nulo, o  resultado dessa operação é nulo, mas nem sempre a gente quer que dê o resultado nulo, é ai que entra a função NVL, ela vai converter o nulo para o valor determinado
> 

## USANDO A FUNÇÃO NVL

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao2.png" />

🏆 Estamos fazendo SAL * 12 + A COMISSÃO(SENDO QUE A COMISSÃO ONDE É NULO, CONVERTE PARA 0)


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao3.png" />

> Isso significa que todos funcionários vão ter o salário anual calculado, não é porque ele não ganha comissão que ele vai deixar de ter esse salário.
> 

---

---

---

## FUNÇÃO DECODE → É USADA PARA INSTRUÇÕES CONDICIONAIS

🏆 Facilita pesquisas condicionais realizando o trabalho de uma instrução CASE ou IF-THEN-ELSE


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao4.png" />

## USANDO A FUNÇÃO DECODE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao5.png" />


🏆 Estamos selecionando o job e o sal E DECODE (SE)

   

- SE JOB FOR IGUAL A ‘ANALYST’ FAÇA SAL*1.1(aumento de 10% pro salário)
- CASO CONTRARIO SE O SAL FOR IGUAL A ‘CLERK, FAÇA SAL*1.15’(aumento de 15% pro salário)
- SE O JOB FOR ‘MANAGER’, FAÇA SAL*1.20(aumento de 20% do salário)
- CASO CONTRARIO É PARA MANTER O SAL

> Os analistas, os CLERK E OS MANAGERS VÃO RECEBER AUMENTO SALARIAL, já os os outros cargos os salários continuaram os mesmos.
> 

⚠️ Toda essa operação de DECODE está recebendo o apelido de ‘REVISED_SALARY’


### RESULTADO:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao6.png" />

---

---

---

## USANDO A FUNÇÃO CASE

⚠️ A função CASE faz a mesma coisa que a função DECODE, sendo que o CASE é uma atualização, ele também é encontrado nas linguagens de programação, podemos dizer que ele tem uma leitura melhor, ele é mais fácil de entender para quem está digitando o comando.


🏆 CONSULTA PARA DOBRAR O SALÁRIO DE CLERK E OS DEMAIS FUNCIONÁRIOS TERÃO AUMENTO SALARIAL DE 50%


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao7.png" />

🏆 NA IMAGEM: 

- ESTAMOS SELECIONANDO ENAME, JOB E SAL
- CASO(case)
- WHEN(quando) O JOB FOR IGUAL A ‘CLERK’
- THEN(então) FAZ O SAL * 2
- ELSE(se não) FAÇA SAL * 1.5
- END (finaliza o case)
- A operação está recebendo o apelido de “AUMENTO SALARIAL”

> O funcionário que tiver o cargo clerk vai ter o salário dobrado, o restante dos funcionários vão receber um aumento de 50%
> 

---

---

## PRATICANDO!!!

## VAMOS COMEÇAR PELO NVL

> Primeiro vamos realizar a função sem o NVL para ver o que acontece
> 

```sql
SELECT ENAME, SAL, COMM, SAL*12 + COMM FROM SCOTT.EMP
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao8.png" />

> Podemos notar que só foi apresentado o salário anual para quem tem valor na comissão, para os demais funcionários onde a comissão é nula, o resultado foi nulo
> 

> Isso não é correto, não é porque um funcionário não ganha comissão que ele não tem salário anual, isso acaba gerando uma informação incorreta, é nesse caso que vamos utilizar a função NVL
> 

```sql
SELECT ENAME, SAL, COMM, SAL*12 + NVL(COMM,0) FROM SCOTT.EMP
```

> ONDE A COMISSÃO FOR NULA, VAI SER SUBSTITUIDO POR 0
> 

<img width="300" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao9.png" />

## UTILIZANDO O DECODE(FUNÇÃO CONDICIONAL)

```sql
SELECT ENAME, SAL,JOB, DECODE(JOB, 'CLERK', SAL*1.1, 'MANAGER', SAL*1.15, 'SALESMAN', SAL*1.2, SAL) "SALARIO REVISADO" FROM SCOTT.EMP
```

- CASO O JOB SEJA ‘CLERK’ FAÇA SAL * 1.1
- CASO O JOB SEJA ‘MANAGER’ FAÇA SAL * 1.15
- CASO O JOB SEJA ‘SALESMAN’ FAÇA SAL * 1.2
- SE NÃO, O SAL PERMANECE DO JEITO QUE ESTÁ
- ESTAMOS APELIDANDO DE ‘SALARIO REVISADO’

<img width="300" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/fdecisao10.png" />


🏆 ATRAVÉS DO COMANDO DECODE A GENTE CONSEGUE GERAR CONDIÇÕES E ATRAVÉS DESSAS CONDIÇÕES A GENTE ESTIPULA O QUE A GENTE QUER QUE ACONTEÇA COM O DADO, APLICANDO A ESTRUTURA DE IF ELSE

