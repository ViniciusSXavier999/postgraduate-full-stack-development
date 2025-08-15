package prototype.application;

public class FuncionarioRecord implements Prototype{
	
	private int id;
	private String nome;
	private String endereco;
	private String designacao;
	private double salario;
	
	public FuncionarioRecord() {
		System.out.println(" Registros de funcionários da Oracle Corporation ");
		System.out.println(" ------------------------------------------------- ");
		System.out.println(" Eid " + "\t"+"Enome"+"\t"+"Edesignação"+"\t"+"Esalário"+"\t\t"+"Endereço");
	}

	public FuncionarioRecord(int id, String nome, String endereco, String designacao, double salario) {
		this();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.designacao = designacao;
		this.salario = salario;
	}
	
	
	public void mostrarRecord() {
		
		System.out.println(id + "\t" + nome + "\t" + designacao + "\t" + salario + "\t" + endereco);
		
	}

	@Override
	public FuncionarioRecord getClone() {
	    return new FuncionarioRecord(id, nome, endereco, designacao, salario);
	}


}
