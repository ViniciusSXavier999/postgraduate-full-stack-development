# ELEMENTOS DO DOM

[Introdução ao DOM - APIs da Web | MDN](https://developer.mozilla.org/pt-BR/docs/Web/API/Document_Object_Model/Introduction)

---

> Tudo que aprendemos anteriormente, vai servir para ter a base e avançar para usar
> 
- React
- Node js
    - Com o node é possível trabalhar tanto com o front-end como também com o back-end
- Vue
- Angular

---

## Como o javascript consegue manipular as tags do HTML?

🏆 DOM → DOCUMENT OBJECT MODEL

🏆 Quando uma página é carregada, o navegador cria um Document Object Model da página


🏆 O modelo HTML DOM é construído como uma árvore de objetos (OBJECTS)


> O navegador é responsável por criar essa arvore que é o DOM
> 

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/elementosDOM1.png" />

📌 Cada elemento(tag) do HTML é como se fosse uma arvore 

💡 Essa arvore é chamada de DOM, com isso é possível pegar os elementos a partir do Javascript e manipula-los 


---

🏆 Com o modelo de objeto, Javascript tem todo o poder necessário para criar HTML dinamicamente:

- JAVASCRIPT pode alterar todos os elementos HTML na página
- JAVASCRIPT pode alterar todos os atributos dos elementos HTML na página
- JAVASCRIPT pode alterar todos os estilos CSS
- JAVASCRIPT pode remover um elemento HTML e seus atributos
- JAVASCRIPT pode adicionar um elemento HTML e seus atributos
- JAVASCRIPT pode reagir a todos os eventos que ocorreram em uma página
- JAVASCRIPT pode criar novos eventos na page

---

## SEJA O CÓDGO HTML A SEGUR

✅ Esse código vai se transformar em uma arvore, vai ser os elementos que compõe o HTML 

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/elementosDOM2.png" />

## APÓS A TRANSFORMAÇÃO

✅ Existem elementos paiis (parent), filhos(childs) e irmãos (siblings). Estes elementos são caracterizados na forma como estão  na árvore, veja o exemplo na imagem abaixo: 


<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/elementosDOM3.png" />

> META, SCRIPT E TITLE SÃO IRMÃOS
> 

> É muito importante saber como essa arvore é montada e como esses elementos estão relacionados.
> 
