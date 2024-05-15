package application;

import java.util.Scanner;

public class Aula05POO_TratamentoDeExcecoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um valor: ");
		int numero1 = sc.nextInt();

		System.out.println(numero1);
		 } 
		 catch (Exception e) {
			System.out.println("Erro, valor não é um número!!");
		}
	}

}
