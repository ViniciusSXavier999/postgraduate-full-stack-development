package application;

public class Aula04POO_Interface_ClassePoupanca implements Aula04POO_Interface_InterfaceConta {
	
	private double saldo;

	
	/* Para depositar eu vou passar um valor por parametro para o usuario inserir 
	 * 
	 * Em seguida vou pegar o saldo da minha conta + ele mesmo e somar com o valor depositado.*/
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;		
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}
	
	

}
