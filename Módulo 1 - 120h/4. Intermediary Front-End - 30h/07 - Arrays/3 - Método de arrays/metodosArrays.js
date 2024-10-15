var arr1 = [1, 5, 9, 10, 13, 28]

/*
    iNVERTANDO VALORES DE UM ARRAY
    
    MÉTODO REVERSE()
 */
console.log("Método REVERSE() -> " + arr1.reverse()) // saida  no console -> [ 28, 13, 10, 9, 5, 1 ]

/*
    TRANSFORMA EM UMA STRING, E SEPARA POR EXEMPLO POR UM CARACTERE DA SUA PREFERÊNCIA

    MÉTODO JOIN()
*/

var arr2 = [9, 5, 28, 13, 50]

console.log("Método JOIN() -> " + arr2.join('|')) // saida no console -> 9|5|28|13|50

/*
    RETIRANDO O PRIMEIRO ELEMENTO DE UM ARRAY

    MÉTODO SHIFT()
*/

let retirando = arr2.shift()

// Vai imprimir no console o valor que eu retirei
console.log("Método SHIFT() (RETIREI O VALOR 9) ->  " + retirando) // saida no console -> 1

// Imprimindo Array atualizado
console.log("Método SHIFT() -> " + arr2)

/* 
    RETORNA A POSIÇÃO DO ELEMENTO QUE EU ESCOLHER DO ARRAY

    MÉTODO INDEXOF()
*/

let arr3 = [2, 5, 9, 999, 28, 1]

console.log("Método INDEXOF() -> Posição do numero 28: " + arr3.indexOf(28))


/* 
    Acrescentando item no ARRAY 

    MÉTODO  PUSH()
*/

// Acrescentando esse valor no Array
arr3.push(7)

console.log("Método PUSH() -> " + arr3)

/* 
    RETIRANDO ULTIMO ELEMENTO DO ARRAY

    MÉTODO POP()
*/

arr3.pop()

// IMPRIMINDO ARRAY ATUALIZADO
console.log("Método POP() -> " + arr3)

