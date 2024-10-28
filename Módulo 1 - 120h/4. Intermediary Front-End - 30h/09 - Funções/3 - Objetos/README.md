## OBJETOS

[Objetos em Javascript](https://www.w3schools.com/js/js_object_definition.asp)

[W3Schools.com](https://www.w3schools.com/js/js_object_definition.asp)

> Geralmente chamamos de objeto aquelas super variáveis que tem uma coleção de valores que a gente pode se referenciar por algum nome
> 

📌 Objetos são como uma espécie de “super variáveis” que armazenam uma “coleção de valores” referenciados por nome, e que podem ser recuperados para serem utilizados em diversas outras partes de um programa. Em Javascript praticamente qualquer tipo de dado é um objeto.


📌 Cada item dessa “Coleção de valores”, é chamado de propriedade. Cada propriedade é composta por um par de “nome: valor”. Quando uma propriedade armazena uma função, ela se torna o que chamamos de método.


📌 A maneira mais simples (e recomendável) de se criar objetos em javascript é usando o que chamamos de notação literal. Um objeto literal é composto por um par de chaves “{}”, que envolve uma ou mais propriedades. Cada propriedade segue o formato “nome: valor” e devem ser separados por vírgula


### Exemplo:

```jsx
// ESSA PESSOA É UM OBJETO QUE POSSUI O NOME LUIZ E O SOBRENOME OTAVIO

const pessoa = {
// propriedades e par de valor (é o valor dele (valor da chave ou valor da propriedade))
	nome: 'Luiz',
	sobrenome: 'Otávio'
};

const chave = 'sobrenome'

// imprimindo a propriedade sobrenome do objeto
console.log(pessoa['sobrenome'])
console.log(pessoa[chave])
```