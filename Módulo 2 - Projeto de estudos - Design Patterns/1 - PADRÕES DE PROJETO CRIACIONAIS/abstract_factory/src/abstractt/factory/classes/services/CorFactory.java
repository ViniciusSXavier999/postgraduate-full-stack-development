package abstractt.factory.classes.services;

import abstractt.factory.classes.cores.Azul;
import abstractt.factory.classes.cores.Verde;
import abstractt.factory.classes.cores.Vermelho;
import abstractt.factory.classes.formas.Quadrado;
import abstractt.factory.classes.formas.Retangulo;
import abstractt.factory.interfaces.Cor;
import abstractt.factory.interfaces.Forma;

public class CorFactory extends AbstractFactory{

	@Override
	public Cor getCor(String cor) {

		if(cor == null) {
			return null;
		}
		
		if(cor.equalsIgnoreCase("VERMELHO")) {
			return new Vermelho();
			
		} else if(cor.equalsIgnoreCase("AZUL")) {
			return new Azul();
			
		} else if(cor.equalsIgnoreCase("VERDE")) {
			return new Verde();
			
		}
		
		else {
			return null;
		}
		
	}

	@Override
	public Forma getForma(String forma) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
