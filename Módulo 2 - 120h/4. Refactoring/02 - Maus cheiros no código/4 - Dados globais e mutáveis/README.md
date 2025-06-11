# 4 → DADOS GLOBAIS E MUTÁVEIS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/DadosGlobaisEMutaveis1.png" />

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/DadosGlobaisEMutaveis2.png" />

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/DadosGlobaisEMutaveis3.png" />

---

## MÃO NA MASSA!!

### TEMOS O SEGUINTE CÓDIGO

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class DadosGlobais {
	
	public String nome;
}
```

### A PRIMEIRA COISA QUE PODEMOS FAZER COM ESSE CÓDIGO E QUE É DE CERTA FORMA RECOMENDADO É ATRIBUIR UM ENCAPSULAMENTO PRIVADO PARA O CAMPO NOME E CRIAR OS MODIFICADORES DE ACESSO

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class DadosGlobais {
	
	private  String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
```