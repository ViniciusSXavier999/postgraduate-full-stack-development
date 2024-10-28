// EXEMPLO DE FUNÇÃO MULTIPLICAR 

function multiplicar(num1, num2) {
    return num1 * num2
}

let x = multiplicar(5, 2)

console.log(x)
console.log("---------------------") 

// FUNÇÃO COM VALORES PRÉ DEFINIDOS

function funcao(a = 5, b = 10){
    return a + b
}

let y = funcao()
console.log(y)
console.log("---------------------") 

// CASO EU NÃO SAIBA A QUANTIDADE DE ARGUMENTOS QUE UMA FUNÇÃO VAI TER

function teste(...args){
    console.log(args)
}

teste(10, 190, 10, 10, 20)