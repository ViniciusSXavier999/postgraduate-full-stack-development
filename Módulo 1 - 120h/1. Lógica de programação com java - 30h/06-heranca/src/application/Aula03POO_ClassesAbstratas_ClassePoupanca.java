package application;

public class Aula03POO_ClassesAbstratas_ClassePoupanca extends Aula03POO_ClassesAbstratas_ClasseConta {

	@Override
	public void imprimeExtrato() {
		
		System.out.println("Saldo: " + this.getSaldo());
		
	}

}
