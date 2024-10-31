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

```


---

🧑🏻‍💻 Como `li` é filho de `ul`, vamos utilizar o método `appencchild()` que vai adicionar valores `li` a `ul`

`AppendChild()`  → AppendChild **é um método que adiciona um novo elemento ao DOM (Document Object Model) de um documento HTML**. O nome appendChild é composto por append, que significa acrescentar ou anexar, e child, que significa filho ou criança (LI É FILHO DE UL)


---

## EXERCÍCIO 2

❓ Crie uma lista dinâmica de times de futebol utilizando o HTML abaixo. Sendo que cada elemento da lista deve ter uma borda azul

