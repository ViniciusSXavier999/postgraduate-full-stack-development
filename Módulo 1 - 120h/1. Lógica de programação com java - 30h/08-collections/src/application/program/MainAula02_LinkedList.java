package application.program;

import java.util.LinkedList;

public class MainAula02_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> animais = new LinkedList<>();
		
		// A minha lista terá 3 animais
		
		animais.add("Cachorro");
		animais.add("Cavalo");
		animais.add("Vaca");
		
		System.out.println("LinkedList: " + animais);
		
		// Adicionando colocando o INDICE
		
		animais.add(1, "Gato");
		System.out.println("LinkedList: " + animais);

	}

}
