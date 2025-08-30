package chain.of.responsibilities.aplicacao;

public abstract class Processador {
    
    protected Processador nextProcessor; // referência para o próximo da cadeia

    public Processador(Processador nextProcessor) {
        this.nextProcessor = nextProcessor; // injeta a dependência (próximo processador)
    }

    public void processo(Numero requisicao) {
        if (nextProcessor != null) {
            nextProcessor.processo(requisicao); // delega para o próximo, se existir
        }
    }
}
