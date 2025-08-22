package design.patterns.adapter.pattern;

public class AdapterPatternDemo {

	public static void main(String[] args) {
	
		CreditCard targetInterface = new BankCustomer();
		
		targetInterface.fornecaDadosBancarios();
		System.out.println(targetInterface.getCreditCard());
	}

}
