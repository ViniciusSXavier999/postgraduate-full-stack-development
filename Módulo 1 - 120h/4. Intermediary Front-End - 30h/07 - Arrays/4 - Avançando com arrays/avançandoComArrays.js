var arr = [5, 9, 10, 28, 50, 13]

/* 

Primeiro parametro é a posição que eu quero tirar

Segundo parametrô é a quantidade a partir do indice do primeiro parametro


*/
var teste = arr.splice(4, 2)

console.log("O valor que eu tirei foi: " + teste)

console.log("Array atualizado: " + arr)

var nomes = ["Maria", "João", "Lucas", "Pedro"]

// Substituindo valores do meu array por novos valores

var novos = nomes.splice(1,1, "Heliane")


console.log("Nome cortado: " + novos)
console.log(nomes)
console.log("----------------------------------")

var pais = ["Brasil", "Argentina", "Espanha"]

// Adicionando mais valores através do método unshift
// O UNSHIFGT ADICIONA UM NOVO ELEMENTO NO INICIO DO ARRAY()
pais.unshift("Estados unidos")

console.log(pais)
console.log("----------------------------------------")

/* Exercicio proposto em aula

    1 -> Criar array com 5 nomes
    2 -> Acrescentar o nome da monica
    3 -> Retirar a ultima posição do array
    4 -> Encontrar posição do samuel
    5 -> Trocar Manuel por Emanuel 

*/

// 1 
var exercicio = ["Guilherme", "Manuel", "Samuel", "Davi", "João"]

// 2
exercicio.unshift("Monica")

console.log("Array atualizado: " + exercicio)

// 3
exercicio.splice(5, 1)

console.log("Array atualizado: " + exercicio)

// 4
console.log("A posição do Samuel é: " + exercicio.indexOf("Samuel"))

// 5 
exercicio.splice(2, 1, "Emanuel")
console.log("Array atualizado: " + exercicio)