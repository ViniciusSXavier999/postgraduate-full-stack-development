package application;

public class RodaFactory {
	
	public static Roda fazerRoda(float diametro, float largura) {
		return new RodaDoCarro(diametro, largura);
	}

}
