package abstractt.factory.classes.services;

import abstractt.factory.classes.formas.Circulo;
import abstractt.factory.classes.formas.Quadrado;
import abstractt.factory.classes.formas.Retangulo;
import abstractt.factory.interfaces.Cor;
import abstractt.factory.interfaces.Forma;

public class FormaFactory extends AbstractFactory {

	@Override
	public Cor getCor(String cor) {
		return null;
	}

	@Override
	public Forma getForma(String forma) {
		
		
		if(forma == null) {
			return null;
		}
		
		if(forma.equalsIgnoreCase("CIRCULO")) {
			return new Circulo();
			
		} else if(forma.equalsIgnoreCase("RETANGULO")) {
			return new Retangulo();
			
		} else if(forma.equalsIgnoreCase("QUADRADO")) {
			return new Quadrado();
			
		}
		
		else {
			return null;
		}
		
	}
	


}
