// reduz os valores á um unico valor
var numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


var soma = numeros.reduce(function(tootal, valor){
  return  tootal + valor
}, 0)

console.log(soma)