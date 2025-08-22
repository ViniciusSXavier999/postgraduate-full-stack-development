package teste;

public class ContaBancaria {
	
	 private double saldo; // dado encapsulado

	    public void depositar(double valor) { // operação
	        saldo += valor;
	    }

	    public double consultarSaldo() { // operação
	        return saldo;
	    }

}
