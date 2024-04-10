package application.program;

import application.Aula02POO_Classes;

public class MainAula02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Aqui estamos fazendo a ação de instânciar*/
		
		/* NEW -> porque estou criando uma nova instância, um novo elemento na memória. */
		
		/* Do lado direito do new temos o nosso método construtor, é o que vai construir a classe.*/
		
		/* A partir desse momento eu tenho uma entidade na memória do computador chamada "exemplo */
		Aula02POO_Classes exemplo = new Aula02POO_Classes();
		
		/* Aqui estou chamando as propriedades e atribuindo valores a elas. */
		
		exemplo.nome = "Java";
		exemplo.Anda();

	}

}
