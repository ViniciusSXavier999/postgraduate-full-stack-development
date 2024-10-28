# FOR EACH

> É recomendado utilizar mais o ForEach do que o for
> 

🏆 O método forEach é usado para percorrer arrays, mas usa uma função de modo diferente do “laço for” tradicional.

- O método forEach passa uma função de callback(uma função dentro de outra função) para cada elemento do array juntamente aos seguintes parâmetros:
- Valor atual (obrigatório) - O valor do elemento atual do array
- Índice (opcional) - O número do índice do elemento atual
- Array (opcional) - O objeto de array ao qual o elemento atual pertence

```jsx
a1.forEach(function(valor, indice, array) {
	console.log(array[indice]) // Esse array é o meu próprio array, no caso o a1
}

```

> Ele é muito parecido com o MAP
> 

## Outros exemplos do uso do forEach

## 1

```jsx
numbers.forEach(function(number) {
	console.log(number)
}
```

## 2 - INLINE ARROW FUNCTION(em uma única linha)

```jsx
numbers.forEach(number => console.log(number)) // Arrow function
```

## 3

```jsx
let foods = ['bread', 'rice', 'meat', 'pizza']

foods.forEach(function(food) // Cada elemento do meu array estou chamando de 'food' 
{
	console.log(food)
})
```