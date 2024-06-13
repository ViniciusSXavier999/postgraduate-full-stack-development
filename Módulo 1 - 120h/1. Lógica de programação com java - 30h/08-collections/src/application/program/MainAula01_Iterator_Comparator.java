package application.program;

import java.util.ArrayList;
import java.util.Iterator;

public class MainAula01_Iterator_Comparator {

	public static void main(String[] args) {
		
		/* Dentro do <> eu coloco o tipo que será a minha lista */
		
		ArrayList<Integer> numeros = new ArrayList<>();
		
		// adicionando valores
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		
		
		System.out.println("ArrayList: " + numeros);
		
		/* percorrendo lista com laço for
		 * 
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
		*/
		
		// CRIANDO UMA INSTANCIA DE ITERATOR (um objeto)
		Iterator<Integer> it = numeros.iterator();
		
		// buscando o proximo valor do meu itarator criado acima
		int num = it.next();
		
		System.out.println("Elemento: " + num);
		
		while(it.hasNext()) {
			it.forEachRemaining((value) -> System.out.println(value + ","));
		}
		
		
		
	}

}
