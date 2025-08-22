# 1 → ADAPTER/WRAPPER

## Resumo (bem curto)

O **Adapter (ou Wrapper)** é um **padrão estrutural** que **converte a interface de uma classe existente (Adaptee)** para **a interface esperada pelo cliente (Target)** — assim, **classes incompatíveis passam a trabalhar juntas sem alterar o código original**.

---

## Exemplo em Java (com explicação linha por linha)

### 1) Interface alvo (Target) — o que o cliente espera usar

```java
// A interface que o cliente conhece e sabe usar (P2).
public interface AudioP2 {                 // Declara a interface "alvo" (Target).
    void reproduzirSom();                  // Contrato esperado: método para tocar som.
}

```

### 2) Classe existente (Adaptee) — interface incompatível

```java
// Uma classe já existente, com outra interface (HDMI), que não queremos/nao podemos mudar.
public class AudioHDMI {                    // "Adaptee": a classe com interface diferente.
    public void reproduzirAudioDigital() {  // Método com nome/assinatura diferentes.
        System.out.println("Reproduzindo áudio via HDMI");
    }
}

```

### 3) Adapter (Wrapper) — faz a ponte entre Target e Adaptee

```java
// Adapter que converte HDMI -> P2, permitindo usar AudioHDMI onde se espera AudioP2.
public class HDMIToP2Adapter implements AudioP2 { // O adapter IMPLEMENTA a interface alvo.
    private final AudioHDMI audioHDMI;            // Mantém uma referência ao Adaptee.

    // Construtor recebe a dependência. (Injeção de dependência)
    public HDMIToP2Adapter(AudioHDMI audioHDMI) { // Recebe o objeto incompatível.
        if (audioHDMI == null) {                  // (Boa prática) validação defensiva.
            throw new IllegalArgumentException("audioHDMI não pode ser nulo");
        }
        this.audioHDMI = audioHDMI;               // Armazena para uso interno.
    }

    @Override                                     // Estamos sobrescrevendo o contrato Target.
    public void reproduzirSom() {                 // Método que o cliente espera chamar.
        // A "adaptação" acontece aqui: convertemos a chamada Target -> Adaptee.
        audioHDMI.reproduzirAudioDigital();       // Delegamos para o método equivalente do HDMI.
    }
}

```

### 4) Cliente — usa apenas a interface Target (sem saber que há HDMI por trás)

```java
public class Main {                               // Classe de entrada do programa.
    public static void main(String[] args) {      // Ponto de execução.
        AudioHDMI hdmi = new AudioHDMI();         // Criamos o Adaptee (interface diferente).
        AudioP2 entradaP2 = new HDMIToP2Adapter(hdmi); // Envolvemos com o Adapter (vira Target).

        entradaP2.reproduzirSom();                // Cliente usa a interface Target normalmente.
        // Saída: "Reproduzindo áudio via HDMI"
    }
}

```

### O que aconteceu?

- O **cliente** só conhece `AudioP2` (Target).
- O **adapter** (`HDMIToP2Adapter`) implementa `AudioP2` e, por baixo dos panos, **redireciona** a chamada para `AudioHDMI.reproduzirAudioDigital()`.
- Assim, **reutilizamos** `AudioHDMI` **sem alterar** seu código e **sem mudar o cliente**.

---

## ADAPTER DEFINIÇÕES

🏆 Adapter é um padrão de projeto estrutural que permite que objetos com interfaces incompatíveis colaborem.

> Uma ótima analogia é: ele é como se fosse um adaptador, de tomada por exemplo, onde é possível adaptar uma tomada de 3 pinos para 2.
> 

🏆 Um adaptador envolve um dos objetos para ocultar a complexidade que ocorre nos bastidores.

🏆 Por exemplo, você pode agrupar um objeto que opera em metros e quilômetros com um adaptador que converte todos os dados em unidades imperiais, como pés e milhas.



---

## O QUE É UM WRAPPER?

🏆

---

## **O que é um Wrapper (resumo curto)**

Um **Wrapper** é uma classe que **"embrulha" outra classe** para **adicionar funcionalidades extras, monitorar ou restringir seu uso**, **sem alterar a classe original** e normalmente **mantendo a mesma interface ou bem próxima**.

---

## **Exemplo: Wrapper para um Serviço de Pagamento**

Imagine que já existe uma classe que processa pagamentos, mas você quer **monitorar quantos pagamentos foram feitos** sem modificar a classe original.

---

### **1) Classe Original (não podemos mudar)**

```java
// Classe original fornecida por outra biblioteca/sistema
public class PagamentoService {
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado!");
    }
}

```

---

### **2) Wrapper**

```java
// Wrapper que adiciona uma funcionalidade: contar quantos pagamentos foram feitos
public class PagamentoServiceWrapper {
    private final PagamentoService pagamentoService; // Objeto real que será envolvido
    private int contadorPagamentos = 0;              // Funcionalidade extra

    public PagamentoServiceWrapper(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;    // Recebe a instância original
    }

    public void processarPagamento(double valor) {   // Mantém o mesmo método
        contadorPagamentos++;                        // Adiciona comportamento extra
        pagamentoService.processarPagamento(valor);  // Chama a lógica original
    }

    public int getContadorPagamentos() {             // Método novo do wrapper
        return contadorPagamentos;
    }
}

```

---

### **3) Cliente (uso do Wrapper)**

```java
public class Main {
    public static void main(String[] args) {
        PagamentoService pagamentoOriginal = new PagamentoService();           // Classe original
        PagamentoServiceWrapper pagamentoWrapper = new PagamentoServiceWrapper(pagamentoOriginal); // Wrapper

        pagamentoWrapper.processarPagamento(100.0);
        pagamentoWrapper.processarPagamento(250.5);

        System.out.println("Pagamentos realizados: " + pagamentoWrapper.getContadorPagamentos());
        // Saída:
        // Pagamento de R$100.0 processado!
        // Pagamento de R$250.5 processado!
        // Pagamentos realizados: 2
    }
}

```

---

### **Por que isso é um Wrapper?**

- **Não muda a interface original**: o método `processarPagamento(double)` continua igual.
- **Adiciona um comportamento extra** (contador) sem mexer no código original.
- **Envolve a classe original** — o cliente pode usar o wrapper como se fosse a própria classe de pagamento.

---


💡

### DÚVIDA SOBRE O MESMO NOME DE MÉTODO

Não, **não é obrigatório** ter o método com o **mesmo nome** da outra classe.

O que acontece é que, **na maioria dos casos de Wrapper**, usamos o **mesmo nome e assinatura** por dois motivos principais:

1. **Manter compatibilidade com quem já usa a classe original** – para que o cliente continue chamando os mesmos métodos sem precisar aprender nada novo.
2. **Facilitar a delegação** – se a intenção é apenas adicionar comportamento extra, manter a mesma assinatura torna o Wrapper “transparente”.

---

### Exemplo sem usar o mesmo nome

Podemos criar um método diferente, e ainda assim será um **Wrapper**, desde que ele use a classe original internamente:

```java
public class PagamentoServiceWrapper {
    private final PagamentoService pagamentoService;
    private int contadorPagamentos = 0;

    public PagamentoServiceWrapper(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    // Método com nome diferente
    public void pagar(double valor) {
        contadorPagamentos++;
        pagamentoService.processarPagamento(valor); // Continua usando o método original
    }

    public int getContadorPagamentos() {
        return contadorPagamentos;
    }
}

```

Uso:

```java
public class Main {
    public static void main(String[] args) {
        PagamentoService original = new PagamentoService();
        PagamentoServiceWrapper wrapper = new PagamentoServiceWrapper(original);

        wrapper.pagar(100.0); // Nome diferente do método original
        wrapper.pagar(50.0);

        System.out.println("Pagamentos feitos: " + wrapper.getContadorPagamentos());
    }
}

```

---

### Conclusão

- **Não é obrigatório** usar o mesmo nome — mas **é comum** para transparência e compatibilidade.
- Se você mudar o nome, o wrapper **continua sendo um wrapper**, desde que ele apenas **encapsule e delegue** ao objeto original (com ou sem comportamentos extras).

---


## WRAPPER

🏆 Uma classe Wrapper “embrulha” um objeto de outra classe. Ele é usado para implementar um padrão de projeto que possui uma instância de um objeto e apresenta sua própria interface ou comportamento para esse objeto, sem alterar a classe original.

> Ao invés de acessarmos a classe primária, a gente acessa a classe wrapper, que é a classe preparada a necessidade especifica.
> 

🏆 A ideia básica de um wrapper é encaminhar a chamada para um objeto subjacente, ao mesmo tempo em que permite que o novo código seja exectuado antes e/ou logo após a chamada.

🟢

**Subjacente** significa algo que está **por baixo, por trás ou servindo de base** para outra coisa, mesmo que não esteja visível diretamente.

Exemplo simples:

- Se você usa um **wrapper**, o objeto **subjacente** é a **classe original que ele envolve**.
- Se você está vendo uma imagem na tela, os **pixels subjacentes** são os elementos básicos que formam a imagem.


---

### EXPLICAÇÃO LINHA POR LINHA DO MÉTODO `fazerAjuste()`

---

```java
public void fazerAjuste(BuracoRedondo buracoRedondo) {

```

- **Declaração do método público** chamado `fazerAjuste`.
- Recebe como parâmetro um objeto do tipo `BuracoRedondo`.
- Provavelmente a classe que contém esse método tem um **objeto `quadrado`** como campo (atributo).

---

```java
double quantia = quadrado.getLargura() - buracoRedondo.getRaio() * Math.sqrt(2);

```

- Calcula quanto o quadrado precisa ser **reduzido para caber no buraco redondo**.
- `quadrado.getLargura()` → obtém a largura atual do quadrado.
- `buracoRedondo.getRaio()` → obtém o raio do buraco redondo.
- `Math.sqrt(2)` → raiz quadrada de 2 (~1.414), usada aqui porque a **diagonal de um quadrado** é `lado * √2`.
- Subtraindo `buracoRedondo.getRaio() * √2` da largura, obtemos **a quantidade que o quadrado precisa reduzir** para que a diagonal caiba no buraco.

---

```java
System.out.println(" Reduzindo quadrado:  " + quadrado.getLargura() + " por " + ((quantia < 0) ? 0 : quantia ) + " quantia ");

```

- Exibe no console informações de depuração:
    - A largura atual do quadrado (`quadrado.getLargura()`).
    - A **quantidade de redução**, que será `0` se `quantia` for negativa (ou seja, não precisa reduzir).
- `((quantia < 0) ? 0 : quantia)` → operador ternário: se `quantia < 0`, usa 0; caso contrário, usa `quantia`.

---

```java
if (quantia > 0) {

```

- Verifica se realmente é necessário reduzir o quadrado.
- Se `quantia <= 0`, o quadrado já cabe no buraco e nada é feito.

---

```java
quadrado.setLargura(quadrado.getLargura() - quantia);

```

- Reduz a largura do quadrado pelo valor calculado em `quantia`.
- Modifica o objeto `quadrado` **diretamente**.

---

```java
System.out.println(" A nova largura é: " + quadrado.getLargura());

```

- Exibe no console a nova largura do quadrado depois do ajuste.

---

### **Resumo geral**

O método `fazerAjuste`:

1. Calcula quanto o quadrado precisa ser **reduzido para caber dentro de um buraco redondo** (considerando a diagonal do quadrado).
2. Mostra no console informações sobre a redução.
3. Se necessário, **reduz a largura do quadrado** e imprime a nova largura.

---

Se quiser, posso fazer um **desenho ou diagrama explicando visualmente** como o quadrado é ajustado para caber no buraco redondo — isso ajuda muito a entender o cálculo com `√2`.

---

### CÓDIGO UTILIZANDO O EXEMPLO DE UM CARRO PARA FACILITAR O MEU ENTENDIMENTO

🏆

---

## **1) Classe do objeto principal (equivalente a Quadrado)**

```java
public class Carro {
    private double largura;

    public Carro(double largura) {
        this.largura = largura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }
}

```

---

## **2) Classe do “alvo” ou restrição (equivalente a BuracoRedondo)**

```java
public class Garagem {
    private int larguraVaga;

    public Garagem(int larguraVaga) {
        this.larguraVaga = larguraVaga;
        System.out.println("Garagem: Largura máxima do carro que cabe é " + larguraVaga * Math.sqrt(2));
    }

    public int getLarguraVaga() {
        return larguraVaga;
    }
}

```

---

## **3) Adapter (equivalente a QuadradoAdapter)**

```java
public class CarroAdapter {

    private Carro carro;

    public CarroAdapter(double larguraCarro) {
        this.carro = new Carro(larguraCarro);
    }

    // Método que ajusta o carro para caber na garagem
    public void fazerAjuste(Garagem garagem) {
        double quantia = carro.getLargura() - garagem.getLarguraVaga() * Math.sqrt(2);
        System.out.println("Reduzindo carro: " + carro.getLargura() + " por " + ((quantia < 0) ? 0 : quantia));

        if (quantia > 0) {
            carro.setLargura(carro.getLargura() - quantia);
            System.out.println("Nova largura do carro: " + carro.getLargura());
        }
    }
}

```

---

## **4) Demo (equivalente a AdapterDemoQuadrado)**

```java
public class AdapterDemoCarro {
    public static void main(String[] args) {

        Garagem garagem = new Garagem(5); // Largura máxima da vaga

        CarroAdapter carroAdapter;

        for (int i = 6; i < 10; i++) {  // Carros com largura de 6 a 9
            carroAdapter = new CarroAdapter((double) i);
            carroAdapter.fazerAjuste(garagem);  // Cliente usa a interface adaptada
        }
    }
}

```

---

### ✅ **O que foi feito**

- **Carro** = Quadrado
- **Garagem** = BuracoRedondo
- **CarroAdapter** = QuadradoAdapter
- **AdapterDemoCarro** = AdapterDemoQuadrado

O cliente **não precisa saber da lógica de ajuste**, só chama `fazerAjuste()`, exatamente como no seu exemplo original de quadrado.

---


---

🏆

### IDEIA DE ESTUDO PARA FIXAR

🏆 CRIAR PROJETO NO QUAL CADA FUNCIONARIO DE UM CARGO ESPECIFICO TENHA UM PRIVILÉGIO DIFERENCIADO


