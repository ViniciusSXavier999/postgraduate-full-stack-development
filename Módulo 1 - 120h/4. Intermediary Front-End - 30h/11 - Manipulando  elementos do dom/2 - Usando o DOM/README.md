# USANDO O DOM

> Elementos da arvore do DOM
> 

---

## 1 → WINDOW → NOSSO PRIMEIRO ELEMENTO DA ÁRVORE DO DOM

🏆 Window → É a janela do navegador, onde é possível fazer algumas coisas com ela

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/window.png" />

- window.alert → uma janela com um texto e um botão de ok
- window.confirm (Bastante utilizado em carrinhos de compra) → Abre uma janela com dois botões e um texto
- window.prompt → Abre uma janela que pode ser digitado alguma coisa, e depois de digitar ele vai gravar em uma variável onde será possível realizar a manipulação

---

### EXERCÍCIO 1

❓ Agora faça o seguinte, crie um prompt informando “Digite seu nome: ”

Em seguida Guarde o nome digitado em uma variável só que em caixa alta.

Crie outro prompt informando “Digite seu sobrenome: ”

Em seguida guarde o sobrenome digitado em uma variável só que em caixa alta. 

Depois apresente nome e sobrenome digitado em uma janela de alerta

```jsx
 	 	  var nome = window.prompt("Qual é o seu nome?")
      var sobrenome = window.prompt("Qual o seu sobrenome?")

      // Retornando em caixa alta
      window.alert("O seu nome é: " + nome.toUpperCase() + " " + sobrenome.toUpperCase())
```


### EXERCÍCIO 2

❓ - Peça para o usuário digitar um número
- Guarda esse número em uma variável
- Peça para o usuário digitar outro número
- Guarda esse número em outra variável
- Agora, faça a soma dos números e apresente em uma janela de alerta

🚨 Tem uma pegadinha, toda vez que é digitado algo no prompt ele entende como uma string 

> Como ele entende que é uma string, ele concatena
> 

> É necessário transformar em int através do parse
> 

```jsx
/* 1 Peça para o usuário digitar um número
           2 Guarda esse número em uma variável
           3 Peça para o usuário digitar outro número
           4 Guarda esse número em outra variável
           5 Agora, faça a soma dos números e apresente em uma janela de alerta */

           // 1 e 2
           var numero = Number.parseInt( window.prompt("Digite um número: "))

           // 3 e 4
           var numero2 = Number.parseInt( window.prompt("Digite o segundo número: "))

           var soma = numero + numero2

           window.alert("A soma dos números é: " + soma)
```

### EXERCÍCIO 3

❓ Quando eu clicar em um botão na tela eu quero que apareça uma janela de confirmação 
```jsx

   /* Quando eu clicar em um botão na tela eu quero que apareça uma janela de confirmação */

    function confirma(){
        let confirmacao = window.confirm("Você deseja excluir esse item?")

        if(confirmacao){
            alert('Você irá excluir o item')
        } else {
            alert('Operação foi cancelada')
        }
    }
```
    
    


