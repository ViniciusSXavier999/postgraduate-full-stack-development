package application.program;

import application.Aula06POO_ExercicioHeranca_ClasseCachorro;
import application.Aula06POO_ExercicioHeranca_ClasseGato;

public class MainAula06 {

	public static void main(String[] args) {

		// GERANDO UM OBJETO DO TIPO CACHORRO
		Aula06POO_ExercicioHeranca_ClasseCachorro c = new Aula06POO_ExercicioHeranca_ClasseCachorro();
		c.setNome("Vinicius");
		
		Aula06POO_ExercicioHeranca_ClasseGato g = new Aula06POO_ExercicioHeranca_ClasseGato();
		g.setNome("Marcela");
		
		c.mostrar();
		g.mostrar();
	}

}
