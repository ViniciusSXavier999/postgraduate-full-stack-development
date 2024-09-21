# PROBLEMAS PARA RESOLVER COM OPERADOR - PARTE 1

## Exercício 1

1️⃣ Escreva um algoritmo para ler o salário mensal de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário.

> Quando eu digo “ler” eu estou dizendo que vou atribuir em uma variável
> 

```jsx
/* Escreva um algoritmo para ler o salário mensal de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário. */

// salario atual
var salario = 3000

// percentual de reajuste
var reajuste = 10 

// CALCULANDO QUAL VAI SER O AUMENTO
var aumento =  salario * reajuste/100

// CALCULANDO O NOVO SALARIO
var novoSalario = salario + aumento

console.log(novoSalario)
```


## Exercício 2

2️⃣ Faça um algoritmo que leia um número inteiro e que imprima o seu sucessor e seu antecessor.

```jsx
var inteiro = 10

var sucessor;
var antecessor;

antecessor = inteiro - 1
sucessor = inteiro + 1

console.log(" O número anterior é:  " + antecessor)
console.log(" O número sucessor é:  " + sucessor)
```


## Exercício 3

2️⃣ O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicado ao custo de fábrica). Supondo que o percentual
do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, calcular e escrever o custo final ao consumidor.

```jsx
var custoFabrica = 40000
var porcentagem = 28
var impostos = 45

var custoFinal =  custoFabrica * porcentagem/100 + custoFabrica * impostos/100 + custoFabrica


console.log("O custo final ao consumidor é: " + custoFinal)
```