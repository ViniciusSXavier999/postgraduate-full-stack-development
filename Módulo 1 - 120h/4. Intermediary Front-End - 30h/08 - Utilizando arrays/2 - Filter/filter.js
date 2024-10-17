
// EXEMPLO 1 FILTER -> função fora do filter

var numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

function buscarNumerosPares(value) {
    if(value % 2 === 0)
        return value
}

// utilizando o filter 
var numerosPares = numeros.filter(buscarNumerosPares)

console.log(numerosPares)

// EXEMPLO 2 FILTER

const numbers = [1, 2, 3, 4]

// utilizando o filter
const evens = numbers.filter(item => item % 2 === 0);

console.log(evens) // o resultado é [2, 4]  

// EXEMPLO 3 DO USO DO FILTER -> Função dentro do filter

var numerosFiltrados = numeros.filter(

    function(valor){
        return valor > 5
    }
)

console.log(numerosFiltrados)

// EXEMPLO 4 DO USO DO FILTER -> função anonima 

var r1 = numeros.filter((valor) => {  // para cada item do meu 'numeros' vai executar essa função
    return valor < 5
} )

console.log(r1)

// EXEMPLO 5 
var r2 = numeros.filter(valor => valor < 5) // é a mesma forma dos exemplos acima, só que bem menos verbosa

// EXEMPLO 6 -> USANDO OBJETO

var funcionarios = [

    {nome: "Luiz", idade: 19},
    {nome: "Davi", idade: 12},
    {nome: "Artur", idade: 22},
    {nome: "Vinicius", idade: 30},

]

// Filtrando todos os nomes dos funcionarios
var pessoasListagem = funcionarios.filter(
    function(valor){
        // realizando o filtro de valores com < 5 letras
        return valor.nome.length < 5
    })

    console.log(pessoasListagem)



