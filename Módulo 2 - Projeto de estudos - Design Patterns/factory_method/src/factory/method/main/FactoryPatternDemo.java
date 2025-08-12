package factory.method.main;

import factory.method.formas.Forma;
import factory.method.formas.FormaFactory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		
		FormaFactory formaFactory = new FormaFactory();
		
		Forma forma1 = formaFactory.buscarForma("CIRCULO");
		forma1.desenhar();
		
		Forma forma2 = formaFactory.buscarForma("QUADRADO");
		forma2.desenhar();
		
		Forma forma3 = formaFactory.buscarForma("RETÂNGULO");
		forma3.desenhar();
		

	}

}
