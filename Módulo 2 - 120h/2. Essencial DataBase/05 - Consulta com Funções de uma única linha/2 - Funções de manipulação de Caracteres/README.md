# 2 → FUNÇÕES DE MANIPULAÇÃO DE CARACTERES

## FUNCÕES SQL

🏆 ESSAS FUNÇÕES PODEM RECEBER VÁRIOS ARGUEMNTOS COMO ENTRADA E GERAM UMA SAIDA, POR ISSO SÃO CHAMADAS DE FUNÇÕES DE UMA ÚNICA LINHA, PORQUE GERAM SEMPRE APENAS 1 RESULTADO, OU SEJA, SE NÓS TIVERMOS 10 LINHAS COMO RESULTADO, NÓS TEREMOS 10 RESULTADOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres1.png" />


🏆 As funções SQL de manipulação de caracteres permitem trabalhar com strings de texto, transformando, combinando ou extraindo informações. Elas podem receber múltiplos argumentos e sempre retornam uma única saída, que é o resultado da manipulação. Vamos ver as mais comuns:

- **`CONCAT`**: Une duas ou mais strings em uma única.
    - Ex: `CONCAT('Olá', ' Mundo') → 'Olá Mundo'`
- **`SUBSTRING`**: Extrai uma parte da string com base na posição inicial e comprimento.
    - Ex: `SUBSTRING('SQL é incrível', 1, 3) → 'SQL'`
- **`UPPER` / `LOWER`**: Converte o texto para maiúsculas ou minúsculas.
    - Ex: `UPPER('sql') → 'SQL'`
- **`TRIM`** / `LTRIM` / `RTRIM`*: Remove espaços ou caracteres específicos no início, fim ou ambos.
    - Ex: `TRIM(' texto ') → 'texto'`
- **`REPLACE`**: Substitui parte da string por outra.
    - Ex: `REPLACE('SQL é legal', 'legal', 'poderoso') → 'SQL é poderoso'`
- **`CHAR_LENGTH` / `LENGTH`**: Retorna o número de caracteres ou bytes de uma string.
    - Ex: `CHAR_LENGTH('SQL') → 3`

---

---

## FUNÇÕES DE CARACTERE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres2.png" />

## FUNÇÕES DE CONVERSÃO DE MAIÚSCULA E MINÚSCULAS

🏆 CONVERTER MAIÚSCULAS EM MINÚSCULAS PARA STRINGS DE CARACTERE


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres3.png" />

- LOWER CONVERTE PARA MINÚSCULO
- UPPER CONVERTE PARA MAIÚSCULO
- INITCAP CONVERTE A PRIMEIRA PARA MAIÚSCULA E O RESTANTE PARA MINÚSCULAS

## USANDO FUNÇÕES DE CONVERSÃO DE MAIÚSCULAS E MINÚSCULAS

✅ EXIBIR O NÚMERO DE FUNCIONÁRIO, NOME E NÚMERO DE DEPARTAMENTO DO FUNCIONÁRIO BLAKE


⚠️ Se a gente manda buscar um registro com o nome blake em letra minúscula não a linhas selecionadas, pois não tem nenhum funcionário blake na tabela emp em letra minúscula.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres4.png" />


✅ Para resolver isso podemos converter o ‘blake’ para letra MAIÚSCULA através do UPPER

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres5.png" />

> Dessa forma o registro será retornado de forma correta
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres6.png" />


---
## FUNÇÕES DE MANIULAÇÃO DE CARACTERE

🏆 MANIPULAR STRINGS DE CARACTERE 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres7.png" />

- CONCAT → CONCATENA DUAS STRINGS
- SUBSTR → VAI TRAZER UM PEDAÇO DA STRING DETERMINADO PELA POSIÇÃO INICIAL E TERMINAL
- LENGTH → TRÁS O TAMANHO DE UMA STRING
- INSTR → TRÁS A POSIÇÃO DA LETRA NA STRING
- LPAD(faz o alinhamento a esquerda), RPAD(faz o alinhamento a direita) →

A função **`LPAD`** (Left Padding) preenche uma string com caracteres à esquerda até atingir um comprimento específico.

**Sintaxe:**

```sql
LPAD(string, comprimento, caractere_de_preenchimento)

```

- **`string`**: Texto original.
- **`comprimento`**: Tamanho total desejado da string final.
- **`caractere_de_preenchimento`**: (Opcional) Caractere usado para preencher. Se omitido, usa espaços.

**Exemplo:**

```sql
SELECT LPAD('SQL', 6, '*') → '***SQL'

```

Se a string for maior que o comprimento especificado, ela será truncada à esquerda.

É útil para formatação de saída, alinhamento ou padronização de dados! Se quiser, posso te mostrar mais casos de uso. 😉

- TRIM → Retira caracteres de uma STRING

---

## USANDO AS FUNÇÕES DE MANIPULAÇÃO DE CARACTERE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres8.png" />

- Estamos selecionando o CAMPO DE NOME DO FUNCIONÁRIO
- REALIZANDO A CONCATENAÇÃO DO NOME E DO CARGO → CONCAT
- CALCULANDO O TAMANHO DO NOME DESSE FUNCIONÁRIO → LENGTH
- BUSCANDO A POSIÇÃO QUE SE ENCONTRA A LETRA A → INSTR
- NÓS QUEREMOS FAZER ISSO PARA TODOS OS FUNCIONARIOS ONDE NO CARGO DA POSIÇÃO 1 ATÉ A POSIÇÃO 5 SEJA IGUAL A ‘SALES’ → SUBSTR

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres9.png" />

---

## FUNÇÕES QUE TRABALHAM COM OS NÚMEROS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres10.png" />

## USANDO A FUNÇÃO ROUND

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres11.png" />

### 🟩 **Exemplo 1: Arredondar para o inteiro mais próximo**

Se você não informar a quantidade de casas decimais, o SQL arredonda para o inteiro mais próximo.

```sql
SELECT ROUND(12.7);

```

🔸 **Resultado:** `13`

```sql
SELECT ROUND(12.4);

```

🔸 **Resultado:** `12`

---

### 🟩 **Exemplo 2: Arredondar com casas decimais específicas**

Você pode definir o número de casas decimais que deseja manter.

```sql
SELECT ROUND(123.4567, 2);

```

🔸 **Resultado:** `123.46`

```sql
SELECT ROUND(123.4543, 3);

```

🔸 **Resultado:** `123.454`

---

### 🟩 **Exemplo 3: Arredondar para baixo (quando o número é < 5)**

```sql
SELECT ROUND(56.342, 2);

```

🔸 **Resultado:** `56.34`

---

### 🟩 **Exemplo 4: Arredondar para cima (quando o número é ≥ 5)**

```sql
SELECT ROUND(56.345, 2);

```

🔸 **Resultado:** `56.35`

---

### 🟩 **Exemplo 5: Arredondar para números inteiros negativos**

Se você usar um número **negativo** como o segundo argumento, ele arredonda para a esquerda do ponto decimal!

```sql
SELECT ROUND(12345.67, -1);

```

🔸 **Resultado:** `12350`

```sql
SELECT ROUND(12345.67, -2);

```

🔸 **Resultado:** `12300`

```sql
SELECT ROUND(12345.67, -3);

```

🔸 **Resultado:** `12000`

---

### 🟩 **Exemplo 6: Arredondar valores negativos**

A função **`ROUND`** também funciona com números negativos!

```sql
SELECT ROUND(-23.567, 2);

```

🔸 **Resultado:** `-23.57`

```sql
SELECT ROUND(-23.543, 2);

```

🔸 **Resultado:** `-23.54`

---

### 🟩 **Exemplo 7: Usar ROUND com colunas de uma tabela**

Se você estiver lidando com dados reais, pode usar **`ROUND`** para arredondar valores diretamente nas colunas.

```sql
SELECT produto, ROUND(preco, 2) AS preco_arredondado
FROM produtos;

```

Isso vai exibir o preço de cada produto com **2 casas decimais**, perfeito para valores monetários!

---

### 🚀 **Resumo rápido:**

- **Número positivo no segundo argumento** → Arredonda para as casas decimais.
- **Número negativo no segundo argumento** → Arredonda para a esquerda do ponto decimal.
- **Valor exato no meio (5)** → Arredonda para cima.
- **Funciona com valores positivos e negativos!**

## USANDO A FUNÇÃO TRUNC

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres12.png" />

🔒 QUANDO TEMOS -1 VAMOS ARREDONDAR PARA A DEZENA MAIS PRÓXIMA


🏆 O TRUNC SIMPLESMENTE CORTA


## DIFERENÇA ROUND E TRUNC

💡 A diferença principal entre **`ROUND`** e **`TRUNC`** está em como eles tratam os números decimais:

- **`ROUND`**: **Arredonda** o valor com base no dígito seguinte. Se for **5 ou maior**, arredonda para cima; se for **menor que 5**, arredonda para baixo.
    
    ```sql
    SELECT ROUND(12.567, 2); -- Resultado: 12.57
    SELECT ROUND(12.564, 2); -- Resultado: 12.56
    
    ```
    
- **`TRUNC`**: **Corta** os dígitos após a posição especificada, sem arredondar. Ele simplesmente **trunca** o número.
    
    ```sql
    SELECT TRUNC(12.567, 2); -- Resultado: 12.56
    SELECT TRUNC(12.564, 2); -- Resultado: 12.56
    
    ```
    

🔑 **Resumo fácil:**

- **`ROUND`** → **Arredonda** o valor.
- **`TRUNC`** → **Corta** os dígitos, sem arredondar.

Se quiser, posso te mostrar mais exemplos práticos! 🚀


## USANDO A FUNÇÃO MOD

🏆 O mod pega o resto da divisão entre dois números


✅
- Estamos selecionando o NOME, SALÁRIO E COMISSÃO
- Depois fazendo a divisão de salário por comissão (o mod pega o resto dessa divisão)
✅

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres13.png" />


---

## PRATICANDO!!!

### PRATICANDO MANIPULAÇÃO DE CARACTERES

```sql
SELECT ENAME, UPPER(ENAME), LOWER(ENAME), INITCAP(ENAME) FROM SCOTT.EMP;
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres14.png" />

### UTILIZANDO O CONCAT, SUBSTR, INSTR E LENGTH

```sql
SELECT ENAME, JOB, CONCAT(ENAME, JOB), SUBSTR(ENAME, 1,3), INSTR(ENAME, 'A'), LENGTH(ENAME) FROM SCOTT.EMP
```

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres15.png" />

- CONCAT → JUNTA DUAS STRINGS
- SUBSTR → CORTA A PALAVRA DE ACORDO COM OS ARGUMENTOS
- INSTR → BUSCA A LETRA NA STRING
- LENGTH → CONTA A QUANTIDADE DE CARACTERES NA STRING

### OPERAÇÕES NÚMERICAS, UTILIZANDO O ROUND E TRUNC

```sql
SELECT ROUND(42.929), TRUNC(42.929) FROM SCOTT.EMP;
```

> Nesse exemplo não estamos falando nada, ou seja, estamos querendo o arredondamento para 0 casas depois da virgula
> 

<img width="200" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres16.png" />

```sql
SELECT ROUND(42.929,2), TRUNC(42.929,2) FROM SCOTT.EMP;
```

> Agora vamos utilizar casas decimais
> 

<img width="300" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/manipula%C3%A7%C3%A3oCaracteres17.png" />

### UTILIZANDO O MOD

```sql
SELECT ENAME, SAL, MOD(SAL, 2) FROM SCOTT.EMP
```


✅ Nesse caso estamos pegando o resto da divisão dos salários dos funcionários dividido por 2


> O operador MOD também é utilizado em outros tipos de linguagem, em algumas linguagens ele é representado pelo símbolo de %
>