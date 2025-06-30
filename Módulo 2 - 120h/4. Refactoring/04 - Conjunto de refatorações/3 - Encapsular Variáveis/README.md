# 3 → ENCAPSULAR VARIÁVEIS

### DEFINIÇÕES IMPORTANTES

### FRASE 01

🏆 O encapsulamento oferece um ponto claro para monitorar as alterações e o uso dos dados.

Por exemplo, podemos acrescentar validações ou uma lógica nas atualizações de forma simples e objetiva (FOLER, 2019)


### PARA REALIZAR ESSA AÇÃO DO ENCAPSULAMENTO DE VARIÁVEIS, TEMOS UM PASSO A PASSO DE PROCEDIMENTOS IMPORTANTE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/encapsularVariaveis01.png" />

1 → MÉTODOS GET E SET

🏆

### 🔹 **Getter** → para **acessar (ler)** o valor

### 🔹 **Setter** → para **atualizar (modificar)** o valor


3 → UTILIZAR OS MÉTODOS GET E SET 

### 🎯 **Objetivo:**

Substituir referências diretas a uma variável por chamadas ao **getter** e **setter** (funções de encapsulamento).

---

### 👎 Antes (sem encapsulamento):

```java
public class Aluno {
    public String nome;
}

```

```java
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.nome = "João"; // acesso direto
        System.out.println(aluno.nome); // acesso direto
    }
}

```

---

### ✅ Depois (com encapsulamento passo a passo):

### 1. **Encapsular a variável:**

```java
public class Aluno {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

```

### 2. **Substituir o acesso direto pelo `setter`:**

```java
aluno.setNome("João");

```

### 3. **Substituir a leitura direta pelo `getter`:**

```java
System.out.println(aluno.getNome());

```

---

### 💡 **Resultado final resumido:**

```java
public class Aluno {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome("João"); // escrita via setter
        System.out.println(aluno.getNome()); // leitura via getter
    }
}

```

---

### ✅ **Resumo final:**

> A cada uso direto da variável, substituímos por get ou set, testando após cada troca, para garantir que tudo continua funcionando corretamente. Isso é encapsular passo a passo.
> 

---

## COLOCANDO A MÃO NA MASSA!

### VAMOS INICIAR IMPLEMENTANDO A CLASSE AREA PARA REALIZAR O CALCULO DA AREA DE UMA FIGURA GEOMETRICA.

```java
package refatoracao.conjunto.refatoracoes.encapsular.variaveis;

public class Area {
	
	int comprimento, largura;
	
	Area (int comprimento, int largura) {
		this.comprimento = comprimento;
		this.largura = largura;
	}

	public void getArea() {
		int area = comprimento * largura;
		System.out.println("Area: " + area);
	}
	
}
```

### CLASSE MAIN

```java
package refatoracao.conjunto.refatoracoes.encapsular.variaveis;

public class MainEncapsularVariaveis {

	public static void main(String[] args) {
		
		Area retangulo = new Area(2, 16);
		
		retangulo.getArea();

	}

}
```