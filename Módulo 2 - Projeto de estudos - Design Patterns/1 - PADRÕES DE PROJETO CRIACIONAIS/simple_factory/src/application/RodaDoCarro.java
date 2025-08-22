package application;

public class RodaDoCarro implements Roda{

	public float diametro;
	public float largura;
	
	
	public RodaDoCarro(float diametro, float largura) {
		this.diametro = diametro;
		this.largura = largura;
	}


	public float getDiametro() {
		return diametro;
	}


	public float getLargura() {
		return largura;
	}

	
	
}
