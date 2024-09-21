
/* O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicado ao custo de fábrica). Supondo que o percentual
do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, calcular e escrever o custo final ao consumidor */


var custoFabrica = 40000
var porcentagem = 28
var impostos = 45

var custoFinal =  custoFabrica * porcentagem/100 + custoFabrica * impostos/100 + custoFabrica


console.log("O custo final ao consumidor é: " + custoFinal)