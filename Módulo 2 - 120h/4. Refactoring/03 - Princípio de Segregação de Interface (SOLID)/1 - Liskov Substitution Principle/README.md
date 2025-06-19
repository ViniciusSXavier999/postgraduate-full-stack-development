# 1 → LISKOV SUBSTITUTION PRINCIPLE

**SOLID** é um acrônimo muito importante na programação orientada a objetos (POO). Ele representa cinco princípios que ajudam a escrever **código mais limpo, organizado, flexível e fácil de manter**.

Aqui vai um resumo simples e direto de cada letra do **SOLID**:

---

### 🟡 **S — Single Responsibility Principle (Princípio da Responsabilidade Única)**

👉 Uma classe deve ter **apenas uma razão para mudar**.

**Ou seja:** ela deve ter apenas **uma responsabilidade**.

✅ Exemplo: uma classe que salva dados **não** deve também ser responsável por exibir os dados na tela.

---

### 🟡 **O — Open/Closed Principle (Princípio Aberto/Fechado)**

👉 "Aberto para extensão, fechado para modificação."

**Ou seja:** você deve poder **adicionar** funcionalidades a uma classe **sem modificar o código existente**.

✅ Isso ajuda a evitar bugs em código que já está funcionando.

---

### 🟡 **L — Liskov Substitution Principle (Princípio da Substituição de Liskov)**

👉 Subtipos devem poder ser usados no lugar de seus tipos base **sem quebrar o programa**.

✅ Se `ClasseFilha` herda de `ClassePai`, então você deve conseguir usar a `ClasseFilha` onde usaria a `ClassePai`.

---

### 🟡 **I — Interface Segregation Principle (Princípio da Segregação de Interface)**

👉 Classes **não devem ser forçadas a implementar interfaces que não usam**.

✅ É melhor ter várias interfaces pequenas e específicas do que uma interface grande e genérica.

---

### 🟡 **D — Dependency Inversion Principle (Princípio da Inversão de Dependência)**

👉 Dependa de **abstrações (interfaces)**, não de implementações concretas.

✅ Isso ajuda a **desacoplar** as partes do sistema, facilitando mudanças e testes.

---

### Resumindo:

> SOLID ajuda a escrever código que cresce bem, sem virar uma bagunça.
> 

---

## VAMOS VER ALGUMAS FRASES E DEPOIS PARTIR PARA O CÓDIGO

### FRASE 01

🏆 As subclasses devem ser substituíveis por suas classes base.

> É preciso haver uma harmonia entre a classe pai e as classes filhas, quando nós conseguimos organizar de forma adequada é possível criar outros recursos.
> 

### FRASE 02

🏆 Os objetos de uma superclasse devem ser substituíveis por objetos de suas subclasses sem quebrar o aplicativo/programa

Em outras palavras, o que queremos é que os objetos de nossas subclasses se comportem da mesma forma que os objetos de nossa superclasse.


### ESTRUTURA QUE RESUME O QUE ESTAMOS PROPONDO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/liskovSubstitutionPrinciple1.png" />

---

### COLOCANDO A MÃO NA MASSA

### TEMOS A SEGUINTE CLASSE TRANSPORTE

```java
package refatoracao.estudos.solid.liskov.substitution.principle;

public class Transporte {
	
	String name;
	double speed;
	Motor motor;
	
	// MÉTODO DA CLASSE
	public void startMotor() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	
	

}
```

### E TAMBÉM A CLASSE CARRO NA QUAL VAMOS REALIZAR A VINCULAÇÃO COM A CLASSE TRANSPORTE

```java
package refatoracao.estudos.solid.liskov.substitution.principle;

public class Carro extends Transporte{
	
	@Override
	public void startMotor() {
		
	}

}
```

### AGORA, VAMOS IMAGINAR QUE O NOSSO CLIENTE SOLICITOU PARA INCLUIR OUTROS VEICULOS DE TRANSPORTE E A GENTE DEVE REALIZAR A IMPLEMENTAÇÃO DA MOTO, CAMINHÃO, BARCO, ETC.

### MAS O CLIENTE ACABOU PEDINDO TAMBÉM A IMPLEMENTAÇÃO DO VEICULO BICICLETA, NESSE CASO TEMOS UM DILEMA, A BICICLETA É UM VEICULO DE TRANSPORTE, PORÉM ELA NÃO POSSUI MOTOR.

🏆 Por tanto, o método:

```java
@Override
	public void startMotor() {
		
	}
```

não poderia ser implementado já que a bicicleta não possui motor, esse é um típico problema da violação do princípio de LISKOV


### COMO RESOLVER ESSE PROBLEMA?

🏆 A solução para problemas que estão relacionados com esse processo, é justamente melhor e gerir a hierarquia de herança, quando nós conseguimos aprimorar esse processo, nós conseguimos resolver.


🏆 Nós poderíamos resolver esse problema diferenciando classes de meio de transporte: COM MOTOR E SEM MOTORES 

```java
package refatoracao.estudos.solid.liskov.substitution.principle;

public class SemMotor {

}
```


---

### DÚVIDA QUE SURGIU DURANTE A AULA

### O que significa essa classe motor na minha classe transporte?

```java
public class Transporte {

    String name;
    double speed;
    Motor motor;
}

```

### ✅ O que significa `Motor motor;`?

Essa linha está **declarando um atributo chamado `motor`** do tipo `Motor`. Ou seja, a classe `Transporte` **possui** um motor.

Isso é um exemplo de **composição**, um princípio da programação orientada a objetos onde uma classe é **composta por outras classes**.

---

### 🔍 Para funcionar, precisa existir uma classe `Motor`

O Java precisa saber o que é esse tipo `Motor`, então você provavelmente tem (ou precisa criar) algo assim:

```java
public class Motor {
    int potencia;
    String tipo;

    // construtor, getters, setters etc.
}

```

---

### 🧠 Em resumo:

- `motor` é **um atributo da classe `Transporte`**.
- Ele é do tipo `Motor`, ou seja, **a classe `Motor` define como é esse objeto** (seus atributos e comportamentos).
- Isso permite que você **crie transportes com diferentes motores**.

---

### 💡 Exemplo prático:

```java
Motor motorDiesel = new Motor();
motorDiesel.potencia = 120;
motorDiesel.tipo = "Diesel";

Transporte caminhão = new Transporte();
caminhão.name = "Caminhão";
caminhão.speed = 80;
caminhão.motor = motorDiesel;

```

Assim, seu objeto `caminhão` tem um motor Diesel com 120 de potência.

### mas nesse caso ele ainda nao foi instanciado, correto?

Na linha abaixo dentro da classe `Transporte`:

```java
Motor motor;

```

Você **apenas declarou** uma variável de instância do tipo `Motor`, mas **ainda não instanciou** o objeto. Isso significa que, por padrão, o valor dela será `null` até que você crie um objeto `Motor` e o associe a ela.

---

### ✅ O que está acontecendo:

- `Motor motor;` → **declaração**
- Ainda **não tem um objeto `Motor` na memória** ligado a essa variável.
- Você precisa fazer isso em algum momento, como:

```java
motor = new Motor();

```

Ou passar no construtor, como:

```java
public class Transporte {
    String name;
    double speed;
    Motor motor;

    public Transporte(String name, double speed, Motor motor) {
        this.name = name;
        this.speed = speed;
        this.motor = motor; // agora sim está sendo atribuído
    }
}

```

---

### ⚠️ Se tentar usar `motor` antes de instanciá-lo:

Você vai ter um erro de `NullPointerException`, porque está tentando acessar algo que ainda é `null`.

---

### ✅ Exemplo completo:

```java
public class Motor {
    int potencia;
    String tipo;
}

public class Transporte {
    String name;
    double speed;
    Motor motor;

    public Transporte(String name, double speed, Motor motor) {
        this.name = name;
        this.speed = speed;
        this.motor = motor;
    }
}

public class Main {
    public static void main(String[] args) {
        Motor m = new Motor();
        m.potencia = 150;
        m.tipo = "Elétrico";

        Transporte carro = new Transporte("Carro", 120, m);

        System.out.println(carro.name);             // Carro
        System.out.println(carro.motor.tipo);       // Elétrico
    }
}

```
