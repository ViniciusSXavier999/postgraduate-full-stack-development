# 4 → COMMAND

## **Resumo do padrão Command**

O **Command** é um **padrão comportamental** usado para **encapsular uma solicitação como um objeto**, permitindo que você:

1. **Parametrize objetos com ações** (pode passar uma ação como argumento).
2. **Programe filas de comandos** (executar depois ou em ordem).
3. **Desfaça ações** (undo/redo).
4. **Separe quem pede a ação de quem a executa** (cliente e executor desacoplados).

💡 **Analogia simples:**

Imagine um controle remoto (Invoker) que só sabe “pressionar botão”. Cada botão dispara uma ação (Command) que é executada por um dispositivo (Receiver).

---

## **Exemplo de código simples em Java**

```java
// 1. Interface Command
interface Command {
    void execute();
}

// 2. Receiver (quem realmente faz a ação)
class Luz {
    public void ligar() {
        System.out.println("Luz ligada!");
    }
    public void desligar() {
        System.out.println("Luz desligada!");
    }
}

// 3. Comandos concretos
class LigarLuzCommand implements Command {
    private Luz luz;

    public LigarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.ligar();
    }
}

class DesligarLuzCommand implements Command {
    private Luz luz;

    public DesligarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.desligar();
    }
}

// 4. Invoker (quem dispara o comando)
class ControleRemoto {
    private Command comando;

    public void setCommand(Command comando) {
        this.comando = comando;
    }

    public void pressionarBotao() {
        comando.execute();
    }
}

// 5. Cliente
public class Main {
    public static void main(String[] args) {
        Luz luz = new Luz();

        Command ligar = new LigarLuzCommand(luz);
        Command desligar = new DesligarLuzCommand(luz);

        ControleRemoto controle = new ControleRemoto();

        controle.setCommand(ligar);
        controle.pressionarBotao(); // Luz ligada!

        controle.setCommand(desligar);
        controle.pressionarBotao(); // Luz desligada!
    }
}

```

✅ **O que acontece aqui:**

- `Command` encapsula a ação.
- `Luz` é quem realmente executa.
- `ControleRemoto` dispara a ação sem saber os detalhes.
- O cliente pode trocar comandos facilmente sem alterar o invoker.

---

## COMMAND

🏆 Command é um padrão de projeto comportamental que transforma uma solicitação em um objeto autônomo que contém todas as informações sobre a solicitação.

🏆 Essa transformação permite passar solicitações como argumentos de método, atrasar ou enfileirar a execução de uma solicitação e dar suporte a operações que podem ser desfeitas.

> É um padrão orientada a dados.
> 

🏆 Por exemplo, o padrão COMMAND sugere que os objetos GUI(interface gráfica do usuário) não devem enviar as solicitações diretamente.

💡 Em vez disso, você deve extrair todos os detalhes da solicitação, como o objeto que está sendo chamado, o nome do método e a lista de argumentos em uma classe de comando separada com um único método que aciona essa solicitação.


---

### EXPLICANDO LINHA POR LINHA DO CÓDIGO DA CLASSE GERENCIADOR

```java

public class Gerenciador {
	
	private List<Ordem> ordemList = new ArrayList<Ordem>();
	
	public void receberPedido(Ordem ordem) {
		ordemList.add(ordem);
	}
	
	public void fazerPedidos() {
		for (Ordem o : ordemList) {
			o.executar();
		}
		
		ordemList.clear();
	}

}
```

💡

---

### **Código**

```java
public class Gerenciador {

    private List<Ordem> ordemList = new ArrayList<Ordem>();

    public void receberPedido(Ordem ordem) {
        ordemList.add(ordem);
    }

    public void fazerPedidos() {
        for (Ordem o : ordemList) {
            o.executar();
        }
        ordemList.clear();
    }
}

```

---

### **1️⃣ Atributo `ordemList`**

```java
private List<Ordem> ordemList = new ArrayList<Ordem>();

```

- Armazena **uma lista de comandos** (`Ordem` é a interface do comando).
- Cada objeto que implementa `Ordem` (como `VenderEstoque`) pode ser adicionado a essa lista.
- É aqui que o **Gerenciador guarda os pedidos antes de executá-los**.

---

### **2️⃣ Método `receberPedido`**

```java
public void receberPedido(Ordem ordem) {
    ordemList.add(ordem);
}

```

- Recebe um **comando** (`Ordem`) do cliente.
- Adiciona o comando à lista para execução futura.
- **Não executa ainda**, apenas guarda.

---

### **3️⃣ Método `fazerPedidos`**

```java
public void fazerPedidos() {
    for (Ordem o : ordemList) {
        o.executar();
    }
    ordemList.clear();
}

```

- Percorre toda a lista de comandos e chama `executar()` em cada um.
- **Aqui o comando realmente dispara a ação** no Receiver (por exemplo, `Estoque`).
- Depois de executar todos, limpa a lista (`ordemList.clear()`), preparando o Gerenciador para novos pedidos.

---

### **Resumo do papel da classe**

| Item | Função |
| --- | --- |
| `Gerenciador` | Funciona como **Broker / Invoker** do padrão Command. |
| `ordemList` | Armazena todos os comandos que foram recebidos. |
| `receberPedido` | Adiciona um comando à lista (pedido). |
| `fazerPedidos` | Executa todos os comandos da lista e limpa a lista. |
| Relação com Command | Não sabe detalhes da execução, apenas chama `executar()` dos comandos. |

---

💡 **Analogia prática:**

- Imagine um restaurante:
    - O **Gerenciador** é o **garçom** que recebe os pedidos e os envia à cozinha.
    - Os **comandos** são os **pedidos** (vender, comprar).
    - O **Receiver (Estoque)** é a **cozinha** que realmente prepara a comida.

---


### LINHA A LINHA DO CÓDIGO DA CLASSE MAIN

💡

---

### **Código**

```java
public class CommandPatternDemo {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        CompreEstoque compreEstoque = new CompreEstoque(estoque);
        VenderEstoque venderEstoque = new VenderEstoque(estoque);

        Gerenciador gerenciador = new Gerenciador();

        gerenciador.receberPedido(compreEstoque);
        gerenciador.receberPedido(venderEstoque);

        gerenciador.fazerPedidos();

    }

}

```

---

### **1️⃣ `Estoque estoque = new Estoque();`**

- **O que acontece:**
    - Cria uma instância da classe `Estoque` (Receiver).
    - O `Estoque` é quem **realiza o trabalho real**, como `comprar()` ou `vender()`.
- **Por debaixo dos panos:**
    - O objeto `estoque` aloca memória no heap.
    - Ele tem métodos como `comprar()` e `vender()` que serão chamados pelos comandos concretos.

---

### **2️⃣ Criação dos comandos**

```java
CompreEstoque compreEstoque = new CompreEstoque(estoque);
VenderEstoque venderEstoque = new VenderEstoque(estoque);

```

- **O que acontece:**
    - Cria dois comandos concretos que implementam a interface `Ordem`.
    - Cada comando recebe **uma referência ao `Estoque`** via construtor.
    - `CompreEstoque.executar()` vai chamar `estoque.comprar()`.
    - `VenderEstoque.executar()` vai chamar `estoque.vender()`.
- **Por debaixo dos panos:**
    - O construtor apenas **guarda a referência do estoque** dentro do comando.
    - Nenhuma ação de compra ou venda ocorre ainda; os métodos só serão chamados quando `executar()` for invocado.

---

### **3️⃣ Criação do Gerenciador**

```java
Gerenciador gerenciador = new Gerenciador();

```

- **O que acontece:**
    - Instancia o Broker / Invoker do padrão Command.
    - O `gerenciador` tem uma lista interna (`ordemList`) para armazenar pedidos (comandos).
- **Por debaixo dos panos:**
    - Um `ArrayList` é criado para armazenar referências de `Ordem`.
    - Ainda não há comandos na lista.

---

### **4️⃣ Recebendo os pedidos**

```java
gerenciador.receberPedido(compreEstoque);
gerenciador.receberPedido(venderEstoque);

```

- **O que acontece:**
    - O Gerenciador adiciona os comandos na lista interna.
    - Agora `ordemList` contém dois elementos: `compreEstoque` e `venderEstoque`.
- **Por debaixo dos panos:**
    - O `ArrayList` armazena referências para os objetos de comando, não cópias deles.
    - Nenhum método `executar()` ainda é chamado; os objetos só ficam “guardados” aguardando execução.

---

### **5️⃣ Executando os pedidos**

```java
gerenciador.fazerPedidos();

```

- **O que acontece:**
    1. O Gerenciador percorre a lista `ordemList`.
    2. Para cada comando (`Ordem o`), chama `o.executar()`.
- **Passo a passo:**
    
    **a) Primeiro comando: `compreEstoque`**
    
    - `executar()` do `CompreEstoque` é chamado.
    - Ele faz: `estoque.comprar()`.
    - `Estoque` executa o método real de compra e imprime algo (ou realiza lógica interna).
    
    **b) Segundo comando: `venderEstoque`**
    
    - `executar()` do `VenderEstoque` é chamado.
    - Ele faz: `estoque.vender()`.
    - `Estoque` realiza a venda.
- **Depois:**
    - `ordemList.clear()` limpa a lista de comandos, liberando referências para que possam ser coletadas pelo Garbage Collector.

---

### **6️⃣ Resumo visual do fluxo**

```
Main
  |
  | cria Estoque (Receiver)
  |
  | cria Comandos (CompreEstoque, VenderEstoque) -> guardam referência ao Estoque
  |
  | cria Gerenciador (Invoker)
  |
  | gerenciador.receberPedido(comandos) -> lista interna armazena referências
  |
  | gerenciador.fazerPedidos() -> para cada comando: executar()
        |
        |-> Comando chama Estoque.metodo()
                |
                |-> Estoque realiza a ação real (comprar ou vender)

```

---

### **7️⃣ Conceito principal**

- **CommandPatternDemo** é o **cliente** que configura o padrão.
- **Gerenciador** não sabe nem se é compra ou venda, só chama `executar()`.
- **Comando concreto** sabe **qual ação realizar** no Receiver.
- **Estoque (Receiver)** faz o trabalho real.

---


💡

### É NECESSÁRIO PASSAR ESTOQUE NO ARGUMENTO?

A sua afirmação **está correta**, mas vamos destrinchar o **porquê** e o que acontece por trás disso.

---

### **1️⃣ Por que é preciso passar o `Estoque` no construtor?**

No seu código, os comandos (`CompreEstoque` e `VenderEstoque`) são definidos assim:

```java
public class CompreEstoque implements Ordem {
    private Estoque abcEstoque;

    public CompreEstoque(Estoque abcEstoque) {
        this.abcEstoque = abcEstoque;
    }

    @Override
    public void executar() {
        abcEstoque.comprar();
    }
}

```

E de forma semelhante:

```java
public class VenderEstoque implements Ordem {
    private Estoque abcEstoque;

    public VenderEstoque(Estoque abcEstoque) {
        this.abcEstoque = abcEstoque;
    }

    @Override
    public void executar() {
        abcEstoque.vender();
    }
}

```

Observe o **construtor**: ele **exige** um objeto `Estoque` como argumento.

Se você **não passar** esse objeto na hora da instanciação, o código nem compila.

---

### **2️⃣ O que aconteceria se não passasse?**

- Se você tentasse fazer:

```java
CompreEstoque compreEstoque = new CompreEstoque(); // ERRO!

```

O compilador reclamaria:

> The constructor CompreEstoque() is undefined
> 

Porque **não existe um construtor vazio (default)**. Você só declarou um construtor que recebe `Estoque`.

---

### **3️⃣ Por que isso é feito?**

Porque no padrão Command, cada comando precisa saber **qual Receiver** (no caso, `Estoque`) ele vai acionar quando `executar()` for chamado.

- O comando **não cria** o Receiver.
- O comando **guarda a referência** para usá-la depois.

---

### **4️⃣ Então a sua frase está certa?**

Sim! Está correto dizer:

> "Sim, é obrigatório passar o Estoque como parâmetro na instanciação porque o construtor da classe CompreEstoque (e VenderEstoque) exige isso".
> 

Se o construtor fosse assim:

```java
public CompreEstoque() {}

```

Aí você poderia instanciar sem parâmetro, mas o comando **não teria a quem delegar a ação**, e `executar()` não funcionaria corretamente.

---

### **5️⃣ Resumo**

- **Sim, é obrigatório** neste caso, porque o **construtor foi definido assim**.
- É o cliente (`CommandPatternDemo`) quem **instancia o Receiver** e o **passa para os comandos**.
- O comando **não é responsável por criar o Estoque**.

---

