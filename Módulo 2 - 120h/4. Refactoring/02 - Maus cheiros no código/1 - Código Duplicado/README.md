# 1 → CÓDIGO DUPLICADO

🏆 Um dispensável é algo sem sentido e desnecessário cuja ausência tornaria o código mais limpo, mais eficiente e mais fácil de entender


---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/codigoDuplicado1.png" />

> Replicar funcionalidades ao longo do código, não é o caminho correto a se seguir, isso pode ser ajustado e deve ser ajustado o mais rápido possível
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/codigoDuplicado2.png" />
---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/codigoDuplicado3.png" />

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/codigoDuplicado4.png" />

---

## EXEMPLO:



### MANEIRA INCORRETA 🚨

Podemos observar que nesse código temos uma duplicidade nele

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class CodigoDuplicado {

	public static void main(String[] args) {
	
		float total = 0, preco = 0;
		
		boolean avancar = true;
		
		if(avancar) {
			total = preco * 0.95f;
			calcular();
		} else {
			total = preco * 0.98f;
			calcular();
		}
	}
	
	public static void calcular() {
		System.out.println("Calcular");
	}

}
```

> Estamos duplicando o método calcular 2 vezes.
> 

### MANEIRA CORRETA

### PODEMOS AJUSTAR DESSA FORMA: COLOCANDO A CHAMADA DO MÉTODO FORA DA VALIDAÇÃO 🔒

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class CodigoDuplicado {

	public static void main(String[] args) {
	
		float total = 0, preco = 0;
		
		boolean avancar = true;
		
		if(avancar) {
			total = preco * 0.95f;
	
		} else {
			total = preco * 0.98f;
			
		}
		
		calcular();
		
	}
	
	public static void calcular() {
		System.out.println("Calcular");
	}

}
```

