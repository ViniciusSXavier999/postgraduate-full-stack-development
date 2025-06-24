# 6 → OPEN/CLOSED

### EXPLICAÇÃO COM EXEMPLO SIMPLES

> "Você deve poder mudar o comportamento de uma classe sem modificar seu código fonte."
> 

Ou seja:

✔️ Pode **extender** a classe

❌ Não deve **alterar** diretamente a classe original

---

### 🧠 Exemplo em Java (antes e depois)

### ❌ Antes (violando o Open/Closed)

```java
public class CalculadoraDesconto {
    public double calcular(String tipoCliente, double valor) {
        if (tipoCliente.equals("vip")) {
            return valor * 0.9;
        } else if (tipoCliente.equals("normal")) {
            return valor * 0.95;
        }
        return valor;
    }
}

```

Aqui, se quiser adicionar outro tipo de cliente, você **tem que editar** o método `calcular`. Isso **quebra o OCP**.

---

### ✅ Depois (seguindo o Open/Closed)

```java
// Interface
public interface Desconto {
    double calcular(double valor);
}

// Implementações
public class DescontoVIP implements Desconto {
    public double calcular(double valor) {
        return valor * 0.9;
    }
}

public class DescontoNormal implements Desconto {
    public double calcular(double valor) {
        return valor * 0.95;
    }
}

// Classe que usa a interface
public class CalculadoraDesconto {
    public double aplicarDesconto(Desconto desconto, double valor) {
        return desconto.calcular(valor);
    }
}

```

### Uso:

```java
CalculadoraDesconto calc = new CalculadoraDesconto();
double precoFinal = calc.aplicarDesconto(new DescontoVIP(), 100.0);
System.out.println(precoFinal); // 90.0

```

Agora, se você quiser adicionar um novo tipo de desconto (ex: "DescontoFeriado"), **não precisa tocar no código da Calculadora**, apenas cria uma nova classe.

---

### ASPECTOS QUE SÃO IMPORTANTES E RELEVANTES QUANDO ESTAMOS IMPLEMENTANDO NOSSOS CÓDIGOS

### FRASE 01

🏆 Um módulo deve estar aberto para extensão, mas fechado para modificação

> Nós podemos usar a classe em outros locais, mas não realizar alterações durante esse processo.
> 

### FRASE 02

🏆 Devemos escrever nossos módulos de modo que possam ser estendidos, sem exigir que sejam modificados.


### FRASE 03


🏆 Como exemplo do OCP, considere a próxima figura. Nesse exemplo a função LogOn depende somente da interface do MODEM.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/openClosed01.png" />

MODEMS adicionais não farão com que a função LogOn seja alterada. Dessa forma, criamos um módulo que poderá ser estendido (sem realizar uma modificação estrutural)

> Nós colocamos as alterações nas classes inferiores, não realizamos mudanças drásticas nas classes superiores.
> 

---

## MÃO NA MASSA!!

### VAMOS IMAGINAR QUE VAMOS REALIZAR UMA IMPLEMENTAÇÃO PARA VINCULAR E GERAR RELATÓRIOS A PARTIR DA LEITURA DE ARQUIVOS ESPECIFICOS

### CLASSE REPORTING SERVICE

🏆 Esse arquivo não sofre alteração, independente das implementações que a gente colocar no processo, nós podemos continuar usando esse elemento, podemos incluir outras classes e funcionalidades sem alterar as classes principais.


```java
package refatoracao.estudos.solid.open.closed;

public class ReportingService {

	public void generateReportBasedOnStrategy(ReportingStrategy reportingStrategy) {
		System.out.println("----------------------------");
		System.out.println("Gerando relatório");
		reportingStrategy.generateReport();
		System.out.println();
	}
	
}
```

### CLASSE CSV

```java
package refatoracao.estudos.solid.open.closed;

public class CSVReportingStrategy implements ReportingStrategy {
	
	@Override
	public void generateReport() {
		System.out.println("CSV");
	}

}
```

### CLASSE XML REPORTING

```java
package refatoracao.estudos.solid.open.closed;

public class XMLReportingStrategy implements ReportingStrategy {
	
	@Override
	public void generateReport() {
		System.out.println("Generate XML Report");
	}

}

```

### INTERFACE REPORTING STRATEGY

```java
package refatoracao.estudos.solid.open.closed;

public interface ReportingStrategy {
	
	public void generateReport();

}
```

### CLASSE MAIN GERADORA DE RELATÓRIO

```java
package refatoracao.estudos.solid.open.closed;

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

🏆

### EXPLICAÇÃO DETALHADA

### ✅ O que essa classe faz (resumidamente):

A classe `GenerateReportMain` é a **classe principal (main)** de um sistema que **gera relatórios** com base em uma **estratégia de formatação**.

Ela:

1. Cria um objeto `ReportingService`.
2. Cria duas estratégias diferentes de relatório: **CSV** e **XML**.
3. Usa o método `generateReportBasedOnStrategy(...)` para gerar os relatórios com cada estratégia.

---

### 🔧 Como funciona por trás (provavelmente):

- `ReportingService` tem um método que **aceita diferentes implementações de `ReportingStrategy`**, uma **interface** com o método (por exemplo) `generate()`.
- `CSVReportingStrategy` e `XMLReportingStrategy` são **implementações diferentes** da interface `ReportingStrategy`.

---

### ✅ A classe segue o princípio **Open/Closed (OCP)**?

**Sim, ela segue!**

Aqui está o porquê:

- **Fechada para modificação:**
    
    A lógica da `GenerateReportMain` **não precisa ser alterada** para suportar novos formatos de relatório (ex: PDF, JSON).
    
- **Aberta para extensão:**
    
    Você pode **criar novas classes** que implementem `ReportingStrategy` (ex: `PDFReportingStrategy`) e passá-las para o `ReportingService` — sem alterar o código já existente.
    

---

### 🧠 Conclusão:

A classe `GenerateReportMain` está usando o padrão **Strategy** de forma correta, respeitando o princípio **Open/Closed** do SOLID, porque permite **adicionar novos comportamentos (relatórios)** sem mudar o código existente. ✔️


---

🏆 As classes inferiores não vão realizar nenhuma alteração na super classe para que elas existam, nós conseguimos realizar adequações e ajustes de forma individualizada em cada uma delas.

