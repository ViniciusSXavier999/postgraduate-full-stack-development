package application.program;

import application.Aula01POO_Heranca_ClassePessoa;
import application.Aula01POO_Heranca_ClasseVendedor;

public class MainAula01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aula01POO_Heranca_ClassePessoa p = new Aula01POO_Heranca_ClassePessoa();
		
		p.setNome("Vinicius");
		
		/*
		 *  p não pode receber "comissao" pois "comissao" pertence a classe que extends pessoa que é 
		 *  vendedor
		 *  
		 *  p.comissao -> ERRO ERRO ERRO ERRO
		 * 
		 * */
		
		Aula01POO_Heranca_ClasseVendedor v = new Aula01POO_Heranca_ClasseVendedor();
		
		v.setNome("Consigo settar esse atributo pois estou herdando da Classe Pessoa");
		v.setComissao(8.9);
		

	}

}
