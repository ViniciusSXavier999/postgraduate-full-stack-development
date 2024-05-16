package application.program;

// AULA SOBRE MÉTODO TO STRING

public class MainAula04_ToString {

	public static void main(String[] args) {
	
		String primeira = "Java";
		String segunda = "Csharp";
		
		/*Já que string é um objeto, podemos declarar um valor a ele dessa forma*/
		String terceira = new String("pyhton");
		
		System.out.println(primeira.toUpperCase());
		System.out.println(segunda.length());
		System.out.println(terceira);
		
		
		// comparar duas strings
		
		boolean result = primeira.equals(segunda);
		System.out.println("Primeira é igual a segunda? " + result);
		
		// comparar segunda com a terceira 
		
		result = segunda.equals(terceira);
		System.out.println("Segunda é igual a terceira? " + result);

	}

}
