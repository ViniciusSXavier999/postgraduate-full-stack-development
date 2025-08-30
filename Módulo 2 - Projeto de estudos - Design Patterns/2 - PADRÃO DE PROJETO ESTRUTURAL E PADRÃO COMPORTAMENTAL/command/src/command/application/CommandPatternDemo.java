package command.application;

public class CommandPatternDemo {

	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		
		CompreEstoque compreEstoque = new CompreEstoque(estoque);
		VenderEstoque venderEstoque = new VenderEstoque(estoque);
		
		Gerenciador gerenciador = new Gerenciador();
		
		gerenciador.receberPedido(compreEstoque);
		gerenciador.receberPedido(venderEstoque);
		
		gerenciador.fazerPedidos();

	}

}
