let numbers = [1, 99, 29, 28, 26, 15]


numbers.forEach(function(n) {
    console.log(n)
})

console.log("--------------------------")
// Realizando a soma dos valores de forma diferente
var tot = 0;

numbers.forEach(valor =>  {
    tot+= valor;
})

console.log(tot)

console.log("--------------------------")
// Existe outros parametros que podemos trabalhar no forEach
numbers.forEach(function(valor, indice, array){
    console.log(array[indice])
})