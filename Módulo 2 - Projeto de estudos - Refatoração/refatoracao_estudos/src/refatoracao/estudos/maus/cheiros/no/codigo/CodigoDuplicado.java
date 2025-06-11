package refatoracao.estudos.maus.cheiros.no.codigo;

public class CodigoDuplicado {

	public static void main(String[] args) {
	
		float total = 0, preco = 0;
		
		boolean avancar = true;
		
		if(avancar) {
			total = preco * 0.95f;
		//	calcular();
		} else {
			total = preco * 0.98f;
		//	calcular();
		}
		
		calcular();
		
	}
	
	public static void calcular() {
		System.out.println("Calcular");
	}

}
