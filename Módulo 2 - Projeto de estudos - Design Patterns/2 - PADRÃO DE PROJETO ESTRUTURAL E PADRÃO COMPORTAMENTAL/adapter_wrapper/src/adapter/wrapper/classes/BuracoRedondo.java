package adapter.wrapper.classes;

public class BuracoRedondo {
	
	private int raio;
	
	public BuracoRedondo(int raio) {
		this.raio = raio;
		System.out.println("Buraco Redondo: O quadrado máximo é " + raio * Math.sqrt(2));
	}
	
	public int getRaio() {
		return raio;
	}

}
