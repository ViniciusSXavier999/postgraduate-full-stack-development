// O map pega os elementos e intera com eles

var numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

// utiliizando o map para multiplicar valores
var nums = numeros.map(function(valor){
    return valor * 2
})

console.log(nums)

// ----------------------------------------------

// Interagindo em cima do meu array de objeto que chama funcionario
var funcionarios = [
    {nome: "Vinicius", idade: 23},
    {nome: "Heliane", idade: 20},
    {nome: "Luan", idade: 30},
    {nome: "Cristian", idade: 29}
]

// Retornando o nome dos meus funcionarios
var nomes = funcionarios.map(pessoa => pessoa.nome) // Para cada item(pessoa) eu quero que ele retorne para mim isso

console.log(nomes)



