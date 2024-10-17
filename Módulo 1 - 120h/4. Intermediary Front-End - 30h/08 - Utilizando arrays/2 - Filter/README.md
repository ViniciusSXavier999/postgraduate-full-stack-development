# FILTER

🏆 O método filter() recebe cada elemento do array e aplica uma instrução condicional a ele. Se essa condição for verdadeira, o elemento é colocado no array de resultado. se for falsa, o elemento não é colocado lá.

```jsx
const numbers = [1, 2, 3, 4]

// utilizando o filter
const evens = numbers.filter(item => item % 2 === 0);

console.log(evens) // o resultado é [2, 4]
```

> No exemplo, eu quero saber se cada elemento do meu array ‘numbers’ é divisível por 2.
> 

> Cada elemento do meu array eu estou chamando de “item”
> 

🚨 O que é ‘⇒’? 

[O que significa o operador "=>"?](https://pt.stackoverflow.com/questions/114367/o-que-significa-o-operador)

### OUTRA FORMA DE FAZER, É UTILIZANDO UMA FUNÇÃO

```jsx
var numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

function buscarNumerosPares(value) {
    if(value % 2 === 0)
        return value
}

// utilizando o filter 
var numerosPares = numeros.filter(buscarNumerosPares)

console.log(numerosPares)
```

### OUTRA MANEIRA ALTERNATIVA DE FAZER

```jsx
var novo_array = arr.filter(function callback(elemento, índice, array) {
	
		// retorna true ou false 

}[, argumentoUsado])
```

📌 Function em Javascript → [Function](https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/Function)

