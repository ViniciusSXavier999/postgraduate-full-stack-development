# DEFININDO E CHAMANDO FUNÇÕES

> É um conceito muito importante pois vai ser utilizado o tempo todo, ajuda muito a organizar o código.
> 

> É um conjunto de instrução bem definido
> 

🏆 Funções são blocos de construção fundamentais em Javascript.

Uma função é um procedimento em Javascript - um conjunto de instruções que executa uma tarefa ou calcula um valor.

Para usar uma função, você deve defini-la em algum lugar no escopo do qual você quiser chamá-la. 


> Podemos utilizar como exemplo o calculo de imposto (para cada produto existe um mesmo calculo de imposto) → Para isso eu criaria uma função que no final vai fazer o calculo desse imposto, sendo assim não seria necessária ficar repetindo código no programa, apenas a função especifica.
> 

> Quando percebemos que determinada ação terá um conjunto de instruções bem definidos, devemos criar uma função
> 

---

## DECLARANDO UMA FUNÇÃO

🏆 A definição da função (também chamada de declaração de função) consiste o uso da palavra chave function, seguida por

- NOME DA FUNÇÃO
- LISTA DE ARGUMENTOS para a função, entre parênteses e separados por vírgulas.
- DECLARAÇÕES JAVASCRIPT que definem a função, entre chaves {}

```jsx
function nome(argumento) {
	// conjunto de instruções
	
	// Esse return faz com que a gente jogue para fora o valor que queremos retornar
	return argumento * 2;

}
```

---

## EXPRESSÃO DE FUNÇÃO


🚨 Funções também podem ser criadas por uma expressão de função.

Tal função pode ser anônima; ele não tem que ter um nome.

Por exemplo, a função square poderia ter sido definida como:
```jsx
var calcula = function(numero) {return numero * 2}; // o return dele vai para calcula, tornando a função anonima

var x = calcula(4) // retorna o valor 8
```

