package command.application;

// Classe de comando concreto
public class CompreEstoque implements Ordem {

	private Estoque abcEstoque;
	
	public CompreEstoque(Estoque abcEstoque) {
		this.abcEstoque = abcEstoque;
	}
	
	@Override
	public void executar() {
		abcEstoque.comprar();
	}
	
	

}
