package application.exercicios;

public class UtilizandoVetores {

	public static void main(String[] args) {
	
		/*
		 * VOCÊ É UM ÁVIDO OBSERVADOR DE PÁSSAROS.
		 * DURANTE 14 DIAS VOCÊ ANOTOU QUANTOS PÁSSAROS VISITARAM O SEU JARDIM.
		 * AGORA VOCÊ DESEJA REALIZAR UMA ESTATÍSTICA PARA RESPONDER AS PERGUNTAS A SEGUIR:
		 * 
		 * A -> NÚMERO TOTAL DE PÁSSAROS
		 * B -> NÚMERO TOTAL DE PÁSSAROS NA PRIMEIRA SEMANA
		 * C -> NÚMERO TOTAL DE PÁSSAROS NA SEGUNDA SEMANA
		 * 
		 * VETOR DE ENTRADA:
		 * 
		 * passarosPorDia = [2,5,0,7,4,1,3,0,2,5,0,1,3,1]
		 * 
		 * */
		
		int[] passarosPorDia = {2,5,0,7,4,1,3,0,2,5,0,1,3,1};
		
		int totalPassaros = 0;
		int passarosPrimeiraS = 0;
		int passarosSegundaS = 0;
		
		
		/*TOTAL DE PASSAROS*/
		// MARCAR O BREAKING POINT E CLICAR NO INSETO, PARA DEBUGAR UTILIZAR A TECLA F6
		for (int i=0; i<14; i++) {
			totalPassaros+= passarosPorDia[i];
		}
		
		/*TOTAL PASSAROS PRIMEIRA SEMANA*/
		for(int i=0; i<7; i++) {
			passarosPrimeiraS+= passarosPorDia[i];
		}
		
		for (int i=7; i<14; i++) {
			passarosSegundaS+= passarosPorDia[i];
		}
		
		System.out.println("Total de Pássaros: " + totalPassaros);
		System.out.println("Total de Pássaros na primeira semana: " + passarosPrimeiraS);
		System.out.println("Total de Pássaros na segunda semana: " + passarosSegundaS);
		
		
		

	}

}
