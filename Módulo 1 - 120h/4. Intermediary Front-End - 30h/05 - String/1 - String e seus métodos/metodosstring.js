var nome = "Vinicius xavier"

// QUANDO EU QUERO SABER O TAMANHO DA MINHA STRING
var x = nome.length
console.log(x)

// Esse método pode ser util nesse exemplo aqui
senha = x > 10 ? "Sua senha deve ser menor que 10 letras": "Senha cadastrada com sucesso"
console.log(senha)

// COLOCANDO LETRAS TODAS MAIUSCULAS
var maiuscula = nome.toLocaleUpperCase()
console.log(maiuscula)

// DIZ A POSIÇÃO ONDE COMEÇA A PALAVRA NA FRASE 
var jogo = "Barcelona vs Corinthians"
var posicao = jogo.indexOf("Corinthians")
console.log(posicao) // 13

// O SLICE CORTA UMA FRASE 
var cortado = jogo.slice(0, 10)
console.log(cortado)