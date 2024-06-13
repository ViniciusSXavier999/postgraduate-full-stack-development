package application.exercicios;

public class Exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] lista = {13,41,5,86,72,9,82,36,27,8};
		
		int pares = 0;
		
		int valorPares = 0;
		
		int maiores = 0;
		
		int indice = 0;
		
		int valor = 0;
		
		
		for (int i=0; i<10; i++) {
			if(lista[i] % 2 == 0 ) {
				pares++;
				valorPares = lista[i];
				System.out.println("quantidade de números pares: " + pares + " E os números pares são: " + valorPares);
			}
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for(int i=0; i<10; i++) {
			if(lista[i] > 28) {
				maiores ++;
				indice = i;
				valor = lista[i];
				System.out.println("maiores que 28 são: " + maiores + " No indice: " + indice +
						" Com o valor de: " + valor);
			}
		}
		
		
	}
	
	

}
