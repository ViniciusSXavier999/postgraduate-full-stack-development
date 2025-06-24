# 4 → SINGLE RESPONSIBILITY PRINCIPLE

---

### ✅ **Single Responsibility Principle (SRP)** — Princípio da Responsabilidade Única

> "Uma classe deve ter apenas uma única razão para mudar."
> 

---

### 📌 Em outras palavras:

Cada classe (ou módulo) deve fazer **uma coisa só** — e **fazer bem feito**.

Ela deve ter **apenas uma responsabilidade**, ou seja, **um único propósito ou função no sistema**.

---

### 🧱 Exemplo prático:

### ❌ Violando o SRP:

```java
public class Relatorio {

    public void gerarRelatorio() {
        // lógica de geração
    }

    public void salvarNoBanco() {
        // lógica para salvar no banco de dados
    }

    public void enviarPorEmail() {
        // lógica para enviar e-mail
    }
}

```

Aqui, a classe `Relatorio` tem **3 responsabilidades**:

1. Gerar relatório
2. Salvar dados
3. Enviar por e-mail

👉 Ou seja, **3 motivos diferentes para mudar**. Isso **viola o SRP**.

---

### ✅ Aplicando o SRP:

```java
public class GeradorRelatorio {
    public void gerar() {
        // lógica de geração
    }
}

public class PersistenciaRelatorio {
    public void salvar() {
        // lógica para salvar no banco
    }
}

public class EmailService {
    public void enviar() {
        // lógica para enviar por e-mail
    }
}

```

Cada classe agora tem **uma única responsabilidade**.

Cada uma muda **por um único motivo específico**.

---

### 🎯 Benefícios do SRP:

- Código mais **organizado** e **modular**
- Mais **fácil de manter e testar**
- **Menos chances de bugs colaterais** quando algo muda

---

### DEFINIÇÕES QUE ABORDAM ESSA QUESTÃO

### FRASE 01

🏆 Uma classe deve ter um, e apenas um, motivo para mudar.


### FRASE 02

🏆 Cada responsabilidade deve ser uma classe, porque uma responsabilidade é um eixo de mudança

- Cada tarefa a gente coloca em uma classe, dessa forma a gente divide as ações que serão realizadas, isso facilita a visualização e compreensão do processo.

### FRASE 03

🏆 Este é o tipo de princípio que todo código orientado a objetos deveria possuir.

Portanto antes de construir aquela classe que cadastra o usuário e envia o e-mail, lembre-se deste princípio.


### FRASE IMPORTANTE PARA SE LEMBRAR

✅ DIVIDIR PARA CONQUISTAR.

> Separar as funcionalidades para que a organização ocorra de forma eficaz, facilita na compreensão, manutenção e atualização, pois as funcionalidades elas estão divididas.
> 

---

## MÃO NA MASSA!

### VAMOS TER A CLASSE ESTUDANTE, ELA POSSUI ALGUMAS FUNCIONALIDADES.

🚨 Porém ela não segue o principio Single Responsability Principle, porque ela possui mais de uma funcionalidade, uma diferente da outra

🔒 A forma correta seria dividir esses processos, dividindo esses métodos um em cada classe.


```java
package refatoracao.estudos.solid.single.responsibility.principle;

public class Estudante {
	
	public void imprimirDetalhes() {
		// funcionalidade do método
	}
	
	public void calcularNota() {
		// funcionalidade do método
	}
	
	public void addAluno() {
		// funcionalidade do método
	}

}
```

### FORMA CORRETA

### CLASSE IMPRIMIR ESTUDANTE

```java
package refatoracao.estudos.solid.single.responsibility.principle;

public class ImprimirEstudante {
	
	public void imprimirDetalhes() {
		// funcionalidade do método
	}
	

}
```

### CLASSE CALCULAR NOTA DO ESTUDANTE

```java
package refatoracao.estudos.solid.single.responsibility.principle;

public class CalcularNotaEstudante {
	

	public void calcularNota() {
		// funcionalidade do método
	}

}
```

### CLASSE PARA ADICIONAR ESTUDANTE

```java
package refatoracao.estudos.solid.single.responsibility.principle;

public class AdicionarEstudante {
	
	public void addAluno() {
		// funcionalidade do método
	}

}

```

🔒 DESSA MANEIRA AS INFORMAÇÕES FICAM BEM MAIS OBJETIVAS, FACILITANDO MUITO A COMPREENSÃO E ORGANIZAÇÃO E CASO SEJA NECESSÁRIO CORRIGIR ALGUM ELEMENTO, BASTA SOMENTE ABRIR A CLASSE ESPECIFICA DESSE ELEMENTO
