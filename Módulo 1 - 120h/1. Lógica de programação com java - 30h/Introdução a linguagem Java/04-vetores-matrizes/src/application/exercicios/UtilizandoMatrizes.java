package application.exercicios;

public class UtilizandoMatrizes {

	public static void main(String[] args) {
	
		/*CONSIDERE QUE VOCÊ TEM A MATRIZ AO LADO.       
		 * 													1 2 3 
		 *                                               |--------
		 *                                              1 | 9 8 7
		 *                                              2 | 5 3 2 
		 *                                              3 | 6 6 7
		 **/

		/*
		 * Neste exemplo, vamos encontrar o ponto de sela de uma matriz quadratica nxn como esta.
		 * 
		 * O ponto de sela é:
		 * 
		 * O maior elemento em uma linha
		 * O menor elemento em uma coluna
		 * 
		 * */
		
		int [][] matriz = {{9, 8, 7}, {5, 3, 2}, {6, 6, 7}};
		
		// AGORA VAMOS CRIAR DOIS VETORES
		
		/* 1 -> PARA ENCONTRAR O MAIOR ELEMENTO NA LINHA 
		 * 
		 * 2 -> PARA ENCONTRAR O MENOR ELEMENTO NA COLUNA
		*/
		
		
		int[] maiorLinha = new int[3];
		int[] menorColuna = new int[3];
		
		for(int i=0; i<3; i++) 
			maiorLinha[i] = 0;
		
		for(int i=0; i<3; i++)
			menorColuna[i] = 10;
		
		// -------------------------------- //
		
		// MAIOR ELEMENTO NA LINHA 0
		for(int i=0; i<3; i++) {
			if(matriz[0][i] > maiorLinha[0])
				maiorLinha[0] = matriz[0][i];
		}
		
		// MAIOR ELEMENTO NA LINHA 1
		for(int i=0; i<3; i++) {
			if(matriz[1][i] > maiorLinha[1])
				maiorLinha[1] = matriz[1][i];
		}
			
		// MAIOR ELEMENTO NA LINHA 2
		for(int i=0; i<3; i++) {
			if(matriz[2][i] > maiorLinha[1])
				maiorLinha[2] = matriz[2][i];
		}
		
		
		// MENOR ELEMENTO NA COLUNA 0
		for(int i=0; i<3; i++)
			if(matriz[i][0] < menorColuna[0])
				menorColuna[0] = matriz[i][0];
		
	
	// MENOR ELEMENTO NA COLUNA 1
			for(int i=0; i<3; i++)
				if(matriz[i][1] < menorColuna[1])
					menorColuna[1] = matriz[i][1];
	
			
			// MENOR ELEMENTO NA COLUNA 2 
			for(int i=0; i<3; i++)
				if(matriz[i][2] < menorColuna[2])
					menorColuna[2] = matriz[i][2];
		
			
			
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					if(maiorLinha[i] == menorColuna[j]) {
						System.out.println("Ponto de sela: " + maiorLinha[i]);
					}
			
		}			
			
	}

