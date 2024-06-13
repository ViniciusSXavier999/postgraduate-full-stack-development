package application.program;

import application.Aula06POO_Metodos;

public class MainAula06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aula06POO_Metodos ex = new Aula06POO_Metodos();
		
		ex.setIdade(19);
		
		/*
		if(ex.VerificarIdade()) {
			System.out.println("Ele é idoso");
		} else {
			System.out.println("Ele é novinho");
		}
		*/
		
		System.out.println(ex.VerificarIdade());
	

	}

}
