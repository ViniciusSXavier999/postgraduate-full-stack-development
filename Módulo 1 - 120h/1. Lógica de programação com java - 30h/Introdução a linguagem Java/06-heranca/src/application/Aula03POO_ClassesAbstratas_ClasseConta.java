package application;

public abstract class  Aula03POO_ClassesAbstratas_ClasseConta {
	
	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public abstract void imprimeExtrato();

}
