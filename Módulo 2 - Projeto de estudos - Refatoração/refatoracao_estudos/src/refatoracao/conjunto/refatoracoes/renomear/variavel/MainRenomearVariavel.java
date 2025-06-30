package refatoracao.conjunto.refatoracoes.renomear.variavel;

public class MainRenomearVariavel {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa();
		
		p1.setIdade(90);
		p1.setNome("Marcelo");
		
		
		System.out.println("Nome: " + p1.getNome() + "\nIdade: " + p1.getIdade());

	}
	
	

}
