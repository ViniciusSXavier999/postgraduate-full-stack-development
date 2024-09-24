## Exercício 6

6️⃣ Para fazer uma promoção, os comerciantes estão procurando aumentar suas vendas oferecendo desconto. Faça um algoritmo que possa receber um valor de um produto e que escreva o novo valor tendo em vista que o desconto foi de 9%

🏆 Como calcular desconto? 

Para calcular um desconto em porcentagem, pode-se seguir os seguintes passos:

1. Multiplicar o valor cheio pelo percentual de desconto para obter o valor do desconto;
2. Subtrair o valor do desconto do valor cheio para obter o valor final com desconto.


```jsx

 var produto = 1000

 var valorDesconto = produto * 0.09

 var valorfinal = produto - valorDesconto

 console.log("Preço com desconto: " + valorfinal)
```


## Exercício 7

7️⃣ Faça um algoritmo que efetue o cálculo da quantidade de litros de combustível gastos de uma viagem, sabendo-se que o carro faz 12 KM com um litro. Deverão ser fornecidos o tempo gasto na viagem e a velocidade média.

Utilizar as seguintes fórmulas

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/exercicio7problemasparareslvercomoperador3.png" />

O algoritmo deverá apresentar os valores da velocidade média, tempo gasto na viagem, distância percorrida e a quantidade de litros utilizados na viagem.

```jsx

var tempo = 3
var velocidade = 80

var distância = (tempo * velocidade) 

var litros = distância / 12

console.log("A velocida média foi: " + velocidade + "Km/h")
console.log("O tempo gasto na viagem foi: " + tempo + "horas")
console.log("A distância percorrida foi: " + distância + "km")
console.log("O consumo de combustível foi: " + litros + " litros")
```
