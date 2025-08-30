# 3 → CHAIN OF RESPONSIBILITIES (CADEIA DE RESPONSABILIDADE)

### EXEMPLO DO QUE É E CÓDIGO

🏆

O **Chain of Responsibility (CoR)** é um padrão de projeto comportamental que **permite passar uma solicitação por uma cadeia de manipuladores**, onde cada objeto da cadeia decide:

- **Processar a solicitação**, ou
- **Passá-la adiante para o próximo manipulador**.

### **Objetivo**

- Desacoplar o remetente do pedido de seus receptores.
- Facilitar a adição/remoção de manipuladores sem alterar o código do cliente.
- Evitar estruturas de controle rígidas (`if/else` encadeados).

🏆 Um fluxo de aprovação de compras (Gerente → Diretor → CEO). Primeiro mostro o **código limpo** (sem comentários), depois explico **linha por linha** cada bloco, como você pediu.

---

```java
class Requisicao {
    private double valor;
    private String motivo;

    public Requisicao(double valor, String motivo) {
        this.valor = valor;
        this.motivo = motivo;
    }

    public double getValor() {
        return valor;
    }

    public String getMotivo() {
        return motivo;
    }
}

```

Explicação linha a linha (do bloco acima)

1. `class Requisicao {` — define a classe que representa uma solicitação de compra.
2. `private double valor;` — campo que guarda o valor da compra.
3. `private String motivo;` — campo que guarda o motivo/descrição da compra.
4. `public Requisicao(double valor, String motivo) {` — construtor que inicializa os campos.
5. `this.valor = valor;` — atribui o parâmetro `valor` ao campo interno.
6. `this.motivo = motivo;` — atribui o parâmetro `motivo` ao campo interno.
7. `}` — fecha o construtor.
8. `public double getValor() {` — início do getter para `valor`.
9. `return valor;` — retorna o valor da requisição.
10. `}` — fecha o getter.
11. `public String getMotivo() {` — início do getter para `motivo`.
12. `return motivo;` — retorna o motivo.
13. `}` — fecha o getter.
14. `}` — fecha a classe `Requisicao`.

---

```java
abstract class Aprovador {
    protected Aprovador proximo;

    public void setProximo(Aprovador proximo) {
        this.proximo = proximo;
    }

    public abstract void aprovar(Requisicao req);
}

```

Explicação linha a linha (do bloco acima)

1. `abstract class Aprovador {` — define a classe base abstrata para os aprovadores.
2. `protected Aprovador proximo;` — referência para o próximo aprovador na cadeia; começa `null`.
3. (linha em branco) — separação visual.
4. `public void setProximo(Aprovador proximo) {` — método público que conecta este aprovador ao próximo.
5. `this.proximo = proximo;` — atribui a referência passada ao campo `proximo`.
6. `}` — fecha `setProximo`.
7. (linha em branco) — separação visual.
8. `public abstract void aprovar(Requisicao req);` — declaração do método que cada subclasse implementará para tentar aprovar a requisição.
9. `}` — fecha a classe `Aprovador`.

---

```java
class Gerente extends Aprovador {
    public void aprovar(Requisicao req) {
        if (req.getValor() <= 1000) {
            System.out.println("Gerente aprovou R$ " + req.getValor() + " para: " + req.getMotivo());
        } else if (proximo != null) {
            proximo.aprovar(req);
        } else {
            System.out.println("Requisição recusada.");
        }
    }
}

```

Explicação linha a linha (do bloco acima)

1. `class Gerente extends Aprovador {` — classe concreta que representa o gerente.
2. `public void aprovar(Requisicao req) {` — implementação do contrato de aprovação.
3. `if (req.getValor() <= 1000) {` — verifica se o valor é até R$1000 (faixa do gerente).
4. `System.out.println("Gerente aprovou R$ " + req.getValor() + " para: " + req.getMotivo());` — se sim, imprime que o Gerente aprovou.
5. `} else if (proximo != null) {` — se não pode aprovar e existe próximo, prepara a delegação.
6. `proximo.aprovar(req);` — delega ao próximo aprovador (dispatch dinâmico chama a implementação correta).
7. `} else {` — se não há próximo, trata como recusado.
8. `System.out.println("Requisição recusada.");` — imprime a recusa.
9. `}` — fecha o `else`.
10. `}` — fecha o método.
11. `}` — fecha a classe `Gerente`.

---

```java
class Diretor extends Aprovador {
    public void aprovar(Requisicao req) {
        if (req.getValor() <= 10000) {
            System.out.println("Diretor aprovou R$ " + req.getValor() + " para: " + req.getMotivo());
        } else if (proximo != null) {
            proximo.aprovar(req);
        } else {
            System.out.println("Requisição recusada.");
        }
    }
}

```

Explicação linha a linha (do bloco acima)

1. `class Diretor extends Aprovador {` — classe concreta representando o diretor.
2. `public void aprovar(Requisicao req) {` — método de aprovação do Diretor.
3. `if (req.getValor() <= 10000) {` — Diretor aprova até R$10.000.
4. `System.out.println("Diretor aprovou R$ " + req.getValor() + " para: " + req.getMotivo());` — imprime aprovação do Diretor.
5. `} else if (proximo != null) {` — se valor maior e há próximo, delega.
6. `proximo.aprovar(req);` — chama o próximo na cadeia.
7. `} else {` — sem próximo, recusa.
8. `System.out.println("Requisição recusada.");` — imprime recusa.
9. `}` — fecha `else`.
10. `}` — fecha o método.
11. `}` — fecha a classe `Diretor`.

---

```java
class CEO extends Aprovador {
    public void aprovar(Requisicao req) {
        if (req.getValor() <= 50000) {
            System.out.println("CEO aprovou R$ " + req.getValor() + " para: " + req.getMotivo());
        } else {
            System.out.println("Requisição precisa de conselho executivo.");
        }
    }
}

```

Explicação linha a linha (do bloco acima)

1. `class CEO extends Aprovador {` — classe concreta do topo da cadeia.
2. `public void aprovar(Requisicao req) {` — implementação do método para o CEO.
3. `if (req.getValor() <= 50000) {` — CEO aprova até R$50.000.
4. `System.out.println("CEO aprovou R$ " + req.getValor() + " para: " + req.getMotivo());` — imprime aprovação do CEO.
5. `} else {` — se valor acima do limite do CEO.
6. `System.out.println("Requisição precisa de conselho executivo.");` — imprime que é necessário um nível superior (ou outro processo).
7. `}` — fecha `else`.
8. `}` — fecha o método.
9. `}` — fecha a classe `CEO`.

---

```java
public class ChainCompraDemo {
    public static void main(String[] args) {
        Aprovador gerente = new Gerente();
        Aprovador diretor = new Diretor();
        Aprovador ceo = new CEO();

        gerente.setProximo(diretor);
        diretor.setProximo(ceo);

        gerente.aprovar(new Requisicao(500, "Teclado novo"));
        gerente.aprovar(new Requisicao(2500, "Notebooks para equipe"));
        gerente.aprovar(new Requisicao(15000, "Licença anual de software"));
        gerente.aprovar(new Requisicao(120000, "Aquisição de servidor"));
    }
}

```

Explicação linha a linha (do bloco acima)

1. `public class ChainCompraDemo {` — classe com o `main` para demonstrar o uso.
2. `public static void main(String[] args) {` — ponto de entrada da aplicação.
3. `Aprovador gerente = new Gerente();` — cria o objeto `Gerente`.
4. `Aprovador diretor = new Diretor();` — cria o objeto `Diretor`.
5. `Aprovador ceo = new CEO();` — cria o objeto `CEO`.
6. (linha em branco) — separação visual.
7. `gerente.setProximo(diretor);` — liga Gerente → Diretor.
8. `diretor.setProximo(ceo);` — liga Diretor → CEO, formando a cadeia Gerente → Diretor → CEO.
9. (linha em branco) — separação visual.
10. `gerente.aprovar(new Requisicao(500, "Teclado novo"));` — envia requisição de R$500: Gerente resolve.
11. `gerente.aprovar(new Requisicao(2500, "Notebooks para equipe"));` — envia R$2500: Gerente passa, Diretor aprova.
12. `gerente.aprovar(new Requisicao(15000, "Licença anual de software"));` — envia R$15.000: Gerente → Diretor → CEO aprova (porque <=50k).
13. `gerente.aprovar(new Requisicao(120000, "Aquisição de servidor"));` — envia R$120.000: percorre a cadeia e o CEO diz que precisa de conselho executivo.
14. `}` — fecha o `main`.
15. `}` — fecha a classe `ChainCompraDemo`.

---

### Saída esperada no console

```
Gerente aprovou R$ 500.0 para: Teclado novo
Diretor aprovou R$ 2500.0 para: Notebooks para equipe
CEO aprovou R$ 15000.0 para: Licença anual de software
Requisição precisa de conselho executivo.

```

---

### Observações rápidas (úteis)

- A cadeia foi iniciada pelo `gerente` — o cliente só precisa conhecer o ponto de entrada.
- Cada aprovador decide se trata ou delega para `proximo`.
- Facilita adicionar novos níveis (ex.: Conselho) sem alterar as classes existentes.
- Em sistemas reais você pode trocar `double` por `BigDecimal`, usar `enum` para status, retornar um `Result` em vez de imprimir no console, e tornar thread-safe se necessário.

---

## CHAIN OF RESPONSIBILITIES

🏆 É um padrão de design comportamental que permite passar solicitações por uma cadeia de manipuladores. Ao receber uma solicitação, cada manipulador decide processar a solicitação ou passá-la para o próximo manipulador na cadeia 

> Esse padrão é usado para obter o acoplamento flexível no design de software.
> 

🏆 O padrão sugere que você vincule esses manipuladores em uma cadeia.


🏆 Cada manipulador vinculado possui um campo para armazenar uma referência ao próximo manipulador na cadeia.

> Quando temos múltiplos objetos determinados em um tempo de execução, são candidatos para tratar uma requisição, aí conseguimos aplicar essa estrutura.
> 

O que você descreveu é exatamente a ideia central:

- Você **tem múltiplos objetos (handlers)**,
- Só que você **não sabe de antemão (em tempo de compilação) qual deles vai tratar a requisição**,
- Então, em **tempo de execução**, a requisição vai passando pela cadeia até um desses objetos assumir a responsabilidade.

🏆 Além de processar uma solicitação, os manipuladores passam a solicitação adiante na cadeia.

🏆 A solicitação percorre a cadeia até que todos os manipuladores tenham a chance de processá-la.


🏆 Um manipulador pode decidir não passar a solicitação adiante na cadeia e efetivamente interromper qualquer processamento adicional.

> Um manipulador é determinado em tempo de execução
> 

💡 Uma solicitação não é tratada por nenhum manipulador?

Sim, isso pode acontecer — **uma solicitação pode percorrer toda a cadeia e não ser tratada por nenhum manipulador**.

Isso ocorre quando:

1. **Nenhum manipulador está preparado para aquele tipo de solicitação**, ou
2. **Nenhum manipulador foi definido como "último recurso" (default handler)**.

---

### O que acontece nesse caso?

- **Se o código não tiver um tratamento padrão**, a requisição simplesmente **não é processada** e pode terminar silenciosamente.
- Muitas implementações exibem uma mensagem, lançam uma exceção ou registram um log, como no exemplo que vimos:

```java
System.out.println("Nenhum manipulador pôde resolver o chamado: " + tipo);

```

---

### É um problema?

Não necessariamente.

- Em alguns cenários, isso é **comportamento esperado** — por exemplo, quando a requisição é inválida.
- Em outros, você pode criar um **manipulador "final" que sempre lida com o que sobrar**, garantindo que nada seja perdido.

---

Quer que eu te mostre **como adicionar um manipulador "default" que sempre trata a solicitação caso ninguém resolva**?


---

### EXPLICANDO O CÓDIGO DA CLASSE CORRENTE

```java
public class Corrente {
	
	Processor pro;
	
	public Corrente() {
		buildCorrente();
	}
	
	private void buildCorrente() {
		pro = new ProcessadorNegativo(new ProcessadorPositivo(new ZeroProcessador)));
	}
	
	public void processo(Numero requisicao) {
		pro.processo(requisicao);
	}

}
```

Essa classe `Corrente` está montando e executando uma **cadeia do padrão Chain of Responsibility**. Vamos destrinchar **passo a passo o que está acontecendo**:

---

### 1. **Declaração da classe e atributo**

```java
public class Corrente {

    Processor pro;

```

- Declara a classe `Corrente`.
- Cria um atributo `pro` do tipo `Processor` (provavelmente uma interface ou classe abstrata que define o método `processo`).
- Esse `pro` será o **ponto de entrada da cadeia**.

---

### 2. **Construtor da classe**

```java
public Corrente() {
    buildCorrente();
}

```

- Quando você cria um objeto `Corrente`, o construtor automaticamente chama o método `buildCorrente()`.
- Isso significa que **a cadeia de responsabilidade é montada assim que a classe é instanciada**.

---

### 3. **Montagem da cadeia**

```java
private void buildCorrente() {
    pro = new ProcessadorNegativo(
            new ProcessadorPositivo(
                    new ZeroProcessador()
            )
    );
}

```

- Aqui é onde a cadeia é criada.
- O que está acontecendo:
    - `ZeroProcessador` é o último da cadeia.
    - `ProcessadorPositivo` recebe `ZeroProcessador` como o próximo.
    - `ProcessadorNegativo` recebe `ProcessadorPositivo` como o próximo.
- O primeiro da corrente é `ProcessadorNegativo` e fica armazenado em `pro`.

Essa linha está **aninhando os handlers**.

---

### 4. **Método de processamento**

```java
public void processo(Numero requisicao) {
    pro.processo(requisicao);
}

```

- Esse método é o que o cliente chama.
- Ele envia a requisição (provavelmente um número com valor positivo, negativo ou zero) para o primeiro handler (`ProcessadorNegativo`).
- A partir daí, **a requisição percorre a cadeia** até que algum handler a trate.

---

### Resumo do papel da classe `Corrente`:

- **Constrói a cadeia** de handlers (`ProcessadorNegativo → ProcessadorPositivo → ZeroProcessador`).
- **Fornece um ponto único de entrada (`processo`)** para o cliente enviar a requisição.
- Atua como um **facilitador** para que o cliente não precise montar manualmente os encadeamentos.

---

### POR QUE SÓ PASSAR **`nextProcessor` JÁ CONECTA A PRÓXIMA CADEIA?**

---

## EXPLICAÇÃO DE TODAS AS CLASSES E TODO O FUNCIONAMENTO JÁ QUE EU NÃO ESTAVA ENTENDENDO

### CLASSE CORRENTE

classe `Corrente`:

---

```java
public class Corrente {

```

- Define a classe `Corrente`. Ela é responsável por **montar e manter a cadeia de processadores**.

---

```java
Processador pro;

```

- Declara um atributo chamado `pro` do tipo `Processador`.
- Este será **a entrada (primeiro elo)** da cadeia.

---

```java
public Corrente() {
    buildCorrente();
}

```

- Construtor da classe `Corrente`.
- Sempre que criamos um objeto `Corrente`, ele chama automaticamente o método `buildCorrente()` para **montar a cadeia**.

---

```java
private void buildCorrente() {
    pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));
}

```

- Esse método monta a cadeia encadeando os processadores:
    1. O último elo (`ProcessadorZero`) recebe `null` → não tem próximo.
    2. `ProcessadorPositivo` recebe como próximo o `ProcessadorZero`.
    3. `ProcessadorNegativo` recebe como próximo o `ProcessadorPositivo`.
- E o primeiro elo (`pro`) aponta para o `ProcessadorNegativo`.

A cadeia fica assim:

**Negativo → Positivo → Zero → null**

---

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- Método público `p` que inicia o processamento.
- Recebe um objeto `Numero` (sua requisição).
- Chama o método `processo()` do primeiro elo da cadeia (`pro`).

---

Essa classe **não processa nada diretamente**, apenas **monta a sequência e dispara o fluxo**.

🏆

### DÚVIDA SOBRE A CLASSE HERANÇA

### Quando eu faço essa composição `Processador pro;` , a classe corrente passa a ter acesso aos metodos e atributos da classe processador?

Quando você faz:

```java
Processador pro;

```

Você não está herdando nada (não é herança), você está apenas dizendo:

> "Dentro da classe Corrente, existe um atributo que guarda uma referência para um objeto do tipo Processador."
> 

Isso significa que:

- Você pode **chamar métodos públicos** de `Processador` (e dos seus filhos) através de `pro`.
- Você pode acessar **atributos públicos** de `Processador` diretamente, se houver.
- **Não pode acessar atributos/métodos privados** de `Processador`, pois composição não dá acesso direto a eles.

---

Por exemplo:

Se `Processador` tem:

```java
public void processo(Numero n) { }
private void logInterno() { }

```

E em `Corrente` você tem:

```java
pro.processo(new Numero(5)); // permitido
pro.logInterno(); // NÃO permitido (é private)

```

---

Resumindo: **composição dá acesso ao que a classe expõe, não a tudo que ela tem**.

🏆

### HERANÇA VS COMPOSIÇÃO

---

## **1. Usando Composição**

```java
class Motor {
    public void ligar() {
        System.out.println("Motor ligado");
    }

    private void statusInterno() {
        System.out.println("Status secreto do motor");
    }
}

class Carro {
    Motor motor = new Motor(); // composição: Carro TEM um Motor

    public void ligarCarro() {
        motor.ligar(); // permitido (público)
    }

    public void tentarAcessarInterno() {
        // motor.statusInterno(); // ERRO! statusInterno é private
    }
}

```

Aqui, **Carro não herda Motor**, ele apenas possui um (`Carro TEM um Motor`).

- Ele pode chamar os métodos públicos (`ligar()`).
- Não consegue acessar métodos/atributos privados do motor.

---

## **2. Usando Herança**

```java
class Motor {
    public void ligar() {
        System.out.println("Motor ligado");
    }

    private void statusInterno() {
        System.out.println("Status secreto do motor");
    }
}

class Carro extends Motor { // herança: Carro É um Motor
    public void ligarCarro() {
        ligar(); // permitido (herdou o método público)
    }

    public void tentarAcessarInterno() {
        // statusInterno(); // ERRO! Mesmo herdando, private ainda é inacessível
    }
}

```

Aqui, **Carro herda Motor** (`Carro É um Motor`).

- Ele pode chamar métodos públicos da superclasse **diretamente** (`ligar()`).
- Mas **métodos privados continuam inacessíveis**, mesmo com herança.

---

## **Resumo da Diferença**

- **Composição**: "tem um" — você precisa criar uma instância e acessar via atributo (`obj.metodo()`).
- **Herança**: "é um" — você herda os métodos e atributos (exceto privados) e pode chamá-los diretamente (`metodo()`).

---

🏆

### DÚVIDA SOBRE A COMPOSIÇÃO NO MEU CÓDIGO

 na sua classe `Corrente`, você não fez:

```java
Processador pro = new Processador();

```

Você fez apenas:

```java
Processador pro;

```

Isso significa que você **declarou uma variável de instância (referência)** do tipo `Processador`, **mas não criou nenhum objeto ainda**.

O objeto só é criado **de verdade** quando você faz:

```java
pro = new ProcessadorNegativo(
        new ProcessadorPositivo(
                new ProcessadorZero(null)
        )
);

```

Ou seja:

- Antes de `buildCorrente()` ser chamado, **`pro` está nulo** (não aponta para nenhum objeto).
- Depois, ele passa a apontar para um **objeto concreto** (`ProcessadorNegativo`) — que é uma subclasse de `Processador`.

---

### Então, respondendo sua dúvida:

- Quando você escreve `Processador pro;`, você **não tem acesso a nada ainda**, porque a variável não referencia um objeto.
- Quando você instancia e atribui (`pro = new ...`), **aí sim você passa a acessar os métodos públicos** de `Processador` (ou da subclasse real).

---

Quer que eu **explique o que acontece passo a passo** nesse momento de:

```java
pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));

```


🏆

### Instanciação na composição

```java
private void buildCorrente() {
    pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));
}

```

Aqui acontece a mágica:

- Você **cria o objeto** `ProcessadorNegativo`, que recebe um `ProcessadorPositivo`, que por sua vez recebe um `ProcessadorZero`.
- Isso significa que **agora `pro` não é mais null**, e você tem um objeto de fato na sua mão.
- A partir desse ponto, você pode chamar métodos do `Processador` (ou suas subclasses) através de `pro`.

---

### Chamando métodos

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- Aqui você já **tem acesso aos métodos da hierarquia de Processador** porque `pro` foi instanciado no `buildCorrente()`.
- É **nesse momento** que você efetivamente consegue usar os métodos e atributos da classe `Processador` (ou das classes derivadas, como `ProcessadorNegativo`).

---

✅ **Resumo**:

1. Declaração → nada acontece, `pro` é null.
2. Construtor → chama `buildCorrente()`.
3. `buildCorrente()` → instancia `Processador` (e suas subclasses) → `pro` agora aponta para um objeto real.
4. Método `p()` → pode usar métodos de `Processador` através de `pro`.

🏆

### NA COMPOSIÇÃO É OBRIGADO INSTANCIAR PARA USAR OS MÉTODOS E ATRIBUTOS DA OUTRA CLASSE

Na **composição**:

- A sua classe **não herda** os métodos ou atributos da outra.
- Para acessar os métodos ou atributos do objeto que você “tem”, você **precisa ter uma instância dele**.
- Até você instanciar o objeto, o campo é `null` e **não dá para chamar métodos**.

Exemplo:

```java
class Motor {
    void ligar() { System.out.println("Motor ligado"); }
}

class Carro {
    Motor motor; // só declarado, ainda null

    void ligarCarro() {
        // motor.ligar();  <- isso daria NullPointerException
    }

    void criarMotor() {
        motor = new Motor(); // agora motor está instanciado
    }
}

```

Então, resumindo: **sem instanciar o objeto, não há acesso aos métodos nem atributos na composição.**


🏆

### Caso eu não instancie a classe processador diretamente, e sim uma subclasse dela, isso tambem funciona para composição?

Na **composição**, o que importa é que o campo seja do tipo da classe ou interface que você quer “ter”. Você **pode instanciar uma subclasse** e atribuí-la a esse campo.

No seu exemplo:

```java
Processador pro;

```

Você **não precisa instanciar exatamente `Processador`**, porque `ProcessadorNegativo`, `ProcessadorPositivo` e `ProcessadorZero` **são subclasses de `Processador`**. Então isso é totalmente válido:

```java
pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));

```

Explicando:

- `pro` é do tipo `Processador` → você pode chamar métodos definidos em `Processador`.
- A instância real é `ProcessadorNegativo` → se esse método tiver **polimorfismo** (overriding), a versão da subclasse será executada.
- Isso é **uma das grandes vantagens da composição com polimorfismo**: você pode trocar a implementação interna sem mudar o código que usa `pro`.

💡 Resumindo: **em composição você sempre precisa de uma instância**, mas essa instância **pode ser qualquer subclasse** do tipo do campo.


### CLASSE PROCESSADOR

### 1️⃣ Declaração da classe

```java
public abstract class Processador {

```

- É **abstract**, ou seja, **não pode ser instanciada diretamente**.
- Serve como **base para todas as subclasses** que implementam processamento específico.
- Essa abstração permite que o campo `nextProcessor` seja de qualquer subclasse de `Processador`.

---

### 2️⃣ Campo `nextProcessor`

```java
protected Processador nextProcessor; // referência para o próximo da cadeia

```

- Esse campo guarda a referência para **o próximo processador na cadeia**.
- É `protected` → visível para subclasses, mas não para classes externas.
- Fundamental para implementar o **encadeamento da responsabilidade**.

---

### 3️⃣ Construtor

```java
public Processador(Processador nextProcessor) {
    this.nextProcessor = nextProcessor; // injeta a dependência (próximo processador)
}

```

- Recebe como parâmetro **o próximo processador na cadeia**.
- Esse é o momento em que você **“liga” os processadores**.
- No seu exemplo anterior:

```java
pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));

```

- `ProcessadorNegativo` é o primeiro da cadeia, recebe `ProcessadorPositivo` como `nextProcessor`, e assim por diante.
- Isso permite que cada processador **conheça apenas o próximo**, sem precisar conhecer toda a cadeia.

---

### 4️⃣ Método `processo`

```java
public void processo(Numero requisicao) {
    if (nextProcessor != null) {
        nextProcessor.processo(requisicao); // delega para o próximo, se existir
    }
}

```

- É **o núcleo do padrão Chain of Responsibility**.
- Cada processador **pode processar a requisição** ou **passá-la adiante**.
- No `Processador` base, **nenhum processamento é feito**, ele só **delegará**.
- Subclasses vão **sobrescrever (`override`)** esse método para tratar casos específicos.
- A linha `nextProcessor.processo(requisicao)` garante que a requisição **percorrerá toda a cadeia** até ser processada ou chegar ao final (`null`).

---

### ✅ Resumindo

1. `Processador` é **abstrato**, não processa nada por si só.
2. Ele mantém a referência para **o próximo da cadeia** (`nextProcessor`).
3. Cada subclass pode processar a requisição **ou delegar ao próximo**.
4. O encadeamento é feito no construtor, ligando os processadores de forma **flexível e polimórfica**.

---

### CLASSE PROCESSADOR NEGATIVO

---

### 1️⃣ Declaração da classe

```java
public class ProcessadorNegativo extends Processador {

```

- `ProcessadorNegativo` **herda de `Processador`**.
- Ou seja, ela **faz parte da cadeia** e pode ter um próximo processador (`nextProcessor`).
- A herança permite **sobrescrever** o método `processo` para tratar apenas números negativos.

---

### 2️⃣ Construtor

```java
public ProcessadorNegativo(Processador nextProcessador) {
    super(nextProcessador);
}

```

- Recebe como parâmetro o **próximo processador na cadeia**.
- Chama o construtor da classe base (`super`) para **armazenar a referência** em `nextProcessor`.
- Isso mantém o encadeamento da cadeia intacto.

💡 Observação: você **não precisa criar o próximo processador aqui**, apenas passar a instância já criada.

---

### 3️⃣ Sobrescrevendo o método `processo`

```java
@Override
public void processo (Numero requisicao) {
    if (requisicao.getNumero() < 0) {
        System.out.println("Processo negativo: " + requisicao.getNumero());
    } else {
        super.processo(requisicao);
    }
}

```

Explicando passo a passo:

1. **Checa se o número é negativo**
    
    ```java
    if (requisicao.getNumero() < 0)
    
    ```
    
    - Se sim, o processador trata a requisição (no caso, apenas imprime uma mensagem).
2. **Caso contrário**
    
    ```java
    else {
        super.processo(requisicao);
    }
    
    ```
    
    - Chama `super.processo(requisicao)` → ou seja, **delegará a requisição para o próximo processador na cadeia**.
    - Se `nextProcessor` for `null`, a chamada termina, e a requisição não é processada.

---

### ✅ Resumindo

- `ProcessadorNegativo` **processa apenas números negativos**.
- Se não puder processar, **passa a requisição adiante** usando a lógica do `Processador` base.
- Essa é a essência do **Chain of Responsibility**: cada objeto decide **se trata ou delega**.

---

### CLASSE PROCESSADOR POSITIVO

---

### 1️⃣ Declaração da classe

```java
public class ProcessadorPositivo extends Processador {

```

- `ProcessadorPositivo` herda de `Processador`.
- Isso significa que **pode fazer parte da cadeia**, ter um `nextProcessor` e sobrescrever o método `processo`.

---

### 2️⃣ Construtor

```java
public ProcessadorPositivo(Processador nextProcessor) {
    super(nextProcessor);
}

```

- Recebe o **próximo processador da cadeia**.
- Chama `super(nextProcessor)` para armazenar a referência em `nextProcessor` da classe base.
- Funciona exatamente igual ao `ProcessadorNegativo`.

---

### 3️⃣ Sobrescrevendo `processo`

```java
@Override
public void processo(Numero requisicao) {
    if (requisicao.getNumero() > 0) {
        System.out.println("Processador positivo: " + requisicao.getNumero());
    } else {
        super.processo(requisicao);
    }
}

```

Passo a passo:

1. **Verifica se o número é positivo**
    
    ```java
    if (requisicao.getNumero() > 0)
    
    ```
    
    - Se sim, **processa a requisição** (aqui só imprime).
2. **Caso contrário**
    
    ```java
    else {
        super.processo(requisicao);
    }
    
    ```
    
    - Delegará para o próximo processador na cadeia (`nextProcessor`).
    - Se não houver próximo (`null`), a requisição termina sem ser processada.

---

### ✅ Resumindo

- `ProcessadorPositivo` trata apenas números positivos.
- Se não puder processar, **passa a requisição adiante**.
- Essa é a **essência do Chain of Responsibility**: cada processador decide se trata ou delega.

---

### CLASSE PROCESSADOR ZERO

Perfeito! Agora temos a **classe `ProcessadorZero`**, que completa a cadeia de responsabilidade para números negativos, positivos e zero. Vamos analisar:

---

### 1️⃣ Declaração da classe

```java
public class ProcessadorZero extends Processador {

```

- Herda da classe abstrata `Processador`.
- Faz parte do **Chain of Responsibility**, podendo delegar a requisição para o próximo processador (`nextProcessor`).

---

### 2️⃣ Construtor

```java
public ProcessadorZero(Processador nextProcessor) {
    super(nextProcessor);
}

```

- Recebe o **próximo processador da cadeia**.
- Chama `super(nextProcessor)` para inicializar o campo `nextProcessor` da classe base.
- Garante que a cadeia continue encadeada.

---

### 3️⃣ Método `processo`

```java
@Override
public void processo(Numero requisicao) {
    if(requisicao.getNumero() == 0) {
        System.out.println("Processador zero:" + requisicao.getNumero());
    } else {
        super.processo(requisicao);
    }
}

```

Passo a passo:

1. **Verifica se o número é zero**
    
    ```java
    if(requisicao.getNumero() == 0)
    
    ```
    
    - Se sim, processa (imprime mensagem).
2. **Caso contrário**
    
    ```java
    else {
        super.processo(requisicao);
    }
    
    ```
    
    - Delegação para o próximo processador da cadeia, se existir.
    - Como `ProcessadorZero` geralmente é o último da cadeia, na prática `nextProcessor` é `null` e a requisição termina.

---

### ✅ Papel no padrão

- Trata exclusivamente **o caso em que o número é zero**.
- Completa a cadeia iniciada por `ProcessadorNegativo` e `ProcessadorPositivo`.
- Não precisa se preocupar com números negativos ou positivos — esses casos já foram tratados anteriormente.

---

### 🔹 Como a cadeia funciona na prática

Se a cadeia for construída assim:

```java
Processador pro = new ProcessadorNegativo(
                        new ProcessadorPositivo(
                            new ProcessadorZero(null)));

```

E você passar diferentes valores:

```java
pro.processo(new Numero(-5)); // ProcessadorNegativo trata
pro.processo(new Numero(10)); // ProcessadorPositivo trata
pro.processo(new Numero(0));  // ProcessadorZero trata

```

- Cada processador **decide se trata ou delega**, seguindo o padrão **Chain of Responsibility**.

---

---

### CLASSE NÚMERO

### 1️⃣ Declaração da classe e atributo

```java
public class Numero {
    private int numero;

```

- A classe possui um **atributo privado `numero`**.
- Privado significa que **não pode ser acessado diretamente fora da classe**, garantindo encapsulamento.

---

### 2️⃣ Construtor

```java
public Numero(int numero) {
    this.numero = numero;
}

```

- Recebe um valor inteiro e o atribui ao atributo `numero`.
- `this.numero` refere-se ao **atributo da classe**, enquanto `numero` é o parâmetro do construtor.

---

### 3️⃣ Método getter

```java
public int getNumero() {
    return numero;
}

```

- Permite **acessar o valor do número** de fora da classe de forma controlada.
- É através deste método que os processadores (`ProcessadorNegativo`, `ProcessadorPositivo`, `ProcessadorZero`) obtêm o valor para decidir se vão processar ou delegar.

---

### ✅ Resumindo

- `Numero` é apenas um **wrapper para um valor inteiro**, mantendo o conceito de **encapsulamento**.
- Todas as classes da cadeia usam o método `getNumero()` para acessar o valor.
- Isso deixa o padrão **flexível**: você poderia adicionar novos atributos ou métodos à classe `Numero` no futuro sem alterar a cadeia de processadores.

---

### CLASSE MAIN PRINCIPAL PARA TESTE

### 1️⃣ Declaração da classe Main

```java
public class TesteChain {

```

- Classe responsável por **testar a cadeia de processadores**.
- Contém o método `main`, ponto de entrada da aplicação.

---

### 2️⃣ Método `main`

```java
public static void main(String[] args) {

```

- Ponto de partida do programa.
- É aqui que você cria objetos e inicia o processamento das requisições.

---

### 3️⃣ Criação da `Corrente`

```java
Corrente corrente = new Corrente();

```

- Cria uma instância de `Corrente`.
- No construtor de `Corrente`:

```java
public Corrente() {
    buildCorrente();
}

```

- Chama `buildCorrente()` que faz:

```java
pro = new ProcessadorNegativo(
          new ProcessadorPositivo(
              new ProcessadorZero(null)));

```

- **O que acontece por baixo dos panos:**
    1. `ProcessadorZero` é criado com `nextProcessor = null`.
    2. `ProcessadorPositivo` é criado com `nextProcessor = ProcessadorZero`.
    3. `ProcessadorNegativo` é criado com `nextProcessor = ProcessadorPositivo`.
    4. O campo `pro` da classe `Corrente` aponta para `ProcessadorNegativo`, ou seja, o **início da cadeia**.

Agora a cadeia está pronta:

**Negativo → Positivo → Zero → null**

---

### 4️⃣ Chamadas do método `p`

```java
corrente.p(new Numero(90));

```

- Aqui você passa um objeto `Numero` com valor 90 para a corrente.
- O método `p` em `Corrente` faz:

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- **O que acontece por baixo dos panos**:
    1. `pro` aponta para `ProcessadorNegativo`.
    2. `ProcessadorNegativo.processo(Numero(90))` é chamado.
        - 90 não é negativo → delega para `super.processo()` → chama `ProcessadorPositivo.processo(Numero(90))`.
    3. `ProcessadorPositivo` verifica: 90 > 0 → imprime `"Processador positivo: 90"`.
    4. A requisição **não precisa ir ao ProcessadorZero**, pois já foi tratada.

---

### 5️⃣ Outros exemplos

```java
corrente.p(new Numero(-50));

```

- Passa por `ProcessadorNegativo`: -50 < 0 → imprime `"Processo negativo: -50"`.
- Não precisa ir adiante.

```java
corrente.p(new Numero(0));

```

- Passa por `ProcessadorNegativo` → delega.
- Passa por `ProcessadorPositivo` → delega.
- Passa por `ProcessadorZero` → 0 == 0 → imprime `"Processador zero: 0"`.

```java
corrente.p(new Numero(91));

```

- Mesma lógica de 90 → tratado pelo `ProcessadorPositivo`.

---

### 6️⃣ Resumindo o fluxo por baixo dos panos

1. Cada `Processador` recebe a requisição (`Numero`).
2. Ele decide:
    - Se pode processar → processa e termina.
    - Se não pode → chama `super.processo()`, que delega para o próximo processador (`nextProcessor`).
3. A requisição percorre a cadeia **até ser processada ou chegar ao final (null)**.
4. A cadeia é **montada dinamicamente** na classe `Corrente`, permitindo trocar ou adicionar processadores facilmente.

---


🏆

### DÚVIDA DE PORQUE CONSIGO INSTANCIAR UM OBJETO DENTRO DO MÉTODO

### Eu só consigo instanciar um objeto numero dentro do metodo por que estou passando ele como parametro na classe corrente?

Exatamente! ✅

Vamos detalhar isso:

---

### 1️⃣ Onde você cria o `Numero`

No `main`, você faz:

```java
corrente.p(new Numero(90));

```

- Aqui você **está criando uma instância de `Numero`** diretamente no momento da chamada.
- O `new Numero(90)` cria o objeto e já passa para o método `p` da classe `Corrente`.

---

### 2️⃣ Por que dentro do método?

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- `p` recebe **como parâmetro** o objeto `Numero`.
- Ou seja, a instância de `Numero` **já existe** quando você chama `p`.
- A classe `Corrente` **não precisa criar um `Numero` internamente**, porque o método já recebeu um objeto válido para processar.

---

### 3️⃣ Poderia criar dentro da classe `Corrente`?

Sim, mas aí você **decide o valor do número internamente**, e não poderia passar diferentes números de fora. Exemplo:

```java
public void p() {
    Numero requisicao = new Numero(42); // valor fixo
    pro.processo(requisicao);
}

```

- Isso funciona, mas **perde a flexibilidade** de passar qualquer número da main.
- Passar como parâmetro é a forma de **injetar a requisição de fora**, mantendo a cadeia **genérica e reutilizável**.

---

### ✅ Resumo

- Você consegue instanciar `Numero` **fora da classe** e passar como parâmetro → permite **flexibilidade**.
- Não é obrigatório criar `Numero` dentro da classe `Corrente`; passar como argumento **é mais flexível e correto** para o padrão Chain of Responsibility.

---


🏆

### QUAL A REFERÊNCIA DO OBJETO NÚMERO CRIADO

Tem sim! ✅

Mesmo que você crie o objeto `Numero` diretamente na chamada do método, ele **possui uma referência em memória**, e é isso que permite que ele seja usado dentro da cadeia de processadores. Vamos detalhar:

---

### 1️⃣ Criação do objeto

```java
corrente.p(new Numero(90));

```

- `new Numero(90)` cria um **objeto na memória heap**.
- O método `p` recebe esse objeto como parâmetro (`Numero requisicao`).
- **`requisicao` é a referência** que aponta para o objeto recém-criado.

---

### 2️⃣ Passagem por parâmetro

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- `requisicao` **não é o objeto em si**, é **uma referência para ele**.
- Quando você chama `pro.processo(requisicao)`, essa mesma referência é passada para o próximo processador.
- Todos os processadores na cadeia **trabalham com a mesma referência**, então qualquer método que acessar `requisicao.getNumero()` verá o mesmo valor.

---

### 3️⃣ Por que parece “sem referência”

- Às vezes parece que não há referência porque você **não deu um nome explícito** ao objeto (como `Numero n = new Numero(90);`).
- Mesmo sem nome, **o objeto existe e tem referência** — é só que essa referência está “temporariamente vinculada” ao parâmetro do método.
- Exemplo equivalente, mas com nome explícito:

```java
Numero n = new Numero(90);
corrente.p(n); // passa a referência 'n' para o método

```

- Funciona exatamente igual à versão sem nome.

---

### ✅ Resumo

- **Todo objeto criado com `new` tem referência na memória**.
- Passar o objeto como parâmetro **replica a referência**, não o objeto.
- A cadeia de processadores trabalha com **a mesma referência**, garantindo que todos vejam o mesmo número.

---

💡 Eu digo dessa forma aqui corrente.p(new Numero(90));, sempre que eu criar dessa forma, eu preciso passar a classe como parametro no metodo da outra classe, correto?

Exatamente! ✅

Vamos detalhar:

---

### 1️⃣ A forma que você está usando

```java
corrente.p(new Numero(90));

```

- `new Numero(90)` cria **um objeto na hora** (sem nome).
- Esse objeto **precisa ser recebido por algum lugar**, senão ele não teria referência para ser usado.
- Por isso, o método `p` na classe `Corrente` precisa ter **um parâmetro do tipo `Numero`**:

```java
public void p(Numero requisicao) {
    pro.processo(requisicao);
}

```

- `requisicao` **é a referência** que aponta para o objeto recém-criado.
- Sem esse parâmetro, o método `p` **não teria como acessar o objeto**.

---

### 2️⃣ Por que funciona assim

- Toda vez que você escreve `new Numero(90)` dentro da chamada do método, você está **criando o objeto e passando a referência na mesma linha**.
- O parâmetro do método é o “canal” pelo qual a referência do objeto entra no método.

---

### 3️⃣ Resumindo

- **Se você quer criar o objeto dentro da chamada do método (inline)**, o método precisa ter **um parâmetro compatível** para receber a referência.
- Caso contrário, você teria que criar o objeto **antes**, dar um nome a ele, e então usar dentro do método:

```java
Numero n = new Numero(90);
corrente.p(n); // ainda passa a referência, mas não inline

```

- Em ambos os casos, o método precisa **ter um parâmetro** para receber a referência se você quer que o objeto seja usado dentro dele.

---

