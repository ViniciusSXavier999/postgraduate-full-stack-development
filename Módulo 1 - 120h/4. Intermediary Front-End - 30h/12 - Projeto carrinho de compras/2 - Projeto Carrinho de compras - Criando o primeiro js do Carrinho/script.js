// Definindo as variaveis do valor total do primeiro item e o valor total do segundo item
// Esse array vai representar a quantidade total do primeiro e do segundo item (a soma que esta sendo adicionada de produto)
var valorTotal = [0, 0]

// valor do primeiro produto e do segundo produto
var valorProduto = [50.00,30.00]

// valor da quantidade que se inicia 
/* Toda vez que eu adicionarItem() eu necessito que os valores sejam alterados */
var quantidade = [0,0]

var qtd = [0,0]

// essa função vai ser responsavel para quando eu clicar no '+' no carrinho a quantidade de produto seja adicionada e ela faça uma conta

/* o 'item' significa que estou fazendo uma concatenação de string para poder acessar o meu id do HTML */

// eu utilizo esse parametro já que eu desejo utilizar esse método dinamicamente
function adicionarItem(item){ 

    var quantidade = document.getElementById('quantidade' + item)

    // pegando o total
    var total = document.getElementById('total' + item)

    /* se eu quero alterar do produto 0, ele vai estar qtd0 que é a primeira posição */
    qtd[item] += 1

    // conta que vai alterar o valor total para ficar correto
    // o valor total vai ser o valor do produto * a quantidade de produtos
    valorTotal[item] = Number.parseFloat(valorProduto[item]) * qtd[item] // o valor produto 0 é o 50.00 que está na posição 0 do array

    // A quantidade vai ser o que estiver escrito no meu array na posição 0 
    quantidade.innerHTML = qtd[item]
    total.innerHTML = valorTotal[item].toFixed(2) // ToFixed() coloca apenas duas casas decimais
}