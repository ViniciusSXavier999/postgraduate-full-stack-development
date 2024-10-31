# ENCONTRANDO ELEMENTOS

💡 Diferença propriedade e atributo HTML E JAVASCRIPT

[Quais as diferenças entre propriedades e atributos no HTML?](https://pt.stackoverflow.com/questions/208011/quais-as-diferen%C3%A7as-entre-propriedades-e-atributos-no-html)


💡 Diferença document.querySelector() e document.getElementById() [https://cursos.alura.com.br/forum/topico-diferenca-entre-doc-getelementbyid-e-doc-queryselector-176845#:~:text=querySelector pode retornar classes%2C além,possível fazer com o getElementById](https://cursos.alura.com.br/forum/topico-diferenca-entre-doc-getelementbyid-e-doc-queryselector-176845#:~:text=querySelector%20pode%20retornar%20classes%2C%20al%C3%A9m,poss%C3%ADvel%20fazer%20com%20o%20getElementById).


---

> Vamos a partir de agora manipular os elementos em geral.
> 

> No dia a dia essa manipulação é feita o tempo todo através do Javascript
> 

---

## COMO A GENTE PEGA ESSES ELEMENTOS?

### Encontrando elementos(uma DAS formas):

Outras formas de acessar esses elementos são através dos:

- ID
- CLASSE
- NOME
- PELO SELETOR

🏆 através da tag → document.getElementByTagName(aqui coloca a tag desejada) → Esse método retorna uma coleção de todos os elementos com um nome de tag especificado.

### Exemplo

> Imagina que temos uma `ul` com varias `li`  dentro dela.
> 

```jsx
// a partir de agora teremos um array de li
var variasLi = document.getElementsByTagName("li");

// para pegar a primeiira li
var primeira = document.getElementsByTagName("li")[0]
```

> Depois que temos o elemento podemos fazer qualquer coisa com ele, Por exemplo, trocar o valor dele ou trocar a cor dele.
>

---



`innerText` → No JavaScript, o innerText é uma propriedade que **retorna o conteúdo textual de um nó e seus descendentes, ignorando as tags HTML**. O innerText é usado para obter o texto visível de um elemento, como se o usuário tivesse selecionado o conteúdo e copiado para a área de transferência. 

`getElementById` → O getElementById **é uma função do JavaScript que retorna um elemento do DOM, identificado por um ID específico**

`innerHTML` → O innerHTML **pode ser usado para receber o conteúdo de um elemento HTML ou para definir um novo conteúdo para ele**.

 `document.getElementsByName()` → O `document.getElementsByName()` **é um método do JavaScript que seleciona todos os elementos do DOM com um determinado atributo de nome**. Ele retorna um objeto NodeList, que é semelhante a um array, contendo todos os elementos selecionados


Outra maneira de estar  fazendo essas manipulações é através de seletores CSS

`document.querySelector()` → O querySelector **é um método do DOM do JavaScript que permite selecionar um elemento específico de uma página para manipular com o JavaScript**. 

O querySelector é vantajoso em relação ao getElementById, pois permite utilizar seletores CSS, o que possibilita uma seleção mais precisa e avançada.


`document.querySelector()` → Retorna uma lista de elementos presentes no documento (usando ordenação em profundidade, pré-ordenada e transversal dos nós do documento) que coincidam com o grupo de seletores especificado.

---


> Quando temos um “S” no elementS quer dizer que teremos um array.
> 



---

## EXERCÍCIO

❓ Com base no HTML a seguir coloque todos os elementos que tem a class estilo com fundo azul, letra branca e todas as letras em maisculo

```html
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercício 1</title>
</head>
<body>
    <div class="estilo">
        div com estilo
    </div>

    <div class="estilo">
        div com estilo 2
    </div>
    
    <div class="estilo">Elemento p com estilo</div>
    <p>Isso é <span class="estilo">elemento span</span> dentro de um p</p>

</body>

<script>
    /* Com base no HTML a seguir coloque todos os elementos que tem a class estilo com fundo azul, letra branca e todas as letras em maisculo */

    // selecionando todos os elementos com a class "estilo"
    element = document.querySelectorAll(".estilo")

   for (var i = 0; i < element.length; i++){
    /* o i começa valendo 0, ele vai ir realizando todas ações que eu pedi até ele voltar para a condição e verificar se i continua sendo maior que o meu array element */
        element[i].style.background = "blue"
        element[i].style.color = 'white'
        element[i].innerText = element[i].innerText.toUpperCase()
   }

</script>

</html>

```


---

🏆 Tudo isso é o que fazemos no nosso dia a dia trabalhando com seletor, como é que eu pego os meus elementos do DOM e faço a manipulação do mesmo.

> É uma questão de prática fazer isso todos os dias.
> 
