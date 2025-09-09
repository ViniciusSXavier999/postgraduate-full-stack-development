# 1 → REPLACE CONSTRUCTOR WITH FACTORY METHOD

💡 Vamos pensar sobre alguns ajustes que nós conseguimos realizar para conseguir obter diversos benefícios com a compreensão do código, a organização estrutural, o processo de manutenção.


---

## SUBSTITUIÇÃO DO CONSTRUTOR PARA REFATORÇÃO DO MÉTODO DE FÁBRICA.

### PROBLEMA

🚨 Você tem um construtor complexo que faz algo mais do que apenas definir valores de parâmetro em campos de objeto.


### SOLUÇÃO

✅ Crie um método de fábrica e use-o para substituir as chamadas do construtor

🏆

**"Replace Constructor with Factory Method"** significa substituir a criação de um objeto usando o **construtor diretamente (`new`)** por um **método estático (factory method)** que cria e retorna a instância.

### Em resumo:

- **Antes:** `Produto p = new Produto();`
- **Depois:** `Produto p = Produto.criarProduto();`

### Por que fazer isso?

- Dá mais **flexibilidade** para controlar como o objeto é criado.
- Permite **ocultar a lógica de criação**.
- Facilita mudanças futuras sem impactar quem usa a classe.


### O QUE É REFATORAÇÃO?

🏆 Refatoração em Java é o processo de **melhorar o código existente sem alterar seu comportamento externo**.

O objetivo é deixá-lo **mais legível, organizado, eficiente e fácil de manter**, corrigindo problemas como duplicação de código, má organização de classes ou métodos muito longos, sem mudar o que o programa faz.

🏆 Essa refatoração ela ajuda a implementar o factory method para uma classe existente, dessa maneira conseguimos organizar o projeto de uma forma objetiva.


---

### CÓDIGO DA AULA

```java
package application;

public class Objeto {
	
	public static Objeto CreateObjeto() {
		return new Objeto();
	}
	
	// INICIALIZAÇÃO DA INSTÂNCIA
	private Objeto() {
		// inicialização da instância
	}

}
```

### EXPLICAÇÃO


🏆 Esse exemplo implementa exatamente o **"Replace Constructor with Factory Method"**, mas pode ser explicado e melhorado.

---

### **O que ele faz?**

- **Construtor privado (`private Objeto()`)**: Impede que outros criem a instância usando `new Objeto()`.
- **Método de fábrica (`public static Objeto CreateObjeto()`)**: Fornece um ponto central para criar o objeto.

---

### **Por que isso é útil?**

- Permite **controlar a criação do objeto**.
- Facilita mudanças futuras (por exemplo, cache de instâncias, criação condicional, instância única).
- Torna o código **mais claro e semântico**: `Objeto.create()` é mais expressivo que `new Objeto()`.

---

### **Versão melhorada**

- Nome do método em **camelCase** (padrão Java: `createObjeto()` → `create()`).
- Pode adicionar **parâmetros de inicialização** se necessário.
- Torna o código mais limpo.

```java
public class Objeto {

    // Fábrica estática para criar a instância
    public static Objeto create() {
        return new Objeto();
    }

    // Construtor privado para controlar a criação
    private Objeto() {
        // inicialização da instância
    }
}

```

Uso:

```java
Objeto obj = Objeto.create();
```

---

