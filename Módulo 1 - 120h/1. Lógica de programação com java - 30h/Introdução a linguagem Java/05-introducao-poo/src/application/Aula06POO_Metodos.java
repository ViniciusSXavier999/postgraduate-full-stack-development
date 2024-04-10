package application;

public class Aula06POO_Metodos {
	
	private int idade;
	
	// INSIRO VALOR
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	// RECEBO O VALOR
	public int getIdade() {
		return idade;
	}
	
	public void Andar() {
		System.out.println("EStou andando...");
	}
	
	public boolean VerificarIdade() {
		if(idade > 18)
			return true;
			else
				return false;
	}

}
