package refatoracao.estudos.solid.dependency.inversion.principle;

public class Livro implements Produto {
	
	   public void comentarioLivro() {
	        System.out.println("Comentando sobre o livro...");
	    }

	    public void paginaInicialLivro() {
	        System.out.println("Abrindo a primeira página...");
	    }

		@Override
		public void comentario() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void amostra() {
			// TODO Auto-generated method stub
			
		}

}
