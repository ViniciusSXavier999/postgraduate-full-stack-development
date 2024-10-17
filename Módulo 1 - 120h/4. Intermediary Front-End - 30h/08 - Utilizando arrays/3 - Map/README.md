# MAP

> Quando observamos um desenvolvedor utilizando o map, pode se dizer que essa pessoa tem um pouco mais de conhecimento, pois o map não é tão comum para quem esta iniciando.
> 



🏆 O método Array.map() permite a você iterar sobre o array e modificar seus elementos usando uma função de callback. 

A função de callback será executada em cada um dos elementos do array

📌 O QUE É FUNÇÃO CALLBACK? → Uma função callback é uma função passada a outra função como argumento, que é então invocado dentro da função externa para completar algum tipo de rotina ou ação. 

[Função Callback - Glossário do MDN Web Docs: Definições de termos relacionados à Web | MDN](https://developer.mozilla.org/pt-BR/docs/Glossary/Callback_function)

🏆 A sintaxe do método map()

`arr.map(function(elemento, índice, array){ }, this);`


🏆 function() é a função de callback chamada para cada elemento do array. O método map() sempre passa o elemento atual, o índiice do eleemento atual e todo o objeto do array para ela.

🏆 O argumento this será usado dentro da função de callback. Por padrão, esse valor é undefined. Por exemplo, Aqui está a forma de mudar o valor de this para o número 80:

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/mapjs.png" />



⚠️ Na primeira imagem podemos observar que podem ser passados até 3 valores para o map

- elemento → é cada elemento do meu array
- índice → é o índice do elemento do meu array, por exemplo 0, 1, 2, 3
- array → é o próprio array
- this → é um numero que você pode estar inicializando

> Na terceira imagem podemos ver o exemplo do método map, para cada elemento dentro do meu array que está sendo chamado de ‘element’ eu multiplico por 3
> 
