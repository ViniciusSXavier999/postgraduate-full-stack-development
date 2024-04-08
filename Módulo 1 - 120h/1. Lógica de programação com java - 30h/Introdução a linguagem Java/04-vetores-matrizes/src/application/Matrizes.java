package application;

public class Matrizes {

	public static void main(String[] args) {
		
		int [][] bi = new int [3][3];
		
		/*
		 * 
		 * INICIALIZAÇÃO MANUAL: DA MAIS TRABALHO
		 * 
		bi[0][0] = 1;
		bi[0][1] = 2;
		bi[0][2] = 3;
		*/
		
		int z = 0;
		
		for(int i=0; i<3; i++) {
			
			for(int j=0; j<3; j++) {
				bi[i][j] = j;
				System.out.println(j);
			}
		}
		
		// -------------------------------- //
		
		
		
		
	}
}
