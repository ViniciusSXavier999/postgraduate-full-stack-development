// TABUADA UTILIZANDO O WHILE

var multiplicador = 0
var tabuada = 5

while (multiplicador <= 10) {
    var result = tabuada * multiplicador
    console.log(result)
    multiplicador++
    
}

console.log("-----------------------------------------")



var c = 1 

// o c vai alterando o valor até que a condição seja falsa
while(c <= 10){
    console.log(c)
    // se eu nao fizer alguma iteração com o c, o laço vai ficar infinito
    c++
}