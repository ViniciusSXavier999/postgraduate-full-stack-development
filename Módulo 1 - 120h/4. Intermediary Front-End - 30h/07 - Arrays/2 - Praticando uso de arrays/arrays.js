// Criando array a partir dos colchetes []
var valores = [8, 1, 7, 2, 9]

// Acessando valores especifios
console.log(valores[2])

console.log("-----------------------")

// percorrendo o array com o loop FOR

/* O método length a gente descobre o tamanho do array, enquanto a var i for menor que o tamanho do array, o loop vai continuar rodando */
for (var i = 0; i < valores.length; i++) {
    console.log(valores[i])
}

console.log('-----------------------')

// percorrendo array com o while
var i = 0
while (i < valores.length) {
    console.log(valores[i])

    i++
}
// --------------------------------------

// Adicionando valores de forma diferente no array

var carros = []

carros[0] = "Ferrari"
carros[1] = "Porshe"
carros[2] = "Fusca"

// Outra forma de declarar Arrays em JS
var motos = new Array("BMW", "YAMAHA", "HONDA")

console.log('---------------------------------')

// Calculando a média de todos números de um array
var soma = 0
for (var i = 0; i < valores.length; i++) {

    soma += valores[i]
    var media = soma / 5

}

console.log("A soma dos valores que está dentro do Array é: " + soma)
console.log("A média desses valores é: " + media)

console.log("--------------------------------------------------------")

// Localizar o maior valor dentro de um array

var maior = 0
for (var i = 0; i < valores.length; i++) {

    if (valores[i] > maior) {
        maior = valores[i]
    }
}
console.log(maior)

// -------------------------------------------------------------------------

console.log("-------------------------------------------------------")

// Retornando maior valor palavra dentro do array cidades

var cidades = ["Sãopaulo", "Riodejaneiro", "Fortaleza"]


var quantidadeString = 0
let palavra = 0

for(var i = 0; i < cidades.length; i++) {
    console.log(cidades[i].length)

    if (cidades[i].length > quantidadeString){
        quantidadeString = cidades[i].length 
    }

    if (cidades[i].length > cidades[palavra].length){
        palavra = i
    }

   

    
}

console.log("--------------------------------------------------")
console.log("A maior palavra tem: " + quantidadeString + " Letras " + " e a palavra é: " + cidades[palavra])



