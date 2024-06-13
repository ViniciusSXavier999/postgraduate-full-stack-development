package application.program;

import java.util.HashSet;
import java.util.Iterator;

public class MainAula03_HashSet {

	public static void main(String[] args) {
		
		// criando meu hashset
		HashSet<Integer> numeros = new HashSet<>();
		
		numeros.add(2);
		numeros.add(5);
		numeros.add(8);
		
		Iterator<Integer> it = numeros.iterator();
		
		
		// Enquanto tiver um proximo, voce imprime o próximo
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
