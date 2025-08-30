package chain.of.responsibilities.aplicacao;

public class Corrente {
	
	Processador pro;
	
	public Corrente() {
		buildCorrente();
	}
	
	private void buildCorrente() {
		pro = new ProcessadorNegativo(new ProcessadorPositivo(new ProcessadorZero(null)));
	}
	
	public void p(Numero requisicao) {
		pro.processo(requisicao);
	}
	
	public void testeFixo() {
		Numero n = new Numero(300);
		System.out.println(n.getNumero());
	}
	

}
