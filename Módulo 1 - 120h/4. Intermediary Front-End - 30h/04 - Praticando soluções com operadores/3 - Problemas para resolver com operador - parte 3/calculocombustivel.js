/* Faça um algoritmo que efetue o cálculo da quantidade de litros de combustível gastos de uma viagem, sabendo-se que o carro faz 12 KM com um litro.
 Deverão ser fornecidos o tempo gasto na viagem e a velocidade média.
Utilizar as seguintes fórmulas O algoritmo deverá apresentar os valores da velocidade média, tempo gasto na viagem, distância percorrida e a quantidade de litros utilizados na viagem. */

var tempo = 3
var velocidade = 80

var distância = (tempo * velocidade) 

var litros = distância / 12

console.log("A velocida média foi: " + velocidade + "Km/h")
console.log("O tempo gasto na viagem foi: " + tempo + "horas")
console.log("A distância percorrida foi: " + distância + "km")
console.log("O consumo de combustível foi: " + litros + " litros")
