package factory.method.formas;

public class FormaFactory {
	
	public Forma buscarForma(String formaTipo) {
		
		if (formaTipo == null) {
			return null;
		}
		
		if (formaTipo.equalsIgnoreCase("CIRCULO")) {
			return new Circulo();
		}
		
		else if (formaTipo.equalsIgnoreCase("RETÂNGULO")) {
			return new Retangulo();
		}
		
		else if (formaTipo.equalsIgnoreCase("QUADRADO")) {
			return new Quadrado();
		}
		
		return null;
	}

}
