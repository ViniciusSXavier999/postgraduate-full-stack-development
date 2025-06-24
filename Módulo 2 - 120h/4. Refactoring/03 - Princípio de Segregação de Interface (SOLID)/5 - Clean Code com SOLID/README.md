# 5 → CLEAN CODE COM SOLID

### DEFINIÇÕES QUE ABORDAM ESSA QUESTÃO

### FRASE 01

🏆 O código limpo sempre parece ter sido escrito por alguém que se importa com os demais desenvolvedores

> Quando a gente consegue tirar o lixo ou elementos que não fazem sentido.
> 

> Agora, nós não levamos em consideração se o código rodou ou não, se compilou ou não, nós levamos em consideração a maneira como nós vamos estruturar nosso código, para manter um código limpo devemos priorizar algumas ações:
> 
> - Organização estrutural
> - A remoção de comentários que não fazem sentido naquele processo
> - Dar um tab para organizar o código

🔒 Desse forma conseguimos deixar o código legível para a equipe que trabalha com o processo de desenvolvimento


### FRASE 02

🏆 Aprender a criar códigos limpos é uma tarefa árdua e requer mais do que um simples conhecimento dos princípios e padrões. Você deve suar a camisa; praticar sozinho e ver que cometeu erros; assistir os outros praticarem e errarem; vê-los tropeçar e refazer seus passos (MARTIN, 2000)


### DICAS PARA UM CÓDIGO LIMPO:

- Evitar colocar muitos parâmetros nos métodos
- Evitar o excesso de comentários
- Estruturar bem o código e nomear as classes com nomes intuitivos e que fazem sentido

### FRASE 03

🏆 Os princípios SOLID nos ajudam a escrever códigos muito mais limpos e aumentam a capacidade de manutenção, além de serem fundamentais para o processo de refatoração.


---

## MÃO NA MASSA!

### CLASSE EMPREGADO

🏆 Podemos observar que a nomenclatura da classe já indica do que ela se trata e isso já facilita o entendimento relacionado a isso.

🏆 Temos o atributo “nomeEmpregado” ele também está se referindo claramente o será armazenado nessa variável 

🏆 E também temos o método que vai realizar a leitura do dado que foi cadastrado


### PONTOS PARA SE ATENTAR

🔒

- Os espaços no código (não altera em nada na compilação, mas facilita o entendimento)
- Não temos comentários, porque tudo já está bem claro e objetivo, tornando nosso código limpo e legível.
- Não seria adequado colocar informações sobre clientes ou fornecedores, dessa maneira não iriamos cumprir com os princípios

```java
package refatoracao.estudos.solid.clean.code.com.solid;

public class Empregado {
	
	private String nomeEmpregado;
	
	public String getNomeEmpregado() {
		return this.nomeEmpregado;
	}

}
```