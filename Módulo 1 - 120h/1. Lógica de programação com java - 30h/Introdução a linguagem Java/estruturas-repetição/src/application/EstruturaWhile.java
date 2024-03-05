package application;

import java.util.Scanner;

public class EstruturaWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// é sempre recomendado declarar a variavel antes de qualquer coisa no programa e inicia-la com 0
		int valor = 0;
		
		while(valor != 99) {
		System.out.println("Digite um valor qualquer ou 99 para sair!");
		Scanner sc = new Scanner(System.in);
		valor = sc.nextInt();
		
		}
		
	

	}

}
