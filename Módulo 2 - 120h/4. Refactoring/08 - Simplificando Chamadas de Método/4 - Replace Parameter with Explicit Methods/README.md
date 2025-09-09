# 4 → REPLACE PARAMETER WITH EXPLICIT METHODS

**"Replace Parameter with Explicit Methods"** significa remover um parâmetro que define diferentes comportamentos de um método e, em vez disso, **criar métodos separados para cada caso**.

### Resumidamente:

- **Antes:** Um único método muda seu comportamento com base em um parâmetro.
- **Depois:** Cria-se **métodos explícitos**, cada um com um propósito claro.

### Exemplo:

**Antes:**

```java
void setStatus(String status) {
    if (status.equals("ativo")) { ... }
    else if (status.equals("inativo")) { ... }
}

```

**Depois:**

```java
void ativar() { ... }
void inativar() { ... }

```

### Vantagens:

- Código **mais legível**.
- Evita parâmetros "mágicos".
- Facilita a manutenção e o entendimento do que cada método faz.

---

### PROBLEMA

🚨 Um método é dividido em partes, cada uma das quais executada dependendo do valor de um parâmetro


### SOLUÇÃO

✅ Extraia as partes individuais do método em seus próprios métodos e chame-os em vez do método original


---

### MÃO NA MASSA!

### Temos o seguinte código com o seguinte método que poderíamos trocar os parâmetros por métodos explícitos

```java
package application;

public class Exemplo {
	
	
	void setValue(String name, int value) {
		
		if(name.equals("height")) {
			int height = value;
			return;
		}
		
		if (name.equals("width")) {
			int width = value;
			return;
		}
		
	}

}
```

🏆

### POR QUE EU DEVERIA APLICAR O CONCEITO NESSE CÓDIGO?

Você deveria aplicar **"Replace Parameter with Explicit Methods"** nesse código porque o parâmetro **`name` está controlando diferentes comportamentos dentro do mesmo método**, deixando-o **menos claro e mais sujeito a erros**.

---

### Problemas no código atual:

- O método **`setValue`** faz mais de uma coisa dependendo de uma *string* — isso dificulta a manutenção.
- Se você digitar `"heigth"` em vez de `"height"`, o erro só aparece em tempo de execução.
- O código fica **menos legível e menos seguro**.

---

### Aplicando "Replace Parameter with Explicit Methods":

Crie métodos separados para cada caso:

```java
package application;

public class Exemplo {

    int height;
    int width;

    void setHeight(int value) {
        this.height = value;
    }

    void setWidth(int value) {
        this.width = value;
    }

}

```

---

### Vantagens:

- **Mais claro:** Quem lê sabe exatamente o que o método faz.
- **Menos propenso a erros:** Não depende de strings mágicas.
- **Facilita futuras mudanças:** Cada método é isolado.

---


### CÓDIGO QUE APLICA O CONCEITO

```java
package application;

public class AplicandoConceito {

	    // Atributos da classe
	    private int height;
	    private int width;

	    // Métodos explícitos
	    public void setHeight(int arg) {
	        this.height = arg;  // atribui ao atributo da instância
	    }

	    public void setWidth(int arg) {
	        this.width = arg;   // atribui ao atributo da instância
	    }

	    // Opcional: métodos para acessar os valores
	    public int getHeight() {
	        return this.height;
	    }

	    public int getWidth() {
	        return this.width;
	    }
	}

```

🏆 Para cada variante do método, nós podemos criar um método separado, ai nós conseguimos executar esse método com base no valor de um parâmetro do método principal.
