package refatoracao.conjunto.refatoracoes.extrair.variavel;

public class MainExtrairVariavel {

	public static void main(String[] args) {
		
		double b = 5, c = 7, d = 0;
		
		double calculo = b *c;
		
		// PODERIAMOS REALIZAR A EXTRAÇÃO DA VARIÁVEL NESSE CALCULO, PORQUE ELE SE REPETE DUAS VEZES
		if (calculo < 8) {
			d = (calculo) + (b/c);
		} 
		
		b = calculo;
		
		System.out.println("B: " + b + "\n" + "D: " + d);
		

	}

}
