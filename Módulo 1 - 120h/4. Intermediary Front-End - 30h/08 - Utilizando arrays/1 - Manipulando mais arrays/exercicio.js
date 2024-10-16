/* Imagina que você tem um array com todos os meses do ano, dividir ele em trimestres*/

let meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]

let trimestre1 = meses.slice(0, 3)
let trimestre2 = meses.slice(3, 6)
let trimestre3 = meses.slice(6, 9)
let trimestre4 = meses.slice(9, 12)

console.log(trimestre1)
console.log(trimestre2)
console.log(trimestre3)
console.log(trimestre4)