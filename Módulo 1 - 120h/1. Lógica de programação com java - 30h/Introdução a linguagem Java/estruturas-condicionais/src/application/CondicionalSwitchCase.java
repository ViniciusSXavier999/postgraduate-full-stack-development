package application;

import java.util.Scanner;

public class CondicionalSwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Cadastrar aluno: ");
		System.out.println("2 - Cadastrar notas: ");
		System.out.println("3 - Listar alunos e nota: ");

		int numero = entrada.nextInt();
		
		// aqui estou iniciando com a variavel numero
		// eu quero comparar se a variavel que o usuario digitou está dentro de um dos casos a seguir
		switch (numero) {
		
		// caso
		// caso o usuario digite o numero 1
		case 1:
			System.out.println("Vamos cadastrar aluno");
			// o break serve para parar a execução e não continuar o switch até o final
			break;
			
		case 2:
			System.out.println("Vamos cadastrar nota");
			break;
			
		case 3:
			System.out.println("Listar alunos");
			break;
			
			// Caso o usuario digite uma informação que não corresponde ao meu switch 
			default:
				System.out.println("O número é inválido");
		
		}
		
	}

}
