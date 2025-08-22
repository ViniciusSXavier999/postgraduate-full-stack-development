package adapter.wrapper.classes;

public class QuadradoAdapter {
	
	private Quadrado quadrado;
	
	public QuadradoAdapter (double w) {
		quadrado = new Quadrado(w);
	}
	
	public void fazerAjuste(BuracoRedondo buracoRedondo) {
		double quantia = quadrado.getLargura() - buracoRedondo.getRaio() * Math.sqrt(2);
		System.out.println(" Reduzindo quadrado:  " + quadrado.getLargura() + " por " + ((quantia < 0) ? 0 : quantia ) + " quantia ");
		
		if (quantia > 0) {
			quadrado.setLargura(quadrado.getLargura() - quantia);
			System.out.println(" A nova largura é: " + quadrado.getLargura());
		}
	}

}
