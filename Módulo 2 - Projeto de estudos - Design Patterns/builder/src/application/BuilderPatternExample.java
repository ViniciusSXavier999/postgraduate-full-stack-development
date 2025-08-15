package application;

public class BuilderPatternExample {

	public static void main(String[] args) {
		
		Bolo bolo1 = new Bolo.Builder()
				.acucar(2)
				.manteiga(0.5)
				.ovos(10)
				.baunilha(9)
				.farinha(0.3)
				.fermentoEmPo(0.7)
				.leite(0.76)
				.cereja(99)
				.build();
		
		System.out.println(bolo1);

	}

}
