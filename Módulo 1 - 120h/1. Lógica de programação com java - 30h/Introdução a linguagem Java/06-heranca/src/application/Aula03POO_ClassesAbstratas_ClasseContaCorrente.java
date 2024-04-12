package application;

public class Aula03POO_ClassesAbstratas_ClasseContaCorrente extends Aula03POO_ClassesAbstratas_ClasseConta{

	@Override
	public void imprimeExtrato() {
		
		System.out.println("Saldo em conta corrente: " + this.getSaldo());
		
	}
	
	
	

}
