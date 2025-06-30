# 4 → RENOMEAR VARIÁVEL

### DEFINIÇÕES PARA COMPREENDER MELHOR O CONCEITO

### FRASE 01

🏆 “Dar bons nomes está no coração de uma programação clara. As variáveis podem fazer muito para explicar minha intenção” (FOWLER, 2019, p. 183)

> A nomenclatura das variáveis já vai representar qual é o processo que será executado, isso também facilita e muito a organização.
> 

> Quando colocamos nomes coerentes nós deixamos de necessitar da colocação de comentários.
> 

### FRASE 02

🏆 “(…) a importância de um nome depende do quão amplamente ele é usado” (FOLER, 2019, P.183).

> Assim como a nomenclatura dos atributos é importante, a dos métodos e classes também são de extrema importância.
> 

> Os nomes devem indicar qual é a funcionalidade, qual é o recurso que será armazenado, tudo isso facilita essa organização estrutural.
> 

---

## MÃO NA MASSA!

### CLASSE PESSOA

> Sempre devemos implementar(quando usamos o encapsulamento) para cada variável o método get e set
> 

🏆 Podemos observar nesse exemplo simples, a importância da nomenclatura, temos a classe pessoa com os atributos idade e nome.


```java
package refatoracao.conjunto.refatoracoes.renomear.variavel;

public class Pessoa {
	
	private int idade;
	private String nome;
	
	
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
```

### CLASSE MAIN

> Vamos fazer a atribuição desses recursos.
> 

🏆 Nesses exemplos a nomenclatura já indica efetivamente as informações que estão sendo manipuladas.
