package application;

public class Aula02POO_Composicao_ClassePedido {
	
	/* Esse meu pedido vai ter itens, por isso vou declarar uma variavel do TIPO ITENS
	 * 
	 *  Mas eu não tenho o objeto ainda, NA COMPOSIÇÃO UM OBJETO TEM O OUTRO OBJETO.
	 *  
	 *  POR ISSO EU VOU INICIALIZAR UM OBJETO ATRAVÉS DO MÉTODO CONSTRUTOR*/
	private Aula02POO_Composicao_ClasseItens item = new Aula02POO_Composicao_ClasseItens("Azul");
	
	
	/* Vou inicializar o objeto pedido, automaticamente quando alguem instanciar um objeto PEDIDO ele 
	 * terá que ter um item  */
	
	public Aula02POO_Composicao_ClassePedido() {
		
	}

	/*Estou pegando o objeto item e instanciando ele, ou seja, um objeto dentro de outro objeto
	 * essa é a composição.*/
	

	public Aula02POO_Composicao_ClassePedido(Aula02POO_Composicao_ClasseItens item) {
		this.item = item;
	}

	public Aula02POO_Composicao_ClasseItens getItem() {
		return item;
	}

	public void setItem(Aula02POO_Composicao_ClasseItens item) {
		this.item = item;
	}
	
	

	
	
	
	
	
	

}
