# 2 → INTERFACE SEGREGATION PRINCIPLE

🏆 VAMOS VER ALGUNS ASPECTOS E DEPOIS VAMOS VER UM CÓDIGO FONTE PARA ENTENDER MELHOR.


---

### FRASE 01

🏆 Muitas interfaces específicas do cliente são melhores do que uma interface geral.

> É a maneira que vamos manipular as interfaces dos nossos programas
> 

### FRASE 02

🏆 Se você tiver uma classe com vários clientes, em vez de carregar a classe com todos os métodos de que os clientes precisam, você deverá criar interfaces especificas para cada cliente e multiplicá-las para a classe.

> Quando nós vamos estruturar e organizar a interface do nosso código, nós precisamos levar esse ponto em consideração, para que o projeto fique estruturado, nós devemos implementar apenas os elementos que certamente serão usados, nós não devemos colocar recursos que não serão utilizados de forma contínua.
> 

---

### IMAGEM QUE REPRESENTA ESSE ASPECTO QUE ESTAMOS ABORDANDO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/interfaceSegregationPrinciple.png" />

---

## MÃO NA MASSA!!

🏆 Vamos imaginar que temos duas classes que nós implementamos. 


### O PRIMEIRO É A INTERFACE(RestauranteInterface) QUE TEMOS ALGUNS MÉTODOS QUE ESTAMOS RELACIONANDO

```java
package refatoracao.estudos.solid.interfacee.segregation.principle;

public interface RestauranteInterface {
	
	public void PedidoOnline();
	
	public void PedidoTel();
	
	public void pedidoPresencial();
	
	public void pagamentoOnline();
	
	public void pagamentoPresencial();

}
```

### A SEGUNDA CLASSE É A PedidoOnline QUE IMPLEMENTA A NOSSA INTERFACE

🏆 Porém nessa classe temos um problema, não é necessário nessa classe em especifico todos os métodos da nossa interface, somente o da respectiva classe que é o de pedido online.


🏆 É um exemplo muito objetivo e claro, para que a gente implemente nossa interface de forma adequada e relevante, dessa forma nós poderíamos retirar esses elementos que não seriam usados nessa classe.


🏆 Nós devemos relacionar e implementar apenas os métodos que fazem sentido para o contexto dessa classe, dessa maneira a interface seria organizada de uma forma adequada.

```java
package refatoracao.estudos.solid.interfacee.segregation.principle;

public class PedidoOnline implements RestauranteInterface {
	

	@Override
	public void PedidoOnline() {
		
		// LÓGICA PEDIDO ONLINE
		
	}

	@Override
	public void PedidoTel() {
		// LÓGICA PEDIDO TOTAL
		
	}

	@Override
	public void pedidoPresencial() {
		// LÓGICA PEDIDO PRESENCIAL
		
	}

	@Override
	public void pagamentoOnline() {
		// LÓGICA PAGAMENTO ONLINE
		
	}

	@Override
	public void pagamentoPresencial() {
		// LÓGICA PAGAMENTO PRESENCIAL
		
	}

}
```

### COMO CORRIGIR TUDO ISSO?



### 📌 Problema: 🏆

Atualmente, sua interface `RestauranteInterface` **força todas as classes que a implementam a definir métodos que talvez não precisem** — como no caso da sua classe `PedidoOnline`, que provavelmente **não precisa de `pedidoPresencial()` ou `pagamentoPresencial()`**, por exemplo.

### 🧠 O que o ISP diz?

> Nenhuma classe deve ser forçada a depender de métodos que ela não usa.
> 

---

## ✅ Como corrigir isso?

**Você deve dividir a interface grande em várias interfaces menores e mais específicas.**

---

### 🔧 Refatoração sugerida:

### 1. Crie interfaces menores:

```java
public interface PedidoOnline {
    void pedidoOnline();
}

public interface PedidoTelefone {
    void pedidoTel();
}

public interface PedidoPresencial {
    void pedidoPresencial();
}

public interface PagamentoOnline {
    void pagamentoOnline();
}

public interface PagamentoPresencial {
    void pagamentoPresencial();
}

```

---

### 2. Sua classe `PedidoOnline` agora só implementa o que **faz sentido**:

```java
public class PedidoOnlineImpl implements PedidoOnline, PagamentoOnline {

    @Override
    public void pedidoOnline() {
        System.out.println("Realizando pedido online...");
    }

    @Override
    public void pagamentoOnline() {
        System.out.println("Processando pagamento online...");
    }
}

```

Se quiser criar outra classe que atenda pedidos presenciais:

```java
public class PedidoPresencialImpl implements PedidoPresencial, PagamentoPresencial {

    @Override
    public void pedidoPresencial() {
        System.out.println("Realizando pedido no balcão...");
    }

    @Override
    public void pagamentoPresencial() {
        System.out.println("Pagamento feito em dinheiro...");
    }
}

```

---

### ✅ Benefícios:

- Cada classe **implementa só o que precisa**.
- O código fica mais **modular e fácil de manter**.
- Evita implementação de métodos vazios ou inúteis.

---

