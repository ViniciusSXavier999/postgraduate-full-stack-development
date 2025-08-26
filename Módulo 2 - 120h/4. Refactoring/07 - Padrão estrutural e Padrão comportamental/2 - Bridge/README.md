# 2 → BRIDGE

---

### Situação:

Temos formas (abstração) que podem ser desenhadas de diferentes maneiras (implementação). Queremos que a forma e a maneira de desenhar possam variar **independentemente**.

---

### Código:

```java
// Implementação (interface que será a "ponte")
interface FormaImplementacao {
    void desenharCirculo(int raio);
}

// Implementações concretas
class DesenhoVermelho implements FormaImplementacao {
    public void desenharCirculo(int raio) {
        System.out.println("Desenhando círculo vermelho com raio: " + raio);
    }
}

class DesenhoAzul implements FormaImplementacao {
    public void desenharCirculo(int raio) {
        System.out.println("Desenhando círculo azul com raio: " + raio);
    }
}

// Abstração
abstract class Forma {
    protected FormaImplementacao implementacao;

    public Forma(FormaImplementacao implementacao) {
        this.implementacao = implementacao;
    }

    public abstract void desenhar();
}

// Abstração refinada
class Circulo extends Forma {
    private int raio;

    public Circulo(int raio, FormaImplementacao implementacao) {
        super(implementacao);
        this.raio = raio;
    }

    public void desenhar() {
        implementacao.desenharCirculo(raio);
    }
}

// Testando
public class BridgeDemo {
    public static void main(String[] args) {
        Forma circuloVermelho = new Circulo(10, new DesenhoVermelho());
        Forma circuloAzul = new Circulo(20, new DesenhoAzul());

        circuloVermelho.desenhar();
        circuloAzul.desenhar();
    }
}

```

---

### O que aconteceu aqui?

- **Abstração**: `Forma` e suas subclasses (`Circulo`).
- **Implementação**: `FormaImplementacao` e suas implementações (`DesenhoVermelho`, `DesenhoAzul`).
- A **ponte** é o campo `FormaImplementacao implementacao` na classe `Forma`.

Assim, você pode adicionar **novos tipos de formas** ou **novas maneiras de desenhar** sem precisar modificar todas as combinações.

---

### RELEMBRANDO SOBRE O QUE É A ABSTRAÇÃO

🏆 Uma **abstração** é uma forma de **representar apenas as características essenciais de algo**, ocultando os detalhes complexos que não são relevantes no momento. Em programação, ela serve para **definir o que um objeto faz**, sem se preocupar em **como ele faz isso**.

---

### Exemplo simples em Java:

```java
// Abstração: define o que todo animal faz, mas não diz COMO.
abstract class Animal {
    abstract void emitirSom(); // método abstrato (sem implementação aqui)
}

// Implementação concreta: cada animal sabe COMO emitir seu som
class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("O cachorro late: Au Au!");
    }
}

class Gato extends Animal {
    @Override
    void emitirSom() {
        System.out.println("O gato mia: Miau!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Cachorro(); // abstração usada
        Animal a2 = new Gato();     // abstração usada

        a1.emitirSom();
        a2.emitirSom();
    }
}

```

---

### O que é a abstração nesse exemplo?

- A classe **`Animal`** é a abstração: ela **define o comportamento geral (emitirSom)** sem mostrar os detalhes.
- As classes **`Cachorro`** e **`Gato`** implementam esse comportamento de formas diferentes.

---


---

## BRIDGE

🏆 Bridge é um padrão de projeto estrutural que permite dividir uma grande classe ou um conjunto de classes estreitamente relacionadas em duas hierarquias separadas - abstração e implementação — que podem ser desenvolvidas independentemente uma da outra.


🏆 Bridge é usado quando precisamos desacoplar uma abstração de sua implementação para que as duas possam variar de forma independente.

🏆 Esse tipo de padrão de design vem sob o padrão estrutural, pois separa a classe de implementação e a classe abstrata, fornecendo uma estrutura de ponte entre elas. 

> Essa abordagem utiliza a composição sobre herança.
> 

---

### RELEMBRANDO O USO DO SUPER()

🏆 O `super()` em Java é usado para **chamar o construtor da superclasse (classe-pai)** quando você cria um objeto de uma classe que **herda** outra.

### Resumidamente:

- Sempre deve ser a **primeira linha** do construtor.
- Serve para **inicializar os atributos ou comportamentos definidos na classe-pai**.
- Se você não escrever `super()`, o compilador chama automaticamente o construtor **padrão (sem parâmetros)** da superclasse, se ele existir.

### Exemplo simples:

```java
class Animal {
    Animal() {
        System.out.println("Construtor de Animal");
    }
}

class Cachorro extends Animal {
    Cachorro() {
        super(); // chama o construtor de Animal
        System.out.println("Construtor de Cachorro");
    }
}

public class Main {
    public static void main(String[] args) {
        new Cachorro();
    }
}

```

**Saída:**

```
Construtor de Animal
Construtor de Cachorro

```


### POR QUE A MINHA CLASSE ABSTRACT FORMA() EXIGE UM OBJETO DO TIPO COR?

🏆 Essa classe está exigindo a classe `Cor` porque **o seu construtor declara um parâmetro do tipo `Cor`**:

```java
public class Forma {
    public Forma(Cor cor) {  // <- Aqui você disse que o construtor precisa de um objeto do tipo Cor
        // ...
    }
}

```

Quando você escreve `Cor cor`, está dizendo ao compilador:

> “Para criar um objeto Forma, preciso receber um objeto que seja do tipo Cor.”
> 

Se o compilador não encontra a definição de `Cor`, ele não sabe que tipo é esse — por isso ele reclama.

### Por que isso é feito?

Provavelmente você está implementando um **padrão de projeto Bridge**, e nele a classe `Forma` é a **abstração**, enquanto `Cor` representa a **implementação** (uma interface ou classe abstrata). Assim, `Forma` depende de `Cor` para definir sua cor, mas não quer saber os detalhes de como a cor é aplicada.

Exemplo típico:

```java
// Implementação (Interface)
public interface Cor {
    void aplicarCor();
}

// Abstração
public abstract class Forma {
    protected Cor cor;

    public Forma(Cor cor) {  // Exige um tipo Cor para associar à Forma
        this.cor = cor;
    }

    public abstract void desenhar();
}

```

### Então, **a classe exige `Cor` porque você a declarou como dependência** no construtor.

Se você não quisesse essa dependência, bastaria remover o parâmetro do construtor.

---


---

## ENTENDENDO MELHOR A ESTRUTURA DO CÓDIGO

```java
	public static void main(String[] args) {
		
		Forma bola = new Circulo(new Azul());
		bola.preencher();
	}
```

🏆

```java
Forma bola = new Circulo(new Azul());

```

1. **`new Azul()`**
    - Aqui você está criando **uma instância da cor Azul**, que provavelmente implementa uma interface `Cor`.
    - Em termos de ponte (Bridge), `Azul` é a **implementação concreta da abstração de cor**.
    - Por baixo dos panos, a JVM aloca memória para o objeto `Azul` e inicializa seus atributos (se houver).
2. **`new Circulo(...)`**
    - Você está criando **um objeto do tipo `Circulo`**, que é uma subclasse de `Forma`.
    - O construtor do `Circulo` recebe a instância de `Azul` e geralmente **armazena essa referência internamente**.
    - Aqui é onde acontece o **“bridge”**: a abstração (`Forma`) está sendo ligada à implementação (`Cor`) sem que elas dependam diretamente uma da outra.
    - Por baixo dos panos, a JVM:
        - Aloca memória para o `Circulo`.
        - Guarda internamente a referência para `Azul`.
        - Executa o construtor de `Circulo`, possivelmente chamando o construtor da superclasse `Forma`.
3. **`Forma bola`**
    - `bola` é uma **variável de referência do tipo abstrato `Forma`**, mas que aponta para um objeto concreto (`Circulo`).
    - Isso é **polimorfismo**: você pode usar qualquer `Forma` concreta sem se preocupar com detalhes da implementação.
    - Por baixo dos panos, a JVM sabe que `bola` aponta para um `Circulo`, e resolve os métodos chamados em tempo de execução.

---

```java
bola.preencher();

```

1. **Chamada de método na abstração**
    - `preencher()` é um método definido em `Forma` (ou na interface que `Forma` implementa).
    - Como `bola` é, na verdade, um `Circulo`, **o método do `Circulo` é executado** (binding dinâmico da JVM).
2. **Delegação para a implementação concreta (`Azul`)**
    - Dentro do método `preencher()` de `Circulo`, provavelmente há algo como:
        
        ```java
        cor.aplicarCor();
        
        ```
        
    - Aqui o objeto `Circulo` **delegou a tarefa de preencher a cor** para o objeto `Azul`.
    - Isso é o coração do **Bridge Pattern**: a abstração (`Forma`) delega a implementação (`Cor`) para um objeto separado.
3. **Resultado final**
    - O círculo é “preenchido” com a cor azul.
    - A abstração e a implementação permanecem desacopladas, permitindo trocar cores ou formas facilmente sem modificar classes existentes.

---

✅ **Resumo detalhado da lógica**:

- `new Azul()` → cria a implementação da cor.
- `new Circulo(new Azul())` → cria a forma `Circulo` e liga a implementação da cor.
- `Forma bola` → permite usar polimorfismo, apontando para qualquer `Forma` concreta.
- `bola.preencher()` → chama o método da abstração, que **delegará à implementação da cor**.

### ESQUEMA VISUAL SIMPLES PARA ENTENDER MELHOR

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/bridge1.png" />


---

🏆 Nós não criamos programas estáticos, as mudanças podem ocorrer de forma natural sem grandes dificuldades por conta da estrutura do projeto estar relevante.

