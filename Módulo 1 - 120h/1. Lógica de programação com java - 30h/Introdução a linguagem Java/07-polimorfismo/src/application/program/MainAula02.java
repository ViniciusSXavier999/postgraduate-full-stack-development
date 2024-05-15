package application.program;

import application.Aula02POO_Sobrecarga_ClasseDesenho;

public class MainAula02 {

	public static void main(String[] args) {
		
		Aula02POO_Sobrecarga_ClasseDesenho d1 = new Aula02POO_Sobrecarga_ClasseDesenho();
		
		// nesse caso estou chamando o método que não utiliza parâmetros
		d1.mostrar();
		
		// Método que tem 1 parâmetro
		d1.mostrar('#');
		
		// Método que tem 2 parâmetros
		d1.mostrar('$', 3);

	}

}
