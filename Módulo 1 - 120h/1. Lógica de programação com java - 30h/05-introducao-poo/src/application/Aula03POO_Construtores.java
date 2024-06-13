package application;

public class Aula03POO_Construtores {
	
	// ESSAS SÃO AS CARACTERISTICAS DO NOSSO OBJETO, O QUE CHAMAMOS DE ATRIBUTOS.
	
		public String nome;
		public String cor;
		public int idade;
		public double peso;
		
		/* QUANDO A GENTE QUER QUE NOSSO OBJETO JÁ SE INICIE COM INFORMAÇÕES DENTRO DELE */
		public Aula03POO_Construtores() {
			idade = 50;
		}
		
		/* CONSTRUTOR RECEBENDO PARAMETROS -> SOBRECARGA */
		public Aula03POO_Construtores(String nome, int idade) {
			// vou colocar esses dados nas minhas propriedades da minha classe
			
			/* this -> Para dizer para o computador que esse valor que vamos inserir é referente a 
			 * variavel nome da classe */
			
			this.nome = nome;
			this.idade = idade;
			
		}
		
		// ESSAS SÃO AS AÇÕES, O QUE CHAMMAMOS DE MÉTODOS.
		
		public void Anda() {
			System.out.println("Estou andando..." + idade);
		}
		
		// MÉTODO QUE VAI MOSTRAR OS VALORES DA IDADE E NOME DO MEU CONSTRUTOR
		public void Dados() {
			System.out.println(nome + " " + idade);
		}

}
