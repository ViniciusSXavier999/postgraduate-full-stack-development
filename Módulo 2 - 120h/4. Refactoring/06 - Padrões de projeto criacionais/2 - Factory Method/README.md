# 2 → FACTORY METHOD

---

## 📌 O que é o Factory Method?

O **Factory Method** é um **padrão de projeto criacional** que diz:

> "Defina um método para criar objetos, mas deixe para as subclasses decidir qual classe concreta será instanciada."
> 

Isso evita que o código cliente use `new` diretamente, deixando a lógica de criação encapsulada.

---

## 🛠 Estrutura do exemplo

### 1. Produto (Product)

Interface ou classe abstrata que define o comportamento comum.

```java
interface Notificacao {
    void enviar(String mensagem);
}

```

---

### 2. Produtos Concretos (Concrete Product)

Implementações específicas da interface.

```java
class EmailNotificacao implements Notificacao {
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

class SMSNotificacao implements Notificacao {
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

```

---

### 3. Criador (Creator)

Classe abstrata que declara o **Factory Method**.

```java
abstract class NotificacaoFactory {
    public abstract Notificacao criarNotificacao();
}

```

---

### 4. Criadores Concretos (Concrete Creator)

Cada subclasse decide qual produto criar.

```java
class EmailFactory extends NotificacaoFactory {
    public Notificacao criarNotificacao() {
        return new EmailNotificacao();
    }
}

class SMSFactory extends NotificacaoFactory {
    public Notificacao criarNotificacao() {
        return new SMSNotificacao();
    }
}

```

---

### 5. Cliente (Client)

O cliente usa a fábrica, mas **não sabe** qual classe concreta está por trás.

```java
public class Main {
    public static void main(String[] args) {
        NotificacaoFactory factory = new EmailFactory();
        Notificacao notificacao = factory.criarNotificacao();
        notificacao.enviar("Bem-vindo ao sistema!");

        factory = new SMSFactory();
        notificacao = factory.criarNotificacao();
        notificacao.enviar("Seu código de verificação é 1234");
    }
}

```

---

## 🔍 Como funciona nesse exemplo

1. **Main** pede para a fábrica criar uma notificação (`criarNotificacao()`).
2. Dependendo da **subclasse de fábrica**, ele recebe **EmailNotificacao** ou **SMSNotificacao**.
3. O cliente **não precisa saber** qual tipo concreto está sendo criado.
4. Isso deixa o código **flexível** para mudar o tipo de produto **sem mudar o cliente**.

---

### EXPLICAÇÃO DETALHADA DE COMO É FEITA A INSTACIAÇÃO NO FACTORY METHOD

🏆

```java
Notificacao notificacao = factory.criarNotificacao();

```

---

## 🖥 Passo 1 — Situação inicial na memória

Antes de chegar nessa linha, no seu código você já tinha feito:

```java
NotificacaoFactory factory = new EmailFactory();

```

📦 Memória nesse momento:

```
factory ──► [Objeto do tipo EmailFactory]

```

A variável `factory` **aponta** para um objeto da classe `EmailFactory`, mas o tipo declarado dela é `NotificacaoFactory` (abstração).

---

## 🖥 Passo 2 — Chamando o método da fábrica

Quando executa `factory.criarNotificacao()`:

- O Java olha para o **objeto real** dentro de `factory` (nesse caso, um `EmailFactory`).
- Ele vê que `EmailFactory` tem uma implementação de `criarNotificacao()`.

📜 Dentro de `EmailFactory` o código é algo assim:

```java
@Override
public Notificacao criarNotificacao() {
    return new EmailNotificacao();
}

```

Então o Java executa esse método e **cria um novo objeto `EmailNotificacao`**.

---

## 🖥 Passo 3 — Objeto criado na memória

Depois do `return new EmailNotificacao();`, a memória fica assim:

```
factory ──► [EmailFactory]
                 │
                 └─ cria ─► [EmailNotificacao]

```

O método `criarNotificacao()` devolve a **referência** para esse novo `EmailNotificacao`.

---

## 🖥 Passo 4 — Atribuição à variável `notificacao`

A variável `notificacao` recebe a referência:

```
factory ──► [EmailFactory]
notificacao ──► [EmailNotificacao]

```

Mesmo que `notificacao` seja declarada como `Notificacao`, ela pode armazenar qualquer objeto que implemente essa interface — nesse caso, `EmailNotificacao`.

---

## 🔄 O que isso garante?

- Você não precisa escrever:
    
    ```java
    EmailNotificacao notificacao = new EmailNotificacao();
    
    ```
    
- O **código cliente** (o `main`) não precisa saber **qual classe concreta** está sendo usada.
- O polimorfismo permite trocar a fábrica (`EmailFactory` → `SMSFactory`) e tudo continuar funcionando sem alterar o resto do código.

---


### MOTIVO PELO QUAL O “NEW” NÃO APARECE EXPLICITAMENTE NA CLASSE MAIN

🏆 Exatamente ✅

O `new` **não aparece** na linha:

```java
Notificacao notificacao = factory.criarNotificacao();

```

porque ele **está escondido** dentro da implementação do método `criarNotificacao()` na classe `EmailFactory`.

---

📌 No caso do `EmailFactory`, algo assim acontece por trás:

```java
@Override
public Notificacao criarNotificacao() {
    return new EmailNotificacao(); // 👈 o "new" está aqui
}

```

Ou seja:

1. **Você** chama `factory.criarNotificacao()`.
2. **A fábrica** executa o `new EmailNotificacao()` internamente.
3. **A fábrica** devolve o objeto já criado.

---

💡 Essa é justamente a **ideia do Factory Method**:

Você **terceiriza** a criação do objeto para outro método/classe, em vez de espalhar `new` por todo o código.

Assim, se amanhã quiser criar outro tipo de `Notificacao`, basta trocar a fábrica.

---


---

## FACTORY METHOD

✅

### 🔹 Diferença para Abstract Factory

- **Factory Method** → Cria **um único tipo de produto** por fábrica.
- **Abstract Factory** → Cria **famílias de produtos relacionados**.

🏆 O factory method é um padrão de projeto criacional que fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados.

> Caso você utilize um método de fábrica ao invés de um construtor, ele pode ter nomes mais descritivos e intuitivos, facilitando a visualização do código
> 

🏆 O factory Method define um método, que deve ser usado para criar objetos em vez de usar uma chamada direta do construtor.

As subclasses podem substituir esse método para alterar a classe de objetos que serão criados.


---

## COLOCANDO A MÃO NA MASSA! (CÓDIGO NO GITHUB)

🏆 A gente poderia criar outras classes de formas geométricas, isso não alteraria a nossa interface principal que é a interface forma.


---

### DÚVIDA SOBRE O TIPO DO MÉTODO

### Esse método "buscarForma" na classe formaFactory,  poderia ser de outro tipo? ou tem que ser necessariamente do tipo da interface forma?

🏆 No **padrão Abstract Factory**, o método `buscarForma` na classe `FormaFactory` **tem que retornar o tipo da interface `Forma`** (ou de uma superclasse comum) para seguir o propósito do padrão.

---

### Por que precisa ser `Forma`?

- O `FormaFactory` foi criado para **fornecer objetos que são "formas"** (`Círculo`, `Quadrado`, `Retângulo`...).
- Todos esses objetos **implementam** a interface `Forma`.
- Se o retorno de `buscarForma` não for do tipo `Forma`, você perde o polimorfismo e não poderia fazer algo como:

```java
Forma f = formaFactory.buscarForma("CIRCULO");
f.desenhar();

```

---

### Poderia mudar o tipo?

Tecnicamente sim — você pode fazer ele retornar `String`, `Object`, ou qualquer outra coisa — mas aí **você foge do conceito do Abstract Factory**.

Nesse padrão, a ideia é que **cada fábrica produza apenas um grupo de objetos relacionados** que compartilham uma mesma interface ou superclasse.

Se `buscarForma` retornasse, por exemplo, `String`, a `FormaFactory` deixaria de ser uma fábrica de formas e viraria outra coisa.

---

💡 Resumindo:

- **Para seguir o Abstract Factory** → o retorno deve ser a interface `Forma` (ou a classe base dela).
- **Para outro uso** → poderia ser outro tipo, mas aí não seria mais o mesmo padrão.

---


### CASO O MÉTODO RETORNASSE OUTRO TIPO


🏆 Se `buscarForma` **não retornar `Forma`**, exemplo:

```java
public String buscarForma(String tipo) {
    return "Círculo criado";
}

```

Então no `main` você **não pode mais** fazer:

```java
Forma f = formaFactory.buscarForma("CIRCULO");
f.desenhar(); // ❌ Erro — String não tem método desenhar()

```

Você teria que trabalhar com `String` ou outro tipo, perdendo o polimorfismo que permite tratar `Círculo`, `Quadrado` e `Retângulo` como um `Forma` genérico.

➡ Ou seja: **perde flexibilidade e foge do padrão Abstract Factory**.


### ESSE MÉTODO PODERIA FICAR NA INTERFACE FORMA?

🏆 Ele **poderia** estar na interface `Forma`, mas isso mudaria completamente o papel dela.

No **Abstract Factory**, a interface `Forma` normalmente define **o que cada forma sabe fazer** (ex.: `desenhar()`), **não como criá-la**.

O método `buscarForma(...)` é **uma responsabilidade de fábrica**, não do produto.

Se você colocasse `buscarForma` dentro de `Forma`:

```java
public interface Forma {
    void desenhar();
    Forma buscarForma(String tipo);
}

```

- Todas as classes (`Círculo`, `Quadrado`, etc.) seriam obrigadas a saber criar outras formas — o que não faz sentido, porque cada forma deveria só se preocupar em se desenhar, não em fabricar outras.
- Quebraria o **Single Responsibility Principle** (SRP) — a forma teria duas funções: ser produto e ser fábrica.

Por isso no padrão **Abstract Factory** a criação fica separada nas classes fábrica (`FormaFactory`), enquanto a interface do produto (`Forma`) só define o comportamento do objeto depois de criado.

