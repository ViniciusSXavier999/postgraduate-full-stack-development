# 3 → REPLACE EXCEPTION WITH TEST

🏆 Processo de substituição da exceção por teste.


### PROBLEMA

🚨 Você utiliza uma exceção em um local onde um teste(validação) simples faria o trabalho? 

### Essa exceção poderia ser substituída por um teste de validação?


### SOLUÇÃO

✅ Substitua a exceção por um teste de condição


---

### NESSE EXEMPLO TEMOS UM TRATAMENTO DE EXCEÇÃO QUE PODERIA SER SUBSTITUIDO POR UMA VALIDAÇÃO

```java
package application;

public class Exemplo {
	
	double [] values;
	
	double getValueForPeriod (int periodNumber) {
		try {
			return values[periodNumber];
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

```

✅

### EXPLICAÇÃO DETALHADA

```java
public class Exemplo {

```

- Declara a **classe pública `Exemplo`**.

```java
double [] values;

```

- Declara um **array de números decimais (`double`)** que armazenará valores.

```java
double getValueForPeriod (int periodNumber) {

```

- Declara um **método que retorna um `double`** e recebe como parâmetro o número do período.

```java
try {
    return values[periodNumber];
}

```

- **Tenta acessar e retornar** o valor no índice indicado.

```java
catch (ArrayIndexOutOfBoundsException e) {
    return 0;
}

```

- **Se o índice for inválido**, captura a exceção e **retorna 0**.

---


### SUBSTITUINDO A EXCEÇÃO PELA VALIDAÇÃO

```java
package application;

public class Exemplo2 {
	
double [] values;
	
	double getValueForPeriod (int periodNumber) {
		
		if(periodNumber >= values.length) {
			return 0;
		} else {
			return values[periodNumber];
		}
	}

}
```