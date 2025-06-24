package refatoracao.estudos.solid.dependency.inversion.principle;

// EXEMPLO INCORRETO QUE NAO SEGUE OS PRINCIPIOS DA DIP DE IMPLEMENTAR UMA INTERFACE OU CLASSE ABSTRATA

/*
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

}*/


// EXEMPLO CORRETO QUE UTILIZA DIP

public class Prateleira {
	
	 private final Produto produto;

	    public Prateleira(Produto produto) {
	        this.produto = produto;
	    }

	    public void addLivro() {
	        System.out.println("Publicação adicionada à prateleira.");
	    }

	    public void customizarComentarios() {
	    	produto.comentario(); // agora é uma abstração
	        System.out.println("Comentários personalizados.");
	    }
	
	
}


