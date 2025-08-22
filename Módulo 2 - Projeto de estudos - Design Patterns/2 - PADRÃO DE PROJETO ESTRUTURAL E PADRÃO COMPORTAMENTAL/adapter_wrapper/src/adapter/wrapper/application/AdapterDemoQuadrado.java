package adapter.wrapper.application;

import adapter.wrapper.classes.BuracoRedondo;
import adapter.wrapper.classes.QuadradoAdapter;

public class AdapterDemoQuadrado {

	public static void main(String[] args) {
	
		BuracoRedondo buracoRedondo = new BuracoRedondo(5);
		
		QuadradoAdapter quadradoAdapter;
		
		for (int i = 6; i < 10; i++) {
			quadradoAdapter = new QuadradoAdapter((double) i);
			
			// o cliente usa a nova interface
			quadradoAdapter.fazerAjuste(buracoRedondo);
		}

	}

}
