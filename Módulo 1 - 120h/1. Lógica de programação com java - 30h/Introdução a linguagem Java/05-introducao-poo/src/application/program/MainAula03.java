package application.program;

import application.Aula03POO_Construtores;

public class MainAula03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aula03POO_Construtores exemplo = new Aula03POO_Construtores();
		exemplo.Anda();
		
		// EXEMPLO UTILIZANDO O CONSTRUTOR COM VALORES
		Aula03POO_Construtores exemplo2 = new Aula03POO_Construtores("Kobe", 70);
		exemplo2.Dados();

	}

}
