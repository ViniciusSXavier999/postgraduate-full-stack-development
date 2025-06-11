# 2 → FUNÇÃO LONGA

🏆 Esse é um problema que podemos corrigir através da refatoração.


---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/funcaoLonga1.png" />

> Ao invés de implementar funções grandes, com vários recursos, nós devemos simplificar e reduzir esse recurso para que o código fique legível.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/funcaoLonga2.png" />

> Nós não devemos colocar várias funcionalidades no mesmo método ou mesma classe, nós devemos dividir, dessa forma facilita até mesmo a visualização e também a manutenção do nosso código.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/funcaoLonga3.png" />

> Se nós conseguirmos criar um método com um nome relevante e coerente com o processo que será executado, não será necessário olhar de forma integral todo o processo que será executado, dessa maneira nós conseguimos bater o olho e já conseguimos identificar a maneira como nós precisamos realizar alguma alteração ou processo.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/funcaoLonga4.png" />

---

## MÃO NA MASSA!

🏆 Vamos observar que podemos extrair o método, ao invés de deixar a chamada dessa forma (supondo que estejamos lidando com outras funcionalidades)


```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class FuncaoLonga {

	public static void main(String[] args) {
		imprimir();
		
		// PRINT DETAILS
		System.out.println("Imprimir 2");
		System.out.println("Imprimir 3");
		
	}
	
	public static void imprimir() {
		System.out.println("Imprimir 1 ");
	}

}
```

🏆 Na classe main vamos ter somente a chamada dos métodos, dessa maneira o nosso código ficará muito mais organizado

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class FuncaoLonga {

	public static void main(String[] args) {
		imprimir();
		imprimir2();
		imprimir3();
	}
	
	public static void imprimir() {
		System.out.println("Imprimir 1 ");
	}
	
	public static void imprimir2() {
		System.out.println("Imprimir 2 ");
	}
	
	public static void imprimir3() {
		System.out.println("Imprimir 3 ");
	}

}
```

Nós extraímos nosso método e organizamos melhor a estrutura do nosso código, ao invés de deixar os processos soltos na classe main, nós podemos criar método relacionados.

