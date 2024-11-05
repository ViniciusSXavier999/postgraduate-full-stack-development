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
    valorCompraSubtotal()
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
        valorCompraSubtotal()
    }

}

  // TODA VEZ QUE EU TIVER ADICIONANDO UM ITEM OU REMOVENDO UM ITEM, EU TENHO QUE ALTERAR ESSE VALOR SUBTOTAL: 

  /* Eu vou trabalhar com base na soma do valorTotal[0,0] que são os valores dos 2 produtos */
  // preciso saber o valor total dos produtos que serão adicionados ao meu array.

 
// ESSA CHAMADA TEM QUE ACONTECER TODA VEZ QUE EU ADICIONAR OU REMOVER UM PRODUTO, POR ESSE MOTIVO VOU COLOCAR ESSE MÉTODO NO FINAL DE AMBOS OS MÉTODOS
  function valorCompraSubtotal(){

    var subtotal = document.getElementById('valorTotalCompra')

    // para conseguir fazer essa conta é necessário fazer um loop no array

    // vou colocar o valorTotal aqui dentro dessa variavel 
    var valor = 0

    for(var i = 0; i < valorTotal.length; i++){

        // vai ser a soma do que ele esta encontrando no valor total com base no i
        valor += valorTotal[i] /* A primeira vez que eu roda o valor vai ser 0, agora imagina se eu tivesse adicionado 1 produto com o valor de 50 na posição 0, a posição 0 agora seria 50.00
        , agora eu adiciono 1 quantidade do 2 produto que é 30 na posição 1 do array, ficaria dessa forma -> [50.00, 30.00]. quando eu rodar a posição vai estar com 50 e a posição 1 com 30,
        ou seja, vou somar esses dois valores e a partir disso atribuir a variavel subtotal o valor da soma do valor dos produtos adicionados */
    }

    subtotal.innerHTML = valor.toFixed(2)


  }