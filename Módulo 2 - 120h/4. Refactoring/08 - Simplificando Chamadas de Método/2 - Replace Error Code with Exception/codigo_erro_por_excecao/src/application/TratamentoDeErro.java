package application;

public class TratamentoDeErro {
	
	public static void test(int i ) {
		if(i == 0) {
			return;
		} else {
			System.out.println("Quantidade de execuções " + i++);
		}
	}

}
