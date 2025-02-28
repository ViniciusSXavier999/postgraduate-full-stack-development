# 3 → FUNÇÕES DE CONVERSÃO DE TIPOS DE DADOS

## TRABALHANDO COM DATAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados1.png" />

> Quando falamos que um campo é do tipo date, esse campo está armazenando desde o século ate os segundos
> 

🏆 Muitas vezes é necessário realizar conversões, exemplo:

- Número em caractere
- Caractere em Número
- Data em Caractere

## ARITMÉTICA COM DATAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados2.png" />

🏆 Data com Data o resultado vai ser NÚMERO DE DIAS


🏆 Já Data com número o resultado será uma DATA


## USANDO OPERADORES ARITMÉTICOS COM DATAS

> Vamos supor que a gente quer saber quantas semanas de vida tem uma pessoa ou quantas semanas tal pessoa trabalha na empresa
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados3.png" />

💡 Estamos pegando o SYSDATE que é a data atual -(menos) o HIREDATE que é a data de admissão (sabendo que data com data da um número de dias a gente vai dividir por 7 e vai descobrir a quantas semanas aquela pessoa trabalha na empresa.)

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados4.png" />


---

## FUNÇÕES DE CONVERSÃO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados5.png" />

### CONVERSÃO IMPLÍCITA DE TIPOS DE DADOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados6.png" />

### CONVERSÃO EXPLÍCITA DE TIPOS DE DADOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados7.png" />

✅

## DIFERENÇA DE CONVERSÃO IMPLÍCITA E EXPLICÍTA

Em SQL, a conversão de dados é o processo de transformar um tipo de dado em outro. Isso pode acontecer de forma **implícita** ou **explícita**. Vou te explicar a diferença!

### 🔹 **Conversão Implícita**

O SQL Server (ou outro SGBD) converte automaticamente um tipo de dado para outro, sem que você precise fazer nada. Essa conversão só acontece quando não há risco de perda de dados ou erro.

**Exemplo:**

```sql
SELECT 10 + '5' AS resultado;

```

Nesse caso, o SQL Server converte a string `'5'` para um número inteiro e retorna `15`. A conversão acontece automaticamente!

🔸 **Exemplos comuns de conversão implícita:**

- `INT` → `FLOAT`
- `VARCHAR` → `TEXT`
- `CHAR` → `VARCHAR`

---

### 🔹 **Conversão Explícita**

Aqui, você **força** a conversão, dizendo ao SQL qual tipo de dado quer usar. Isso é útil quando a conversão implícita não ocorre ou você quer ter controle total sobre o resultado.

**Exemplo usando `CAST`:**

```sql
SELECT CAST('2025-02-27' AS DATE) AS data_formatada;

```

**Exemplo usando `CONVERT` (SQL Server):**

```sql
SELECT CONVERT(INT, '123') AS numero_inteiro;

```

🔸 **Vantagens da conversão explícita:**

- Mais controle sobre o tipo final.
- Evita comportamentos inesperados.
- Permite converter tipos que o SQL não converteria sozinho (ex: de `FLOAT` para `VARCHAR`).

---

### 🧠 **Resumo prático:**

| **Tipo de Conversão** | **Como Funciona** | **Exemplo** |
| --- | --- | --- |
| **Implícita** | O SQL faz automaticamente. | `SELECT 10 + '5';` |
| **Explícita** | Você força a conversão com funções. | `SELECT CAST('5' AS INT);` |

Se estiver manipulando muitos dados ou tratando entradas de usuários, vale mais a pena usar conversão explícita para evitar surpresas! 🚀

Quer que eu te ajude a escolher quando usar cada uma? Ou quer mais exemplos? É só falar! ✌️


---

## FUNÇÃO TO_CHAR COM DATAS

✅ TO_CHAR(data, ‘fmt’)


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados8.png" />

> Isso vai ser útil quando por exemplo a gente queira mudar o formato padrão de visualização das datas da linguagem SQL
> 

## ELEMENTOS DE MODELO DE FORMATO DE DATA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados9.png" />

## USANDO A FUNÇÃO TO_CHAR COM DATAS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados10.png" />

- hiredate → Data de admissão do colaborado
- fm → Oculta o 0 a esquerda

### RESULTADO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados11.png" />

## FUNÇÃO TO_CHAR COM NÚMEROS

✅ TO_CHAR(número, ‘fmt’)


### CONVERTE UM NÚMERO PARA CARACTERE

> Use estes formatos com a função TO_CHAR para exibir um valor de numérico como um caractere:
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados12.png" />

## USANDO A FUNÇÃO TO_CHAR COM NÚMEROS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados13.png" />

### RESULTADO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados14.png" />

---

---

---

## PRATICANDO!!!

### UTILIZANDO O SYSDATE PARA VER A DATA E HORA DO SISTEMA OPERACIONAL

```sql
SELECT SYSDATE FROM DUAL;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados15.png" />

> Podemos notar que o formato da data está:
> 
- 2 dígitos pro dia
- 3 letras pro mês
- 2 dígitos pro ano

✅ CASO EU QUEIRA ALTERAR ESSA VISUALIZAÇÃO, EU POSSO UTILIZAR O TO CHAR.


### UTILIZANDO O TO_CHAR

```sql
SELECT TO_CHAR(SYSDATE, 'DD/MONTH/YYYY') FROM DUAL
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados16.png" />

✅ Caso eu queira ver o dia da semana e o ano por extenso

```sql
SELECT TO_CHAR(SYSDATE, 'DAY/YEAR') FROM DUAL
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados17.png" />


### FAZENDO A ARITMÉTICA ENTRE AS DATAS

```sql
SELECT ENAME, (SYSDATE-HIREDATE) DIAS, (SYSDATE-HIREDATE)/7 SEMANAS, (SYSDATE-HIREDATE)/ 365 ANOS, (SYSDATE-HIREDATE) * 24 FROM SCOTT.EMP;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados18.png" />

> Podemos notar que a visualização esta com muitas casas decimais, por isso podemos utilizar o TRUNC que corta todas as casas decimais (O ROUND ARREDONDA, ELE É DIFERENTE DO TRUNC)
> 
> 
> ```sql
> SELECT ENAME, TRUNC((SYSDATE-HIREDATE)) DIAS, TRUNC((SYSDATE-HIREDATE)/7) SEMANAS, TRUNC((SYSDATE-HIREDATE)/ 365) ANOS, TRUNC((SYSDATE-HIREDATE) * 24) HORAS FROM SCOTT.EMP;
> ```
> 
> <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados19.png" />
> 

### MOSTRANDO O HIREDATE PARA CONFERIR SE ESTÁ TUDO CERTO COM OS CALCULOS

```sql
SELECT ENAME,HIREDATE, TRUNC((SYSDATE-HIREDATE)) DIAS, TRUNC((SYSDATE-HIREDATE)/7) SEMANAS, TRUNC((SYSDATE-HIREDATE)/ 365) ANOS, TRUNC((SYSDATE-HIREDATE) * 24) HORAS FROM SCOTT.EMP;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados20.png" />

### USANDO A FUNÇÃO TO_CHAR PARA TRABALHAR COM NÚMEROS

```sql
SELECT ENAME, SAL, TO_CHAR(SAL, 'L999.999.999,99') FROM SCOTT.EMP
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/convers%C3%A3oDados21.png" />

✅ O ‘L’ é responsável por colocar a moeda local, a nuvem está nos estados unidos, por isso a moeda local é o dollar


✅ As milhares estão separadas por virgula e as dezenas por ponto



🏆 A gente converteu o número para caractere 


🏆 Lembrando que se trata de um select, a gente não está alterando o conteúdo, só estamos visualizando em outro formato

