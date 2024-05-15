package application;

public class Aula02POO_Sobrecarga_ClasseDesenho {
	
	// MÉTODO SEM PARÂMETRO
	
	public void mostrar() {
		for(int i =0; i < 10; i++) {
			System.out.println("*");
		}
	}

	// MÉTODO COM 1 PARÂMETRO
	
	public void mostrar(char simb) {
		for(int i =0; i < 10; i++) {
			System.out.println(simb);
		}
	}
	
	// MÉTODO COM DOIS PARÂMETROS
	
	public void mostrar(char simb, int n) {
		for(int i =0; i < n; i++) {
			System.out.println(simb);
		}
	}
}
