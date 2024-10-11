# CRIANDO E MANIPULANDO ARRAYS

## O QUE É UM ARRAY?


🏆 Array:

- Lista de objetos
    - Imagina uma lista de super mercado com as mercadorias que você precisa
- Objetos que contém múltiplos valores armazenados em uma lista.
- Um objeto array pode ser armazenado em variáveis e ser tratado de forma muito similar a qualquer outro tipo de valor
- Javascript não possui um tipo de dados array especifico
    - Você pode ter vários tipos misturados dentro de um array (string, booleano, number)
        - Em outras linguagens isso não é possível, pois tem uma determinada limitação

     <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array1.png" />
    
---

## Criando um array

- Arrays são construídos a partir dos colchetes, os quais contém uma lista de itens separados por vírgulas.

Exemplo: 

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array2.png" />

> Nesse caso temos um array de Strings
> 

Outro exemplo com outros tipos de array:

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array3.png" />

> É possível também termos um array dentro de outro array como na imagem acima
> 

---

## CRIAÇÃO DE UM ARRAY

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array4.png" />

> É possível criar a partir do operador ‘new’
> 

> Ou também criar diretamente utilizando os []
> 

> Os elementos são separados por virgula
> 

> Não tem criação melhor ou pior, mas o mais utilizado no dia a dia é a criação a partir dos colchetes.
> 
- **elemento0, elemento1,…, elementoN** é uma lista de valores para os elementos do array
- Quando esses valores são especificados, o array é inicializado com eles como elementos deste array
- A propriedade do comprimento do array é definida pelo número de argumentos.
- A sintaxe dos colchetes é chamada de “array literal” ou “inicializador de array”

---

## CRIANDO UM ARRAY DIFERENTE DE ZERO E SEM ELEMENTOS

- Para criar um array com tamanho diferente de zero mas sem nenhum item, exemplo:

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array5.png" />
## CRIANDO UM ARRAY COM UM ÚNICO ELEMENTO NUMÉRICO

- você precisa usar a sintaxe dos colchetes.
- Quando um único valor tipo número é passado para o construtor do Array(), ou para uma função, ele é interpretado como um comprimentoDoArray, e não como um elemento único.
- Chamar Array(N) resulta em um RangeError, se N é um número não inteiro cuja porção fracionária não é zero

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array6.png" />

> Para dizer que o Array tem 42 posições devemos utilizar e colocar o número de posições desejadas dentro dos ()
> 

---

## REFERENCIANDO ELEMENTOS DO ARRAY

- Você referencia os elementos do array através do uso de elementos numéricos ordinais

🚨 Os números ordinais são **números que indicam a ordem ou posição de algo numa sequência, ou seja, a localização de um objeto**.


 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array7.png" />

> O Array sempre se inicia na posição 0, nesse caso o valor ‘Vento’ está na posição 0.
> 
- você então se refere ao primeiro elemento do array como um myArray[0] e ao segundo elemento do array como um myArray[1].
- O índice do elemento começa com zero.

---

## POPULANDO UM ARRAY

- Você pode povoar (inserir elementos) de algumas formas, uma delas é atribuindo valores aos seus elementos

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array8.png" />

## OU

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/array9.png" />

> Na segunda imagem primeiro eu atribuo através do new Array (utilizando parenteses), que é quando estou criando um novo objeto do tipo Array
> 

> E logo em seguida, atribuo através dos colchetes
>