package refatoracao.estudos.maus.cheiros.no.codigo;

public class ListaLongaParametros {

	public static void main(String[] args) {
	
		/*
		Email(true, false, "teste@outlook.com", null);
		*/
		
		EmailCadastroListaLongaParametros Email = new EmailCadastroListaLongaParametros();
		
		Email.param1 = false;
		Email.param2 = false;
		Email.param3 = true;
		Email.email = "vinisim999@gmail.com";
		
		System.out.println(Email.getParam1());
	}
	
	/*
	public static void Email(boolean b, boolean c, String string, Object object) {
		System.out.println("1. " + b + "\n" +
						   "2. " + c + "\n" +
						   "string" + string + "\n" +
						   "object" + object + "\n"
				);
	} */

}
