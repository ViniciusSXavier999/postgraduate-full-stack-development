# 5 → COMBINAR FUNÇÕES EM CLASSE

### DEFINIÇÕES IMPORTANTES

### FRASE 01

🏆 Quando vemos um grupo de funções (ou métodos) que atuam de forma muito próxima em um corpo comum de dados, podemos criar uma classe (FOWLER, 2019).

### ✅ **Resumo da ideia:**

> Quando várias funções usam os mesmos dados, é melhor agrupar tudo em uma classe, em vez de deixar solto no código.
> 

Isso melhora:

- **Organização**
- **Reutilização**
- **Manutenção**

---

### 💡 **Exemplo antes (sem classe):**

```java
String nome = "Ana";
int idade = 20;

void mostrarDados(String nome, int idade) {
    System.out.println(nome + " tem " + idade + " anos.");
}

```

---

### ✅ **Exemplo depois (com classe):**

```java
public class Pessoa {
    String nome;
    int idade;

    void mostrarDados() {
        System.out.println(nome + " tem " + idade + " anos.");
    }
}

```

---

### 🧠 **Resumo final:**

> Quando várias funções trabalham com os mesmos dados (como nome e idade), é melhor colocar tudo isso dentro de uma classe, como Pessoa, para organizar e encapsular melhor o comportamento.
> 

### FRASE 02

🏆 “Usar uma classe deixa o ambiente comum compartilhado por essas funções mais explícito, permite simplificar as chamadas de função dentro do objeto por meio da remoção de vários argumentos, além de fornecer uma referência para a passagem de um objeto como esse a outras partes do sistema” (FOWLER, 2019).

### 📌 **Resumo da ideia:**

> Criar uma classe ajuda a:
> 
1. **Compartilhar dados entre métodos facilmente**
2. **Evitar passar muitos argumentos repetidos**
3. **Passar o objeto inteiro para outros lugares do sistema**

---

### 👎 Antes (sem classe, muitos argumentos repetidos):

```java
void mostrar(String nome, int idade) {
    System.out.println(nome + " tem " + idade + " anos.");
}

void aniversario(String nome, int idade) {
    idade++;
    System.out.println(nome + " agora tem " + idade);
}

```

---

### ✅ Depois (com classe — mais simples, mais organizado):

```java
public class Pessoa {
    String nome;
    int idade;

    void mostrar() {
        System.out.println(nome + " tem " + idade + " anos.");
    }

    void aniversario() {
        idade++;
        System.out.println(nome + " agora tem " + idade);
    }
}

```

### 🧠 O que melhorou:

- ✅ **Menos argumentos** nos métodos (`nome` e `idade` já estão dentro da classe)
- ✅ Os métodos **compartilham os mesmos dados** (`nome`, `idade`)
- ✅ Podemos **passar o objeto `Pessoa` inteiro** para outros métodos ou classes com facilidade

---

### 💬 Exemplo de uso:

```java
Pessoa p = new Pessoa();
p.nome = "Ana";
p.idade = 20;

p.mostrar();
p.aniversario();

```

---

### ✅ **Resumo final:**

> Usar uma classe deixa claro que os métodos compartilham os mesmos dados, reduz a repetição de argumentos e facilita a passagem do objeto inteiro no sistema.
> 

---

## MÃO NA MASSA!!

### CLASSE VEICULO

```java
package refatoracao.conjunto.refatoracoes.combinar.funcoes.classe;

public class Veiculo {
	
	public void aceleracaoTotal() {
		System.out.println("Velocidade do veículo");
	}
	
	public void velocidade (int velocidade) {
		System.out.println("Velocidade: " + velocidade);
	}

}
```

### CLASSE MAIN

```java
package refatoracao.conjunto.refatoracoes.combinar.funcoes.classe;

public class Main {

	public static void main(String[] args) {

		Veiculo carro = new Veiculo();
		
		carro.aceleracaoTotal();
		carro.velocidade(99);
	}

}
```

🏆 Essa prática de combinar funções em classe é fundamental pois conseguimos organizar as classes e acessar aquelas informações através de outra classe, dessa forma conseguimos separar os processos e facilitar a organização estrutural do nosso código.

🏆 Caso fosse necessária poderíamos adicionar várias outras funcionalidades a classe veiculo.

