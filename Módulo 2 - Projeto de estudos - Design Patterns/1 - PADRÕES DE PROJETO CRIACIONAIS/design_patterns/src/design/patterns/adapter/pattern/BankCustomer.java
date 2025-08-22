package design.patterns.adapter.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {

	@Override
	public void fornecaDadosBancarios() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Digite o nome do titular da conta: ");
			String customername = br.readLine();
			System.out.print("\n");

			System.out.print("Digite o número da conta:");
			long accn = Long.parseLong(br.readLine());
			System.out.print("\n");

			System.out.print("Digite o nome do banco: ");
			String bankname = br.readLine();

			setAccHolderName(customername);
			setAccNumber(accn);
			setBankName(bankname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCreditCard() {
		return "Cartão de crédito fornecido com os seguintes dados:\n" + "Titular: " + getAccHolderName() + "\n"
				+ "Banco: " + getBankName() + "\n" + "Conta: " + getAccNumber();
	}

}
