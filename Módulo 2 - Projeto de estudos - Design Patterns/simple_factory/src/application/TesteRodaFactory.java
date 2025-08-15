package application;

public class TesteRodaFactory {

	public static void main(String[] args) {
		
		Roda r1 = RodaFactory.fazerRoda(50, 80);
		
		System.out.println(r1.getDiametro());
		System.out.println(r1.getLargura());
	}

}
