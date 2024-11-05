// Definindo as variaveis do valor total do primeiro item e o valor total do segundo item
// Esse array vai representar a quantidade total do primeiro e do segundo item (a soma que esta sendo adicionada de produto)
var valorTotal = [0, 0]

// valor do primeiro produto e do segundo produto
var valorProduto = [50.00,30.00]

// valor da quantidade que se inicia 
/* Toda vez que eu adicionarItem() eu necessito que os valores sejam alterados */ 
var qtd = [0,0]

// essa função vai ser responsavel para quando eu clicar no '+' no carrinho a quantidade de produto seja adicionada e ela faça uma conta

/* o 'item' significa que estou fazendo uma concatenação de string para poder acessar o meu id do HTML */

// eu utilizo esse parametro já que eu desejo utilizar esse método dinamicamente
function adicionarItem(item){ 

    var quantidade = document.getElementById('quantidade' + item)

    // pegando o total do elemento que eu passo como parametro do método
    var total = document.getElementById('total' + item)

    /* se eu quero alterar do produto 0, ele vai estar qtd0 que é a primeira posição e vou adicionar mais 1 */
    qtd[item] += 1

    // conta que vai alterar o valor total para ficar correto
    // o valor total vai ser o valor do produto * a quantidade de produtos
    valorTotal[item] = Number.parseFloat(valorProduto[item]) * qtd[item] // o valor produto 0 é o 50.00 que está na posição 0 do array

    // A quantidade vai ser o que estiver escrito no meu array na posição 0 
    quantidade.innerHTML = qtd[item]
    total.innerHTML = valorTotal[item].toFixed(2) // ToFixed() coloca apenas duas casas decimais
}

// --------------------------------------------------------------------------------------------------------------------------------------//

function removerItem(item) {

    // É a mesma coisa do método acima, a diferença é que vou subtrair
    if(qtd[item] > 0){
        qtd[item]-= 1;

        // AGORA EU VOU REPETIR O PASSO A PASSO PARA PODER ATUALIZAR O VALOR APÓS A REMOÇÃO DO ITEM
        var quantidade = document.getElementById('quantidade' + item)

        // colocando o elemento que tem o total0 na variavel 'total'
        var total = document.getElementById('total' + item)

        // A 'quantidade' eu quero que seja printado na minha tela o valor que está na posição do meu array [item]
        quantidade.innerHTML = qtd[item]
        // eu quero o valor de qual produto? do item, por isso coloco ele entre colchetes
        valorTotal[item] = Number.parseFloat(valorProduto[item] * qtd[item])
        total.innerHTML = valorTotal[item].toFixed(2)
    }
}