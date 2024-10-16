
// UTILIZANDO SLICE()

let array = [1, 2, 3, "Hello world", 4.12, true]

// Utilizando o slice()
let newArray = array.slice(0,3)

console.log(array) // [ 1, 2, 3, 'Hello world', 4.12, true ]
console.log(newArray) // [ 1, 2, 3 ]


// UTILIZANDO O CONCAT

var pessoa = ["Eduardo", "Joana", "Wallace", "Rosana"]
var gerente = ["Davi", "Manuela"]

var empresa = pessoa.concat(gerente)

console.log(empresa)