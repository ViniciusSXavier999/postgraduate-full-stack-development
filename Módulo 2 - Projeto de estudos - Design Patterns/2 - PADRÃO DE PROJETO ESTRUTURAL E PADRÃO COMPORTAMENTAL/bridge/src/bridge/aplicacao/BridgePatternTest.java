package bridge.aplicacao;

import bridge.cores.Azul;
import bridge.formas.Circulo;
import bridge.formas.Forma;
import bridge.formas.Retangulo;

public class BridgePatternTest {

	public static void main(String[] args) {
		
		Forma bola = new Circulo(new Azul());
		bola.preencher();
		
		Forma retangulo = new Retangulo(new Azul());
		retangulo.preencher();
		

	}

}
