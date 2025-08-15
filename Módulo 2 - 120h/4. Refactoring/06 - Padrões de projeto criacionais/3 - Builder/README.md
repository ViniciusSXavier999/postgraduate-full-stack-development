# 3 → BUILDER

## RESUMO DO QUE É ESSE PADRÃO DE PROJETO COM EXEMPLO SIMPLES

O **Builder** é um padrão de projeto criacional usado para **construir objetos complexos passo a passo**, separando a **lógica de construção** da **representação final**.

📌 **Em resumo:**

- Permite criar diferentes representações de um mesmo objeto usando o mesmo processo de construção.
- É útil quando um objeto tem **muitos parâmetros** opcionais ou passos de montagem.
- Evita **construtores enormes** e confusos (o famoso *telescoping constructor*).

**Componentes principais:**

1. **Builder** – Interface ou classe abstrata que define os passos para construir o objeto.
2. **Concrete Builder** – Implementa esses passos, montando o objeto final.
3. **Product** – O objeto final a ser construído.
4. **Director** (opcional) – Controla a ordem de execução dos passos.

**Exemplo bem curto:**

```java
class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    private Pessoa(Builder b) {
        this.nome = b.nome;
        this.idade = b.idade;
        this.cidade = b.cidade;
    }

    public static class Builder {
        private String nome;
        private int idade;
        private String cidade;

        public Builder nome(String nome) { this.nome = nome; return this; }
        public Builder idade(int idade) { this.idade = idade; return this; }
        public Builder cidade(String cidade) { this.cidade = cidade; return this; }
        public Pessoa build() { return new Pessoa(this); }
    }
}

// Uso:
Pessoa p = new Pessoa.Builder()
               .nome("João")
               .idade(30)
               .cidade("São Paulo")
               .build();

```

💡 **Vantagens:** código mais legível, flexível e fácil de manter.

---

### DEFINIÇÕES CONCEITUAIS

🏆 O padrão builder visa separar a construção de um objeto complexo de sua representação para que o mesmo processo de construção possa criar diferentes representações.

> A gente consegue simplificar nossas instâncias, chamadas de objetos e métodos.
> 

🏆 O processo de construção de um objeto deve ser genérico para que ele possa ser usado para criar diferentes representações do mesmo objeto.


### EXEMPLO DO BUILDER SEM CLASSE ESTÁTICA INTERNA

🏆 Exemplo: `Pessoa` com *Builder* externo

---

```java
// Classe que será construída
public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    // Construtor "package-private" para forçar uso do builder
    Pessoa(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome + ", " + idade + " anos, mora em " + cidade;
    }
}

```

---

```java
// Builder externo
public class PessoaBuilder {
    private String nome;
    private int idade;
    private String cidade;

    public PessoaBuilder setNome(String nome) {
        this.nome = nome;
        return this; // encadeamento
    }

    public PessoaBuilder setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public PessoaBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Pessoa build() {
        return new Pessoa(nome, idade, cidade);
    }
}

```

---

```java
// Uso
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new PessoaBuilder()
                .setNome("João")
                .setIdade(30)
                .setCidade("São Paulo")
                .build();

        System.out.println(pessoa);
    }
}

```

---

🔹 **O que mudou**

- O *Builder* (`PessoaBuilder`) é **uma classe separada** e não uma classe estática dentro de `Pessoa`.
- Continua seguindo o padrão **Builder**, pois o processo de construção está separado da representação final.
- Funciona exatamente igual na hora de usar.

---

### DÚVIDA

como eu consigo fazer isso "  Pessoa pessoa = new PessoaBuilder()" se pessoaBuilder nao extends pessoa?  

 

Você consegue fazer isso porque, na verdade, o que está acontecendo nessa linha:

```java
Pessoa pessoa = new PessoaBuilder()
        .setNome("João")
        .setIdade(30)
        .setCidade("São Paulo")
        .build();

```

não é que `PessoaBuilder` **vira** um `Pessoa` diretamente.

O que acontece é:

1. **`new PessoaBuilder()`** cria um *builder*, não uma `Pessoa`.
2. Você chama vários métodos (`setNome`, `setIdade`, etc.) que **retornam o próprio builder**.
3. Quando você chama `.build()`, esse método **retorna um novo objeto `Pessoa`**.
4. Esse objeto retornado pelo `.build()` é o que está sendo atribuído à variável `pessoa`.

---

Se fosse “passo a passo” ficaria assim:

```java
PessoaBuilder builder = new PessoaBuilder();
builder.setNome("João");
builder.setIdade(30);
builder.setCidade("São Paulo");

Pessoa pessoa = builder.build(); // Aqui sim criamos o Pessoa

```

💡 **Resumo:**

Você não precisa de `extends` porque o `PessoaBuilder` **não é** um `Pessoa`.

O builder é só uma classe **que sabe construir** um `Pessoa` e, no final, te entrega um objeto desse tipo.

---


---

### DÚVIDA SOBRE O “RETURN THIS”

🏆 Quando você coloca **`return this;`** dentro de um método, você está dizendo:

> "Depois que esse método terminar, devolva o próprio objeto que chamou o método."
> 

---

### Exemplo simples:

```java
public class Pessoa {
    private String nome;

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this; // devolve o próprio objeto Pessoa
    }
}

```

### O que acontece ao usar:

```java
Pessoa p = new Pessoa()
    .setNome("João");

```

- `new Pessoa()` → cria um novo objeto.
- `.setNome("João")` → executa o método **setNome** e retorna **o mesmo objeto**.
- Isso permite **continuar** chamando outros métodos logo na sequência, sem precisar criar outra variável.

---

### Sem `return this`

```java
public class Pessoa {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
}

```

Uso:

```java
Pessoa p = new Pessoa();
p.setNome("João"); // não dá para encadear com outros métodos diretamente

```

---

**Resumindo:**

`return this;` serve para **encadear métodos** no **mesmo objeto**, muito usado no **Builder Pattern** e APIs “fluidas”.

---


---

### MÃO NA MASSA! PRATICANDO! (CÓDIGO NO GITHUB)

🏆 Estamos realizando a construção e manipulação de ingredientes da nossa receita.

🏆 Cada método vai retornar o mesmo objeto builder


---

### POR QUE UTILIZAR O PADRÃO BUILDER?

🏆 Beleza — vamos pegar exatamente o seu exemplo de `Pessoa` e **remover o padrão Builder** para ver a diferença.

---

## **Sem o padrão Builder**

```java
class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    // Construtor tradicional com todos os parâmetros
    public Pessoa(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }
}

// Uso:
Pessoa p = new Pessoa("João", 30, "São Paulo");

```

---

## **Diferença prática**

| **Com Builder** | **Sem Builder** |
| --- | --- |
| Permite criar objetos passo a passo, escolhendo apenas os atributos que você quer definir. | Você precisa passar **todos** os parâmetros no construtor, mesmo que alguns sejam opcionais. |
| Código fica mais legível com nomes de métodos (`.nome("João")` em vez de lembrar a ordem dos parâmetros). | Ordem dos parâmetros importa, e é fácil confundir (`"São Paulo", 30, "João"` seria um erro). |
| Evita a criação de múltiplos construtores sobrecarregados para diferentes combinações de atributos. | Se tiver muitos atributos opcionais, você acaba criando vários construtores diferentes ou usando `null`. |
| Mais seguro contra erros de ordem e valores nulos indevidos. | Menos seguro e mais difícil de manter se a classe crescer. |

---

💡 **Resumo**

O padrão **Builder** é útil principalmente quando:

- O objeto tem **muitos atributos opcionais**.
- Você quer **evitar construtores com listas enormes de parâmetros**.
- Você quer **código mais legível e fácil de manter**.

Se o seu objeto for simples (3 ou 4 atributos obrigatórios), provavelmente **não vale a pena usar Builder**.

---

