package refatoracao.conjunto.refatoracoes.extrair.funcao;

public class Main {

	public static void main(String[] args) {
		
		// DEFINIÇÃO DE OBJETOS E ATRIBUIÇÕES
		int a = 1;
		int b = 2;
		int c = 0;
		int d = 0;
		
		// DOIS CALCULOS QUE SÃO REALIZADOS
		 c = adicao(a, b);
		 d = adicao(a, c);
		
		// EXIBIÇÃO DOS RESULTADOS OBTIDOS
		vizualizacao(c);
		vizualizacao(d);

	}
	
	
	// MÉTODO RESPONSÁVEL PELO CALCULO
	private static int adicao(int num1, int num2) {
		return num1 + num2;
	}
	
	private static void vizualizacao(int num) {
		 System.out.println(num);
	}
	
	

}
