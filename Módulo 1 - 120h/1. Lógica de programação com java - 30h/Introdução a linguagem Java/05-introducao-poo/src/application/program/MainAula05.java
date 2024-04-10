package application.program;

import application.Aula05POO_Encapsulamento;

public class MainAula05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aula05POO_Encapsulamento exemplo = new Aula05POO_Encapsulamento();
		
		// SETANDO VALORES ATRAVÉS DO SET 
		exemplo.setNome("Vinicius");
		
		// IMPRIMINDO OS VALORES QUE EU SETTEI COM O SET E ACESSANDO ELES ATRAVÉS DO MEU GET
		System.out.println(exemplo.getNome());

	}

}
