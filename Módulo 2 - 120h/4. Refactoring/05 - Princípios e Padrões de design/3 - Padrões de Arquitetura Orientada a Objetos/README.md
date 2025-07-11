# 3 → PADRÕES DE ARQUITETURA ORIENTADA A OBJETOS

### FRASES QUE VÃO NORTEAR A NOSSA REFLEXÃO

### FRASE 01

🏆 Os objetos são os blocos de construção fundamentais para todos os tipos de aplicativos de software 

🏆 Portanto, o estilo arquitetônico orientado a objetos tornou-se o dominante para a produção de aplicativos de software orientada a objetos.


## 🧱 Frase:

**"Os objetos são os blocos de construção fundamentais para todos os tipos de aplicativos de software."**

---

### ✅ Explicando passo a passo:

### 1. **"Objetos"**

No contexto de **programação orientada a objetos (POO)**, um **objeto** é uma unidade que contém **dados (atributos)** e **comportamentos (métodos)**.

Exemplo: Um objeto "Carro" pode ter atributos como `cor`, `modelo`, e métodos como `acelerar()`, `frear()`.

---

### 2. **"Blocos de construção fundamentais"**

A ideia de "bloco de construção" vem da engenharia: tijolos constroem casas; peças constroem máquinas.

Na programação, **objetos são como esses "tijolos"**: com eles, você monta **funcionalidades complexas** de um programa.

---

### 3. **"Para todos os tipos de aplicativos de software"**

A frase sugere que **independente do tipo de software** (jogos, apps móveis, sistemas bancários...), os objetos **são essenciais na construção** desses sistemas quando usamos a abordagem orientada a objetos.

---

## 📌 Resumo:

> Em sistemas que usam a programação orientada a objetos, os objetos são as peças básicas que você combina para criar funcionalidades completas. Assim como blocos constroem uma casa, os objetos constroem programas.
> 

---


### FRASE 02

🏆 As propriedades de herança, polimorfismo, encapsulamento e composição fornecidas pelo POO são úteis na produção de aplicativos de software altamente modulares (coesos e acoplados), utilizáveis e reutilizáveis.


### FRASE 03

🏆 O estilo orientado a objetos é adequado se quisermos encapsular a lógica e os dados juntos em componentes reutilizáveis.

> Nós podemos encapsular os atributos e acessa-los a partir dos métodos de acesso (get e set), dessa maneira a estrutura do nosso código ficará adequada, facilitando ajustes e alterações.
> 

### FRASE 04

🏆 Os componentes de um sistema encapsulam dados e as operações que devem ser aplicadas para manipular os dados.

🏆 a coordenação e a comunicação entre os componentes são estabelecidas via passagem de mensagens. 


## 🧱 Frase 1:

> "Os componentes de um sistema encapsulam dados e as operações que devem ser aplicadas para manipular os dados."
> 

### ✅ Explicação:

Na programação orientada a objetos, **"componentes"** são normalmente **classes e objetos**.

**Encapsular** significa **proteger os dados internos** da classe e permitir acesso a eles **apenas por meio de métodos (operações)**.

### 💡 Exemplo:

```java
public class ContaBancaria {
    private double saldo; // dado encapsulado

    public void depositar(double valor) { // operação
        saldo += valor;
    }

    public double consultarSaldo() { // operação
        return saldo;
    }
}

```

### 🧠 Resumo:

- `saldo` está protegido (privado).
- Só é possível alterar ou ler o saldo por meio dos **métodos públicos** (`depositar`, `consultarSaldo`).
- Isso é **encapsulamento**: os dados estão “fechados” e são manipulados por métodos da própria classe.

---

## 💬 Frase 2:

> "A coordenação e a comunicação entre os componentes são estabelecidas via passagem de mensagens."
> 

### ✅ Explicação:

Na OOP, os **objetos "conversam" entre si** chamando **métodos uns dos outros**.

Isso é o que chamamos de **passagem de mensagens**.

### 💡 Exemplo:

```java
public class Cliente {
    public void realizarDeposito(ContaBancaria conta, double valor) {
        conta.depositar(valor); // cliente envia mensagem para conta
    }
}

```

### 🧠 Resumo:

- O objeto `Cliente` **comunica-se com** o objeto `ContaBancaria` chamando o método `depositar()`.
- Isso é uma **mensagem enviada** para o objeto `conta`, pedindo que ele execute uma operação.
- Essa é a forma de **coordenação entre objetos** na OOP.

---

## ✅ Conclusão simplificada:

| Conceito | Exemplo no código |
| --- | --- |
| **Encapsulamento** | `saldo` só é acessado via métodos |
| **Passagem de mensagens** | `cliente.realizarDeposito(conta...)` chama método de outro objeto |

---


---

## VANTAGENS DA ARQUITETURA ORIENTADA A OBJETOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/arquiteturaPOO1.png" />

🟢 Nós conseguimos separar as funcionalidades, dividir os recursos, agrupar os elementos que são semelhantes, isso pode melhorar a performance do nosso projeto, além da possibilidade da reutilização dos recursos que foram criados.


🟣 Esses ajustes não vão afetar o funcionamento do programa como um todo


---

---

### EXPLICAÇÃO DE UM CÓDIGO QUE EU NÃO ESTAVA ENTENDENDO

## 🎯 Objetivo:

Mostrar por que **passar o objeto `ContaBancaria` como parâmetro** é útil — especialmente quando temos **vários clientes e várias contas**.

---

## 🧱 Estrutura do exemplo:

- **Cada cliente pode depositar em contas diferentes**
- **O método `realizarDeposito` recebe a conta como parâmetro**
- A lógica fica **flexível e reutilizável**

---

## ✅ Código completo:

### 🔹 `ContaBancaria.java`

```java
package banco;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

```

---

### 🔹 `Cliente.java`

```java
package banco;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void realizarDeposito(ContaBancaria conta, double valor) {
        System.out.println(nome + " está depositando R$" + valor + " na conta de " + conta.getTitular());
        conta.depositar(valor);
    }
}

```

---

### 🔹 `Main.java`

```java
package banco;

public class Main {
    public static void main(String[] args) {
        // Criando contas
        ContaBancaria contaAna = new ContaBancaria("Ana");
        ContaBancaria contaBruno = new ContaBancaria("Bruno");

        // Criando clientes
        Cliente joao = new Cliente("João");
        Cliente maria = new Cliente("Maria");

        // João deposita em duas contas diferentes
        joao.realizarDeposito(contaAna, 100.0);
        joao.realizarDeposito(contaBruno, 50.0);

        // Maria deposita na conta da Ana
        maria.realizarDeposito(contaAna, 200.0);

        // Mostrando saldos
        System.out.println("\nSaldo de Ana: R$" + contaAna.getSaldo());
        System.out.println("Saldo de Bruno: R$" + contaBruno.getSaldo());
    }
}

```

---

## 📌 Saída esperada:

```
João está depositando R$100.0 na conta de Ana
João está depositando R$50.0 na conta de Bruno
Maria está depositando R$200.0 na conta de Ana

Saldo de Ana: R$300.0
Saldo de Bruno: R$50.0

```

---

## ✅ O que esse exemplo mostra?

| O que está acontecendo? | Por quê isso importa? |
| --- | --- |
| `Cliente` usa qualquer `ContaBancaria` | Reutilização de código |
| Cada cliente pode operar em **qualquer conta passada** | Alta flexibilidade |
| Método `realizarDeposito(conta, valor)` é **genérico** | Fácil de manter e escalar |

---