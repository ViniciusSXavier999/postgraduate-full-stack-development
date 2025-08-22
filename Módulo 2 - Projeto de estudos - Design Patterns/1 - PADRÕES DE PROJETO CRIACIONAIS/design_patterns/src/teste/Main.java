package teste;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	       // Aqui é onde acontece a instanciação dos objetos
        ContaBancaria conta = new ContaBancaria(); // ← new = criação do objeto
        Cliente cliente = new Cliente();           // ← new também aqui

        cliente.realizarDeposito(conta, 300.0);    // passa o objeto como parâmetro

        System.out.println("Saldo atual: R$ " + conta.consultarSaldo());

	}

}
