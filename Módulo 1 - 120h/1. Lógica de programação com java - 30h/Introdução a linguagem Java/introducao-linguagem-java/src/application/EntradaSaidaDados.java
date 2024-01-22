package application;

import java.util.Scanner;

public class EntradaSaidaDados {

	public static void main(String[] args) {
		
		System.out.println("Olá mundo");
		
		System.out.println("Informe seu nome: ");
		
		Scanner sc = new Scanner(System.in);
		
		String palavra;
		
		palavra = sc.next();
		
		System.out.println("O nome digitado foi: " + palavra);
	

	}

}
