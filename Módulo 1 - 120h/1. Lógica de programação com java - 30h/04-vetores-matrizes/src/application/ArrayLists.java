package application;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {
		
		/*Esse new serve apenas para gente criar o objeto na memória*/
		
		ArrayList<String> estados = new ArrayList<>();
		
		
		// ADICIONANDO ELEMENTOS AO ARRAY
		
		estados.add("São paulo");
		estados.add("Rio de janeiro");
		
		System.out.println(estados.get(1));
		
		// REMOVENDO ELEMENTOS DO ARRAY
		
		estados.remove(1);
		System.out.println(estados);
		
		// VERIFICANDO SE EXISTE TAL INFORMAÇÃO NO ARRAY
		System.out.println(estados.contains("São paulo"));
		

	}

}
