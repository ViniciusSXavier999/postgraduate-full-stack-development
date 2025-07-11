package teste;

public class Cliente {
	
	   public void realizarDeposito(ContaBancaria conta, double valor) {
	        conta.depositar(valor); // cliente envia mensagem para conta
	    }

}
