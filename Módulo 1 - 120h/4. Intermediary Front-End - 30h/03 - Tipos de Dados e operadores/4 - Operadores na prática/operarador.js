var n = 33 

// REALIZANDO CALCULOS MATEMATICOS

n+= 3 // estou dizendo que ' n ' é igual a ele mesmo + 3. RESULTADO = 6

n++ // após essa linha o resultado será 7, pois estou incrementando 1 na variável n
console.log(n)

// INCREMENTO E DECREMENTO 

var x = 10;
x++
x--
console.log(x)

// COMPARAÇÃO

var a = 99
var b = 12

console.log(n > x) //  FALSE

if(n < x) {
    console.log('oi')
}else {
    console.log('tchau')
}

console.log(n > x && a > b) // TRUE POIS AMBAS AS COMPARAÇÕES SÃO VERDADE

console.log(n > a || b > x ) // TRUE POIS APESAR DE 'n' não ser maior que 'a', 'b' é maior que 'x'

// EXERCICIOS DO VIDEO 

// VERIFICAR SE 'a' é maior do que 'b' e 'b' é divisivel por 2 
console.log(a > b && b % 2 == 0)

// VERIFICAR SE 'b' é maior ou igual que 'a' ou 'b'  dividido por 2 o resultado é 2
console.log(b >= a || b / 2 == 2) // false pois ambas as comparações são false

// VERIFICAR SE 'a' é maior que 'b' e 'b' maior ou igual a 5
console.log(a > b && b >= 5)

// UTILIZANDO TERNARIO
var par = b % 2 == 0 ? "par":"impar"

console.log(par)



