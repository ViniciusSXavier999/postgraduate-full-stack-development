package chain.of.responsibilities.aplicacao;

public class ProcessadorPositivo extends Processador {
	
	public ProcessadorPositivo(Processador nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void processo(Numero requisicao) {
		if (requisicao.getNumero() > 0) {
			System.out.println("Processador positivo: " + requisicao.getNumero());
		}
		
		else {
			super.processo(requisicao);
		}
	}

}
