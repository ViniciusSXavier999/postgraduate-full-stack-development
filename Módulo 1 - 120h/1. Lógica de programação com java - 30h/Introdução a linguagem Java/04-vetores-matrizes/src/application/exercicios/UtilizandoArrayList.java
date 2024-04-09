package application.exercicios;

import java.util.ArrayList;

public class UtilizandoArrayList {

	public static void main(String[] args) {
		
		
		// CRIANDO ARRAY LIST
		ArrayList<String> players = new ArrayList<String>();
		
		//ADICIONANDO ELEMENTOS NO ARRAYLIST
		players.add("Kobe bryant");
		players.add("Lebron james");
		players.add("Luka doncic");
		
		// IMPRIMINDO BANDAS
		System.out.println(players);
		
		// SUBSTITUINDO INDEX DOS ELEMENTOS DO ARRAY
		players.add(players.indexOf("Lebron james"), "Curry");
		
		// IMPRIMINDO VALORES ALTERADOS
		System.out.println(players);
		
		// REMOVENDO ELEMENTOS DO ARRAY 
		players.remove("Curry");
		
		// IMPRIMINDO PARA CONFIRMAR A REMOÇÃO
		System.out.println(players);
		
		// LIMPANDO TODOS OS ELEMENTOS DA LISTA 
		players.clear();
		
		// IMPRIMINDO PARA CONFIRMAR QUE OS VALORES DA MINHA LISTA FORAM EXCLUIDOS 
		System.out.println(players);
	

	}

}
