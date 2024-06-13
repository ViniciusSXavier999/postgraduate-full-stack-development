package application.program;

import application.Aula04POO_Interface_ClassePoupanca;
import application.Aula04POO_Interface_InterfaceConta;

public class MainAula04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Aqui eu tenho uma variavel do tipo INTERFACE CONTA QUE VAI RECEBER UM OBJETO DO TIPO POUPANCA*/
		Aula04POO_Interface_InterfaceConta cp = new Aula04POO_Interface_ClassePoupanca();
		
		// Consultando o saldo antes do depósito
		System.out.println(cp.getSaldo());
		
		// Depositando dinheiro
		cp.depositar(500);
		System.out.println(cp.getSaldo());
		
		cp.sacar(200);
		System.out.println(cp.getSaldo());

	}


}
