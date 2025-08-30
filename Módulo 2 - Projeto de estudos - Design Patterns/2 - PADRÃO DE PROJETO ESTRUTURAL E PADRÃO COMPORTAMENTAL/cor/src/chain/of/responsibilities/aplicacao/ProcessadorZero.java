package chain.of.responsibilities.aplicacao;

public class ProcessadorZero extends Processador{
	
	public ProcessadorZero(Processador nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void processo(Numero requisicao) {
		
		if(requisicao.getNumero() == 0) {
			
			System.out.println("Processador zero:" + requisicao.getNumero() );
			
		}
		
		else {
			super.processo(requisicao);
		}
		
	}

}
