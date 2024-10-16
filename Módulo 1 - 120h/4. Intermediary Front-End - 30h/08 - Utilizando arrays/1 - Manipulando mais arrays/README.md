# MANIPULANDO MAIS ARRAYS

## 2 MÉTODOS MUITO IMPORTANTES PARA MANIPULAÇÃO DE ARRAYS

## SLICE()

🏆 O método slice() copia uma parte de um array e o retorna como um novo array. Isso não modifica o array original

- De: Corta o array a partir do índice informado;
- Ate: Corta o array até o índice informado (ele imprimi sempre 1 anterior ao índice)

`array.slice(de, ate)`

```jsx
let array = [1, 2, 3, "Hello world", 4.12, true]

// Utilizando o slice()
let newArray = array.slice(0,3)

console.log(array) // [ 1, 2, 3, 'Hello world', 4.12, true ]
console.log(newArray) // [1, 2, 3 ]
```

> O splice muda o Array original, enquanto o slice() não.
> 

> Ele tem o mesmo sentido, vou cortar daqui até determinado ponto.
> 

## CONCAT()

🏆 O concat é um método utilizado para fazer a junção de duas partes e após essa junção ele retorna uma nova.

esta método no javascript pode ser utilizado para Strings ou em arrays, o comando é igual, para os dois tipos de dados

```jsx
let titulo = "Dr. ";
let nome = "João da silva";
let nome_completo = titulo.concat(nome);

console.log(nome_completo)
```

```jsx
let array1 = [1, 2, 3]
let array2 = [4, 5, 6]

let array3 = array1.concat(array2);

console.log(array3) // vai imprimir os dois arrays concatenados 
```

```jsx
/* Imagina que você tem um array com todos os meses do ano, dividir ele em trimestres*/

let meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]

let trimestre1 = meses.slice(0, 3)
let trimestre2 = meses.slice(3, 6)
let trimestre3 = meses.slice(6, 9)
let trimestre4 = meses.slice(9, 12)

console.log(trimestre1)
console.log(trimestre2)
console.log(trimestre3)
console.log(trimestre4)
```