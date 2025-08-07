# 1 → ABSTRACT FACTORY

## 🏭 **Abstract Factory — Fábrica Abstrata**

### ✅ **Definição**

O **Abstract Factory** é um **padrão de criação** que fornece uma interface para criar **famílias de objetos relacionados** ou dependentes **sem especificar suas classes concretas**.

---

### 🎯 **Objetivo**

Permitir que você crie **grupos de objetos relacionados** (como uma UI com botões e menus) de forma **consistente e intercambiável**, sem acoplar o código a classes específicas.

---

### 🧱 **Estrutura**

- **AbstractFactory (interface/fábrica abstrata)**: declara métodos para criar os produtos.
- **ConcreteFactory**: implementa a AbstractFactory, criando objetos concretos.
- **AbstractProduct**: interfaces dos produtos que serão criados.
- **ConcreteProduct**: implementações dos produtos.
- **Client**: usa apenas interfaces da fábrica e dos produtos — **não conhece classes concretas**.

---

### 💡 **Exemplo prático**

Imagine um app com **tema claro** e **tema escuro**:

- AbstractFactory: `GUIFactory`
- ConcreteFactory: `LightThemeFactory`, `DarkThemeFactory`
- AbstractProduct: `Button`, `Checkbox`
- ConcreteProduct: `LightButton`, `DarkButton`, etc.
- O cliente (app) usa `GUIFactory` para criar botões/checkboxes de acordo com o tema, **sem saber qual classe está sendo usada**.

---

### 📌 **Vantagens**

- Facilita a troca de famílias inteiras de objetos.
- Promove o uso de interfaces e baixo acoplamento.
- Garante consistência entre objetos relacionados.

### ⚠️ **Desvantagens**

- Código mais complexo.
- Pode ser exagerado se você não precisa de múltiplas famílias de objetos.

---

### ABSTRACT FACTORY

🏆 A primeira coisa que o padrão abstract factory sugere é declarar explicitamente as interfaces para cada produto distinto da família de produtos.

```java
// Interface para Produto A
interface ProdutoA {
    void operacaoA();
}

// Interface para Produto B
interface ProdutoB {
    void operacaoB();
}

// Fábrica abstrata que declara métodos para criar cada produto
interface FabricaAbstrata {
    ProdutoA criarProdutoA();
    ProdutoB criarProdutoB();
}

```

Esse código define explicitamente as interfaces dos produtos distintos (`ProdutoA` e `ProdutoB`) e a fábrica abstrata que os cria, que é a essência do padrão Abstract Factory. 


🏆 Em seguida, você pode fazer com que todas as variantes de produtos sigam essas interfaces.

🏆 O próximo passo é declarar a Abstract Factory - uma interface com uma lista de métodos de criação para todos os produtos que fazem parte da família de produtos.


🏆 Para cada variante de uma família de produtos, criamos uma classe de fábrica separada com base na Abstract Factory.


🏆 O código do cliente deve funcionar por meio de suas respectivas interfaces abstratas (produtos abstratos declaram interfaces para um conjunto de produtos distintos, mas relacionados, que compõem uma família de produtos).

> Esse padrão fornece uma melhor maneira de criar objetos e formalizar esse processo.
> 

---

## CÓDIGO NO GITHUB.

---

### O QUE É UMA CLASSE CONCRETA?

Uma **classe concreta** é uma classe **completa** — ou seja, que **pode ser instanciada** diretamente e **implementa todos os seus métodos**.

### Características de uma classe concreta:

- **Pode ser instanciada** (criar objetos com `new`).
- **Implementa todos os métodos** (inclusive os herdados, se houver).
- Pode herdar de uma classe abstrata ou implementar interfaces.

---

### EXPLICAÇÃO DA MINHA CLASSE QUE DEFINE A ESTRUTURA PARA AS FÁBRICAS QUE CRIAM OBJETOS DE TIPO DIFERENTE

```java
package abstractt.factory.classes;

import abstractt.factory.interfaces.Cor;
import abstractt.factory.interfaces.Forma;

public abstract class AbstractFactory {

	abstract Cor getCor(String cor);
	
	abstract Forma getForma(String forma);
	
}
```

🏆 Essa classe é um exemplo clássico do **padrão de projeto Abstract Factory** em Java.

Vamos explicar **linha por linha**:

---

```java
public abstract class AbstractFactory {

```

- `public`: A classe pode ser acessada de qualquer lugar do código.
- `abstract class`: Define uma **classe abstrata** chamada `AbstractFactory`, ou seja, **não pode ser instanciada diretamente**.
- Essa classe vai servir como **fábrica base (superclasse)** para outras fábricas concretas que criam **objetos de diferentes famílias** (ex: cores e formas).

---

```java
	abstract Cor getCor(String cor);

```

- Esse é um **método abstrato**: ele **não tem corpo** (implementação).
- Classes que **herdarem `AbstractFactory` são obrigadas a implementar esse método**.
- Ele deve retornar um objeto do tipo `Cor`, com base no nome passado como parâmetro (`"vermelho"`, `"azul"`, etc).

---

```java
	abstract Forma getForma(String forma);

```

- Outro **método abstrato**, também **sem corpo**.
- Quem herdar `AbstractFactory` terá que dizer **como criar e retornar uma `Forma`**, com base no nome fornecido (`"círculo"`, `"quadrado"`, etc).

---

### Em resumo:

A classe `AbstractFactory` **define a estrutura** (interface) para fábricas que criam objetos de **tipos diferentes**, como `Cor` e `Forma`, mas **não implementa a lógica**. Isso é deixado para as subclasses concretas.

---


### COMO ELA DEFINE UMA INTERFACE SE ELA NÃO É UMA INTERFACE?

🏆 Vamos esclarecer isso de forma simples:

### ✅ **Classe abstrata vs Interface**

- Embora a `AbstractFactory` **não seja uma interface**, ela **define uma "interface de uso"**, ou seja, **um contrato de métodos** que as classes concretas devem seguir.
- Ela faz isso através de **métodos abstratos**.

---

### ✅ O que significa “define a interface” nesse contexto?

Quando dizemos que uma **classe abstrata "define a interface"**, queremos dizer que:

> Ela obriga as subclasses a seguirem um conjunto específico de métodos, assim como uma interface faria.
> 

---

### Diferença principal:

| **Interface** | **Classe Abstrata** |
| --- | --- |
| Usa `interface` | Usa `abstract class` |
| Todos os métodos são abstratos por padrão (Java 7) | Pode ter métodos abstratos **e concretos** |
| Não possui estado (atributos com lógica) | Pode ter atributos, construtores e lógica compartilhada |
| Usada para definir **somente** o contrato | Pode definir **contrato e comportamento comum** |

---

### No seu exemplo:

```java
public abstract class AbstractFactory {
    abstract Cor getCor(String cor);
    abstract Forma getForma(String forma);
}

```

Ela está **fornecendo um contrato (interface de uso)**:

- Qualquer fábrica concreta deve implementar esses dois métodos.
- Isso garante que o resto do sistema possa usar qualquer fábrica concreta sem se importar com **como** ela cria os objetos — apenas **que ela os cria**.

---


## RESUMINDO QUEM É QUEM NO PROJETO

🏆

**Resumo direto e simples** de quem é quem no seu padrão **Abstract Factory**, com base nas classes que você mencionou:

---

### 🧱 **1. Interface dos Produtos (o que será criado)**

- `Forma` → interface para **formas geométricas** (`desenhar()`).
- `Cor` → interface para **cores** (`preencher()`).

---

### 🧱 **2. Implementações dos Produtos**

- **Formas (implementam `Forma`)**:
    - `Circulo`
    - `Retangulo`
    - `Quadrado`
- **Cores (implementam `Cor`)**:
    - `Vermelho`
    - `Verde`
    - `Azul`

---

### 🏭 **3. Fábricas Concretas (criam os produtos específicos)**

- `FormaFactory` → retorna objetos que implementam `Forma`.
- `CorFactory` → retorna objetos que implementam `Cor`.

---

### 🧰 **4. Fábrica Abstrata**

- `AbstractFactory` → classe **abstrata** com métodos:
    
    ```java
    abstract Cor getCor(String cor);
    abstract Forma getForma(String forma);
    
    ```
    

---

### 🧠 **5. Produtor de Fábricas**

- `FactoryProdutor` → classe que decide qual fábrica concreta retornar:
    - `"FORMA"` → retorna `FormaFactory`
    - `"COR"` → retorna `CorFactory`

---

### 🧪 **6. Cliente**

- A `classe Main` (ex: `AbstractFactoryPatternDemo`) → **usa tudo isso**, sem saber como os objetos foram criados, só os utiliza.

---


---

---

### EXPLICANDO CLASSE ‘FACTORYPRODUTOR’

🏆 Essa classe `FactoryProdutor` é o que chamamos de **fábrica de fábricas** (ou **super fábrica**) no padrão **Abstract Factory**.

---

### 📌 Função principal:

A classe **`FactoryProdutor`** é responsável por **fornecer a fábrica adequada** com base na escolha do cliente (por exemplo, `FormaFactory` ou `CorFactory`).

---

### 🔍 Linha por linha:

```java
public class FactoryProdutor {

```

Define a classe pública `FactoryProdutor`. Ela **não precisa ser instanciada**, pois usa um método `static`.

---

```java
    public static AbstractFactory getFactory(String escolha) {

```

Método `static` chamado `getFactory`. Ele recebe uma `String` chamada `escolha` e **retorna uma fábrica concreta** que implementa `AbstractFactory`.

---

```java
        if (escolha.equalsIgnoreCase("FORMA")) {
            return new FormaFactory();

```

Se a `escolha` for "FORMA", retorna uma nova instância de `FormaFactory`.

---

```java
        } else if (escolha.equalsIgnoreCase("COR")) {
            return new CorFactory();

```

Se a `escolha` for "COR", retorna uma nova instância de `CorFactory`.

---

```java
        return null;
    }
}

```

Se a `escolha` não for nenhuma das duas opções, retorna `null`.

---

### 🧠 Em resumo:

A `FactoryProdutor` é **uma camada a mais de abstração**, usada para obter a **fábrica correta**, dependendo do tipo de objeto que você quer criar.

---

### 🧪 Exemplo de uso:

```java
AbstractFactory fabricaFormas = FactoryProdutor.getFactory("FORMA");
Forma circulo = fabricaFormas.getForma("CIRCULO");

AbstractFactory fabricaCores = FactoryProdutor.getFactory("COR");
Cor vermelho = fabricaCores.getCor("VERMELHO");

```


### DETALHE IMPORTANTE SOBRE MÉTODO STATIC NESSE PADRÃO

🏆

```java
Forma forma1 = FormaFactory.getForma("CIRCULO");

```

---

## 🟡 O problema aqui

Essa linha **só vai funcionar** se o método `getForma()` for **estático** (ou seja, tiver a palavra-chave `static`):

```java
public static Forma getForma(String forma) {
    // lógica para retornar uma forma
}

```

Mas no padrão **Abstract Factory**, esse método **normalmente NÃO é estático**. Ele é chamado a partir de uma **instância** da fábrica, como neste exemplo:

```java
AbstractFactory formaFactory = FactoryProdutor.getFactory("FORMA");
Forma forma = formaFactory.getForma("CIRCULO");

```

---

## ✅ Por que isso acontece?

### ✅ Métodos estáticos

- São chamados **direto pela classe**, como:
    
    ```java
    FormaFactory.getForma("CIRCULO");
    
    ```
    
- **Não precisam de instância.**
- **Não podem ser sobrescritos** por classes filhas.

### ❌ Isso **quebra** o padrão Abstract Factory

O padrão Abstract Factory é feito para trabalhar com **polimorfismo**, ou seja, você usa a **mesma interface abstrata** para diferentes tipos de fábrica.

Exemplo correto:

```java
AbstractFactory fabrica = FactoryProdutor.getFactory("FORMA"); // pode ser FormaFactory ou CorFactory
Forma forma = fabrica.getForma("CIRCULO");
forma.desenhar();

```

Se `getForma()` for estático, isso **não funciona**, porque você não pode fazer:

```java
AbstractFactory fabrica = ...;
fabrica.getForma(); // ERRO se for estático!

```

---

## 🔄 Resumo simples

| Situação | Funciona? | Por quê |
| --- | --- | --- |
| `FormaFactory.getForma("CIRCULO")` com método **estático** | ✅ | Chamada direta, não precisa instância |
| `formaFactory.getForma("CIRCULO")` com método **não-estático** | ✅ | Correto para o padrão Abstract Factory |
| `FormaFactory.getForma("CIRCULO")` com método **não-estático** | ❌ | Erro de compilação: precisa de instância |

---


### PARTE 2 DA DÚVIDA SOBRE ONDE COLOCAR O MÉTODO STATIC

🏆

---

## ✅ Por que eu fiz aquela **observação**?

Você usou este trecho no seu `main`:

```java
Forma forma1 = FormaFactory.getForma("CIRCULO");

```

Esse código **chama o método `getForma()` diretamente da classe `FormaFactory`**, sem criar um objeto da fábrica.

👉 Isso **só é possível se `getForma()` for `static`**.

---

## 🎯 Onde está a confusão?

Você disse:

> "mas o meu método static está na classe produtor"
> 

Sim, está! Mas no trecho acima você **não está usando `FactoryProdutor.getFactory()` para obter a fábrica** — está chamando diretamente a `FormaFactory`.

---

### Seu código, novamente:

```java
AbstractFactory formaTeste = FactoryProdutor.getFactory("FORMA");

Forma forma1 = FormaFactory.getForma("CIRCULO"); // ← chamada direta
forma1.desenhar();

```

O esperado (segundo o padrão **Abstract Factory**) seria algo assim:

```java
AbstractFactory formaTeste = FactoryProdutor.getFactory("FORMA");

Forma forma1 = formaTeste.getForma("CIRCULO"); // ← forma correta
forma1.desenhar();

```

---

## 🛠️ Então, o que está “fora do padrão”?

O fato de você **chamar `FormaFactory.getForma()` diretamente** indica que o método `getForma()` é `static`.

Mas no padrão Abstract Factory, a ideia é **trabalhar com instâncias de fábrica**, não com métodos estáticos.

---

## ✅ Conclusão

- ✔️ Sua classe `FactoryProdutor` com método `static` está 100% correta no contexto do padrão Abstract Factory.
- ⚠️ O problema que eu apontei foi sobre a **chamada direta de `FormaFactory.getForma()`**, que foge um pouco da ideia do padrão — **a menos que você tenha feito esse método `static` de propósito** (o que funciona, mas é fora do estilo esperado do padrão).

### DÚVIDA CASO EU NÃO IMPLEMENTASSE CIRCULO COMO UMA FORMA

🏆

---

### 📌 **Quando você pode tratar um objeto como `Forma`?**

Você **só pode usar um objeto como sendo do tipo `Forma`** se ele implementa a interface `Forma`. Isso é essencial para o polimorfismo funcionar.

---

### 🔍 Exemplo real:

### Interface:

```java
public interface Forma {
    void desenhar();
}

```

### Classe que implementa:

```java
public class Circulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando círculo");
    }
}

```

### Código que usa polimorfismo:

```java
Forma minhaForma = new Circulo(); // OK, Circulo é um Forma
minhaForma.desenhar();            // Chama o método da classe Circulo

```

Aqui funciona perfeitamente, porque **`Circulo` implementa `Forma`**, então pode ser tratado como `Forma`.

---

### ❌ E se **não** implementar a interface?

### Classe sem implements:

```java
public class Circulo {
    public void desenhar() {
        System.out.println("Desenhando círculo");
    }
}

```

### Tentando isso:

```java
Forma minhaForma = new Circulo(); // ❌ ERRO: Circulo não é um Forma!

```

Você receberá um erro de compilação assim:

> Type mismatch: cannot convert from Circulo to Forma
> 

Ou seja:

> O compilador não permite que você trate um Circulo como um Forma, porque ele não declarou que é.
> 

---

### ✅ Por que isso importa?

Em um padrão como o **Abstract Factory**, você normalmente trabalha com **interfaces** para desacoplar seu código. Assim, você pode trocar as implementações sem mudar o código que usa essas interfaces:

```java
Forma forma = fabrica.getForma("CIRCULO");
forma.desenhar();  // Não importa se é Círculo, Quadrado ou Triângulo

```

Se `Círculo` não implementar `Forma`, o código acima **quebra completamente**.

---


### POR QUE NÃO COLOCAR O MÉTODO DENTRO DE OUTRA CLASSE?

🏆 por que o método `getFactory` **está na classe `FactoryProdutor`** e **não** na `AbstractFactory`.

---

## ✅ Por que `getFactory` está em `FactoryProdutor`?

A classe `FactoryProdutor` **é responsável por escolher qual fábrica (factory) concreta você quer usar**. É uma espécie de **"fábrica de fábricas"** — isso é típico do padrão **Abstract Factory**.

---

### 🏗️ Design correto do padrão Abstract Factory:

- `AbstractFactory`: é uma classe ou interface **abstrata**, que define **o que as fábricas devem implementar**, como `getForma`, `getCor`, etc.
- `FormaFactory` e `CorFactory`: implementam essa interface/classe abstrata.
- `FactoryProdutor`: é um **helper** (auxiliar) que escolhe e retorna a fábrica concreta apropriada com base em algum critério (como a string `"FORMA"` ou `"COR"`).

---

## 🔥 Por que **NÃO** colocar `getFactory` dentro de `AbstractFactory`?

### 1. **Responsabilidade diferente (SRP - Single Responsibility Principle)**

- `AbstractFactory` define **o que as fábricas fazem** (contratos como `getForma()` ou `getCor()`).
- `getFactory()` tem como papel **decidir qual fábrica criar**, ou seja, é uma **responsabilidade separada**.

Colocar isso em `AbstractFactory` **quebraria o princípio da responsabilidade única**.

---

### 2. **Seria estranho fazer isso dentro de algo abstrato**

Você não pode instanciar diretamente uma classe abstrata. Então, seria **contraditório ter um método que retorna implementações concretas dentro de uma classe que não pode ser instanciada**.

---

## 🧠 Analogia simples:

Imagine:

- `FormaFactory` → Fábrica de Formas
- `CorFactory` → Fábrica de Cores
- `FactoryProdutor` → Funcionário do balcão que pergunta: "Você quer formas ou cores?"

Não faz sentido perguntar isso **dentro da própria fábrica**, né? Esse papel é de alguém acima: **o produtor**.

---

## ✅ Conclusão

Você **não deve** colocar `getFactory()` dentro de `AbstractFactory`, porque:

- `AbstractFactory` define **o contrato**, não escolhe implementações.
- `FactoryProdutor` existe **justamente para separar essa lógica de escolha**.
- É uma **boa prática de design**, respeitando princípios como **responsabilidade única** e **abstração correta**.

### EXPLICANDO CÓDIGO

```java
public class FactoryProdutor {
	
	public static AbstractFactory getFactory (String escolha) {
		
		if(escolha.equalsIgnoreCase("FORMA")) {
			return new FormaFactory();
			
		} else if (escolha.equalsIgnoreCase("COR")) {
			return new CorFactory();
		}
		
		return null;
	}

}

```

🏆

---

### Código completo:

```java
public class FactoryProdutor {

    public static AbstractFactory getFactory(String escolha) {

        if (escolha.equalsIgnoreCase("FORMA")) {
            return new FormaFactory();

        } else if (escolha.equalsIgnoreCase("COR")) {
            return new CorFactory();
        }

        return null;
    }

}

```

---

### Linha por linha:

---

### `public class FactoryProdutor {`

- **Declaração da classe pública** chamada `FactoryProdutor`.
- Essa classe tem o papel de **fornecer fábricas específicas** com base em uma **string de escolha** (ex: `"FORMA"` ou `"COR"`).
- É uma **fábrica de fábricas** (no padrão **Abstract Factory**).

---

### `public static AbstractFactory getFactory(String escolha) {`

- Declara o método **estático** `getFactory`, que:
    - Pode ser chamado **sem instanciar** a classe `FactoryProdutor`.
    - **Retorna um objeto do tipo `AbstractFactory`**, que pode ser uma `FormaFactory` ou uma `CorFactory`.
    - Recebe um parâmetro `escolha`, do tipo `String`, que define qual fábrica o usuário quer.

---

### `if (escolha.equalsIgnoreCase("FORMA")) {`

- Verifica se o valor de `escolha` é **"FORMA"**, **ignorando se está em maiúsculas ou minúsculas**.
- Exemplo: `"FORMA"`, `"forma"`, `"Forma"`... todos seriam aceitos.

---

### `return new FormaFactory();`

- Se a condição acima for verdadeira, cria e **retorna uma nova instância da fábrica de formas (`FormaFactory`)**.
- Essa fábrica provavelmente implementa `AbstractFactory` e tem métodos como `getForma()`.

---

### `} else if (escolha.equalsIgnoreCase("COR")) {`

- Se a escolha não foi `"FORMA"`, verifica se é `"COR"`, ignorando letras maiúsculas/minúsculas.
- Serve para retornar a fábrica de cores, se for o caso.

---

### `return new CorFactory();`

- Cria e retorna uma **nova instância de `CorFactory`**, que também deve implementar `AbstractFactory`.
- Essa fábrica provavelmente tem um método como `getCor()`.

---

### `return null;`

- Caso a `escolha` não seja nem `"FORMA"` nem `"COR"`, o método retorna `null`.
- Isso significa que **nenhuma fábrica foi selecionada** (opcionalmente, você poderia lançar uma exceção aqui em vez de retornar `null`).

---

### 🔁 Exemplo de uso:

```java
AbstractFactory fabricaDeFormas = FactoryProdutor.getFactory("FORMA");
Forma circulo = fabricaDeFormas.getForma("CIRCULO");
circulo.desenhar();

```

- Aqui:
    - `getFactory("FORMA")` → retorna `FormaFactory`
    - `getForma("CIRCULO")` → retorna objeto `Circulo`
    - `desenhar()` → imprime: `"Círculo interno :: método draw()"`

---

### ✅ Resumo:

| Linha | Função |
| --- | --- |
| `public class FactoryProdutor` | Define a classe responsável por retornar uma fábrica concreta. |
| `public static AbstractFactory...` | Define o método que escolhe e retorna a fábrica com base na entrada. |
| `if (...)` e `else if (...)` | Checa a entrada e decide qual fábrica retornar. |
| `return new ...` | Instancia e retorna a fábrica apropriada. |
| `return null` | Retorna `null` se a entrada não for reconhecida. |

---


### MÉTODOS EM OUTRAS CLASSES

🏆 É **muito comum e uma boa prática** criar métodos em uma classe que retornem objetos de outras classes, especialmente em padrões de projeto e designs bem organizados.

---

### Por quê?

1. **Encapsulamento e abstração:**
    
    Uma classe pode atuar como **fábrica, construtor ou provedor** de objetos, escondendo a complexidade da criação ou configuração desses objetos.
    
2. **Padrões de projeto:**
    - No **Factory Method** ou **Abstract Factory**, métodos em uma classe retornam instâncias de outras classes para desacoplar a criação do uso.
    - Exemplo: uma `FabricaDeFormas` tem método `getForma()` que retorna objetos como `Circulo`, `Retangulo` etc.
3. **Organização do código:**
    
    Centralizar a criação de objetos numa única classe/método ajuda a manter o código mais limpo, reutilizável e testável.
    

---

### Exemplo simples:

```java
public class CarroFactory {
    public Carro criarCarro(String modelo) {
        if(modelo.equals("sedan")) {
            return new Sedan();
        } else if(modelo.equals("SUV")) {
            return new Suv();
        }
        return null;
    }
}

```

Aqui, o método `criarCarro` **não retorna um `CarroFactory`, mas sim objetos `Carro` (ou seus derivados)**.

---

### Resumo

- **É normal e desejável** uma classe ter métodos que retornem objetos de outras classes.
- Isso promove **boa separação de responsabilidades** e facilita manutenção e escalabilidade.
