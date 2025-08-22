package abstractt.factory.main;

import abstractt.factory.classes.services.AbstractFactory;
import abstractt.factory.classes.services.FormaFactory;
import abstractt.factory.interfaces.Cor;
import abstractt.factory.interfaces.Forma;
import abstractt.factory.produtor.FactoryProdutor;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		
		AbstractFactory forma = FactoryProdutor.getFactory("FORMA");
		
		Forma forma1 = forma.getForma("CIRCULO");
		forma1.desenhar();
		
		Forma forma2 = forma.getForma("QUADRADO");
		forma2.desenhar();
		
		
		AbstractFactory cor = FactoryProdutor.getFactory("cor");
		
		Cor cor1 = cor.getCor("VERMELHO");
		cor1.preencher();
	}

}
