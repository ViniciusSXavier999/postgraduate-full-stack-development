class Pessoa {

    constructor(nome, sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome
    }


    falar() {
        console.log("Olá " + this.nome)
    }

    get nomeCompleto() {
        console.log("Ola " + this.nome +  this.sobrenome)
    }


}

// Instanciando e utilizando a classe
 p1 = new Pessoa("Vini", " Xavier")
 p1.falar()

 // nesse caso como estou utilizando o a palabra 'get' no inicio do método, eu não preciso utilizar os parenteses, basta somente chamar a função
 p1.nomeCompleto

