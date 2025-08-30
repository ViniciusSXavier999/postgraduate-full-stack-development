package chain.of.responsibilities.aplicacao;

public class TesteChain {

	public static void main(String[] args) {
		
		Corrente corrente = new Corrente();
		
		corrente.p(new Numero(90));
		corrente.p(new Numero(- 50));
		corrente.p(new Numero(0));
		corrente.p(new Numero(91));
		
		
		// realizando teste de criação de objeto
		corrente.testeFixo();

	}

}
