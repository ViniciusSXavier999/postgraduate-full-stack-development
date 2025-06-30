# 2 → EXTRAIR VARIÁVEL

🏆 Principio fundamental para organização do nosso código


---

## CONCEITOS E REFLEXÃO

### FRASE 01

🏆 “As expressões podem se tornar muito complexas e difíceis de ler. Em situações como essas, as variáveis locais podem ajudar a separar a expressão em partes mais fáceis de lidar” (FOWLER, 2019, p.163)

> Principalmente em cálculos matemáticos muito grande dentro de uma função, extrair as variáveis pode acabar ajudando e muito.
> 

> Ao invés de replicar a expressão ao longo do código, nós podemos realizar a atribuição para uma variável, aplicando o principio da extração.
> 

### 5 ETAPAS PARA EXTRAIR UMA VARIÁVEL

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/extrairVariavel01.png" />


> 1 → Nós precisamos observar se essa manipulação ela não vai causar alguma falha ao longo do nosso código, das classes, das instancias.
> 

> 2 → Antes de remover a expressão, nós vamos fazer isso por etapa, vamos verificar se o resultado continua o mesmo após atribuir a expressão para uma variável.
> 

> 3 → A substituição e o teste devem caminhar juntos.
> 

---

## MÃO NA MASSA!

### DE INICIO TEMOS A CLASSE MAIN DESSA FORMA.

🏆 PODERIAMOS REALIZAR A EXTRAÇÃO DA VARIÁVEL NESSE CALCULO(DENTRO DO IF), PORQUE ELE SE REPETE DUAS VEZES.


```java
package refatoracao.conjunto.refatoracoes.extrair.variavel;

public class MainExtrairVariavel {

	public static void main(String[] args) {
		
		double b = 5;
		double c = 7;
		double d = 0;
		
		if (b * c < 8) {
			d = (b * c) + (b/c);
		} 
		
		b = b * c;
		
		System.out.println("B: " + b + "\n" + "D: " + d);
		

	}

}
```

### APLICANDO O PRINCIPIO DA EXTRAÇÃO DE VARIÁVEL

🏆 Vamos atribuir o resultado em uma variável especifica e usar essa variável, dessa forma conseguiríamos evitar a repetição dessa mesma expressão em várias partes do código.


```java
package refatoracao.conjunto.refatoracoes.extrair.variavel;

public class MainExtrairVariavel {

	public static void main(String[] args) {
		
		double b = 5, c = 7, d = 0;
		
		double calculo = b *c;
		
		// PODERIAMOS REALIZAR A EXTRAÇÃO DA VARIÁVEL NESSE CALCULO, PORQUE ELE SE REPETE DUAS VEZES
		if (calculo < 8) {
			d = (calculo) + (b/c);
		} 
		
		b = calculo;
		
		System.out.println("B: " + b + "\n" + "D: " + d);
		

	}

}
```

### CONCLUSÃO

🏆 AO INVÉS DE REPETIR UM PROCESSO DIVERSAS VEZES, VAMOS CRIAR UMA VARIÁVEL, ATRIBUIR O VALOR DESSE PROCESSO NESSA VARIÁVEL E UTILIZAR ESSA VARIÁVEL QUANDO NECESSÁRIO.

