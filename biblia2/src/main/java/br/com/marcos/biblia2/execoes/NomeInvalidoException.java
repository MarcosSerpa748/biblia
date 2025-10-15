package br.com.marcos.biblia2.execoes;

public class NomeInvalidoException extends RuntimeException {
    private String mensagem;

    public NomeInvalidoException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
