package refatoracao.estudos.solid.liskov.substitution.principle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bicicleta b = new Bicicleta();
		Transporte t = new Transporte();
		
		System.out.println(b.vaiNaMarra());
		System.out.println(t.vaiNaMarra());

	}

}
