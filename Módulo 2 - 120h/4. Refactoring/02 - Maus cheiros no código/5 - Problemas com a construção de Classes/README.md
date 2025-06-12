# 5 → PROBLEMAS COM A CONSTRUÇÃO DE CLASSES


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/problemasConstrucaoClasses1.png" />

---


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/problemasConstrucaoClasses2.png" />

---


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/problemasConstrucaoClasses3.png" />

> Quando vamos criar uma subclasse nós precisamos perceber se todos os atributos da classe pai, realmente vão fazer sentido na subclasse também, nós devemos rever essas estruturas para evitar de termos situações como essa, precisamos organizar a classe de forma adequada, unificar as funcionalidades para que a classe elas possam ser relevantes.
> 

---

## MÃO NA MASSA

### VAMOS IMAGINAR QUE A GENTE POSSA FAZER A GERAÇÃO DE RELATÓRIOS

🏆 Se por ventura a gente tiver um campo que for mais usado em outra classe do que na própria classe, já é um problema que podemos corrigir e manipular.


🏆 A geração do relatório do arquivo CSV a gente fez de forma separada, nós dividimos as informações.


🏆 Quando conseguimos dividir a estrutura, isso facilita a manutenção e futuras alterações que possam ser realizadas no nosso código.


### CLASSE MAIN

```java
package refatoracao.estudos.maus.cheiros.no.codigo.problemas.construcao.classes;

public class GenerateReportMain {

	public static void main(String[] args) {
		ReportingService rs = new ReportingService();
		
		// GERAR RELATÓRIO CSV
		ReportingStrategy csvReportingStrategy = new CSVReportingStrategy();
		rs.generateReportBasedOnStrategy(csvReportingStrategy);
		
		// GERAR RELATÓRIO XML 
		ReportingStrategy xmlReportingStrategy = new XMLReportingStrategy();
		rs.generateReportBasedOnStrategy(xmlReportingStrategy);
	}

}
```

### VAMOS IMAGINAR AGORA QUE O CLIENTE PEDIU PARA CRIAR UMA INCLUSÃO DE UMA NOVA FUNCIONALIDADE(EXEMPLO: RELATÓRIO EM FORMATO PDF)

> Como nós dividimos o processo, será de certa forma mais fácil realizar a criação dessa estrutura e o código ficará mais estruturado.
> 

> Quando nós dividimos o projeto em responsabilidades diferentes, quando necessário inserir demandas, nós conseguimos implementar de uma forma simples e objetiva.
> 

---

### DÚVIDA IMPORTANTE DURANTE A AULA (POLIMORFISMO)



---

### ✅ O que acontece nesse trecho: 🏆

```java
ReportingStrategy csvReportingStrategy = new CSVReportingStrategy();
ReportingStrategy xmlReportingStrategy = new XMLReportingStrategy();

```

- `ReportingStrategy` é **uma interface** (ou uma classe abstrata).
- `CSVReportingStrategy` e `XMLReportingStrategy` são **implementações concretas** dessa interface.
- Você está criando objetos de classes concretas (`CSVReportingStrategy`, `XMLReportingStrategy`) mas armazenando nas variáveis do tipo da interface (`ReportingStrategy`).

---

### 🤔 Por que fazer isso?

Porque isso permite que o código trabalhe de forma **genérica**, sem saber exatamente **qual é a implementação concreta**.

**Vantagens:**

- **Flexibilidade:** você pode trocar a estratégia sem mudar o restante do código.
- **Extensibilidade:** novas estratégias podem ser adicionadas sem modificar a lógica principal.
- **Manutenção:** código mais limpo e desacoplado.

---

### 🧠 Analogia rápida

Pense em um **controle remoto (`ReportingStrategy`)** que pode controlar **vários tipos de TV** (Samsung, LG, etc — `CSVReportingStrategy`, `XMLReportingStrategy`).

O controle remoto (tipo da variável) é sempre o mesmo, mas o comportamento muda dependendo da TV (classe concreta).

---

### 🧪 Exemplo genérico:

```java
interface Animal {
    void emitirSom();
}

class Cachorro implements Animal {
    public void emitirSom() {
        System.out.println("Au au");
    }
}

class Gato implements Animal {
    public void emitirSom() {
        System.out.println("Miau");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cachorro();  // Tipo: Animal, objeto: Cachorro
        Animal animal2 = new Gato();      // Tipo: Animal, objeto: Gato

        animal1.emitirSom(); // Au au
        animal2.emitirSom(); // Miau
    }
}

```

Mesmo sendo do tipo `Animal`, cada objeto se comporta de forma diferente — isso é **polimorfismo**.




### OUTRA EXPLICAÇÃO 🏆

---

## 🔁 O Código em Foco

```java
ReportingStrategy csvReportingStrategy = new CSVReportingStrategy();
rs.generateReportBasedOnStrategy(csvReportingStrategy);

ReportingStrategy xmlReportingStrategy = new XMLReportingStrategy();
rs.generateReportBasedOnStrategy(xmlReportingStrategy);

```

---

## 📌 O que está acontecendo aqui

Você está **declarando uma variável** do tipo `ReportingStrategy`, mas **instanciando um objeto** de uma **subclasse concreta**, como `CSVReportingStrategy` ou `XMLReportingStrategy`.

Isso se baseia em **princípios centrais da Programação Orientada a Objetos (POO)**:

### 1. **Abstração**

Você cria uma **interface genérica** (`ReportingStrategy`) que define o **comportamento comum** que várias classes concretas devem seguir.

### 2. **Polimorfismo**

Você pode **usar uma interface como tipo da variável** e mudar a implementação real dinamicamente. O método chamado será sempre o da **classe concreta**, mesmo que o tipo da variável seja da interface.

### 3. **Desacoplamento (baixo acoplamento)**

Seu código (`generateReportBasedOnStrategy`) **não precisa saber** se o relatório é CSV, XML, JSON, etc. Ele só exige um **objeto que siga o contrato da interface `ReportingStrategy`**.

---

## 🔍 Vamos por partes

### 📦 A Interface

```java
public interface ReportingStrategy {
    void generateReport(Data data);
}

```

Ela define o **contrato**: qualquer classe que implemente `ReportingStrategy` precisa fornecer uma implementação para `generateReport`.

---

### 🏗️ As Implementações

```java
public class CSVReportingStrategy implements ReportingStrategy {
    public void generateReport(Data data) {
        // Gera relatório CSV
    }
}

public class XMLReportingStrategy implements ReportingStrategy {
    public void generateReport(Data data) {
        // Gera relatório XML
    }
}

```

Ambas as classes **implementam o mesmo método**, mas com comportamentos diferentes.

---

### ⚙️ O Método que Usa a Estratégia

```java
public class ReportService {
    public void generateReportBasedOnStrategy(ReportingStrategy strategy) {
        // dados fictícios para exemplo
        Data d = new Data();
        strategy.generateReport(d); // chama a implementação específica
    }
}

```

Aqui o método aceita **qualquer objeto** que implemente `ReportingStrategy`, sem se importar com qual exatamente.

---

### 🧠 Por que o tipo da variável é `ReportingStrategy`?

Essa prática tem nome: **programar para a interface, não para a implementação**.

Significa que você escreve seu código usando **tipos mais genéricos e abstratos**, e só define as **implementações concretas** quando for realmente necessário. Isso torna o sistema mais flexível e expansível.

---

## ✅ Benefícios diretos disso

| Vantagem | Descrição |
| --- | --- |
| **Flexibilidade** | Troca fácil de estratégia sem mudar o código do consumidor |
| **Reutilização** | O mesmo método pode usar várias implementações |
| **Testabilidade** | Fácil substituir a estratégia por uma versão mock para testes |
| **Expansibilidade** | Adicionar novas estratégias não quebra o código existente |
| **Princípios SOLID** | Isso respeita o **O** de **Open/Closed Principle**: "Aberto para extensão, fechado para modificação" |

---

## 🎯 Resumo final

Você usa o **tipo da interface** (`ReportingStrategy`) para permitir que o objeto instanciado (`CSVReportingStrategy` ou `XMLReportingStrategy`) possa ser trocado **sem afetar o restante do sistema**.

É uma aplicação prática de **polimorfismo + design orientado a interfaces** — exatamente o que dá poder e organização à programação orientada a objetos.


### O QUE É UMA CLASSE CONCRETA EM JAVA?

🏆 Uma **classe concreta** em Java (e em programação orientada a objetos em geral) é uma **classe que pode ser instanciada diretamente**, ou seja, você pode criar objetos a partir dela usando o operador `new`.

---

### ✅ Características de uma classe concreta:

- **Possui implementação completa** de todos os seus métodos.
- **Não é abstrata** (não usa a palavra-chave `abstract`).
- Pode **herdar de outras classes** ou **implementar interfaces**.
- Pode ser usada diretamente no seu código com `new`.

---

### 🧱 Exemplo de classe concreta

```java
public class Cachorro {
    public void latir() {
        System.out.println("Au au!");
    }
}

```

Você pode instanciar essa classe diretamente:

```java
Cachorro dog = new Cachorro();
dog.latir(); // imprime "Au au!"

```

---

### ❌ Classe **não concreta** (abstrata)

Já uma **classe abstrata** **não pode ser instanciada diretamente**, pois contém métodos **sem implementação** (ou está marcada como abstrata).

```java
public abstract class Animal {
    public abstract void emitirSom();
}

```

Tentativa de instanciar diretamente:

```java
Animal a = new Animal(); // ❌ Erro: classe abstrata não pode ser instanciada

```

Para usar, você precisa criar uma **classe concreta que a estende**:

```java
public class Gato extends Animal {
    public void emitirSom() {
        System.out.println("Miau");
    }
}

Animal gato = new Gato(); // agora sim!
gato.emitirSom(); // Miau

```

---

### 📌 Conclusão

> Uma classe concreta é uma classe completa e utilizável — ela pode ser instanciada diretamente e possui todos os métodos implementados.
> 

Ela é o oposto de uma interface ou classe abstrata, que serve como modelo ou contrato, mas não pode ser usada sozinha.

