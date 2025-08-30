package command.application;

// CLASSE DE COMANDO CONCRETO

/* FAZ O PROCESSAMENTO REAL DO COMANDO */
public class VenderEstoque implements Ordem{

	private Estoque abcEstoque;
	
	public VenderEstoque(Estoque abcEstoque) {
		this.abcEstoque = abcEstoque;
	}
	
	@Override
	public void executar() {
		abcEstoque.vender();
	}

}
