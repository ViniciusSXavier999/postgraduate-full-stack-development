// 1 FORMA DE CRIAR OBJETOS EM JAVASCRIPT

var pessoa = {
    nome: 'Luiz', 
    sobrenome: 'Otavio'
}

console.log(pessoa['sobrenome'])
console.log('-------------------')

// 2 FORMA DE CRIAR OBJETOS

var pessoa1 = new Object

pessoa1.nome = "Angela"
pessoa1.sobrenome = "Silva"

// criando uma função para o objeto
pessoa1.falarNome = function(){
    return console.log("Nome: " + this.nome)
}

pessoa1.falarNome("Vini")
console.log('-------------------')

// FUNÇÃO PARA CRIAR PESSOA
function criarPessoa(nome, sobrenome) {
    return {nome, sobrenome}
}

// CRIANDO PESSOA 1
var p1 = criarPessoa("Vini", "Xavier")

// CRIANDO PESSOA 2
var p2 = criarPessoa("Heliane", "Melo")

console.log(p1)
console.log(p2)
