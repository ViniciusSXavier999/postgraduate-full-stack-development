// for in

// CRIAÇÃO DE OBJETO DE FORMA LITERAL
var carro = [{ modelo: 'Audio A3', marca: 'Audi', ano: 2020 },
{ modelo: 'x80', marca: 'Ferrari', ano: 2029 }]


/*
 
for (let i in carro){
console.log(carro[i])
}
 
*/


// UTILIZANDO O FOR
for (var i = 0; i < carro.length; i++) {
    let result = carro[i]

    // buscando somente a marca
    console.log(result.marca)

    // buscando somente o modelo
    console.log(result.modelo)
}

console.log("-----------------------------------------")

// UTILIZANDO O FOR / OF


// O FOR OF é melhor quando se quer pegar as propriedades
// Cada elemento do meu array de carro vai estar no c
for (let c of carro) {
    console.log(c.ano)
}

console.log("-----------------------------------------")
// TABUADA UTILIZANDO O FOR

var entrada = 5
var multiplicador = 0

for (var i = 0; i <= 10; i++) {
    var result = entrada * i
    console.log(entrada + "X" + i + " = " + result)
}