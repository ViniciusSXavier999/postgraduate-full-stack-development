package abstractt.factory.classes.services;

import abstractt.factory.interfaces.Cor;
import abstractt.factory.interfaces.Forma;

public abstract class AbstractFactory {

	public abstract Cor getCor(String cor);
	
	public abstract Forma getForma(String forma);
	
}
