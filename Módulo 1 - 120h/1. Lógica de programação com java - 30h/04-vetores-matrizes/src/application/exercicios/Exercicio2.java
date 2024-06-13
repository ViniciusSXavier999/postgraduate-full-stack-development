package application.exercicios;

public class Exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] valores = {9, 8, 7, 6, 5};
		
		int aux;
		int cont = 0;
		
		while (cont < 2) {
			aux = valores[cont];
			valores[cont] = valores[cont+1];
			valores[cont+1] = aux;
			cont ++;
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(valores[i]);
		}
		

	}

}
