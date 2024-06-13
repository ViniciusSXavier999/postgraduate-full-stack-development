package application.program;

import java.util.TreeSet;

public class MainAula04_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Integer> numeros = new TreeSet<>();
		
		numeros.add(8);
		numeros.add(6);
		numeros.add(9);
		
		// nesse caso ele vai mostrar com colchetes porque eu não interagi diretamente com o iterator
		System.out.println("TreeSet: " + numeros);
		
		// removendo apenas 1 numero
		boolean result = numeros.remove(6);
		System.out.println("Removeu? " + result);
		
		// removendo todos dados da lista
		result = numeros.removeAll(numeros);
		System.out.println("TreeSet: " + result);
		
		
	}

}
