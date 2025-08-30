package command.application;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
	
	private List<Ordem> ordemList = new ArrayList<Ordem>();
	
	public void receberPedido(Ordem ordem) {
		ordemList.add(ordem);
	}
	
	public void fazerPedidos() {
		for (Ordem o : ordemList) {
			o.executar();
		}
		
		ordemList.clear();
	}

}
