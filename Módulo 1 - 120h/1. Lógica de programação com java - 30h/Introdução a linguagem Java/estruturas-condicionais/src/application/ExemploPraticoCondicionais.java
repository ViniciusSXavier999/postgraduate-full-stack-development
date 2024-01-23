package application;

import java.util.Scanner;
import java.util.Random;

public class ExemploPraticoCondicionais {

	public static void main(String[] args) {

		/*
		Random gerador = new Random();
		// Quando eu coloco o número 100 o computador entende que eu quero gerar números de 0 a 100
		int x = gerador.nextInt(100);
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Adivinhe o número que estou pensando: ");
		int numero = entrada.nextInt();
		
		if (numero == x) {
			System.out.println("Você adivinhou!!");
		}
		
		else {
			System.out.println("Você errou!!, eu pensei no: " + x);
		}
		*/
		
		// gerador de número 
		Random gerador = new Random();	
		
		// variaveis
		int nivel, ns , palpite;
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1 - Fácil");
		System.out.println("2   Médio");
		System.out.println("3 - Dificil");
		System.out.println("Escolha o nível de dificulade que você deseja: ");
		nivel = sc.nextInt();
		
		if (nivel == 1) {
			ns = gerador.nextInt(10);
			
			System.out.println("Adivinhe o número que estou pensando: ");
			palpite = sc.nextInt();
			
			if(palpite == ns) {
				System.out.println("Você acertou!!");
			} else {
				System.out.println("Você errou, eu estava pensando no número: " + ns);
			}
		}
		
		if (nivel == 2) {
			ns = gerador.nextInt(50);
			
			System.out.println("Adivinhe o número que estou pensando: ");
			palpite = sc.nextInt();
			
			if (palpite == ns) {
				System.out.println("Você acertou!!");
			} else {
				System.out.println("Você errou, eu estava pensando no número:" + ns);
			}
		}
		
		if (nivel == 3) {
			ns = gerador.nextInt(100);
			
			System.out.println("Dificuldade - Dificil!");
			System.out.println("Adivinhe o número que estou pensando ");
			palpite = sc.nextInt();
			
			if (palpite == ns) {
				System.out.println("Você acertou!!");
			} else {
				System.out.println("Você errou, eu estava pensando no número: " + ns);
			}
			
		}
		
	
		
		

	}

}

