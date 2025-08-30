package chain.of.responsibilities.aplicacao;

public class ProcessadorNegativo extends Processador {
	
	public ProcessadorNegativo(Processador nextProcessador) {
		super(nextProcessador);
	}
	
	@Override
	public void processo (Numero requisicao) {
		if (requisicao.getNumero() < 0) {
			System.out.println("Processo negativo: " + requisicao.getNumero());
		}
		
		else {
			super.processo(requisicao);
		}
	}

}
