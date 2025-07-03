# 1 → PRINCÍPIOS DE DESIGN

## DIFERENÇA ENTRE PRINCÍPIOS DE DESIGN E PADRÕES DE PROJETO

**princípios de design não são a mesma coisa que design patterns**, embora estejam relacionados.

---

## ✅ Diferença entre **Princípios de Design** e **Design Patterns**:

### 🔹 **Princípios de Design**:

São **regras gerais, boas práticas e diretrizes** que ajudam a escrever código mais limpo, modular, reutilizável e fácil de manter.

- Eles são **mais abstratos**.
- Você os aplica **de forma ampla** no seu código e no design da arquitetura.
- Exemplo: o famoso conjunto de princípios **SOLID**.

### 📌 Exemplos de princípios de design:

- **S — Single Responsibility Principle**: Uma classe deve ter apenas um motivo para mudar.
- **O — Open/Closed Principle**: Aberto para extensão, fechado para modificação.
- **L — Liskov Substitution Principle**: Subclasses devem poder ser substituídas por suas superclasses sem quebrar o sistema.
- **I — Interface Segregation Principle**: Muitas interfaces específicas são melhores do que uma interface genérica.
- **D — Dependency Inversion Principle**: Dependa de abstrações, não de implementações.

Outros princípios:

- **DRY (Don’t Repeat Yourself)**: Evite duplicação de código.
- **KISS (Keep It Simple, Stupid)**: Mantenha as coisas simples.
- **YAGNI (You Aren’t Gonna Need It)**: Não implemente o que não é necessário.

---

### 🔹 **Design Patterns**:

São **soluções reutilizáveis** e testadas para problemas específicos de design de software.

- Eles são **mais concretos**, com **estruturas conhecidas** (classes, métodos, relações).
- Você os aplica em **situações específicas** para resolver um problema comum.
- Exemplos: **Singleton**, **Observer**, **Factory**, **Strategy**, etc.

---

## ✅ Resumo:

| Conceito | O que é? | Exemplo |
| --- | --- | --- |
| **Princípios de Design** | Regras gerais de design e boas práticas | SOLID, DRY, KISS, YAGNI |
| **Design Patterns** | Soluções específicas para problemas recorrentes | Singleton, Observer, Factory |

---

🏆 O QUE É, E COMO A GENTE CONSEGUE CRIAR CÓDIGOS A PARTIR DO PRINCÍPIO DE DESIGN


---

### DEFINIÇÕES PARA REFLETIR E ENTENDER MELHOR

### FRASE 01

🏆 Um padrão de projeto é uma solução geral repetível para um problema comum no projeto de software.

É uma descrição ou modelo de como resolver um problema que pode ser usado em muitas situações diferentes

> Nós temos um problema e a partir do padrão de projeto a gente consegue encontrar a solução de uma maneira mais simples.
> 

### FRASE 02

🏆 Os padrões de design podem acelerar o processo de desenvolvimento fornecendo paradigmas de desenvolvimento testados e comprovados.

> Quando conseguimos aplicar um padrão de design, a gente consegue acelerar o processo de desenvolvimento.
> 

### FRASE 03

🏆 O design de software eficaz requer a consideração de questões que podem não se tornar visíveis até mais tarde na implementação.


### FRASE 04

🏆 A reutilização de padrões de design(design patterns) ajuda a evitar problemas sutis que podem causar grandes problemas e melhorar a legibilidade do código para codificadores e arquitetos familiarizados com os padrões.

> Para a realização das manutenções, quando adotamos um padrão, nós conseguimos melhorar todos esses processos.
> 

### FRASE 05

🏆 Os padrões de projeto fornecem soluções gerais, documentadas em um formato que não requer especificações vinculadas a um problema especifico.

 

> Nós conseguimos aplicar os padrões em projetos diferentes, que utilizam arquiteturas diferentes
> 

### FRASE 06

🏆 Os padrões permitem que os desenvolvedores se comuniquem usando nomes conhecidos e bem compreendidos para interações de software.


---

## MÃO NA MASSA!

### ADAPTER PATTERN

🏆 Ele permite que as classes trabalhem juntas, o que não pode acontecer devido a interfaces incompatíveis. 


🏆 O **Adapter Pattern** (Padrão Adaptador) é um **padrão de projeto estrutural** cujo objetivo é permitir que duas interfaces incompatíveis trabalhem juntas. Ele atua como um **"tradutor"** entre classes com interfaces diferentes, mas que precisam cooperar.

### 📌 Finalidade:

Permitir que uma classe funcione com outra classe cuja interface é diferente da esperada.

---

### ✅ Quando usar:

- Quando você quer reutilizar uma classe existente, mas sua interface não é compatível com o restante do sistema.
- Quando você quer integrar uma nova funcionalidade em um sistema legado sem alterar o código existente.

---

### 🧱 Estrutura:

O padrão geralmente envolve:

- **Target**: A interface esperada pelo cliente.
- **Adaptee**: A classe existente com a interface incompatível.
- **Adapter**: A classe que implementa a interface do Target e traduz as chamadas para o Adaptee.

---

### 🧩 Exemplo prático:

Imagine um sistema que espera objetos do tipo `TomadaAmericana`, mas você tem um dispositivo com `TomadaEuropeia`. Um **Adaptador** pode ser criado para converter uma `TomadaEuropeia` em uma `TomadaAmericana`.

---

### 💬 Analogias:

É como um **adaptador de tomada elétrica**: você usa um adaptador para conectar um plug europeu em uma tomada americana.

---

### 👨‍💻 Exemplo em código (Java):

```java
// Target
interface TomadaAmericana {
    void conectar();
}

// Adaptee
class TomadaEuropeia {
    void ligar() {
        System.out.println("Tomada europeia conectada.");
    }
}

// Adapter
class AdaptadorEuropeuParaAmericano implements TomadaAmericana {
    private TomadaEuropeia tomadaEuropeia;

    AdaptadorEuropeuParaAmericano(TomadaEuropeia tomada) {
        this.tomadaEuropeia = tomada;
    }

    public void conectar() {
        tomadaEuropeia.ligar();
    }
}

```

---

### ⚖️ Vantagens:

- Reutilização de código existente.
- Redução de acoplamento entre sistemas.
- Facilidade de integração com APIs legadas.

### ❗ Desvantagens:

- Pode adicionar complexidade.
- Muitos adaptadores podem tornar o sistema difícil de manter.

---


### INTERFACE CREDITCARD

```java
package design.patterns.adapter.pattern;

public interface CreditCard {
	
	public void fornecaDadosBancarios();
	
	public String getCreditCard();

}
```

### CLASSE BANKDETAILS

```java
package design.patterns.adapter.pattern;

public class BankDetails {
	
	private String bankName;
	private String accHolderName;
	private long accNumber;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	
	

}
```

### CLASSE BANK CUSTOMER

```java
package design.patterns.adapter.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {

	@Override
	public void fornecaDadosBancarios() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Digite o nome do titular da conta: ");
			String customername = br.readLine();
			System.out.println("\n");

			System.out.println("Digite o número da conta:");
			long accn = Long.parseLong(br.readLine());
			System.out.println("\n");

			System.out.println("Digite o nome do banco: ");
			String bankname = br.readLine();

			setAccHolderName(customername);
			setAccNumber(accn);
			setBankName(bankname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCreditCard() {
		return "Cartão de crédito fornecido com os seguintes dados:\n" + "Titular: " + getAccHolderName() + "\n"
				+ "Banco: " + getBankName() + "\n" + "Conta: " + getAccNumber();
	}

}
```



### EXPLICAÇÃO LINHA POR LINHA DESSA CLASSE 🏆

```java
public class BankCustomer extends BankDetails implements CreditCard {

```

➡️ Define uma classe chamada `BankCustomer` que **herda** de `BankDetails` e **implementa** a interface `CreditCard`.

---

```java
@Override
public void fornecaDadosBancarios() {

```

➡️ Sobrescreve o método `fornecaDadosBancarios()` da interface ou classe base, que coleta dados bancários.

---

```java
try {

```

➡️ Inicia um bloco `try` para capturar possíveis exceções.

---

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

```

➡️ Cria um leitor de entrada para capturar dados digitados no console.

---

```java
System.out.println("Digite o nome do titular da conta: ");

```

➡️ Exibe uma mensagem pedindo o nome do titular.

---

```java
String customername = br.readLine();

```

➡️ Lê o nome digitado pelo usuário.

---

```java
System.out.println("\n");

```

➡️ Imprime uma linha em branco (salto de linha).

---

```java
System.out.println("Digite o número da conta:");

```

➡️ Exibe uma mensagem pedindo o número da conta.

---

```java
long accn = Long.parseLong(br.readLine());

```

➡️ Lê o número da conta e converte a entrada de texto em `long`.

---

```java
System.out.println("\n");

```

➡️ Imprime outra linha em branco.

---

```java
System.out.println("Digite o nome do banco: ");

```

➡️ Exibe uma mensagem pedindo o nome do banco.

---

```java
String bankname = br.readLine();

```

➡️ Lê o nome do banco digitado pelo usuário.

---

```java
setAccHolderName(customername);

```

➡️ Salva o nome do titular usando o método `setAccHolderName()` da classe `BankDetails`.

---

```java
setAccNumber(accn);

```

➡️ Salva o número da conta com `setAccNumber()`.

---

```java
setBankName(bankname);

```

➡️ Salva o nome do banco com `setBankName()`.

---

```java
} catch (Exception e) {
    e.printStackTrace();
}

```

➡️ Captura e imprime qualquer exceção que ocorra durante a entrada de dados.

---

```java
@Override
public String getCreditCard() {
    // TODO Auto-generated method stub
    return null;
}

```

➡️ Método `getCreditCard()` da interface `CreditCard` foi sobrescrito, mas **ainda não foi implementado** (retorna `null` por enquanto).

---


### CLASSE ADAPTER PATTERN DEMO

```java
package design.patterns.adapter.pattern;

public class AdapterPatternDemo {

	public static void main(String[] args) {
	
		CreditCard targetInterface = new BankCustomer();
		
		targetInterface.fornecaDadosBancarios();
		System.out.println(targetInterface.getCreditCard());
	}

}

```



### EXPLICANDO LINHA POR LINHA DESSA CLASSE 🏆

## 📂 Classe: `AdapterPatternDemo`

```java
package design.patterns.adapter.pattern;

```

➡️ Define o **pacote** onde essa classe está localizada. Ajuda a organizar o código e evitar conflitos de nomes entre classes.

---

```java
public class AdapterPatternDemo {

```

➡️ Declara a **classe principal** usada para demonstrar o funcionamento do **Adapter Pattern**.

---

```java
	public static void main(String[] args) {

```

➡️ Declara o **método principal** que será executado ao iniciar o programa. É o ponto de entrada da aplicação Java.

---

```java
		CreditCard targetInterface = new BankCustomer();

```

➡️ Aqui acontece algo muito importante:

### 🧠 O que está acontecendo?

- Você está **criando um objeto do tipo `BankCustomer`**, que é uma classe que **implementa** a interface `CreditCard`.
- No entanto, a **variável é do tipo `CreditCard`**, ou seja, ela só pode acessar os métodos definidos nessa interface.

### 🤔 Por quê?

- Isso é um exemplo de **programação orientada a interfaces**.
- **Motivo:** permite flexibilidade e baixo acoplamento. Você pode facilmente trocar a implementação (`BankCustomer`) por outra classe que também implemente `CreditCard`, sem mudar o código que usa o objeto.

### 📌 Analogia:

É como declarar uma variável do tipo `List`, mas instanciar com `new ArrayList()`. Você programa para a **interface**, não para a implementação.

---

```java
		targetInterface.fornecaDadosBancarios();

```

➡️ Chama o método `fornecaDadosBancarios()` da interface `CreditCard`, que foi **implementado por `BankCustomer`**.

- Esse método coleta os dados bancários do usuário (via `System.in`).

---

```java
		System.out.println(targetInterface.getCreditCard());

```

➡️ Exibe o resultado do método `getCreditCard()`, que retorna uma string formatada com os dados fornecidos anteriormente.

---

## ✅ Por que usar interface no lado esquerdo?

- **Flexibilidade:** Você pode mudar `BankCustomer` por outra classe no futuro, sem mudar o código do cliente.
- **Polimorfismo:** Permite que diferentes objetos que implementam a mesma interface possam ser tratados igualmente.
- **Padrão Adapter:** É **essencial** aqui porque `CreditCard` é o "alvo" que o código cliente espera — e `BankCustomer` é o **adaptador** que traduz a interface de `BankDetails.`

---




### ENTENDENDO MELHOR ❓

## ✅ Sua dúvida:

> Se BankDetails é uma classe, como BankCustomer pode ser um adaptador que "traduz a interface de BankDetails"?
> 

---

## 🧩 Lembre-se do papel do **Adapter Pattern**:

O Adapter Pattern serve para **fazer duas interfaces incompatíveis se comunicarem**, sem precisar modificar o código original de nenhuma delas.

---

## 💡 Situação do seu código:

### 🧱 Classe existente (incompatível com o cliente):

```java
public class BankDetails {
    private String bankName;
    private String accHolderName;
    private long accNumber;

    // getters e setters...
}

```

- Essa classe **contém dados bancários**, mas **não implementa** a interface `CreditCard`.
- Ou seja: o **cliente que espera um `CreditCard` não pode usar um `BankDetails` diretamente**.

---

### 🎯 Interface esperada pelo cliente:

```java
public interface CreditCard {
    void fornecaDadosBancarios();
    String getCreditCard();
}

```

- O **código cliente quer trabalhar com objetos que implementam `CreditCard`**.

---

### 🧩 O papel de `BankCustomer` como adaptador:

```java
public class BankCustomer extends BankDetails implements CreditCard {
    @Override
    public void fornecaDadosBancarios() {
        // Pede os dados do usuário e armazena usando métodos de BankDetails
    }

    @Override
    public String getCreditCard() {
        // Usa os dados de BankDetails para montar a resposta
    }
}

```

Aqui, `BankCustomer` atua como **Adaptador** porque:

1. **Extende `BankDetails`** para **acessar e manipular os dados bancários existentes**.
2. **Implementa `CreditCard`**, permitindo que o objeto **seja tratado como um "cartão de crédito" pelo cliente**.

> ✅ Assim, ele adapta a "estrutura" da classe BankDetails à "interface" esperada (CreditCard).
> 

---

### 📊 Visual do Adapter Pattern no seu exemplo:

```
[ Client (espera CreditCard) ]
            |
            v
[ CreditCard interface ] <-- "Target"
            ^
            |
[ BankCustomer ] ---------> usa os métodos de [ BankDetails ]
     ^                             (classe já existente)
     |
[ Adapter ]

```

---

### 📝 Resumo simples:

- `BankDetails` é uma **classe já existente** com dados bancários.
- O cliente **não pode usá-la diretamente**, porque espera um `CreditCard`.
- `BankCustomer` **traz os métodos da interface esperada** (`CreditCard`) e os **conecta internamente** com os dados da `BankDetails`.
- Isso é o que significa "traduzir a interface de `BankDetails`" — adaptando seu uso ao que o cliente espera.

---



### EXEMPLO DE OUTRA IMPLEMENTAÇÃO DE CREDITCARD 🔒

---

## 🧩 Interface em comum: `CreditCard`

```java
public interface CreditCard {
    void fornecaDadosBancarios();
    String getCreditCard();
}

```

---

## 🔧 Implementação 1: `BankCustomer` (versão básica)

```java
public class BankCustomer extends BankDetails implements CreditCard {

    @Override
    public void fornecaDadosBancarios() {
        setAccHolderName("João Silva");
        setAccNumber(123456789);
        setBankName("Banco do Brasil");
    }

    @Override
    public String getCreditCard() {
        return "Cartão comum emitido para " + getAccHolderName() +
               ", Banco: " + getBankName() +
               ", Conta: " + getAccNumber();
    }
}

```

---

## 🌟 Implementação 2: `PremiumCustomer` (com outro comportamento)

```java
public class PremiumCustomer extends BankDetails implements CreditCard {

    @Override
    public void fornecaDadosBancarios() {
        setAccHolderName("Maria Andrade");
        setAccNumber(987654321);
        setBankName("Banco Premium");
    }

    @Override
    public String getCreditCard() {
        return "💳 Cartão PREMIUM emitido para " + getAccHolderName() +
               " do " + getBankName() +
               ". Conta Nº: " + getAccNumber();
    }
}

```

---

## 💻 Classe de Teste (Main)

```java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Cliente comum
        CreditCard cliente1 = new BankCustomer();
        cliente1.fornecaDadosBancarios();
        System.out.println(cliente1.getCreditCard());

        System.out.println("---------------------------");

        // Cliente premium
        CreditCard cliente2 = new PremiumCustomer();
        cliente2.fornecaDadosBancarios();
        System.out.println(cliente2.getCreditCard());
    }
}

```

---

## ✅ Resultado esperado:

```
Cartão comum emitido para João Silva, Banco: Banco do Brasil, Conta: 123456789
---------------------------
💳 Cartão PREMIUM emitido para Maria Andrade do Banco Premium. Conta Nº: 987654321

```

---

### 🎯 O que isso demonstra?

- As duas classes implementam a **mesma interface** (`CreditCard`).
- O código cliente (`main`) trata ambas **da mesma forma**.
- O comportamento é **diferenciado dinamicamente**, dependendo da implementação.

---




### IMPLEMENTAÇÃO UTILIZANDO LIST 🔒

---

## 1. Interface `CreditCard`

```java
public interface CreditCard {
    void fornecaDadosBancarios();
    String getCreditCard();
}

```

---

## 2. Implementação 1: `BankCustomer`

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {

    @Override
    public void fornecaDadosBancarios() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Digite o nome do titular da conta (BankCustomer): ");
            String customername = br.readLine();

            System.out.print("Digite o número da conta: ");
            long accn = Long.parseLong(br.readLine());

            System.out.print("Digite o nome do banco: ");
            String bankname = br.readLine();

            setAccHolderName(customername);
            setAccNumber(accn);
            setBankName(bankname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCreditCard() {
        return "Cartão BankCustomer para: " + getAccHolderName() + ", Banco: " + getBankName() + ", Conta: " + getAccNumber();
    }
}

```

---

## 3. Implementação 2: `PremiumCustomer`

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PremiumCustomer extends BankDetails implements CreditCard {

    @Override
    public void fornecaDadosBancarios() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Digite o nome do titular da conta (PremiumCustomer): ");
            String customername = br.readLine();

            System.out.print("Digite o número da conta: ");
            long accn = Long.parseLong(br.readLine());

            System.out.print("Digite o nome do banco: ");
            String bankname = br.readLine();

            setAccHolderName(customername);
            setAccNumber(accn);
            setBankName(bankname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCreditCard() {
        return "💳 Cartão Premium para: " + getAccHolderName() + " do banco " + getBankName() + ", Conta: " + getAccNumber();
    }
}

```

---

## 4. Classe base `BankDetails`

```java
public class BankDetails {
    private String bankName;
    private String accHolderName;
    private long accNumber;

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getAccHolderName() { return accHolderName; }
    public void setAccHolderName(String accHolderName) { this.accHolderName = accHolderName; }

    public long getAccNumber() { return accNumber; }
    public void setAccNumber(long accNumber) { this.accNumber = accNumber; }
}

```

---

## 5. Classe demo com `List<CreditCard>`

```java
import java.util.ArrayList;
import java.util.List;

public class AdapterPatternDemo {

    public static void main(String[] args) {
        List<CreditCard> customers = new ArrayList<>();

        customers.add(new BankCustomer());
        customers.add(new PremiumCustomer());

        // Coleta os dados para cada cliente
        for (CreditCard customer : customers) {
            customer.fornecaDadosBancarios();
            System.out.println();
        }

        // Exibe os dados dos cartões
        for (CreditCard customer : customers) {
            System.out.println(customer.getCreditCard());
        }
    }
}

```

---

## 🏃‍♂️ Como funciona?

1. Cria um `List<CreditCard>` que pode guardar qualquer implementação da interface.
2. Adiciona duas instâncias: `BankCustomer` e `PremiumCustomer`.
3. Para cada cliente, chama `fornecaDadosBancarios()`, que pede dados no console.
4. Depois, imprime as informações dos cartões, chamando `getCreditCard()` polimorficamente.
