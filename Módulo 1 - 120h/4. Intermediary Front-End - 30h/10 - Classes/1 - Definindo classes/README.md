# 1 → DEFININDO CLASSES

> Serve para as outras linguagens de programação também
> 

> Basicamente quando se trata de classes → Eu quero ter um modelo de tal coisa (exemplo de um usuário)
> 
- Todo usuário tem um nome
- Todo usuário tem um sobrenome

> Eu quero ter um modelo que toda vez que eu tiver um usuário no meu sistema ele obrigatoriamente precisa ter um nome e um sobrenome
> 

📌 Eu faço isso através de um modelo, e esse modelo é a classe, um MOLDE 


## MÉTODO CONSTRUTOR

📌 Toda vez que eu for criar um novo Usuário, esse constructor() tem que ser chamado para passar as propriedades que eu desejo que no caso é  nome e sobrenome 

```jsx
class User {

	// Todo usuário tem um nome e um sobrenome
	constructor(firstName, lastName) {
		this.firstName = firstName		
		this.lastName = lastName
}

// MÉTODO QUE IMPRIMI O NOME COMPLETO
getFullName(){
	console.log(this.firstName + " " + this.lastName)
}
```

### CRIANDO UM NOVO USUÁRIO A PARTIR DA MINHA CLASSE

```jsx
                     // Através do meu constructor foi definido que para dar vida a um usuário era necessário passar o nome e sobrenome
const user = new User("Caio", "de lima costa")

// Chamando o método a partir da variável de referência
user.getFullName() // Caio de lima costa
```


---

🏆 Quando se fala em javascript na sua definição informa que ela é orientada a objetos.  Mas o principio da orientação a objetos envolve o uso de classes. Contudo, javascript não tinha muito bem uma classe, era usado prototype para dizer que se fazia uso de classe. Sendo assim, a partir do ECMAScript 2015 (ES6), as classes começaram a fazer parte da linguagem. Isso não mudou ou adicionou funcionalidades, mas trouxe uma melhor organização para o código, além de entrar no padrão de outras tecnologias


🏆 Getter e setters são usados para proteger seus dados, especialmente na criação de classes. Para cada instância de variável, um método getter retorna seu valor, enquanto um método setter o define ou atualiza. Com isso em mente, getters e setters também são conhecidos como métodos de acesso e de modificação, respectivamente. Por convenção, getters começam com a palavra “get” e setters com a palavra “set”, seguidos de um nome de variável.

```jsx
class Person {
		constructor(name)
											// esse name é o argumento do constructor
			 this._name = name;
}

get name() {
   ...
}

set name(newName) {
   ...
}
```

---

## CONCEITO DO ENCAPSULAMENTO

📌 Você não pode chegar lá e mudar o nome da pessoa de qualquer forma, isso não pode, para isso utilizamos o get, para pegar o valor atribuído ao nome e o set para atribuir um nome respectivamente.

