# CRIANDO ELEMENTOS

> Agora imagina se você queira criar um elemento dinamicamente, por exemplo, criar uma ul com diversos itens dentro dela (li), tudo isso dinamicamente
> 

---

📌 Dinamicamente → Que se altera de modo contínuo; que tende a evoluir; em que há movimento e mudança; que se adapta com facilidade: personalidade dinâmica.


---

🧑🏻‍💻

`document.createElement()` → O método `document.createElement()` **cria um elemento HTML específico em um documento HTML**.



🧑🏻‍💻

`document.body.append(variavel)` → adicionando o elemento que eu criei no meu Javascript ao HTML

- append() → Significa acrescentar

---

## EXERCÍCIO 1

❓ Crie uma lista e adicione elementos dentro dessa lista

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercitando a criação de elementos dinamicamente através do Javascript</title>
</head>
<body>
    <ul id="lista">
        <li>Java</li>
    </ul>
</body>

<script>
    /* Crie uma lista e adicione elementos dentro dessa lista */
    
    // Acessando a ul
    var lista = document.getElementById("lista")

    // criando a li
    var li = document.createElement("li")
    // Adicionando valores a li
    li.textContent = "Quem somos"

    lista.appendChild(li)
</script>

</html>
```


---

🧑🏻‍💻 Como `li` é filho de `ul`, vamos utilizar o método `appencchild()` que vai adicionar valores `li` a `ul`

`AppendChild()`  → AppendChild **é um método que adiciona um novo elemento ao DOM (Document Object Model) de um documento HTML**. O nome appendChild é composto por append, que significa acrescentar ou anexar, e child, que significa filho ou criança (LI É FILHO DE UL)


---

## EXERCÍCIO 2

❓ Crie uma lista dinâmica de times de futebol utilizando o HTML abaixo. Sendo que cada elemento da lista deve ter uma borda azul


```html
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercitando a criação de elementos dinamicamente através do Javascript</title>
</head>
<body>
    <ul class="listaTime">

    </ul>
</body>

<script>
    /* Crie uma lista dinâmica de times de futebol utilizando o HTML abaixo. Sendo que cada elemento da lista deve ter uma borda azul */

    // Array de times, vou pegar esses valores e criar li
    times = ["Real Madrid", "Barcelona", "Juventos", "Atletico"]


    var listaDeTimes = document.querySelector("ul.listaTime")

    // varrendo o array para adicionar as li 
    for(var i = 0; i < times.length; i++){

        // colocando os elementos do meu array na variavel "time" (para cada um dos times eu coloquei o nome time)
        var time = times[i]

        // agora eu quero pegar os elementos desse array e colocar como um texto dentro de um li
        
        var li = document.createElement("li")

        // adicionando os elementos do array na li
        li.innerText = time

        // colando a borda azul
       li.style.border = "1px solid blue"

       // adicionando as li dentro da ul
       listaDeTimes.appendChild(li)
    }
</script>
</html>
```

