# 4 → MELHORANDO O CÓDIGO COM DESIGN PATTERN

### FRASES PARA COMPREENDER MELHOR COMO APRIMORAR O CÓDIGO COM OS PADRÕES DE DESIGN

### FRASE 01

🏆 Os padrões de design oferecem uma abordagem de melhores práticas para dar suporte ao design de software orientado a objetos, que é mais fácil de projetar, implementar, alterar, testar e reutilizar.

> A ideia é criar recursos que sejam reutilizados em outros projetos, dessa maneira a gente diminui até mesmo o tempo de desenvolvimento, já que o bloco de código já esta funcionando.
> 

### FRASE 02

🏆 A ideia é acelerar o processo de desenvolvimento fornecendo paradigmas de desenvolvimento/design bem testados e comprovados.

> A cada novo projeto podemos sugerir um aprimoramento para algum módulo que já foi realizado e utilizado anteriormente.
> 

### FRASE 03

🏆 Um padrão de design representa uma ideia, não uma implementação especifica.

Padrões de projeto são estratégias independentes de linguagem de programação para resolver um problema comum.


---

## MÃO NA MASSA!! OS CÓDIGOS DESSA AULA ESTÃO NO GITHUB.

🏆

### VAMOS UTILIZAR O PADRÃO BRIDGE

A estrutura básica do **Bridge Pattern** envolve:

1. **Abstração (Abstraction)**
    - Define a interface abstrata e mantém uma referência para o objeto Implementador.
2. **Implementador (Implementor)**
    - Interface para as classes que fornecem a implementação.
3. **Refinamento da Abstração (RefinedAbstraction)**
    - Extende a Abstração e usa o Implementador para realizar ações.
4. **Implementações Concretas (ConcreteImplementor)**
    - Classes que implementam a interface Implementador com diferentes versões ou plataformas.

---

**Resumo visual simples:**

```
Abstraction  ---------->  Implementor
     |                        |
RefinedAbstraction      ConcreteImplementor

```

## 🔗 **Bridge Pattern** — Padrão **Ponte**

O **Bridge** é um dos **23 padrões de projeto** do livro *Design Patterns: Elements of Reusable Object-Oriented Software* (Gang of Four, ou GoF). Ele é um padrão **estrutural**, e seu objetivo é:

> "Desacoplar uma abstração da sua implementação, de forma que as duas possam variar independentemente."
> 

💡 Abstração é ocultar os detalhes complexos e mostrar apenas o essencial.


---

### 📌 Quando usar?

Use o padrão **Bridge** quando:

- Você tem uma **hierarquia de classes muito grande** (abstrações e implementações combinadas).
- Deseja **manter a flexibilidade** para **alterar abstrações ou implementações separadamente**.
- Quer evitar uma **explosão de subclasses** com múltiplas variações.

---

## 🔧 Estrutura do padrão Bridge

### Participantes:

- **Abstraction**: Define a interface de alto nível (ex: `RemoteControl`)
- **RefinedAbstraction**: Extende a abstração com comportamentos adicionais (ex: `AdvancedRemoteControl`)
- **Implementor**: Interface para a implementação (ex: `Device`)
- **ConcreteImplementor**: Implementações reais (ex: `TV`, `Radio`)

💡 Um dos principais objetivos desse padrão é separar as devidas funcionalidades nas determinadas classes.


---

## EXPLICAÇÃO DE PARTES DO CÓDIGO

💡 minha classe BasicRemote está dessa forma public class BasicRemote implements Remote {

```
protected Device device;

public BasicRemote() {}

public BasicRemote(Device device) {
	this.device = device;
}  

```

resume linha por linha e explica ela para mim

🏆 Vamos analisar sua classe `BasicRemote` linha por linha de forma objetiva e didática.

---

### 🧩 Código da classe:

```java
public class BasicRemote implements Remote {

```

- Define a **classe `BasicRemote`**.
- Ela **implementa a interface `Remote`**, o que significa que ela deve fornecer implementação para os métodos definidos na interface `Remote`.
- Essa classe é a **Abstraction** no **Bridge Pattern**.

---

```java
	protected Device device;

```

- Declara uma variável `device` com visibilidade **`protected`**, ou seja:
    - Pode ser acessada pela própria classe, por subclasses (`AdvancedRemote`, por exemplo) e por outras classes no mesmo pacote.
- O tipo `Device` é a **interface Implementor** do padrão Bridge — representa o **dispositivo real** (como TV, rádio...).
- Esse campo **conecta a abstração com a implementação**.

---

```java
	public BasicRemote() {}

```

- **Construtor padrão (sem parâmetros)**.
- Permite criar um `BasicRemote` **sem definir o `device` ainda** (embora isso torne o controle inútil até o dispositivo ser atribuído manualmente).

---

```java
	public BasicRemote(Device device) {
		this.device = device;
	}

```

- Construtor com parâmetro.
- Permite criar um `BasicRemote` **já ligado a um dispositivo real** (`TV`, `Radio`, etc.).
- `this.device = device;` → armazena o dispositivo passado no atributo da classe.

---

### ✅ **Resumo geral da classe `BasicRemote`:**

- **Função:** É a implementação básica de um controle remoto.
- Usa a interface `Remote` para definir seu contrato.
- Guarda uma referência (`device`) ao dispositivo real, que será manipulado.
- Faz parte da **abstração** no padrão **Bridge**, permitindo separar o **controle (Remote)** do **dispositivo (Device)**.

---

Se quiser, posso complementar com os métodos típicos dessa classe (como `volumeUp`, `channelDown`, etc.) para ver como ela interage com `device`.



### DIFERENÇA DE DEVICE X REMOTE

🏆 Vamos esclarecer a **diferença entre as interfaces `Device` e `Remote`** no contexto do seu código e do **padrão de projeto Bridge**.

---

### 🧩 **1. Interface `Device`**

👉 **Implementor** no Bridge Pattern

### ✅ Função:

Define **o que um dispositivo (como TV, rádio, etc.) pode fazer**.

Ela representa **a implementação real**, e as classes concretas (como `Tv`, `Radio`) implementam essa interface.

### 🧪 Exemplos típicos de métodos:

```java
public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}

```

---

### 🎮 **2. Interface `Remote`**

👉 **Abstraction** no Bridge Pattern

### ✅ Função:

Define o **comportamento de um controle remoto** que opera dispositivos (`Device`).

Ela representa **a abstração que será usada pelos clientes** (usuários, programadores, etc.)

### 🧪 Exemplos típicos de métodos:

```java
public interface Remote {
    void power();
    void volumeUp();
    void volumeDown();
    void channelUp();
    void channelDown();
}

```

---

### 🔍 **Diferença resumida:**

| Interface | Papel no Bridge | Representa | Implementada por | Exemplos |
| --- | --- | --- | --- | --- |
| `Device` | Implementor | O **dispositivo real** | `Tv`, `Radio`, etc. | `setVolume()`, `getChannel()` |
| `Remote` | Abstraction | O **controle remoto** | `BasicRemote`, `AdvancedRemote` | `volumeUp()`, `mute()` |

---

### 🧠 **Analogia simples:**

- **Device** = A TV (comandos reais: mudar volume, ligar/desligar)
- **Remote** = O controle (botões que "pedem" para a TV fazer algo)

---


### EXPLICAÇÃO DA SAÍDA DO CONSOLE

🏆

Testes com controle remoto básico
Controlo remoto: alternar energia (ligado / desligado)

TV: Ligada
Volume atual: 30%
Canal atual: 1

Testes com controle remoto avançado.
Controlo remoto: alternar energia (ligado / desligado)
Controlo remoto: tirar volume (mudo)

TV: Desligada
Volume atual: 0%
Canal atual: 1

💡 Vamos analisar por que **os valores mudam** quando você usa o **controle remoto avançado**, especificamente:

```
TV: Desligada
Volume atual: 0%
Canal atual: 1

```

---

### ✅ **Resumo do que acontece no seu método `testDevice`:**

```java
BasicRemote basicRemote = new BasicRemote(device);
basicRemote.power(); // liga a TV
device.printStatus(); // TV: Ligada, Volume: 30, Canal: 1

AdvancedRemote advancedRemote = new AdvancedRemote(device);
advancedRemote.power(); // desliga a TV
advancedRemote.mute();  // zera o volume
device.printStatus();   // TV: Desligada, Volume: 0, Canal: 1

```

---

### 🔍 **Passo a passo detalhado do que está acontecendo:**

### 1. **Você liga a TV com o controle básico:**

```java
basicRemote.power();

```

- Esse método **alterna o estado da TV**:
    - Se estava desligada (`on = false`), agora está **ligada (`on = true`)**

### 2. **Depois imprime o status:**

```java
device.printStatus();

```

Resultado:

```
TV: Ligada
Volume atual: 30%
Canal atual: 1

```

### 3. **Você usa o controle remoto avançado:**

```java
advancedRemote.power();

```

- Isso **desliga a TV**, porque ela já estava ligada.
- Lembra: `power()` funciona como **toggle** (liga/desliga).

### 4. **Você chama `advancedRemote.mute();`**

```java
device.setVolume(0); // ← aqui zera o volume

```

### 5. **Imprime novamente o status:**

```java
device.printStatus();

```

Agora mostra:

```
TV: Desligada
Volume atual: 0%
Canal atual: 1

```

---

### ✅ **Conclusão:**

| Alteração | Causa |
| --- | --- |
| **Desligou a TV** | `advancedRemote.power()` chamou `device.disable()` |
| **Volume = 0%** | `advancedRemote.mute()` chamou `device.setVolume(0)` |
| **Canal = 1** | Nunca foi alterado, continuou igual ao estado inicial |

---

