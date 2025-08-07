package abstractt.factory.produtor;

import abstractt.factory.classes.services.AbstractFactory;
import abstractt.factory.classes.services.CorFactory;
import abstractt.factory.classes.services.FormaFactory;

public class FactoryProdutor {
	
	public static AbstractFactory getFactory (String escolha) {
		
		if(escolha.equalsIgnoreCase("FORMA")) {
			return new FormaFactory();
			
		} else if (escolha.equalsIgnoreCase("COR")) {
			return new CorFactory();
		}
		
		return null;
	}

}
