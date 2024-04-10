package application.exercicios;

public class Exercicio1 {

	public static void main(String[] args) {
		
		int[] lista = {3, 4, 5, 6, 7};
		
		int cont = 0;
		
	
		while(cont < 5) {
			System.out.println(lista[cont]);
			cont++;
		}
		
		System.out.println("------------------------------");
		
		for(cont=0; cont < 5; cont ++) {
			System.out.println(lista[cont]);
		}

	}

}
