package refatoracao.estudos.solid.dependency.inversion.principle;

public class Prateleira {
	
	 	Livro livro;

	 	// INJEÇÃO DE DEPENDENCIA VIA CONSTRUTOR
	    public Prateleira(Livro livro) {
	        this.livro = livro;
	    }
	    
	    

	    public void addLivro() {
	        System.out.println("Livro adicionado à prateleira.");
	    }

	    public void customizarComentarios() {
	        livro.comentarioLivro();
	        System.out.println("Comentários personalizados.");
	    }

}
