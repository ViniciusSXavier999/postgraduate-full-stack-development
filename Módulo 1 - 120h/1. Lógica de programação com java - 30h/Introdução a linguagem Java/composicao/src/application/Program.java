package application;

import entities.ItemDoPedido;
import entities.Produto;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Produto p = new Produto();
		
		p.setNome("Carro");
		
		ItemDoPedido item = new ItemDoPedido(1, 2000.0, p );
		
		
		System.out.println(item.getProduto().getNome());

	}

}
