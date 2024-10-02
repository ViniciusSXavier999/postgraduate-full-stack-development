```jsx
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
```