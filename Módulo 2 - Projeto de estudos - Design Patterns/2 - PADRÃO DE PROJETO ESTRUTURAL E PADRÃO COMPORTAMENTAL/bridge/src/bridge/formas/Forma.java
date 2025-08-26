package bridge.formas;

import bridge.cores.Cor;

public abstract class Forma { 
	
	public Cor cor;
	
	public Forma(Cor cor) {
		this.cor= cor;	}
	
	abstract public void preencher();

}
