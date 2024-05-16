package application.program;

import java.util.ArrayList;

public class ProjetoListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> linguagens = new ArrayList<>();
		
		linguagens.add("Java");
		linguagens.add("Csharp");
		linguagens.add("Python");
		linguagens.add("Javascript");
		
		System.out.println("Arraylist: " + linguagens);
		
		// criando um vetor
		String[] arr = new String[linguagens.size()];
		
		// convertendo os dados do array para o vetor de string
		linguagens.toArray(arr);
		
		System.out.println("Array: ");
		
		for(String item: arr) {
			System.out.println(item + " , ");
		}

	}

}
