package application;

import java.util.Scanner;

public class EstruturaDoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		int opcao;
		
		// faça
		
		// O TESTE COM O DO WHILE É FEITO NO FINAL
		do {
			System.err.println("Digite um valor ou 99 para sair");
			Scanner sc = new Scanner(System.in);
			opcao = sc.nextInt();
		} while (opcao != 99);

	}

}
