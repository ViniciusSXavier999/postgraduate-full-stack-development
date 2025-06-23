# 3 → DEPENDENCY INVERSION PRINCIPLE

### DEFINIÇÕES QUE ABORDAM ESSA QUESTÃO

### FRASE 01

🏆 O Princípio de inversão de dependência é a estratégia de depender de interfaces ou funções e classes abstratas, em vez de funções e classes concretas.

### O que é classe concreta?

Classes **concretas** são classes **completas**, que **podem ser instanciadas** (ou seja, você pode criar objetos a partir delas).

---

### ✅ Resumo rápido:

- **Classe concreta**: tem **implementações reais** dos métodos.
- **Você pode criar objetos** com `new MinhaClasse()`.

---

### 🧱 Exemplo:

```java
public class Carro {
    void ligar() {
        System.out.println("Carro ligado");
    }
}

```

Aqui, `Carro` é uma **classe concreta**. Você pode fazer:

```java
Carro c = new Carro();
c.ligar();

```

---

### ❌ Contraste com:

- **Classe abstrata**: não pode ser instanciada diretamente.
- **Interface**: define apenas o que as classes devem fazer, não como.

---


### FRASE 02

🏆 Os módulos superiores dependem de módulos dos módulos de nível inferior, que dependem de módulos de nível ainda inferior, etc

### ✅ Explicação resumida:

> Em um sistema mal projetado, módulos mais "importantes" (nível alto) dependem diretamente de detalhes de implementação (nível baixo).
> 

---

### 🧠 O que o **DIP** diz?

> Inverta essa dependência!
> 
> 
> Os módulos de alto nível **não devem depender de módulos de baixo nível**, **ambos devem depender de abstrações** (interfaces ou classes abstratas).
> 

---

### 🔧 Exemplo simples:

---

## 📦 Cenário simples: **Notificação de usuário**

Queremos que uma classe envie notificações. Podemos ter notificações por **e-mail**, **SMS**, etc.

---

### ❌ Sem DIP (errado): classe de alto nível depende diretamente da implementação concreta

```java
class Email {
    public void enviarMensagem(String msg) {
        System.out.println("Enviando por e-mail: " + msg);
    }
}

class Notificador {
    private Email email = new Email(); // DEPENDÊNCIA DIRETA

    public void notificar(String msg) {
        email.enviarMensagem(msg);
    }
}

```

🚫 Problema: se quisermos trocar `Email` por `SMS`, temos que **mudar o código da classe `Notificador`**.

---

### ✅ Com DIP (correto): alto e baixo nível dependem de **uma abstração**

```java
// Abstração (interface)
interface EnviadorMensagem {
    void enviarMensagem(String msg);
}

// Implementação 1: Email
class EnviadorEmail implements EnviadorMensagem {
    public void enviarMensagem(String msg) {
        System.out.println("Enviando por e-mail: " + msg);
    }
}

// Implementação 2: SMS
class EnviadorSMS implements EnviadorMensagem {
    public void enviarMensagem(String msg) {
        System.out.println("Enviando por SMS: " + msg);
    }
}

// Classe de alto nível depende da INTERFACE
class Notificador {
    private EnviadorMensagem enviador;

    // Injetamos a dependência por construtor
    public Notificador(EnviadorMensagem enviador) {
        this.enviador = enviador;
    }

    public void notificar(String msg) {
        enviador.enviarMensagem(msg);
    }
}

```

### 🧪 Como usar:

```java
public class Main {
    public static void main(String[] args) {
        EnviadorMensagem enviador = new EnviadorEmail(); // ou new EnviadorSMS()
        Notificador notificador = new Notificador(enviador);

        notificador.notificar("Sua pizza saiu para entrega!");
    }
}

```

---

### ✅ O que está acontecendo aqui?

- `Notificador` depende da **interface** `EnviadorMensagem`, não de `Email` ou `SMS` diretamente.
- Podemos mudar a forma de envio **sem tocar no código do `Notificador`**.
- Isso é o DIP em ação.

---


---

### IMAGEM QUE REPRESENTA ESSE ASPECTO QUE ESTAMOS ABORDANDO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dependencyInversionPrinciple1.png" />

---

🏆 Os módulos de alto nível lidam com as políticas de alto nível do aplicativo. Essas políticas geralmente se preocupam pouco com os detalhes que os implementam.

> Essas especificações devem ficar nas classes inferiores.
> 

---

### MÃO NA MASSA!!!

### CLASSE LIVRO

```java
package refatoracao.estudos.solid.dependency.inversion.principle;

public class Livro {
	
	   public void comentarioLivro() {
	        System.out.println("Comentando sobre o livro...");
	    }

	    public void paginaInicialLivro() {
	        System.out.println("Abrindo a primeira página...");
	    }

}

```

### CLASSE PRATELEIRA

```java
package refatoracao.estudos.solid.dependency.inversion.principle;

public class Prateleira {
	
	 	Livro livro;

	    public Prateleira(Livro livro) {
	        this.livro = livro;
	    }
	    
	    

	    public void addLivro() {
	        System.out.println("Livro adicionado à prateleira.");
	    }

	    public void customizarComentarios() {
	        livro.comentarioLivro();
	        System.out.println("Comentários personalizados.");
	    }

}
```



ESSA CLASSE DEPENDE DA CLASSE LIVRO DE BAIXO NÍVEL. 🏆

A classe `Prateleira` **não segue o princípio da inversão de dependência (Dependency Inversion Principle - DIP)** porque **ela depende diretamente de uma classe concreta (`Livro`) em vez de depender de uma abstração (como uma interface ou classe abstrata)**.

### Relembrando o que diz o DIP:

O **Princípio da Inversão de Dependência** (a letra "D" do SOLID) afirma que:

> "Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações."
> 

---

### Análise do código:

```java
public class Prateleira {

 	Livro livro;

 	public Prateleira(Livro livro) {
        this.livro = livro;
    }

    public void addLivro() {
        System.out.println("Livro adicionado à prateleira.");
    }

    public void customizarComentarios() {
        livro.comentarioLivro(); // <- AQUI está a dependência concreta
        System.out.println("Comentários personalizados.");
    }

}

```

Aqui, a classe `Prateleira` é um **módulo de alto nível**, e a classe `Livro` é um **módulo de baixo nível**. O problema é que a classe `Prateleira` está diretamente acoplada a `Livro`. Isso **viola o DIP**, porque qualquer mudança na implementação de `Livro` pode impactar diretamente a `Prateleira`.

---

### Como corrigir e seguir o DIP?

Você pode criar uma **interface** (ou classe abstrata), por exemplo `Publicacao`, e fazer com que `Livro` a implemente. A classe `Prateleira` então dependeria da **abstração**, não da implementação concreta:

```java
public interface Publicacao {
    void comentarioLivro();
}

```

```java
public class Livro implements Publicacao {
    public void comentarioLivro() {
        System.out.println("Comentário do livro.");
    }
}

```

```java
public class Prateleira {

    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void addLivro() {
        System.out.println("Publicação adicionada à prateleira.");
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro(); // agora é uma abstração
        System.out.println("Comentários personalizados.");
    }
}

```

---

### Benefícios dessa mudança:

- **Baixo acoplamento**: `Prateleira` não se importa se é um `Livro`, `Revista`, ou outro tipo de publicação.
- **Alta coesão** e **flexibilidade**: facilita testes e manutenção.
- **Extensibilidade**: você pode criar novas classes que implementem `Publicacao` sem alterar `Prateleira`.

---

### EXPLICAÇÃO DO CÓDIGO 🏆

Nesse código, a classe `Prateleira` foi refatorada para seguir o **Princípio da Inversão de Dependência (DIP)**, e o que está acontecendo pode ser explicado passo a passo:

---

### 📌 Explicação geral

A classe `Prateleira` agora **depende de uma abstração** chamada `Publicacao` (provavelmente uma interface ou classe abstrata), em vez de depender diretamente de uma implementação concreta como `Livro`.

---

### 🔍 Linha por linha

```java
public class Prateleira {

    private final Publicacao publicacao;

```

- Aqui, `Prateleira` declara um atributo privado chamado `publicacao`, do tipo `Publicacao` (uma **abstração**).
- A palavra-chave `final` indica que esse campo não pode ser reatribuído após o construtor. Isso favorece **imutabilidade** e **design seguro**.

---

```java
    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

```

- A injeção de dependência ocorre aqui: a abstração `Publicacao` é **injetada via construtor**.
- Isso significa que quem for criar uma instância de `Prateleira` deve fornecer uma implementação de `Publicacao` (por exemplo, um `Livro` que implementa essa interface).

---

```java
    public void addLivro() {
        System.out.println("Publicação adicionada à prateleira.");
    }

```

- Método simples que simula a adição de uma publicação à prateleira.
- A mensagem foi genérica ("Publicação", não "Livro") para refletir o uso de abstração.

---

```java
    public void customizarComentarios() {
        publicacao.comentarioLivro(); // agora é uma abstração
        System.out.println("Comentários personalizados.");
    }

```

- Este método chama o método `comentarioLivro()` da interface `Publicacao`.
- Aqui está a principal vantagem: `Prateleira` **não sabe qual é a implementação concreta** — ela só sabe que existe um comportamento (`comentarioLivro()`), e **confia** que quem implementa `Publicacao` fornecerá esse comportamento.

---

### ✅ O que está sendo feito corretamente?

- **Inversão de dependência**: `Prateleira` depende da interface `Publicacao`, não de `Livro`.
- **Desacoplamento**: `Prateleira` pode trabalhar com qualquer tipo de `Publicacao` (ex: `Livro`, `Revista`, `Artigo`, etc.).
- **Facilidade de teste**: você pode criar uma classe mock (fictícia) de `Publicacao` para testar a `Prateleira`, sem depender de lógica real de `Livro`.

---

### 📘 Resumo

Essa versão da classe `Prateleira`:

| Característica | Antes | Agora |
| --- | --- | --- |
| Tipo de dependência | Concreta (`Livro`) | Abstrata (`Publicacao`) |
| Acoplamento | Alto | Baixo |
| Flexibilidade | Baixa (só funciona com `Livro`) | Alta (pode funcionar com qualquer `Publicacao`) |
| Conformidade com DIP (SOLID) | ❌ Não segue | ✅ Segue |



### EXPLICAÇÃO DA INJEÇÃO DE DEPENDÊNCIA 🏆

### 🧠 O que é injeção de dependência?

**Injeção de dependência (DI)** é quando um **objeto externo fornece as dependências** que uma classe precisa, em vez da própria classe criá-las diretamente.

---

### ✅ No seu exemplo:

```java
public class Prateleira {
    Livro livro;

    public Prateleira(Livro livro) {
        this.livro = livro;
    }
    // ...
}

```

### 🔍 O que está acontecendo aqui?

- A classe `Prateleira` **depende de um objeto `Livro`** para funcionar.
- **Essa dependência é passada de fora**, via **construtor** → isso é **injeção de dependência por construtor**.
- Ou seja, **`Prateleira` não cria o `Livro`**, ela apenas **recebe**.

---

### 💬 Em outras palavras:

> A classe não é responsável por criar suas dependências, ela só as usa.
> 
> 
> Isso segue o **Princípio da Inversão de Dependência (DIP)**.
> 

---

### ✅ Benefícios:

- Código mais **flexível** e **testável**.
- Facilita a **substituição** do `Livro` por outra implementação, se `Livro` fosse uma interface, por exemplo.
- Ajuda a manter o **baixo acoplamento** entre as classes.

---

```java
public class Prateleira {
    Livro livro;

    public Prateleira(Livro livro) {
        this.livro = livro;
    }
    // ...
}

```

A **instanciação do objeto `Livro` não ocorre dentro da classe `Prateleira`**. Ou seja, a classe `Prateleira` **recebe** um objeto do tipo `Livro` de **fora** – isso **é um exemplo de injeção de dependência via construtor**.

---

### Onde ocorre a instanciação então?

A **instanciação ocorre fora da classe `Prateleira`**, por exemplo:

```java
Livro meuLivro = new Livro();           // AQUI ocorre a instanciação
Prateleira prateleira = new Prateleira(meuLivro);  // Injeção da dependência

```

Nesse caso, o objeto `Livro` é criado fora e **injetado no construtor** da classe `Prateleira`.

---

### Se fosse sem injeção de dependência, seria assim:

```java
public class Prateleira {
    Livro livro;

    public Prateleira() {
        this.livro = new Livro(); // AQUI ocorre a instanciação internamente
    }
}

```

Nesse caso, `Prateleira` cria a instância de `Livro` sozinha — isso **aumenta o acoplamento** e dificulta testes e manutenção.

---


### INTERFACE PRODUTO

```java
package refatoracao.estudos.solid.dependency.inversion.principle;

public interface Produto {

	void comentario();
	
	void amostra();
}
```

---

## DÚVIDAS DURANTE A AULA.

### DÚVIDA 1: Quando livro implementa publicao, automaticamente prateleira implementa tambem ?

---

### ✅ Explicando com clareza: 🏆

Quando você faz isso:

```java
public class Livro implements Publicacao {
    // implementação dos métodos da interface
}

```

- A classe `Livro` **se compromete** a implementar os métodos definidos pela interface `Publicacao`.
- Isso significa que qualquer objeto do tipo `Livro` **pode ser tratado como um `Publicacao`**.

---

### 🧠 Mas o que acontece em `Prateleira`?

```java
public class Prateleira {
    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
}

```

- Aqui, a `Prateleira` **usa/composição**: ela **recebe** (ou armazena) uma instância de `Publicacao`.
- Mas ela **não implementa** a interface `Publicacao`, a menos que você diga explicitamente:

```java
public class Prateleira implements Publicacao {
    // Agora você teria que implementar todos os métodos de Publicacao
}

```

---

### 🎯 Analogia simples:

- **Livro** é como um *funcionário* que assina um contrato (`Publicacao`) e promete seguir regras.
- **Prateleira** é como um *departamento* que contrata esse funcionário, mas o departamento **não está vinculado ao contrato**, apenas o utiliza.
- Para o departamento (Prateleira) seguir o contrato (`Publicacao`), ele teria que assiná-lo também (fazer `implements Publicacao`).

---

### ✔️ Em resumo

| Situação | Implementa a interface? | Observações |
| --- | --- | --- |
| `Livro implements Publicacao` | ✅ Sim | Livro deve implementar todos os métodos da interface |
| `Prateleira` recebe `Publicacao` como dependência | ❌ Não | Ela usa uma implementação de `Publicacao`, mas **não a implementa** |
| `Prateleira implements Publicacao` | ✅ Só se você declarar explicitamente | Teria que implementar os métodos também |

### DÚVIDA 2: Na minha classe prateleira, está ocorrendo DIP?

---

### 📌 Princípio da Inversão de Dependência (DIP) — Relembrando 🏆

> “Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.”
> 

Ou seja:

- **Código de alto nível** (como `Prateleira`) deve depender de uma **interface**, não de uma implementação concreta como `Livro`.
- A **interface (abstração)** define o que deve ser feito.
- As **implementações** (como `Livro`, `Revista`, etc.) definem **como** isso será feito.

---

### ✅ Aplicação da DIP neste código

```java
public class Prateleira {
    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void addLivro() {
        System.out.println("Publicação adicionada à prateleira.");
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro(); // agora é uma abstração
        System.out.println("Comentários personalizados.");
    }
}

```

### O que está correto aqui:

| Elemento | Por que está certo? |
| --- | --- |
| `publicacao` é do tipo `Publicacao` (uma **interface** ou **classe abstrata**) | ✔️ A classe depende de uma abstração, não de uma implementação concreta |
| O objeto real (ex: `Livro`) é passado via construtor | ✔️ Isso permite usar diferentes implementações de `Publicacao` sem mudar o código de `Prateleira` |
| A classe `Prateleira` não precisa saber se é um `Livro`, `Revista`, etc. | ✔️ Isso reduz o acoplamento e segue o DIP |

---

### 📘 Exemplo para visualizar o uso:

```java
public interface Publicacao {
    void comentarioLivro();
}

public class Livro implements Publicacao {
    public void comentarioLivro() {
        System.out.println("Comentário do livro.");
    }
}

public class Revista implements Publicacao {
    public void comentarioLivro() {
        System.out.println("Comentário da revista.");
    }
}

public class Main {
    public static void main(String[] args) {
        Publicacao livro = new Livro();
        Prateleira prateleira = new Prateleira(livro);
        prateleira.customizarComentarios();

        Publicacao revista = new Revista();
        Prateleira outraPrateleira = new Prateleira(revista);
        outraPrateleira.customizarComentarios();
    }
}

```

✅ Esse código permite trocar `Livro` por `Revista` ou qualquer outra `Publicacao` **sem alterar a lógica da `Prateleira`**, cumprindo a **inversão de dependência**.

---

### ✅ Conclusão

> ✔️ Sim, sua classe Prateleira está aplicando corretamente o DIP, porque depende de uma abstração (Publicacao) e não de uma implementação concreta (Livro).
> 

### DÚVIDA 3: ENTÃO NÃO É NECESSÁRIO UTILIZAR O IMPLEMENTS NA CLASSE?

🏆 Exatamente! ✅ **Não é necessário usar `implements` na classe `Prateleira` nesse caso.**

---

### 📌 Por quê?

A palavra-chave `implements` só é usada quando **uma classe precisa seguir um contrato definido por uma interface**, ou seja, **quando ela mesma deve oferecer os métodos definidos pela interface**.

No seu caso:

```java
public class Prateleira {
    private final Publicacao publicacao;
    ...
}

```

- A classe `Prateleira` **não está tentando ser uma `Publicacao`**.
- Ela **usa/composição** de um objeto que implementa a interface `Publicacao`.
- Portanto, **ela só depende dessa abstração**, e não precisa implementá-la.

---

### ✅ Correto:

```java
public class Prateleira {
    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro();
    }
}

```

---

### ❌ Desnecessário:

```java
public class Prateleira implements Publicacao {
    ...
}

```

Esse só seria necessário **se `Prateleira` também quisesse se comportar como uma `Publicacao`**, ou seja, **se ela própria quisesse implementar `comentarioLivro()`** — o que **não faz sentido no seu contexto atual**.

---

### ✅ Em resumo:

| Situação | Usa `implements`? | Por quê? |
| --- | --- | --- |
| `Prateleira` **usa** `Publicacao` | ❌ Não | Está apenas **consumindo** a interface via composição |
| `Livro` **é** uma `Publicacao` | ✅ Sim | Está **implementando** os métodos da interface |
| `Prateleira` precisa agir como uma `Publicacao` | ✅ Somente se necessário | Só se ela mesma tiver que ser usada como uma `Publicacao` |

---


### DÚVIDA 4: O QUE SIGNIFICA “o que é Ela usa/composição de um objeto que implementa a interface Publicacao.? pode usar livro como exemplo”?

🏆 Claro! Vamos explicar isso de forma bem direta e com exemplo usando a classe `Livro`.

---

### 📘 O que significa:

> "Ela usa/composição de um objeto que implementa a interface Publicacao"?
> 

Significa que a classe `Prateleira` **não implementa a interface `Publicacao` diretamente**, mas **possui um atributo que é uma instância de uma classe que implementa essa interface** — ou seja, **ela usa a interface indiretamente por meio de composição**.

---

### 📦 Composição — explicando o termo:

**Composição** é quando uma classe **tem** outra classe como parte de sua estrutura, geralmente como um atributo.

É diferente de **herança**, onde uma classe **é um tipo de** outra.

---

### 👇 Exemplo com `Livro` e `Publicacao`

### Interface `Publicacao`:

```java
public interface Publicacao {
    void comentarioLivro();
}

```

### Classe `Livro` que implementa a interface:

```java
public class Livro implements Publicacao {
    @Override
    public void comentarioLivro() {
        System.out.println("Comentário do livro.");
    }
}

```

### Classe `Prateleira` que **usa/composição**:

```java
public class Prateleira {
    private final Publicacao publicacao; // composição: tem uma Publicacao

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro(); // usa o comportamento da interface
        System.out.println("Comentários personalizados.");
    }
}

```

### Classe principal que junta tudo:

```java
public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro(); // Livro IMPLEMENTA Publicacao
        Prateleira prateleira = new Prateleira(livro); // Prateleira USA livro

        prateleira.customizarComentarios();
    }
}

```

---

### 🧠 Em resumo:

- `Livro` **implementa** a interface `Publicacao` → ele fornece o comportamento definido.
- `Prateleira` **usa/composição**: ela **tem um atributo** do tipo `Publicacao` (pode ser `Livro`, `Revista`, etc.).
- `Prateleira` **chama métodos da interface** por meio desse atributo, sem saber que é especificamente um `Livro`.

---

### 🎯 Vantagens de usar composição com abstração (como você fez):

- Permite mudar a implementação (usar `Livro`, `Revista`, `Artigo`, etc.) sem alterar a `Prateleira`.
- Reduz o acoplamento.
- Segue o DIP (Princípio da Inversão de Dependência).

---


### DÚVIDA 5: se é uma instancia, por que o operador new não esta sendo utilizado?

🏆 Excelente pergunta! E você está pensando da maneira certa. Vamos esclarecer isso com cuidado:

---

### ✅ Resposta curta:

O operador `new` **é usado sim — mas não dentro da classe `Prateleira`**. Ele é usado **fora dela**, no código que **instancia** a `Prateleira`, geralmente na classe `Main` ou em algum outro ponto de criação do objeto.

---

### 📌 Vamos revisar com exemplo:

### Classe `Prateleira`:

```java
public class Prateleira {
    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro();
    }
}

```

👉 Aqui, `Prateleira` **não cria** (`new`) o `Livro`. Ela **recebe** um `Publicacao` pronto via construtor.

---

### Classe `Livro`:

```java
public class Livro implements Publicacao {
    public void comentarioLivro() {
        System.out.println("Comentário do livro.");
    }
}

```

---

### Onde o `new` aparece? Aqui:

```java
public class Main {
    public static void main(String[] args) {
        Publicacao livro = new Livro(); // AQUI está o new
        Prateleira prateleira = new Prateleira(livro); // Injeção via construtor

        prateleira.customizarComentarios();
    }
}

```

🟢 O `new Livro()` **cria a instância concreta** de `Livro`, que é passada para a `Prateleira`.

---

### 🧠 Isso é um padrão de **injeção de dependência**:

- A `Prateleira` **não deve saber** como criar um `Livro` (nem usar `new Livro()`).
- Alguém de fora (como a classe `Main`, um controller, ou um framework como Spring) é que **faz a injeção da dependência**.
- Isso segue o **DIP (Dependency Inversion Principle)** e o princípio da **responsabilidade única (SRP)**.

---

### 🔥 Por que isso é bom?

Se a `Prateleira` fizesse isso:

```java
public class Prateleira {
    private final Publicacao publicacao = new Livro(); // acoplamento forte 😬
}

```

Ela estaria **acoplada à implementação `Livro`** para sempre — não daria pra usar uma `Revista` ou um `Artigo` sem mudar o código da classe.

---

### ✅ Conclusão

Você não vê o `new` dentro da `Prateleira` porque **ela não cria a dependência — ela recebe pronta**. Isso é um sinal de **bom design orientado a objetos** e prática comum em **injeção de dependência**.


### DÚVIDA 6: O que seria criar a dependência?


---

### ✅ O que significa **"criar a dependência"**? 🏆

**Criar a dependência** significa que uma classe **instancia diretamente** outra classe usando o operador `new`.

Ou seja, ela **é responsável por construir o objeto que ela mesma vai usar**.

---

### 📦 Exemplo — Criando a dependência (acoplamento forte):

```java
public class Prateleira {

    private final Livro livro;

    public Prateleira() {
        this.livro = new Livro(); // Aqui está criando a dependência diretamente
    }

    public void customizarComentarios() {
        livro.comentarioLivro();
    }
}

```

🔴 **Problema**: Agora a `Prateleira` está **fortemente acoplada** à classe `Livro`.

- Você **não pode** trocar o `Livro` por outro tipo de publicação (ex: `Revista`) sem alterar o código da classe.
- Isso **viola o DIP** e **torna o código menos flexível/testável**.

---

### ✅ Em vez disso, usamos **injeção de dependência**:

```java
public class Prateleira {

    private final Publicacao publicacao;

    public Prateleira(Publicacao publicacao) {
        this.publicacao = publicacao; // Recebe a dependência de fora
    }

    public void customizarComentarios() {
        publicacao.comentarioLivro();
    }
}

```

E em outro lugar (como na classe `Main`), **criamos a dependência** e passamos:

```java
Publicacao livro = new Livro(); // Aqui criamos a dependência
Prateleira prateleira = new Prateleira(livro); // E injetamos

```

---

### 🧠 Então em resumo:

| Termo | Significado |
| --- | --- |
| **Criar a dependência** | Usar `new` dentro da própria classe para instanciar outra classe que ela usa |
| **Injeção de dependência** | Receber a instância de outra classe já criada (geralmente por um terceiro ou framework) |

---

### 🎯 Por que evitar criar dependências internamente?

- Para **reduzir o acoplamento**
- Para **facilitar testes** (pode passar mocks ou dublês)
- Para **aumentar a flexibilidade** (mudar a implementação sem tocar no código)
- Para **seguir o DIP (Dependency Inversion Principle)**

---

