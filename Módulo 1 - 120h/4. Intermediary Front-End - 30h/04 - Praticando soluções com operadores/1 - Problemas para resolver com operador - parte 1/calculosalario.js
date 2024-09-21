/* Escreva um algoritmo para ler o salário mensal de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário. */

// salario atual
var salario = 3000

// percentual de reajuste
var reajuste = 10 

// CALCULANDO QUAL VAI SER O AUMENTO
var aumento =  salario * reajuste/100

// CALCULANDO O NOVO SALARIO
var novoSalario = salario + aumento

console.log("O salario com o reajuste é: " + novoSalario)