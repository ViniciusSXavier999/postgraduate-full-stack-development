# 5 → SIMPLE FACTORY

### **Simple Factory (Fábrica Simples)**

- **O que é:**
    - Um **padrão de criação** que centraliza a lógica de criação de objetos em **uma única classe/fábrica**.
    - A fábrica decide **qual classe concreta instanciar** com base em parâmetros fornecidos pelo cliente.
- **Objetivo:**
    - Evitar que o código cliente use `new` diretamente para criar objetos.
    - Facilitar manutenção e extensão do código.
- **Como funciona:**
    - O cliente chama um **método da fábrica**, passando algum critério (ex.: tipo de objeto).
    - A fábrica retorna **uma instância do objeto correto**.
- **Exemplo resumido em palavras:**
    - Um método `getAnimal("cachorro")` retorna um objeto `Cachorro`.
    - `getAnimal("gato")` retorna um objeto `Gato`.
    - O cliente só interage com a fábrica, sem se preocupar com as classes concretas.
- **Diferença para Factory Method:**
    - **Simple Factory:** não é um padrão formal do GoF, é mais um **atalho simples**.
    - **Factory Method:** cada subclasse decide **como criar o objeto**, é mais flexível.

### EXEMPLO COM CÓDIGO SIMPLES

---

### Exemplo: Fábrica de Animais

```java
// Interface comum para todos os animais
interface Animal {
    void fazerSom();
}

// Classes concretas
class Cachorro implements Animal {
    public void fazerSom() {
        System.out.println("Au Au!");
    }
}

class Gato implements Animal {
    public void fazerSom() {
        System.out.println("Miau!");
    }
}

// Simple Factory
class AnimalFactory {
    public static Animal criarAnimal(String tipo) {
        if(tipo.equalsIgnoreCase("cachorro")) {
            return new Cachorro();
        } else if(tipo.equalsIgnoreCase("gato")) {
            return new Gato();
        } else {
            return null; // ou lançar exceção
        }
    }
}

// Uso no código cliente
public class Main {
    public static void main(String[] args) {
        Animal a1 = AnimalFactory.criarAnimal("cachorro");
        a1.fazerSom(); // Saída: Au Au!

        Animal a2 = AnimalFactory.criarAnimal("gato");
        a2.fazerSom(); // Saída: Miau!
    }
}

```

---

### **Explicando linha por linha**

1. **Interface Animal:** define um método comum `fazerSom()` para todos os animais.
2. **Classes Cachorro e Gato:** implementam a interface `Animal` e fornecem comportamento próprio.
3. **AnimalFactory:**
    - Método `criarAnimal(String tipo)` decide **qual objeto instanciar**.
    - Centraliza toda a lógica de criação.
4. **Cliente (Main):**
    - Pede um animal para a fábrica.
    - Não precisa saber **qual classe concreta** está sendo criada.

---

💡 **Resumo:**

- O cliente **não usa `new` diretamente**.
- Todas as instâncias passam pela **fábrica**, facilitando manutenção e extensão do código.

---

## SIMPLE FACTORY

🏆 O padrão simple factory permite interfaces para criar objetos sem expor a lógica de criação do objeto para o cliente.

> Em POO uma fábrica é um objeto para criar outros objetos
> 

> Uma fábrica é uma função ou método que retorna objetos.
> 

🏆 O padrão simple factory descreve uma classe que possui um método de criação como uma grande condicional que, com base nos parâmetros do método, escolhe qual classe de produto instanciar e retornar.


🏆 O padrão simple factory geralmente é representado por um único método em uma única classe. Com o tempo, esse método pode se tornar muito grande, então você pode decidir extrair partes do método para subclasses.

---

### **Exemplo inicial (método grande)**

```java
class AnimalFactory {
    public static Animal criarAnimal(String tipo) {
        if(tipo.equalsIgnoreCase("cachorro")) {
            return new Cachorro();
        } else if(tipo.equalsIgnoreCase("gato")) {
            return new Gato();
        } else if(tipo.equalsIgnoreCase("passaro")) {
            return new Passaro();
        } else {
            return null;
        }
    }
}

```

- Aqui, **um único método** decide todos os tipos de animais.
- Se você precisar adicionar 10 ou 20 tipos, o método vai ficar **grande e difícil de manter**.

---

### **Refatorando com subclasses (divide responsabilidade)**

```java
abstract class AnimalFactoryBase {
    abstract Animal criarAnimal();
}

class CachorroFactory extends AnimalFactoryBase {
    public Animal criarAnimal() { return new Cachorro(); }
}

class GatoFactory extends AnimalFactoryBase {
    public Animal criarAnimal() { return new Gato(); }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        AnimalFactoryBase factory = new CachorroFactory();
        Animal a1 = factory.criarAnimal();
        a1.fazerSom(); // Saída: Au Au!

        factory = new GatoFactory();
        Animal a2 = factory.criarAnimal();
        a2.fazerSom(); // Saída: Miau!
    }
}

```

- Agora cada **subclasse da fábrica** cria apenas um tipo de objeto.
- O método grande foi dividido, facilitando manutenção e extensão.

---

💡 **Resumo:**

- Simple Factory começa com **um método centralizado**.
- Quando cresce demais, você **divide em subclasses**, cada uma responsável por criar um tipo específico de objeto.

---

### DÚVIDA SOBRE O CÓDIGO

por que eu estou conseguindo passar esses parâmetros se minha interface não tem parâmetros ? 	

```java
public static Roda fazerRoda(float diametro, float largura) {
return new RodaDoCarro(diametro, largura);
}
```

🏆

---

No seu exemplo:

```java
public static Roda fazerRoda(float diametro, float largura) {
    return new RodaDoCarro(diametro, largura);
}

```

- `Roda` é provavelmente uma **interface**.
- `RodaDoCarro` é a **classe concreta** que implementa `Roda`.
- Você **está criando uma instância concreta** (`new RodaDoCarro(diametro, largura)`) e **retornando-a como referência do tipo da interface** (`Roda`).

---

### Por que isso funciona mesmo que a interface não tenha parâmetros

1. **Interfaces não têm construtores**, então você **não chama o construtor da interface**.
2. Você está chamando o **construtor da classe concreta** (`RodaDoCarro`) que aceita os parâmetros `diametro` e `largura`.
3. O retorno do método é do tipo `Roda` (a interface), **mas o objeto em si é da classe concreta**, que sabe lidar com os parâmetros.

---

💡 **Resumo curto:**

- Interfaces definem **o que o objeto faz**, não **como é criado**.
- Construtores sempre pertencem a classes concretas.
- Você pode passar parâmetros para criar o objeto concreto, e retornar uma referência do tipo da interface.

### ENTENDENDO DA ONDE O MÉTODO GET DIAMETRO E GET LARGURA É CHAMADO

🏆

Se **a interface `Roda`** declara os métodos `getDiametro()` e `getLargura()`, então:

- O **tipo de referência** (`Roda`) vem da interface.
- O **código que realmente é executado** está na **classe concreta `RodaDoCarro`**, porque ela implementa a interface.

---

### Como funciona no seu exemplo

```java
// Interface
public interface Roda {
    float getDiametro();
    float getLargura();
}

// Classe concreta
public class RodaDoCarro implements Roda {
    private float diametro;
    private float largura;

    public RodaDoCarro(float diametro, float largura) {
        this.diametro = diametro;
        this.largura = largura;
    }

    public float getDiametro() { return diametro; }
    public float getLargura() { return largura; }
}

```

```java
// Uso
Roda r1 = RodaFactory.fazerRoda(50, 80);
System.out.println(r1.getDiametro()); // definido na interface, executado na classe concreta

```

---

💡 **Resumo:**

- A **interface** garante que todo mundo que for uma `Roda` terá `getDiametro()` e `getLargura()`.
- A **classe concreta** fornece a implementação real que é executada.

### EXPLICAÇÃO MAIS DETALHADA

🏆

```java
System.out.println(r1.getDiametro());

```

---

## **Passo a passo interno**

1. **Tipo de referência**
    
    Você declarou:
    
    ```java
    Roda r1 = RodaFactory.fazerRoda(50, 80);
    
    ```
    
    - `Roda` é **o tipo da variável** (a interface).
    - Isso significa que o compilador **só permite chamar métodos que estão definidos em `Roda`**.
    - Como `getDiametro()` está na interface, o compilador aprova.

---

1. **Tipo real do objeto**
    
    O método `RodaFactory.fazerRoda(50, 80)` retorna:
    
    ```java
    return new RodaDoCarro(diametro, largura);
    
    ```
    
    Ou seja, **o objeto real que vive dentro de `r1`** é do tipo `RodaDoCarro`.
    

---

1. **Ligação dinâmica (Dynamic Dispatch)**
    
    Quando você chama:
    
    ```java
    r1.getDiametro();
    
    ```
    
    o Java olha **no tempo de execução** qual é o **tipo real do objeto** dentro de `r1` (que é `RodaDoCarro`) e vai executar **a implementação de `getDiametro()` dessa classe**.
    

---

1. **Execução**
    
    Dentro de `RodaDoCarro`, o método é:
    
    ```java
    public float getDiametro() {
        return diametro;
    }
    
    ```
    
    Ele devolve o valor que você passou no construtor (`50`).
    

---

1. **Resumo visual**

```
Compilador → "Ok, Roda tem getDiametro(), pode chamar."
Tempo de execução → "O objeto é RodaDoCarro, então uso o getDiametro() dela."

```

---


### PARA FIXAR

🏆

---

### **Versão funcionando** (método declarado na interface)

```java
interface Roda {
    float getDiametro();
    float getLargura();
}

class RodaDoCarro implements Roda {
    private float diametro;
    private float largura;

    public RodaDoCarro(float diametro, float largura) {
        this.diametro = diametro;
        this.largura = largura;
    }

    public float getDiametro() { return diametro; }
    public float getLargura() { return largura; }
}

class RodaFactory {
    public static Roda fazerRoda(float diametro, float largura) {
        return new RodaDoCarro(diametro, largura);
    }
}

public class Teste {
    public static void main(String[] args) {
        Roda r1 = RodaFactory.fazerRoda(50, 80);

        // Compila e funciona
        System.out.println(r1.getDiametro());
    }
}

```

✅ **Funciona** porque `getDiametro()` está na interface `Roda`.

---

### **Versão quebrando** (método só na classe concreta)

```java
interface Roda {
    // interface sem métodos
}

class RodaDoCarro implements Roda {
    private float diametro;
    private float largura;

    public RodaDoCarro(float diametro, float largura) {
        this.diametro = diametro;
        this.largura = largura;
    }

    public float getDiametro() { return diametro; }
    public float getLargura() { return largura; }
}

class RodaFactory {
    public static Roda fazerRoda(float diametro, float largura) {
        return new RodaDoCarro(diametro, largura);
    }
}

public class Teste {
    public static void main(String[] args) {
        Roda r1 = RodaFactory.fazerRoda(50, 80);

        // ❌ Erro de compilação:
        // "cannot find symbol: method getDiametro()"
        System.out.println(r1.getDiametro());
    }
}

```

💥 **O que acontece:**

O compilador só olha o **tipo declarado** da variável (`Roda`) e não encontra `getDiametro()` na interface.

Mesmo que o objeto real seja `RodaDoCarro`, **o compilador não deixa compilar**.

---

### **Como resolver nesse caso**

Se quiser acessar métodos da classe concreta, teria que fazer um *cast*:

```java
System.out.println(((RodaDoCarro) r1).getDiametro());

```

Mas isso **quebra o polimorfismo** e é justamente o que a interface tenta evitar.

---


