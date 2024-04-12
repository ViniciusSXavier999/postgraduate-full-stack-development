package application.program;

import application.Aula03POO_ClassesAbstratas_ClasseConta;
import application.Aula03POO_ClassesAbstratas_ClassePoupanca;
import application.Aula03POO_ClassesAbstratas_ClasseContaCorrente;

public class MainAula03 {

	public static void main(String[] args) {
	
		/*Aqui temos o nosso tipo de variavel sendo do TIPO CONTA
		 * 
		 * JÁ O objeto é do tipo Classe Poupança pois não podemos instânciar objetos já que minha classe
		 * conta é abstrata*/
		
		Aula03POO_ClassesAbstratas_ClasseConta cp = new Aula03POO_ClassesAbstratas_ClassePoupanca();
		Aula03POO_ClassesAbstratas_ClasseConta cc = new Aula03POO_ClassesAbstratas_ClasseContaCorrente();
		
		cp.setSaldo(5000.0);
		cp.imprimeExtrato();
		
		cc.setSaldo(200.0);
		cc.imprimeExtrato();

	}

}
