package bridge.formas;

import bridge.cores.Cor;

public class Circulo extends Forma {
	
	public Circulo(Cor cor) {
		super(cor);
	}

	@Override
	public void preencher() {
		System.out.println("Circulo preenchido com a cor: ");
		cor.preencherCor();
		
	}

	
	
}
