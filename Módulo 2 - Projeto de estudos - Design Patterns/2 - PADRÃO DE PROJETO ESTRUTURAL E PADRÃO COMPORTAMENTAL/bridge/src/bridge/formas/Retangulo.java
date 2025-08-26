package bridge.formas;

import bridge.cores.Cor;

public class Retangulo extends Forma {

	public Retangulo(Cor cor) {
		super(cor);
	}

	@Override
	public void preencher() {
		System.out.println("Retangulho preenchido com a cor: ");
		cor.preencherCor();
		
	}
	
}
