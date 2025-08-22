package prototype.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrototypeDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print(" Digite o ID do funcionário: ");
		int eid = Integer.parseInt(br.readLine());
		System.out.print("\n");

		System.out.print(" Digite o nome do funcionário: ");
		String enome = br.readLine();
		System.out.print("\n");

		System.out.print(" Digite o endereço do funcionário:  ");
		String eendereco = br.readLine();
		System.out.print("\n");

		System.out.print(" Digite o cargo do funcionário: ");
		String edesignacao = br.readLine();
		System.out.print("\n");

		System.out.print(" Digite o salário do funcionário: ");
		double esalario = Double.parseDouble(br.readLine());
		System.out.print("\n");

		FuncionarioRecord f1 = new FuncionarioRecord(eid, enome, eendereco, edesignacao, esalario);

		// MOSTRANDO OS DADOS QUE FORAM PASSADOS PELO CLIENTE
		f1.mostrarRecord();
		System.out.print("\n");

		FuncionarioRecord f2 = f1.getClone();

		f2.mostrarRecord();

	}

}
