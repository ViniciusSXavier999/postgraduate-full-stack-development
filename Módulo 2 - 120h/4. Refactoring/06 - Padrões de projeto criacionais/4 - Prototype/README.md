# 4 → PROTOTYPE

🏆 O **Prototype** é um padrão de projeto criacional que **cria novos objetos copiando (clonando) um objeto existente**, em vez de instanciá-los do zero com `new`.

💡 **Quando usar**:

- Quando a criação de um objeto é **cara** (demorada, complexa ou consome muitos recursos).
- Quando você quer **duplicar** objetos mantendo suas configurações ou estado atual.

📌 **Resumo em uma frase**:

Em vez de construir um objeto do zero, o Prototype faz uma cópia de um modelo (protótipo) já existente.


🏆

---

### Exemplo: `Pessoa` com Prototype sem generics

```java
class Pessoa implements Cloneable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void mostrar() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

    @Override
    public Pessoa clone() {
        try {
            return (Pessoa) super.clone(); // usa clone do Object
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // Apenas para alterar o nome no clone
    public void setNome(String nome) {
        this.nome = nome;
    }
}

```

---

### Uso

```java
public class Main {
    public static void main(String[] args) {
        // Criação do objeto original
        Pessoa p1 = new Pessoa("João", 30);
        p1.mostrar();

        // Clonando o objeto
        Pessoa p2 = p1.clone();
        p2.setNome("Maria"); // alterando apenas o clone
        p2.mostrar();

        // Original permanece inalterado
        p1.mostrar();
    }
}

```

---

### 🔍 O que acontece:

1. `p1` é criado normalmente.
2. `p2` é criado **clonando `p1`** com `clone()`.
3. Alterações em `p2` **não afetam `p1`**, cada objeto é independente.
4. Não usamos interface genérica, apenas `Cloneable` e `clone()` da classe `Object`.

---


### DÚVIDA

🏆

### Esse nome do clone que foi alterado, antes era joao no p1?

No exemplo:

```java
Pessoa p1 = new Pessoa("João", 30);
Pessoa p2 = p1.clone();
p2.setNome("Maria");

```

- `p1` foi criado com **nome = "João"**.
- Quando você clonou (`p2 = p1.clone()`), `p2` **herdou o mesmo nome** que `p1` tinha no momento da clonagem, então **p2 também começou com nome = "João"**.
- Depois, você chamou `p2.setNome("Maria")`, então **apenas o clone mudou**.
- O `p1` continua com **nome = "João"**, porque os dois objetos são independentes após a clonagem.

💡 **Resumo visual:**

```
p1 -> nome: "João"
p2 (clone) -> nome: "João"  ---> setNome("Maria")  -> nome: "Maria"

```


---

### PADRÃO PROTOTYPE

🏆 Prototype é um padrão de projeto criacional que permite copiar objetos existentes sem tornar seu código dependente de suas classes.


🏆 O padrão Prototype delega o processo de clonagem aos objetos reais que estão sendo clonados.

Vamos simplificar essa frase:

> "O padrão Prototype delega o processo de clonagem aos objetos reais que estão sendo clonados."
> 

Significa que **cada objeto sabe como se copiar sozinho**.

---

### Explicando passo a passo:

1. **No Prototype**, você não cria um novo objeto do zero usando `new` diretamente em outro lugar.
2. **O próprio objeto original** é quem se “clona”, ou seja, **ele cria a cópia de si mesmo**.
3. Isso é feito geralmente com o método `clone()`, que copia os atributos do objeto original para o novo.

---

### Exemplo no seu caso da `Pessoa`:

```java
Pessoa p1 = new Pessoa("João", 30);
Pessoa p2 = p1.clone(); // o p1 é quem cria o p2

```

- Quem cria `p2` é **p1**, porque `clone()` está dentro da classe `Pessoa`.
- O `Main` ou outra classe **não precisa saber como copiar cada atributo**, apenas chama `p1.clone()`.

💡 **Resumo:**

O Prototype faz com que **o próprio objeto seja responsável por gerar sua cópia**, em vez de outra classe tentar criar a cópia manualmente.

---

💡 Uma das possibilidades de aplica esse principio é quando as classes são instanciadas em tempo de execução 

Quando dizemos que uma classe é **instanciada em tempo de execução**, significa que **o objeto só é criado enquanto o programa está rodando**, e não em tempo de compilação.

---

### Explicando passo a passo:

1. **Compilação**
    - O código fonte é traduzido para bytecode (ou código de máquina).
    - O compilador **não cria objetos** ainda, apenas verifica se a classe existe e se o código está correto.
2. **Tempo de execução**
    - Quando o programa está rodando (`java Main`), você pode criar objetos com `new` ou outros métodos (como `clone()` ou fábricas).
    - É nesse momento que a **memória é alocada** para o objeto e ele passa a existir de fato.

---

### Exemplo em Java:

```java
Pessoa p = new Pessoa("João", 30); // aqui o objeto Pessoa é instanciado em tempo de execução

```

- Antes dessa linha, **não existe nenhum objeto Pessoa na memória**.
- Quando o programa chega nessa linha, a JVM **aloca memória** e cria o objeto `p`.

---

💡 **Resumo:**

- **Instanciar** = criar um objeto da classe.
- **Tempo de execução** = quando o programa está rodando, não quando o código é escrito ou compilado.


🏆 O padrão declara uma interface comum para todos os objetos que suportam a clonagem. Essa interface permite clonar um objeto sem acoplar seu código à classe desse objeto.


💡 Em programação, **“acoplar”** (ou “acoplamento”) se refere a **o quanto uma parte do código depende de outra**.

---

### Explicando:

1. **Alto acoplamento**
    - Um módulo ou classe depende fortemente de outra.
    - Mudanças em uma classe **provocam mudanças** em várias outras.
    - Exemplo ruim:
        
        ```java
        class Motor {
            public void ligar() { ... }
        }
        
        class Carro {
            private Motor motor = new Motor(); // Carro está fortemente acoplado ao Motor
        }
        
        ```
        
2. **Baixo acoplamento**
    - Uma classe depende pouco ou é independente de outras.
    - Facilita manutenção, testes e reutilização.
    - Exemplo melhor:
        
        ```java
        class Carro {
            private Motor motor;
        
            public Carro(Motor motor) { // Motor é passado de fora
                this.motor = motor;
            }
        }
        
        ```
        

---

💡 **Resumo rápido:**

- **Acoplar** = criar dependência entre partes do código.
- **Menos acoplamento** é melhor: classes são mais independentes e fáceis de manter.


---

### MÃO NA MASSA! (CÓDIGO NO GITHUB)

### EXPLICANDO PARTES DO CÓDIGO QUE EU NÃO ENTENDI

```java
	private int id;
	private String nome;
	private String endereco;
	private String designacao;
	private double salario;
	
	public FuncionarioRecord() {
		System.out.println(" Registros de funcionários da Oracle Corporation ");
		System.out.println(" ------------------------------------------------- ");
		System.out.println(" Eid " + "\t"+"Enome"+"\t"+"Edesignação"+"\t"+"Esalário"+"\t\t"+"Endereço");
	}

	public FuncionarioRecord(int id, String nome, String endereco, String designacao, double salario) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.designacao = designacao;
		this.salario = salario;
	}
```

💡 Nessa classe `FuncionarioRecord`, temos **dois construtores**, e cada um cumpre um papel diferente:

---

### **1. Construtor sem parâmetros**

```java
public FuncionarioRecord() {
    System.out.println(" Registros de funcionários da Oracle Corporation ");
    System.out.println(" ------------------------------------------------- ");
    System.out.println(" Eid " + "\t"+"Enome"+"\t"+"Edesignação"+"\t"+"Esalário"+"\t\t"+"Endereço");
}

```

- **O que faz:**
    - Não recebe nenhum dado de entrada.
    - Apenas imprime um **cabeçalho** com título e colunas para exibir registros de funcionários.
- **Uso típico:**
    - Quando você quer criar um objeto apenas para exibir informações gerais, sem definir valores específicos.

---

### **2. Construtor com parâmetros**

```java
public FuncionarioRecord(int id, String nome, String endereco, String designacao, double salario) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.designacao = designacao;
    this.salario = salario;
}

```

- **O que faz:**
    - Recebe todos os atributos do funcionário como parâmetros.
    - Inicializa o objeto com **valores específicos**.
- **Uso típico:**
    - Quando você quer criar um registro de funcionário com dados concretos (id, nome, endereço, cargo, salário).

---

### **Resumo sobre os construtores da classe**

- A classe está usando **sobrecarga de construtores**: dois construtores com **assinaturas diferentes**.
- Um construtor serve para **imprimir cabeçalho** (sem dados).
- O outro serve para **armazenar os dados do funcionário** dentro do objeto.

💡 **Dica:**

Isso permite flexibilidade: você pode criar um objeto apenas para mostrar títulos ou criar um objeto já com dados completos de um funcionário.


### OBSERVAÇÃO DA PARTE FINAL DO CÓDIGO QUANDO VOU CRIAR UM NOVO FUNCIONARIO

💡

---

### Explicando linha por linha:

```java
FuncionarioRecord f1 = new FuncionarioRecord(eid, enome, eendereco, edesignacao, esalario);
f1.mostrarRecord();

```

- Cria o objeto original (`f1`) e mostra seus dados.

```java
FuncionarioRecord f2 = (FuncionarioRecord) f1.getClone();

```

- `getClone()` retorna um objeto do tipo `Prototype` (ou da interface que você definiu).
- O **cast** `(FuncionarioRecord)` serve para converter o objeto de volta para `FuncionarioRecord`.
- Depois disso, `f2` é uma cópia independente de `f1`.

```java
f2.mostrarRecord();

```

- Mostra os dados do clone.

---

### ✅ Observações

- O cast é necessário se o método `getClone()` retornar **uma interface ou classe genérica** (`Prototype`).
- Se `getClone()` já retornar `FuncionarioRecord`, o cast **não é necessário**.

---

💡 **Resumo:**

- Ambas as formas funcionam.
- Use o cast apenas quando o retorno de `getClone()` não for do tipo concreto que você quer.
