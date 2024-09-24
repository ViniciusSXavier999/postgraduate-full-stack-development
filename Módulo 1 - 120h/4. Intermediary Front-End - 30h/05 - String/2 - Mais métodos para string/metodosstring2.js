
var jogo = "Corinthians vs palmeiras"

// PROCURA SE EXISTE ALGUMA PALAVRA NA SUA STRING 
var val = jogo.includes("vs")
console.log(val)

var str1 = "Hello"
var str2 = " Brasil"

// REALIZANDO A CONCATENAÇÃO
var str3 = str1.concat(str2)
console.log(str3)

// TRIM TIRA OS ESPAÇOS EM BRANCO
var frase = "    Olá você esta aprendendo javascript"
console.log(frase.trim())

// TRANSFORMANDO EM ARRAY
var num = "1, 2, 3, 4, 5, 6, 7"

var arr = num.split(",")

console.log(arr)
