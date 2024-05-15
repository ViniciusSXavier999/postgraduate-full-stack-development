package application;


/*ESSA CLASSE HERDA DA CLASSE LINGUAGEM, ENTAO AUTOMATICAMENTE MÉTODOS E ATRIBUTOS
 * QUE ESTÃO NA CLASSE MAE SERAO HERDADES NA CLASSE FILHO.
 * MASSSSSSSSSSSSSSSS EU NÃO QUERO QUE MOSTRA NA TELA "LINGUA PORTUGUESA" QUE É O QUE O MÉTODO
 * DA CLASSE MÃE FAZ! 
 * */

public class Aula03POO_Sobrescrita_ClasseJava extends Aula03POO_Sobrescrita_ClasseLinguagem {
	
	@Override
	public void mostrarInformacao() {
		System.out.println("Linguagem Java");
	}

}
