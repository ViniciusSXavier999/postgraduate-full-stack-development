package refatoracao.conjunto.refatoracoes.encapsular.variaveis;

public class Area {
	
	int comprimento, largura;
	
	Area (int comprimento, int largura) {
		this.comprimento = comprimento;
		this.largura = largura;
	}

	public void getArea() {
		int area = comprimento * largura;
		System.out.println("Area: " + area);
	}
	
}
