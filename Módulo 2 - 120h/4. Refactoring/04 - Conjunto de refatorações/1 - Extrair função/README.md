# 1 → EXTRAIR FUNÇÃO

🏆 Compreender e aplicar o processo de extrair uma função (e/ou método).

---

## CONCEITOS E REFLEXÃO

### FRASE 01

🏆 “O processo de extrair função (ou um método em uma linguagem orientada a objetos) é a dinâmica de observar um fragmento de código, compreender o que ele faz e, em seguida, extrair esse código para a sua própria função, com um nome baseado em seu propósito” (FOWLER, 2019).

### ✅ **Resumo da ideia:**

**Extrair função** significa **pegar um trecho de código que faz algo específico**, **dar um nome claro para esse comportamento** e **colocá-lo em uma função separada**.

Isso ajuda a:

- Tornar o código mais **legível**
- **Evitar repetições**
- Facilitar **manutenção e testes**

---

### 🧱 **Exemplo antes da extração:**

```java
public class Pagamento {

    public static void processarPagamento(double valor) {
        if (valor > 0) {
            System.out.println("Pagamento aceito");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public static void main(String[] args) {
        processarPagamento(100);
        processarPagamento(-50);
    }
}

```

---

### 🔧 **Depois da extração de método (`validarValor`)**:

```java
public class Pagamento {

    public static boolean validarValor(double valor) {
        return valor > 0;
    }

    public static void processarPagamento(double valor) {
        if (validarValor(valor)) {
            System.out.println("Pagamento aceito");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public static void main(String[] args) {
        processarPagamento(100);
        processarPagamento(-50);
    }
}

```

---

### ✅ **Resumo da melhoria:**

Extraímos a lógica `valor > 0` para um método chamado `validarValor`, que tem um **nome descritivo**, deixando o método `processarPagamento` **mais limpo e fácil de entender**.

Se quiser um exemplo com múltiplas responsabilidades ou refatoração mais avançada, posso adaptar!

Vamos dizer que esse código de validação (`if valor > 0`) aparece em vários lugares. Em vez de repetir isso, extraímos para uma função separada.

### 🧠 **Explicação curta:**

> Pegamos um trecho de código que fazia algo específico (validar o valor), entendemos seu propósito, e colocamos esse trecho em uma função com nome claro (validar_valor). Isso é extrair função.
> 

### FRASE 02

🏆 “Se você tiver de dispender esforços para observar um fragmento de código e descobrir o que ele faz, então deve extraí-lo em uma função e atribuir-lhe um nome com base no ‘o quê’ ele faz.

> Nós não devemos deixar várias informações jogadas no nosso código.
> 

> Quando nós temos um processo, o ideal é criar uma função especifico para realizar aquele processo.
> 

---

## MÃO NA MASSA!!

### CLASSE MAIN

🏆 Temos 3 elementos que poderiam ser extraídos e separados:

1. DEFINIÇÃO DAS VARIÁVEIS
2. CALCULOS 
3. EXIBIÇÃO NA TELA

Dessa maneira, nosso código ficaria organizado.

</aside>

```java
package refatoracao.conjunto.refatoracoes.extrair.funcao;

public class Main {

	public static void main(String[] args) {
		
		// DEFINIÇÃO DE DOIS OBJETOS E ATRIBUIÇÕES
		int a = 1;
		int b = 2;
		
		// DOIS CALCULOS QUE SÃO REALIZADOS
		int c = a + b;
		int d = a +c;
		
		// EXIBIÇÃO DOS RESULTADOS OBTIDOS
		System.out.println("C" + c + "\nD: " + d);

	}

}

```

### VAMOS REALIZAR A IMPLEMENTAÇÃO DO CONCEITO DE EXTRAIR FUNÇÃO.

🏆 Essa é a importância da divisão dos recursos, nós conseguimos extrair a função, colocando a funcionalidade para ser executada de forma isolada, isso facilita muito a compreensão e organização estrutural do código.


```java
package refatoracao.conjunto.refatoracoes.extrair.funcao;

public class Main {

	public static void main(String[] args) {
		
		// DEFINIÇÃO DE OBJETOS E ATRIBUIÇÕES
		int a = 1;
		int b = 2;
		int c = 0;
		int d = 0;
		
		// DOIS CALCULOS QUE SÃO REALIZADOS
		 c = adicao(a, b);
		 d = adicao(a, c);
		
		// EXIBIÇÃO DOS RESULTADOS OBTIDOS
		vizualizacao(c);
		vizualizacao(d);

	}
	
	
	// MÉTODO RESPONSÁVEL PELO CALCULO
	private static int adicao(int num1, int num2) {
		return num1 + num2;
	}
	
	private static void vizualizacao(int num) {
		 System.out.println(num);
	}
	
	

}
```

---

---

### O QUE É UM MÉTODO STATIC EM JAVA?

### ✅ **Resumo rápido:**

Um **método `static` em Java** é um método que **pertence à classe**, e **não a um objeto**.

---

### 🔑 **Principais características:**

- Pode ser chamado **sem criar um objeto** da classe.
- **Não pode acessar diretamente atributos ou métodos de instância** (não-estáticos).
- Ideal para **funções utilitárias** ou operações que **não dependem do estado do objeto**.

---

### 📌 **Exemplo:**

```java
public class Util {
    public static int somar(int a, int b) {
        return a + b;
    }
}

```

Uso:

```java
int resultado = Util.somar(2, 3); // sem precisar de "new Util()"

```

---

### CRIANDO UM MÉTODO STATIC EM JAVA QUE ATRIBUI VALORES AS VARIÁVEIS

---

### 🎯 **Objetivo:**

Extrair este bloco:

```java
int a = 1;
int b = 2;
int c = 0;
int d = 0;

```

Para um método separado que retorne esses valores organizadamente.

---

### ✅ **Solução: usar um método `static` que retorna um objeto ou array**

Como o Java **não permite retornar múltiplos valores diretamente**, temos algumas opções. A mais clara e organizada é criar uma **classe auxiliar** para armazenar os quatro inteiros.

---

### 🧱 **1. Criando uma classe auxiliar para os valores:**

```java
public class Valores {
    public int a;
    public int b;
    public int c;
    public int d;

    public Valores(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}

```

---

### 🧠 **2. Método `static` que extrai as atribuições:**

```java
public class Main {

    public static void main(String[] args) {
        Valores valores = inicializarValores();

        int c = adicao(valores.a, valores.b);
        int d = adicao(valores.a, c);

        System.out.println("C: " + c + "\nD: " + d);
    }

    // Método extraído
    public static Valores inicializarValores() {
        int a = 1;
        int b = 2;
        int c = 0;
        int d = 0;
        return new Valores(a, b, c, d);
    }

    public static int adicao(int num1, int num2) {
        return num1 + num2;
    }
}

```

---

### 🧾 **Resultado:**

- O método `inicializarValores()` centraliza as atribuições iniciais.
- Os valores são organizados na classe `Valores`, facilitando o acesso.
- Código mais limpo e preparado para mudanças.

---



### EXPLICAÇÃO DO MÉTODO LINHA POR LINHA 🏆

Vamos analisar o método `inicializarValores()` linha por linha para entender o que ele faz.

---

### 👇 Método completo:

```java
public static Valores inicializarValores() {
    int a = 1;
    int b = 2;
    int c = 0;
    int d = 0;
    return new Valores(a, b, c, d);
}

```

---

### 🧩 **Linha por linha:**

---

### 🔹 `public static Valores inicializarValores() {`

- `public`: o método pode ser chamado de **qualquer lugar** (mesmo fora da classe, se necessário).
- `static`: o método pertence à **classe**, não a um objeto — pode ser chamado direto do `main`.
- `Valores`: é o **tipo de retorno** do método. Ele vai retornar um **objeto da classe `Valores`**, que armazena os 4 inteiros.
- `inicializarValores()`: é o **nome do método**, descritivo, indicando que ele **inicializa os valores necessários**.

---

### 🔹 `int a = 1;`

- Cria uma variável `a` do tipo `int` (inteiro) e **atribui o valor 1**.

---

### 🔹 `int b = 2;`

- Cria a variável `b` com o valor **2**.

---

### 🔹 `int c = 0;`

- Cria a variável `c` com valor inicial **0**.

---

### 🔹 `int d = 0;`

- Cria a variável `d` com valor inicial **0** também.

---

### 🔹 `return new Valores(a, b, c, d);`

- Cria um **novo objeto da classe `Valores`**, passando os 4 inteiros como argumentos para o construtor:
    
    ```java
    public Valores(int a, int b, int c, int d) { ... }
    
    ```
    
- Em seguida, retorna esse objeto para quem chamou o método.

---

### ✅ **Resumo final:**

Esse método cria e inicializa quatro variáveis (`a`, `b`, `c`, `d`), agrupa todas elas em um objeto `Valores` e retorna esse objeto. Isso ajuda a **organizar melhor o código** e **separar responsabilidades**, facilitando futuras alterações.


### NA CLASSE MAIN, É POSSÍVEL ALTERAR OS VALORES ATRIBUIDOS AS VARIÁVEIS DENTRO DO MÉTODO?

### ❓**É possível alterar os valores das variáveis `a`, `b`, `c`, `d` da classe `Valores`, mesmo elas sendo criadas dentro do método `inicializarValores()`?**

### ✅ **Sim, é possível alterar os valores!**

Mesmo que `a`, `b`, `c`, `d` **tenham sido declaradas dentro do método**, elas foram **copiadas para dentro de um objeto** da classe `Valores`, que **é retornado para o `main()`**. Então, no `main()`, você **tem acesso completo a esse objeto** — e portanto **pode alterar os atributos dele**.

---

### 👇 Exemplo:

```java
public class Main {

    public static void main(String[] args) {
        Valores valores = inicializarValores(); // recebe o objeto com os 4 valores

        // Podemos alterar os valores aqui
        valores.a = 10;
        valores.c = 50;

        System.out.println("Novo A: " + valores.a); // imprime 10
        System.out.println("Novo C: " + valores.c); // imprime 50
    }

    public static Valores inicializarValores() {
        int a = 1;
        int b = 2;
        int c = 0;
        int d = 0;
        return new Valores(a, b, c, d);
    }
}

```

---

### 🧠 Por quê?

- O método `inicializarValores()` **cria um objeto `Valores`** com os números como **cópias**.
- Quando esse objeto é retornado, ele **existe no `main`**, e seus **atributos são públicos e mutáveis** (no exemplo original).
- Logo, você **pode modificar os atributos livremente**.

---

### 🛡️ **Se quiser impedir alterações**, você pode:

1. Tornar os atributos da classe `Valores` **`private`**.
2. **Não fornecer `setters`**, apenas `getters`.
3. Tornar a classe **imutável**, como com `final`.

### POR QUE NA CLASSE MAIN EU NÃO UTILIZO O ‘`new valores()`’?

### 🤔 **Por que não usamos `new Valores()` diretamente na classe `Main`?**

Na verdade, **você até poderia usar `new Valores()` diretamente** no `main`, mas **no seu código atual isso está encapsulado dentro do método `inicializarValores()`**, que já faz isso por você.

---

### ✅ **O que está acontecendo:**

```java
Valores valores = inicializarValores();

```

Neste caso:

- Você está **chamando o método `inicializarValores()`**;
- Esse método **cria o objeto `Valores` com `new Valores(...)`** internamente;
- E então **retorna esse objeto**;
- O `main` apenas **recebe o resultado** e guarda na variável `valores`.

---

### 🔧 **Equivalente se você quisesse usar `new` diretamente no `main`:**

```java
Valores valores = new Valores(1, 2, 0, 0);

```

Ambos os jeitos funcionam.

---

### 🧠 **Por que preferir usar um método como `inicializarValores()`?**

1. **Organização do código**: separa lógica de inicialização em um lugar próprio.
2. **Reutilização**: se for usar os mesmos valores em vários lugares, você reaproveita o método.
3. **Facilidade de manutenção**: se os valores mudarem no futuro (ou vierem do usuário, de um arquivo etc.), você só altera dentro do método, não no `main`.

---

### ✅ **Resumo:**

Você **não usa `new Valores()` no `main` porque o método `inicializarValores()` já faz isso por você**. Mas se quiser, **pode sim instanciar direto** com `new`, sem problema algum.