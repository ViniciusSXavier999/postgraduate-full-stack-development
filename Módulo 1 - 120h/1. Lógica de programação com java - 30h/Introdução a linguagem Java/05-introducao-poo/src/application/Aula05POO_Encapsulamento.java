package application;

public class Aula05POO_Encapsulamento {
	
	private String nome;

	// MÉTODO QUE FARÁ EU ALTERAR LÁ DA CLASSE PRINCIPAL O VALOR DO MEU ATRIBUTO NOME
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// MÉTODO ACESSOR QUE BUSCA A INFORMAÇÃO DO ATRIBUTO DO MEU OBJETO
	
	/*Eu não passo parametros porque eu não estou passando dados.*/
	public String getNome() {
		return nome;
	}
	
	
}
