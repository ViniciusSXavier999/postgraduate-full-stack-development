# 3 → LISTA LONGA DE PARÂMETROS

🏆 As vezes utilizamos métodos com vários parâmetros e nós não conseguimos entender os itens que são passados e isso acaba gerando uma grande confusão.


---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/listaLongaParametros01.png" />

> Nós não devemos continuar utilizando essa prática.
> 

---


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/listaLongaParametros02.png" />

---


<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/listaLongaParametros03.png" />

---

## JEITO CORRETO.

### NÓS TEMOS O SEGUINTE MÉTODO E SEUS PARÂMETROS

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class ListaLongaParametros {

	public static void main(String[] args) {
	
		Email(true, false, "teste@outlook.com", null);

	}
	
	public static void Email(boolean b, boolean c, String string, Object object) {
		System.out.println("1. " + b + "\n" +
						   "2. " + c + "\n" +
						   "string" + string + "\n" +
						   "object" + object + "\n"
				);
	}

}
```

### PODERIAMOS RESOLVER ESSE “PROBLEMA” AGRUPANDO ESSES PARÂMETROS EM UM NOVO OBJETO

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class EmailCadastroListaLongaParametros {
	
	public boolean param1;
	public boolean param2;
	public String email;
	public boolean param3;
	
	public boolean getParam1() {
		return param1;
	}
	
	public void setParam1(boolean param1) {
		this.param1 = param1;
	}

}
```




### NOSSO CÓDIGO REFATORADO FICARIA DESSE FORMA 🏆

```java
package refatoracao.estudos.maus.cheiros.no.codigo;

public class ListaLongaParametros {

	public static void main(String[] args) {
		
		EmailCadastroListaLongaParametros Email = new EmailCadastroListaLongaParametros();
		
		Email.param1 = false;
		Email.param2 = false;
		Email.param3 = true;
		Email.email = "vinisim999@gmail.com";
		
		System.out.println(Email.getParam1());
	}
}
```

🏆 Observe que agora conseguimos enxergar de forma clara e objetiva quais são as informações que nós estamos enviando.
